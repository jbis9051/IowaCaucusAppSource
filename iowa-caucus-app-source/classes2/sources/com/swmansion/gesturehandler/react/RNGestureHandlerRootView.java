package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.views.view.ReactViewGroup;

public class RNGestureHandlerRootView extends ReactViewGroup {
    @Nullable
    private RNGestureHandlerRootHelper mRootHelper;

    public RNGestureHandlerRootView(Context context) {
        super(context);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.swmansion.gesturehandler.react.RNGestureHandlerRootView, android.view.ViewGroup, com.facebook.react.views.view.ReactViewGroup] */
    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        RNGestureHandlerRootView.super.onAttachedToWindow();
        if (this.mRootHelper == null) {
            this.mRootHelper = new RNGestureHandlerRootHelper(getContext(), this);
        }
    }

    public void tearDown() {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.mRootHelper;
        if (rNGestureHandlerRootHelper != null) {
            rNGestureHandlerRootHelper.tearDown();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (((RNGestureHandlerRootHelper) Assertions.assertNotNull(this.mRootHelper)).dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return RNGestureHandlerRootView.super.dispatchTouchEvent(motionEvent);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        ((RNGestureHandlerRootHelper) Assertions.assertNotNull(this.mRootHelper)).requestDisallowInterceptTouchEvent(z);
        RNGestureHandlerRootView.super.requestDisallowInterceptTouchEvent(z);
    }
}
