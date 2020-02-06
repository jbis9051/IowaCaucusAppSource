package io.grpc;

import io.grpc.Metadata;

final class Status$StatusCodeMarshaller implements Metadata.TrustedAsciiMarshaller<Status> {
    private Status$StatusCodeMarshaller() {
    }

    public byte[] toAsciiString(Status status) {
        return status.getCode().valueAscii();
    }

    public Status parseAsciiString(byte[] bArr) {
        return Status.access$400(bArr);
    }
}
