package io.sentry;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapUtil {
    public static JSONObject toJSONObject(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    jSONObject.put(nextKey, (Object) null);
                    break;
                case 2:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 4:
                    jSONObject.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, toJSONObject(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    jSONObject.put(nextKey, ArrayUtil.toJSONArray(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return jSONObject;
    }

    /* renamed from: io.sentry.MapUtil$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.MapUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                obj = ArrayUtil.toArray((JSONArray) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static Map<String, Object> toMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    hashMap.put(nextKey, (Object) null);
                    break;
                case 2:
                    hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    break;
                case 3:
                    hashMap.put(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    break;
                case 4:
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    hashMap.put(nextKey, toMap(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    hashMap.put(nextKey, ArrayUtil.toArray(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return hashMap;
    }

    public static WritableMap toWritableMap(Map<String, Object> map) {
        WritableMap createMap = Arguments.createMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value == null) {
                createMap.putNull((String) next.getKey());
            } else if (value instanceof Boolean) {
                createMap.putBoolean((String) next.getKey(), ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                createMap.putDouble((String) next.getKey(), ((Double) value).doubleValue());
            } else if (value instanceof Integer) {
                createMap.putInt((String) next.getKey(), ((Integer) value).intValue());
            } else if (value instanceof String) {
                createMap.putString((String) next.getKey(), (String) value);
            } else if (value instanceof Map) {
                createMap.putMap((String) next.getKey(), toWritableMap((Map) value));
            } else if (value.getClass() != null && value.getClass().isArray()) {
                createMap.putArray((String) next.getKey(), ArrayUtil.toWritableArray((Object[]) value));
            }
        }
        return createMap;
    }
}
