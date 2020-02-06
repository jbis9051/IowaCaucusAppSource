package com.google.api;

import com.google.api.AuthRequirement;
import com.google.api.OAuthRequirements;
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
public final class AuthenticationRule extends GeneratedMessageLite<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
    public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */
    public static final AuthenticationRule DEFAULT_INSTANCE = new AuthenticationRule();
    public static final int OAUTH_FIELD_NUMBER = 2;
    private static volatile Parser<AuthenticationRule> PARSER = null;
    public static final int REQUIREMENTS_FIELD_NUMBER = 7;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private boolean allowWithoutCredential_;
    private int bitField0_;
    private OAuthRequirements oauth_;
    private Internal.ProtobufList<AuthRequirement> requirements_ = emptyProtobufList();
    private String selector_ = "";

    private AuthenticationRule() {
    }

    public String getSelector() {
        return this.selector_;
    }

    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* access modifiers changed from: private */
    public void setSelector(String str) {
        if (str != null) {
            this.selector_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* access modifiers changed from: private */
    public void setSelectorBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.selector_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public boolean hasOauth() {
        return this.oauth_ != null;
    }

    public OAuthRequirements getOauth() {
        OAuthRequirements oAuthRequirements = this.oauth_;
        return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
    }

    /* access modifiers changed from: private */
    public void setOauth(OAuthRequirements oAuthRequirements) {
        if (oAuthRequirements != null) {
            this.oauth_ = oAuthRequirements;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setOauth(OAuthRequirements.Builder builder) {
        this.oauth_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeOauth(OAuthRequirements oAuthRequirements) {
        OAuthRequirements oAuthRequirements2 = this.oauth_;
        if (oAuthRequirements2 == null || oAuthRequirements2 == OAuthRequirements.getDefaultInstance()) {
            this.oauth_ = oAuthRequirements;
        } else {
            this.oauth_ = OAuthRequirements.newBuilder(this.oauth_).mergeFrom(oAuthRequirements).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearOauth() {
        this.oauth_ = null;
    }

    public boolean getAllowWithoutCredential() {
        return this.allowWithoutCredential_;
    }

    /* access modifiers changed from: private */
    public void setAllowWithoutCredential(boolean z) {
        this.allowWithoutCredential_ = z;
    }

    /* access modifiers changed from: private */
    public void clearAllowWithoutCredential() {
        this.allowWithoutCredential_ = false;
    }

    public List<AuthRequirement> getRequirementsList() {
        return this.requirements_;
    }

    public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
        return this.requirements_;
    }

    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    public AuthRequirement getRequirements(int i) {
        return (AuthRequirement) this.requirements_.get(i);
    }

    public AuthRequirementOrBuilder getRequirementsOrBuilder(int i) {
        return (AuthRequirementOrBuilder) this.requirements_.get(i);
    }

    private void ensureRequirementsIsMutable() {
        if (!this.requirements_.isModifiable()) {
            this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
        }
    }

    /* access modifiers changed from: private */
    public void setRequirements(int i, AuthRequirement authRequirement) {
        if (authRequirement != null) {
            ensureRequirementsIsMutable();
            this.requirements_.set(i, authRequirement);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setRequirements(int i, AuthRequirement.Builder builder) {
        ensureRequirementsIsMutable();
        this.requirements_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addRequirements(AuthRequirement authRequirement) {
        if (authRequirement != null) {
            ensureRequirementsIsMutable();
            this.requirements_.add(authRequirement);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRequirements(int i, AuthRequirement authRequirement) {
        if (authRequirement != null) {
            ensureRequirementsIsMutable();
            this.requirements_.add(i, authRequirement);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRequirements(AuthRequirement.Builder builder) {
        ensureRequirementsIsMutable();
        this.requirements_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addRequirements(int i, AuthRequirement.Builder builder) {
        ensureRequirementsIsMutable();
        this.requirements_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.addAll(iterable, this.requirements_);
    }

    /* access modifiers changed from: private */
    public void clearRequirements() {
        this.requirements_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRequirements(int i) {
        ensureRequirementsIsMutable();
        this.requirements_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        if (this.oauth_ != null) {
            codedOutputStream.writeMessage(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        if (z) {
            codedOutputStream.writeBool(5, z);
        }
        for (int i = 0; i < this.requirements_.size(); i++) {
            codedOutputStream.writeMessage(7, (MessageLite) this.requirements_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.selector_.isEmpty() ? CodedOutputStream.computeStringSize(1, getSelector()) + 0 : 0;
        if (this.oauth_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        if (z) {
            computeStringSize += CodedOutputStream.computeBoolSize(5, z);
        }
        for (int i2 = 0; i2 < this.requirements_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(7, (MessageLite) this.requirements_.get(i2));
        }
        this.memoizedSerializedSize = computeStringSize;
        return computeStringSize;
    }

    public static AuthenticationRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuthenticationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthenticationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthenticationRule authenticationRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(authenticationRule);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(AuthenticationRule.DEFAULT_INSTANCE);
        }

        public String getSelector() {
            return this.instance.getSelector();
        }

        public ByteString getSelectorBytes() {
            return this.instance.getSelectorBytes();
        }

        public Builder setSelector(String str) {
            copyOnWrite();
            this.instance.setSelector(str);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            this.instance.clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setSelectorBytes(byteString);
            return this;
        }

        public boolean hasOauth() {
            return this.instance.hasOauth();
        }

        public OAuthRequirements getOauth() {
            return this.instance.getOauth();
        }

        public Builder setOauth(OAuthRequirements oAuthRequirements) {
            copyOnWrite();
            this.instance.setOauth(oAuthRequirements);
            return this;
        }

        public Builder setOauth(OAuthRequirements.Builder builder) {
            copyOnWrite();
            this.instance.setOauth(builder);
            return this;
        }

        public Builder mergeOauth(OAuthRequirements oAuthRequirements) {
            copyOnWrite();
            this.instance.mergeOauth(oAuthRequirements);
            return this;
        }

        public Builder clearOauth() {
            copyOnWrite();
            this.instance.clearOauth();
            return this;
        }

        public boolean getAllowWithoutCredential() {
            return this.instance.getAllowWithoutCredential();
        }

        public Builder setAllowWithoutCredential(boolean z) {
            copyOnWrite();
            this.instance.setAllowWithoutCredential(z);
            return this;
        }

        public Builder clearAllowWithoutCredential() {
            copyOnWrite();
            this.instance.clearAllowWithoutCredential();
            return this;
        }

        public List<AuthRequirement> getRequirementsList() {
            return Collections.unmodifiableList(this.instance.getRequirementsList());
        }

        public int getRequirementsCount() {
            return this.instance.getRequirementsCount();
        }

        public AuthRequirement getRequirements(int i) {
            return this.instance.getRequirements(i);
        }

        public Builder setRequirements(int i, AuthRequirement authRequirement) {
            copyOnWrite();
            this.instance.setRequirements(i, authRequirement);
            return this;
        }

        public Builder setRequirements(int i, AuthRequirement.Builder builder) {
            copyOnWrite();
            this.instance.setRequirements(i, builder);
            return this;
        }

        public Builder addRequirements(AuthRequirement authRequirement) {
            copyOnWrite();
            this.instance.addRequirements(authRequirement);
            return this;
        }

        public Builder addRequirements(int i, AuthRequirement authRequirement) {
            copyOnWrite();
            this.instance.addRequirements(i, authRequirement);
            return this;
        }

        public Builder addRequirements(AuthRequirement.Builder builder) {
            copyOnWrite();
            this.instance.addRequirements(builder);
            return this;
        }

        public Builder addRequirements(int i, AuthRequirement.Builder builder) {
            copyOnWrite();
            this.instance.addRequirements(i, builder);
            return this;
        }

        public Builder addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
            copyOnWrite();
            this.instance.addAllRequirements(iterable);
            return this;
        }

        public Builder clearRequirements() {
            copyOnWrite();
            this.instance.clearRequirements();
            return this;
        }

        public Builder removeRequirements(int i) {
            copyOnWrite();
            this.instance.removeRequirements(i);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthenticationRule$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.AuthenticationRule.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthenticationRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requirements_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                AuthenticationRule authenticationRule = (AuthenticationRule) obj2;
                this.selector_ = mergeFromVisitor.visitString(!this.selector_.isEmpty(), this.selector_, true ^ authenticationRule.selector_.isEmpty(), authenticationRule.selector_);
                this.oauth_ = mergeFromVisitor.visitMessage(this.oauth_, authenticationRule.oauth_);
                boolean z = this.allowWithoutCredential_;
                boolean z2 = authenticationRule.allowWithoutCredential_;
                this.allowWithoutCredential_ = mergeFromVisitor.visitBoolean(z, z, z2, z2);
                this.requirements_ = mergeFromVisitor.visitList(this.requirements_, authenticationRule.requirements_);
                if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= authenticationRule.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                OAuthRequirements.Builder builder = this.oauth_ != null ? (OAuthRequirements.Builder) this.oauth_.toBuilder() : null;
                                this.oauth_ = codedInputStream.readMessage(OAuthRequirements.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.oauth_);
                                    this.oauth_ = builder.buildPartial();
                                }
                            } else if (readTag == 40) {
                                this.allowWithoutCredential_ = codedInputStream.readBool();
                            } else if (readTag == 58) {
                                if (!this.requirements_.isModifiable()) {
                                    this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
                                }
                                this.requirements_.add(codedInputStream.readMessage(AuthRequirement.parser(), extensionRegistryLite));
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z3 = true;
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
                    synchronized (AuthenticationRule.class) {
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

    public static AuthenticationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthenticationRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
