package h0.g.a.g.a;
/* compiled from: StopLogicEngine.java */
/* loaded from: classes.dex */
public class n implements m {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public boolean k = false;
    public float l;
    public float m;

    @Override // h0.g.a.g.a.m
    public boolean a() {
        return b() < 1.0E-5f && Math.abs(this.i - this.m) < 1.0E-5f;
    }

    @Override // h0.g.a.g.a.m
    public float b() {
        return this.k ? -c(this.m) : c(this.m);
    }

    public float c(float f) {
        float f2;
        float f3;
        float f4 = this.d;
        if (f <= f4) {
            f2 = this.a;
            f3 = this.b;
        } else {
            int i = this.j;
            if (i == 1) {
                return 0.0f;
            }
            f -= f4;
            f4 = this.e;
            if (f < f4) {
                f2 = this.b;
                f3 = this.c;
            } else if (i == 2) {
                return this.h;
            } else {
                float f5 = f - f4;
                float f6 = this.f;
                if (f5 >= f6) {
                    return this.i;
                }
                float f7 = this.c;
                return f7 - ((f5 * f7) / f6);
            }
        }
        return (((f3 - f2) * f) / f4) + f2;
    }

    public final void d(float f, float f2, float f3, float f4, float f5) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.a = f;
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f2 - ((((-f) / f3) * f) / 2.0f)) * f3));
            if (sqrt < f4) {
                this.j = 2;
                this.a = f;
                this.b = sqrt;
                this.c = 0.0f;
                float f8 = (sqrt - f) / f3;
                this.d = f8;
                this.e = sqrt / f3;
                this.g = ((f + sqrt) * f8) / 2.0f;
                this.h = f2;
                this.i = f2;
                return;
            }
            this.j = 3;
            this.a = f;
            this.b = f4;
            this.c = f4;
            float f9 = (f4 - f) / f3;
            this.d = f9;
            float f10 = f4 / f3;
            this.f = f10;
            float f11 = ((f + f4) * f9) / 2.0f;
            float f12 = (f10 * f4) / 2.0f;
            this.e = ((f2 - f11) - f12) / f4;
            this.g = f11;
            this.h = f2 - f12;
            this.i = f2;
        } else if (f7 >= f2) {
            this.j = 1;
            this.a = f;
            this.b = 0.0f;
            this.g = f2;
            this.d = (2.0f * f2) / f;
        } else {
            float f13 = f2 - f7;
            float f14 = f13 / f;
            if (f14 + f6 < f5) {
                this.j = 2;
                this.a = f;
                this.b = f;
                this.c = 0.0f;
                this.g = f13;
                this.h = f2;
                this.d = f14;
                this.e = f6;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) (((f * f) / 2.0f) + (f3 * f2)));
            float f15 = (sqrt2 - f) / f3;
            this.d = f15;
            float f16 = sqrt2 / f3;
            this.e = f16;
            if (sqrt2 < f4) {
                this.j = 2;
                this.a = f;
                this.b = sqrt2;
                this.c = 0.0f;
                this.d = f15;
                this.e = f16;
                this.g = ((f + sqrt2) * f15) / 2.0f;
                this.h = f2;
                return;
            }
            this.j = 3;
            this.a = f;
            this.b = f4;
            this.c = f4;
            float f17 = (f4 - f) / f3;
            this.d = f17;
            float f18 = f4 / f3;
            this.f = f18;
            float f19 = ((f + f4) * f17) / 2.0f;
            float f20 = (f18 * f4) / 2.0f;
            this.e = ((f2 - f19) - f20) / f4;
            this.g = f19;
            this.h = f2 - f20;
            this.i = f2;
        }
    }

    @Override // h0.g.a.g.a.m
    public float getInterpolation(float f) {
        float f2;
        float f3 = this.d;
        if (f <= f3) {
            float f4 = this.a;
            f2 = ((((this.b - f4) * f) * f) / (f3 * 2.0f)) + (f4 * f);
        } else {
            int i = this.j;
            if (i == 1) {
                f2 = this.g;
            } else {
                float f5 = f - f3;
                float f6 = this.e;
                if (f5 < f6) {
                    float f7 = this.g;
                    float f8 = this.b;
                    f2 = ((((this.c - f8) * f5) * f5) / (f6 * 2.0f)) + (f8 * f5) + f7;
                } else if (i == 2) {
                    f2 = this.h;
                } else {
                    float f9 = f5 - f6;
                    float f10 = this.f;
                    if (f9 <= f10) {
                        float f11 = this.h;
                        float f12 = this.c * f9;
                        f2 = (f11 + f12) - ((f12 * f9) / (f10 * 2.0f));
                    } else {
                        f2 = this.i;
                    }
                }
            }
        }
        this.m = f;
        return this.k ? this.l - f2 : this.l + f2;
    }
}
