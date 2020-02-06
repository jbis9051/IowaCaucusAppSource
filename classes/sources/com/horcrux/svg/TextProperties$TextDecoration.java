package com.horcrux.svg;

import com.facebook.react.uimanager.ViewProps;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

enum TextProperties$TextDecoration {
    None(ViewProps.NONE),
    Underline("underline"),
    Overline("overline"),
    LineThrough("line-through"),
    Blink("blink");
    
    private static final Map<String, TextProperties$TextDecoration> decorationToEnum = null;
    private final String decoration;

    static {
        int i;
        decorationToEnum = new HashMap();
        for (TextProperties$TextDecoration textProperties$TextDecoration : values()) {
            decorationToEnum.put(textProperties$TextDecoration.decoration, textProperties$TextDecoration);
        }
    }

    private TextProperties$TextDecoration(String str) {
        this.decoration = str;
    }

    static TextProperties$TextDecoration getEnum(String str) {
        if (decorationToEnum.containsKey(str)) {
            return decorationToEnum.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    @Nonnull
    public String toString() {
        return this.decoration;
    }
}
