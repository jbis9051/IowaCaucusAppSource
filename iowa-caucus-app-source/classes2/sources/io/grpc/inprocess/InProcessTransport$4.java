package io.grpc.inprocess;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.NoopClientStream;
import io.grpc.internal.StatsTraceContext;

class InProcessTransport$4 extends NoopClientStream {
    final /* synthetic */ InProcessTransport this$0;
    final /* synthetic */ StatsTraceContext val$statsTraceCtx;
    final /* synthetic */ Status val$status;

    InProcessTransport$4(InProcessTransport inProcessTransport, StatsTraceContext statsTraceContext, Status status) {
        this.this$0 = inProcessTransport;
        this.val$statsTraceCtx = statsTraceContext;
        this.val$status = status;
    }

    public void start(ClientStreamListener clientStreamListener) {
        this.val$statsTraceCtx.clientOutboundHeaders();
        this.val$statsTraceCtx.streamClosed(this.val$status);
        clientStreamListener.closed(this.val$status, new Metadata());
    }
}
