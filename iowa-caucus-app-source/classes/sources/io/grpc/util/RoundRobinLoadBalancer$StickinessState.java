package io.grpc.util;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.util.RoundRobinLoadBalancer;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@VisibleForTesting
final class RoundRobinLoadBalancer$StickinessState {
    static final int MAX_ENTRIES = 1000;
    final Queue<String> evictionQueue = new ConcurrentLinkedQueue();
    final Metadata.Key<String> key;
    final ConcurrentMap<String, RoundRobinLoadBalancer.Ref<LoadBalancer.Subchannel>> stickinessMap = new ConcurrentHashMap();

    RoundRobinLoadBalancer$StickinessState(@Nonnull String str) {
        this.key = Metadata.Key.of(str, Metadata.ASCII_STRING_MARSHALLER);
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public LoadBalancer.Subchannel maybeRegister(String str, @Nonnull LoadBalancer.Subchannel subchannel) {
        RoundRobinLoadBalancer.Ref ref;
        RoundRobinLoadBalancer.Ref ref2 = (RoundRobinLoadBalancer.Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.STICKY_REF);
        do {
            ref = (RoundRobinLoadBalancer.Ref) this.stickinessMap.putIfAbsent(str, ref2);
            if (ref == null) {
                addToEvictionQueue(str);
                return subchannel;
            }
            LoadBalancer.Subchannel subchannel2 = (LoadBalancer.Subchannel) ref.value;
            if (subchannel2 != null && RoundRobinLoadBalancer.isReady(subchannel2)) {
                return subchannel2;
            }
        } while (!this.stickinessMap.replace(str, ref, ref2));
        return subchannel;
    }

    private void addToEvictionQueue(String str) {
        String poll;
        while (this.stickinessMap.size() >= 1000 && (poll = this.evictionQueue.poll()) != null) {
            this.stickinessMap.remove(poll);
        }
        this.evictionQueue.add(str);
    }

    /* access modifiers changed from: package-private */
    public void remove(LoadBalancer.Subchannel subchannel) {
        ((RoundRobinLoadBalancer.Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.STICKY_REF)).value = null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public LoadBalancer.Subchannel getSubchannel(String str) {
        RoundRobinLoadBalancer.Ref ref = (RoundRobinLoadBalancer.Ref) this.stickinessMap.get(str);
        if (ref != null) {
            return (LoadBalancer.Subchannel) ref.value;
        }
        return null;
    }
}
