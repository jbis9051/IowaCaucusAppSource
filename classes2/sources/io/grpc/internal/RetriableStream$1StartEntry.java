package io.grpc.internal;

class RetriableStream$1StartEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;

    RetriableStream$1StartEntry(RetriableStream retriableStream) {
        this.this$0 = retriableStream;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.start(new RetriableStream$Sublistener(this.this$0, retriableStream$Substream));
    }
}
