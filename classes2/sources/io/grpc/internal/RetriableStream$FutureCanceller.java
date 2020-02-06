package io.grpc.internal;

import java.util.concurrent.Future;
import javax.annotation.CheckForNull;
import javax.annotation.concurrent.GuardedBy;

final class RetriableStream$FutureCanceller {
    @GuardedBy("lock")
    boolean cancelled;
    @GuardedBy("lock")
    Future<?> future;
    final Object lock;

    RetriableStream$FutureCanceller(Object obj) {
        this.lock = obj;
    }

    /* access modifiers changed from: package-private */
    public void setFuture(Future<?> future2) {
        synchronized (this.lock) {
            if (!this.cancelled) {
                this.future = future2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("lock")
    @CheckForNull
    public Future<?> markCancelled() {
        this.cancelled = true;
        return this.future;
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("lock")
    public boolean isCancelled() {
        return this.cancelled;
    }
}
