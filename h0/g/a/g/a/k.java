package h0.g.a.g.a;
/* compiled from: SpringStopEngine.java */
/* loaded from: classes.dex */
public class k implements m {
    public double b;
    public double c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public double a = 0.5d;
    public int i = 0;

    @Override // h0.g.a.g.a.m
    public boolean a() {
        double d = ((double) this.e) - this.c;
        double d2 = this.b;
        double d3 = (double) this.f;
        return Math.sqrt((((d2 * d) * d) + ((d3 * d3) * ((double) this.g))) / d2) <= ((double) this.h);
    }

    @Override // h0.g.a.g.a.m
    public float b() {
        return 0.0f;
    }

    @Override // h0.g.a.g.a.m
    public float getInterpolation(float f) {
        k kVar = this;
        double d = (double) (f - kVar.d);
        double d2 = kVar.b;
        double d3 = kVar.a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d2 / ((double) kVar.g)) * d) * 4.0d)) + 1.0d);
        double d4 = d / ((double) sqrt);
        int i = 0;
        while (i < sqrt) {
            double d5 = (double) kVar.e;
            double d6 = kVar.c;
            double d7 = (double) kVar.f;
            double d8 = (double) kVar.g;
            double d9 = ((((((-d2) * (d5 - d6)) - (d7 * d3)) / d8) * d4) / 2.0d) + d7;
            double d10 = ((((-((((d4 * d9) / 2.0d) + d5) - d6)) * d2) - (d9 * d3)) / d8) * d4;
            float f2 = (float) (d7 + d10);
            this.f = f2;
            float f3 = (float) ((((d10 / 2.0d) + d7) * d4) + d5);
            this.e = f3;
            int i2 = this.i;
            if (i2 > 0) {
                if (f3 < 0.0f && (i2 & 1) == 1) {
                    this.e = -f3;
                    this.f = -f2;
                }
                float f4 = this.e;
                if (f4 > 1.0f && (i2 & 2) == 2) {
                    this.e = 2.0f - f4;
                    this.f = -this.f;
                }
            }
            i++;
            sqrt = sqrt;
            kVar = this;
        }
        kVar.d = f;
        return kVar.e;
    }
}
