package io.grpc.inprocess;

import io.grpc.Status;

class InProcessTransport$2 implements Runnable {
    final /* synthetic */ InProcessTransport this$0;
    final /* synthetic */ Status val$localShutdownStatus;

    InProcessTransport$2(InProcessTransport inProcessTransport, Status status) {
        this.this$0 = inProcessTransport;
        this.val$localShutdownStatus = status;
    }

    public void run() {
        synchronized (this.this$0) {
            InProcessTransport.access$100(this.this$0, this.val$localShutdownStatus);
            InProcessTransport.access$200(this.this$0);
        }
    }
}
