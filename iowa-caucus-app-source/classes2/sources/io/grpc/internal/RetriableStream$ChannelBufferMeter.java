package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.atomic.AtomicLong;

final class RetriableStream$ChannelBufferMeter {
    private final AtomicLong bufferUsed = new AtomicLong();

    RetriableStream$ChannelBufferMeter() {
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public long addAndGet(long j) {
        return this.bufferUsed.addAndGet(j);
    }
}
