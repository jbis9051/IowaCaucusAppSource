package io.grpc.internal;

import io.grpc.Status;

class DelayedClientTransport$4 implements Runnable {
    final /* synthetic */ DelayedClientTransport this$0;
    final /* synthetic */ Status val$status;

    DelayedClientTransport$4(DelayedClientTransport delayedClientTransport, Status status) {
        this.this$0 = delayedClientTransport;
        this.val$status = status;
    }

    public void run() {
        DelayedClientTransport.access$100(this.this$0).transportShutdown(this.val$status);
    }
}
