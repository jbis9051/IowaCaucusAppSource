package io.grpc.internal;

import javax.annotation.Nullable;

final class RetriableStream$RetryPlan {
    final long backoffNanos;
    @Nullable
    final Integer hedgingPushbackMillis;
    final boolean isFatal;
    final boolean shouldRetry;

    RetriableStream$RetryPlan(boolean z, boolean z2, long j, @Nullable Integer num) {
        this.shouldRetry = z;
        this.isFatal = z2;
        this.backoffNanos = j;
        this.hedgingPushbackMillis = num;
    }
}
