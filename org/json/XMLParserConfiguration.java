package org.json;
/* loaded from: classes4.dex */
public class XMLParserConfiguration {
    public final String cDataTagName;
    public final boolean convertNilAttributeToNull;
    public final boolean keepStrings;
    public static final XMLParserConfiguration ORIGINAL = new XMLParserConfiguration();
    public static final XMLParserConfiguration KEEP_STRINGS = new XMLParserConfiguration(true);

    public XMLParserConfiguration() {
        this(false, "content", false);
    }

    public XMLParserConfiguration(boolean z) {
        this(z, "content", false);
    }

    public XMLParserConfiguration(String str) {
        this(false, str, false);
    }

    public XMLParserConfiguration(boolean z, String str) {
        this.keepStrings = z;
        this.cDataTagName = str;
        this.convertNilAttributeToNull = false;
    }

    public XMLParserConfiguration(boolean z, String str, boolean z2) {
        this.keepStrings = z;
        this.cDataTagName = str;
        this.convertNilAttributeToNull = z2;
    }
}
