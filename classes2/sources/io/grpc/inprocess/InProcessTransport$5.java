package io.grpc.inprocess;

import io.grpc.Status;
import io.grpc.internal.ClientTransport$PingCallback;

class InProcessTransport$5 implements Runnable {
    final /* synthetic */ InProcessTransport this$0;
    final /* synthetic */ ClientTransport$PingCallback val$callback;
    final /* synthetic */ Status val$shutdownStatus;

    InProcessTransport$5(InProcessTransport inProcessTransport, ClientTransport$PingCallback clientTransport$PingCallback, Status status) {
        this.this$0 = inProcessTransport;
        this.val$callback = clientTransport$PingCallback;
        this.val$shutdownStatus = status;
    }

    public void run() {
        this.val$callback.onFailure(this.val$shutdownStatus.asRuntimeException());
    }
}
