package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;
import org.reactnative.facedetector.RNFaceDetector;

public class FaceDetectionErrorEvent extends Event<FaceDetectionErrorEvent> {
    private static final Pools.SynchronizedPool<FaceDetectionErrorEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private RNFaceDetector mFaceDetector;

    public short getCoalescingKey() {
        return 0;
    }

    private FaceDetectionErrorEvent() {
    }

    public static FaceDetectionErrorEvent obtain(int i, RNFaceDetector rNFaceDetector) {
        FaceDetectionErrorEvent faceDetectionErrorEvent = (FaceDetectionErrorEvent) EVENTS_POOL.acquire();
        if (faceDetectionErrorEvent == null) {
            faceDetectionErrorEvent = new FaceDetectionErrorEvent();
        }
        faceDetectionErrorEvent.init(i, rNFaceDetector);
        return faceDetectionErrorEvent;
    }

    private void init(int i, RNFaceDetector rNFaceDetector) {
        FaceDetectionErrorEvent.super.init(i);
        this.mFaceDetector = rNFaceDetector;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_FACE_DETECTION_ERROR.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        createMap.putBoolean("isOperational", rNFaceDetector != null && rNFaceDetector.isOperational());
        return createMap;
    }
}
