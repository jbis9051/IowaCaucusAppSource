package io.grpc.internal;

class DelayedClientTransport$3 implements Runnable {
    final /* synthetic */ DelayedClientTransport this$0;
    final /* synthetic */ ManagedClientTransport$Listener val$listener;

    DelayedClientTransport$3(DelayedClientTransport delayedClientTransport, ManagedClientTransport$Listener managedClientTransport$Listener) {
        this.this$0 = delayedClientTransport;
        this.val$listener = managedClientTransport$Listener;
    }

    public void run() {
        this.val$listener.transportTerminated();
    }
}
