package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.LoadBalancer;
import io.grpc.NameResolver;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
@ThreadSafe
public abstract class LoadBalancer$Helper {
    public abstract ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str);

    public abstract String getAuthority();

    @Deprecated
    public abstract NameResolver.Factory getNameResolverFactory();

    public abstract void updateBalancingState(@Nonnull ConnectivityState connectivityState, @Nonnull LoadBalancer$SubchannelPicker loadBalancer$SubchannelPicker);

    public final LoadBalancer.Subchannel createSubchannel(EquivalentAddressGroup equivalentAddressGroup, Attributes attributes) {
        Preconditions.checkNotNull(equivalentAddressGroup, "addrs");
        return createSubchannel((List<EquivalentAddressGroup>) Collections.singletonList(equivalentAddressGroup), attributes);
    }

    public LoadBalancer.Subchannel createSubchannel(List<EquivalentAddressGroup> list, Attributes attributes) {
        throw new UnsupportedOperationException();
    }

    public final void updateSubchannelAddresses(LoadBalancer.Subchannel subchannel, EquivalentAddressGroup equivalentAddressGroup) {
        Preconditions.checkNotNull(equivalentAddressGroup, "addrs");
        updateSubchannelAddresses(subchannel, (List<EquivalentAddressGroup>) Collections.singletonList(equivalentAddressGroup));
    }

    public void updateSubchannelAddresses(LoadBalancer.Subchannel subchannel, List<EquivalentAddressGroup> list) {
        throw new UnsupportedOperationException();
    }

    public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
        throw new UnsupportedOperationException();
    }

    public ManagedChannel createResolvingOobChannel(String str) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void refreshNameResolution() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void runSerialized(Runnable runnable) {
        getSynchronizationContext().execute(runnable);
    }

    public SynchronizationContext getSynchronizationContext() {
        throw new UnsupportedOperationException();
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        throw new UnsupportedOperationException();
    }

    public ChannelLogger getChannelLogger() {
        throw new UnsupportedOperationException();
    }
}
