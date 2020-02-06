package io.grpc.inprocess;

import io.grpc.Attributes;
import io.grpc.Grpc;

class InProcessTransport$3 implements Runnable {
    final /* synthetic */ InProcessTransport this$0;

    InProcessTransport$3(InProcessTransport inProcessTransport) {
        this.this$0 = inProcessTransport;
    }

    public void run() {
        synchronized (this.this$0) {
            InProcessTransport.access$402(this.this$0, InProcessTransport.access$500(this.this$0).transportReady(Attributes.newBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, new InProcessSocketAddress(InProcessTransport.access$300(this.this$0))).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, new InProcessSocketAddress(InProcessTransport.access$300(this.this$0))).build()));
            InProcessTransport.access$000(this.this$0).transportReady();
        }
    }
}
