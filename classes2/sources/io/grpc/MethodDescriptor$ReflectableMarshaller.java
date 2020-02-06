package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
public interface MethodDescriptor$ReflectableMarshaller<T> extends MethodDescriptor$Marshaller<T> {
    Class<T> getMessageClass();
}
