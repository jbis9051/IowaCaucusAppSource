package com.google.firebase.firestore.util;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class AsyncQueue$DelayedTask {
    private ScheduledFuture scheduledFuture;
    /* access modifiers changed from: private */
    public final long targetTimeMs;
    private final Runnable task;
    final /* synthetic */ AsyncQueue this$0;
    /* access modifiers changed from: private */
    public final AsyncQueue$TimerId timerId;

    /* synthetic */ AsyncQueue$DelayedTask(AsyncQueue asyncQueue, AsyncQueue$TimerId asyncQueue$TimerId, long j, Runnable runnable, AsyncQueue$1 asyncQueue$1) {
        this(asyncQueue, asyncQueue$TimerId, j, runnable);
    }

    private AsyncQueue$DelayedTask(AsyncQueue asyncQueue, AsyncQueue$TimerId asyncQueue$TimerId, long j, Runnable runnable) {
        this.this$0 = asyncQueue;
        this.timerId = asyncQueue$TimerId;
        this.targetTimeMs = j;
        this.task = runnable;
    }

    /* access modifiers changed from: private */
    public void start(long j) {
        this.scheduledFuture = AsyncQueue.access$000(this.this$0).schedule(AsyncQueue$DelayedTask$$Lambda$1.lambdaFactory$(this), j, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public void skipDelay() {
        handleDelayElapsed();
    }

    public void cancel() {
        this.this$0.verifyIsCurrentThread();
        ScheduledFuture scheduledFuture2 = this.scheduledFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
            markDone();
        }
    }

    /* access modifiers changed from: private */
    public void handleDelayElapsed() {
        this.this$0.verifyIsCurrentThread();
        if (this.scheduledFuture != null) {
            markDone();
            this.task.run();
        }
    }

    private void markDone() {
        Assert.hardAssert(this.scheduledFuture != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
        this.scheduledFuture = null;
        AsyncQueue.access$100(this.this$0, this);
    }
}
