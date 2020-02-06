package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.RetriableStream;
import io.grpc.internal.StreamListener;

final class RetriableStream$Sublistener implements ClientStreamListener {
    final RetriableStream$Substream substream;
    final /* synthetic */ RetriableStream this$0;

    RetriableStream$Sublistener(RetriableStream retriableStream, RetriableStream$Substream retriableStream$Substream) {
        this.this$0 = retriableStream;
        this.substream = retriableStream$Substream;
    }

    public void headersRead(Metadata metadata) {
        RetriableStream.access$1200(this.this$0, this.substream);
        if (RetriableStream.access$100(this.this$0).winningSubstream == this.substream) {
            RetriableStream.access$1300(this.this$0).headersRead(metadata);
            if (RetriableStream.access$500(this.this$0) != null) {
                RetriableStream.access$500(this.this$0).onSuccess();
            }
        }
    }

    public void closed(Status status, Metadata metadata) {
        closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x019b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void closed(io.grpc.Status r5, io.grpc.internal.ClientStreamListener.RpcProgress r6, io.grpc.Metadata r7) {
        /*
            r4 = this;
            io.grpc.internal.RetriableStream r0 = r4.this$0
            java.lang.Object r0 = io.grpc.internal.RetriableStream.access$300(r0)
            monitor-enter(r0)
            io.grpc.internal.RetriableStream r1 = r4.this$0     // Catch:{ all -> 0x01be }
            io.grpc.internal.RetriableStream r2 = r4.this$0     // Catch:{ all -> 0x01be }
            io.grpc.internal.RetriableStream$State r2 = io.grpc.internal.RetriableStream.access$100(r2)     // Catch:{ all -> 0x01be }
            io.grpc.internal.RetriableStream$Substream r3 = r4.substream     // Catch:{ all -> 0x01be }
            io.grpc.internal.RetriableStream$State r2 = r2.substreamClosed(r3)     // Catch:{ all -> 0x01be }
            io.grpc.internal.RetriableStream.access$102(r1, r2)     // Catch:{ all -> 0x01be }
            monitor-exit(r0)     // Catch:{ all -> 0x01be }
            io.grpc.internal.RetriableStream$Substream r0 = r4.substream
            boolean r0 = r0.bufferLimitExceeded
            if (r0 == 0) goto L_0x003c
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetriableStream$Substream r0 = r4.substream
            io.grpc.internal.RetriableStream.access$1200(r6, r0)
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetriableStream$State r6 = io.grpc.internal.RetriableStream.access$100(r6)
            io.grpc.internal.RetriableStream$Substream r6 = r6.winningSubstream
            io.grpc.internal.RetriableStream$Substream r0 = r4.substream
            if (r6 != r0) goto L_0x003b
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.ClientStreamListener r6 = io.grpc.internal.RetriableStream.access$1300(r6)
            r6.closed(r5, r7)
        L_0x003b:
            return
        L_0x003c:
            io.grpc.internal.RetriableStream r0 = r4.this$0
            io.grpc.internal.RetriableStream$State r0 = io.grpc.internal.RetriableStream.access$100(r0)
            io.grpc.internal.RetriableStream$Substream r0 = r0.winningSubstream
            if (r0 != 0) goto L_0x01a1
            io.grpc.internal.ClientStreamListener$RpcProgress r0 = io.grpc.internal.ClientStreamListener.RpcProgress.REFUSED
            r1 = 0
            r2 = 1
            if (r6 != r0) goto L_0x00de
            io.grpc.internal.RetriableStream r0 = r4.this$0
            java.util.concurrent.atomic.AtomicBoolean r0 = io.grpc.internal.RetriableStream.access$1400(r0)
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x00de
            io.grpc.internal.RetriableStream r5 = r4.this$0
            io.grpc.internal.RetriableStream$Substream r6 = r4.substream
            int r6 = r6.previousAttemptCount
            io.grpc.internal.RetriableStream$Substream r5 = io.grpc.internal.RetriableStream.access$200(r5, r6)
            io.grpc.internal.RetriableStream r6 = r4.this$0
            boolean r6 = io.grpc.internal.RetriableStream.access$1500(r6)
            if (r6 == 0) goto L_0x00ab
            io.grpc.internal.RetriableStream r6 = r4.this$0
            java.lang.Object r6 = io.grpc.internal.RetriableStream.access$300(r6)
            monitor-enter(r6)
            io.grpc.internal.RetriableStream r7 = r4.this$0     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream r0 = r4.this$0     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream$State r0 = io.grpc.internal.RetriableStream.access$100(r0)     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream$Substream r3 = r4.substream     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream$State r0 = r0.replaceActiveHedge(r3, r5)     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream.access$102(r7, r0)     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream r7 = r4.this$0     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream r0 = r4.this$0     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream$State r0 = io.grpc.internal.RetriableStream.access$100(r0)     // Catch:{ all -> 0x00a8 }
            boolean r7 = io.grpc.internal.RetriableStream.access$400(r7, r0)     // Catch:{ all -> 0x00a8 }
            if (r7 != 0) goto L_0x009f
            io.grpc.internal.RetriableStream r7 = r4.this$0     // Catch:{ all -> 0x00a8 }
            io.grpc.internal.RetriableStream$State r7 = io.grpc.internal.RetriableStream.access$100(r7)     // Catch:{ all -> 0x00a8 }
            java.util.Collection r7 = r7.activeHedges     // Catch:{ all -> 0x00a8 }
            int r7 = r7.size()     // Catch:{ all -> 0x00a8 }
            if (r7 != r2) goto L_0x009f
            r1 = 1
        L_0x009f:
            monitor-exit(r6)     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00cf
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetriableStream.access$1200(r6, r5)
            goto L_0x00cf
        L_0x00a8:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00a8 }
            throw r5
        L_0x00ab:
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetryPolicy r6 = io.grpc.internal.RetriableStream.access$1600(r6)
            if (r6 != 0) goto L_0x00c0
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetryPolicy$Provider r7 = io.grpc.internal.RetriableStream.access$1700(r6)
            io.grpc.internal.RetryPolicy r7 = r7.get()
            io.grpc.internal.RetriableStream.access$1602(r6, r7)
        L_0x00c0:
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetryPolicy r6 = io.grpc.internal.RetriableStream.access$1600(r6)
            int r6 = r6.maxAttempts
            if (r6 != r2) goto L_0x00cf
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetriableStream.access$1200(r6, r5)
        L_0x00cf:
            io.grpc.internal.RetriableStream r6 = r4.this$0
            java.util.concurrent.Executor r6 = io.grpc.internal.RetriableStream.access$1000(r6)
            io.grpc.internal.RetriableStream$Sublistener$1 r7 = new io.grpc.internal.RetriableStream$Sublistener$1
            r7.<init>(r5)
            r6.execute(r7)
            return
        L_0x00de:
            io.grpc.internal.ClientStreamListener$RpcProgress r0 = io.grpc.internal.ClientStreamListener.RpcProgress.DROPPED
            if (r6 != r0) goto L_0x00f0
            io.grpc.internal.RetriableStream r6 = r4.this$0
            boolean r6 = io.grpc.internal.RetriableStream.access$1500(r6)
            if (r6 == 0) goto L_0x015c
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetriableStream.access$1800(r6)
            goto L_0x015c
        L_0x00f0:
            io.grpc.internal.RetriableStream r6 = r4.this$0
            java.util.concurrent.atomic.AtomicBoolean r6 = io.grpc.internal.RetriableStream.access$1400(r6)
            r6.set(r2)
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetryPolicy r6 = io.grpc.internal.RetriableStream.access$1600(r6)
            if (r6 != 0) goto L_0x0119
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetryPolicy$Provider r0 = io.grpc.internal.RetriableStream.access$1700(r6)
            io.grpc.internal.RetryPolicy r0 = r0.get()
            io.grpc.internal.RetriableStream.access$1602(r6, r0)
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetryPolicy r0 = io.grpc.internal.RetriableStream.access$1600(r6)
            long r0 = r0.initialBackoffNanos
            io.grpc.internal.RetriableStream.access$1902(r6, r0)
        L_0x0119:
            io.grpc.internal.RetriableStream$RetryPlan r6 = r4.makeRetryDecision(r5, r7)
            boolean r0 = r6.shouldRetry
            if (r0 == 0) goto L_0x0153
            io.grpc.internal.RetriableStream r5 = r4.this$0
            java.lang.Object r0 = io.grpc.internal.RetriableStream.access$300(r5)
            monitor-enter(r0)
            io.grpc.internal.RetriableStream r5 = r4.this$0     // Catch:{ all -> 0x0150 }
            io.grpc.internal.RetriableStream$FutureCanceller r7 = new io.grpc.internal.RetriableStream$FutureCanceller     // Catch:{ all -> 0x0150 }
            io.grpc.internal.RetriableStream r1 = r4.this$0     // Catch:{ all -> 0x0150 }
            java.lang.Object r1 = io.grpc.internal.RetriableStream.access$300(r1)     // Catch:{ all -> 0x0150 }
            r7.<init>(r1)     // Catch:{ all -> 0x0150 }
            io.grpc.internal.RetriableStream.access$2002(r5, r7)     // Catch:{ all -> 0x0150 }
            monitor-exit(r0)     // Catch:{ all -> 0x0150 }
            io.grpc.internal.RetriableStream r5 = r4.this$0
            java.util.concurrent.ScheduledExecutorService r5 = io.grpc.internal.RetriableStream.access$800(r5)
            io.grpc.internal.RetriableStream$Sublistener$2 r0 = new io.grpc.internal.RetriableStream$Sublistener$2
            r0.<init>()
            long r1 = r6.backoffNanos
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS
            java.util.concurrent.ScheduledFuture r5 = r5.schedule(r0, r1, r6)
            r7.setFuture(r5)
            return
        L_0x0150:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0150 }
            throw r5
        L_0x0153:
            boolean r1 = r6.isFatal
            io.grpc.internal.RetriableStream r0 = r4.this$0
            java.lang.Integer r6 = r6.hedgingPushbackMillis
            io.grpc.internal.RetriableStream.access$2100(r0, r6)
        L_0x015c:
            io.grpc.internal.RetriableStream r6 = r4.this$0
            boolean r6 = io.grpc.internal.RetriableStream.access$1500(r6)
            if (r6 == 0) goto L_0x01a1
            io.grpc.internal.RetriableStream r6 = r4.this$0
            java.lang.Object r6 = io.grpc.internal.RetriableStream.access$300(r6)
            monitor-enter(r6)
            io.grpc.internal.RetriableStream r0 = r4.this$0     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream r2 = r4.this$0     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream$State r2 = io.grpc.internal.RetriableStream.access$100(r2)     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream$Substream r3 = r4.substream     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream$State r2 = r2.removeActiveHedge(r3)     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream.access$102(r0, r2)     // Catch:{ all -> 0x019e }
            if (r1 != 0) goto L_0x019c
            io.grpc.internal.RetriableStream r0 = r4.this$0     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream r1 = r4.this$0     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream$State r1 = io.grpc.internal.RetriableStream.access$100(r1)     // Catch:{ all -> 0x019e }
            boolean r0 = io.grpc.internal.RetriableStream.access$400(r0, r1)     // Catch:{ all -> 0x019e }
            if (r0 != 0) goto L_0x019a
            io.grpc.internal.RetriableStream r0 = r4.this$0     // Catch:{ all -> 0x019e }
            io.grpc.internal.RetriableStream$State r0 = io.grpc.internal.RetriableStream.access$100(r0)     // Catch:{ all -> 0x019e }
            java.util.Collection r0 = r0.activeHedges     // Catch:{ all -> 0x019e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x019e }
            if (r0 != 0) goto L_0x019c
        L_0x019a:
            monitor-exit(r6)     // Catch:{ all -> 0x019e }
            return
        L_0x019c:
            monitor-exit(r6)     // Catch:{ all -> 0x019e }
            goto L_0x01a1
        L_0x019e:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x019e }
            throw r5
        L_0x01a1:
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetriableStream$Substream r0 = r4.substream
            io.grpc.internal.RetriableStream.access$1200(r6, r0)
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.RetriableStream$State r6 = io.grpc.internal.RetriableStream.access$100(r6)
            io.grpc.internal.RetriableStream$Substream r6 = r6.winningSubstream
            io.grpc.internal.RetriableStream$Substream r0 = r4.substream
            if (r6 != r0) goto L_0x01bd
            io.grpc.internal.RetriableStream r6 = r4.this$0
            io.grpc.internal.ClientStreamListener r6 = io.grpc.internal.RetriableStream.access$1300(r6)
            r6.closed(r5, r7)
        L_0x01bd:
            return
        L_0x01be:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01be }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream$Sublistener.closed(io.grpc.Status, io.grpc.internal.ClientStreamListener$RpcProgress, io.grpc.Metadata):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.grpc.internal.RetriableStream$RetryPlan makeRetryDecision(io.grpc.Status r13, io.grpc.Metadata r14) {
        /*
            r12 = this;
            io.grpc.internal.RetriableStream r0 = r12.this$0
            io.grpc.internal.RetryPolicy r0 = io.grpc.internal.RetriableStream.access$1600(r0)
            java.util.Set r0 = r0.retryableStatusCodes
            io.grpc.Status$Code r1 = r13.getCode()
            boolean r0 = r0.contains(r1)
            io.grpc.internal.RetriableStream r1 = r12.this$0
            io.grpc.internal.HedgingPolicy r1 = io.grpc.internal.RetriableStream.access$700(r1)
            java.util.Set<io.grpc.Status$Code> r1 = r1.nonFatalStatusCodes
            io.grpc.Status$Code r13 = r13.getCode()
            boolean r13 = r1.contains(r13)
            io.grpc.internal.RetriableStream r1 = r12.this$0
            boolean r1 = io.grpc.internal.RetriableStream.access$1500(r1)
            if (r1 == 0) goto L_0x0036
            if (r13 != 0) goto L_0x0036
            io.grpc.internal.RetriableStream$RetryPlan r13 = new io.grpc.internal.RetriableStream$RetryPlan
            r3 = 0
            r4 = 1
            r5 = 0
            r7 = 0
            r2 = r13
            r2.<init>(r3, r4, r5, r7)
            return r13
        L_0x0036:
            io.grpc.Metadata$Key r1 = io.grpc.internal.RetriableStream.GRPC_RETRY_PUSHBACK_MS
            java.lang.Object r14 = r14.get(r1)
            java.lang.String r14 = (java.lang.String) r14
            r1 = 0
            if (r14 == 0) goto L_0x004c
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ NumberFormatException -> 0x0046 }
            goto L_0x004d
        L_0x0046:
            r14 = -1
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x004d
        L_0x004c:
            r14 = r1
        L_0x004d:
            io.grpc.internal.RetriableStream r2 = r12.this$0
            io.grpc.internal.RetriableStream$Throttle r2 = io.grpc.internal.RetriableStream.access$500(r2)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x006f
            if (r0 != 0) goto L_0x0063
            if (r13 != 0) goto L_0x0063
            if (r14 == 0) goto L_0x006f
            int r13 = r14.intValue()
            if (r13 >= 0) goto L_0x006f
        L_0x0063:
            io.grpc.internal.RetriableStream r13 = r12.this$0
            io.grpc.internal.RetriableStream$Throttle r13 = io.grpc.internal.RetriableStream.access$500(r13)
            boolean r13 = r13.onQualifiedFailureThenCheckIsAboveThreshold()
            r13 = r13 ^ r4
            goto L_0x0070
        L_0x006f:
            r13 = 0
        L_0x0070:
            io.grpc.internal.RetriableStream r2 = r12.this$0
            io.grpc.internal.RetryPolicy r2 = io.grpc.internal.RetriableStream.access$1600(r2)
            int r2 = r2.maxAttempts
            io.grpc.internal.RetriableStream$Substream r5 = r12.substream
            int r5 = r5.previousAttemptCount
            int r5 = r5 + r4
            if (r2 <= r5) goto L_0x00de
            if (r13 != 0) goto L_0x00de
            if (r14 != 0) goto L_0x00bf
            if (r0 == 0) goto L_0x00de
            io.grpc.internal.RetriableStream r13 = r12.this$0
            long r2 = io.grpc.internal.RetriableStream.access$1900(r13)
            double r2 = (double) r2
            java.util.Random r13 = io.grpc.internal.RetriableStream.access$2200()
            double r5 = r13.nextDouble()
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r5
            long r2 = (long) r2
            io.grpc.internal.RetriableStream r13 = r12.this$0
            long r5 = io.grpc.internal.RetriableStream.access$1900(r13)
            double r5 = (double) r5
            io.grpc.internal.RetriableStream r0 = r12.this$0
            io.grpc.internal.RetryPolicy r0 = io.grpc.internal.RetriableStream.access$1600(r0)
            double r7 = r0.backoffMultiplier
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r7
            long r5 = (long) r5
            io.grpc.internal.RetriableStream r0 = r12.this$0
            io.grpc.internal.RetryPolicy r0 = io.grpc.internal.RetriableStream.access$1600(r0)
            long r7 = r0.maxBackoffNanos
            long r5 = java.lang.Math.min(r5, r7)
            io.grpc.internal.RetriableStream.access$1902(r13, r5)
            goto L_0x00db
        L_0x00bf:
            int r13 = r14.intValue()
            if (r13 < 0) goto L_0x00de
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS
            int r0 = r14.intValue()
            long r2 = (long) r0
            long r2 = r13.toNanos(r2)
            io.grpc.internal.RetriableStream r13 = r12.this$0
            io.grpc.internal.RetryPolicy r0 = io.grpc.internal.RetriableStream.access$1600(r13)
            long r5 = r0.initialBackoffNanos
            io.grpc.internal.RetriableStream.access$1902(r13, r5)
        L_0x00db:
            r9 = r2
            r7 = 1
            goto L_0x00e2
        L_0x00de:
            r4 = 0
            r9 = r4
            r7 = 0
        L_0x00e2:
            io.grpc.internal.RetriableStream$RetryPlan r13 = new io.grpc.internal.RetriableStream$RetryPlan
            r8 = 0
            io.grpc.internal.RetriableStream r0 = r12.this$0
            boolean r0 = io.grpc.internal.RetriableStream.access$1500(r0)
            if (r0 == 0) goto L_0x00ef
            r11 = r14
            goto L_0x00f0
        L_0x00ef:
            r11 = r1
        L_0x00f0:
            r6 = r13
            r6.<init>(r7, r8, r9, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream$Sublistener.makeRetryDecision(io.grpc.Status, io.grpc.Metadata):io.grpc.internal.RetriableStream$RetryPlan");
    }

    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        RetriableStream.State access$100 = RetriableStream.access$100(this.this$0);
        Preconditions.checkState(access$100.winningSubstream != null, "Headers should be received prior to messages.");
        if (access$100.winningSubstream == this.substream) {
            RetriableStream.access$1300(this.this$0).messagesAvailable(messageProducer);
        }
    }

    public void onReady() {
        if (RetriableStream.access$100(this.this$0).drainedSubstreams.contains(this.substream)) {
            RetriableStream.access$1300(this.this$0).onReady();
        }
    }
}
