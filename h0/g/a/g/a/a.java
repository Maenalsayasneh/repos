package h0.g.a.g.a;

import java.util.Arrays;
/* compiled from: ArcCurveFit.java */
/* loaded from: classes.dex */
public class a extends b {
    public final double[] a;
    public C0058a[] b;

    /* compiled from: ArcCurveFit.java */
    /* renamed from: h0.g.a.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0058a {
        public static double[] a = new double[91];
        public double[] b;
        public double c;
        public double d;
        public double e;
        public double f;
        public double g;
        public double h;
        public double i;
        public double j;
        public double k;
        public double l;
        public double m;
        public double n;
        public double o;
        public double p;
        public double q;
        public boolean r;
        public boolean s;

        public C0058a(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            double d7 = d3;
            boolean z = false;
            this.s = false;
            int i2 = 1;
            this.r = i == 1 ? true : z;
            this.d = d;
            this.e = d2;
            this.j = 1.0d / (d2 - d);
            if (3 == i) {
                this.s = true;
            }
            double d8 = d5 - d7;
            double d9 = d6 - d4;
            if (this.s || Math.abs(d8) < 0.001d || Math.abs(d9) < 0.001d) {
                this.s = true;
                this.f = d7;
                this.g = d5;
                this.h = d4;
                this.i = d6;
                double hypot = Math.hypot(d9, d8);
                this.c = hypot;
                this.o = hypot * this.j;
                double d10 = this.e;
                double d11 = this.d;
                this.m = d8 / (d10 - d11);
                this.n = d9 / (d10 - d11);
                return;
            }
            this.b = new double[101];
            boolean z2 = this.r;
            this.k = ((double) (z2 ? -1 : i2)) * d8;
            this.l = d9 * ((double) (z2 ? 1 : -1));
            this.m = z2 ? d5 : d7;
            this.n = z2 ? d4 : d6;
            double d12 = d4 - d6;
            int i3 = 0;
            double d13 = 0.0d;
            double d14 = 0.0d;
            double d15 = 0.0d;
            while (true) {
                double[] dArr = a;
                if (i3 >= dArr.length) {
                    break;
                }
                double radians = Math.toRadians((((double) i3) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d8;
                double cos = Math.cos(radians) * d12;
                if (i3 > 0) {
                    d13 += Math.hypot(sin - d14, cos - d15);
                    a[i3] = d13;
                }
                i3++;
                d15 = cos;
                d14 = sin;
            }
            this.c = d13;
            int i4 = 0;
            while (true) {
                double[] dArr2 = a;
                if (i4 >= dArr2.length) {
                    break;
                }
                dArr2[i4] = dArr2[i4] / d13;
                i4++;
            }
            int i5 = 0;
            while (true) {
                double[] dArr3 = this.b;
                if (i5 < dArr3.length) {
                    double length = ((double) i5) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(a, length);
                    if (binarySearch >= 0) {
                        this.b[i5] = ((double) binarySearch) / ((double) (a.length - 1));
                    } else if (binarySearch == -1) {
                        this.b[i5] = 0.0d;
                    } else {
                        int i6 = -binarySearch;
                        int i7 = i6 - 2;
                        double[] dArr4 = a;
                        this.b[i5] = (((length - dArr4[i7]) / (dArr4[i6 - 1] - dArr4[i7])) + ((double) i7)) / ((double) (dArr4.length - 1));
                    }
                    i5++;
                } else {
                    this.o = this.c * this.j;
                    return;
                }
            }
        }

        public double a() {
            double d = this.k * this.q;
            double hypot = this.o / Math.hypot(d, (-this.l) * this.p);
            if (this.r) {
                d = -d;
            }
            return d * hypot;
        }

        public double b() {
            double d = this.k * this.q;
            double d2 = (-this.l) * this.p;
            double hypot = this.o / Math.hypot(d, d2);
            return this.r ? (-d2) * hypot : d2 * hypot;
        }

        public double c(double d) {
            double d2 = (d - this.d) * this.j;
            double d3 = this.f;
            return ((this.g - d3) * d2) + d3;
        }

        public double d(double d) {
            double d2 = (d - this.d) * this.j;
            double d3 = this.h;
            return ((this.i - d3) * d2) + d3;
        }

        public double e() {
            return (this.k * this.p) + this.m;
        }

        public double f() {
            return (this.l * this.q) + this.n;
        }

        public void g(double d) {
            double d2 = (this.r ? this.e - d : d - this.d) * this.j;
            double d3 = 0.0d;
            if (d2 > 0.0d) {
                d3 = 1.0d;
                if (d2 < 1.0d) {
                    double[] dArr = this.b;
                    double length = d2 * ((double) (dArr.length - 1));
                    int i = (int) length;
                    d3 = ((dArr[i + 1] - dArr[i]) * (length - ((double) i))) + dArr[i];
                }
            }
            double d4 = d3 * 1.5707963267948966d;
            this.p = Math.sin(d4);
            this.q = Math.cos(d4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r5 == 1) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.a = dArr;
        this.b = new C0058a[dArr.length - 1];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            C0058a[] aVarArr = this.b;
            if (i < aVarArr.length) {
                int i4 = iArr[i];
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3) {
                            }
                        }
                        i2 = 2;
                        i3 = i2;
                    }
                    i2 = 1;
                    i3 = i2;
                } else {
                    i3 = 3;
                }
                int i5 = i + 1;
                aVarArr[i] = new C0058a(i3, dArr[i], dArr[i5], dArr2[i][0], dArr2[i][1], dArr2[i5][0], dArr2[i5][1]);
                i = i5;
            } else {
                return;
            }
        }
    }

    @Override // h0.g.a.g.a.b
    public double b(double d, int i) {
        double f;
        double b;
        C0058a[] aVarArr = this.b;
        int i2 = 0;
        if (d < aVarArr[0].d) {
            double d2 = aVarArr[0].d;
            double d3 = d - aVarArr[0].d;
            if (!aVarArr[0].s) {
                aVarArr[0].g(d2);
                if (i == 0) {
                    f = this.b[0].e();
                    b = this.b[0].a();
                } else {
                    f = this.b[0].f();
                    b = this.b[0].b();
                }
                return (b * d3) + f;
            } else if (i == 0) {
                return (d3 * this.b[0].m) + aVarArr[0].c(d2);
            } else {
                return (d3 * this.b[0].n) + aVarArr[0].d(d2);
            }
        } else if (d > aVarArr[aVarArr.length - 1].e) {
            double d4 = aVarArr[aVarArr.length - 1].e;
            double d5 = d - d4;
            int length = aVarArr.length - 1;
            if (i == 0) {
                return (d5 * this.b[length].m) + aVarArr[length].c(d4);
            }
            return (d5 * this.b[length].n) + aVarArr[length].d(d4);
        } else {
            while (true) {
                C0058a[] aVarArr2 = this.b;
                if (i2 >= aVarArr2.length) {
                    return Double.NaN;
                }
                if (d > aVarArr2[i2].e) {
                    i2++;
                } else if (!aVarArr2[i2].s) {
                    aVarArr2[i2].g(d);
                    if (i == 0) {
                        return this.b[i2].e();
                    }
                    return this.b[i2].f();
                } else if (i == 0) {
                    return aVarArr2[i2].c(d);
                } else {
                    return aVarArr2[i2].d(d);
                }
            }
        }
    }

    @Override // h0.g.a.g.a.b
    public void c(double d, double[] dArr) {
        C0058a[] aVarArr = this.b;
        if (d < aVarArr[0].d) {
            double d2 = aVarArr[0].d;
            double d3 = d - aVarArr[0].d;
            if (aVarArr[0].s) {
                double c = aVarArr[0].c(d2);
                C0058a[] aVarArr2 = this.b;
                dArr[0] = (aVarArr2[0].m * d3) + c;
                dArr[1] = (d3 * this.b[0].n) + aVarArr2[0].d(d2);
                return;
            }
            aVarArr[0].g(d2);
            dArr[0] = (this.b[0].a() * d3) + this.b[0].e();
            dArr[1] = (this.b[0].b() * d3) + this.b[0].f();
        } else if (d > aVarArr[aVarArr.length - 1].e) {
            double d4 = aVarArr[aVarArr.length - 1].e;
            double d5 = d - d4;
            int length = aVarArr.length - 1;
            if (aVarArr[length].s) {
                double c2 = aVarArr[length].c(d4);
                C0058a[] aVarArr3 = this.b;
                dArr[0] = (aVarArr3[length].m * d5) + c2;
                dArr[1] = (d5 * this.b[length].n) + aVarArr3[length].d(d4);
                return;
            }
            aVarArr[length].g(d);
            dArr[0] = (this.b[length].a() * d5) + this.b[length].e();
            dArr[1] = (this.b[length].b() * d5) + this.b[length].f();
        } else {
            int i = 0;
            while (true) {
                C0058a[] aVarArr4 = this.b;
                if (i >= aVarArr4.length) {
                    return;
                }
                if (d > aVarArr4[i].e) {
                    i++;
                } else if (aVarArr4[i].s) {
                    dArr[0] = aVarArr4[i].c(d);
                    dArr[1] = this.b[i].d(d);
                    return;
                } else {
                    aVarArr4[i].g(d);
                    dArr[0] = this.b[i].e();
                    dArr[1] = this.b[i].f();
                    return;
                }
            }
        }
    }

    @Override // h0.g.a.g.a.b
    public void d(double d, float[] fArr) {
        C0058a[] aVarArr = this.b;
        if (d < aVarArr[0].d) {
            double d2 = aVarArr[0].d;
            double d3 = d - aVarArr[0].d;
            if (aVarArr[0].s) {
                double c = aVarArr[0].c(d2);
                C0058a[] aVarArr2 = this.b;
                fArr[0] = (float) ((aVarArr2[0].m * d3) + c);
                fArr[1] = (float) ((d3 * this.b[0].n) + aVarArr2[0].d(d2));
                return;
            }
            aVarArr[0].g(d2);
            fArr[0] = (float) ((this.b[0].a() * d3) + this.b[0].e());
            fArr[1] = (float) ((this.b[0].b() * d3) + this.b[0].f());
        } else if (d > aVarArr[aVarArr.length - 1].e) {
            double d4 = aVarArr[aVarArr.length - 1].e;
            double d5 = d - d4;
            int length = aVarArr.length - 1;
            if (aVarArr[length].s) {
                double c2 = aVarArr[length].c(d4);
                C0058a[] aVarArr3 = this.b;
                fArr[0] = (float) ((aVarArr3[length].m * d5) + c2);
                fArr[1] = (float) ((d5 * this.b[length].n) + aVarArr3[length].d(d4));
                return;
            }
            aVarArr[length].g(d);
            fArr[0] = (float) this.b[length].e();
            fArr[1] = (float) this.b[length].f();
        } else {
            int i = 0;
            while (true) {
                C0058a[] aVarArr4 = this.b;
                if (i >= aVarArr4.length) {
                    return;
                }
                if (d > aVarArr4[i].e) {
                    i++;
                } else if (aVarArr4[i].s) {
                    fArr[0] = (float) aVarArr4[i].c(d);
                    fArr[1] = (float) this.b[i].d(d);
                    return;
                } else {
                    aVarArr4[i].g(d);
                    fArr[0] = (float) this.b[i].e();
                    fArr[1] = (float) this.b[i].f();
                    return;
                }
            }
        }
    }

    @Override // h0.g.a.g.a.b
    public void e(double d, double[] dArr) {
        C0058a[] aVarArr = this.b;
        if (d < aVarArr[0].d) {
            d = aVarArr[0].d;
        } else if (d > aVarArr[aVarArr.length - 1].e) {
            d = aVarArr[aVarArr.length - 1].e;
        }
        int i = 0;
        while (true) {
            C0058a[] aVarArr2 = this.b;
            if (i >= aVarArr2.length) {
                return;
            }
            if (d > aVarArr2[i].e) {
                i++;
            } else if (aVarArr2[i].s) {
                dArr[0] = aVarArr2[i].m;
                dArr[1] = aVarArr2[i].n;
                return;
            } else {
                aVarArr2[i].g(d);
                dArr[0] = this.b[i].a();
                dArr[1] = this.b[i].b();
                return;
            }
        }
    }

    @Override // h0.g.a.g.a.b
    public double[] f() {
        return this.a;
    }
}
