package i0.p.a.a;

import android.graphics.RectF;
/* compiled from: CropWindowHandler.java */
/* loaded from: classes4.dex */
public final class e {
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public final RectF a = new RectF();
    public final RectF b = new RectF();
    public float k = 1.0f;
    public float l = 1.0f;

    public static boolean f(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }

    public static boolean g(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    public static boolean h(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    public static boolean i(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    public float a() {
        return Math.min(this.f, this.j / this.l);
    }

    public float b() {
        return Math.min(this.e, this.i / this.k);
    }

    public float c() {
        return Math.max(this.d, this.h / this.l);
    }

    public float d() {
        return Math.max(this.c, this.g / this.k);
    }

    public RectF e() {
        this.b.set(this.a);
        return this.b;
    }

    public boolean j() {
        return this.a.width() >= 100.0f && this.a.height() >= 100.0f;
    }
}
