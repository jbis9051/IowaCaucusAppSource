package io.grpc;

@Internal
public final class InternalClientInterceptors {
    public static <ReqT, RespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor clientInterceptor, MethodDescriptor$Marshaller<ReqT> methodDescriptor$Marshaller, MethodDescriptor$Marshaller<RespT> methodDescriptor$Marshaller2) {
        return ClientInterceptors.wrapClientInterceptor(clientInterceptor, methodDescriptor$Marshaller, methodDescriptor$Marshaller2);
    }
}
