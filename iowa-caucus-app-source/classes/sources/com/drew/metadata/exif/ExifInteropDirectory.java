package com.drew.metadata.exif;

import com.drew.lang.annotations.NotNull;
import java.util.HashMap;

public class ExifInteropDirectory extends ExifDirectoryBase {
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "Interoperability";
    }

    static {
        addExifTagNames(_tagNameMap);
    }

    public ExifInteropDirectory() {
        setDescriptor(new ExifInteropDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
