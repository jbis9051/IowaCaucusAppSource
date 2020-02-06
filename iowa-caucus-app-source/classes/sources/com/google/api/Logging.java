package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Logging extends GeneratedMessageLite<Logging, Builder> implements LoggingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Logging DEFAULT_INSTANCE = new Logging();
    private static volatile Parser<Logging> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<LoggingDestination> consumerDestinations_ = emptyProtobufList();
    private Internal.ProtobufList<LoggingDestination> producerDestinations_ = emptyProtobufList();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface LoggingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getLogs(int i);

        ByteString getLogsBytes(int i);

        int getLogsCount();

        List<String> getLogsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    private Logging() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class LoggingDestination extends GeneratedMessageLite<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
        /* access modifiers changed from: private */
        public static final LoggingDestination DEFAULT_INSTANCE = new LoggingDestination();
        public static final int LOGS_FIELD_NUMBER = 1;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 3;
        private static volatile Parser<LoggingDestination> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<String> logs_ = GeneratedMessageLite.emptyProtobufList();
        private String monitoredResource_ = "";

        private LoggingDestination() {
        }

        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        public ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        /* access modifiers changed from: private */
        public void setMonitoredResource(String str) {
            if (str != null) {
                this.monitoredResource_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearMonitoredResource() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        /* access modifiers changed from: private */
        public void setMonitoredResourceBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.monitoredResource_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public List<String> getLogsList() {
            return this.logs_;
        }

        public int getLogsCount() {
            return this.logs_.size();
        }

        public String getLogs(int i) {
            return (String) this.logs_.get(i);
        }

        public ByteString getLogsBytes(int i) {
            return ByteString.copyFromUtf8((String) this.logs_.get(i));
        }

        private void ensureLogsIsMutable() {
            if (!this.logs_.isModifiable()) {
                this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
            }
        }

        /* access modifiers changed from: private */
        public void setLogs(int i, String str) {
            if (str != null) {
                ensureLogsIsMutable();
                this.logs_.set(i, str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addLogs(String str) {
            if (str != null) {
                ensureLogsIsMutable();
                this.logs_.add(str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAllLogs(Iterable<String> iterable) {
            ensureLogsIsMutable();
            AbstractMessageLite.addAll(iterable, this.logs_);
        }

        /* access modifiers changed from: private */
        public void clearLogs() {
            this.logs_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addLogsBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                ensureLogsIsMutable();
                this.logs_.add(byteString.toStringUtf8());
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.logs_.size(); i++) {
                codedOutputStream.writeString(1, (String) this.logs_.get(i));
            }
            if (!this.monitoredResource_.isEmpty()) {
                codedOutputStream.writeString(3, getMonitoredResource());
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.logs_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag((String) this.logs_.get(i3));
            }
            int size = 0 + i2 + (getLogsList().size() * 1);
            if (!this.monitoredResource_.isEmpty()) {
                size += CodedOutputStream.computeStringSize(3, getMonitoredResource());
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        public static LoggingDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LoggingDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LoggingDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LoggingDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LoggingDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LoggingDestination loggingDestination) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(loggingDestination);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(LoggingDestination.DEFAULT_INSTANCE);
            }

            public String getMonitoredResource() {
                return this.instance.getMonitoredResource();
            }

            public ByteString getMonitoredResourceBytes() {
                return this.instance.getMonitoredResourceBytes();
            }

            public Builder setMonitoredResource(String str) {
                copyOnWrite();
                this.instance.setMonitoredResource(str);
                return this;
            }

            public Builder clearMonitoredResource() {
                copyOnWrite();
                this.instance.clearMonitoredResource();
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setMonitoredResourceBytes(byteString);
                return this;
            }

            public List<String> getLogsList() {
                return Collections.unmodifiableList(this.instance.getLogsList());
            }

            public int getLogsCount() {
                return this.instance.getLogsCount();
            }

            public String getLogs(int i) {
                return this.instance.getLogs(i);
            }

            public ByteString getLogsBytes(int i) {
                return this.instance.getLogsBytes(i);
            }

            public Builder setLogs(int i, String str) {
                copyOnWrite();
                this.instance.setLogs(i, str);
                return this;
            }

            public Builder addLogs(String str) {
                copyOnWrite();
                this.instance.addLogs(str);
                return this;
            }

            public Builder addAllLogs(Iterable<String> iterable) {
                copyOnWrite();
                this.instance.addAllLogs(iterable);
                return this;
            }

            public Builder clearLogs() {
                copyOnWrite();
                this.instance.clearLogs();
                return this;
            }

            public Builder addLogsBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.addLogsBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LoggingDestination();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.logs_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                    LoggingDestination loggingDestination = (LoggingDestination) obj2;
                    this.monitoredResource_ = mergeFromVisitor.visitString(!this.monitoredResource_.isEmpty(), this.monitoredResource_, true ^ loggingDestination.monitoredResource_.isEmpty(), loggingDestination.monitoredResource_);
                    this.logs_ = mergeFromVisitor.visitList(this.logs_, loggingDestination.logs_);
                    if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= loggingDestination.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.logs_.isModifiable()) {
                                        this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
                                    }
                                    this.logs_.add(readStringRequireUtf8);
                                } else if (readTag == 26) {
                                    this.monitoredResource_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (LoggingDestination.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static LoggingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LoggingDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Logging$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Logging.AnonymousClass1.<clinit>():void");
        }
    }

    public List<LoggingDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public List<? extends LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    public LoggingDestination getProducerDestinations(int i) {
        return (LoggingDestination) this.producerDestinations_.get(i);
    }

    public LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int i) {
        return (LoggingDestinationOrBuilder) this.producerDestinations_.get(i);
    }

    private void ensureProducerDestinationsIsMutable() {
        if (!this.producerDestinations_.isModifiable()) {
            this.producerDestinations_ = GeneratedMessageLite.mutableCopy(this.producerDestinations_);
        }
    }

    /* access modifiers changed from: private */
    public void setProducerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.set(i, loggingDestination);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setProducerDestinations(int i, LoggingDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(LoggingDestination loggingDestination) {
        if (loggingDestination != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.add(loggingDestination);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.add(i, loggingDestination);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(LoggingDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(int i, LoggingDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllProducerDestinations(Iterable<? extends LoggingDestination> iterable) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.addAll(iterable, this.producerDestinations_);
    }

    /* access modifiers changed from: private */
    public void clearProducerDestinations() {
        this.producerDestinations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeProducerDestinations(int i) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.remove(i);
    }

    public List<LoggingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public List<? extends LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    public LoggingDestination getConsumerDestinations(int i) {
        return (LoggingDestination) this.consumerDestinations_.get(i);
    }

    public LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return (LoggingDestinationOrBuilder) this.consumerDestinations_.get(i);
    }

    private void ensureConsumerDestinationsIsMutable() {
        if (!this.consumerDestinations_.isModifiable()) {
            this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
        }
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.set(i, loggingDestination);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int i, LoggingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(LoggingDestination loggingDestination) {
        if (loggingDestination != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(loggingDestination);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(i, loggingDestination);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(LoggingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int i, LoggingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends LoggingDestination> iterable) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.addAll(iterable, this.consumerDestinations_);
    }

    /* access modifiers changed from: private */
    public void clearConsumerDestinations() {
        this.consumerDestinations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeConsumerDestinations(int i) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.producerDestinations_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.producerDestinations_.get(i));
        }
        for (int i2 = 0; i2 < this.consumerDestinations_.size(); i2++) {
            codedOutputStream.writeMessage(2, (MessageLite) this.consumerDestinations_.get(i2));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.producerDestinations_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.producerDestinations_.get(i3));
        }
        for (int i4 = 0; i4 < this.consumerDestinations_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.consumerDestinations_.get(i4));
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Logging parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Logging parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Logging parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Logging parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Logging parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Logging parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Logging parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Logging parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Logging parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Logging parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Logging logging) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(logging);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Logging, Builder> implements LoggingOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Logging.DEFAULT_INSTANCE);
        }

        public List<LoggingDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(this.instance.getProducerDestinationsList());
        }

        public int getProducerDestinationsCount() {
            return this.instance.getProducerDestinationsCount();
        }

        public LoggingDestination getProducerDestinations(int i) {
            return this.instance.getProducerDestinations(i);
        }

        public Builder setProducerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            this.instance.setProducerDestinations(i, loggingDestination);
            return this;
        }

        public Builder setProducerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            this.instance.setProducerDestinations(i, builder);
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination loggingDestination) {
            copyOnWrite();
            this.instance.addProducerDestinations(loggingDestination);
            return this;
        }

        public Builder addProducerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            this.instance.addProducerDestinations(i, loggingDestination);
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination.Builder builder) {
            copyOnWrite();
            this.instance.addProducerDestinations(builder);
            return this;
        }

        public Builder addProducerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            this.instance.addProducerDestinations(i, builder);
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends LoggingDestination> iterable) {
            copyOnWrite();
            this.instance.addAllProducerDestinations(iterable);
            return this;
        }

        public Builder clearProducerDestinations() {
            copyOnWrite();
            this.instance.clearProducerDestinations();
            return this;
        }

        public Builder removeProducerDestinations(int i) {
            copyOnWrite();
            this.instance.removeProducerDestinations(i);
            return this;
        }

        public List<LoggingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(this.instance.getConsumerDestinationsList());
        }

        public int getConsumerDestinationsCount() {
            return this.instance.getConsumerDestinationsCount();
        }

        public LoggingDestination getConsumerDestinations(int i) {
            return this.instance.getConsumerDestinations(i);
        }

        public Builder setConsumerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            this.instance.setConsumerDestinations(i, loggingDestination);
            return this;
        }

        public Builder setConsumerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            this.instance.setConsumerDestinations(i, builder);
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination loggingDestination) {
            copyOnWrite();
            this.instance.addConsumerDestinations(loggingDestination);
            return this;
        }

        public Builder addConsumerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            this.instance.addConsumerDestinations(i, loggingDestination);
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination.Builder builder) {
            copyOnWrite();
            this.instance.addConsumerDestinations(builder);
            return this;
        }

        public Builder addConsumerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            this.instance.addConsumerDestinations(i, builder);
            return this;
        }

        public Builder addAllConsumerDestinations(Iterable<? extends LoggingDestination> iterable) {
            copyOnWrite();
            this.instance.addAllConsumerDestinations(iterable);
            return this;
        }

        public Builder clearConsumerDestinations() {
            copyOnWrite();
            this.instance.clearConsumerDestinations();
            return this;
        }

        public Builder removeConsumerDestinations(int i) {
            copyOnWrite();
            this.instance.removeConsumerDestinations(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Logging();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.producerDestinations_.makeImmutable();
                this.consumerDestinations_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Logging logging = (Logging) obj2;
                this.producerDestinations_ = visitor.visitList(this.producerDestinations_, logging.producerDestinations_);
                this.consumerDestinations_ = visitor.visitList(this.consumerDestinations_, logging.consumerDestinations_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (!this.producerDestinations_.isModifiable()) {
                                    this.producerDestinations_ = GeneratedMessageLite.mutableCopy(this.producerDestinations_);
                                }
                                this.producerDestinations_.add(codedInputStream.readMessage(LoggingDestination.parser(), extensionRegistryLite));
                            } else if (readTag == 18) {
                                if (!this.consumerDestinations_.isModifiable()) {
                                    this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
                                }
                                this.consumerDestinations_.add(codedInputStream.readMessage(LoggingDestination.parser(), extensionRegistryLite));
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (Logging.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    public static Logging getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Logging> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
