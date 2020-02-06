package com.horcrux.svg;

import android.graphics.Matrix;
import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.TransformHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.lang.reflect.Array;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class RenderableViewManager extends ViewGroupManager<VirtualView> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final double EPSILON = 1.0E-5d;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final SparseArray<RenderableView> mTagToRenderableView = new SparseArray<>();
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();
    private static final MatrixDecompositionContext sMatrixDecompositionContext = new MatrixDecompositionContext();
    private static final double[] sTransformDecompositionArray = new double[16];
    private final String mClassName;
    private final SVGClass svgClass;

    public LayoutShadowNode createShadowNodeInstance() {
        return new RenderableShadowNode(this);
    }

    public Class<RenderableShadowNode> getShadowNodeClass() {
        return RenderableShadowNode.class;
    }

    private static boolean isZero(double d) {
        return !Double.isNaN(d) && Math.abs(d) < 1.0E-5d;
    }

    private static void decomposeMatrix() {
        double[] dArr = sMatrixDecompositionContext.perspective;
        double[] dArr2 = sMatrixDecompositionContext.scale;
        double[] dArr3 = sMatrixDecompositionContext.skew;
        double[] dArr4 = sMatrixDecompositionContext.translation;
        double[] dArr5 = sMatrixDecompositionContext.rotationDegrees;
        if (!isZero(sTransformDecompositionArray[15])) {
            double[][] dArr6 = (double[][]) Array.newInstance(double.class, new int[]{4, 4});
            double[] dArr7 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    double[] dArr8 = sTransformDecompositionArray;
                    int i3 = (i * 4) + i2;
                    double d = dArr8[i3] / dArr8[15];
                    dArr6[i][i2] = d;
                    if (i2 == 3) {
                        d = 0.0d;
                    }
                    dArr7[i3] = d;
                }
            }
            dArr7[15] = 1.0d;
            if (!isZero(MatrixMathHelper.determinant(dArr7))) {
                if (!isZero(dArr6[0][3]) || !isZero(dArr6[1][3]) || !isZero(dArr6[2][3])) {
                    MatrixMathHelper.multiplyVectorByMatrix(new double[]{dArr6[0][3], dArr6[1][3], dArr6[2][3], dArr6[3][3]}, MatrixMathHelper.transpose(MatrixMathHelper.inverse(dArr7)), dArr);
                } else {
                    dArr[2] = 0.0d;
                    dArr[1] = 0.0d;
                    dArr[0] = 0.0d;
                    dArr[3] = 1.0d;
                }
                System.arraycopy(dArr6[3], 0, dArr4, 0, 3);
                double[][] dArr9 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
                for (int i4 = 0; i4 < 3; i4++) {
                    dArr9[i4][0] = dArr6[i4][0];
                    dArr9[i4][1] = dArr6[i4][1];
                    dArr9[i4][2] = dArr6[i4][2];
                }
                dArr2[0] = MatrixMathHelper.v3Length(dArr9[0]);
                dArr9[0] = MatrixMathHelper.v3Normalize(dArr9[0], dArr2[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr2[1] = MatrixMathHelper.v3Length(dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Normalize(dArr9[1], dArr2[1]);
                dArr3[0] = dArr3[0] / dArr2[1];
                dArr3[1] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[0], 1.0d, -dArr3[1]);
                dArr3[2] = MatrixMathHelper.v3Dot(dArr9[1], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[1], 1.0d, -dArr3[2]);
                dArr2[2] = MatrixMathHelper.v3Length(dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Normalize(dArr9[2], dArr2[2]);
                dArr3[1] = dArr3[1] / dArr2[2];
                dArr3[2] = dArr3[2] / dArr2[2];
                if (MatrixMathHelper.v3Dot(dArr9[0], MatrixMathHelper.v3Cross(dArr9[1], dArr9[2])) < 0.0d) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        dArr2[i5] = dArr2[i5] * -1.0d;
                        double[] dArr10 = dArr9[i5];
                        dArr10[0] = dArr10[0] * -1.0d;
                        double[] dArr11 = dArr9[i5];
                        dArr11[1] = dArr11[1] * -1.0d;
                        double[] dArr12 = dArr9[i5];
                        dArr12[2] = dArr12[2] * -1.0d;
                    }
                }
                dArr5[0] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[2][1], dArr9[2][2])) * 57.29577951308232d);
                dArr5[1] = MatrixMathHelper.roundTo3Places((-Math.atan2(-dArr9[2][0], Math.sqrt((dArr9[2][1] * dArr9[2][1]) + (dArr9[2][2] * dArr9[2][2])))) * 57.29577951308232d);
                dArr5[2] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[1][0], dArr9[0][0])) * 57.29577951308232d);
            }
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        decomposeMatrix();
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[1]));
        view.setRotation((float) sMatrixDecompositionContext.rotationDegrees[2]);
        view.setRotationX((float) sMatrixDecompositionContext.rotationDegrees[0]);
        view.setRotationY((float) sMatrixDecompositionContext.rotationDegrees[1]);
        view.setScaleX((float) sMatrixDecompositionContext.scale[0]);
        view.setScaleY((float) sMatrixDecompositionContext.scale[1]);
        double[] dArr = sMatrixDecompositionContext.perspective;
        if (dArr.length > 2) {
            float f = (float) dArr[2];
            if (f == 0.0f) {
                f = 7.8125E-4f;
            }
            float f2 = -1.0f / f;
            float f3 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            view.setCameraDistance(f3 * f3 * f2 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(PixelUtil.toPixelFromDIP(0.0f));
        view.setTranslationY(PixelUtil.toPixelFromDIP(0.0f));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    static class GroupViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        GroupViewManager() {
            super(SVGClass.RNSVGGroup);
        }

        GroupViewManager(SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "font")
        public void setFont(GroupView groupView, @Nullable ReadableMap readableMap) {
            groupView.setFont(readableMap);
        }

        @ReactProp(name = "fontSize")
        public void setFontSize(GroupView groupView, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = 2.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble(ViewProps.FONT_SIZE, dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString(ViewProps.FONT_SIZE, dynamic.asString());
            } else {
                return;
            }
            groupView.setFont(javaOnlyMap);
        }

        @ReactProp(name = "fontWeight")
        public void setFontWeight(GroupView groupView, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = 2.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble(ViewProps.FONT_WEIGHT, dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString(ViewProps.FONT_WEIGHT, dynamic.asString());
            } else {
                return;
            }
            groupView.setFont(javaOnlyMap);
        }
    }

    static class PathViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        PathViewManager() {
            super(SVGClass.RNSVGPath);
        }

        @ReactProp(name = "d")
        public void setD(PathView pathView, String str) {
            pathView.setD(str);
        }
    }

    static class ImageViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        ImageViewManager() {
            super(SVGClass.RNSVGImage);
        }

        @ReactProp(name = "x")
        public void setX(ImageView imageView, Dynamic dynamic) {
            imageView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(ImageView imageView, Dynamic dynamic) {
            imageView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(ImageView imageView, Dynamic dynamic) {
            imageView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(ImageView imageView, Dynamic dynamic) {
            imageView.setHeight(dynamic);
        }

        @ReactProp(name = "src")
        public void setSrc(ImageView imageView, @Nullable ReadableMap readableMap) {
            imageView.setSrc(readableMap);
        }

        @ReactProp(name = "align")
        public void setAlign(ImageView imageView, String str) {
            imageView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(ImageView imageView, int i) {
            imageView.setMeetOrSlice(i);
        }
    }

    static class CircleViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        CircleViewManager() {
            super(SVGClass.RNSVGCircle);
        }

        @ReactProp(name = "cx")
        public void setCx(CircleView circleView, Dynamic dynamic) {
            circleView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(CircleView circleView, Dynamic dynamic) {
            circleView.setCy(dynamic);
        }

        @ReactProp(name = "r")
        public void setR(CircleView circleView, Dynamic dynamic) {
            circleView.setR(dynamic);
        }
    }

    static class EllipseViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        EllipseViewManager() {
            super(SVGClass.RNSVGEllipse);
        }

        @ReactProp(name = "cx")
        public void setCx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRy(dynamic);
        }
    }

    static class LineViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        LineViewManager() {
            super(SVGClass.RNSVGLine);
        }

        @ReactProp(name = "x1")
        public void setX1(LineView lineView, Dynamic dynamic) {
            lineView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LineView lineView, Dynamic dynamic) {
            lineView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LineView lineView, Dynamic dynamic) {
            lineView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LineView lineView, Dynamic dynamic) {
            lineView.setY2(dynamic);
        }
    }

    static class RectViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        RectViewManager() {
            super(SVGClass.RNSVGRect);
        }

        @ReactProp(name = "x")
        public void setX(RectView rectView, Dynamic dynamic) {
            rectView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(RectView rectView, Dynamic dynamic) {
            rectView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(RectView rectView, Dynamic dynamic) {
            rectView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(RectView rectView, Dynamic dynamic) {
            rectView.setHeight(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RectView rectView, Dynamic dynamic) {
            rectView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RectView rectView, Dynamic dynamic) {
            rectView.setRy(dynamic);
        }
    }

    static class DefsViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        DefsViewManager() {
            super(SVGClass.RNSVGDefs);
        }
    }

    static class UseViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        UseViewManager() {
            super(SVGClass.RNSVGUse);
        }

        @ReactProp(name = "href")
        public void setHref(UseView useView, String str) {
            useView.setHref(str);
        }

        @ReactProp(name = "x")
        public void setX(UseView useView, Dynamic dynamic) {
            useView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(UseView useView, Dynamic dynamic) {
            useView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(UseView useView, Dynamic dynamic) {
            useView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(UseView useView, Dynamic dynamic) {
            useView.setHeight(dynamic);
        }
    }

    static class LinearGradientManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        LinearGradientManager() {
            super(SVGClass.RNSVGLinearGradient);
        }

        @ReactProp(name = "x1")
        public void setX1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY2(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(LinearGradientView linearGradientView, int i) {
            linearGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(LinearGradientView linearGradientView, @Nullable ReadableArray readableArray) {
            linearGradientView.setGradientTransform(readableArray);
        }
    }

    static class RadialGradientManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        RadialGradientManager() {
            super(SVGClass.RNSVGRadialGradient);
        }

        @ReactProp(name = "fx")
        public void setFx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFx(dynamic);
        }

        @ReactProp(name = "fy")
        public void setFy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRy(dynamic);
        }

        @ReactProp(name = "cx")
        public void setCx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCy(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(RadialGradientView radialGradientView, int i) {
            radialGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(RadialGradientView radialGradientView, @Nullable ReadableArray readableArray) {
            radialGradientView.setGradientTransform(readableArray);
        }
    }

    private RenderableViewManager(SVGClass sVGClass) {
        this.svgClass = sVGClass;
        this.mClassName = sVGClass.toString();
    }

    @Nonnull
    public String getName() {
        return this.mClassName;
    }

    @ReactProp(name = "mask")
    public void setMask(VirtualView virtualView, String str) {
        virtualView.setMask(str);
    }

    @ReactProp(name = "markerStart")
    public void setMarkerStart(VirtualView virtualView, String str) {
        virtualView.setMarkerStart(str);
    }

    @ReactProp(name = "markerMid")
    public void setMarkerMid(VirtualView virtualView, String str) {
        virtualView.setMarkerMid(str);
    }

    @ReactProp(name = "markerEnd")
    public void setMarkerEnd(VirtualView virtualView, String str) {
        virtualView.setMarkerEnd(str);
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(VirtualView virtualView, String str) {
        virtualView.setClipPath(str);
    }

    @ReactProp(name = "clipRule")
    public void setClipRule(VirtualView virtualView, int i) {
        virtualView.setClipRule(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(@Nonnull VirtualView virtualView, float f) {
        virtualView.setOpacity(f);
    }

    @ReactProp(name = "fill")
    public void setFill(RenderableView renderableView, @Nullable Dynamic dynamic) {
        renderableView.setFill(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(RenderableView renderableView, float f) {
        renderableView.setFillOpacity(f);
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(RenderableView renderableView, int i) {
        renderableView.setFillRule(i);
    }

    @ReactProp(name = "stroke")
    public void setStroke(RenderableView renderableView, @Nullable Dynamic dynamic) {
        renderableView.setStroke(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(RenderableView renderableView, float f) {
        renderableView.setStrokeOpacity(f);
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(RenderableView renderableView, @Nullable ReadableArray readableArray) {
        renderableView.setStrokeDasharray(readableArray);
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(RenderableView renderableView, float f) {
        renderableView.setStrokeDashoffset(f);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStrokeWidth(dynamic);
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(RenderableView renderableView, float f) {
        renderableView.setStrokeMiterlimit(f);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(RenderableView renderableView, int i) {
        renderableView.setStrokeLinecap(i);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(RenderableView renderableView, int i) {
        renderableView.setStrokeLinejoin(i);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(RenderableView renderableView, int i) {
        renderableView.setVectorEffect(i);
    }

    @ReactProp(name = "matrix")
    public void setMatrix(VirtualView virtualView, Dynamic dynamic) {
        virtualView.setMatrix(dynamic);
    }

    @ReactProp(name = "transform")
    public void setTransform(VirtualView virtualView, Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Array) {
            ReadableArray asArray = dynamic.asArray();
            if (asArray == null) {
                resetTransformProperty(virtualView);
            } else {
                setTransformProperty(virtualView, asArray);
            }
            Matrix matrix = virtualView.getMatrix();
            virtualView.mTransform = matrix;
            virtualView.mTransformInvertible = matrix.invert(virtualView.mInvTransform);
        }
    }

    @ReactProp(name = "propList")
    public void setPropList(RenderableView renderableView, @Nullable ReadableArray readableArray) {
        renderableView.setPropList(readableArray);
    }

    @ReactProp(name = "responsible")
    public void setResponsible(VirtualView virtualView, boolean z) {
        virtualView.setResponsible(z);
    }

    @ReactProp(name = "onLayout")
    public void setOnLayout(VirtualView virtualView, boolean z) {
        virtualView.setOnLayout(z);
    }

    @ReactProp(name = "name")
    public void setName(VirtualView virtualView, String str) {
        virtualView.setName(str);
    }

    /* access modifiers changed from: private */
    public void invalidateSvgView(VirtualView virtualView) {
        SvgView svgView = virtualView.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
        if (virtualView instanceof TextView) {
            ((TextView) virtualView).getTextContainer().clearChildCache();
        }
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull VirtualView virtualView) {
        super.addEventEmitters(themedReactContext, virtualView);
        virtualView.setOnHierarchyChangeListener(new 1(this));
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(@Nonnull VirtualView virtualView) {
        super.onAfterUpdateTransaction(virtualView);
        invalidateSvgView(virtualView);
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public VirtualView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        switch (2.$SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass[this.svgClass.ordinal()]) {
            case 1:
                return new GroupView(themedReactContext);
            case 2:
                return new PathView(themedReactContext);
            case 3:
                return new CircleView(themedReactContext);
            case 4:
                return new EllipseView(themedReactContext);
            case 5:
                return new LineView(themedReactContext);
            case 6:
                return new RectView(themedReactContext);
            case 7:
                return new TextView(themedReactContext);
            case 8:
                return new TSpanView(themedReactContext);
            case 9:
                return new TextPathView(themedReactContext);
            case 10:
                return new ImageView(themedReactContext);
            case 11:
                return new ClipPathView(themedReactContext);
            case 12:
                return new DefsView(themedReactContext);
            case 13:
                return new UseView(themedReactContext);
            case 14:
                return new SymbolView(themedReactContext);
            case 15:
                return new LinearGradientView(themedReactContext);
            case 16:
                return new RadialGradientView(themedReactContext);
            case 17:
                return new PatternView(themedReactContext);
            case 18:
                return new MaskView(themedReactContext);
            case 19:
                return new MarkerView(themedReactContext);
            default:
                throw new IllegalStateException("Unexpected type " + this.svgClass.toString());
        }
    }

    static void setRenderableView(int i, RenderableView renderableView) {
        mTagToRenderableView.put(i, renderableView);
        Runnable runnable = mTagToRunnable.get(i);
        if (runnable != null) {
            runnable.run();
            mTagToRunnable.delete(i);
        }
    }

    static void runWhenViewIsAvailable(int i, Runnable runnable) {
        mTagToRunnable.put(i, runnable);
    }

    @Nullable
    static RenderableView getRenderableViewByTag(int i) {
        return mTagToRenderableView.get(i);
    }

    public void onDropViewInstance(@Nonnull VirtualView virtualView) {
        super.onDropViewInstance(virtualView);
        mTagToRenderableView.remove(virtualView.getId());
    }
}
