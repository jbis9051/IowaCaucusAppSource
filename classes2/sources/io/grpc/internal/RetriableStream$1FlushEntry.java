package io.grpc.internal;

class RetriableStream$1FlushEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;

    RetriableStream$1FlushEntry(RetriableStream retriableStream) {
        this.this$0 = retriableStream;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.flush();
    }
}
