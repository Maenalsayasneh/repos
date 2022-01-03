package h0.t;
/* compiled from: NavOptions.java */
/* loaded from: classes.dex */
public final class q {
    public boolean a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;

    public q(boolean z, int i, boolean z2, int i2, int i3, int i4, int i5) {
        this.a = z;
        this.b = i;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.b == qVar.b && this.c == qVar.c && this.d == qVar.d && this.e == qVar.e && this.f == qVar.f && this.g == qVar.g;
    }

    public int hashCode() {
        return ((((((((((((this.a ? 1 : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0)) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
    }
}
