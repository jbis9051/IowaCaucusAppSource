package io.grpc.inprocess;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class InProcessTransport implements ServerTransport, ConnectionClientTransport {
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
    /* access modifiers changed from: private */
    public final Attributes attributes;
    private final String authority;
    /* access modifiers changed from: private */
    public final int clientMaxInboundMetadataSize;
    /* access modifiers changed from: private */
    public ManagedClientTransport.Listener clientTransportListener;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public final InUseStateAggregator<InProcessStream> inUseState = new 1(this);
    private final InternalLogId logId;
    /* access modifiers changed from: private */
    public final String name;
    private int serverMaxInboundMetadataSize;
    private ScheduledExecutorService serverScheduler;
    private ObjectPool<ScheduledExecutorService> serverSchedulerPool;
    /* access modifiers changed from: private */
    public Attributes serverStreamAttributes;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public List<ServerStreamTracer.Factory> serverStreamTracerFactories;
    /* access modifiers changed from: private */
    public ServerTransportListener serverTransportListener;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public boolean shutdown;
    @GuardedBy("this")
    private Status shutdownStatus;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public Set<InProcessStream> streams = new HashSet();
    @GuardedBy("this")
    private boolean terminated;
    private final String userAgent;

    public InProcessTransport(String str, int i, String str2, String str3, Attributes attributes2) {
        this.name = str;
        this.clientMaxInboundMetadataSize = i;
        this.authority = str2;
        this.userAgent = GrpcUtil.getGrpcUserAgent("inprocess", str3);
        Preconditions.checkNotNull(attributes2, "eagAttrs");
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes2).build();
        this.logId = InternalLogId.allocate(getClass(), str);
    }

    @CheckReturnValue
    public synchronized Runnable start(ManagedClientTransport.Listener listener) {
        this.clientTransportListener = listener;
        InProcessServer findServer = InProcessServer.findServer(this.name);
        if (findServer != null) {
            this.serverMaxInboundMetadataSize = findServer.getMaxInboundMetadataSize();
            this.serverSchedulerPool = findServer.getScheduledExecutorServicePool();
            this.serverScheduler = (ScheduledExecutorService) this.serverSchedulerPool.getObject();
            this.serverStreamTracerFactories = findServer.getStreamTracerFactories();
            this.serverTransportListener = findServer.register(this);
        }
        if (this.serverTransportListener == null) {
            Status status = Status.UNAVAILABLE;
            this.shutdownStatus = status.withDescription("Could not find server: " + this.name);
            return new 2(this, this.shutdownStatus);
        }
        return new 3(this);
    }

    public synchronized ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        int metadataSize;
        if (this.shutdownStatus != null) {
            return failedClientStream(StatsTraceContext.newClientContext(callOptions, this.attributes, metadata), this.shutdownStatus);
        }
        metadata.put(GrpcUtil.USER_AGENT_KEY, this.userAgent);
        if (this.serverMaxInboundMetadataSize == Integer.MAX_VALUE || (metadataSize = metadataSize(metadata)) <= this.serverMaxInboundMetadataSize) {
            return InProcessStream.access$700(new InProcessStream(this, methodDescriptor, metadata, callOptions, this.authority, (1) null));
        }
        return failedClientStream(StatsTraceContext.newClientContext(callOptions, this.attributes, metadata), Status.RESOURCE_EXHAUSTED.withDescription(String.format("Request metadata larger than %d: %d", new Object[]{Integer.valueOf(this.serverMaxInboundMetadataSize), Integer.valueOf(metadataSize)})));
    }

    private ClientStream failedClientStream(StatsTraceContext statsTraceContext, Status status) {
        return new 4(this, statsTraceContext, status);
    }

    public synchronized void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        if (this.terminated) {
            executor.execute(new 5(this, pingCallback, this.shutdownStatus));
        } else {
            executor.execute(new 6(this, pingCallback));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void shutdown(io.grpc.Status r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.shutdown     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r1.shutdownStatus = r2     // Catch:{ all -> 0x0019 }
            r1.notifyShutdown(r2)     // Catch:{ all -> 0x0019 }
            java.util.Set<io.grpc.inprocess.InProcessTransport$InProcessStream> r2 = r1.streams     // Catch:{ all -> 0x0019 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x0017
            r1.notifyTerminated()     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.shutdown(io.grpc.Status):void");
    }

    public synchronized void shutdown() {
        shutdown(Status.UNAVAILABLE.withDescription("InProcessTransport shutdown by the server-side"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r0.hasNext() == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        io.grpc.inprocess.InProcessTransport.InProcessStream.access$700((io.grpc.inprocess.InProcessTransport.InProcessStream) r0.next()).cancel(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shutdownNow(io.grpc.Status r3) {
        /*
            r2 = this;
            java.lang.String r0 = "reason"
            com.google.common.base.Preconditions.checkNotNull(r3, r0)
            monitor-enter(r2)
            r2.shutdown(r3)     // Catch:{ all -> 0x0030 }
            boolean r0 = r2.terminated     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
            return
        L_0x000f:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0030 }
            java.util.Set<io.grpc.inprocess.InProcessTransport$InProcessStream> r1 = r2.streams     // Catch:{ all -> 0x0030 }
            r0.<init>(r1)     // Catch:{ all -> 0x0030 }
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r0.next()
            io.grpc.inprocess.InProcessTransport$InProcessStream r1 = (io.grpc.inprocess.InProcessTransport.InProcessStream) r1
            io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r1 = io.grpc.inprocess.InProcessTransport.InProcessStream.access$700(r1)
            r1.cancel(r3)
            goto L_0x001b
        L_0x002f:
            return
        L_0x0030:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
            goto L_0x0034
        L_0x0033:
            throw r3
        L_0x0034:
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.shutdownNow(io.grpc.Status):void");
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).toString();
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return this.serverScheduler;
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture create = SettableFuture.create();
        create.set((Object) null);
        return create;
    }

    /* access modifiers changed from: private */
    public synchronized void notifyShutdown(Status status) {
        if (!this.shutdown) {
            this.shutdown = true;
            this.clientTransportListener.transportShutdown(status);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void notifyTerminated() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.terminated     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            r2.terminated = r0     // Catch:{ all -> 0x002a }
            java.util.concurrent.ScheduledExecutorService r0 = r2.serverScheduler     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x001a
            io.grpc.internal.ObjectPool<java.util.concurrent.ScheduledExecutorService> r0 = r2.serverSchedulerPool     // Catch:{ all -> 0x002a }
            java.util.concurrent.ScheduledExecutorService r1 = r2.serverScheduler     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = r0.returnObject(r1)     // Catch:{ all -> 0x002a }
            java.util.concurrent.ScheduledExecutorService r0 = (java.util.concurrent.ScheduledExecutorService) r0     // Catch:{ all -> 0x002a }
            r2.serverScheduler = r0     // Catch:{ all -> 0x002a }
        L_0x001a:
            io.grpc.internal.ManagedClientTransport$Listener r0 = r2.clientTransportListener     // Catch:{ all -> 0x002a }
            r0.transportTerminated()     // Catch:{ all -> 0x002a }
            io.grpc.internal.ServerTransportListener r0 = r2.serverTransportListener     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0028
            io.grpc.internal.ServerTransportListener r0 = r2.serverTransportListener     // Catch:{ all -> 0x002a }
            r0.transportTerminated()     // Catch:{ all -> 0x002a }
        L_0x0028:
            monitor-exit(r2)
            return
        L_0x002a:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.notifyTerminated():void");
    }

    /* access modifiers changed from: private */
    public static int metadataSize(Metadata metadata) {
        byte[][] serialize = InternalMetadata.serialize(metadata);
        if (serialize == null) {
            return 0;
        }
        long j = 0;
        for (int i = 0; i < serialize.length; i += 2) {
            j += (long) (serialize[i].length + 32 + serialize[i + 1].length);
        }
        return (int) Math.min(j, 2147483647L);
    }

    /* access modifiers changed from: private */
    public static Status stripCause(Status status) {
        if (status == null) {
            return null;
        }
        return Status.fromCodeValue(status.getCode().value()).withDescription(status.getDescription());
    }
}
