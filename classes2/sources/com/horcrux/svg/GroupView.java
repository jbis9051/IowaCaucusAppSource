package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

@SuppressLint({"ViewConstructor"})
class GroupView extends RenderableView {
    @Nullable
    ReadableMap mFont;
    private GlyphContext mGlyphContext;

    public GroupView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "font")
    public void setFont(@Nullable ReadableMap readableMap) {
        this.mFont = readableMap;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setupGlyphContext(Canvas canvas) {
        RectF rectF = new RectF(canvas.getClipBounds());
        if (this.mMatrix != null) {
            this.mMatrix.mapRect(rectF);
        }
        if (this.mTransform != null) {
            this.mTransform.mapRect(rectF);
        }
        this.mGlyphContext = new GlyphContext(this.mScale, rectF.width(), rectF.height());
    }

    /* access modifiers changed from: package-private */
    public GlyphContext getGlyphContext() {
        return this.mGlyphContext;
    }

    private static <T> T requireNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: package-private */
    public GlyphContext getTextRootGlyphContext() {
        return ((GroupView) requireNonNull(getTextRoot())).getGlyphContext();
    }

    /* access modifiers changed from: package-private */
    public void pushGlyphContext() {
        getTextRootGlyphContext().pushContext(this, this.mFont);
    }

    /* access modifiers changed from: package-private */
    public void popGlyphContext() {
        getTextRootGlyphContext().popContext();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        setupGlyphContext(canvas);
        if (f > 0.01f) {
            clip(canvas, paint);
            drawGroup(canvas, paint, f);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawGroup(Canvas canvas, Paint paint, float f) {
        pushGlyphContext();
        SvgView svgView = getSvgView();
        RectF rectF = new RectF();
        for (int i = 0; i < getChildCount(); i++) {
            RenderableView childAt = getChildAt(i);
            if (!(childAt instanceof MaskView)) {
                if (childAt instanceof VirtualView) {
                    RenderableView renderableView = (VirtualView) childAt;
                    boolean z = renderableView instanceof RenderableView;
                    if (z) {
                        renderableView.mergeProperties(this);
                    }
                    int saveAndSetupCanvas = renderableView.saveAndSetupCanvas(canvas, this.mCTM);
                    renderableView.render(canvas, paint, this.mOpacity * f);
                    RectF clientRect = renderableView.getClientRect();
                    if (clientRect != null) {
                        rectF.union(clientRect);
                    }
                    renderableView.restoreCanvas(canvas, saveAndSetupCanvas);
                    if (z) {
                        renderableView.resetProperties();
                    }
                    if (renderableView.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                } else if (childAt instanceof SvgView) {
                    SvgView svgView2 = (SvgView) childAt;
                    svgView2.drawChildren(canvas);
                    if (svgView2.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                }
            }
        }
        setClientRect(rectF);
        popGlyphContext();
    }

    /* access modifiers changed from: package-private */
    public void drawPath(Canvas canvas, Paint paint, float f) {
        GroupView.super.draw(canvas, paint, f);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        this.mPath = new Path();
        for (int i = 0; i < getChildCount(); i++) {
            VirtualView childAt = getChildAt(i);
            if (!(childAt instanceof MaskView) && (childAt instanceof VirtualView)) {
                VirtualView virtualView = childAt;
                this.mPath.addPath(virtualView.getPath(canvas, paint), virtualView.mMatrix);
            }
        }
        return this.mPath;
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint, Region.Op op) {
        Path path;
        Path path2;
        Path path3 = new Path();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 19) {
            Path.Op valueOf = Path.Op.valueOf(op.name());
            while (i < getChildCount()) {
                VirtualView childAt = getChildAt(i);
                if (!(childAt instanceof MaskView) && (childAt instanceof VirtualView)) {
                    GroupView groupView = childAt;
                    Matrix matrix = groupView.mMatrix;
                    if (groupView instanceof GroupView) {
                        path2 = groupView.getPath(canvas, paint, op);
                    } else {
                        path2 = groupView.getPath(canvas, paint);
                    }
                    path2.transform(matrix);
                    path3.op(path2, valueOf);
                }
                i++;
            }
        } else {
            Region region = new Region(canvas.getClipBounds());
            Region region2 = new Region();
            while (i < getChildCount()) {
                VirtualView childAt2 = getChildAt(i);
                if (!(childAt2 instanceof MaskView) && (childAt2 instanceof VirtualView)) {
                    GroupView groupView2 = childAt2;
                    Matrix matrix2 = groupView2.mMatrix;
                    if (groupView2 instanceof GroupView) {
                        path = groupView2.getPath(canvas, paint, op);
                    } else {
                        path = groupView2.getPath(canvas, paint);
                    }
                    if (matrix2 != null) {
                        path.transform(matrix2);
                    }
                    Region region3 = new Region();
                    region3.setPath(path, region);
                    region2.op(region3, op);
                }
                i++;
            }
            path3.addPath(region2.getBoundaryPath());
        }
        return path3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0064: MOVE  (r5v8 com.horcrux.svg.VirtualView) = (r4v2 com.horcrux.svg.VirtualView)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    int hitTest(float[] r9) {
        /*
            r8 = this;
            boolean r0 = r8.mInvertible
            r1 = -1
            if (r0 == 0) goto L_0x0097
            boolean r0 = r8.mTransformInvertible
            if (r0 != 0) goto L_0x000b
            goto L_0x0097
        L_0x000b:
            r0 = 2
            float[] r0 = new float[r0]
            android.graphics.Matrix r2 = r8.mInvMatrix
            r2.mapPoints(r0, r9)
            android.graphics.Matrix r9 = r8.mInvTransform
            r9.mapPoints(r0)
            r9 = 0
            r2 = r0[r9]
            int r2 = java.lang.Math.round(r2)
            r3 = 1
            r4 = r0[r3]
            int r4 = java.lang.Math.round(r4)
            android.graphics.Path r5 = r8.getClipPath()
            if (r5 == 0) goto L_0x004f
            android.graphics.Path r6 = r8.mClipRegionPath
            if (r6 == r5) goto L_0x0046
            r8.mClipRegionPath = r5
            android.graphics.RectF r6 = new android.graphics.RectF
            r6.<init>()
            r8.mClipBounds = r6
            android.graphics.RectF r6 = r8.mClipBounds
            r5.computeBounds(r6, r3)
            android.graphics.RectF r6 = r8.mClipBounds
            android.graphics.Region r5 = r8.getRegion(r5, r6)
            r8.mClipRegion = r5
        L_0x0046:
            android.graphics.Region r5 = r8.mClipRegion
            boolean r2 = r5.contains(r2, r4)
            if (r2 != 0) goto L_0x004f
            return r1
        L_0x004f:
            int r2 = r8.getChildCount()
            int r2 = r2 - r3
        L_0x0054:
            if (r2 < 0) goto L_0x0097
            android.view.View r4 = r8.getChildAt(r2)
            boolean r5 = r4 instanceof com.horcrux.svg.VirtualView
            if (r5 == 0) goto L_0x007e
            boolean r5 = r4 instanceof com.horcrux.svg.MaskView
            if (r5 == 0) goto L_0x0063
            goto L_0x0094
        L_0x0063:
            r5 = r4
            com.horcrux.svg.VirtualView r5 = (com.horcrux.svg.VirtualView) r5
            int r6 = r5.hitTest(r0)
            if (r6 == r1) goto L_0x0094
            boolean r9 = r5.isResponsible()
            if (r9 != 0) goto L_0x007d
            int r9 = r4.getId()
            if (r6 == r9) goto L_0x0079
            goto L_0x007d
        L_0x0079:
            int r6 = r8.getId()
        L_0x007d:
            return r6
        L_0x007e:
            boolean r5 = r4 instanceof com.horcrux.svg.SvgView
            if (r5 == 0) goto L_0x0094
            r5 = r4
            com.horcrux.svg.SvgView r5 = (com.horcrux.svg.SvgView) r5
            r6 = r0[r9]
            r7 = r0[r3]
            int r5 = r5.reactTagForTouch(r6, r7)
            int r4 = r4.getId()
            if (r5 == r4) goto L_0x0094
            return r5
        L_0x0094:
            int r2 = r2 + -1
            goto L_0x0054
        L_0x0097:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.GroupView.hitTest(float[]):int");
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineTemplate(this, this.mName);
        }
        for (int i = 0; i < getChildCount(); i++) {
            VirtualView childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                childAt.saveDefinition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resetProperties() {
        for (int i = 0; i < getChildCount(); i++) {
            RenderableView childAt = getChildAt(i);
            if (childAt instanceof RenderableView) {
                childAt.resetProperties();
            }
        }
    }
}
