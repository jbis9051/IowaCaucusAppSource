package io.sentry;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArrayUtil {
    public static JSONArray toJSONArray(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    jSONArray.put(i, (Object) null);
                    break;
                case 2:
                    jSONArray.put(i, readableArray.getBoolean(i));
                    break;
                case 3:
                    jSONArray.put(i, readableArray.getDouble(i));
                    break;
                case 4:
                    jSONArray.put(i, readableArray.getString(i));
                    break;
                case 5:
                    jSONArray.put(i, MapUtil.toJSONObject(readableArray.getMap(i)));
                    break;
                case 6:
                    jSONArray.put(i, toJSONArray(readableArray.getArray(i)));
                    break;
            }
        }
        return jSONArray;
    }

    /* renamed from: io.sentry.ArrayUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x004b }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.ArrayUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static Object[] toArray(JSONArray jSONArray) throws JSONException {
        Object[] objArr = new Object[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                obj = MapUtil.toMap((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                obj = toArray((JSONArray) obj);
            }
            objArr[i] = obj;
        }
        return objArr;
    }

    public static Object[] toArray(ReadableArray readableArray) {
        Object[] objArr = new Object[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    objArr[i] = null;
                    break;
                case 2:
                    objArr[i] = Boolean.valueOf(readableArray.getBoolean(i));
                    break;
                case 3:
                    objArr[i] = Double.valueOf(readableArray.getDouble(i));
                    break;
                case 4:
                    objArr[i] = readableArray.getString(i);
                    break;
                case 5:
                    objArr[i] = MapUtil.toMap(readableArray.getMap(i));
                    break;
                case 6:
                    objArr[i] = toArray(readableArray.getArray(i));
                    break;
            }
        }
        return objArr;
    }

    public static WritableArray toWritableArray(Object[] objArr) {
        WritableArray createArray = Arguments.createArray();
        for (Boolean bool : objArr) {
            if (bool == null) {
                createArray.pushNull();
            }
            if (bool instanceof Boolean) {
                createArray.pushBoolean(bool.booleanValue());
            }
            if (bool instanceof Double) {
                createArray.pushDouble(((Double) bool).doubleValue());
            }
            if (bool instanceof Integer) {
                createArray.pushInt(bool.intValue());
            }
            if (bool instanceof String) {
                createArray.pushString(bool);
            }
            if (bool instanceof Map) {
                createArray.pushMap(MapUtil.toWritableMap(bool));
            }
            if (bool.getClass().isArray()) {
                createArray.pushArray(toWritableArray((Object[]) bool));
            }
        }
        return createArray;
    }
}
