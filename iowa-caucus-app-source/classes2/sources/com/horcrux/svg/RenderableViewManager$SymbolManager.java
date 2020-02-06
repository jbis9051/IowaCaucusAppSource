package com.horcrux.svg;

import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.RenderableViewManager;

class RenderableViewManager$SymbolManager extends RenderableViewManager.GroupViewManager {
    RenderableViewManager$SymbolManager() {
        super(RenderableViewManager$SVGClass.RNSVGSymbol);
    }

    @ReactProp(name = "minX")
    public void setMinX(SymbolView symbolView, float f) {
        symbolView.setMinX(f);
    }

    @ReactProp(name = "minY")
    public void setMinY(SymbolView symbolView, float f) {
        symbolView.setMinY(f);
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(SymbolView symbolView, float f) {
        symbolView.setVbWidth(f);
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(SymbolView symbolView, float f) {
        symbolView.setVbHeight(f);
    }

    @ReactProp(name = "align")
    public void setAlign(SymbolView symbolView, String str) {
        symbolView.setAlign(str);
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(SymbolView symbolView, int i) {
        symbolView.setMeetOrSlice(i);
    }
}
