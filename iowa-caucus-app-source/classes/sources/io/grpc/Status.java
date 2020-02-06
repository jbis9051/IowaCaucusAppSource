package io.grpc;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import io.grpc.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@CheckReturnValue
@Immutable
public final class Status {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Status ABORTED = Code.ABORTED.toStatus();
    public static final Status ALREADY_EXISTS = Code.ALREADY_EXISTS.toStatus();
    public static final Status CANCELLED = Code.CANCELLED.toStatus();
    static final Metadata.Key<Status> CODE_KEY = Metadata.Key.of("grpc-status", false, new StatusCodeMarshaller((1) null));
    public static final Status DATA_LOSS = Code.DATA_LOSS.toStatus();
    public static final Status DEADLINE_EXCEEDED = Code.DEADLINE_EXCEEDED.toStatus();
    public static final Status FAILED_PRECONDITION = Code.FAILED_PRECONDITION.toStatus();
    private static final boolean FAIL_ON_EQUALS_FOR_TEST = Boolean.parseBoolean(System.getProperty(TEST_EQUALS_FAILURE_PROPERTY, "false"));
    public static final Status INTERNAL = Code.INTERNAL.toStatus();
    public static final Status INVALID_ARGUMENT = Code.INVALID_ARGUMENT.toStatus();
    static final Metadata.Key<String> MESSAGE_KEY = Metadata.Key.of("grpc-message", false, STATUS_MESSAGE_MARSHALLER);
    public static final Status NOT_FOUND = Code.NOT_FOUND.toStatus();
    public static final Status OK = Code.OK.toStatus();
    public static final Status OUT_OF_RANGE = Code.OUT_OF_RANGE.toStatus();
    public static final Status PERMISSION_DENIED = Code.PERMISSION_DENIED.toStatus();
    public static final Status RESOURCE_EXHAUSTED = Code.RESOURCE_EXHAUSTED.toStatus();
    /* access modifiers changed from: private */
    public static final List<Status> STATUS_LIST = buildStatusList();
    private static final Metadata.TrustedAsciiMarshaller<String> STATUS_MESSAGE_MARSHALLER = new StatusMessageMarshaller((1) null);
    private static final String TEST_EQUALS_FAILURE_PROPERTY = "io.grpc.Status.failOnEqualsForTest";
    public static final Status UNAUTHENTICATED = Code.UNAUTHENTICATED.toStatus();
    public static final Status UNAVAILABLE = Code.UNAVAILABLE.toStatus();
    public static final Status UNIMPLEMENTED = Code.UNIMPLEMENTED.toStatus();
    public static final Status UNKNOWN = Code.UNKNOWN.toStatus();
    private final Throwable cause;
    private final Code code;
    private final String description;

    private static List<Status> buildStatusList() {
        TreeMap treeMap = new TreeMap();
        Code[] values = Code.values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            Code code2 = values[i];
            Status status = (Status) treeMap.put(Integer.valueOf(code2.value()), new Status(code2));
            if (status == null) {
                i++;
            } else {
                throw new IllegalStateException("Code value duplication between " + status.getCode().name() + " & " + code2.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static Status fromCodeValue(int i) {
        if (i >= 0 && i <= STATUS_LIST.size()) {
            return STATUS_LIST.get(i);
        }
        Status status = UNKNOWN;
        return status.withDescription("Unknown code " + i);
    }

    /* access modifiers changed from: private */
    public static Status fromCodeValue(byte[] bArr) {
        if (bArr.length == 1 && bArr[0] == 48) {
            return OK;
        }
        return fromCodeValueSlow(bArr);
    }

    private static Status fromCodeValueSlow(byte[] bArr) {
        int i;
        int length = bArr.length;
        char c = 1;
        int i2 = 0;
        if (length != 1) {
            if (length == 2 && bArr[0] >= 48 && bArr[0] <= 57) {
                i2 = 0 + ((bArr[0] - 48) * 10);
            }
            Status status = UNKNOWN;
            return status.withDescription("Unknown code " + new String(bArr, Charsets.US_ASCII));
        }
        c = 0;
        if (bArr[c] >= 48 && bArr[c] <= 57 && (i = i2 + (bArr[c] - 48)) < STATUS_LIST.size()) {
            return STATUS_LIST.get(i);
        }
        Status status2 = UNKNOWN;
        return status2.withDescription("Unknown code " + new String(bArr, Charsets.US_ASCII));
    }

    public static Status fromCode(Code code2) {
        return code2.toStatus();
    }

    public static Status fromThrowable(Throwable th) {
        for (Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                return ((StatusException) th2).getStatus();
            }
            if (th2 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th2).getStatus();
            }
        }
        return UNKNOWN.withCause(th);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4683")
    public static Metadata trailersFromThrowable(Throwable th) {
        for (Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                return ((StatusException) th2).getTrailers();
            }
            if (th2 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th2).getTrailers();
            }
        }
        return null;
    }

    static String formatThrowableMessage(Status status) {
        if (status.description == null) {
            return status.code.toString();
        }
        return status.code + ": " + status.description;
    }

    private Status(Code code2) {
        this(code2, (String) null, (Throwable) null);
    }

    private Status(Code code2, @Nullable String str, @Nullable Throwable th) {
        this.code = (Code) Preconditions.checkNotNull(code2, "code");
        this.description = str;
        this.cause = th;
    }

    public Status withCause(Throwable th) {
        if (Objects.equal(this.cause, th)) {
            return this;
        }
        return new Status(this.code, this.description, th);
    }

    public Status withDescription(String str) {
        if (Objects.equal(this.description, str)) {
            return this;
        }
        return new Status(this.code, str, this.cause);
    }

    public Status augmentDescription(String str) {
        if (str == null) {
            return this;
        }
        if (this.description == null) {
            return new Status(this.code, str, this.cause);
        }
        Code code2 = this.code;
        return new Status(code2, this.description + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + str, this.cause);
    }

    public Code getCode() {
        return this.code;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    public boolean isOk() {
        return Code.OK == this.code;
    }

    public StatusRuntimeException asRuntimeException() {
        return new StatusRuntimeException(this);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4683")
    public StatusRuntimeException asRuntimeException(@Nullable Metadata metadata) {
        return new StatusRuntimeException(this, metadata);
    }

    public StatusException asException() {
        return new StatusException(this);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4683")
    public StatusException asException(@Nullable Metadata metadata) {
        return new StatusException(this, metadata);
    }

    public String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper(this).add("code", this.code.name()).add("description", this.description);
        Throwable th = this.cause;
        Object obj = th;
        if (th != null) {
            obj = Throwables.getStackTraceAsString(th);
        }
        return add.add("cause", obj).toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
