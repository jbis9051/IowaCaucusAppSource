package io.grpc.internal;

class RetriableStream$1MaxOutboundMessageSizeEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ int val$maxSize;

    RetriableStream$1MaxOutboundMessageSizeEntry(RetriableStream retriableStream, int i) {
        this.this$0 = retriableStream;
        this.val$maxSize = i;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setMaxOutboundMessageSize(this.val$maxSize);
    }
}
