package i0.h.c.j;
/* compiled from: CycleDetector.java */
/* loaded from: classes2.dex */
public class q {
    public final Class<?> a;
    public final boolean b;

    public q(Class cls, boolean z, o oVar) {
        this.a = cls;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!qVar.a.equals(this.a) || qVar.b != this.b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
    }
}
