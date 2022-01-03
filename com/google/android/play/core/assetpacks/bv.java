package com.google.android.play.core.assetpacks;
/* loaded from: classes2.dex */
public final class bv extends RuntimeException {
    public final int c;

    public bv(String str) {
        super(str);
        this.c = -1;
    }

    public bv(String str, int i) {
        super(str);
        this.c = i;
    }

    public bv(String str, Exception exc) {
        super(str, exc);
        this.c = -1;
    }

    public bv(String str, Exception exc, int i) {
        super(str, exc);
        this.c = i;
    }
}
