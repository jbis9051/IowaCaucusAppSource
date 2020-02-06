package io.grpc.internal;

class RetriableStream$1MessageCompressionEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ boolean val$enable;

    RetriableStream$1MessageCompressionEntry(RetriableStream retriableStream, boolean z) {
        this.this$0 = retriableStream;
        this.val$enable = z;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setMessageCompression(this.val$enable);
    }
}
