package io.grpc.internal;

import io.grpc.ClientStreamTracer;
import javax.annotation.concurrent.GuardedBy;

class RetriableStream$BufferSizeTracer extends ClientStreamTracer {
    @GuardedBy("lock")
    long bufferNeeded;
    private final RetriableStream$Substream substream;
    final /* synthetic */ RetriableStream this$0;

    RetriableStream$BufferSizeTracer(RetriableStream retriableStream, RetriableStream$Substream retriableStream$Substream) {
        this.this$0 = retriableStream;
        this.substream = retriableStream$Substream;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        r0.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void outboundWireSize(long r8) {
        /*
            r7 = this;
            io.grpc.internal.RetriableStream r0 = r7.this$0
            io.grpc.internal.RetriableStream$State r0 = io.grpc.internal.RetriableStream.access$100(r0)
            io.grpc.internal.RetriableStream$Substream r0 = r0.winningSubstream
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            r0 = 0
            io.grpc.internal.RetriableStream r1 = r7.this$0
            java.lang.Object r1 = io.grpc.internal.RetriableStream.access$300(r1)
            monitor-enter(r1)
            io.grpc.internal.RetriableStream r2 = r7.this$0     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream$State r2 = io.grpc.internal.RetriableStream.access$100(r2)     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream$Substream r2 = r2.winningSubstream     // Catch:{ all -> 0x0088 }
            if (r2 != 0) goto L_0x0086
            io.grpc.internal.RetriableStream$Substream r2 = r7.substream     // Catch:{ all -> 0x0088 }
            boolean r2 = r2.closed     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0024
            goto L_0x0086
        L_0x0024:
            long r2 = r7.bufferNeeded     // Catch:{ all -> 0x0088 }
            long r2 = r2 + r8
            r7.bufferNeeded = r2     // Catch:{ all -> 0x0088 }
            long r8 = r7.bufferNeeded     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream r2 = r7.this$0     // Catch:{ all -> 0x0088 }
            long r2 = io.grpc.internal.RetriableStream.access$2300(r2)     // Catch:{ all -> 0x0088 }
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0037
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            return
        L_0x0037:
            long r8 = r7.bufferNeeded     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream r2 = r7.this$0     // Catch:{ all -> 0x0088 }
            long r2 = io.grpc.internal.RetriableStream.access$2400(r2)     // Catch:{ all -> 0x0088 }
            r4 = 1
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0049
            io.grpc.internal.RetriableStream$Substream r8 = r7.substream     // Catch:{ all -> 0x0088 }
            r8.bufferLimitExceeded = r4     // Catch:{ all -> 0x0088 }
            goto L_0x0071
        L_0x0049:
            io.grpc.internal.RetriableStream r8 = r7.this$0     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream$ChannelBufferMeter r8 = io.grpc.internal.RetriableStream.access$2500(r8)     // Catch:{ all -> 0x0088 }
            long r2 = r7.bufferNeeded     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream r9 = r7.this$0     // Catch:{ all -> 0x0088 }
            long r5 = io.grpc.internal.RetriableStream.access$2300(r9)     // Catch:{ all -> 0x0088 }
            long r2 = r2 - r5
            long r8 = r8.addAndGet(r2)     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream r2 = r7.this$0     // Catch:{ all -> 0x0088 }
            long r5 = r7.bufferNeeded     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream.access$2302(r2, r5)     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream r2 = r7.this$0     // Catch:{ all -> 0x0088 }
            long r2 = io.grpc.internal.RetriableStream.access$2600(r2)     // Catch:{ all -> 0x0088 }
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0071
            io.grpc.internal.RetriableStream$Substream r8 = r7.substream     // Catch:{ all -> 0x0088 }
            r8.bufferLimitExceeded = r4     // Catch:{ all -> 0x0088 }
        L_0x0071:
            io.grpc.internal.RetriableStream$Substream r8 = r7.substream     // Catch:{ all -> 0x0088 }
            boolean r8 = r8.bufferLimitExceeded     // Catch:{ all -> 0x0088 }
            if (r8 == 0) goto L_0x007f
            io.grpc.internal.RetriableStream r8 = r7.this$0     // Catch:{ all -> 0x0088 }
            io.grpc.internal.RetriableStream$Substream r9 = r7.substream     // Catch:{ all -> 0x0088 }
            java.lang.Runnable r0 = io.grpc.internal.RetriableStream.access$2700(r8, r9)     // Catch:{ all -> 0x0088 }
        L_0x007f:
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0085
            r0.run()
        L_0x0085:
            return
        L_0x0086:
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            return
        L_0x0088:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream$BufferSizeTracer.outboundWireSize(long):void");
    }
}
