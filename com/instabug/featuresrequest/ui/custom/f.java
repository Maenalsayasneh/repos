package com.instabug.featuresrequest.ui.custom;
/* compiled from: ToolbarActionButton.java */
/* loaded from: classes2.dex */
public class f {
    public int a;
    public int b;
    public a c;
    public b d;

    /* compiled from: ToolbarActionButton.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* compiled from: ToolbarActionButton.java */
    /* loaded from: classes2.dex */
    public enum b {
        ICON(0),
        TEXT(1),
        VOTE(2);
        
        private int type;

        b(int i) {
            this.type = i;
        }
    }

    public f(int i, int i2, a aVar, b bVar) {
        this.a = i;
        this.b = i2;
        this.c = aVar;
        this.d = bVar;
    }
}
