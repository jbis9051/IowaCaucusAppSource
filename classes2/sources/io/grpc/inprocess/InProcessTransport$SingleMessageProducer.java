package io.grpc.inprocess;

import io.grpc.internal.StreamListener;
import java.io.InputStream;
import javax.annotation.Nullable;

class InProcessTransport$SingleMessageProducer implements StreamListener.MessageProducer {
    private InputStream message;

    /* synthetic */ InProcessTransport$SingleMessageProducer(InputStream inputStream, InProcessTransport$1 inProcessTransport$1) {
        this(inputStream);
    }

    private InProcessTransport$SingleMessageProducer(InputStream inputStream) {
        this.message = inputStream;
    }

    @Nullable
    public InputStream next() {
        InputStream inputStream = this.message;
        this.message = null;
        return inputStream;
    }
}
