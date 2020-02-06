package com.google.api;

import com.google.api.Property;
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
public final class ProjectProperties extends GeneratedMessageLite<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
    /* access modifiers changed from: private */
    public static final ProjectProperties DEFAULT_INSTANCE = new ProjectProperties();
    private static volatile Parser<ProjectProperties> PARSER = null;
    public static final int PROPERTIES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Property> properties_ = emptyProtobufList();

    private ProjectProperties() {
    }

    public List<Property> getPropertiesList() {
        return this.properties_;
    }

    public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
        return this.properties_;
    }

    public int getPropertiesCount() {
        return this.properties_.size();
    }

    public Property getProperties(int i) {
        return (Property) this.properties_.get(i);
    }

    public PropertyOrBuilder getPropertiesOrBuilder(int i) {
        return (PropertyOrBuilder) this.properties_.get(i);
    }

    private void ensurePropertiesIsMutable() {
        if (!this.properties_.isModifiable()) {
            this.properties_ = GeneratedMessageLite.mutableCopy(this.properties_);
        }
    }

    /* access modifiers changed from: private */
    public void setProperties(int i, Property property) {
        if (property != null) {
            ensurePropertiesIsMutable();
            this.properties_.set(i, property);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setProperties(int i, Property.Builder builder) {
        ensurePropertiesIsMutable();
        this.properties_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addProperties(Property property) {
        if (property != null) {
            ensurePropertiesIsMutable();
            this.properties_.add(property);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addProperties(int i, Property property) {
        if (property != null) {
            ensurePropertiesIsMutable();
            this.properties_.add(i, property);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addProperties(Property.Builder builder) {
        ensurePropertiesIsMutable();
        this.properties_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addProperties(int i, Property.Builder builder) {
        ensurePropertiesIsMutable();
        this.properties_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllProperties(Iterable<? extends Property> iterable) {
        ensurePropertiesIsMutable();
        AbstractMessageLite.addAll(iterable, this.properties_);
    }

    /* access modifiers changed from: private */
    public void clearProperties() {
        this.properties_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeProperties(int i) {
        ensurePropertiesIsMutable();
        this.properties_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.properties_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.properties_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.properties_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.properties_.get(i3));
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static ProjectProperties parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ProjectProperties parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ProjectProperties parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ProjectProperties parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ProjectProperties parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ProjectProperties projectProperties) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(projectProperties);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(ProjectProperties.DEFAULT_INSTANCE);
        }

        public List<Property> getPropertiesList() {
            return Collections.unmodifiableList(this.instance.getPropertiesList());
        }

        public int getPropertiesCount() {
            return this.instance.getPropertiesCount();
        }

        public Property getProperties(int i) {
            return this.instance.getProperties(i);
        }

        public Builder setProperties(int i, Property property) {
            copyOnWrite();
            this.instance.setProperties(i, property);
            return this;
        }

        public Builder setProperties(int i, Property.Builder builder) {
            copyOnWrite();
            this.instance.setProperties(i, builder);
            return this;
        }

        public Builder addProperties(Property property) {
            copyOnWrite();
            this.instance.addProperties(property);
            return this;
        }

        public Builder addProperties(int i, Property property) {
            copyOnWrite();
            this.instance.addProperties(i, property);
            return this;
        }

        public Builder addProperties(Property.Builder builder) {
            copyOnWrite();
            this.instance.addProperties(builder);
            return this;
        }

        public Builder addProperties(int i, Property.Builder builder) {
            copyOnWrite();
            this.instance.addProperties(i, builder);
            return this;
        }

        public Builder addAllProperties(Iterable<? extends Property> iterable) {
            copyOnWrite();
            this.instance.addAllProperties(iterable);
            return this;
        }

        public Builder clearProperties() {
            copyOnWrite();
            this.instance.clearProperties();
            return this;
        }

        public Builder removeProperties(int i) {
            copyOnWrite();
            this.instance.removeProperties(i);
            return this;
        }
    }

    /* renamed from: com.google.api.ProjectProperties$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.ProjectProperties.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ProjectProperties();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.properties_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.properties_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.properties_, ((ProjectProperties) obj2).properties_);
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
                                if (!this.properties_.isModifiable()) {
                                    this.properties_ = GeneratedMessageLite.mutableCopy(this.properties_);
                                }
                                this.properties_.add(codedInputStream.readMessage(Property.parser(), extensionRegistryLite));
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
                    synchronized (ProjectProperties.class) {
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

    public static ProjectProperties getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ProjectProperties> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
