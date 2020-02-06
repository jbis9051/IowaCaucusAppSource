package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.RenderableViewManager;
import javax.annotation.Nullable;

class RenderableViewManager$MaskManager extends RenderableViewManager.GroupViewManager {
    RenderableViewManager$MaskManager() {
        super(RenderableViewManager$SVGClass.RNSVGMask);
    }

    @ReactProp(name = "x")
    public void setX(MaskView maskView, Dynamic dynamic) {
        maskView.setX(dynamic);
    }

    @ReactProp(name = "y")
    public void setY(MaskView maskView, Dynamic dynamic) {
        maskView.setY(dynamic);
    }

    @ReactProp(name = "width")
    public void setWidth(MaskView maskView, Dynamic dynamic) {
        maskView.setWidth(dynamic);
    }

    @ReactProp(name = "height")
    public void setHeight(MaskView maskView, Dynamic dynamic) {
        maskView.setHeight(dynamic);
    }

    @ReactProp(name = "maskUnits")
    public void setMaskUnits(MaskView maskView, int i) {
        maskView.setMaskUnits(i);
    }

    @ReactProp(name = "maskContentUnits")
    public void setMaskContentUnits(MaskView maskView, int i) {
        maskView.setMaskContentUnits(i);
    }

    @ReactProp(name = "maskTransform")
    public void setMaskTransform(MaskView maskView, @Nullable ReadableArray readableArray) {
        maskView.setMaskTransform(readableArray);
    }
}
