package io.grpc;

import com.google.common.base.Preconditions;

public final class CallOptions$Key<T> {
    private final String debugString;
    /* access modifiers changed from: private */
    public final T defaultValue;

    private CallOptions$Key(String str, T t) {
        this.debugString = str;
        this.defaultValue = t;
    }

    public T getDefault() {
        return this.defaultValue;
    }

    public String toString() {
        return this.debugString;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
    @Deprecated
    public static <T> CallOptions$Key<T> of(String str, T t) {
        Preconditions.checkNotNull(str, "debugString");
        return new CallOptions$Key<>(str, t);
    }

    public static <T> CallOptions$Key<T> create(String str) {
        Preconditions.checkNotNull(str, "debugString");
        return new CallOptions$Key<>(str, (Object) null);
    }

    public static <T> CallOptions$Key<T> createWithDefault(String str, T t) {
        Preconditions.checkNotNull(str, "debugString");
        return new CallOptions$Key<>(str, t);
    }
}
