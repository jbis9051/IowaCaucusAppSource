package io.grpc.internal;

class RetriableStream$1RequestEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ int val$numMessages;

    RetriableStream$1RequestEntry(RetriableStream retriableStream, int i) {
        this.this$0 = retriableStream;
        this.val$numMessages = i;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.request(this.val$numMessages);
    }
}
