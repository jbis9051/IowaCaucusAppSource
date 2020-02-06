package com.swmansion.reanimated.nodes;

import android.util.Log;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.reanimated.NodesManager;
import io.sentry.marshaller.json.JsonMarshaller;

public class DebugNode extends Node {
    private final String mMessage;
    private final int mValueID;

    public DebugNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mMessage = readableMap.getString(JsonMarshaller.MESSAGE);
        this.mValueID = readableMap.getInt(FirebaseAnalytics.Param.VALUE);
    }

    /* access modifiers changed from: protected */
    public Object evaluate() {
        Object value = this.mNodesManager.findNodeById(this.mValueID, Node.class).value();
        Log.d("REANIMATED", String.format("%s %s", new Object[]{this.mMessage, value}));
        return value;
    }
}
