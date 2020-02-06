package io.grpc.util;

import io.grpc.LoadBalancer$SubchannelPicker;

abstract class RoundRobinLoadBalancer$RoundRobinPicker extends LoadBalancer$SubchannelPicker {
    /* access modifiers changed from: package-private */
    public abstract boolean isEquivalentTo(RoundRobinLoadBalancer$RoundRobinPicker roundRobinLoadBalancer$RoundRobinPicker);

    private RoundRobinLoadBalancer$RoundRobinPicker() {
    }
}
