package io.grpc;

import com.google.common.base.Charsets;

public enum Status$Code {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNAUTHENTICATED(16);
    
    private final int value;
    private final byte[] valueAscii;

    private Status$Code(int i) {
        this.value = i;
        this.valueAscii = Integer.toString(i).getBytes(Charsets.US_ASCII);
    }

    public int value() {
        return this.value;
    }

    public Status toStatus() {
        return (Status) Status.access$000().get(this.value);
    }

    /* access modifiers changed from: private */
    public byte[] valueAscii() {
        return this.valueAscii;
    }
}
