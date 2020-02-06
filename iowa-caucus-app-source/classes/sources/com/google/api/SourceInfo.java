package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class SourceInfo extends GeneratedMessageLite<SourceInfo, Builder> implements SourceInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final SourceInfo DEFAULT_INSTANCE = new SourceInfo();
    private static volatile Parser<SourceInfo> PARSER = null;
    public static final int SOURCE_FILES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Any> sourceFiles_ = emptyProtobufList();

    private SourceInfo() {
    }

    public List<Any> getSourceFilesList() {
        return this.sourceFiles_;
    }

    public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
        return this.sourceFiles_;
    }

    public int getSourceFilesCount() {
        return this.sourceFiles_.size();
    }

    public Any getSourceFiles(int i) {
        return (Any) this.sourceFiles_.get(i);
    }

    public AnyOrBuilder getSourceFilesOrBuilder(int i) {
        return (AnyOrBuilder) this.sourceFiles_.get(i);
    }

    private void ensureSourceFilesIsMutable() {
        if (!this.sourceFiles_.isModifiable()) {
            this.sourceFiles_ = GeneratedMessageLite.mutableCopy(this.sourceFiles_);
        }
    }

    /* access modifiers changed from: private */
    public void setSourceFiles(int i, Any any) {
        if (any != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.set(i, any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setSourceFiles(int i, Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(Any any) {
        if (any != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.add(any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(int i, Any any) {
        if (any != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.add(i, any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(int i, Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllSourceFiles(Iterable<? extends Any> iterable) {
        ensureSourceFilesIsMutable();
        AbstractMessageLite.addAll(iterable, this.sourceFiles_);
    }

    /* access modifiers changed from: private */
    public void clearSourceFiles() {
        this.sourceFiles_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeSourceFiles(int i) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.sourceFiles_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.sourceFiles_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.sourceFiles_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.sourceFiles_.get(i3));
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static SourceInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SourceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SourceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SourceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SourceInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SourceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SourceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SourceInfo sourceInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(sourceInfo);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<SourceInfo, Builder> implements SourceInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(SourceInfo.DEFAULT_INSTANCE);
        }

        public List<Any> getSourceFilesList() {
            return Collections.unmodifiableList(this.instance.getSourceFilesList());
        }

        public int getSourceFilesCount() {
            return this.instance.getSourceFilesCount();
        }

        public Any getSourceFiles(int i) {
            return this.instance.getSourceFiles(i);
        }

        public Builder setSourceFiles(int i, Any any) {
            copyOnWrite();
            this.instance.setSourceFiles(i, any);
            return this;
        }

        public Builder setSourceFiles(int i, Any.Builder builder) {
            copyOnWrite();
            this.instance.setSourceFiles(i, builder);
            return this;
        }

        public Builder addSourceFiles(Any any) {
            copyOnWrite();
            this.instance.addSourceFiles(any);
            return this;
        }

        public Builder addSourceFiles(int i, Any any) {
            copyOnWrite();
            this.instance.addSourceFiles(i, any);
            return this;
        }

        public Builder addSourceFiles(Any.Builder builder) {
            copyOnWrite();
            this.instance.addSourceFiles(builder);
            return this;
        }

        public Builder addSourceFiles(int i, Any.Builder builder) {
            copyOnWrite();
            this.instance.addSourceFiles(i, builder);
            return this;
        }

        public Builder addAllSourceFiles(Iterable<? extends Any> iterable) {
            copyOnWrite();
            this.instance.addAllSourceFiles(iterable);
            return this;
        }

        public Builder clearSourceFiles() {
            copyOnWrite();
            this.instance.clearSourceFiles();
            return this;
        }

        public Builder removeSourceFiles(int i) {
            copyOnWrite();
            this.instance.removeSourceFiles(i);
            return this;
        }
    }

    /* renamed from: com.google.api.SourceInfo$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.SourceInfo.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SourceInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.sourceFiles_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.sourceFiles_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.sourceFiles_, ((SourceInfo) obj2).sourceFiles_);
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
                                if (!this.sourceFiles_.isModifiable()) {
                                    this.sourceFiles_ = GeneratedMessageLite.mutableCopy(this.sourceFiles_);
                                }
                                this.sourceFiles_.add(codedInputStream.readMessage(Any.parser(), extensionRegistryLite));
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
                    synchronized (SourceInfo.class) {
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

    public static SourceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SourceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
