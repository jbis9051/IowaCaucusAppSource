package org.reactnative.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.CamcorderProfile;
import android.os.Build;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.zxing.Result;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.events.BarCodeReadEvent;
import org.reactnative.camera.events.BarcodeDetectionErrorEvent;
import org.reactnative.camera.events.BarcodesDetectedEvent;
import org.reactnative.camera.events.CameraMountErrorEvent;
import org.reactnative.camera.events.CameraReadyEvent;
import org.reactnative.camera.events.FaceDetectionErrorEvent;
import org.reactnative.camera.events.FacesDetectedEvent;
import org.reactnative.camera.events.PictureSavedEvent;
import org.reactnative.camera.events.PictureTakenEvent;
import org.reactnative.camera.events.TextRecognizedEvent;
import org.reactnative.facedetector.RNFaceDetector;

public class RNCameraViewHelper {
    public static final String[][] exifTags = {new String[]{"string", "Artist"}, new String[]{"int", "BitsPerSample"}, new String[]{"int", "Compression"}, new String[]{"string", "Copyright"}, new String[]{"string", "DateTime"}, new String[]{"string", "ImageDescription"}, new String[]{"int", "ImageLength"}, new String[]{"int", "ImageWidth"}, new String[]{"int", "JPEGInterchangeFormat"}, new String[]{"int", "JPEGInterchangeFormatLength"}, new String[]{"string", "Make"}, new String[]{"string", "Model"}, new String[]{"int", "Orientation"}, new String[]{"int", "PhotometricInterpretation"}, new String[]{"int", "PlanarConfiguration"}, new String[]{"double", "PrimaryChromaticities"}, new String[]{"double", "ReferenceBlackWhite"}, new String[]{"int", "ResolutionUnit"}, new String[]{"int", "RowsPerStrip"}, new String[]{"int", "SamplesPerPixel"}, new String[]{"string", "Software"}, new String[]{"int", "StripByteCounts"}, new String[]{"int", "StripOffsets"}, new String[]{"int", "TransferFunction"}, new String[]{"double", "WhitePoint"}, new String[]{"double", "XResolution"}, new String[]{"double", "YCbCrCoefficients"}, new String[]{"int", "YCbCrPositioning"}, new String[]{"int", "YCbCrSubSampling"}, new String[]{"double", "YResolution"}, new String[]{"double", "ApertureValue"}, new String[]{"double", "BrightnessValue"}, new String[]{"string", "CFAPattern"}, new String[]{"int", "ColorSpace"}, new String[]{"string", "ComponentsConfiguration"}, new String[]{"double", "CompressedBitsPerPixel"}, new String[]{"int", "Contrast"}, new String[]{"int", "CustomRendered"}, new String[]{"string", "DateTimeDigitized"}, new String[]{"string", "DateTimeOriginal"}, new String[]{"string", "DeviceSettingDescription"}, new String[]{"double", "DigitalZoomRatio"}, new String[]{"string", "ExifVersion"}, new String[]{"double", "ExposureBiasValue"}, new String[]{"double", "ExposureIndex"}, new String[]{"int", "ExposureMode"}, new String[]{"int", "ExposureProgram"}, new String[]{"double", "ExposureTime"}, new String[]{"double", "FNumber"}, new String[]{"string", "FileSource"}, new String[]{"int", "Flash"}, new String[]{"double", "FlashEnergy"}, new String[]{"string", "FlashpixVersion"}, new String[]{"double", "FocalLength"}, new String[]{"int", "FocalLengthIn35mmFilm"}, new String[]{"int", "FocalPlaneResolutionUnit"}, new String[]{"double", "FocalPlaneXResolution"}, new String[]{"double", "FocalPlaneYResolution"}, new String[]{"int", "GainControl"}, new String[]{"int", "ISOSpeedRatings"}, new String[]{"string", "ImageUniqueID"}, new String[]{"int", "LightSource"}, new String[]{"string", "MakerNote"}, new String[]{"double", "MaxApertureValue"}, new String[]{"int", "MeteringMode"}, new String[]{"int", "NewSubfileType"}, new String[]{"string", "OECF"}, new String[]{"int", "PixelXDimension"}, new String[]{"int", "PixelYDimension"}, new String[]{"string", "RelatedSoundFile"}, new String[]{"int", "Saturation"}, new String[]{"int", "SceneCaptureType"}, new String[]{"string", "SceneType"}, new String[]{"int", "SensingMethod"}, new String[]{"int", "Sharpness"}, new String[]{"double", "ShutterSpeedValue"}, new String[]{"string", "SpatialFrequencyResponse"}, new String[]{"string", "SpectralSensitivity"}, new String[]{"int", "SubfileType"}, new String[]{"string", "SubSecTime"}, new String[]{"string", "SubSecTimeDigitized"}, new String[]{"string", "SubSecTimeOriginal"}, new String[]{"int", "SubjectArea"}, new String[]{"double", "SubjectDistance"}, new String[]{"int", "SubjectDistanceRange"}, new String[]{"int", "SubjectLocation"}, new String[]{"string", "UserComment"}, new String[]{"int", "WhiteBalance"}, new String[]{"int", "GPSAltitudeRef"}, new String[]{"string", "GPSAreaInformation"}, new String[]{"double", "GPSDOP"}, new String[]{"string", "GPSDateStamp"}, new String[]{"double", "GPSDestBearing"}, new String[]{"string", "GPSDestBearingRef"}, new String[]{"double", "GPSDestDistance"}, new String[]{"string", "GPSDestDistanceRef"}, new String[]{"double", "GPSDestLatitude"}, new String[]{"string", "GPSDestLatitudeRef"}, new String[]{"double", "GPSDestLongitude"}, new String[]{"string", "GPSDestLongitudeRef"}, new String[]{"int", "GPSDifferential"}, new String[]{"double", "GPSImgDirection"}, new String[]{"string", "GPSImgDirectionRef"}, new String[]{"string", "GPSLatitudeRef"}, new String[]{"string", "GPSLongitudeRef"}, new String[]{"string", "GPSMapDatum"}, new String[]{"string", "GPSMeasureMode"}, new String[]{"string", "GPSProcessingMethod"}, new String[]{"string", "GPSSatellites"}, new String[]{"double", "GPSSpeed"}, new String[]{"string", "GPSSpeedRef"}, new String[]{"string", "GPSStatus"}, new String[]{"string", "GPSTimeStamp"}, new String[]{"double", "GPSTrack"}, new String[]{"string", "GPSTrackRef"}, new String[]{"string", "GPSVersionID"}, new String[]{"string", "InteroperabilityIndex"}, new String[]{"int", "ThumbnailImageLength"}, new String[]{"int", "ThumbnailImageWidth"}, new String[]{"int", "DNGVersion"}, new String[]{"int", "DefaultCropSize"}, new String[]{"int", "PreviewImageStart"}, new String[]{"int", "PreviewImageLength"}, new String[]{"int", "AspectFrame"}, new String[]{"int", "SensorBottomBorder"}, new String[]{"int", "SensorLeftBorder"}, new String[]{"int", "SensorRightBorder"}, new String[]{"int", "SensorTopBorder"}, new String[]{"int", "ISO"}};

