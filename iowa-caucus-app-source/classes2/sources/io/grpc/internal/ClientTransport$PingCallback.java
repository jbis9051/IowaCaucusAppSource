package io.grpc.internal;

public interface ClientTransport$PingCallback {
    void onFailure(Throwable th);

    void onSuccess(long j);
}
