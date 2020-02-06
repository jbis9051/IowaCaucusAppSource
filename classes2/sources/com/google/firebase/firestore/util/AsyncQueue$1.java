package com.google.firebase.firestore.util;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class AsyncQueue$1 extends ScheduledThreadPoolExecutor {
    final /* synthetic */ AsyncQueue this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncQueue$1(AsyncQueue asyncQueue, int i, ThreadFactory threadFactory) {
        super(i, threadFactory);
        this.this$0 = asyncQueue;
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            try {
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException unused) {
            } catch (ExecutionException e) {
                th = e.getCause();
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            this.this$0.panic(th);
        }
    }
}
