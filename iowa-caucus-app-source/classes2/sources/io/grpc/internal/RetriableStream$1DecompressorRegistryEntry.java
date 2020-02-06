package io.grpc.internal;

import io.grpc.DecompressorRegistry;

class RetriableStream$1DecompressorRegistryEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ DecompressorRegistry val$decompressorRegistry;

    RetriableStream$1DecompressorRegistryEntry(RetriableStream retriableStream, DecompressorRegistry decompressorRegistry) {
        this.this$0 = retriableStream;
        this.val$decompressorRegistry = decompressorRegistry;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setDecompressorRegistry(this.val$decompressorRegistry);
    }
}
