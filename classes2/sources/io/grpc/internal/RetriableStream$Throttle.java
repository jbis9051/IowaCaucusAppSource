package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import java.util.concurrent.atomic.AtomicInteger;

final class RetriableStream$Throttle {
    private static final int THREE_DECIMAL_PLACES_SCALE_UP = 1000;
    final int maxTokens;
    final int threshold;
    final AtomicInteger tokenCount = new AtomicInteger();
    final int tokenRatio;

    RetriableStream$Throttle(float f, float f2) {
        this.tokenRatio = (int) (f2 * 1000.0f);
        this.maxTokens = (int) (f * 1000.0f);
        int i = this.maxTokens;
        this.threshold = i / 2;
        this.tokenCount.set(i);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isAboveThreshold() {
        return this.tokenCount.get() > this.threshold;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean onQualifiedFailureThenCheckIsAboveThreshold() {
        int i;
        int i2;
        do {
            i = this.tokenCount.get();
            if (i == 0) {
                return false;
            }
            i2 = i - 1000;
        } while (!this.tokenCount.compareAndSet(i, Math.max(i2, 0)));
        if (i2 > this.threshold) {
            return true;
        }
        return false;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @com.google.common.annotations.VisibleForTesting
    void onSuccess() {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicInteger r0 = r4.tokenCount
            int r0 = r0.get()
            int r1 = r4.maxTokens
            if (r0 != r1) goto L_0x000b
            goto L_0x001a
        L_0x000b:
            int r2 = r4.tokenRatio
            int r2 = r2 + r0
            java.util.concurrent.atomic.AtomicInteger r3 = r4.tokenCount
            int r1 = java.lang.Math.min(r2, r1)
            boolean r0 = r3.compareAndSet(r0, r1)
            if (r0 == 0) goto L_0x0000
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream$Throttle.onSuccess():void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetriableStream$Throttle)) {
            return false;
        }
        RetriableStream$Throttle retriableStream$Throttle = (RetriableStream$Throttle) obj;
        if (this.maxTokens == retriableStream$Throttle.maxTokens && this.tokenRatio == retriableStream$Throttle.tokenRatio) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxTokens), Integer.valueOf(this.tokenRatio));
    }
}
