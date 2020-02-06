package io.grpc.util;

import androidx.core.app.NotificationCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import javax.annotation.Nonnull;

@VisibleForTesting
final class RoundRobinLoadBalancer$EmptyPicker extends RoundRobinLoadBalancer$RoundRobinPicker {
    private final Status status;

    RoundRobinLoadBalancer$EmptyPicker(@Nonnull Status status2) {
        super();
        this.status = (Status) Preconditions.checkNotNull(status2, NotificationCompat.CATEGORY_STATUS);
    }

    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
        return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
    }

    /* access modifiers changed from: package-private */
    public boolean isEquivalentTo(RoundRobinLoadBalancer$RoundRobinPicker roundRobinLoadBalancer$RoundRobinPicker) {
        if (roundRobinLoadBalancer$RoundRobinPicker instanceof RoundRobinLoadBalancer$EmptyPicker) {
            RoundRobinLoadBalancer$EmptyPicker roundRobinLoadBalancer$EmptyPicker = (RoundRobinLoadBalancer$EmptyPicker) roundRobinLoadBalancer$RoundRobinPicker;
            if (Objects.equal(this.status, roundRobinLoadBalancer$EmptyPicker.status) || (this.status.isOk() && roundRobinLoadBalancer$EmptyPicker.status.isOk())) {
                return true;
            }
        }
        return false;
    }
}
