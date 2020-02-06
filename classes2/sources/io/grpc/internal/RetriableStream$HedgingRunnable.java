package io.grpc.internal;

import io.grpc.Status;
import java.util.concurrent.TimeUnit;

final class RetriableStream$HedgingRunnable implements Runnable {
    final RetriableStream$FutureCanceller scheduledHedgingRef;
    final /* synthetic */ RetriableStream this$0;

    RetriableStream$HedgingRunnable(RetriableStream retriableStream, RetriableStream$FutureCanceller retriableStream$FutureCanceller) {
        this.this$0 = retriableStream;
        this.scheduledHedgingRef = retriableStream$FutureCanceller;
    }

    public void run() {
        RetriableStream.access$1000(this.this$0).execute(new Runnable() {
            public void run() {
                RetriableStream$FutureCanceller retriableStream$FutureCanceller;
                boolean z;
                RetriableStream$Substream access$200 = RetriableStream.access$200(RetriableStream$HedgingRunnable.this.this$0, RetriableStream.access$100(RetriableStream$HedgingRunnable.this.this$0).hedgingAttemptCount);
                synchronized (RetriableStream.access$300(RetriableStream$HedgingRunnable.this.this$0)) {
                    retriableStream$FutureCanceller = null;
                    z = false;
                    if (RetriableStream$HedgingRunnable.this.scheduledHedgingRef.isCancelled()) {
                        z = true;
                    } else {
                        RetriableStream.access$102(RetriableStream$HedgingRunnable.this.this$0, RetriableStream.access$100(RetriableStream$HedgingRunnable.this.this$0).addActiveHedge(access$200));
                        if (!RetriableStream.access$400(RetriableStream$HedgingRunnable.this.this$0, RetriableStream.access$100(RetriableStream$HedgingRunnable.this.this$0)) || (RetriableStream.access$500(RetriableStream$HedgingRunnable.this.this$0) != null && !RetriableStream.access$500(RetriableStream$HedgingRunnable.this.this$0).isAboveThreshold())) {
                            RetriableStream.access$102(RetriableStream$HedgingRunnable.this.this$0, RetriableStream.access$100(RetriableStream$HedgingRunnable.this.this$0).freezeHedging());
                            RetriableStream.access$602(RetriableStream$HedgingRunnable.this.this$0, (RetriableStream$FutureCanceller) null);
                        } else {
                            RetriableStream retriableStream = RetriableStream$HedgingRunnable.this.this$0;
                            retriableStream$FutureCanceller = new RetriableStream$FutureCanceller(RetriableStream.access$300(RetriableStream$HedgingRunnable.this.this$0));
                            RetriableStream.access$602(retriableStream, retriableStream$FutureCanceller);
                        }
                    }
                }
                if (z) {
                    access$200.stream.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                    return;
                }
                if (retriableStream$FutureCanceller != null) {
                    retriableStream$FutureCanceller.setFuture(RetriableStream.access$800(RetriableStream$HedgingRunnable.this.this$0).schedule(new RetriableStream$HedgingRunnable(RetriableStream$HedgingRunnable.this.this$0, retriableStream$FutureCanceller), RetriableStream.access$700(RetriableStream$HedgingRunnable.this.this$0).hedgingDelayNanos, TimeUnit.NANOSECONDS));
                }
                RetriableStream.access$900(RetriableStream$HedgingRunnable.this.this$0, access$200);
            }
        });
    }
}
