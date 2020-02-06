package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class ReactSliderEvent extends Event<ReactSliderEvent> {
    public static final String EVENT_NAME = "topChange";
    private final boolean mFromUser;
    private final double mValue;

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topChange";
    }

    public ReactSliderEvent(int i, double d, boolean z) {
        super(i);
        this.mValue = d;
        this.mFromUser = z;
    }

    public double getValue() {
        return this.mValue;
    }

    public boolean isFromUser() {
        return this.mFromUser;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE, getValue());
        createMap.putBoolean("fromUser", isFromUser());
        return createMap;
    }
}
