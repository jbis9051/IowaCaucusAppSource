package io.grpc.inprocess;

import io.grpc.internal.InUseStateAggregator;

class InProcessTransport$1 extends InUseStateAggregator<InProcessTransport$InProcessStream> {
    final /* synthetic */ InProcessTransport this$0;

    InProcessTransport$1(InProcessTransport inProcessTransport) {
        this.this$0 = inProcessTransport;
    }

    /* access modifiers changed from: protected */
    public void handleInUse() {
        InProcessTransport.access$000(this.this$0).transportInUse(true);
    }

    /* access modifiers changed from: protected */
    public void handleNotInUse() {
        InProcessTransport.access$000(this.this$0).transportInUse(false);
    }
}
