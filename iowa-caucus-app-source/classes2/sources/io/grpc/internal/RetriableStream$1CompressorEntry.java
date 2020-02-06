package io.grpc.internal;

import io.grpc.Compressor;

class RetriableStream$1CompressorEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ Compressor val$compressor;

    RetriableStream$1CompressorEntry(RetriableStream retriableStream, Compressor compressor) {
        this.this$0 = retriableStream;
        this.val$compressor = compressor;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setCompressor(this.val$compressor);
    }
}
