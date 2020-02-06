package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.RenderableViewManager;
import javax.annotation.Nullable;

class RenderableViewManager$TextViewManager extends RenderableViewManager.GroupViewManager {
    RenderableViewManager$TextViewManager() {
        super(RenderableViewManager$SVGClass.RNSVGText);
    }

    RenderableViewManager$TextViewManager(RenderableViewManager$SVGClass renderableViewManager$SVGClass) {
        super(renderableViewManager$SVGClass);
    }

    @ReactProp(name = "inlineSize")
    public void setInlineSize(TextView textView, Dynamic dynamic) {
        textView.setInlineSize(dynamic);
    }

    @ReactProp(name = "textLength")
    public void setTextLength(TextView textView, Dynamic dynamic) {
        textView.setTextLength(dynamic);
    }

    @ReactProp(name = "lengthAdjust")
    public void setLengthAdjust(TextView textView, @Nullable String str) {
        textView.setLengthAdjust(str);
    }

    @ReactProp(name = "alignmentBaseline")
    public void setMethod(TextView textView, @Nullable String str) {
        textView.setMethod(str);
    }

    @ReactProp(name = "baselineShift")
    public void setBaselineShift(TextView textView, Dynamic dynamic) {
        textView.setBaselineShift(dynamic);
    }

    @ReactProp(name = "verticalAlign")
    public void setVerticalAlign(TextView textView, @Nullable String str) {
        textView.setVerticalAlign(str);
    }

    @ReactProp(name = "rotate")
    public void setRotate(TextView textView, Dynamic dynamic) {
        textView.setRotate(dynamic);
    }

    @ReactProp(name = "dx")
    public void setDeltaX(TextView textView, Dynamic dynamic) {
        textView.setDeltaX(dynamic);
    }

    @ReactProp(name = "dy")
    public void setDeltaY(TextView textView, Dynamic dynamic) {
        textView.setDeltaY(dynamic);
    }

    @ReactProp(name = "x")
    public void setX(TextView textView, Dynamic dynamic) {
        textView.setPositionX(dynamic);
    }

    @ReactProp(name = "y")
    public void setY(TextView textView, Dynamic dynamic) {
        textView.setPositionY(dynamic);
    }

    @ReactProp(name = "font")
    public void setFont(TextView textView, @Nullable ReadableMap readableMap) {
        textView.setFont(readableMap);
    }
}
