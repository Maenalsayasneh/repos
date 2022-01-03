package com.instabug.survey.ui;
/* compiled from: ViewType.java */
/* loaded from: classes2.dex */
public enum f {
    PARTIAL,
    SECONDARY,
    PRIMARY;

    public static f a(int i, f fVar) {
        if (i > 0) {
            values();
            if (i < 3) {
                return values()[i];
            }
        }
        return fVar;
    }

    public int a() {
        return ordinal();
    }
}
