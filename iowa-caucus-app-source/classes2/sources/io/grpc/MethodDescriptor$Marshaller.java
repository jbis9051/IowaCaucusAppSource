package io.grpc;

import java.io.InputStream;

public interface MethodDescriptor$Marshaller<T> {
    T parse(InputStream inputStream);

    InputStream stream(T t);
}