    private static boolean rotationIsLandscape(int i) {
        return i == 90 || i == 270;
    }

    public static void emitMountErrorEvent(final ViewGroup viewGroup, final String str) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(CameraMountErrorEvent.obtain(viewGroup.getId(), str));
            }
        });
    }

    public static void emitCameraReadyEvent(final ViewGroup viewGroup) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(CameraReadyEvent.obtain(viewGroup.getId()));
            }
        });
    }

    public static void emitPictureSavedEvent(final ViewGroup viewGroup, final WritableMap writableMap) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(PictureSavedEvent.obtain(viewGroup.getId(), writableMap));
            }
        });
    }

    public static void emitPictureTakenEvent(final ViewGroup viewGroup) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(PictureTakenEvent.obtain(viewGroup.getId()));
            }
        });
    }

    public static void emitFacesDetectedEvent(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(FacesDetectedEvent.obtain(viewGroup.getId(), writableArray));
            }
        });
    }

    public static void emitFaceDetectionErrorEvent(final ViewGroup viewGroup, final RNFaceDetector rNFaceDetector) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(FaceDetectionErrorEvent.obtain(viewGroup.getId(), rNFaceDetector));
            }
        });
    }

    public static void emitBarcodesDetectedEvent(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(BarcodesDetectedEvent.obtain(viewGroup.getId(), writableArray));
            }
        });
    }

    public static void emitBarcodeDetectionErrorEvent(final ViewGroup viewGroup, final RNBarcodeDetector rNBarcodeDetector) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(BarcodeDetectionErrorEvent.obtain(viewGroup.getId(), rNBarcodeDetector));
            }
        });
    }

    public static void emitBarCodeReadEvent(ViewGroup viewGroup, Result result, int i, int i2) {
        ReactContext context = viewGroup.getContext();
        final ViewGroup viewGroup2 = viewGroup;
        final Result result2 = result;
        final int i3 = i;
        final int i4 = i2;
        final ReactContext reactContext = context;
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(BarCodeReadEvent.obtain(viewGroup2.getId(), result2, i3, i4));
            }
        });
    }

    public static void emitTextRecognizedEvent(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext context = viewGroup.getContext();
        context.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                context.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(TextRecognizedEvent.obtain(viewGroup.getId(), writableArray));
            }
        });
    }

    public static int getCorrectCameraRotation(int i, int i2, int i3) {
        if (i2 == 1) {
            return (i3 + i) % 360;
        }
        return ((i3 - i) + (rotationIsLandscape(i) ? 180 : 0)) % 360;
    }

    private static int getCamcorderProfileQualityFromCameraModuleConstant(int i) {
        if (i == 0) {
            return Build.VERSION.SDK_INT >= 21 ? 8 : 6;
        }
        if (i == 1) {
            return 6;
        }
        if (i != 2) {
            return (i == 3 || i == 4) ? 4 : 1;
        }
        return 5;
    }

    public static CamcorderProfile getCamcorderProfile(int i) {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        int camcorderProfileQualityFromCameraModuleConstant = getCamcorderProfileQualityFromCameraModuleConstant(i);
        if (CamcorderProfile.hasProfile(camcorderProfileQualityFromCameraModuleConstant)) {
            camcorderProfile = CamcorderProfile.get(camcorderProfileQualityFromCameraModuleConstant);
            if (i == 4) {
                camcorderProfile.videoFrameWidth = 640;
            }
        }
        return camcorderProfile;
    }

    public static WritableMap getExifData(ExifInterface exifInterface) {
        WritableMap createMap = Arguments.createMap();
        for (String[] strArr : exifTags) {
            String str = strArr[1];
            if (exifInterface.getAttribute(str) != null) {
                String str2 = strArr[0];
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1325958191) {
                    if (hashCode != -891985903) {
                        if (hashCode == 104431 && str2.equals("int")) {
                            c = 1;
                        }
                    } else if (str2.equals("string")) {
                        c = 0;
                    }
                } else if (str2.equals("double")) {
                    c = 2;
                }
                if (c == 0) {
                    createMap.putString(str, exifInterface.getAttribute(str));
                } else if (c == 1) {
                    createMap.putInt(str, exifInterface.getAttributeInt(str, 0));
                } else if (c == 2) {
                    createMap.putDouble(str, exifInterface.getAttributeDouble(str, 0.0d));
                }
            }
        }
        double[] latLong = exifInterface.getLatLong();
        if (latLong != null) {
            createMap.putDouble("GPSLatitude", latLong[0]);
            createMap.putDouble("GPSLongitude", latLong[1]);
            createMap.putDouble("GPSAltitude", exifInterface.getAltitude(0.0d));
        }
        return createMap;
    }

    public static void setExifData(ExifInterface exifInterface, ReadableMap readableMap) {
        for (String[] strArr : exifTags) {
            String str = strArr[1];
            if (readableMap.hasKey(str)) {
                String str2 = strArr[0];
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1325958191) {
                    if (hashCode != -891985903) {
                        if (hashCode == 104431 && str2.equals("int")) {
                            c = 1;
                        }
                    } else if (str2.equals("string")) {
                        c = 0;
                    }
                } else if (str2.equals("double")) {
                    c = 2;
                }
                if (c == 0) {
                    exifInterface.setAttribute(str, readableMap.getString(str));
                } else if (c == 1) {
                    exifInterface.setAttribute(str, Integer.toString(readableMap.getInt(str)));
                    readableMap.getInt(str);
                } else if (c == 2) {
                    exifInterface.setAttribute(str, Double.toString(readableMap.getDouble(str)));
                    readableMap.getDouble(str);
                }
            }
        }
        if (readableMap.hasKey("GPSLatitude") && readableMap.hasKey("GPSLongitude")) {
            exifInterface.setLatLong(readableMap.getDouble("GPSLatitude"), readableMap.getDouble("GPSLongitude"));
        }
        if (readableMap.hasKey("GPSAltitude")) {
            exifInterface.setAltitude(readableMap.getDouble("GPSAltitude"));
        }
    }

    public static void clearExifData(ExifInterface exifInterface) {
        for (String[] strArr : exifTags) {
            exifInterface.setAttribute(strArr[1], (String) null);
        }
        exifInterface.setAttribute("GPSLatitude", (String) null);
        exifInterface.setAttribute("GPSLongitude", (String) null);
        exifInterface.setAttribute("GPSAltitude", (String) null);
    }

    public static Bitmap generateSimulatorPhoto(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        float f = (float) i;
        float f2 = (float) i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(-256);
        paint2.setTextSize(35.0f);
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G '->' HH:mm:ss z");
        canvas.drawText(simpleDateFormat.format(instance.getTime()), 0.1f * f, f2 * 0.2f, paint2);
        canvas.drawText(simpleDateFormat.format(instance.getTime()), 0.2f * f, f2 * 0.4f, paint2);
        canvas.drawText(simpleDateFormat.format(instance.getTime()), 0.3f * f, 0.6f * f2, paint2);
        canvas.drawText(simpleDateFormat.format(instance.getTime()), f * 0.4f, f2 * 0.8f, paint2);
        return createBitmap;
    }
}
