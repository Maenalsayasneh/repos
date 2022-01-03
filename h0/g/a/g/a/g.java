package h0.g.a.g.a;

import java.lang.reflect.Array;
/* compiled from: MonotonicCurveFit.java */
/* loaded from: classes.dex */
public class g extends b {
    public double[] a;
    public double[][] b;
    public double[][] c;
    public double[] d;

    public g(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.d = new double[length2];
        int i = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, i, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(double.class, length, length2);
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                dArr3[i3][i2] = (dArr2[i4][i2] - dArr2[i3][i2]) / (dArr[i4] - dArr[i3]);
                if (i3 == 0) {
                    dArr4[i3][i2] = dArr3[i3][i2];
                } else {
                    dArr4[i3][i2] = (dArr3[i3 - 1][i2] + dArr3[i3][i2]) * 0.5d;
                }
                i3 = i4;
            }
            dArr4[i][i2] = dArr3[length - 2][i2];
        }
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                if (dArr3[i5][i6] == 0.0d) {
                    dArr4[i5][i6] = 0.0d;
                    dArr4[i5 + 1][i6] = 0.0d;
                } else {
                    double d = dArr4[i5][i6] / dArr3[i5][i6];
                    int i7 = i5 + 1;
                    double d2 = dArr4[i7][i6] / dArr3[i5][i6];
                    double hypot = Math.hypot(d, d2);
                    if (hypot > 9.0d) {
                        double d3 = 3.0d / hypot;
                        dArr4[i5][i6] = d * d3 * dArr3[i5][i6];
                        dArr4[i7][i6] = d3 * d2 * dArr3[i5][i6];
                    }
                }
            }
        }
        this.a = dArr;
        this.b = dArr2;
        this.c = dArr4;
    }

    public static double g(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d2 * 6.0d;
        double d9 = 6.0d * d7 * d3;
        double d10 = 3.0d * d;
        double d11 = d10 * d5 * d7;
        return (d * d5) + (((d11 + (((d10 * d6) * d7) + ((d9 + ((d8 * d4) + ((-6.0d * d7) * d4))) - (d8 * d3)))) - (((2.0d * d) * d6) * d2)) - (((4.0d * d) * d5) * d2));
    }

    public static double i(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d7 * d2;
        double d9 = 3.0d * d7;
        double d10 = d9 * d4;
        double d11 = d * d6;
        double d12 = d11 * d8;
        double d13 = d * d5;
        return (d13 * d2) + ((((d8 * d13) + (d12 + (((((d8 * 2.0d) * d3) + (d10 + ((-2.0d * d8) * d4))) - (d9 * d3)) + d3))) - (d11 * d7)) - (((2.0d * d) * d5) * d7));
    }

    @Override // h0.g.a.g.a.b
    public double b(double d, int i) {
        double[] dArr = this.a;
        int length = dArr.length;
        int i2 = 0;
        if (d <= dArr[0]) {
            return (h(dArr[0], i) * (d - dArr[0])) + this.b[0][i];
        }
        int i3 = length - 1;
        if (d >= dArr[i3]) {
            return (h(dArr[i3], i) * (d - dArr[i3])) + this.b[i3][i];
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.a;
            if (d == dArr2[i2]) {
                return this.b[i2][i];
            }
            int i4 = i2 + 1;
            if (d < dArr2[i4]) {
                double d2 = dArr2[i4] - dArr2[i2];
                double d3 = (d - dArr2[i2]) / d2;
                double[][] dArr3 = this.b;
                double d4 = dArr3[i2][i];
                double d5 = dArr3[i4][i];
                double[][] dArr4 = this.c;
                return i(d2, d3, d4, d5, dArr4[i2][i], dArr4[i4][i]);
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // h0.g.a.g.a.b
    public void c(double d, double[] dArr) {
        double[] dArr2 = this.a;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.b[0].length;
        if (d <= dArr2[0]) {
            e(dArr2[0], this.d);
            for (int i2 = 0; i2 < length2; i2++) {
                dArr[i2] = ((d - this.a[0]) * this.d[i2]) + this.b[0][i2];
            }
            return;
        }
        int i3 = length - 1;
        if (d >= dArr2[i3]) {
            e(dArr2[i3], this.d);
            while (i < length2) {
                dArr[i] = ((d - this.a[i3]) * this.d[i]) + this.b[i3][i];
                i++;
            }
            return;
        }
        int i4 = 0;
        while (i4 < length - 1) {
            if (d == this.a[i4]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = this.b[i4][i5];
                }
            }
            double[] dArr3 = this.a;
            int i6 = i4 + 1;
            if (d < dArr3[i6]) {
                double d2 = dArr3[i6] - dArr3[i4];
                double d3 = (d - dArr3[i4]) / d2;
                while (i < length2) {
                    double[][] dArr4 = this.b;
                    double d4 = dArr4[i4][i];
                    double d5 = dArr4[i6][i];
                    double[][] dArr5 = this.c;
                    dArr[i] = i(d2, d3, d4, d5, dArr5[i4][i], dArr5[i6][i]);
                    i++;
                }
                return;
            }
            i4 = i6;
        }
    }

    @Override // h0.g.a.g.a.b
    public void d(double d, float[] fArr) {
        double[] dArr = this.a;
        int length = dArr.length;
        int i = 0;
        int length2 = this.b[0].length;
        if (d <= dArr[0]) {
            e(dArr[0], this.d);
            for (int i2 = 0; i2 < length2; i2++) {
                fArr[i2] = (float) (((d - this.a[0]) * this.d[i2]) + this.b[0][i2]);
            }
            return;
        }
        int i3 = length - 1;
        if (d >= dArr[i3]) {
            e(dArr[i3], this.d);
            while (i < length2) {
                fArr[i] = (float) (((d - this.a[i3]) * this.d[i]) + this.b[i3][i]);
                i++;
            }
            return;
        }
        int i4 = 0;
        while (i4 < length - 1) {
            if (d == this.a[i4]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) this.b[i4][i5];
                }
            }
            double[] dArr2 = this.a;
            int i6 = i4 + 1;
            if (d < dArr2[i6]) {
                double d2 = dArr2[i6] - dArr2[i4];
                double d3 = (d - dArr2[i4]) / d2;
                while (i < length2) {
                    double[][] dArr3 = this.b;
                    double d4 = dArr3[i4][i];
                    double d5 = dArr3[i6][i];
                    double[][] dArr4 = this.c;
                    fArr[i] = (float) i(d2, d3, d4, d5, dArr4[i4][i], dArr4[i6][i]);
                    i++;
                }
                return;
            }
            i4 = i6;
        }
    }

    @Override // h0.g.a.g.a.b
    public void e(double d, double[] dArr) {
        double d2;
        double[] dArr2 = this.a;
        int length = dArr2.length;
        int length2 = this.b[0].length;
        if (d <= dArr2[0]) {
            d2 = dArr2[0];
        } else {
            int i = length - 1;
            d2 = d >= dArr2[i] ? dArr2[i] : d;
        }
        int i2 = 0;
        while (i2 < length - 1) {
            double[] dArr3 = this.a;
            int i3 = i2 + 1;
            if (d2 <= dArr3[i3]) {
                double d3 = dArr3[i3] - dArr3[i2];
                double d4 = (d2 - dArr3[i2]) / d3;
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.b;
                    double d5 = dArr4[i2][i4];
                    double d6 = dArr4[i3][i4];
                    double[][] dArr5 = this.c;
                    dArr[i4] = g(d3, d4, d5, d6, dArr5[i2][i4], dArr5[i3][i4]) / d3;
                }
                return;
            }
            i2 = i3;
        }
    }

    @Override // h0.g.a.g.a.b
    public double[] f() {
        return this.a;
    }

    public double h(double d, int i) {
        double d2;
        double[] dArr = this.a;
        int length = dArr.length;
        int i2 = 0;
        if (d < dArr[0]) {
            d2 = dArr[0];
        } else {
            int i3 = length - 1;
            d2 = d >= dArr[i3] ? dArr[i3] : d;
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.a;
            int i4 = i2 + 1;
            if (d2 <= dArr2[i4]) {
                double d3 = dArr2[i4] - dArr2[i2];
                double[][] dArr3 = this.b;
                double d4 = dArr3[i2][i];
                double d5 = dArr3[i4][i];
                double[][] dArr4 = this.c;
                return g(d3, (d2 - dArr2[i2]) / d3, d4, d5, dArr4[i2][i], dArr4[i4][i]) / d3;
            }
            i2 = i4;
        }
        return 0.0d;
    }
}
