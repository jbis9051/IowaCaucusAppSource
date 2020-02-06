package io.grpc.internal;

class RetriableStream$1MaxInboundMessageSizeEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ int val$maxSize;

    RetriableStream$1MaxInboundMessageSizeEntry(RetriableStream retriableStream, int i) {
        this.this$0 = retriableStream;
        this.val$maxSize = i;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setMaxInboundMessageSize(this.val$maxSize);
    }
}
