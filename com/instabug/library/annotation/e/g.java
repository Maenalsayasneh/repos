package com.instabug.library.annotation.e;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/* compiled from: Weight.java */
@SuppressFBWarnings({"EQ_COMPARETO_USE_OBJECT_EQUALS", "UUF_UNUSED_FIELD", "URF_UNREAD_FIELD"})
/* loaded from: classes2.dex */
public class g implements Comparable<g> {
    public float Y1;
    public int Z1;
    public int a2;
    public int b2;
    public int c;
    public int c2;
    public int d;
    public float d2;
    public float q;
    public float x;
    public float y;

    /* compiled from: Weight.java */
    /* loaded from: classes2.dex */
    public enum a {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Override // java.lang.Comparable
    public int compareTo(g gVar) {
        int i = gVar.c;
        int i2 = this.c;
        if (i > i2) {
            return -1;
        }
        return i < i2 ? 1 : 0;
    }
}
