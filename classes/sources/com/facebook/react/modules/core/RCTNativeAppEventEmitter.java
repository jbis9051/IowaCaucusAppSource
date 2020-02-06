package com.facebook.react.modules.core;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.JavaScriptModule;

public interface RCTNativeAppEventEmitter extends JavaScriptModule {
    void emit(String str, @Nullable Object obj);
}
