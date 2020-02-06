package com.horcrux.svg;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;

class ImageView$1 extends BaseBitmapDataSubscriber {
    final /* synthetic */ ImageView this$0;

    ImageView$1(ImageView imageView) {
        this.this$0 = imageView;
    }

    public void onNewResultImpl(Bitmap bitmap) {
        ImageView.access$000(this.this$0).set(false);
        SvgView svgView = this.this$0.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
    }

    public void onFailureImpl(DataSource dataSource) {
        ImageView.access$000(this.this$0).set(false);
        FLog.w("ReactNative", dataSource.getFailureCause(), "RNSVG: fetchDecodedImage failed!", new Object[0]);
    }
}
