package com.instabug.library.annotation;

import android.graphics.PointF;
import android.graphics.RectF;
import java.io.Serializable;
/* compiled from: DirectionRectF.java */
/* loaded from: classes2.dex */
public class b extends RectF implements Serializable {
    public a c;
    public EnumC0024b d;
    public a q;
    public EnumC0024b x;
    public PointF y = new PointF();
    public PointF Y1 = new PointF();
    public PointF Z1 = new PointF();
    public PointF a2 = new PointF();
    public boolean b2 = false;
    public boolean c2 = true;

    /* compiled from: DirectionRectF.java */
    /* loaded from: classes2.dex */
    public enum a {
        LEFT,
        RIGHT
    }

    /* compiled from: DirectionRectF.java */
    /* renamed from: com.instabug.library.annotation.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0024b {
        TOP,
        BOTTOM
    }

    public b() {
    }

    public PointF a() {
        return new PointF(((RectF) this).right, ((RectF) this).bottom);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            ((RectF) this).bottom = 0.0f;
            ((RectF) this).right = 0.0f;
            ((RectF) this).top = 0.0f;
            ((RectF) this).left = 0.0f;
            this.q = null;
            this.c = null;
            this.x = null;
            this.d = null;
            this.y.set(0.0f, 0.0f);
            this.Y1.set(0.0f, 0.0f);
            this.Z1.set(0.0f, 0.0f);
            this.a2.set(0.0f, 0.0f);
            this.b2 = false;
            this.c2 = true;
            return;
        }
        ((RectF) this).left = ((RectF) bVar).left;
        ((RectF) this).top = ((RectF) bVar).top;
        ((RectF) this).right = ((RectF) bVar).right;
        ((RectF) this).bottom = ((RectF) bVar).bottom;
        this.c = bVar.c;
        this.d = bVar.d;
        this.q = bVar.q;
        this.x = bVar.x;
        this.y.set(bVar.y);
        this.Y1.set(bVar.Y1);
        this.Z1.set(bVar.Z1);
        this.a2.set(bVar.a2);
        this.b2 = bVar.b2;
        this.c2 = bVar.c2;
    }

    public b(b bVar) {
        c(bVar);
    }

    public b(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }
}
