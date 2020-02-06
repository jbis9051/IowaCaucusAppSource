package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.HedgingPolicy;
import io.grpc.internal.RetryPolicy;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

abstract class RetriableStream<ReqT> implements ClientStream {
    /* access modifiers changed from: private */
    public static final Status CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
    @VisibleForTesting
    static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.of("grpc-previous-rpc-attempts", Metadata.ASCII_STRING_MARSHALLER);
    @VisibleForTesting
    static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS = Metadata.Key.of("grpc-retry-pushback-ms", Metadata.ASCII_STRING_MARSHALLER);
    /* access modifiers changed from: private */
    public static Random random = new Random();
    /* access modifiers changed from: private */
    public final Executor callExecutor;
    /* access modifiers changed from: private */
    public final long channelBufferLimit;
    /* access modifiers changed from: private */
    public final ChannelBufferMeter channelBufferUsed;
    private final Metadata headers;
    /* access modifiers changed from: private */
    public HedgingPolicy hedgingPolicy;
    private final HedgingPolicy.Provider hedgingPolicyProvider;
    /* access modifiers changed from: private */
    public boolean isHedging;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public ClientStreamListener masterListener;
    /* access modifiers changed from: private */
    public final MethodDescriptor<ReqT, ?> method;
    /* access modifiers changed from: private */
    public long nextBackoffIntervalNanos;
    /* access modifiers changed from: private */
    public final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final long perRpcBufferLimit;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public long perRpcBufferUsed;
    /* access modifiers changed from: private */
    public RetryPolicy retryPolicy;
    /* access modifiers changed from: private */
    public final RetryPolicy.Provider retryPolicyProvider;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService scheduledExecutorService;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public FutureCanceller scheduledHedging;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public FutureCanceller scheduledRetry;
    /* access modifiers changed from: private */
    public volatile State state = new State(new ArrayList(8), Collections.emptyList(), (Collection<Substream>) null, (Substream) null, false, false, false, 0);
    /* access modifiers changed from: private */
    @Nullable
    public final Throttle throttle;

    /* access modifiers changed from: package-private */
    public abstract ClientStream newSubstream(ClientStreamTracer.Factory factory, Metadata metadata);

    /* access modifiers changed from: package-private */
    public abstract void postCommit();

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    @Nullable
    public abstract Status prestart();

    RetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, Metadata metadata, ChannelBufferMeter channelBufferMeter, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService2, RetryPolicy.Provider provider, HedgingPolicy.Provider provider2, @Nullable Throttle throttle2) {
        this.method = methodDescriptor;
        this.channelBufferUsed = channelBufferMeter;
        this.perRpcBufferLimit = j;
        this.channelBufferLimit = j2;
        this.callExecutor = executor;
        this.scheduledExecutorService = scheduledExecutorService2;
        this.headers = metadata;
        this.retryPolicyProvider = (RetryPolicy.Provider) Preconditions.checkNotNull(provider, "retryPolicyProvider");
        this.hedgingPolicyProvider = (HedgingPolicy.Provider) Preconditions.checkNotNull(provider2, "hedgingPolicyProvider");
        this.throttle = throttle2;
    }

    /* access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public Runnable commit(Substream substream) {
        Future future;
        Future future2;
        synchronized (this.lock) {
            if (this.state.winningSubstream != null) {
                return null;
            }
            Collection<Substream> collection = this.state.drainedSubstreams;
            this.state = this.state.committed(substream);
            this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
            if (this.scheduledRetry != null) {
                Future markCancelled = this.scheduledRetry.markCancelled();
                this.scheduledRetry = null;
                future = markCancelled;
            } else {
                future = null;
            }
            if (this.scheduledHedging != null) {
                Future markCancelled2 = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
                future2 = markCancelled2;
            } else {
                future2 = null;
            }
            1CommitTask r3 = new 1CommitTask(this, collection, substream, future, future2);
            return r3;
        }
    }

    /* access modifiers changed from: private */
    public void commitAndRun(Substream substream) {
        Runnable commit = commit(substream);
        if (commit != null) {
            commit.run();
        }
    }

    /* access modifiers changed from: private */
    public Substream createSubstream(int i) {
        Substream substream = new Substream(i);
        substream.stream = newSubstream(new 1(this, new BufferSizeTracer(this, substream)), updateHeaders(this.headers, i));
        return substream;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Metadata updateHeaders(Metadata metadata, int i) {
        Metadata metadata2 = new Metadata();
        metadata2.merge(metadata);
        if (i > 0) {
            metadata2.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(i));
        }
        return metadata2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        r1 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r1.hasNext() == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r3 = (io.grpc.internal.RetriableStream.BufferEntry) r1.next();
        r4 = r7.state;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        if (r4.winningSubstream == null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006f, code lost:
        if (r4.winningSubstream == r8) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        if (r4.cancelled == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        if (r4.winningSubstream != r8) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007a, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        com.google.common.base.Preconditions.checkState(r0, "substream should be CANCELLED_BECAUSE_COMMITTED already");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0080, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0081, code lost:
        r3.runWith(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0085, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain(io.grpc.internal.RetriableStream.Substream r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = r1
            r1 = 0
        L_0x0004:
            java.lang.Object r3 = r7.lock
            monitor-enter(r3)
            io.grpc.internal.RetriableStream$State r4 = r7.state     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream$Substream r5 = r4.winningSubstream     // Catch:{ all -> 0x0088 }
            if (r5 == 0) goto L_0x001a
            io.grpc.internal.RetriableStream$Substream r5 = r4.winningSubstream     // Catch:{ all -> 0x0088 }
            if (r5 == r8) goto L_0x001a
            monitor-exit(r3)     // Catch:{ all -> 0x0088 }
            io.grpc.internal.ClientStream r8 = r8.stream
            io.grpc.Status r0 = CANCELLED_BECAUSE_COMMITTED
            r8.cancel(r0)
            return
        L_0x001a:
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r5 = r4.buffer     // Catch:{ all -> 0x0088 }
            int r5 = r5.size()     // Catch:{ all -> 0x0088 }
            if (r1 != r5) goto L_0x002a
            io.grpc.internal.RetriableStream$State r8 = r4.substreamDrained(r8)     // Catch:{ all -> 0x0088 }
            r7.state = r8     // Catch:{ all -> 0x0088 }
            monitor-exit(r3)     // Catch:{ all -> 0x0088 }
            return
        L_0x002a:
            boolean r5 = r8.closed     // Catch:{ all -> 0x0088 }
            if (r5 == 0) goto L_0x0030
            monitor-exit(r3)     // Catch:{ all -> 0x0088 }
            return
        L_0x0030:
            int r5 = r1 + 128
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r6 = r4.buffer     // Catch:{ all -> 0x0088 }
            int r6 = r6.size()     // Catch:{ all -> 0x0088 }
            int r5 = java.lang.Math.min(r5, r6)     // Catch:{ all -> 0x0088 }
            if (r2 != 0) goto L_0x004a
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0088 }
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r4 = r4.buffer     // Catch:{ all -> 0x0088 }
            java.util.List r1 = r4.subList(r1, r5)     // Catch:{ all -> 0x0088 }
            r2.<init>(r1)     // Catch:{ all -> 0x0088 }
            goto L_0x0056
        L_0x004a:
            r2.clear()     // Catch:{ all -> 0x0088 }
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r4 = r4.buffer     // Catch:{ all -> 0x0088 }
            java.util.List r1 = r4.subList(r1, r5)     // Catch:{ all -> 0x0088 }
            r2.addAll(r1)     // Catch:{ all -> 0x0088 }
        L_0x0056:
            monitor-exit(r3)     // Catch:{ all -> 0x0088 }
            java.util.Iterator r1 = r2.iterator()
        L_0x005b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0085
            java.lang.Object r3 = r1.next()
            io.grpc.internal.RetriableStream$BufferEntry r3 = (io.grpc.internal.RetriableStream.BufferEntry) r3
            io.grpc.internal.RetriableStream$State r4 = r7.state
            io.grpc.internal.RetriableStream$Substream r6 = r4.winningSubstream
            if (r6 == 0) goto L_0x0072
            io.grpc.internal.RetriableStream$Substream r6 = r4.winningSubstream
            if (r6 == r8) goto L_0x0072
            goto L_0x0085
        L_0x0072:
            boolean r6 = r4.cancelled
            if (r6 == 0) goto L_0x0081
            io.grpc.internal.RetriableStream$Substream r1 = r4.winningSubstream
            if (r1 != r8) goto L_0x007b
            r0 = 1
        L_0x007b:
            java.lang.String r8 = "substream should be CANCELLED_BECAUSE_COMMITTED already"
            com.google.common.base.Preconditions.checkState(r0, r8)
            return
        L_0x0081:
            r3.runWith(r8)
            goto L_0x005b
        L_0x0085:
            r1 = r5
            goto L_0x0004
        L_0x0088:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x008b:
            throw r8
        L_0x008c:
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.drain(io.grpc.internal.RetriableStream$Substream):void");
    }

    public final void start(ClientStreamListener clientStreamListener) {
        this.masterListener = clientStreamListener;
        Status prestart = prestart();
        if (prestart != null) {
            cancel(prestart);
            return;
        }
        synchronized (this.lock) {
            this.state.buffer.add(new 1StartEntry(this));
        }
        boolean z = false;
        Substream createSubstream = createSubstream(0);
        if (this.hedgingPolicy == null) {
            z = true;
        }
        Preconditions.checkState(z, "hedgingPolicy has been initialized unexpectedly");
        this.hedgingPolicy = this.hedgingPolicyProvider.get();
        if (!HedgingPolicy.DEFAULT.equals(this.hedgingPolicy)) {
            this.isHedging = true;
            this.retryPolicy = RetryPolicy.DEFAULT;
            FutureCanceller futureCanceller = null;
            synchronized (this.lock) {
                this.state = this.state.addActiveHedge(createSubstream);
                if (hasPotentialHedging(this.state) && (this.throttle == null || this.throttle.isAboveThreshold())) {
                    futureCanceller = new FutureCanceller(this.lock);
                    this.scheduledHedging = futureCanceller;
                }
            }
            if (futureCanceller != null) {
                futureCanceller.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(this, futureCanceller), this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
            }
        }
        drain(createSubstream);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (r1 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r1.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r2.setFuture(r5.scheduledExecutorService.schedule(new io.grpc.internal.RetriableStream.HedgingRunnable(r5, r2), (long) r6.intValue(), java.util.concurrent.TimeUnit.MILLISECONDS));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushbackHedging(@javax.annotation.Nullable java.lang.Integer r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r6.intValue()
            if (r0 >= 0) goto L_0x000d
            r5.freezeHedging()
            return
        L_0x000d:
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            io.grpc.internal.RetriableStream$FutureCanceller r1 = r5.scheduledHedging     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0016:
            io.grpc.internal.RetriableStream$FutureCanceller r1 = r5.scheduledHedging     // Catch:{ all -> 0x0042 }
            java.util.concurrent.Future r1 = r1.markCancelled()     // Catch:{ all -> 0x0042 }
            io.grpc.internal.RetriableStream$FutureCanceller r2 = new io.grpc.internal.RetriableStream$FutureCanceller     // Catch:{ all -> 0x0042 }
            java.lang.Object r3 = r5.lock     // Catch:{ all -> 0x0042 }
            r2.<init>(r3)     // Catch:{ all -> 0x0042 }
            r5.scheduledHedging = r2     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x002c
            r0 = 0
            r1.cancel(r0)
        L_0x002c:
            java.util.concurrent.ScheduledExecutorService r0 = r5.scheduledExecutorService
            io.grpc.internal.RetriableStream$HedgingRunnable r1 = new io.grpc.internal.RetriableStream$HedgingRunnable
            r1.<init>(r5, r2)
            int r6 = r6.intValue()
            long r3 = (long) r6
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r6 = r0.schedule(r1, r3, r6)
            r2.setFuture(r6)
            return
        L_0x0042:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.pushbackHedging(java.lang.Integer):void");
    }

    public final void cancel(Status status) {
        Substream substream = new Substream(0);
        substream.stream = new NoopClientStream();
        Runnable commit = commit(substream);
        if (commit != null) {
            this.masterListener.closed(status, new Metadata());
            commit.run();
            return;
        }
        this.state.winningSubstream.stream.cancel(status);
        synchronized (this.lock) {
            this.state = this.state.cancelled();
        }
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> collection;
        synchronized (this.lock) {
            if (!this.state.passThrough) {
                this.state.buffer.add(bufferEntry);
            }
            collection = this.state.drainedSubstreams;
        }
        for (Substream runWith : collection) {
            bufferEntry.runWith(runWith);
        }
    }

    public final void writeMessage(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    /* access modifiers changed from: package-private */
    public final void sendMessage(ReqT reqt) {
        State state2 = this.state;
        if (state2.passThrough) {
            state2.winningSubstream.stream.writeMessage(this.method.streamRequest(reqt));
        } else {
            delayOrExecute(new 1SendMessageEntry(this, reqt));
        }
    }

    public final void request(int i) {
        State state2 = this.state;
        if (state2.passThrough) {
            state2.winningSubstream.stream.request(i);
        } else {
            delayOrExecute(new 1RequestEntry(this, i));
        }
    }

    public final void flush() {
        State state2 = this.state;
        if (state2.passThrough) {
            state2.winningSubstream.stream.flush();
        } else {
            delayOrExecute(new 1FlushEntry(this));
        }
    }

    public final boolean isReady() {
        for (Substream substream : this.state.drainedSubstreams) {
            if (substream.stream.isReady()) {
                return true;
            }
        }
        return false;
    }

    public final void setCompressor(Compressor compressor) {
        delayOrExecute(new 1CompressorEntry(this, compressor));
    }

    public final void setFullStreamDecompression(boolean z) {
        delayOrExecute(new 1FullStreamDecompressionEntry(this, z));
    }

    public final void setMessageCompression(boolean z) {
        delayOrExecute(new 1MessageCompressionEntry(this, z));
    }

    public final void halfClose() {
        delayOrExecute(new 1HalfCloseEntry(this));
    }

    public final void setAuthority(String str) {
        delayOrExecute(new 1AuthorityEntry(this, str));
    }

    public final void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new 1DecompressorRegistryEntry(this, decompressorRegistry));
    }

    public final void setMaxInboundMessageSize(int i) {
        delayOrExecute(new 1MaxInboundMessageSizeEntry(this, i));
    }

    public final void setMaxOutboundMessageSize(int i) {
        delayOrExecute(new 1MaxOutboundMessageSizeEntry(this, i));
    }

    public final void setDeadline(Deadline deadline) {
        delayOrExecute(new 1DeadlineEntry(this, deadline));
    }

    public final Attributes getAttributes() {
        if (this.state.winningSubstream != null) {
            return this.state.winningSubstream.stream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    @VisibleForTesting
    static void setRandom(Random random2) {
        random = random2;
    }

    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean hasPotentialHedging(State state2) {
        return state2.winningSubstream == null && state2.hedgingAttemptCount < this.hedgingPolicy.maxAttempts && !state2.hedgingFrozen;
    }

    /* access modifiers changed from: private */
    public void freezeHedging() {
        Future future;
        synchronized (this.lock) {
            if (this.scheduledHedging != null) {
                future = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
            } else {
                future = null;
            }
            this.state = this.state.freezeHedging();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    private static final class State {
        final Collection<Substream> activeHedges;
        @Nullable
        final List<BufferEntry> buffer;
        final boolean cancelled;
        final Collection<Substream> drainedSubstreams;
        final int hedgingAttemptCount;
        final boolean hedgingFrozen;
        final boolean passThrough;
        @Nullable
        final Substream winningSubstream;

        State(@Nullable List<BufferEntry> list, Collection<Substream> collection, Collection<Substream> collection2, @Nullable Substream substream, boolean z, boolean z2, boolean z3, int i) {
            this.buffer = list;
            this.drainedSubstreams = (Collection) Preconditions.checkNotNull(collection, "drainedSubstreams");
            this.winningSubstream = substream;
            this.activeHedges = collection2;
            this.cancelled = z;
            this.passThrough = z2;
            this.hedgingFrozen = z3;
            this.hedgingAttemptCount = i;
            boolean z4 = false;
            Preconditions.checkState(!z2 || list == null, "passThrough should imply buffer is null");
            Preconditions.checkState(!z2 || substream != null, "passThrough should imply winningSubstream != null");
            Preconditions.checkState(!z2 || (collection.size() == 1 && collection.contains(substream)) || (collection.size() == 0 && substream.closed), "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((!z || substream != null) ? true : z4, "cancelled should imply committed");
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State cancelled() {
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, true, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State substreamDrained(Substream substream) {
            Collection unmodifiableCollection;
            List<BufferEntry> list;
            boolean z = true;
            Preconditions.checkState(!this.passThrough, "Already passThrough");
            if (substream.closed) {
                unmodifiableCollection = this.drainedSubstreams;
            } else if (this.drainedSubstreams.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.drainedSubstreams);
                arrayList.add(substream);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            boolean z2 = this.winningSubstream != null;
            List<BufferEntry> list2 = this.buffer;
            if (z2) {
                if (this.winningSubstream != substream) {
                    z = false;
                }
                Preconditions.checkState(z, "Another RPC attempt has already committed");
                list = null;
            } else {
                list = list2;
            }
            return new State(list, collection, this.activeHedges, this.winningSubstream, this.cancelled, z2, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State substreamClosed(Substream substream) {
            substream.closed = true;
            if (!this.drainedSubstreams.contains(substream)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.drainedSubstreams);
            arrayList.remove(substream);
            return new State(this.buffer, Collections.unmodifiableCollection(arrayList), this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State committed(Substream substream) {
            boolean z;
            Set set;
            List<BufferEntry> list;
            Preconditions.checkState(this.winningSubstream == null, "Already committed");
            List<BufferEntry> list2 = this.buffer;
            if (this.drainedSubstreams.contains(substream)) {
                list = null;
                set = Collections.singleton(substream);
                z = true;
            } else {
                list = list2;
                set = Collections.emptyList();
                z = false;
            }
            return new State(list, set, this.activeHedges, substream, this.cancelled, z, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State freezeHedging() {
            if (this.hedgingFrozen) {
                return this;
            }
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, true, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State addActiveHedge(Substream substream) {
            Collection collection;
            Preconditions.checkState(!this.hedgingFrozen, "hedging frozen");
            Preconditions.checkState(this.winningSubstream == null, "already committed");
            Collection<Substream> collection2 = this.activeHedges;
            if (collection2 == null) {
                collection = Collections.singleton(substream);
            } else {
                ArrayList arrayList = new ArrayList(collection2);
                arrayList.add(substream);
                collection = Collections.unmodifiableCollection(arrayList);
            }
            return new State(this.buffer, this.drainedSubstreams, collection, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount + 1);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State removeActiveHedge(Substream substream) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State replaceActiveHedge(Substream substream, Substream substream2) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            arrayList.add(substream2);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }
    }
}
