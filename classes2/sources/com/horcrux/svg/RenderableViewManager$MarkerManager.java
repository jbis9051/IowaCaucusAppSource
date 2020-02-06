package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.RenderableViewManager;

class RenderableViewManager$MarkerManager extends RenderableViewManager.GroupViewManager {
    RenderableViewManager$MarkerManager() {
        super(RenderableViewManager$SVGClass.RNSVGMarker);
    }

    @ReactProp(name = "refX")
    public void setRefX(MarkerView markerView, Dynamic dynamic) {
        markerView.setRefX(dynamic);
    }

    @ReactProp(name = "refY")
    public void setRefY(MarkerView markerView, Dynamic dynamic) {
        markerView.setRefY(dynamic);
    }

    @ReactProp(name = "markerWidth")
    public void setMarkerWidth(MarkerView markerView, Dynamic dynamic) {
        markerView.setMarkerWidth(dynamic);
    }

    @ReactProp(name = "markerHeight")
    public void setMarkerHeight(MarkerView markerView, Dynamic dynamic) {
        markerView.setMarkerHeight(dynamic);
    }

    @ReactProp(name = "markerUnits")
    public void setMarkerUnits(MarkerView markerView, String str) {
        markerView.setMarkerUnits(str);
    }

    @ReactProp(name = "orient")
    public void setOrient(MarkerView markerView, String str) {
        markerView.setOrient(str);
    }

    @ReactProp(name = "minX")
    public void setMinX(MarkerView markerView, float f) {
        markerView.setMinX(f);
    }

    @ReactProp(name = "minY")
    public void setMinY(MarkerView markerView, float f) {
        markerView.setMinY(f);
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(MarkerView markerView, float f) {
        markerView.setVbWidth(f);
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(MarkerView markerView, float f) {
        markerView.setVbHeight(f);
    }

    @ReactProp(name = "align")
    public void setAlign(MarkerView markerView, String str) {
        markerView.setAlign(str);
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(MarkerView markerView, int i) {
        markerView.setMeetOrSlice(i);
    }
}
