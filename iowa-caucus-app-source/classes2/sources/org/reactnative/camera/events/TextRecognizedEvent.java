package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public class TextRecognizedEvent extends Event<TextRecognizedEvent> {
    private static final Pools.SynchronizedPool<TextRecognizedEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private WritableArray mData;

    private TextRecognizedEvent() {
    }

    public static TextRecognizedEvent obtain(int i, WritableArray writableArray) {
        TextRecognizedEvent textRecognizedEvent = (TextRecognizedEvent) EVENTS_POOL.acquire();
        if (textRecognizedEvent == null) {
            textRecognizedEvent = new TextRecognizedEvent();
        }
        textRecognizedEvent.init(i, writableArray);
        return textRecognizedEvent;
    }

    private void init(int i, WritableArray writableArray) {
        TextRecognizedEvent.super.init(i);
        this.mData = writableArray;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_TEXT_RECOGNIZED.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), createEvent());
    }

    private WritableMap createEvent() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "textBlock");
        createMap.putArray("textBlocks", this.mData);
        createMap.putInt("target", getViewTag());
        return createMap;
    }
}
