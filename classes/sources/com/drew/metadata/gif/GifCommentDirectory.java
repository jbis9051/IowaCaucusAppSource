package com.drew.metadata.gif;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import com.drew.metadata.StringValue;
import java.util.HashMap;

public class GifCommentDirectory extends Directory {
    public static final int TAG_COMMENT = 1;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "GIF Comment";
    }

    static {
        _tagNameMap.put(1, "Comment");
    }

    public GifCommentDirectory(StringValue stringValue) {
        setDescriptor(new GifCommentDescriptor(this));
        setStringValue(1, stringValue);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
