package com.horcrux.svg;

import android.view.View;
import android.view.ViewGroup;

class RenderableViewManager$1 implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ RenderableViewManager this$0;

    RenderableViewManager$1(RenderableViewManager renderableViewManager) {
        this.this$0 = renderableViewManager;
    }

    public void onChildViewAdded(View view, View view2) {
        if (view instanceof VirtualView) {
            RenderableViewManager.access$100(this.this$0, (VirtualView) view);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        if (view instanceof VirtualView) {
            RenderableViewManager.access$100(this.this$0, (VirtualView) view);
        }
    }
}
