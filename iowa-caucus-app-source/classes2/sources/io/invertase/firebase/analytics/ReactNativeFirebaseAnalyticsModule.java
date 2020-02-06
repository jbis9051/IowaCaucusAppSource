package io.invertase.firebase.analytics;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import javax.annotation.Nullable;

public class ReactNativeFirebaseAnalyticsModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Analytics";
    private final UniversalFirebaseAnalyticsModule module;

    ReactNativeFirebaseAnalyticsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseAnalyticsModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void logEvent(String str, @Nullable ReadableMap readableMap, Promise promise) {
        this.module.logEvent(str, Arguments.toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$logEvent$0(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$logEvent$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setAnalyticsCollectionEnabled(Boolean bool, Promise promise) {
        this.module.setAnalyticsCollectionEnabled(bool).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setAnalyticsCollectionEnabled$1(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$setAnalyticsCollectionEnabled$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setCurrentScreen(String str, @Nullable String str2, Promise promise) {
        this.module.setAnalyticsCollectionEnabled(getCurrentActivity(), str, str2).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setCurrentScreen$2(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$setCurrentScreen$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setMinimumSessionDuration(double d, Promise promise) {
        this.module.setMinimumSessionDuration((long) d).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setMinimumSessionDuration$3(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$setMinimumSessionDuration$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setSessionTimeoutDuration(double d, Promise promise) {
        this.module.setSessionTimeoutDuration((long) d).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setSessionTimeoutDuration$4(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$setSessionTimeoutDuration$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserId(String str, Promise promise) {
        this.module.setUserId(str).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserId$5(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserId$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserProperty(String str, String str2, Promise promise) {
        this.module.setUserProperty(str, str2).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperty$6(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserProperty$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserProperties(ReadableMap readableMap, Promise promise) {
        this.module.setUserProperties(Arguments.toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperties$7(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserProperties$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void resetAnalyticsData(Promise promise) {
        this.module.resetAnalyticsData().addOnCompleteListener(new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$0;

            {
                this.f$0 = r1;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$resetAnalyticsData$8(this.f$0, task);
            }
        });
    }

    static /* synthetic */ void lambda$resetAnalyticsData$8(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }
}
