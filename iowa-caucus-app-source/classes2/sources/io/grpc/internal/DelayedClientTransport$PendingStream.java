package io.grpc.internal;

import io.grpc.Context;
import io.grpc.LoadBalancer;
import io.grpc.Status;

class DelayedClientTransport$PendingStream extends DelayedStream {
    /* access modifiers changed from: private */
    public final LoadBalancer.PickSubchannelArgs args;
    private final Context context;
    final /* synthetic */ DelayedClientTransport this$0;

    /* synthetic */ DelayedClientTransport$PendingStream(DelayedClientTransport delayedClientTransport, LoadBalancer.PickSubchannelArgs pickSubchannelArgs, DelayedClientTransport$1 delayedClientTransport$1) {
        this(delayedClientTransport, pickSubchannelArgs);
    }

    private DelayedClientTransport$PendingStream(DelayedClientTransport delayedClientTransport, LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
        this.this$0 = delayedClientTransport;
        this.context = Context.current();
        this.args = pickSubchannelArgs;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public void createRealStream(ClientTransport clientTransport) {
        Context attach = this.context.attach();
        try {
            ClientStream newStream = clientTransport.newStream(this.args.getMethodDescriptor(), this.args.getHeaders(), this.args.getCallOptions());
            this.context.detach(attach);
            setStream(newStream);
        } catch (Throwable th) {
            this.context.detach(attach);
            throw th;
        }
    }

    public void cancel(Status status) {
        super.cancel(status);
        synchronized (DelayedClientTransport.access$400(this.this$0)) {
            if (DelayedClientTransport.access$500(this.this$0) != null) {
                boolean remove = DelayedClientTransport.access$600(this.this$0).remove(this);
                if (!this.this$0.hasPendingStreams() && remove) {
                    DelayedClientTransport.access$800(this.this$0).executeLater(DelayedClientTransport.access$700(this.this$0));
                    if (DelayedClientTransport.access$900(this.this$0) != null) {
                        DelayedClientTransport.access$800(this.this$0).executeLater(DelayedClientTransport.access$500(this.this$0));
                        DelayedClientTransport.access$502(this.this$0, (Runnable) null);
                    }
                }
            }
        }
        DelayedClientTransport.access$800(this.this$0).drain();
    }
}
