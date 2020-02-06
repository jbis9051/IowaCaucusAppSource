package io.grpc.internal;

class DelayedClientTransport$5 implements Runnable {
    final /* synthetic */ DelayedClientTransport this$0;
    final /* synthetic */ DelayedClientTransport$PendingStream val$stream;
    final /* synthetic */ ClientTransport val$transport;

    DelayedClientTransport$5(DelayedClientTransport delayedClientTransport, DelayedClientTransport$PendingStream delayedClientTransport$PendingStream, ClientTransport clientTransport) {
        this.this$0 = delayedClientTransport;
        this.val$stream = delayedClientTransport$PendingStream;
        this.val$transport = clientTransport;
    }

    public void run() {
        this.val$stream.createRealStream(this.val$transport);
    }
}
