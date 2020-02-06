package io.grpc.internal;

final class RetriableStream$Substream {
    boolean bufferLimitExceeded;
    boolean closed;
    final int previousAttemptCount;
    ClientStream stream;

    RetriableStream$Substream(int i) {
        this.previousAttemptCount = i;
    }
}
