package io.grpc.internal;

import java.util.concurrent.Executor;

final class ConnectivityStateManager$Listener {
    final Runnable callback;
    final Executor executor;

    ConnectivityStateManager$Listener(Runnable runnable, Executor executor2) {
        this.callback = runnable;
        this.executor = executor2;
    }

    /* access modifiers changed from: package-private */
    public void runInExecutor() {
        this.executor.execute(this.callback);
    }
}
