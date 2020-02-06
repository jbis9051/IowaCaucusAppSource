package io.grpc.internal;

class RetriableStream$1SendMessageEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ Object val$message;

    RetriableStream$1SendMessageEntry(RetriableStream retriableStream, Object obj) {
        this.this$0 = retriableStream;
        this.val$message = obj;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.writeMessage(RetriableStream.access$1100(this.this$0).streamRequest(this.val$message));
    }
}
