package io.grpc;

import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
public interface MethodDescriptor$PrototypeMarshaller<T> extends MethodDescriptor$ReflectableMarshaller<T> {
    @Nullable
    T getMessagePrototype();
}
