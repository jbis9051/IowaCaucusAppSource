package com.google.firebase.firestore.util;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$DelayedTask$$Lambda$1 implements Runnable {
    private final AsyncQueue$DelayedTask arg$1;

    private AsyncQueue$DelayedTask$$Lambda$1(AsyncQueue$DelayedTask asyncQueue$DelayedTask) {
        this.arg$1 = asyncQueue$DelayedTask;
    }

    public static Runnable lambdaFactory$(AsyncQueue$DelayedTask asyncQueue$DelayedTask) {
        return new AsyncQueue$DelayedTask$$Lambda$1(asyncQueue$DelayedTask);
    }

    public void run() {
        this.arg$1.handleDelayElapsed();
    }
}
