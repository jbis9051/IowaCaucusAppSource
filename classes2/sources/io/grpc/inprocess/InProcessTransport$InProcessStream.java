package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ServerStream;
import io.grpc.internal.ServerStreamListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.annotation.concurrent.GuardedBy;

class InProcessTransport$InProcessStream {
    /* access modifiers changed from: private */
    public volatile String authority;
    private final CallOptions callOptions;
    /* access modifiers changed from: private */
    public final InProcessClientStream clientStream;
    /* access modifiers changed from: private */
    public final Metadata headers;
    /* access modifiers changed from: private */
    public final MethodDescriptor<?, ?> method;
    /* access modifiers changed from: private */
    public final InProcessServerStream serverStream;
    final /* synthetic */ InProcessTransport this$0;

    /* synthetic */ InProcessTransport$InProcessStream(InProcessTransport inProcessTransport, MethodDescriptor methodDescriptor, Metadata metadata, CallOptions callOptions2, String str, InProcessTransport$1 inProcessTransport$1) {
        this(inProcessTransport, methodDescriptor, metadata, callOptions2, str);
    }

    private InProcessTransport$InProcessStream(InProcessTransport inProcessTransport, MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions2, String str) {
        this.this$0 = inProcessTransport;
        this.method = (MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD);
        this.headers = (Metadata) Preconditions.checkNotNull(metadata, "headers");
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions2, "callOptions");
        this.authority = str;
        this.clientStream = new InProcessClientStream(callOptions2, metadata);
        this.serverStream = new InProcessServerStream(methodDescriptor, metadata);
    }

    /* access modifiers changed from: private */
    public void streamClosed() {
        synchronized (this.this$0) {
            boolean remove = InProcessTransport.access$800(this.this$0).remove(this);
            if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                InProcessTransport.access$900(this.this$0).updateObjectInUse(this, false);
            }
            if (InProcessTransport.access$800(this.this$0).isEmpty() && remove && InProcessTransport.access$1000(this.this$0)) {
                InProcessTransport.access$200(this.this$0);
            }
        }
    }

    private class InProcessServerStream implements ServerStream {
        @GuardedBy("this")
        private Status clientNotifyStatus;
        @GuardedBy("this")
        private Metadata clientNotifyTrailers;
        @GuardedBy("this")
        private ArrayDeque<StreamListener.MessageProducer> clientReceiveQueue = new ArrayDeque<>();
        @GuardedBy("this")
        private int clientRequested;
        @GuardedBy("this")
        private ClientStreamListener clientStreamListener;
        @GuardedBy("this")
        private boolean closed;
        @GuardedBy("this")
        private int outboundSeqNo;
        final StatsTraceContext statsTraceCtx;

        public void flush() {
        }

        public void setCompressor(Compressor compressor) {
        }

        public void setDecompressor(Decompressor decompressor) {
        }

        public void setMessageCompression(boolean z) {
        }

        InProcessServerStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
            this.statsTraceCtx = StatsTraceContext.newServerContext(InProcessTransport.access$1100(InProcessTransport$InProcessStream.this.this$0), methodDescriptor.getFullMethodName(), metadata);
        }

        /* access modifiers changed from: private */
        public synchronized void setListener(ClientStreamListener clientStreamListener2) {
            this.clientStreamListener = clientStreamListener2;
        }

        public void setListener(ServerStreamListener serverStreamListener) {
            InProcessTransport$InProcessStream.this.clientStream.setListener(serverStreamListener);
        }

        public void request(int i) {
            if (InProcessTransport$InProcessStream.this.clientStream.serverRequested(i)) {
                synchronized (this) {
                    if (!this.closed) {
                        this.clientStreamListener.onReady();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean clientRequested(int r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                boolean r0 = r5.closed     // Catch:{ all -> 0x0079 }
                r1 = 0
                if (r0 == 0) goto L_0x0008
                monitor-exit(r5)
                return r1
            L_0x0008:
                int r0 = r5.clientRequested     // Catch:{ all -> 0x0079 }
                r2 = 1
                if (r0 <= 0) goto L_0x000f
                r0 = 1
                goto L_0x0010
            L_0x000f:
                r0 = 0
            L_0x0010:
                int r3 = r5.clientRequested     // Catch:{ all -> 0x0079 }
                int r3 = r3 + r6
                r5.clientRequested = r3     // Catch:{ all -> 0x0079 }
            L_0x0015:
                int r6 = r5.clientRequested     // Catch:{ all -> 0x0079 }
                if (r6 <= 0) goto L_0x0034
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r6 = r5.clientReceiveQueue     // Catch:{ all -> 0x0079 }
                boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0079 }
                if (r6 != 0) goto L_0x0034
                int r6 = r5.clientRequested     // Catch:{ all -> 0x0079 }
                int r6 = r6 - r2
                r5.clientRequested = r6     // Catch:{ all -> 0x0079 }
                io.grpc.internal.ClientStreamListener r6 = r5.clientStreamListener     // Catch:{ all -> 0x0079 }
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r5.clientReceiveQueue     // Catch:{ all -> 0x0079 }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0079 }
                io.grpc.internal.StreamListener$MessageProducer r3 = (io.grpc.internal.StreamListener.MessageProducer) r3     // Catch:{ all -> 0x0079 }
                r6.messagesAvailable(r3)     // Catch:{ all -> 0x0079 }
                goto L_0x0015
            L_0x0034:
                boolean r6 = r5.closed     // Catch:{ all -> 0x0079 }
                if (r6 == 0) goto L_0x003a
                monitor-exit(r5)
                return r1
            L_0x003a:
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r6 = r5.clientReceiveQueue     // Catch:{ all -> 0x0079 }
                boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0079 }
                if (r6 == 0) goto L_0x006b
                io.grpc.Status r6 = r5.clientNotifyStatus     // Catch:{ all -> 0x0079 }
                if (r6 == 0) goto L_0x006b
                r5.closed = r2     // Catch:{ all -> 0x0079 }
                io.grpc.inprocess.InProcessTransport$InProcessStream r6 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x0079 }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r6 = r6.clientStream     // Catch:{ all -> 0x0079 }
                io.grpc.internal.StatsTraceContext r6 = r6.statsTraceCtx     // Catch:{ all -> 0x0079 }
                io.grpc.Metadata r3 = r5.clientNotifyTrailers     // Catch:{ all -> 0x0079 }
                r6.clientInboundTrailers(r3)     // Catch:{ all -> 0x0079 }
                io.grpc.inprocess.InProcessTransport$InProcessStream r6 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x0079 }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r6 = r6.clientStream     // Catch:{ all -> 0x0079 }
                io.grpc.internal.StatsTraceContext r6 = r6.statsTraceCtx     // Catch:{ all -> 0x0079 }
                io.grpc.Status r3 = r5.clientNotifyStatus     // Catch:{ all -> 0x0079 }
                r6.streamClosed(r3)     // Catch:{ all -> 0x0079 }
                io.grpc.internal.ClientStreamListener r6 = r5.clientStreamListener     // Catch:{ all -> 0x0079 }
                io.grpc.Status r3 = r5.clientNotifyStatus     // Catch:{ all -> 0x0079 }
                io.grpc.Metadata r4 = r5.clientNotifyTrailers     // Catch:{ all -> 0x0079 }
                r6.closed(r3, r4)     // Catch:{ all -> 0x0079 }
            L_0x006b:
                int r6 = r5.clientRequested     // Catch:{ all -> 0x0079 }
                if (r6 <= 0) goto L_0x0071
                r6 = 1
                goto L_0x0072
            L_0x0071:
                r6 = 0
            L_0x0072:
                if (r0 != 0) goto L_0x0077
                if (r6 == 0) goto L_0x0077
                r1 = 1
            L_0x0077:
                monitor-exit(r5)
                return r1
            L_0x0079:
                r6 = move-exception
                monitor-exit(r5)
                goto L_0x007d
            L_0x007c:
                throw r6
            L_0x007d:
                goto L_0x007c
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessServerStream.clientRequested(int):boolean");
        }

        /* access modifiers changed from: private */
        public void clientCancelled(Status status) {
            internalCancel(status);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void writeMessage(java.io.InputStream r9) {
            /*
                r8 = this;
                monitor-enter(r8)
                boolean r0 = r8.closed     // Catch:{ all -> 0x005a }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r8)
                return
            L_0x0007:
                io.grpc.internal.StatsTraceContext r0 = r8.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r0.outboundMessage(r1)     // Catch:{ all -> 0x005a }
                io.grpc.internal.StatsTraceContext r2 = r8.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r3 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r4 = -1
                r6 = -1
                r2.outboundMessageSent(r3, r4, r6)     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r0 = r0.clientStream     // Catch:{ all -> 0x005a }
                io.grpc.internal.StatsTraceContext r0 = r0.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r0.inboundMessage(r1)     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r0 = r0.clientStream     // Catch:{ all -> 0x005a }
                io.grpc.internal.StatsTraceContext r1 = r0.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r2 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r3 = -1
                r5 = -1
                r1.inboundMessageRead(r2, r3, r5)     // Catch:{ all -> 0x005a }
                int r0 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                int r0 = r0 + 1
                r8.outboundSeqNo = r0     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$SingleMessageProducer r0 = new io.grpc.inprocess.InProcessTransport$SingleMessageProducer     // Catch:{ all -> 0x005a }
                r1 = 0
                r0.<init>(r9, r1)     // Catch:{ all -> 0x005a }
                int r9 = r8.clientRequested     // Catch:{ all -> 0x005a }
                if (r9 <= 0) goto L_0x0053
                int r9 = r8.clientRequested     // Catch:{ all -> 0x005a }
                int r9 = r9 + -1
                r8.clientRequested = r9     // Catch:{ all -> 0x005a }
                io.grpc.internal.ClientStreamListener r9 = r8.clientStreamListener     // Catch:{ all -> 0x005a }
                r9.messagesAvailable(r0)     // Catch:{ all -> 0x005a }
                goto L_0x0058
            L_0x0053:
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r9 = r8.clientReceiveQueue     // Catch:{ all -> 0x005a }
                r9.add(r0)     // Catch:{ all -> 0x005a }
            L_0x0058:
                monitor-exit(r8)
                return
            L_0x005a:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessServerStream.writeMessage(java.io.InputStream):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x000e, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean isReady() {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.closed     // Catch:{ all -> 0x000f }
                r1 = 0
                if (r0 == 0) goto L_0x0008
                monitor-exit(r2)
                return r1
            L_0x0008:
                int r0 = r2.clientRequested     // Catch:{ all -> 0x000f }
                if (r0 <= 0) goto L_0x000d
                r1 = 1
            L_0x000d:
                monitor-exit(r2)
                return r1
            L_0x000f:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessServerStream.isReady():boolean");
        }

        public void writeHeaders(Metadata metadata) {
            int access$1600;
            if (InProcessTransport.access$1500(InProcessTransport$InProcessStream.this.this$0) == Integer.MAX_VALUE || (access$1600 = InProcessTransport.access$1600(metadata)) <= InProcessTransport.access$1500(InProcessTransport$InProcessStream.this.this$0)) {
                synchronized (this) {
                    if (!this.closed) {
                        InProcessTransport$InProcessStream.this.clientStream.statsTraceCtx.clientInboundHeaders();
                        this.clientStreamListener.headersRead(metadata);
                        return;
                    }
                    return;
                }
            }
            Status withDescription = Status.CANCELLED.withDescription("Client cancelled the RPC");
            InProcessTransport$InProcessStream.this.clientStream.serverClosed(withDescription, withDescription);
            notifyClientClose(Status.RESOURCE_EXHAUSTED.withDescription(String.format("Response header metadata larger than %d: %d", new Object[]{Integer.valueOf(InProcessTransport.access$1500(InProcessTransport$InProcessStream.this.this$0)), Integer.valueOf(access$1600)})), new Metadata());
        }

        public void close(Status status, Metadata metadata) {
            InProcessTransport$InProcessStream.this.clientStream.serverClosed(Status.OK, status);
            if (InProcessTransport.access$1500(InProcessTransport$InProcessStream.this.this$0) != Integer.MAX_VALUE) {
                int access$1600 = InProcessTransport.access$1600(metadata) + (status.getDescription() == null ? 0 : status.getDescription().length());
                if (access$1600 > InProcessTransport.access$1500(InProcessTransport$InProcessStream.this.this$0)) {
                    status = Status.RESOURCE_EXHAUSTED.withDescription(String.format("Response header metadata larger than %d: %d", new Object[]{Integer.valueOf(InProcessTransport.access$1500(InProcessTransport$InProcessStream.this.this$0)), Integer.valueOf(access$1600)}));
                    metadata = new Metadata();
                }
            }
            notifyClientClose(status, metadata);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            io.grpc.inprocess.InProcessTransport$InProcessStream.access$1900(r1.this$1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void notifyClientClose(io.grpc.Status r2, io.grpc.Metadata r3) {
            /*
                r1 = this;
                io.grpc.Status r2 = io.grpc.inprocess.InProcessTransport.access$1800(r2)
                monitor-enter(r1)
                boolean r0 = r1.closed     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x003d }
                return
            L_0x000b:
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r0 = r1.clientReceiveQueue     // Catch:{ all -> 0x003d }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x0032
                r0 = 1
                r1.closed = r0     // Catch:{ all -> 0x003d }
                io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x003d }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r0 = r0.clientStream     // Catch:{ all -> 0x003d }
                io.grpc.internal.StatsTraceContext r0 = r0.statsTraceCtx     // Catch:{ all -> 0x003d }
                r0.clientInboundTrailers(r3)     // Catch:{ all -> 0x003d }
                io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x003d }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r0 = r0.clientStream     // Catch:{ all -> 0x003d }
                io.grpc.internal.StatsTraceContext r0 = r0.statsTraceCtx     // Catch:{ all -> 0x003d }
                r0.streamClosed(r2)     // Catch:{ all -> 0x003d }
                io.grpc.internal.ClientStreamListener r0 = r1.clientStreamListener     // Catch:{ all -> 0x003d }
                r0.closed(r2, r3)     // Catch:{ all -> 0x003d }
                goto L_0x0036
            L_0x0032:
                r1.clientNotifyStatus = r2     // Catch:{ all -> 0x003d }
                r1.clientNotifyTrailers = r3     // Catch:{ all -> 0x003d }
            L_0x0036:
                monitor-exit(r1)     // Catch:{ all -> 0x003d }
                io.grpc.inprocess.InProcessTransport$InProcessStream r2 = io.grpc.inprocess.InProcessTransport$InProcessStream.this
                r2.streamClosed()
                return
            L_0x003d:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x003d }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessServerStream.notifyClientClose(io.grpc.Status, io.grpc.Metadata):void");
        }

        public void cancel(Status status) {
            if (internalCancel(Status.CANCELLED.withDescription("server cancelled stream"))) {
                InProcessTransport$InProcessStream.this.clientStream.serverClosed(status, status);
                InProcessTransport$InProcessStream.this.streamClosed();
            }
        }

        private synchronized boolean internalCancel(Status status) {
            if (this.closed) {
                return false;
            }
            this.closed = true;
            while (true) {
                StreamListener.MessageProducer poll = this.clientReceiveQueue.poll();
                if (poll != null) {
                    while (true) {
                        InputStream next = poll.next();
                        if (next != null) {
                            try {
                                next.close();
                            } catch (Throwable th) {
                                InProcessTransport.access$2000().log(Level.WARNING, "Exception closing stream", th);
                            }
                        }
                    }
                } else {
                    InProcessTransport$InProcessStream.this.clientStream.statsTraceCtx.streamClosed(status);
                    this.clientStreamListener.closed(status, new Metadata());
                    return true;
                }
            }
        }

        public Attributes getAttributes() {
            return InProcessTransport.access$400(InProcessTransport$InProcessStream.this.this$0);
        }

        public String getAuthority() {
            return InProcessTransport$InProcessStream.this.authority;
        }

        public StatsTraceContext statsTraceContext() {
            return this.statsTraceCtx;
        }
    }

    private class InProcessClientStream implements ClientStream {
        final CallOptions callOptions;
        @GuardedBy("this")
        private boolean closed;
        @GuardedBy("this")
        private int outboundSeqNo;
        @GuardedBy("this")
        private boolean serverNotifyHalfClose;
        @GuardedBy("this")
        private ArrayDeque<StreamListener.MessageProducer> serverReceiveQueue = new ArrayDeque<>();
        @GuardedBy("this")
        private int serverRequested;
        @GuardedBy("this")
        private ServerStreamListener serverStreamListener;
        final StatsTraceContext statsTraceCtx;

        public void flush() {
        }

        public void setCompressor(Compressor compressor) {
        }

        public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        }

        public void setFullStreamDecompression(boolean z) {
        }

        public void setMaxInboundMessageSize(int i) {
        }

        public void setMaxOutboundMessageSize(int i) {
        }

        public void setMessageCompression(boolean z) {
        }

        InProcessClientStream(CallOptions callOptions2, Metadata metadata) {
            this.callOptions = callOptions2;
            this.statsTraceCtx = StatsTraceContext.newClientContext(callOptions2, InProcessTransport.access$2200(InProcessTransport$InProcessStream.this.this$0), metadata);
        }

        /* access modifiers changed from: private */
        public synchronized void setListener(ServerStreamListener serverStreamListener2) {
            this.serverStreamListener = serverStreamListener2;
        }

        public void request(int i) {
            if (InProcessTransport$InProcessStream.this.serverStream.clientRequested(i)) {
                synchronized (this) {
                    if (!this.closed) {
                        this.serverStreamListener.onReady();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean serverRequested(int r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r4.closed     // Catch:{ all -> 0x0055 }
                r1 = 0
                if (r0 == 0) goto L_0x0008
                monitor-exit(r4)
                return r1
            L_0x0008:
                int r0 = r4.serverRequested     // Catch:{ all -> 0x0055 }
                r2 = 1
                if (r0 <= 0) goto L_0x000f
                r0 = 1
                goto L_0x0010
            L_0x000f:
                r0 = 0
            L_0x0010:
                int r3 = r4.serverRequested     // Catch:{ all -> 0x0055 }
                int r3 = r3 + r5
                r4.serverRequested = r3     // Catch:{ all -> 0x0055 }
            L_0x0015:
                int r5 = r4.serverRequested     // Catch:{ all -> 0x0055 }
                if (r5 <= 0) goto L_0x0034
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r5 = r4.serverReceiveQueue     // Catch:{ all -> 0x0055 }
                boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0055 }
                if (r5 != 0) goto L_0x0034
                int r5 = r4.serverRequested     // Catch:{ all -> 0x0055 }
                int r5 = r5 - r2
                r4.serverRequested = r5     // Catch:{ all -> 0x0055 }
                io.grpc.internal.ServerStreamListener r5 = r4.serverStreamListener     // Catch:{ all -> 0x0055 }
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r4.serverReceiveQueue     // Catch:{ all -> 0x0055 }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0055 }
                io.grpc.internal.StreamListener$MessageProducer r3 = (io.grpc.internal.StreamListener.MessageProducer) r3     // Catch:{ all -> 0x0055 }
                r5.messagesAvailable(r3)     // Catch:{ all -> 0x0055 }
                goto L_0x0015
            L_0x0034:
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r5 = r4.serverReceiveQueue     // Catch:{ all -> 0x0055 }
                boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0055 }
                if (r5 == 0) goto L_0x0047
                boolean r5 = r4.serverNotifyHalfClose     // Catch:{ all -> 0x0055 }
                if (r5 == 0) goto L_0x0047
                r4.serverNotifyHalfClose = r1     // Catch:{ all -> 0x0055 }
                io.grpc.internal.ServerStreamListener r5 = r4.serverStreamListener     // Catch:{ all -> 0x0055 }
                r5.halfClosed()     // Catch:{ all -> 0x0055 }
            L_0x0047:
                int r5 = r4.serverRequested     // Catch:{ all -> 0x0055 }
                if (r5 <= 0) goto L_0x004d
                r5 = 1
                goto L_0x004e
            L_0x004d:
                r5 = 0
            L_0x004e:
                if (r0 != 0) goto L_0x0053
                if (r5 == 0) goto L_0x0053
                r1 = 1
            L_0x0053:
                monitor-exit(r4)
                return r1
            L_0x0055:
                r5 = move-exception
                monitor-exit(r4)
                goto L_0x0059
            L_0x0058:
                throw r5
            L_0x0059:
                goto L_0x0058
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessClientStream.serverRequested(int):boolean");
        }

        /* access modifiers changed from: private */
        public void serverClosed(Status status, Status status2) {
            internalCancel(status, status2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void writeMessage(java.io.InputStream r9) {
            /*
                r8 = this;
                monitor-enter(r8)
                boolean r0 = r8.closed     // Catch:{ all -> 0x005a }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r8)
                return
            L_0x0007:
                io.grpc.internal.StatsTraceContext r0 = r8.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r0.outboundMessage(r1)     // Catch:{ all -> 0x005a }
                io.grpc.internal.StatsTraceContext r2 = r8.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r3 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r4 = -1
                r6 = -1
                r2.outboundMessageSent(r3, r4, r6)     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream r0 = r0.serverStream     // Catch:{ all -> 0x005a }
                io.grpc.internal.StatsTraceContext r0 = r0.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r0.inboundMessage(r1)     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport$InProcessStream.this     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream r0 = r0.serverStream     // Catch:{ all -> 0x005a }
                io.grpc.internal.StatsTraceContext r1 = r0.statsTraceCtx     // Catch:{ all -> 0x005a }
                int r2 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                r3 = -1
                r5 = -1
                r1.inboundMessageRead(r2, r3, r5)     // Catch:{ all -> 0x005a }
                int r0 = r8.outboundSeqNo     // Catch:{ all -> 0x005a }
                int r0 = r0 + 1
                r8.outboundSeqNo = r0     // Catch:{ all -> 0x005a }
                io.grpc.inprocess.InProcessTransport$SingleMessageProducer r0 = new io.grpc.inprocess.InProcessTransport$SingleMessageProducer     // Catch:{ all -> 0x005a }
                r1 = 0
                r0.<init>(r9, r1)     // Catch:{ all -> 0x005a }
                int r9 = r8.serverRequested     // Catch:{ all -> 0x005a }
                if (r9 <= 0) goto L_0x0053
                int r9 = r8.serverRequested     // Catch:{ all -> 0x005a }
                int r9 = r9 + -1
                r8.serverRequested = r9     // Catch:{ all -> 0x005a }
                io.grpc.internal.ServerStreamListener r9 = r8.serverStreamListener     // Catch:{ all -> 0x005a }
                r9.messagesAvailable(r0)     // Catch:{ all -> 0x005a }
                goto L_0x0058
            L_0x0053:
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r9 = r8.serverReceiveQueue     // Catch:{ all -> 0x005a }
                r9.add(r0)     // Catch:{ all -> 0x005a }
            L_0x0058:
                monitor-exit(r8)
                return
            L_0x005a:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessClientStream.writeMessage(java.io.InputStream):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x000e, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean isReady() {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.closed     // Catch:{ all -> 0x000f }
                r1 = 0
                if (r0 == 0) goto L_0x0008
                monitor-exit(r2)
                return r1
            L_0x0008:
                int r0 = r2.serverRequested     // Catch:{ all -> 0x000f }
                if (r0 <= 0) goto L_0x000d
                r1 = 1
            L_0x000d:
                monitor-exit(r2)
                return r1
            L_0x000f:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessClientStream.isReady():boolean");
        }

        public void cancel(Status status) {
            Status access$1800 = InProcessTransport.access$1800(status);
            if (internalCancel(access$1800, access$1800)) {
                InProcessTransport$InProcessStream.this.serverStream.clientCancelled(status);
                InProcessTransport$InProcessStream.this.streamClosed();
            }
        }

        private synchronized boolean internalCancel(Status status, Status status2) {
            if (this.closed) {
                return false;
            }
            this.closed = true;
            while (true) {
                StreamListener.MessageProducer poll = this.serverReceiveQueue.poll();
                if (poll != null) {
                    while (true) {
                        InputStream next = poll.next();
                        if (next != null) {
                            try {
                                next.close();
                            } catch (Throwable th) {
                                InProcessTransport.access$2000().log(Level.WARNING, "Exception closing stream", th);
                            }
                        }
                    }
                } else {
                    InProcessTransport$InProcessStream.this.serverStream.statsTraceCtx.streamClosed(status2);
                    this.serverStreamListener.closed(status);
                    return true;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void halfClose() {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.closed     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r1)
                return
            L_0x0007:
                java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r0 = r1.serverReceiveQueue     // Catch:{ all -> 0x001a }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0015
                io.grpc.internal.ServerStreamListener r0 = r1.serverStreamListener     // Catch:{ all -> 0x001a }
                r0.halfClosed()     // Catch:{ all -> 0x001a }
                goto L_0x0018
            L_0x0015:
                r0 = 1
                r1.serverNotifyHalfClose = r0     // Catch:{ all -> 0x001a }
            L_0x0018:
                monitor-exit(r1)
                return
            L_0x001a:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport$InProcessStream.InProcessClientStream.halfClose():void");
        }

        public void setAuthority(String str) {
            String unused = InProcessTransport$InProcessStream.this.authority = str;
        }

        public void start(ClientStreamListener clientStreamListener) {
            InProcessTransport$InProcessStream.this.serverStream.setListener(clientStreamListener);
            synchronized (InProcessTransport$InProcessStream.this.this$0) {
                this.statsTraceCtx.clientOutboundHeaders();
                InProcessTransport.access$800(InProcessTransport$InProcessStream.this.this$0).add(InProcessTransport$InProcessStream.this);
                if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                    InProcessTransport.access$900(InProcessTransport$InProcessStream.this.this$0).updateObjectInUse(InProcessTransport$InProcessStream.this, true);
                }
                InProcessTransport.access$500(InProcessTransport$InProcessStream.this.this$0).streamCreated(InProcessTransport$InProcessStream.this.serverStream, InProcessTransport$InProcessStream.this.method.getFullMethodName(), InProcessTransport$InProcessStream.this.headers);
            }
        }

        public Attributes getAttributes() {
            return Attributes.EMPTY;
        }

        public void setDeadline(Deadline deadline) {
            InProcessTransport$InProcessStream.this.headers.discardAll(GrpcUtil.TIMEOUT_KEY);
            InProcessTransport$InProcessStream.this.headers.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(Math.max(0, deadline.timeRemaining(TimeUnit.NANOSECONDS))));
        }
    }
}
