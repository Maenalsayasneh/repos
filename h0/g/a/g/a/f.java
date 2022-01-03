package h0.g.a.g.a;
/* compiled from: LinearCurveFit.java */
/* loaded from: classes.dex */
public class f extends b {
    public double[] a;
    public double[][] b;
    public double[] c;

    public f(double[] dArr, double[][] dArr2) {
        int length = dArr2[0].length;
        this.c = new double[length];
        this.a = dArr;
        this.b = dArr2;
        if (length > 2) {
            double d = 0.0d;
            int i = 0;
            double d2 = 0.0d;
            while (i < dArr.length) {
                double d3 = dArr2[i][0];
                double d4 = dArr2[i][0];
                if (i > 0) {
                    Math.hypot(d3 - d, d4 - d2);
                }
                i++;
                d = d3;
                d2 = d4;
            }
        }
    }

    @Override // h0.g.a.g.a.b
    public double b(double d, int i) {
        double[] dArr = this.a;
        int length = dArr.length;
        int i2 = 0;
        if (d <= dArr[0]) {
            return (g(dArr[0], i) * (d - dArr[0])) + this.b[0][i];
        }
        int i3 = length - 1;
        if (d >= dArr[i3]) {
            return (g(dArr[i3], i) * (d - dArr[i3])) + this.b[i3][i];
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.a;
            if (d == dArr2[i2]) {
                return this.b[i2][i];
            }
            int i4 = i2 + 1;
            if (d < dArr2[i4]) {
                double d2 = (d - dArr2[i2]) / (dArr2[i4] - dArr2[i2]);
                double[][] dArr3 = this.b;
                return (dArr3[i4][i] * d2) + ((1.0d - d2) * dArr3[i2][i]);
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
            e(dArr2[0], this.c);
            for (int i2 = 0; i2 < length2; i2++) {
                dArr[i2] = ((d - this.a[0]) * this.c[i2]) + this.b[0][i2];
            }
            return;
        }
        int i3 = length - 1;
        if (d >= dArr2[i3]) {
            e(dArr2[i3], this.c);
            while (i < length2) {
                dArr[i] = ((d - this.a[i3]) * this.c[i]) + this.b[i3][i];
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
                double d2 = (d - dArr3[i4]) / (dArr3[i6] - dArr3[i4]);
                while (i < length2) {
                    double[][] dArr4 = this.b;
                    dArr[i] = (dArr4[i6][i] * d2) + ((1.0d - d2) * dArr4[i4][i]);
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
            e(dArr[0], this.c);
            for (int i2 = 0; i2 < length2; i2++) {
                fArr[i2] = (float) (((d - this.a[0]) * this.c[i2]) + this.b[0][i2]);
            }
            return;
        }
        int i3 = length - 1;
        if (d >= dArr[i3]) {
            e(dArr[i3], this.c);
            while (i < length2) {
                fArr[i] = (float) (((d - this.a[i3]) * this.c[i]) + this.b[i3][i]);
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
                double d2 = (d - dArr2[i4]) / (dArr2[i6] - dArr2[i4]);
                while (i < length2) {
                    double[][] dArr3 = this.b;
                    fArr[i] = (float) ((dArr3[i6][i] * d2) + ((1.0d - d2) * dArr3[i4][i]));
                    i++;
                }
                return;
            }
            i4 = i6;
        }
    }

    @Override // h0.g.a.g.a.b
    public void e(double d, double[] dArr) {
        double[] dArr2 = this.a;
        int length = dArr2.length;
        int length2 = this.b[0].length;
        if (d <= dArr2[0]) {
            d = dArr2[0];
        } else {
            int i = length - 1;
            if (d >= dArr2[i]) {
                d = dArr2[i];
            }
        }
        int i2 = 0;
        while (i2 < length - 1) {
            double[] dArr3 = this.a;
            int i3 = i2 + 1;
            if (d <= dArr3[i3]) {
                double d2 = dArr3[i3] - dArr3[i2];
                double d3 = dArr3[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.b;
                    dArr[i4] = (dArr4[i3][i4] - dArr4[i2][i4]) / d2;
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

    public double g(double d, int i) {
        double[] dArr = this.a;
        int length = dArr.length;
        int i2 = 0;
        if (d < dArr[0]) {
            d = dArr[0];
        } else {
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                d = dArr[i3];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.a;
            int i4 = i2 + 1;
            if (d <= dArr2[i4]) {
                double d2 = dArr2[i4] - dArr2[i2];
                double d3 = dArr2[i2];
                double[][] dArr3 = this.b;
                return (dArr3[i4][i] - dArr3[i2][i]) / d2;
            }
            i2 = i4;
        }
        return 0.0d;
    }
}
