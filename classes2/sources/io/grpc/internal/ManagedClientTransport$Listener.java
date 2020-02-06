package io.grpc.internal;

import io.grpc.Status;

public interface ManagedClientTransport$Listener {
    void transportInUse(boolean z);

    void transportReady();

    void transportShutdown(Status status);

    void transportTerminated();
}
