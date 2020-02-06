package com.horcrux.svg;

import javax.annotation.Nonnull;

public enum SvgView$Events {
    EVENT_DATA_URL("onDataURL");
    
    private final String mName;

    private SvgView$Events(String str) {
        this.mName = str;
    }

    @Nonnull
    public String toString() {
        return this.mName;
    }
}
