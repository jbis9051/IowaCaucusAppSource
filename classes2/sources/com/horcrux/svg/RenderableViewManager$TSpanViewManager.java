package com.horcrux.svg;

import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

class RenderableViewManager$TSpanViewManager extends RenderableViewManager$TextViewManager {
    RenderableViewManager$TSpanViewManager() {
        super(RenderableViewManager$SVGClass.RNSVGTSpan);
    }

    @ReactProp(name = "content")
    public void setContent(TSpanView tSpanView, @Nullable String str) {
        tSpanView.setContent(str);
    }
}
