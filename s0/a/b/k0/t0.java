package s0.a.b.k0;
/* loaded from: classes4.dex */
public class t0 {
    public int a;
    public int b;
    public long c;
    public long d;

    public t0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public t0(long j, long j2) {
        this.c = j;
        this.d = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return t0Var.b == this.b && t0Var.a == this.a && t0Var.d == this.d && t0Var.c == this.c;
    }

    public int hashCode() {
        int i = this.a ^ this.b;
        long j = this.c;
        int i2 = (i ^ ((int) j)) ^ ((int) (j >> 32));
        long j2 = this.d;
        return (i2 ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }
}
