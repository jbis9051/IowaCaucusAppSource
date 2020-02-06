package io.grpc.inprocess;

import io.grpc.internal.ClientTransport$PingCallback;

class InProcessTransport$6 implements Runnable {
    final /* synthetic */ InProcessTransport this$0;
    final /* synthetic */ ClientTransport$PingCallback val$callback;

    InProcessTransport$6(InProcessTransport inProcessTransport, ClientTransport$PingCallback clientTransport$PingCallback) {
        this.this$0 = inProcessTransport;
        this.val$callback = clientTransport$PingCallback;
    }

    public void run() {
        this.val$callback.onSuccess(0);
    }
}
