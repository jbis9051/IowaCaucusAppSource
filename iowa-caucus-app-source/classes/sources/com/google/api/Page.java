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
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Page extends GeneratedMessageLite<Page, Builder> implements PageOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Page DEFAULT_INSTANCE = new Page();
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Page> PARSER = null;
    public static final int SUBPAGES_FIELD_NUMBER = 3;
    private int bitField0_;
    private String content_ = "";
    private String name_ = "";
    private Internal.ProtobufList<Page> subpages_ = emptyProtobufList();

    private Page() {
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* access modifiers changed from: private */
    public void setName(String str) {
        if (str != null) {
            this.name_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getContent() {
        return this.content_;
    }

    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    /* access modifiers changed from: private */
    public void setContent(String str) {
        if (str != null) {
            this.content_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* access modifiers changed from: private */
    public void setContentBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.content_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public List<Page> getSubpagesList() {
        return this.subpages_;
    }

    public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
        return this.subpages_;
    }

    public int getSubpagesCount() {
        return this.subpages_.size();
    }

    public Page getSubpages(int i) {
        return (Page) this.subpages_.get(i);
    }

    public PageOrBuilder getSubpagesOrBuilder(int i) {
        return (PageOrBuilder) this.subpages_.get(i);
    }

    private void ensureSubpagesIsMutable() {
        if (!this.subpages_.isModifiable()) {
            this.subpages_ = GeneratedMessageLite.mutableCopy(this.subpages_);
        }
    }

    /* access modifiers changed from: private */
    public void setSubpages(int i, Page page) {
        if (page != null) {
            ensureSubpagesIsMutable();
            this.subpages_.set(i, page);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setSubpages(int i, Builder builder) {
        ensureSubpagesIsMutable();
        this.subpages_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addSubpages(Page page) {
        if (page != null) {
            ensureSubpagesIsMutable();
            this.subpages_.add(page);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addSubpages(int i, Page page) {
        if (page != null) {
            ensureSubpagesIsMutable();
            this.subpages_.add(i, page);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addSubpages(Builder builder) {
        ensureSubpagesIsMutable();
        this.subpages_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addSubpages(int i, Builder builder) {
        ensureSubpagesIsMutable();
        this.subpages_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllSubpages(Iterable<? extends Page> iterable) {
        ensureSubpagesIsMutable();
        AbstractMessageLite.addAll(iterable, this.subpages_);
    }

    /* access modifiers changed from: private */
    public void clearSubpages() {
        this.subpages_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeSubpages(int i) {
        ensureSubpagesIsMutable();
        this.subpages_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (!this.content_.isEmpty()) {
            codedOutputStream.writeString(2, getContent());
        }
        for (int i = 0; i < this.subpages_.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.subpages_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        if (!this.content_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getContent());
        }
        for (int i2 = 0; i2 < this.subpages_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, (MessageLite) this.subpages_.get(i2));
        }
        this.memoizedSerializedSize = computeStringSize;
        return computeStringSize;
    }

    public static Page parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Page parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Page parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Page parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Page parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Page parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Page parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Page parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Page parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Page parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Page page) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(page);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Page, Builder> implements PageOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Page.DEFAULT_INSTANCE);
        }

        public String getName() {
            return this.instance.getName();
        }

        public ByteString getNameBytes() {
            return this.instance.getNameBytes();
        }

        public Builder setName(String str) {
            copyOnWrite();
            this.instance.setName(str);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            this.instance.clearName();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setNameBytes(byteString);
            return this;
        }

        public String getContent() {
            return this.instance.getContent();
        }

        public ByteString getContentBytes() {
            return this.instance.getContentBytes();
        }

        public Builder setContent(String str) {
            copyOnWrite();
            this.instance.setContent(str);
            return this;
        }

        public Builder clearContent() {
            copyOnWrite();
            this.instance.clearContent();
            return this;
        }

        public Builder setContentBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setContentBytes(byteString);
            return this;
        }

        public List<Page> getSubpagesList() {
            return Collections.unmodifiableList(this.instance.getSubpagesList());
        }

        public int getSubpagesCount() {
            return this.instance.getSubpagesCount();
        }

        public Page getSubpages(int i) {
            return this.instance.getSubpages(i);
        }

        public Builder setSubpages(int i, Page page) {
            copyOnWrite();
            this.instance.setSubpages(i, page);
            return this;
        }

        public Builder setSubpages(int i, Builder builder) {
            copyOnWrite();
            this.instance.setSubpages(i, builder);
            return this;
        }

        public Builder addSubpages(Page page) {
            copyOnWrite();
            this.instance.addSubpages(page);
            return this;
        }

        public Builder addSubpages(int i, Page page) {
            copyOnWrite();
            this.instance.addSubpages(i, page);
            return this;
        }

        public Builder addSubpages(Builder builder) {
            copyOnWrite();
            this.instance.addSubpages(builder);
            return this;
        }

        public Builder addSubpages(int i, Builder builder) {
            copyOnWrite();
            this.instance.addSubpages(i, builder);
            return this;
        }

        public Builder addAllSubpages(Iterable<? extends Page> iterable) {
            copyOnWrite();
            this.instance.addAllSubpages(iterable);
            return this;
        }

        public Builder clearSubpages() {
            copyOnWrite();
            this.instance.clearSubpages();
            return this;
        }

        public Builder removeSubpages(int i) {
            copyOnWrite();
            this.instance.removeSubpages(i);
            return this;
        }
    }

    /* renamed from: com.google.api.Page$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Page.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Page();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.subpages_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                Page page = (Page) obj2;
                this.name_ = mergeFromVisitor.visitString(!this.name_.isEmpty(), this.name_, !page.name_.isEmpty(), page.name_);
                this.content_ = mergeFromVisitor.visitString(!this.content_.isEmpty(), this.content_, true ^ page.content_.isEmpty(), page.content_);
                this.subpages_ = mergeFromVisitor.visitList(this.subpages_, page.subpages_);
                if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= page.bitField0_;
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.content_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                if (!this.subpages_.isModifiable()) {
                                    this.subpages_ = GeneratedMessageLite.mutableCopy(this.subpages_);
                                }
                                this.subpages_.add(codedInputStream.readMessage(parser(), extensionRegistryLite));
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
                    synchronized (Page.class) {
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

    public static Page getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Page> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
