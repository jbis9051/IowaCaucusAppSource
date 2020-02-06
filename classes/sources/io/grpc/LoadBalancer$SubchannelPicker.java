package io.grpc;

import io.grpc.LoadBalancer;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
@ThreadSafe
public abstract class LoadBalancer$SubchannelPicker {
    public abstract LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);

    public void requestConnection() {
    }
}
