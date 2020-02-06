package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.react.bridge.ReactContext;

@SuppressLint({"ViewConstructor"})
class DefsView extends DefinitionView {
    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
    }

    public DefsView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        for (int i = 0; i < getChildCount(); i++) {
            VirtualView childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                childAt.saveDefinition();
            }
        }
    }
}
