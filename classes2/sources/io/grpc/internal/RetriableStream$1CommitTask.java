package io.grpc.internal;

import java.util.Collection;
import java.util.concurrent.Future;

class RetriableStream$1CommitTask implements Runnable {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ Future val$hedgingFuture;
    final /* synthetic */ Future val$retryFuture;
    final /* synthetic */ Collection val$savedDrainedSubstreams;
    final /* synthetic */ RetriableStream$Substream val$winningSubstream;

    RetriableStream$1CommitTask(RetriableStream retriableStream, Collection collection, RetriableStream$Substream retriableStream$Substream, Future future, Future future2) {
        this.this$0 = retriableStream;
        this.val$savedDrainedSubstreams = collection;
        this.val$winningSubstream = retriableStream$Substream;
        this.val$retryFuture = future;
        this.val$hedgingFuture = future2;
    }

    public void run() {
        for (RetriableStream$Substream retriableStream$Substream : this.val$savedDrainedSubstreams) {
            if (retriableStream$Substream != this.val$winningSubstream) {
                retriableStream$Substream.stream.cancel(RetriableStream.access$000());
            }
        }
        Future future = this.val$retryFuture;
        if (future != null) {
            future.cancel(false);
        }
        Future future2 = this.val$hedgingFuture;
        if (future2 != null) {
            future2.cancel(false);
        }
        this.this$0.postCommit();
    }
}
