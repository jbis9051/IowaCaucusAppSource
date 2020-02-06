package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public class BarcodesDetectedEvent extends Event<BarcodesDetectedEvent> {
    private static final Pools.SynchronizedPool<BarcodesDetectedEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private WritableArray mBarcodes;

    private BarcodesDetectedEvent() {
    }

    public static BarcodesDetectedEvent obtain(int i, WritableArray writableArray) {
        BarcodesDetectedEvent barcodesDetectedEvent = (BarcodesDetectedEvent) EVENTS_POOL.acquire();
        if (barcodesDetectedEvent == null) {
            barcodesDetectedEvent = new BarcodesDetectedEvent();
        }
        barcodesDetectedEvent.init(i, writableArray);
        return barcodesDetectedEvent;
    }

    private void init(int i, WritableArray writableArray) {
        BarcodesDetectedEvent.super.init(i);
        this.mBarcodes = writableArray;
    }

    public short getCoalescingKey() {
        if (this.mBarcodes.size() > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) this.mBarcodes.size();
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_BARCODES_DETECTED.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "barcode");
        createMap.putArray("barcodes", this.mBarcodes);
        createMap.putInt("target", getViewTag());
        return createMap;
    }
}
