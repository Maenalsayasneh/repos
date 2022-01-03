package com.instabug.survey.f.c;

import java.io.Serializable;
/* compiled from: Frequency.java */
/* loaded from: classes2.dex */
public class d implements Serializable {
    public int c;
    public int d;

    public int a() {
        if (this.d <= 0) {
            this.d = 30;
        }
        return this.d;
    }
}
