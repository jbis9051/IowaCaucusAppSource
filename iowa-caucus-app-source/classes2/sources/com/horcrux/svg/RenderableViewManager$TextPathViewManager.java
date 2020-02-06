package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

class RenderableViewManager$TextPathViewManager extends RenderableViewManager$TextViewManager {
    RenderableViewManager$TextPathViewManager() {
        super(RenderableViewManager$SVGClass.RNSVGTextPath);
    }

    @ReactProp(name = "href")
    public void setHref(TextPathView textPathView, String str) {
        textPathView.setHref(str);
    }

    @ReactProp(name = "startOffset")
    public void setStartOffset(TextPathView textPathView, Dynamic dynamic) {
        textPathView.setStartOffset(dynamic);
    }

    @ReactProp(name = "method")
    public void setMethod(TextPathView textPathView, @Nullable String str) {
        textPathView.setMethod(str);
    }

    @ReactProp(name = "spacing")
    public void setSpacing(TextPathView textPathView, @Nullable String str) {
        textPathView.setSpacing(str);
    }

    @ReactProp(name = "side")
    public void setSide(TextPathView textPathView, @Nullable String str) {
        textPathView.setSide(str);
    }

    @ReactProp(name = "midLine")
    public void setSharp(TextPathView textPathView, @Nullable String str) {
        textPathView.setSharp(str);
    }
}
