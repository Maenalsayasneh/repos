package com.instabug.library.annotation.g;

import java.io.Serializable;
/* compiled from: AspectRatioCalculator.java */
/* loaded from: classes2.dex */
public class a implements Serializable {
    public float c = 0.0f;
    public float d = 0.0f;
    public float q = 0.0f;
    public float x = 0.0f;

    public float a() {
        float f = this.q;
        if (f != 0.0f) {
            float f2 = this.c;
            if (f2 != 0.0f) {
                return f / f2;
            }
        }
        return 1.0f;
    }

    public float b() {
        float f = this.x;
        if (f != 0.0f) {
            float f2 = this.d;
            if (f2 != 0.0f) {
                return f / f2;
            }
        }
        return 1.0f;
    }
}
