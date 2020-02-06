package io.grpc.internal;

import io.grpc.Deadline;

class RetriableStream$1DeadlineEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ Deadline val$deadline;

    RetriableStream$1DeadlineEntry(RetriableStream retriableStream, Deadline deadline) {
        this.this$0 = retriableStream;
        this.val$deadline = deadline;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setDeadline(this.val$deadline);
    }
}
