package com.horcrux.svg;

class TextProperties {

    enum Direction {
        ltr,
        rtl
    }

    enum FontStyle {
        normal,
        italic,
        oblique
    }

    enum FontVariantLigatures {
        normal,
        none
    }

    enum TextAnchor {
        start,
        middle,
        end
    }

    enum TextLengthAdjust {
        spacing,
        spacingAndGlyphs
    }

    enum TextPathMethod {
        align,
        stretch
    }

    enum TextPathMidLine {
        sharp,
        smooth
    }

    enum TextPathSide {
        left,
        right
    }

    enum TextPathSpacing {
        auto,
        exact
    }

    TextProperties() {
    }
}
