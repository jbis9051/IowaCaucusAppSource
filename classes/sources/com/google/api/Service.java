package com.google.api;

import com.adobe.xmp.XMPError;
import com.facebook.imageutils.JfifUtil;
import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Experimental;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Service extends GeneratedMessageLite<Service, Builder> implements ServiceOrBuilder {
    public static final int APIS_FIELD_NUMBER = 3;
    public static final int AUTHENTICATION_FIELD_NUMBER = 11;
    public static final int BACKEND_FIELD_NUMBER = 8;
    public static final int BILLING_FIELD_NUMBER = 26;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
    public static final int CONTEXT_FIELD_NUMBER = 12;
    public static final int CONTROL_FIELD_NUMBER = 21;
    /* access modifiers changed from: private */
    public static final Service DEFAULT_INSTANCE = new Service();
    public static final int DOCUMENTATION_FIELD_NUMBER = 6;
    public static final int ENDPOINTS_FIELD_NUMBER = 18;
    public static final int ENUMS_FIELD_NUMBER = 5;
    public static final int EXPERIMENTAL_FIELD_NUMBER = 101;
    public static final int HTTP_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int LOGGING_FIELD_NUMBER = 27;
    public static final int LOGS_FIELD_NUMBER = 23;
    public static final int METRICS_FIELD_NUMBER = 24;
    public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
    public static final int MONITORING_FIELD_NUMBER = 28;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Service> PARSER = null;
    public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
    public static final int QUOTA_FIELD_NUMBER = 10;
    public static final int SOURCE_INFO_FIELD_NUMBER = 37;
    public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int USAGE_FIELD_NUMBER = 15;
    private Internal.ProtobufList<Api> apis_ = emptyProtobufList();
    private Authentication authentication_;
    private Backend backend_;
    private Billing billing_;
    private int bitField0_;
    private UInt32Value configVersion_;
    private Context context_;
    private Control control_;
    private Documentation documentation_;
    private Internal.ProtobufList<Endpoint> endpoints_ = emptyProtobufList();
    private Internal.ProtobufList<Enum> enums_ = emptyProtobufList();
    private Experimental experimental_;
    private Http http_;
    private String id_ = "";
    private Logging logging_;
    private Internal.ProtobufList<LogDescriptor> logs_ = emptyProtobufList();
    private Internal.ProtobufList<MetricDescriptor> metrics_ = emptyProtobufList();
    private Internal.ProtobufList<MonitoredResourceDescriptor> monitoredResources_ = emptyProtobufList();
    private Monitoring monitoring_;
    private String name_ = "";
    private String producerProjectId_ = "";
    private Quota quota_;
    private SourceInfo sourceInfo_;
    private SystemParameters systemParameters_;
    private String title_ = "";
    private Internal.ProtobufList<Type> types_ = emptyProtobufList();
    private Usage usage_;

    private Service() {
    }

    public boolean hasConfigVersion() {
        return this.configVersion_ != null;
    }

    public UInt32Value getConfigVersion() {
        UInt32Value uInt32Value = this.configVersion_;
        return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
    }

    /* access modifiers changed from: private */
    public void setConfigVersion(UInt32Value uInt32Value) {
        if (uInt32Value != null) {
            this.configVersion_ = uInt32Value;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setConfigVersion(UInt32Value.Builder builder) {
        this.configVersion_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeConfigVersion(UInt32Value uInt32Value) {
        UInt32Value uInt32Value2 = this.configVersion_;
        if (uInt32Value2 == null || uInt32Value2 == UInt32Value.getDefaultInstance()) {
            this.configVersion_ = uInt32Value;
        } else {
            this.configVersion_ = UInt32Value.newBuilder(this.configVersion_).mergeFrom(uInt32Value).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearConfigVersion() {
        this.configVersion_ = null;
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

    public String getId() {
        return this.id_;
    }

    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    /* access modifiers changed from: private */
    public void setId(String str) {
        if (str != null) {
            this.id_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.id_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getTitle() {
        return this.title_;
    }

    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    /* access modifiers changed from: private */
    public void setTitle(String str) {
        if (str != null) {
            this.title_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.title_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getProducerProjectId() {
        return this.producerProjectId_;
    }

    public ByteString getProducerProjectIdBytes() {
        return ByteString.copyFromUtf8(this.producerProjectId_);
    }

    /* access modifiers changed from: private */
    public void setProducerProjectId(String str) {
        if (str != null) {
            this.producerProjectId_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearProducerProjectId() {
        this.producerProjectId_ = getDefaultInstance().getProducerProjectId();
    }

    /* access modifiers changed from: private */
    public void setProducerProjectIdBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.producerProjectId_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public List<Api> getApisList() {
        return this.apis_;
    }

    public List<? extends ApiOrBuilder> getApisOrBuilderList() {
        return this.apis_;
    }

    public int getApisCount() {
        return this.apis_.size();
    }

    public Api getApis(int i) {
        return (Api) this.apis_.get(i);
    }

    public ApiOrBuilder getApisOrBuilder(int i) {
        return (ApiOrBuilder) this.apis_.get(i);
    }

    private void ensureApisIsMutable() {
        if (!this.apis_.isModifiable()) {
            this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
        }
    }

    /* access modifiers changed from: private */
    public void setApis(int i, Api api) {
        if (api != null) {
            ensureApisIsMutable();
            this.apis_.set(i, api);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setApis(int i, Api.Builder builder) {
        ensureApisIsMutable();
        this.apis_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addApis(Api api) {
        if (api != null) {
            ensureApisIsMutable();
            this.apis_.add(api);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addApis(int i, Api api) {
        if (api != null) {
            ensureApisIsMutable();
            this.apis_.add(i, api);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addApis(Api.Builder builder) {
        ensureApisIsMutable();
        this.apis_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addApis(int i, Api.Builder builder) {
        ensureApisIsMutable();
        this.apis_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllApis(Iterable<? extends Api> iterable) {
        ensureApisIsMutable();
        AbstractMessageLite.addAll(iterable, this.apis_);
    }

    /* access modifiers changed from: private */
    public void clearApis() {
        this.apis_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeApis(int i) {
        ensureApisIsMutable();
        this.apis_.remove(i);
    }

    public List<Type> getTypesList() {
        return this.types_;
    }

    public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
        return this.types_;
    }

    public int getTypesCount() {
        return this.types_.size();
    }

    public Type getTypes(int i) {
        return (Type) this.types_.get(i);
    }

    public TypeOrBuilder getTypesOrBuilder(int i) {
        return (TypeOrBuilder) this.types_.get(i);
    }

    private void ensureTypesIsMutable() {
        if (!this.types_.isModifiable()) {
            this.types_ = GeneratedMessageLite.mutableCopy(this.types_);
        }
    }

    /* access modifiers changed from: private */
    public void setTypes(int i, Type type) {
        if (type != null) {
            ensureTypesIsMutable();
            this.types_.set(i, type);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setTypes(int i, Type.Builder builder) {
        ensureTypesIsMutable();
        this.types_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addTypes(Type type) {
        if (type != null) {
            ensureTypesIsMutable();
            this.types_.add(type);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addTypes(int i, Type type) {
        if (type != null) {
            ensureTypesIsMutable();
            this.types_.add(i, type);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addTypes(Type.Builder builder) {
        ensureTypesIsMutable();
        this.types_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addTypes(int i, Type.Builder builder) {
        ensureTypesIsMutable();
        this.types_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllTypes(Iterable<? extends Type> iterable) {
        ensureTypesIsMutable();
        AbstractMessageLite.addAll(iterable, this.types_);
    }

    /* access modifiers changed from: private */
    public void clearTypes() {
        this.types_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeTypes(int i) {
        ensureTypesIsMutable();
        this.types_.remove(i);
    }

    public List<Enum> getEnumsList() {
        return this.enums_;
    }

    public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
        return this.enums_;
    }

    public int getEnumsCount() {
        return this.enums_.size();
    }

    public Enum getEnums(int i) {
        return (Enum) this.enums_.get(i);
    }

    public EnumOrBuilder getEnumsOrBuilder(int i) {
        return (EnumOrBuilder) this.enums_.get(i);
    }

    private void ensureEnumsIsMutable() {
        if (!this.enums_.isModifiable()) {
            this.enums_ = GeneratedMessageLite.mutableCopy(this.enums_);
        }
    }

    /* access modifiers changed from: private */
    public void setEnums(int i, Enum enumR) {
        if (enumR != null) {
            ensureEnumsIsMutable();
            this.enums_.set(i, enumR);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setEnums(int i, Enum.Builder builder) {
        ensureEnumsIsMutable();
        this.enums_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addEnums(Enum enumR) {
        if (enumR != null) {
            ensureEnumsIsMutable();
            this.enums_.add(enumR);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addEnums(int i, Enum enumR) {
        if (enumR != null) {
            ensureEnumsIsMutable();
            this.enums_.add(i, enumR);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addEnums(Enum.Builder builder) {
        ensureEnumsIsMutable();
        this.enums_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addEnums(int i, Enum.Builder builder) {
        ensureEnumsIsMutable();
        this.enums_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllEnums(Iterable<? extends Enum> iterable) {
        ensureEnumsIsMutable();
        AbstractMessageLite.addAll(iterable, this.enums_);
    }

    /* access modifiers changed from: private */
    public void clearEnums() {
        this.enums_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeEnums(int i) {
        ensureEnumsIsMutable();
        this.enums_.remove(i);
    }

    public boolean hasDocumentation() {
        return this.documentation_ != null;
    }

    public Documentation getDocumentation() {
        Documentation documentation = this.documentation_;
        return documentation == null ? Documentation.getDefaultInstance() : documentation;
    }

    /* access modifiers changed from: private */
    public void setDocumentation(Documentation documentation) {
        if (documentation != null) {
            this.documentation_ = documentation;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setDocumentation(Documentation.Builder builder) {
        this.documentation_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeDocumentation(Documentation documentation) {
        Documentation documentation2 = this.documentation_;
        if (documentation2 == null || documentation2 == Documentation.getDefaultInstance()) {
            this.documentation_ = documentation;
        } else {
            this.documentation_ = Documentation.newBuilder(this.documentation_).mergeFrom(documentation).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearDocumentation() {
        this.documentation_ = null;
    }

    public boolean hasBackend() {
        return this.backend_ != null;
    }

    public Backend getBackend() {
        Backend backend = this.backend_;
        return backend == null ? Backend.getDefaultInstance() : backend;
    }

    /* access modifiers changed from: private */
    public void setBackend(Backend backend) {
        if (backend != null) {
            this.backend_ = backend;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setBackend(Backend.Builder builder) {
        this.backend_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeBackend(Backend backend) {
        Backend backend2 = this.backend_;
        if (backend2 == null || backend2 == Backend.getDefaultInstance()) {
            this.backend_ = backend;
        } else {
            this.backend_ = Backend.newBuilder(this.backend_).mergeFrom(backend).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearBackend() {
        this.backend_ = null;
    }

    public boolean hasHttp() {
        return this.http_ != null;
    }

    public Http getHttp() {
        Http http = this.http_;
        return http == null ? Http.getDefaultInstance() : http;
    }

    /* access modifiers changed from: private */
    public void setHttp(Http http) {
        if (http != null) {
            this.http_ = http;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setHttp(Http.Builder builder) {
        this.http_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeHttp(Http http) {
        Http http2 = this.http_;
        if (http2 == null || http2 == Http.getDefaultInstance()) {
            this.http_ = http;
        } else {
            this.http_ = Http.newBuilder(this.http_).mergeFrom(http).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearHttp() {
        this.http_ = null;
    }

    public boolean hasQuota() {
        return this.quota_ != null;
    }

    public Quota getQuota() {
        Quota quota = this.quota_;
        return quota == null ? Quota.getDefaultInstance() : quota;
    }

    /* access modifiers changed from: private */
    public void setQuota(Quota quota) {
        if (quota != null) {
            this.quota_ = quota;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setQuota(Quota.Builder builder) {
        this.quota_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeQuota(Quota quota) {
        Quota quota2 = this.quota_;
        if (quota2 == null || quota2 == Quota.getDefaultInstance()) {
            this.quota_ = quota;
        } else {
            this.quota_ = Quota.newBuilder(this.quota_).mergeFrom(quota).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearQuota() {
        this.quota_ = null;
    }

    public boolean hasAuthentication() {
        return this.authentication_ != null;
    }

    public Authentication getAuthentication() {
        Authentication authentication = this.authentication_;
        return authentication == null ? Authentication.getDefaultInstance() : authentication;
    }

    /* access modifiers changed from: private */
    public void setAuthentication(Authentication authentication) {
        if (authentication != null) {
            this.authentication_ = authentication;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setAuthentication(Authentication.Builder builder) {
        this.authentication_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeAuthentication(Authentication authentication) {
        Authentication authentication2 = this.authentication_;
        if (authentication2 == null || authentication2 == Authentication.getDefaultInstance()) {
            this.authentication_ = authentication;
        } else {
            this.authentication_ = Authentication.newBuilder(this.authentication_).mergeFrom(authentication).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAuthentication() {
        this.authentication_ = null;
    }

    public boolean hasContext() {
        return this.context_ != null;
    }

    public Context getContext() {
        Context context = this.context_;
        return context == null ? Context.getDefaultInstance() : context;
    }

    /* access modifiers changed from: private */
    public void setContext(Context context) {
        if (context != null) {
            this.context_ = context;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setContext(Context.Builder builder) {
        this.context_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeContext(Context context) {
        Context context2 = this.context_;
        if (context2 == null || context2 == Context.getDefaultInstance()) {
            this.context_ = context;
        } else {
            this.context_ = Context.newBuilder(this.context_).mergeFrom(context).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearContext() {
        this.context_ = null;
    }

    public boolean hasUsage() {
        return this.usage_ != null;
    }

    public Usage getUsage() {
        Usage usage = this.usage_;
        return usage == null ? Usage.getDefaultInstance() : usage;
    }

    /* access modifiers changed from: private */
    public void setUsage(Usage usage) {
        if (usage != null) {
            this.usage_ = usage;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setUsage(Usage.Builder builder) {
        this.usage_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeUsage(Usage usage) {
        Usage usage2 = this.usage_;
        if (usage2 == null || usage2 == Usage.getDefaultInstance()) {
            this.usage_ = usage;
        } else {
            this.usage_ = Usage.newBuilder(this.usage_).mergeFrom(usage).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearUsage() {
        this.usage_ = null;
    }

    public List<Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    public int getEndpointsCount() {
        return this.endpoints_.size();
    }

    public Endpoint getEndpoints(int i) {
        return (Endpoint) this.endpoints_.get(i);
    }

    public EndpointOrBuilder getEndpointsOrBuilder(int i) {
        return (EndpointOrBuilder) this.endpoints_.get(i);
    }

    private void ensureEndpointsIsMutable() {
        if (!this.endpoints_.isModifiable()) {
            this.endpoints_ = GeneratedMessageLite.mutableCopy(this.endpoints_);
        }
    }

    /* access modifiers changed from: private */
    public void setEndpoints(int i, Endpoint endpoint) {
        if (endpoint != null) {
            ensureEndpointsIsMutable();
            this.endpoints_.set(i, endpoint);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setEndpoints(int i, Endpoint.Builder builder) {
        ensureEndpointsIsMutable();
        this.endpoints_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addEndpoints(Endpoint endpoint) {
        if (endpoint != null) {
            ensureEndpointsIsMutable();
            this.endpoints_.add(endpoint);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addEndpoints(int i, Endpoint endpoint) {
        if (endpoint != null) {
            ensureEndpointsIsMutable();
            this.endpoints_.add(i, endpoint);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addEndpoints(Endpoint.Builder builder) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addEndpoints(int i, Endpoint.Builder builder) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllEndpoints(Iterable<? extends Endpoint> iterable) {
        ensureEndpointsIsMutable();
        AbstractMessageLite.addAll(iterable, this.endpoints_);
    }

    /* access modifiers changed from: private */
    public void clearEndpoints() {
        this.endpoints_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeEndpoints(int i) {
        ensureEndpointsIsMutable();
        this.endpoints_.remove(i);
    }

    public boolean hasControl() {
        return this.control_ != null;
    }

    public Control getControl() {
        Control control = this.control_;
        return control == null ? Control.getDefaultInstance() : control;
    }

    /* access modifiers changed from: private */
    public void setControl(Control control) {
        if (control != null) {
            this.control_ = control;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setControl(Control.Builder builder) {
        this.control_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeControl(Control control) {
        Control control2 = this.control_;
        if (control2 == null || control2 == Control.getDefaultInstance()) {
            this.control_ = control;
        } else {
            this.control_ = Control.newBuilder(this.control_).mergeFrom(control).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearControl() {
        this.control_ = null;
    }

    public List<LogDescriptor> getLogsList() {
        return this.logs_;
    }

    public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    public int getLogsCount() {
        return this.logs_.size();
    }

    public LogDescriptor getLogs(int i) {
        return (LogDescriptor) this.logs_.get(i);
    }

    public LogDescriptorOrBuilder getLogsOrBuilder(int i) {
        return (LogDescriptorOrBuilder) this.logs_.get(i);
    }

    private void ensureLogsIsMutable() {
        if (!this.logs_.isModifiable()) {
            this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
        }
    }

    /* access modifiers changed from: private */
    public void setLogs(int i, LogDescriptor logDescriptor) {
        if (logDescriptor != null) {
            ensureLogsIsMutable();
            this.logs_.set(i, logDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setLogs(int i, LogDescriptor.Builder builder) {
        ensureLogsIsMutable();
        this.logs_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addLogs(LogDescriptor logDescriptor) {
        if (logDescriptor != null) {
            ensureLogsIsMutable();
            this.logs_.add(logDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addLogs(int i, LogDescriptor logDescriptor) {
        if (logDescriptor != null) {
            ensureLogsIsMutable();
            this.logs_.add(i, logDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addLogs(LogDescriptor.Builder builder) {
        ensureLogsIsMutable();
        this.logs_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addLogs(int i, LogDescriptor.Builder builder) {
        ensureLogsIsMutable();
        this.logs_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllLogs(Iterable<? extends LogDescriptor> iterable) {
        ensureLogsIsMutable();
        AbstractMessageLite.addAll(iterable, this.logs_);
    }

    /* access modifiers changed from: private */
    public void clearLogs() {
        this.logs_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeLogs(int i) {
        ensureLogsIsMutable();
        this.logs_.remove(i);
    }

    public List<MetricDescriptor> getMetricsList() {
        return this.metrics_;
    }

    public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    public int getMetricsCount() {
        return this.metrics_.size();
    }

    public MetricDescriptor getMetrics(int i) {
        return (MetricDescriptor) this.metrics_.get(i);
    }

    public MetricDescriptorOrBuilder getMetricsOrBuilder(int i) {
        return (MetricDescriptorOrBuilder) this.metrics_.get(i);
    }

    private void ensureMetricsIsMutable() {
        if (!this.metrics_.isModifiable()) {
            this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_);
        }
    }

    /* access modifiers changed from: private */
    public void setMetrics(int i, MetricDescriptor metricDescriptor) {
        if (metricDescriptor != null) {
            ensureMetricsIsMutable();
            this.metrics_.set(i, metricDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setMetrics(int i, MetricDescriptor.Builder builder) {
        ensureMetricsIsMutable();
        this.metrics_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addMetrics(MetricDescriptor metricDescriptor) {
        if (metricDescriptor != null) {
            ensureMetricsIsMutable();
            this.metrics_.add(metricDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addMetrics(int i, MetricDescriptor metricDescriptor) {
        if (metricDescriptor != null) {
            ensureMetricsIsMutable();
            this.metrics_.add(i, metricDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addMetrics(MetricDescriptor.Builder builder) {
        ensureMetricsIsMutable();
        this.metrics_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addMetrics(int i, MetricDescriptor.Builder builder) {
        ensureMetricsIsMutable();
        this.metrics_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
        ensureMetricsIsMutable();
        AbstractMessageLite.addAll(iterable, this.metrics_);
    }

    /* access modifiers changed from: private */
    public void clearMetrics() {
        this.metrics_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMetrics(int i) {
        ensureMetricsIsMutable();
        this.metrics_.remove(i);
    }

    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
        return this.monitoredResources_;
    }

    public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
        return this.monitoredResources_;
    }

    public int getMonitoredResourcesCount() {
        return this.monitoredResources_.size();
    }

    public MonitoredResourceDescriptor getMonitoredResources(int i) {
        return (MonitoredResourceDescriptor) this.monitoredResources_.get(i);
    }

    public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i) {
        return (MonitoredResourceDescriptorOrBuilder) this.monitoredResources_.get(i);
    }

    private void ensureMonitoredResourcesIsMutable() {
        if (!this.monitoredResources_.isModifiable()) {
            this.monitoredResources_ = GeneratedMessageLite.mutableCopy(this.monitoredResources_);
        }
    }

    /* access modifiers changed from: private */
    public void setMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        if (monitoredResourceDescriptor != null) {
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.set(i, monitoredResourceDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
        if (monitoredResourceDescriptor != null) {
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.add(monitoredResourceDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        if (monitoredResourceDescriptor != null) {
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.add(i, monitoredResourceDescriptor);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
        ensureMonitoredResourcesIsMutable();
        AbstractMessageLite.addAll(iterable, this.monitoredResources_);
    }

    /* access modifiers changed from: private */
    public void clearMonitoredResources() {
        this.monitoredResources_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMonitoredResources(int i) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.remove(i);
    }

    public boolean hasBilling() {
        return this.billing_ != null;
    }

    public Billing getBilling() {
        Billing billing = this.billing_;
        return billing == null ? Billing.getDefaultInstance() : billing;
    }

    /* access modifiers changed from: private */
    public void setBilling(Billing billing) {
        if (billing != null) {
            this.billing_ = billing;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setBilling(Billing.Builder builder) {
        this.billing_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeBilling(Billing billing) {
        Billing billing2 = this.billing_;
        if (billing2 == null || billing2 == Billing.getDefaultInstance()) {
            this.billing_ = billing;
        } else {
            this.billing_ = Billing.newBuilder(this.billing_).mergeFrom(billing).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearBilling() {
        this.billing_ = null;
    }

    public boolean hasLogging() {
        return this.logging_ != null;
    }

    public Logging getLogging() {
        Logging logging = this.logging_;
        return logging == null ? Logging.getDefaultInstance() : logging;
    }

    /* access modifiers changed from: private */
    public void setLogging(Logging logging) {
        if (logging != null) {
            this.logging_ = logging;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setLogging(Logging.Builder builder) {
        this.logging_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeLogging(Logging logging) {
        Logging logging2 = this.logging_;
        if (logging2 == null || logging2 == Logging.getDefaultInstance()) {
            this.logging_ = logging;
        } else {
            this.logging_ = Logging.newBuilder(this.logging_).mergeFrom(logging).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLogging() {
        this.logging_ = null;
    }

    public boolean hasMonitoring() {
        return this.monitoring_ != null;
    }

    public Monitoring getMonitoring() {
        Monitoring monitoring = this.monitoring_;
        return monitoring == null ? Monitoring.getDefaultInstance() : monitoring;
    }

    /* access modifiers changed from: private */
    public void setMonitoring(Monitoring monitoring) {
        if (monitoring != null) {
            this.monitoring_ = monitoring;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setMonitoring(Monitoring.Builder builder) {
        this.monitoring_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeMonitoring(Monitoring monitoring) {
        Monitoring monitoring2 = this.monitoring_;
        if (monitoring2 == null || monitoring2 == Monitoring.getDefaultInstance()) {
            this.monitoring_ = monitoring;
        } else {
            this.monitoring_ = Monitoring.newBuilder(this.monitoring_).mergeFrom(monitoring).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearMonitoring() {
        this.monitoring_ = null;
    }

    public boolean hasSystemParameters() {
        return this.systemParameters_ != null;
    }

    public SystemParameters getSystemParameters() {
        SystemParameters systemParameters = this.systemParameters_;
        return systemParameters == null ? SystemParameters.getDefaultInstance() : systemParameters;
    }

    /* access modifiers changed from: private */
    public void setSystemParameters(SystemParameters systemParameters) {
        if (systemParameters != null) {
            this.systemParameters_ = systemParameters;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setSystemParameters(SystemParameters.Builder builder) {
        this.systemParameters_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeSystemParameters(SystemParameters systemParameters) {
        SystemParameters systemParameters2 = this.systemParameters_;
        if (systemParameters2 == null || systemParameters2 == SystemParameters.getDefaultInstance()) {
            this.systemParameters_ = systemParameters;
        } else {
            this.systemParameters_ = SystemParameters.newBuilder(this.systemParameters_).mergeFrom(systemParameters).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSystemParameters() {
        this.systemParameters_ = null;
    }

    public boolean hasSourceInfo() {
        return this.sourceInfo_ != null;
    }

    public SourceInfo getSourceInfo() {
        SourceInfo sourceInfo = this.sourceInfo_;
        return sourceInfo == null ? SourceInfo.getDefaultInstance() : sourceInfo;
    }

    /* access modifiers changed from: private */
    public void setSourceInfo(SourceInfo sourceInfo) {
        if (sourceInfo != null) {
            this.sourceInfo_ = sourceInfo;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setSourceInfo(SourceInfo.Builder builder) {
        this.sourceInfo_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeSourceInfo(SourceInfo sourceInfo) {
        SourceInfo sourceInfo2 = this.sourceInfo_;
        if (sourceInfo2 == null || sourceInfo2 == SourceInfo.getDefaultInstance()) {
            this.sourceInfo_ = sourceInfo;
        } else {
            this.sourceInfo_ = SourceInfo.newBuilder(this.sourceInfo_).mergeFrom(sourceInfo).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSourceInfo() {
        this.sourceInfo_ = null;
    }

    public boolean hasExperimental() {
        return this.experimental_ != null;
    }

    public Experimental getExperimental() {
        Experimental experimental = this.experimental_;
        return experimental == null ? Experimental.getDefaultInstance() : experimental;
    }

    /* access modifiers changed from: private */
    public void setExperimental(Experimental experimental) {
        if (experimental != null) {
            this.experimental_ = experimental;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setExperimental(Experimental.Builder builder) {
        this.experimental_ = builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeExperimental(Experimental experimental) {
        Experimental experimental2 = this.experimental_;
        if (experimental2 == null || experimental2 == Experimental.getDefaultInstance()) {
            this.experimental_ = experimental;
        } else {
            this.experimental_ = Experimental.newBuilder(this.experimental_).mergeFrom(experimental).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearExperimental() {
        this.experimental_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (!this.title_.isEmpty()) {
            codedOutputStream.writeString(2, getTitle());
        }
        for (int i = 0; i < this.apis_.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.apis_.get(i));
        }
        for (int i2 = 0; i2 < this.types_.size(); i2++) {
            codedOutputStream.writeMessage(4, (MessageLite) this.types_.get(i2));
        }
        for (int i3 = 0; i3 < this.enums_.size(); i3++) {
            codedOutputStream.writeMessage(5, (MessageLite) this.enums_.get(i3));
        }
        if (this.documentation_ != null) {
            codedOutputStream.writeMessage(6, getDocumentation());
        }
        if (this.backend_ != null) {
            codedOutputStream.writeMessage(8, getBackend());
        }
        if (this.http_ != null) {
            codedOutputStream.writeMessage(9, getHttp());
        }
        if (this.quota_ != null) {
            codedOutputStream.writeMessage(10, getQuota());
        }
        if (this.authentication_ != null) {
            codedOutputStream.writeMessage(11, getAuthentication());
        }
        if (this.context_ != null) {
            codedOutputStream.writeMessage(12, getContext());
        }
        if (this.usage_ != null) {
            codedOutputStream.writeMessage(15, getUsage());
        }
        for (int i4 = 0; i4 < this.endpoints_.size(); i4++) {
            codedOutputStream.writeMessage(18, (MessageLite) this.endpoints_.get(i4));
        }
        if (this.configVersion_ != null) {
            codedOutputStream.writeMessage(20, getConfigVersion());
        }
        if (this.control_ != null) {
            codedOutputStream.writeMessage(21, getControl());
        }
        if (!this.producerProjectId_.isEmpty()) {
            codedOutputStream.writeString(22, getProducerProjectId());
        }
        for (int i5 = 0; i5 < this.logs_.size(); i5++) {
            codedOutputStream.writeMessage(23, (MessageLite) this.logs_.get(i5));
        }
        for (int i6 = 0; i6 < this.metrics_.size(); i6++) {
            codedOutputStream.writeMessage(24, (MessageLite) this.metrics_.get(i6));
        }
        for (int i7 = 0; i7 < this.monitoredResources_.size(); i7++) {
            codedOutputStream.writeMessage(25, (MessageLite) this.monitoredResources_.get(i7));
        }
        if (this.billing_ != null) {
            codedOutputStream.writeMessage(26, getBilling());
        }
        if (this.logging_ != null) {
            codedOutputStream.writeMessage(27, getLogging());
        }
        if (this.monitoring_ != null) {
            codedOutputStream.writeMessage(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            codedOutputStream.writeMessage(29, getSystemParameters());
        }
        if (!this.id_.isEmpty()) {
            codedOutputStream.writeString(33, getId());
        }
        if (this.sourceInfo_ != null) {
            codedOutputStream.writeMessage(37, getSourceInfo());
        }
        if (this.experimental_ != null) {
            codedOutputStream.writeMessage(101, getExperimental());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        if (!this.title_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getTitle());
        }
        int i2 = computeStringSize;
        for (int i3 = 0; i3 < this.apis_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.apis_.get(i3));
        }
        for (int i4 = 0; i4 < this.types_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.types_.get(i4));
        }
        for (int i5 = 0; i5 < this.enums_.size(); i5++) {
            i2 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.enums_.get(i5));
        }
        if (this.documentation_ != null) {
            i2 += CodedOutputStream.computeMessageSize(6, getDocumentation());
        }
        if (this.backend_ != null) {
            i2 += CodedOutputStream.computeMessageSize(8, getBackend());
        }
        if (this.http_ != null) {
            i2 += CodedOutputStream.computeMessageSize(9, getHttp());
        }
        if (this.quota_ != null) {
            i2 += CodedOutputStream.computeMessageSize(10, getQuota());
        }
        if (this.authentication_ != null) {
            i2 += CodedOutputStream.computeMessageSize(11, getAuthentication());
        }
        if (this.context_ != null) {
            i2 += CodedOutputStream.computeMessageSize(12, getContext());
        }
        if (this.usage_ != null) {
            i2 += CodedOutputStream.computeMessageSize(15, getUsage());
        }
        for (int i6 = 0; i6 < this.endpoints_.size(); i6++) {
            i2 += CodedOutputStream.computeMessageSize(18, (MessageLite) this.endpoints_.get(i6));
        }
        if (this.configVersion_ != null) {
            i2 += CodedOutputStream.computeMessageSize(20, getConfigVersion());
        }
        if (this.control_ != null) {
            i2 += CodedOutputStream.computeMessageSize(21, getControl());
        }
        if (!this.producerProjectId_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(22, getProducerProjectId());
        }
        for (int i7 = 0; i7 < this.logs_.size(); i7++) {
            i2 += CodedOutputStream.computeMessageSize(23, (MessageLite) this.logs_.get(i7));
        }
        for (int i8 = 0; i8 < this.metrics_.size(); i8++) {
            i2 += CodedOutputStream.computeMessageSize(24, (MessageLite) this.metrics_.get(i8));
        }
        for (int i9 = 0; i9 < this.monitoredResources_.size(); i9++) {
            i2 += CodedOutputStream.computeMessageSize(25, (MessageLite) this.monitoredResources_.get(i9));
        }
        if (this.billing_ != null) {
            i2 += CodedOutputStream.computeMessageSize(26, getBilling());
        }
        if (this.logging_ != null) {
            i2 += CodedOutputStream.computeMessageSize(27, getLogging());
        }
        if (this.monitoring_ != null) {
            i2 += CodedOutputStream.computeMessageSize(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            i2 += CodedOutputStream.computeMessageSize(29, getSystemParameters());
        }
        if (!this.id_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(33, getId());
        }
        if (this.sourceInfo_ != null) {
            i2 += CodedOutputStream.computeMessageSize(37, getSourceInfo());
        }
        if (this.experimental_ != null) {
            i2 += CodedOutputStream.computeMessageSize(101, getExperimental());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Service parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Service parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Service parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Service parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Service parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseDelimitedFrom(InputStream inputStream) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Service parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Service service) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(service);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Service.DEFAULT_INSTANCE);
        }

        public boolean hasConfigVersion() {
            return this.instance.hasConfigVersion();
        }

        public UInt32Value getConfigVersion() {
            return this.instance.getConfigVersion();
        }

        public Builder setConfigVersion(UInt32Value uInt32Value) {
            copyOnWrite();
            this.instance.setConfigVersion(uInt32Value);
            return this;
        }

        public Builder setConfigVersion(UInt32Value.Builder builder) {
            copyOnWrite();
            this.instance.setConfigVersion(builder);
            return this;
        }

        public Builder mergeConfigVersion(UInt32Value uInt32Value) {
            copyOnWrite();
            this.instance.mergeConfigVersion(uInt32Value);
            return this;
        }

        public Builder clearConfigVersion() {
            copyOnWrite();
            this.instance.clearConfigVersion();
            return this;
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

        public String getId() {
            return this.instance.getId();
        }

        public ByteString getIdBytes() {
            return this.instance.getIdBytes();
        }

        public Builder setId(String str) {
            copyOnWrite();
            this.instance.setId(str);
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            this.instance.clearId();
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setIdBytes(byteString);
            return this;
        }

        public String getTitle() {
            return this.instance.getTitle();
        }

        public ByteString getTitleBytes() {
            return this.instance.getTitleBytes();
        }

        public Builder setTitle(String str) {
            copyOnWrite();
            this.instance.setTitle(str);
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            this.instance.clearTitle();
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setTitleBytes(byteString);
            return this;
        }

        public String getProducerProjectId() {
            return this.instance.getProducerProjectId();
        }

        public ByteString getProducerProjectIdBytes() {
            return this.instance.getProducerProjectIdBytes();
        }

        public Builder setProducerProjectId(String str) {
            copyOnWrite();
            this.instance.setProducerProjectId(str);
            return this;
        }

        public Builder clearProducerProjectId() {
            copyOnWrite();
            this.instance.clearProducerProjectId();
            return this;
        }

        public Builder setProducerProjectIdBytes(ByteString byteString) {
            copyOnWrite();
            this.instance.setProducerProjectIdBytes(byteString);
            return this;
        }

        public List<Api> getApisList() {
            return Collections.unmodifiableList(this.instance.getApisList());
        }

        public int getApisCount() {
            return this.instance.getApisCount();
        }

        public Api getApis(int i) {
            return this.instance.getApis(i);
        }

        public Builder setApis(int i, Api api) {
            copyOnWrite();
            this.instance.setApis(i, api);
            return this;
        }

        public Builder setApis(int i, Api.Builder builder) {
            copyOnWrite();
            this.instance.setApis(i, builder);
            return this;
        }

        public Builder addApis(Api api) {
            copyOnWrite();
            this.instance.addApis(api);
            return this;
        }

        public Builder addApis(int i, Api api) {
            copyOnWrite();
            this.instance.addApis(i, api);
            return this;
        }

        public Builder addApis(Api.Builder builder) {
            copyOnWrite();
            this.instance.addApis(builder);
            return this;
        }

        public Builder addApis(int i, Api.Builder builder) {
            copyOnWrite();
            this.instance.addApis(i, builder);
            return this;
        }

        public Builder addAllApis(Iterable<? extends Api> iterable) {
            copyOnWrite();
            this.instance.addAllApis(iterable);
            return this;
        }

        public Builder clearApis() {
            copyOnWrite();
            this.instance.clearApis();
            return this;
        }

        public Builder removeApis(int i) {
            copyOnWrite();
            this.instance.removeApis(i);
            return this;
        }

        public List<Type> getTypesList() {
            return Collections.unmodifiableList(this.instance.getTypesList());
        }

        public int getTypesCount() {
            return this.instance.getTypesCount();
        }

        public Type getTypes(int i) {
            return this.instance.getTypes(i);
        }

        public Builder setTypes(int i, Type type) {
            copyOnWrite();
            this.instance.setTypes(i, type);
            return this;
        }

        public Builder setTypes(int i, Type.Builder builder) {
            copyOnWrite();
            this.instance.setTypes(i, builder);
            return this;
        }

        public Builder addTypes(Type type) {
            copyOnWrite();
            this.instance.addTypes(type);
            return this;
        }

        public Builder addTypes(int i, Type type) {
            copyOnWrite();
            this.instance.addTypes(i, type);
            return this;
        }

        public Builder addTypes(Type.Builder builder) {
            copyOnWrite();
            this.instance.addTypes(builder);
            return this;
        }

        public Builder addTypes(int i, Type.Builder builder) {
            copyOnWrite();
            this.instance.addTypes(i, builder);
            return this;
        }

        public Builder addAllTypes(Iterable<? extends Type> iterable) {
            copyOnWrite();
            this.instance.addAllTypes(iterable);
            return this;
        }

        public Builder clearTypes() {
            copyOnWrite();
            this.instance.clearTypes();
            return this;
        }

        public Builder removeTypes(int i) {
            copyOnWrite();
            this.instance.removeTypes(i);
            return this;
        }

        public List<Enum> getEnumsList() {
            return Collections.unmodifiableList(this.instance.getEnumsList());
        }

        public int getEnumsCount() {
            return this.instance.getEnumsCount();
        }

        public Enum getEnums(int i) {
            return this.instance.getEnums(i);
        }

        public Builder setEnums(int i, Enum enumR) {
            copyOnWrite();
            this.instance.setEnums(i, enumR);
            return this;
        }

        public Builder setEnums(int i, Enum.Builder builder) {
            copyOnWrite();
            this.instance.setEnums(i, builder);
            return this;
        }

        public Builder addEnums(Enum enumR) {
            copyOnWrite();
            this.instance.addEnums(enumR);
            return this;
        }

        public Builder addEnums(int i, Enum enumR) {
            copyOnWrite();
            this.instance.addEnums(i, enumR);
            return this;
        }

        public Builder addEnums(Enum.Builder builder) {
            copyOnWrite();
            this.instance.addEnums(builder);
            return this;
        }

        public Builder addEnums(int i, Enum.Builder builder) {
            copyOnWrite();
            this.instance.addEnums(i, builder);
            return this;
        }

        public Builder addAllEnums(Iterable<? extends Enum> iterable) {
            copyOnWrite();
            this.instance.addAllEnums(iterable);
            return this;
        }

        public Builder clearEnums() {
            copyOnWrite();
            this.instance.clearEnums();
            return this;
        }

        public Builder removeEnums(int i) {
            copyOnWrite();
            this.instance.removeEnums(i);
            return this;
        }

        public boolean hasDocumentation() {
            return this.instance.hasDocumentation();
        }

        public Documentation getDocumentation() {
            return this.instance.getDocumentation();
        }

        public Builder setDocumentation(Documentation documentation) {
            copyOnWrite();
            this.instance.setDocumentation(documentation);
            return this;
        }

        public Builder setDocumentation(Documentation.Builder builder) {
            copyOnWrite();
            this.instance.setDocumentation(builder);
            return this;
        }

        public Builder mergeDocumentation(Documentation documentation) {
            copyOnWrite();
            this.instance.mergeDocumentation(documentation);
            return this;
        }

        public Builder clearDocumentation() {
            copyOnWrite();
            this.instance.clearDocumentation();
            return this;
        }

        public boolean hasBackend() {
            return this.instance.hasBackend();
        }

        public Backend getBackend() {
            return this.instance.getBackend();
        }

        public Builder setBackend(Backend backend) {
            copyOnWrite();
            this.instance.setBackend(backend);
            return this;
        }

        public Builder setBackend(Backend.Builder builder) {
            copyOnWrite();
            this.instance.setBackend(builder);
            return this;
        }

        public Builder mergeBackend(Backend backend) {
            copyOnWrite();
            this.instance.mergeBackend(backend);
            return this;
        }

        public Builder clearBackend() {
            copyOnWrite();
            this.instance.clearBackend();
            return this;
        }

        public boolean hasHttp() {
            return this.instance.hasHttp();
        }

        public Http getHttp() {
            return this.instance.getHttp();
        }

        public Builder setHttp(Http http) {
            copyOnWrite();
            this.instance.setHttp(http);
            return this;
        }

        public Builder setHttp(Http.Builder builder) {
            copyOnWrite();
            this.instance.setHttp(builder);
            return this;
        }

        public Builder mergeHttp(Http http) {
            copyOnWrite();
            this.instance.mergeHttp(http);
            return this;
        }

        public Builder clearHttp() {
            copyOnWrite();
            this.instance.clearHttp();
            return this;
        }

        public boolean hasQuota() {
            return this.instance.hasQuota();
        }

        public Quota getQuota() {
            return this.instance.getQuota();
        }

        public Builder setQuota(Quota quota) {
            copyOnWrite();
            this.instance.setQuota(quota);
            return this;
        }

        public Builder setQuota(Quota.Builder builder) {
            copyOnWrite();
            this.instance.setQuota(builder);
            return this;
        }

        public Builder mergeQuota(Quota quota) {
            copyOnWrite();
            this.instance.mergeQuota(quota);
            return this;
        }

        public Builder clearQuota() {
            copyOnWrite();
            this.instance.clearQuota();
            return this;
        }

        public boolean hasAuthentication() {
            return this.instance.hasAuthentication();
        }

        public Authentication getAuthentication() {
            return this.instance.getAuthentication();
        }

        public Builder setAuthentication(Authentication authentication) {
            copyOnWrite();
            this.instance.setAuthentication(authentication);
            return this;
        }

        public Builder setAuthentication(Authentication.Builder builder) {
            copyOnWrite();
            this.instance.setAuthentication(builder);
            return this;
        }

        public Builder mergeAuthentication(Authentication authentication) {
            copyOnWrite();
            this.instance.mergeAuthentication(authentication);
            return this;
        }

        public Builder clearAuthentication() {
            copyOnWrite();
            this.instance.clearAuthentication();
            return this;
        }

        public boolean hasContext() {
            return this.instance.hasContext();
        }

        public Context getContext() {
            return this.instance.getContext();
        }

        public Builder setContext(Context context) {
            copyOnWrite();
            this.instance.setContext(context);
            return this;
        }

        public Builder setContext(Context.Builder builder) {
            copyOnWrite();
            this.instance.setContext(builder);
            return this;
        }

        public Builder mergeContext(Context context) {
            copyOnWrite();
            this.instance.mergeContext(context);
            return this;
        }

        public Builder clearContext() {
            copyOnWrite();
            this.instance.clearContext();
            return this;
        }

        public boolean hasUsage() {
            return this.instance.hasUsage();
        }

        public Usage getUsage() {
            return this.instance.getUsage();
        }

        public Builder setUsage(Usage usage) {
            copyOnWrite();
            this.instance.setUsage(usage);
            return this;
        }

        public Builder setUsage(Usage.Builder builder) {
            copyOnWrite();
            this.instance.setUsage(builder);
            return this;
        }

        public Builder mergeUsage(Usage usage) {
            copyOnWrite();
            this.instance.mergeUsage(usage);
            return this;
        }

        public Builder clearUsage() {
            copyOnWrite();
            this.instance.clearUsage();
            return this;
        }

        public List<Endpoint> getEndpointsList() {
            return Collections.unmodifiableList(this.instance.getEndpointsList());
        }

        public int getEndpointsCount() {
            return this.instance.getEndpointsCount();
        }

        public Endpoint getEndpoints(int i) {
            return this.instance.getEndpoints(i);
        }

        public Builder setEndpoints(int i, Endpoint endpoint) {
            copyOnWrite();
            this.instance.setEndpoints(i, endpoint);
            return this;
        }

        public Builder setEndpoints(int i, Endpoint.Builder builder) {
            copyOnWrite();
            this.instance.setEndpoints(i, builder);
            return this;
        }

        public Builder addEndpoints(Endpoint endpoint) {
            copyOnWrite();
            this.instance.addEndpoints(endpoint);
            return this;
        }

        public Builder addEndpoints(int i, Endpoint endpoint) {
            copyOnWrite();
            this.instance.addEndpoints(i, endpoint);
            return this;
        }

        public Builder addEndpoints(Endpoint.Builder builder) {
            copyOnWrite();
            this.instance.addEndpoints(builder);
            return this;
        }

        public Builder addEndpoints(int i, Endpoint.Builder builder) {
            copyOnWrite();
            this.instance.addEndpoints(i, builder);
            return this;
        }

        public Builder addAllEndpoints(Iterable<? extends Endpoint> iterable) {
            copyOnWrite();
            this.instance.addAllEndpoints(iterable);
            return this;
        }

        public Builder clearEndpoints() {
            copyOnWrite();
            this.instance.clearEndpoints();
            return this;
        }

        public Builder removeEndpoints(int i) {
            copyOnWrite();
            this.instance.removeEndpoints(i);
            return this;
        }

        public boolean hasControl() {
            return this.instance.hasControl();
        }

        public Control getControl() {
            return this.instance.getControl();
        }

        public Builder setControl(Control control) {
            copyOnWrite();
            this.instance.setControl(control);
            return this;
        }

        public Builder setControl(Control.Builder builder) {
            copyOnWrite();
            this.instance.setControl(builder);
            return this;
        }

        public Builder mergeControl(Control control) {
            copyOnWrite();
            this.instance.mergeControl(control);
            return this;
        }

        public Builder clearControl() {
            copyOnWrite();
            this.instance.clearControl();
            return this;
        }

        public List<LogDescriptor> getLogsList() {
            return Collections.unmodifiableList(this.instance.getLogsList());
        }

        public int getLogsCount() {
            return this.instance.getLogsCount();
        }

        public LogDescriptor getLogs(int i) {
            return this.instance.getLogs(i);
        }

        public Builder setLogs(int i, LogDescriptor logDescriptor) {
            copyOnWrite();
            this.instance.setLogs(i, logDescriptor);
            return this;
        }

        public Builder setLogs(int i, LogDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.setLogs(i, builder);
            return this;
        }

        public Builder addLogs(LogDescriptor logDescriptor) {
            copyOnWrite();
            this.instance.addLogs(logDescriptor);
            return this;
        }

        public Builder addLogs(int i, LogDescriptor logDescriptor) {
            copyOnWrite();
            this.instance.addLogs(i, logDescriptor);
            return this;
        }

        public Builder addLogs(LogDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.addLogs(builder);
            return this;
        }

        public Builder addLogs(int i, LogDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.addLogs(i, builder);
            return this;
        }

        public Builder addAllLogs(Iterable<? extends LogDescriptor> iterable) {
            copyOnWrite();
            this.instance.addAllLogs(iterable);
            return this;
        }

        public Builder clearLogs() {
            copyOnWrite();
            this.instance.clearLogs();
            return this;
        }

        public Builder removeLogs(int i) {
            copyOnWrite();
            this.instance.removeLogs(i);
            return this;
        }

        public List<MetricDescriptor> getMetricsList() {
            return Collections.unmodifiableList(this.instance.getMetricsList());
        }

        public int getMetricsCount() {
            return this.instance.getMetricsCount();
        }

        public MetricDescriptor getMetrics(int i) {
            return this.instance.getMetrics(i);
        }

        public Builder setMetrics(int i, MetricDescriptor metricDescriptor) {
            copyOnWrite();
            this.instance.setMetrics(i, metricDescriptor);
            return this;
        }

        public Builder setMetrics(int i, MetricDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.setMetrics(i, builder);
            return this;
        }

        public Builder addMetrics(MetricDescriptor metricDescriptor) {
            copyOnWrite();
            this.instance.addMetrics(metricDescriptor);
            return this;
        }

        public Builder addMetrics(int i, MetricDescriptor metricDescriptor) {
            copyOnWrite();
            this.instance.addMetrics(i, metricDescriptor);
            return this;
        }

        public Builder addMetrics(MetricDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.addMetrics(builder);
            return this;
        }

        public Builder addMetrics(int i, MetricDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.addMetrics(i, builder);
            return this;
        }

        public Builder addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
            copyOnWrite();
            this.instance.addAllMetrics(iterable);
            return this;
        }

        public Builder clearMetrics() {
            copyOnWrite();
            this.instance.clearMetrics();
            return this;
        }

        public Builder removeMetrics(int i) {
            copyOnWrite();
            this.instance.removeMetrics(i);
            return this;
        }

        public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
            return Collections.unmodifiableList(this.instance.getMonitoredResourcesList());
        }

        public int getMonitoredResourcesCount() {
            return this.instance.getMonitoredResourcesCount();
        }

        public MonitoredResourceDescriptor getMonitoredResources(int i) {
            return this.instance.getMonitoredResources(i);
        }

        public Builder setMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            copyOnWrite();
            this.instance.setMonitoredResources(i, monitoredResourceDescriptor);
            return this;
        }

        public Builder setMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.setMonitoredResources(i, builder);
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
            copyOnWrite();
            this.instance.addMonitoredResources(monitoredResourceDescriptor);
            return this;
        }

        public Builder addMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            copyOnWrite();
            this.instance.addMonitoredResources(i, monitoredResourceDescriptor);
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.addMonitoredResources(builder);
            return this;
        }

        public Builder addMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            copyOnWrite();
            this.instance.addMonitoredResources(i, builder);
            return this;
        }

        public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
            copyOnWrite();
            this.instance.addAllMonitoredResources(iterable);
            return this;
        }

        public Builder clearMonitoredResources() {
            copyOnWrite();
            this.instance.clearMonitoredResources();
            return this;
        }

        public Builder removeMonitoredResources(int i) {
            copyOnWrite();
            this.instance.removeMonitoredResources(i);
            return this;
        }

        public boolean hasBilling() {
            return this.instance.hasBilling();
        }

        public Billing getBilling() {
            return this.instance.getBilling();
        }

        public Builder setBilling(Billing billing) {
            copyOnWrite();
            this.instance.setBilling(billing);
            return this;
        }

        public Builder setBilling(Billing.Builder builder) {
            copyOnWrite();
            this.instance.setBilling(builder);
            return this;
        }

        public Builder mergeBilling(Billing billing) {
            copyOnWrite();
            this.instance.mergeBilling(billing);
            return this;
        }

        public Builder clearBilling() {
            copyOnWrite();
            this.instance.clearBilling();
            return this;
        }

        public boolean hasLogging() {
            return this.instance.hasLogging();
        }

        public Logging getLogging() {
            return this.instance.getLogging();
        }

        public Builder setLogging(Logging logging) {
            copyOnWrite();
            this.instance.setLogging(logging);
            return this;
        }

        public Builder setLogging(Logging.Builder builder) {
            copyOnWrite();
            this.instance.setLogging(builder);
            return this;
        }

        public Builder mergeLogging(Logging logging) {
            copyOnWrite();
            this.instance.mergeLogging(logging);
            return this;
        }

        public Builder clearLogging() {
            copyOnWrite();
            this.instance.clearLogging();
            return this;
        }

        public boolean hasMonitoring() {
            return this.instance.hasMonitoring();
        }

        public Monitoring getMonitoring() {
            return this.instance.getMonitoring();
        }

        public Builder setMonitoring(Monitoring monitoring) {
            copyOnWrite();
            this.instance.setMonitoring(monitoring);
            return this;
        }

        public Builder setMonitoring(Monitoring.Builder builder) {
            copyOnWrite();
            this.instance.setMonitoring(builder);
            return this;
        }

        public Builder mergeMonitoring(Monitoring monitoring) {
            copyOnWrite();
            this.instance.mergeMonitoring(monitoring);
            return this;
        }

        public Builder clearMonitoring() {
            copyOnWrite();
            this.instance.clearMonitoring();
            return this;
        }

        public boolean hasSystemParameters() {
            return this.instance.hasSystemParameters();
        }

        public SystemParameters getSystemParameters() {
            return this.instance.getSystemParameters();
        }

        public Builder setSystemParameters(SystemParameters systemParameters) {
            copyOnWrite();
            this.instance.setSystemParameters(systemParameters);
            return this;
        }

        public Builder setSystemParameters(SystemParameters.Builder builder) {
            copyOnWrite();
            this.instance.setSystemParameters(builder);
            return this;
        }

        public Builder mergeSystemParameters(SystemParameters systemParameters) {
            copyOnWrite();
            this.instance.mergeSystemParameters(systemParameters);
            return this;
        }

        public Builder clearSystemParameters() {
            copyOnWrite();
            this.instance.clearSystemParameters();
            return this;
        }

        public boolean hasSourceInfo() {
            return this.instance.hasSourceInfo();
        }

        public SourceInfo getSourceInfo() {
            return this.instance.getSourceInfo();
        }

        public Builder setSourceInfo(SourceInfo sourceInfo) {
            copyOnWrite();
            this.instance.setSourceInfo(sourceInfo);
            return this;
        }

        public Builder setSourceInfo(SourceInfo.Builder builder) {
            copyOnWrite();
            this.instance.setSourceInfo(builder);
            return this;
        }

        public Builder mergeSourceInfo(SourceInfo sourceInfo) {
            copyOnWrite();
            this.instance.mergeSourceInfo(sourceInfo);
            return this;
        }

        public Builder clearSourceInfo() {
            copyOnWrite();
            this.instance.clearSourceInfo();
            return this;
        }

        public boolean hasExperimental() {
            return this.instance.hasExperimental();
        }

        public Experimental getExperimental() {
            return this.instance.getExperimental();
        }

        public Builder setExperimental(Experimental experimental) {
            copyOnWrite();
            this.instance.setExperimental(experimental);
            return this;
        }

        public Builder setExperimental(Experimental.Builder builder) {
            copyOnWrite();
            this.instance.setExperimental(builder);
            return this;
        }

        public Builder mergeExperimental(Experimental experimental) {
            copyOnWrite();
            this.instance.mergeExperimental(experimental);
            return this;
        }

        public Builder clearExperimental() {
            copyOnWrite();
            this.instance.clearExperimental();
            return this;
        }
    }

    /* renamed from: com.google.api.Service$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Service.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Service();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.apis_.makeImmutable();
                this.types_.makeImmutable();
                this.enums_.makeImmutable();
                this.endpoints_.makeImmutable();
                this.logs_.makeImmutable();
                this.metrics_.makeImmutable();
                this.monitoredResources_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                Service service = (Service) obj2;
                this.configVersion_ = mergeFromVisitor.visitMessage(this.configVersion_, service.configVersion_);
                this.name_ = mergeFromVisitor.visitString(!this.name_.isEmpty(), this.name_, !service.name_.isEmpty(), service.name_);
                this.id_ = mergeFromVisitor.visitString(!this.id_.isEmpty(), this.id_, !service.id_.isEmpty(), service.id_);
                this.title_ = mergeFromVisitor.visitString(!this.title_.isEmpty(), this.title_, !service.title_.isEmpty(), service.title_);
                this.producerProjectId_ = mergeFromVisitor.visitString(!this.producerProjectId_.isEmpty(), this.producerProjectId_, true ^ service.producerProjectId_.isEmpty(), service.producerProjectId_);
                this.apis_ = mergeFromVisitor.visitList(this.apis_, service.apis_);
                this.types_ = mergeFromVisitor.visitList(this.types_, service.types_);
                this.enums_ = mergeFromVisitor.visitList(this.enums_, service.enums_);
                this.documentation_ = mergeFromVisitor.visitMessage(this.documentation_, service.documentation_);
                this.backend_ = mergeFromVisitor.visitMessage(this.backend_, service.backend_);
                this.http_ = mergeFromVisitor.visitMessage(this.http_, service.http_);
                this.quota_ = mergeFromVisitor.visitMessage(this.quota_, service.quota_);
                this.authentication_ = mergeFromVisitor.visitMessage(this.authentication_, service.authentication_);
                this.context_ = mergeFromVisitor.visitMessage(this.context_, service.context_);
                this.usage_ = mergeFromVisitor.visitMessage(this.usage_, service.usage_);
                this.endpoints_ = mergeFromVisitor.visitList(this.endpoints_, service.endpoints_);
                this.control_ = mergeFromVisitor.visitMessage(this.control_, service.control_);
                this.logs_ = mergeFromVisitor.visitList(this.logs_, service.logs_);
                this.metrics_ = mergeFromVisitor.visitList(this.metrics_, service.metrics_);
                this.monitoredResources_ = mergeFromVisitor.visitList(this.monitoredResources_, service.monitoredResources_);
                this.billing_ = mergeFromVisitor.visitMessage(this.billing_, service.billing_);
                this.logging_ = mergeFromVisitor.visitMessage(this.logging_, service.logging_);
                this.monitoring_ = mergeFromVisitor.visitMessage(this.monitoring_, service.monitoring_);
                this.systemParameters_ = mergeFromVisitor.visitMessage(this.systemParameters_, service.systemParameters_);
                this.sourceInfo_ = mergeFromVisitor.visitMessage(this.sourceInfo_, service.sourceInfo_);
                this.experimental_ = mergeFromVisitor.visitMessage(this.experimental_, service.experimental_);
                if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= service.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 18:
                                this.title_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 26:
                                if (!this.apis_.isModifiable()) {
                                    this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
                                }
                                this.apis_.add(codedInputStream.readMessage(Api.parser(), extensionRegistryLite));
                                break;
                            case 34:
                                if (!this.types_.isModifiable()) {
                                    this.types_ = GeneratedMessageLite.mutableCopy(this.types_);
                                }
                                this.types_.add(codedInputStream.readMessage(Type.parser(), extensionRegistryLite));
                                break;
                            case 42:
                                if (!this.enums_.isModifiable()) {
                                    this.enums_ = GeneratedMessageLite.mutableCopy(this.enums_);
                                }
                                this.enums_.add(codedInputStream.readMessage(Enum.parser(), extensionRegistryLite));
                                break;
                            case 50:
                                Documentation.Builder builder = this.documentation_ != null ? (Documentation.Builder) this.documentation_.toBuilder() : null;
                                this.documentation_ = codedInputStream.readMessage(Documentation.parser(), extensionRegistryLite);
                                if (builder == null) {
                                    break;
                                } else {
                                    builder.mergeFrom(this.documentation_);
                                    this.documentation_ = builder.buildPartial();
                                    break;
                                }
                            case 66:
                                Backend.Builder builder2 = this.backend_ != null ? (Backend.Builder) this.backend_.toBuilder() : null;
                                this.backend_ = codedInputStream.readMessage(Backend.parser(), extensionRegistryLite);
                                if (builder2 == null) {
                                    break;
                                } else {
                                    builder2.mergeFrom(this.backend_);
                                    this.backend_ = builder2.buildPartial();
                                    break;
                                }
                            case 74:
                                Http.Builder builder3 = this.http_ != null ? (Http.Builder) this.http_.toBuilder() : null;
                                this.http_ = codedInputStream.readMessage(Http.parser(), extensionRegistryLite);
                                if (builder3 == null) {
                                    break;
                                } else {
                                    builder3.mergeFrom(this.http_);
                                    this.http_ = builder3.buildPartial();
                                    break;
                                }
                            case 82:
                                Quota.Builder builder4 = this.quota_ != null ? (Quota.Builder) this.quota_.toBuilder() : null;
                                this.quota_ = codedInputStream.readMessage(Quota.parser(), extensionRegistryLite);
                                if (builder4 == null) {
                                    break;
                                } else {
                                    builder4.mergeFrom(this.quota_);
                                    this.quota_ = builder4.buildPartial();
                                    break;
                                }
                            case 90:
                                Authentication.Builder builder5 = this.authentication_ != null ? (Authentication.Builder) this.authentication_.toBuilder() : null;
                                this.authentication_ = codedInputStream.readMessage(Authentication.parser(), extensionRegistryLite);
                                if (builder5 == null) {
                                    break;
                                } else {
                                    builder5.mergeFrom(this.authentication_);
                                    this.authentication_ = builder5.buildPartial();
                                    break;
                                }
                            case 98:
                                Context.Builder builder6 = this.context_ != null ? (Context.Builder) this.context_.toBuilder() : null;
                                this.context_ = codedInputStream.readMessage(Context.parser(), extensionRegistryLite);
                                if (builder6 == null) {
                                    break;
                                } else {
                                    builder6.mergeFrom(this.context_);
                                    this.context_ = builder6.buildPartial();
                                    break;
                                }
                            case 122:
                                Usage.Builder builder7 = this.usage_ != null ? (Usage.Builder) this.usage_.toBuilder() : null;
                                this.usage_ = codedInputStream.readMessage(Usage.parser(), extensionRegistryLite);
                                if (builder7 == null) {
                                    break;
                                } else {
                                    builder7.mergeFrom(this.usage_);
                                    this.usage_ = builder7.buildPartial();
                                    break;
                                }
                            case 146:
                                if (!this.endpoints_.isModifiable()) {
                                    this.endpoints_ = GeneratedMessageLite.mutableCopy(this.endpoints_);
                                }
                                this.endpoints_.add(codedInputStream.readMessage(Endpoint.parser(), extensionRegistryLite));
                                break;
                            case 162:
                                UInt32Value.Builder builder8 = this.configVersion_ != null ? (UInt32Value.Builder) this.configVersion_.toBuilder() : null;
                                this.configVersion_ = codedInputStream.readMessage(UInt32Value.parser(), extensionRegistryLite);
                                if (builder8 == null) {
                                    break;
                                } else {
                                    builder8.mergeFrom(this.configVersion_);
                                    this.configVersion_ = builder8.buildPartial();
                                    break;
                                }
                            case 170:
                                Control.Builder builder9 = this.control_ != null ? (Control.Builder) this.control_.toBuilder() : null;
                                this.control_ = codedInputStream.readMessage(Control.parser(), extensionRegistryLite);
                                if (builder9 == null) {
                                    break;
                                } else {
                                    builder9.mergeFrom(this.control_);
                                    this.control_ = builder9.buildPartial();
                                    break;
                                }
                            case 178:
                                this.producerProjectId_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 186:
                                if (!this.logs_.isModifiable()) {
                                    this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
                                }
                                this.logs_.add(codedInputStream.readMessage(LogDescriptor.parser(), extensionRegistryLite));
                                break;
                            case 194:
                                if (!this.metrics_.isModifiable()) {
                                    this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_);
                                }
                                this.metrics_.add(codedInputStream.readMessage(MetricDescriptor.parser(), extensionRegistryLite));
                                break;
                            case XMPError.BADRDF:
                                if (!this.monitoredResources_.isModifiable()) {
                                    this.monitoredResources_ = GeneratedMessageLite.mutableCopy(this.monitoredResources_);
                                }
                                this.monitoredResources_.add(codedInputStream.readMessage(MonitoredResourceDescriptor.parser(), extensionRegistryLite));
                                break;
                            case 210:
                                Billing.Builder builder10 = this.billing_ != null ? (Billing.Builder) this.billing_.toBuilder() : null;
                                this.billing_ = codedInputStream.readMessage(Billing.parser(), extensionRegistryLite);
                                if (builder10 == null) {
                                    break;
                                } else {
                                    builder10.mergeFrom(this.billing_);
                                    this.billing_ = builder10.buildPartial();
                                    break;
                                }
                            case JfifUtil.MARKER_SOS:
                                Logging.Builder builder11 = this.logging_ != null ? (Logging.Builder) this.logging_.toBuilder() : null;
                                this.logging_ = codedInputStream.readMessage(Logging.parser(), extensionRegistryLite);
                                if (builder11 == null) {
                                    break;
                                } else {
                                    builder11.mergeFrom(this.logging_);
                                    this.logging_ = builder11.buildPartial();
                                    break;
                                }
                            case 226:
                                Monitoring.Builder builder12 = this.monitoring_ != null ? (Monitoring.Builder) this.monitoring_.toBuilder() : null;
                                this.monitoring_ = codedInputStream.readMessage(Monitoring.parser(), extensionRegistryLite);
                                if (builder12 == null) {
                                    break;
                                } else {
                                    builder12.mergeFrom(this.monitoring_);
                                    this.monitoring_ = builder12.buildPartial();
                                    break;
                                }
                            case 234:
                                SystemParameters.Builder builder13 = this.systemParameters_ != null ? (SystemParameters.Builder) this.systemParameters_.toBuilder() : null;
                                this.systemParameters_ = codedInputStream.readMessage(SystemParameters.parser(), extensionRegistryLite);
                                if (builder13 == null) {
                                    break;
                                } else {
                                    builder13.mergeFrom(this.systemParameters_);
                                    this.systemParameters_ = builder13.buildPartial();
                                    break;
                                }
                            case 266:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 298:
                                SourceInfo.Builder builder14 = this.sourceInfo_ != null ? (SourceInfo.Builder) this.sourceInfo_.toBuilder() : null;
                                this.sourceInfo_ = codedInputStream.readMessage(SourceInfo.parser(), extensionRegistryLite);
                                if (builder14 == null) {
                                    break;
                                } else {
                                    builder14.mergeFrom(this.sourceInfo_);
                                    this.sourceInfo_ = builder14.buildPartial();
                                    break;
                                }
                            case 810:
                                Experimental.Builder builder15 = this.experimental_ != null ? (Experimental.Builder) this.experimental_.toBuilder() : null;
                                this.experimental_ = codedInputStream.readMessage(Experimental.parser(), extensionRegistryLite);
                                if (builder15 == null) {
                                    break;
                                } else {
                                    builder15.mergeFrom(this.experimental_);
                                    this.experimental_ = builder15.buildPartial();
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
                    synchronized (Service.class) {
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

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Service> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
