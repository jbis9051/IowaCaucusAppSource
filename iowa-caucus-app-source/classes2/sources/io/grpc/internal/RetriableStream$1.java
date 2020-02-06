package io.grpc.internal;

import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;

class RetriableStream$1 extends ClientStreamTracer.Factory {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ ClientStreamTracer val$bufferSizeTracer;

    RetriableStream$1(RetriableStream retriableStream, ClientStreamTracer clientStreamTracer) {
        this.this$0 = retriableStream;
        this.val$bufferSizeTracer = clientStreamTracer;
    }

    public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
        return this.val$bufferSizeTracer;
    }
}
