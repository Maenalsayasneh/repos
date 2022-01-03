package h0.g.a.g.a;
/* compiled from: CurveFit.java */
/* loaded from: classes.dex */
public abstract class b {

    /* compiled from: CurveFit.java */
    /* loaded from: classes.dex */
    public static class a extends b {
        public double a;
        public double[] b;

        public a(double d, double[] dArr) {
            this.a = d;
            this.b = dArr;
        }

        @Override // h0.g.a.g.a.b
        public double b(double d, int i) {
            return this.b[i];
        }

        @Override // h0.g.a.g.a.b
        public void c(double d, double[] dArr) {
            double[] dArr2 = this.b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // h0.g.a.g.a.b
        public void d(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.b;
                if (i < dArr.length) {
                    fArr[i] = (float) dArr[i];
                    i++;
                } else {
                    return;
                }
            }
        }

        @Override // h0.g.a.g.a.b
        public void e(double d, double[] dArr) {
            for (int i = 0; i < this.b.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        @Override // h0.g.a.g.a.b
        public double[] f() {
            return new double[]{this.a};
        }
    }

    public static b a(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i == 0) {
            return new g(dArr, dArr2);
        }
        if (i != 2) {
            return new f(dArr, dArr2);
        }
        return new a(dArr[0], dArr2[0]);
    }

    public abstract double b(double d, int i);

    public abstract void c(double d, double[] dArr);

    public abstract void d(double d, float[] fArr);

    public abstract void e(double d, double[] dArr);

    public abstract double[] f();
}
