package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.RenderableViewManager;
import javax.annotation.Nullable;

class RenderableViewManager$PatternManager extends RenderableViewManager.GroupViewManager {
    RenderableViewManager$PatternManager() {
        super(RenderableViewManager$SVGClass.RNSVGPattern);
    }

    @ReactProp(name = "x")
    public void setX(PatternView patternView, Dynamic dynamic) {
        patternView.setX(dynamic);
    }

    @ReactProp(name = "y")
    public void setY(PatternView patternView, Dynamic dynamic) {
        patternView.setY(dynamic);
    }

    @ReactProp(name = "width")
    public void setWidth(PatternView patternView, Dynamic dynamic) {
        patternView.setWidth(dynamic);
    }

    @ReactProp(name = "height")
    public void setHeight(PatternView patternView, Dynamic dynamic) {
        patternView.setHeight(dynamic);
    }

    @ReactProp(name = "patternUnits")
    public void setPatternUnits(PatternView patternView, int i) {
        patternView.setPatternUnits(i);
    }

    @ReactProp(name = "patternContentUnits")
    public void setPatternContentUnits(PatternView patternView, int i) {
        patternView.setPatternContentUnits(i);
    }

    @ReactProp(name = "patternTransform")
    public void setPatternTransform(PatternView patternView, @Nullable ReadableArray readableArray) {
        patternView.setPatternTransform(readableArray);
    }

    @ReactProp(name = "minX")
    public void setMinX(PatternView patternView, float f) {
        patternView.setMinX(f);
    }

    @ReactProp(name = "minY")
    public void setMinY(PatternView patternView, float f) {
        patternView.setMinY(f);
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(PatternView patternView, float f) {
        patternView.setVbWidth(f);
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(PatternView patternView, float f) {
        patternView.setVbHeight(f);
    }

    @ReactProp(name = "align")
    public void setAlign(PatternView patternView, String str) {
        patternView.setAlign(str);
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(PatternView patternView, int i) {
        patternView.setMeetOrSlice(i);
    }
}
