package io.grpc.internal;

class RetriableStream$1FullStreamDecompressionEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ boolean val$fullStreamDecompression;

    RetriableStream$1FullStreamDecompressionEntry(RetriableStream retriableStream, boolean z) {
        this.this$0 = retriableStream;
        this.val$fullStreamDecompression = z;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setFullStreamDecompression(this.val$fullStreamDecompression);
    }
}
