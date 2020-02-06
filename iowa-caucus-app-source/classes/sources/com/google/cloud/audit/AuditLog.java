package com.google.cloud.audit;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.AuthorizationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class AuditLog extends GeneratedMessageLite<AuditLog, Builder> implements AuditLogOrBuilder {
    public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
    public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
    /* access modifiers changed from: private */
    public static final AuditLog DEFAULT_INSTANCE = new AuditLog();
    public static final int METHOD_NAME_FIELD_NUMBER = 8;
    public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
    private static volatile Parser<AuditLog> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 16;
    public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
    public static final int RESPONSE_FIELD_NUMBER = 17;
    public static final int SERVICE_DATA_FIELD_NUMBER = 15;
    public static final int SERVICE_NAME_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 2;
    private AuthenticationInfo authenticationInfo_;
    private Internal.ProtobufList<AuthorizationInfo> authorizationInfo_ = emptyProtobufList();
    private int bitField0_;
    private String methodName_ = "";
    private long numResponseItems_;
    private RequestMetadata requestMetadata_;
    private Struct request_;
    private String resourceName_ = "";
    private Struct response_;
    private Any serviceData_;
    private String serviceName_ = "";
    private Status status_;

    private AuditLog() {
    }

    public String getServiceName() {
        return this.serviceName_;
    }

    public ByteString getServiceNameBytes() {
        return ByteString.copyFromUtf8(this.serviceName_);
    }

    /* access modifiers changed from: private */
    public void setServiceName(String str) {
        if (str != null) {
            this.serviceName_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearServiceName() {
        this.serviceName_ = getDefaultInstance().getServiceName();
    }

    /* access modifiers changed from: private */
    public void setServiceNameBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.serviceName_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getMethodName() {
        return this.methodName_;
    }

    public ByteString getMethodNameBytes() {
        return ByteString.copyFromUtf8(this.methodName_);
    }

    /* access modifiers changed from: private */
    public void setMethodName(String str) {
        if (str != null) {
            this.methodName_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearMethodName() {
        this.methodName_ = getDefaultInstance().getMethodName();
    }

    /* access modifiers changed from: private */
    public void setMethodNameBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.methodName_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getResourceName() {
        return this.resourceName_;
    }

    public ByteString getResourceNameBytes() {
        return ByteString.copyFromUtf8(this.resourceName_);
    }

    /* access modifiers changed from: private */
    public void setResourceName(String str) {
        if (str != null) {
            this.resourceName_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearResourceName() {
        this.resourceName_ = getDefaultInstance().getResourceName();
    }

    /* access modifiers changed from: private */
    public void setResourceNameBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.resourceName_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public long getNumResponseItems() {
        return this.numResponseItems_;
    }

    /* access modifiers changed from: private */
    public void setNumResponseItems(long j) {
        this.numResponseItems_ = j;
    }

    /* access modifiers changed from: private */
    public void clearNumResponseItems() {
        this.numResponseItems_ = 0;
    }

    public boolean hasStatus() {
        return this.status_ != null;
    }

    public Status getStatus() {
        Status status = this.status_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    /* access modifiers changed from: private */
    public void setStatus(Status status) {
        if (status != null) {
            this.status_ = status;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setStatus(Status.Builder builder) {
        this.status_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeStatus(Status status) {
        Status status2 = this.status_;
        if (status2 == null || status2 == Status.getDefaultInstance()) {
            this.status_ = status;
        } else {
            this.status_ = Status.newBuilder(this.status_).mergeFrom(status).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = null;
    }

    public boolean hasAuthenticationInfo() {
        return this.authenticationInfo_ != null;
    }

    public AuthenticationInfo getAuthenticationInfo() {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        return authenticationInfo == null ? AuthenticationInfo.getDefaultInstance() : authenticationInfo;
    }

    /* access modifiers changed from: private */
    public void setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        if (authenticationInfo != null) {
            this.authenticationInfo_ = authenticationInfo;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setAuthenticationInfo(AuthenticationInfo.Builder builder) {
        this.authenticationInfo_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
        if (authenticationInfo2 == null || authenticationInfo2 == AuthenticationInfo.getDefaultInstance()) {
            this.authenticationInfo_ = authenticationInfo;
        } else {
            this.authenticationInfo_ = AuthenticationInfo.newBuilder(this.authenticationInfo_).mergeFrom(authenticationInfo).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAuthenticationInfo() {
        this.authenticationInfo_ = null;
    }

    public List<AuthorizationInfo> getAuthorizationInfoList() {
        return this.authorizationInfo_;
    }

    public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
        return this.authorizationInfo_;
    }

    public int getAuthorizationInfoCount() {
        return this.authorizationInfo_.size();
    }

    public AuthorizationInfo getAuthorizationInfo(int i) {
        return (AuthorizationInfo) this.authorizationInfo_.get(i);
    }

    public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i) {
        return (AuthorizationInfoOrBuilder) this.authorizationInfo_.get(i);
    }

    private void ensureAuthorizationInfoIsMutable() {
        if (!this.authorizationInfo_.isModifiable()) {
            this.authorizationInfo_ = GeneratedMessageLite.mutableCopy(this.authorizationInfo_);
        }
    }

    /* access modifiers changed from: private */
    public void setAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
        if (authorizationInfo != null) {
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.set(i, authorizationInfo);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
        if (authorizationInfo != null) {
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.add(authorizationInfo);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
        if (authorizationInfo != null) {
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.add(i, authorizationInfo);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(AuthorizationInfo.Builder builder) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
        ensureAuthorizationInfoIsMutable();
        AbstractMessageLite.addAll(iterable, this.authorizationInfo_);
    }

    /* access modifiers changed from: private */
    public void clearAuthorizationInfo() {
        this.authorizationInfo_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeAuthorizationInfo(int i) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.remove(i);
    }

    public boolean hasRequestMetadata() {
        return this.requestMetadata_ != null;
    }

    public RequestMetadata getRequestMetadata() {
        RequestMetadata requestMetadata = this.requestMetadata_;
        return requestMetadata == null ? RequestMetadata.getDefaultInstance() : requestMetadata;
    }

    /* access modifiers changed from: private */
    public void setRequestMetadata(RequestMetadata requestMetadata) {
        if (requestMetadata != null) {
            this.requestMetadata_ = requestMetadata;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setRequestMetadata(RequestMetadata.Builder builder) {
        this.requestMetadata_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeRequestMetadata(RequestMetadata requestMetadata) {
        RequestMetadata requestMetadata2 = this.requestMetadata_;
        if (requestMetadata2 == null || requestMetadata2 == RequestMetadata.getDefaultInstance()) {
            this.requestMetadata_ = requestMetadata;
        } else {
            this.requestMetadata_ = RequestMetadata.newBuilder(this.requestMetadata_).mergeFrom(requestMetadata).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRequestMetadata() {
        this.requestMetadata_ = null;
    }

    public boolean hasRequest() {
        return this.request_ != null;
    }

    public Struct getRequest() {
        Struct struct = this.request_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* access modifiers changed from: private */
    public void setRequest(Struct struct) {
        if (struct != null) {
            this.request_ = struct;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setRequest(Struct.Builder builder) {
        this.request_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeRequest(Struct struct) {
        Struct struct2 = this.request_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.request_ = struct;
        } else {
            this.request_ = Struct.newBuilder(this.request_).mergeFrom(struct).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRequest() {
        this.request_ = null;
    }

    public boolean hasResponse() {
        return this.response_ != null;
    }

    public Struct getResponse() {
        Struct struct = this.response_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* access modifiers changed from: private */
    public void setResponse(Struct struct) {
        if (struct != null) {
            this.response_ = struct;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setResponse(Struct.Builder builder) {
        this.response_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeResponse(Struct struct) {
        Struct struct2 = this.response_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.response_ = struct;
        } else {
            this.response_ = Struct.newBuilder(this.response_).mergeFrom(struct).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearResponse() {
        this.response_ = null;
    }

    public boolean hasServiceData() {
        return this.serviceData_ != null;
    }

    public Any getServiceData() {
        Any any = this.serviceData_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* access modifiers changed from: private */
    public void setServiceData(Any any) {
        if (any != null) {
            this.serviceData_ = any;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setServiceData(Any.Builder builder) {
        this.serviceData_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeServiceData(Any any) {
        Any any2 = this.serviceData_;
        if (any2 == null || any2 == Any.getDefaultInstance()) {
            this.serviceData_ = any;
        } else {
            this.serviceData_ = Any.newBuilder(this.serviceData_).mergeFrom(any).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearServiceData() {
        this.serviceData_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.status_ != null) {
            codedOutputStream.writeMessage(2, getStatus());
        }
        if (this.authenticationInfo_ != null) {
            codedOutputStream.writeMessage(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            codedOutputStream.writeMessage(4, getRequestMetadata());
        }
        if (!this.serviceName_.isEmpty()) {
            codedOutputStream.writeString(7, getServiceName());
        }
        if (!this.methodName_.isEmpty()) {
            codedOutputStream.writeString(8, getMethodName());
        }
        for (int i = 0; i < this.authorizationInfo_.size(); i++) {
            codedOutputStream.writeMessage(9, (MessageLite) this.authorizationInfo_.get(i));
        }
        if (!this.resourceName_.isEmpty()) {
            codedOutputStream.writeString(11, getResourceName());
        }
        long j = this.numResponseItems_;
        if (j != 0) {
            codedOutputStream.writeInt64(12, j);
        }
        if (this.serviceData_ != null) {
            codedOutputStream.writeMessage(15, getServiceData());
        }
        if (this.request_ != null) {
            codedOutputStream.writeMessage(16, getRequest());
        }
        if (this.response_ != null) {
            codedOutputStream.writeMessage(17, getResponse());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.status_ != null ? CodedOutputStream.computeMessageSize(2, getStatus()) + 0 : 0;
        if (this.authenticationInfo_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, getRequestMetadata());
        }
        if (!this.serviceName_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeStringSize(7, getServiceName());
        }
        if (!this.methodName_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeStringSize(8, getMethodName());
        }
        for (int i2 = 0; i2 < this.authorizationInfo_.size(); i2++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(9, (MessageLite) this.authorizationInfo_.get(i2));
        }
        if (!this.resourceName_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeStringSize(11, getResourceName());
        }
        long j = this.numResponseItems_;
        if (j != 0) {
            computeMessageSize += CodedOutputStream.computeInt64Size(12, j);
        }
        if (this.serviceData_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(15, getServiceData());
        }
        if (this.request_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(16, getRequest());
        }
        if (this.response_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(17, getResponse());
        }
        this.memoizedSerializedSize = computeMessageSize;
        return computeMessageSize;
    }

    public static AuditLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuditLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuditLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuditLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuditLog parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuditLog auditLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(auditLog);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuditLog, Builder> implements AuditLogOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(AuditLog.DEFAULT_INSTANCE);
        }

        public String getServiceName() {
            return this.instance.getServiceName();
        }

        public ByteString getServiceNameBytes() {
            return this.instance.getServiceNameBytes();
        }

        public Builder setServiceName(String str) {
            copyOnWrite();
            this.instance.setServiceName(str);
            return this;
        }

        public Builder clearServiceName() {
            copyOnWrite();
            this.instance.clearServiceName();
            return this;
        }

        public Builder setServiceNameBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setServiceNameBytes(byteString);
            return this;
        }

        public String getMethodName() {
            return this.instance.getMethodName();
        }

        public ByteString getMethodNameBytes() {
            return this.instance.getMethodNameBytes();
        }

        public Builder setMethodName(String str) {
            copyOnWrite();
            this.instance.setMethodName(str);
            return this;
        }

        public Builder clearMethodName() {
            copyOnWrite();
            this.instance.clearMethodName();
            return this;
        }

        public Builder setMethodNameBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setMethodNameBytes(byteString);
            return this;
        }

        public String getResourceName() {
            return this.instance.getResourceName();
        }

        public ByteString getResourceNameBytes() {
            return this.instance.getResourceNameBytes();
        }

        public Builder setResourceName(String str) {
            copyOnWrite();
            this.instance.setResourceName(str);
            return this;
        }

        public Builder clearResourceName() {
            copyOnWrite();
            this.instance.clearResourceName();
            return this;
        }

        public Builder setResourceNameBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setResourceNameBytes(byteString);
            return this;
        }

        public long getNumResponseItems() {
            return this.instance.getNumResponseItems();
        }

        public Builder setNumResponseItems(long j) {
            copyOnWrite();
            this.instance.setNumResponseItems(j);
            return this;
        }

        public Builder clearNumResponseItems() {
            copyOnWrite();
            this.instance.clearNumResponseItems();
            return this;
        }

        public boolean hasStatus() {
            return this.instance.hasStatus();
        }

        public Status getStatus() {
            return this.instance.getStatus();
        }

        public Builder setStatus(Status status) {
            copyOnWrite();
            this.instance.setStatus(status);
            return this;
        }

        public Builder setStatus(Status.Builder builder) {
            copyOnWrite();
            this.instance.setStatus(builder);
            return this;
        }

        public Builder mergeStatus(Status status) {
            copyOnWrite();
            this.instance.mergeStatus(status);
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            this.instance.clearStatus();
            return this;
        }

        public boolean hasAuthenticationInfo() {
            return this.instance.hasAuthenticationInfo();
        }

        public AuthenticationInfo getAuthenticationInfo() {
            return this.instance.getAuthenticationInfo();
        }

        public Builder setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            copyOnWrite();
            this.instance.setAuthenticationInfo(authenticationInfo);
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo.Builder builder) {
            copyOnWrite();
            this.instance.setAuthenticationInfo(builder);
            return this;
        }

        public Builder mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            copyOnWrite();
            this.instance.mergeAuthenticationInfo(authenticationInfo);
            return this;
        }

        public Builder clearAuthenticationInfo() {
            copyOnWrite();
            this.instance.clearAuthenticationInfo();
            return this;
        }

        public List<AuthorizationInfo> getAuthorizationInfoList() {
            return Collections.unmodifiableList(this.instance.getAuthorizationInfoList());
        }

        public int getAuthorizationInfoCount() {
            return this.instance.getAuthorizationInfoCount();
        }

        public AuthorizationInfo getAuthorizationInfo(int i) {
            return this.instance.getAuthorizationInfo(i);
        }

        public Builder setAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            copyOnWrite();
            this.instance.setAuthorizationInfo(i, authorizationInfo);
            return this;
        }

        public Builder setAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            copyOnWrite();
            this.instance.setAuthorizationInfo(i, builder);
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
            copyOnWrite();
            this.instance.addAuthorizationInfo(authorizationInfo);
            return this;
        }

        public Builder addAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            copyOnWrite();
            this.instance.addAuthorizationInfo(i, authorizationInfo);
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo.Builder builder) {
            copyOnWrite();
            this.instance.addAuthorizationInfo(builder);
            return this;
        }

        public Builder addAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            copyOnWrite();
            this.instance.addAuthorizationInfo(i, builder);
            return this;
        }

        public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
            copyOnWrite();
            this.instance.addAllAuthorizationInfo(iterable);
            return this;
        }

        public Builder clearAuthorizationInfo() {
            copyOnWrite();
            this.instance.clearAuthorizationInfo();
            return this;
        }

        public Builder removeAuthorizationInfo(int i) {
            copyOnWrite();
            this.instance.removeAuthorizationInfo(i);
            return this;
        }

        public boolean hasRequestMetadata() {
            return this.instance.hasRequestMetadata();
        }

        public RequestMetadata getRequestMetadata() {
            return this.instance.getRequestMetadata();
        }

        public Builder setRequestMetadata(RequestMetadata requestMetadata) {
            copyOnWrite();
            this.instance.setRequestMetadata(requestMetadata);
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata.Builder builder) {
            copyOnWrite();
            this.instance.setRequestMetadata(builder);
            return this;
        }

        public Builder mergeRequestMetadata(RequestMetadata requestMetadata) {
            copyOnWrite();
            this.instance.mergeRequestMetadata(requestMetadata);
            return this;
        }

        public Builder clearRequestMetadata() {
            copyOnWrite();
            this.instance.clearRequestMetadata();
            return this;
        }

        public boolean hasRequest() {
            return this.instance.hasRequest();
        }

        public Struct getRequest() {
            return this.instance.getRequest();
        }

        public Builder setRequest(Struct struct) {
            copyOnWrite();
            this.instance.setRequest(struct);
            return this;
        }

        public Builder setRequest(Struct.Builder builder) {
            copyOnWrite();
            this.instance.setRequest(builder);
            return this;
        }

        public Builder mergeRequest(Struct struct) {
            copyOnWrite();
            this.instance.mergeRequest(struct);
            return this;
        }

        public Builder clearRequest() {
            copyOnWrite();
            this.instance.clearRequest();
            return this;
        }

        public boolean hasResponse() {
            return this.instance.hasResponse();
        }

        public Struct getResponse() {
            return this.instance.getResponse();
        }

        public Builder setResponse(Struct struct) {
            copyOnWrite();
            this.instance.setResponse(struct);
            return this;
        }

        public Builder setResponse(Struct.Builder builder) {
            copyOnWrite();
            this.instance.setResponse(builder);
            return this;
        }

        public Builder mergeResponse(Struct struct) {
            copyOnWrite();
            this.instance.mergeResponse(struct);
            return this;
        }

        public Builder clearResponse() {
            copyOnWrite();
            this.instance.clearResponse();
            return this;
        }

        public boolean hasServiceData() {
            return this.instance.hasServiceData();
        }

        public Any getServiceData() {
            return this.instance.getServiceData();
        }

        public Builder setServiceData(Any any) {
            copyOnWrite();
            this.instance.setServiceData(any);
            return this;
        }

        public Builder setServiceData(Any.Builder builder) {
            copyOnWrite();
            this.instance.setServiceData(builder);
            return this;
        }

        public Builder mergeServiceData(Any any) {
            copyOnWrite();
            this.instance.mergeServiceData(any);
            return this;
        }

        public Builder clearServiceData() {
            copyOnWrite();
            this.instance.clearServiceData();
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.AuditLog$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.AuditLog.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AuditLog();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.authorizationInfo_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                AuditLog auditLog = (AuditLog) obj2;
                this.serviceName_ = mergeFromVisitor.visitString(!this.serviceName_.isEmpty(), this.serviceName_, !auditLog.serviceName_.isEmpty(), auditLog.serviceName_);
                this.methodName_ = mergeFromVisitor.visitString(!this.methodName_.isEmpty(), this.methodName_, !auditLog.methodName_.isEmpty(), auditLog.methodName_);
                this.resourceName_ = mergeFromVisitor.visitString(!this.resourceName_.isEmpty(), this.resourceName_, !auditLog.resourceName_.isEmpty(), auditLog.resourceName_);
                this.numResponseItems_ = mergeFromVisitor.visitLong(this.numResponseItems_ != 0, this.numResponseItems_, auditLog.numResponseItems_ != 0, auditLog.numResponseItems_);
                this.status_ = mergeFromVisitor.visitMessage(this.status_, auditLog.status_);
                this.authenticationInfo_ = mergeFromVisitor.visitMessage(this.authenticationInfo_, auditLog.authenticationInfo_);
                this.authorizationInfo_ = mergeFromVisitor.visitList(this.authorizationInfo_, auditLog.authorizationInfo_);
                this.requestMetadata_ = mergeFromVisitor.visitMessage(this.requestMetadata_, auditLog.requestMetadata_);
                this.request_ = mergeFromVisitor.visitMessage(this.request_, auditLog.request_);
                this.response_ = mergeFromVisitor.visitMessage(this.response_, auditLog.response_);
                this.serviceData_ = mergeFromVisitor.visitMessage(this.serviceData_, auditLog.serviceData_);
                if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= auditLog.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 18:
                                Status.Builder builder = this.status_ != null ? (Status.Builder) this.status_.toBuilder() : null;
                                this.status_ = codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                                if (builder == null) {
                                    break;
                                } else {
                                    builder.mergeFrom(this.status_);
                                    this.status_ = builder.buildPartial();
                                    break;
                                }
                            case 26:
                                AuthenticationInfo.Builder builder2 = this.authenticationInfo_ != null ? (AuthenticationInfo.Builder) this.authenticationInfo_.toBuilder() : null;
                                this.authenticationInfo_ = codedInputStream.readMessage(AuthenticationInfo.parser(), extensionRegistryLite);
                                if (builder2 == null) {
                                    break;
                                } else {
                                    builder2.mergeFrom(this.authenticationInfo_);
                                    this.authenticationInfo_ = builder2.buildPartial();
                                    break;
                                }
                            case 34:
                                RequestMetadata.Builder builder3 = this.requestMetadata_ != null ? (RequestMetadata.Builder) this.requestMetadata_.toBuilder() : null;
                                this.requestMetadata_ = codedInputStream.readMessage(RequestMetadata.parser(), extensionRegistryLite);
                                if (builder3 == null) {
                                    break;
                                } else {
                                    builder3.mergeFrom(this.requestMetadata_);
                                    this.requestMetadata_ = builder3.buildPartial();
                                    break;
                                }
                            case 58:
                                this.serviceName_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 66:
                                this.methodName_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 74:
                                if (!this.authorizationInfo_.isModifiable()) {
                                    this.authorizationInfo_ = GeneratedMessageLite.mutableCopy(this.authorizationInfo_);
                                }
                                this.authorizationInfo_.add(codedInputStream.readMessage(AuthorizationInfo.parser(), extensionRegistryLite));
                                break;
                            case 90:
                                this.resourceName_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 96:
                                this.numResponseItems_ = codedInputStream.readInt64();
                                break;
                            case 122:
                                Any.Builder builder4 = this.serviceData_ != null ? (Any.Builder) this.serviceData_.toBuilder() : null;
                                this.serviceData_ = codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                if (builder4 == null) {
                                    break;
                                } else {
                                    builder4.mergeFrom(this.serviceData_);
                                    this.serviceData_ = builder4.buildPartial();
                                    break;
                                }
                            case NikonType2MakernoteDirectory.TAG_ADAPTER:
                                Struct.Builder builder5 = this.request_ != null ? (Struct.Builder) this.request_.toBuilder() : null;
                                this.request_ = codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                if (builder5 == null) {
                                    break;
                                } else {
                                    builder5.mergeFrom(this.request_);
                                    this.request_ = builder5.buildPartial();
                                    break;
                                }
                            case 138:
                                Struct.Builder builder6 = this.response_ != null ? (Struct.Builder) this.response_.toBuilder() : null;
                                this.response_ = codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                if (builder6 == null) {
                                    break;
                                } else {
                                    builder6.mergeFrom(this.response_);
                                    this.response_ = builder6.buildPartial();
                                    break;
                                }
                            default:
                                if (codedInputStream.skipField(readTag)) {
                                    break;
                                }
                                z = true;
                                break;
                        }
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
                    synchronized (AuditLog.class) {
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

    public static AuditLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuditLog> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
