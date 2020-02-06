package com.google.api;

import com.google.api.UsageRule;
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
public final class Usage extends GeneratedMessageLite<Usage, Builder> implements UsageOrBuilder {
    /* access modifiers changed from: private */
    public static final Usage DEFAULT_INSTANCE = new Usage();
    private static volatile Parser<Usage> PARSER = null;
    public static final int PRODUCER_NOTIFICATION_CHANNEL_FIELD_NUMBER = 7;
    public static final int REQUIREMENTS_FIELD_NUMBER = 1;
    public static final int RULES_FIELD_NUMBER = 6;
    private int bitField0_;
    private String producerNotificationChannel_ = "";
    private Internal.ProtobufList<String> requirements_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<UsageRule> rules_ = emptyProtobufList();

    private Usage() {
    }

    public List<String> getRequirementsList() {
        return this.requirements_;
    }

    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    public String getRequirements(int i) {
        return (String) this.requirements_.get(i);
    }

    public ByteString getRequirementsBytes(int i) {
        return ByteString.copyFromUtf8((String) this.requirements_.get(i));
    }

    private void ensureRequirementsIsMutable() {
        if (!this.requirements_.isModifiable()) {
            this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
        }
    }

    /* access modifiers changed from: private */
    public void setRequirements(int i, String str) {
        if (str != null) {
            ensureRequirementsIsMutable();
            this.requirements_.set(i, str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRequirements(String str) {
        if (str != null) {
            ensureRequirementsIsMutable();
            this.requirements_.add(str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAllRequirements(Iterable<String> iterable) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.addAll(iterable, this.requirements_);
    }

    /* access modifiers changed from: private */
    public void clearRequirements() {
        this.requirements_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addRequirementsBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            ensureRequirementsIsMutable();
            this.requirements_.add(byteString.toStringUtf8());
            return;
        }
        throw new NullPointerException();
    }

    public List<UsageRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends UsageRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public UsageRule getRules(int i) {
        return (UsageRule) this.rules_.get(i);
    }

    public UsageRuleOrBuilder getRulesOrBuilder(int i) {
        return (UsageRuleOrBuilder) this.rules_.get(i);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int i, UsageRule usageRule) {
        if (usageRule != null) {
            ensureRulesIsMutable();
            this.rules_.set(i, usageRule);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setRules(int i, UsageRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addRules(UsageRule usageRule) {
        if (usageRule != null) {
            ensureRulesIsMutable();
            this.rules_.add(usageRule);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRules(int i, UsageRule usageRule) {
        if (usageRule != null) {
            ensureRulesIsMutable();
            this.rules_.add(i, usageRule);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRules(UsageRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int i, UsageRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends UsageRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll(iterable, this.rules_);
    }

    /* access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    public String getProducerNotificationChannel() {
        return this.producerNotificationChannel_;
    }

    public ByteString getProducerNotificationChannelBytes() {
        return ByteString.copyFromUtf8(this.producerNotificationChannel_);
    }

    /* access modifiers changed from: private */
    public void setProducerNotificationChannel(String str) {
        if (str != null) {
            this.producerNotificationChannel_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearProducerNotificationChannel() {
        this.producerNotificationChannel_ = getDefaultInstance().getProducerNotificationChannel();
    }

    /* access modifiers changed from: private */
    public void setProducerNotificationChannelBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.producerNotificationChannel_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.requirements_.size(); i++) {
            codedOutputStream.writeString(1, (String) this.requirements_.get(i));
        }
        for (int i2 = 0; i2 < this.rules_.size(); i2++) {
            codedOutputStream.writeMessage(6, (MessageLite) this.rules_.get(i2));
        }
        if (!this.producerNotificationChannel_.isEmpty()) {
            codedOutputStream.writeString(7, getProducerNotificationChannel());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.requirements_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag((String) this.requirements_.get(i3));
        }
        int size = i2 + 0 + (getRequirementsList().size() * 1);
        for (int i4 = 0; i4 < this.rules_.size(); i4++) {
            size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.rules_.get(i4));
        }
        if (!this.producerNotificationChannel_.isEmpty()) {
            size += CodedOutputStream.computeStringSize(7, getProducerNotificationChannel());
        }
        this.memoizedSerializedSize = size;
        return size;
    }

    public static Usage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Usage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Usage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Usage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Usage parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Usage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Usage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Usage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Usage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Usage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Usage usage) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(usage);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Usage, Builder> implements UsageOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Usage.DEFAULT_INSTANCE);
        }

        public List<String> getRequirementsList() {
            return Collections.unmodifiableList(this.instance.getRequirementsList());
        }

        public int getRequirementsCount() {
            return this.instance.getRequirementsCount();
        }

        public String getRequirements(int i) {
            return this.instance.getRequirements(i);
        }

        public ByteString getRequirementsBytes(int i) {
            return this.instance.getRequirementsBytes(i);
        }

        public Builder setRequirements(int i, String str) {
            copyOnWrite();
            this.instance.setRequirements(i, str);
            return this;
        }

        public Builder addRequirements(String str) {
            copyOnWrite();
            this.instance.addRequirements(str);
            return this;
        }

        public Builder addAllRequirements(Iterable<String> iterable) {
            copyOnWrite();
            this.instance.addAllRequirements(iterable);
            return this;
        }

        public Builder clearRequirements() {
            copyOnWrite();
            this.instance.clearRequirements();
            return this;
        }

        public Builder addRequirementsBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.addRequirementsBytes(byteString);
            return this;
        }

        public List<UsageRule> getRulesList() {
            return Collections.unmodifiableList(this.instance.getRulesList());
        }

        public int getRulesCount() {
            return this.instance.getRulesCount();
        }

        public UsageRule getRules(int i) {
            return this.instance.getRules(i);
        }

        public Builder setRules(int i, UsageRule usageRule) {
            copyOnWrite();
            this.instance.setRules(i, usageRule);
            return this;
        }

        public Builder setRules(int i, UsageRule.Builder builder) {
            copyOnWrite();
            this.instance.setRules(i, builder);
            return this;
        }

        public Builder addRules(UsageRule usageRule) {
            copyOnWrite();
            this.instance.addRules(usageRule);
            return this;
        }

        public Builder addRules(int i, UsageRule usageRule) {
            copyOnWrite();
            this.instance.addRules(i, usageRule);
            return this;
        }

        public Builder addRules(UsageRule.Builder builder) {
            copyOnWrite();
            this.instance.addRules(builder);
            return this;
        }

        public Builder addRules(int i, UsageRule.Builder builder) {
            copyOnWrite();
            this.instance.addRules(i, builder);
            return this;
        }

        public Builder addAllRules(Iterable<? extends UsageRule> iterable) {
            copyOnWrite();
            this.instance.addAllRules(iterable);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            this.instance.clearRules();
            return this;
        }

        public Builder removeRules(int i) {
            copyOnWrite();
            this.instance.removeRules(i);
            return this;
        }

        public String getProducerNotificationChannel() {
            return this.instance.getProducerNotificationChannel();
        }

        public ByteString getProducerNotificationChannelBytes() {
            return this.instance.getProducerNotificationChannelBytes();
        }

        public Builder setProducerNotificationChannel(String str) {
            copyOnWrite();
            this.instance.setProducerNotificationChannel(str);
            return this;
        }

        public Builder clearProducerNotificationChannel() {
            copyOnWrite();
            this.instance.clearProducerNotificationChannel();
            return this;
        }

        public Builder setProducerNotificationChannelBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setProducerNotificationChannelBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.Usage$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Usage.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Usage();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requirements_.makeImmutable();
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                Usage usage = (Usage) obj2;
                this.requirements_ = mergeFromVisitor.visitList(this.requirements_, usage.requirements_);
                this.rules_ = mergeFromVisitor.visitList(this.rules_, usage.rules_);
                this.producerNotificationChannel_ = mergeFromVisitor.visitString(!this.producerNotificationChannel_.isEmpty(), this.producerNotificationChannel_, true ^ usage.producerNotificationChannel_.isEmpty(), usage.producerNotificationChannel_);
                if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= usage.bitField0_;
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
                                if (!this.requirements_.isModifiable()) {
                                    this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
                                }
                                this.requirements_.add(readStringRequireUtf8);
                            } else if (readTag == 50) {
                                if (!this.rules_.isModifiable()) {
                                    this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
                                }
                                this.rules_.add(codedInputStream.readMessage(UsageRule.parser(), extensionRegistryLite));
                            } else if (readTag == 58) {
                                this.producerNotificationChannel_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (Usage.class) {
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

    public static Usage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Usage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
