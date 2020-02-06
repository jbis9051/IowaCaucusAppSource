package com.horcrux.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

class SvgViewModule$1 implements Runnable {
    final /* synthetic */ int val$attempt;
    final /* synthetic */ ReadableMap val$options;
    final /* synthetic */ Callback val$successCallback;
    final /* synthetic */ int val$tag;

    SvgViewModule$1(int i, ReadableMap readableMap, Callback callback, int i2) {
        this.val$tag = i;
        this.val$options = readableMap;
        this.val$successCallback = callback;
        this.val$attempt = i2;
    }

    public void run() {
        SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(this.val$tag);
        if (svgViewByTag == null) {
            SvgViewManager.runWhenViewIsAvailable(this.val$tag, new Runnable() {
                public void run() {
                    SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(SvgViewModule$1.this.val$tag);
                    if (svgViewByTag != null) {
                        svgViewByTag.setToDataUrlTask(new Runnable() {
                            public void run() {
                                SvgViewModule.access$000(SvgViewModule$1.this.val$tag, SvgViewModule$1.this.val$options, SvgViewModule$1.this.val$successCallback, SvgViewModule$1.this.val$attempt + 1);
                            }
                        });
                    }
                }
            });
        } else if (svgViewByTag.notRendered()) {
            svgViewByTag.setToDataUrlTask(new Runnable() {
                public void run() {
                    SvgViewModule.access$000(SvgViewModule$1.this.val$tag, SvgViewModule$1.this.val$options, SvgViewModule$1.this.val$successCallback, SvgViewModule$1.this.val$attempt + 1);
                }
            });
        } else {
            ReadableMap readableMap = this.val$options;
            if (readableMap != null) {
                this.val$successCallback.invoke(new Object[]{svgViewByTag.toDataURL(readableMap.getInt("width"), this.val$options.getInt("height"))});
                return;
            }
            this.val$successCallback.invoke(new Object[]{svgViewByTag.toDataURL()});
        }
    }
}
