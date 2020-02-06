package com.google.firebase.firestore.util;

import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class AsyncQueue$DelayedStartFactory implements Runnable, ThreadFactory {
    private Runnable delegate;
    private final CountDownLatch latch;
    final /* synthetic */ AsyncQueue this$0;

    private AsyncQueue$DelayedStartFactory(AsyncQueue asyncQueue) {
        this.this$0 = asyncQueue;
        this.latch = new CountDownLatch(1);
    }

    /* synthetic */ AsyncQueue$DelayedStartFactory(AsyncQueue asyncQueue, AsyncQueue$1 asyncQueue$1) {
        this(asyncQueue);
    }

    public void run() {
        try {
            this.latch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.delegate.run();
    }

    public Thread newThread(@NonNull Runnable runnable) {
        Assert.hardAssert(this.delegate == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
        this.delegate = runnable;
        this.latch.countDown();
        return AsyncQueue.access$200(this.this$0);
    }
}
