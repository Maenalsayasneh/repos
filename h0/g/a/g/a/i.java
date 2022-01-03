package h0.g.a.g.a;
/* compiled from: Schlick.java */
/* loaded from: classes.dex */
public class i extends c {
    public double d;
    public double e;

    public i(String str) {
        this.c = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.e = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    @Override // h0.g.a.g.a.c
    public double a(double d) {
        double d2 = this.e;
        if (d < d2) {
            return (d2 * d) / (((d2 - d) * this.d) + d);
        }
        return ((d - 1.0d) * (1.0d - d2)) / ((1.0d - d) - ((d2 - d) * this.d));
    }

    @Override // h0.g.a.g.a.c
    public double b(double d) {
        double d2 = this.e;
        if (d < d2) {
            double d3 = this.d;
            double d4 = d3 * d2 * d2;
            double d5 = ((d2 - d) * d3) + d;
            return d4 / (d5 * d5);
        }
        double d6 = this.d;
        double d7 = d2 - 1.0d;
        double d8 = (((d2 - d) * (-d6)) - d) + 1.0d;
        return ((d7 * d6) * d7) / (d8 * d8);
    }
}
