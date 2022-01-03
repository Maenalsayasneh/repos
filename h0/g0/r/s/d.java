package h0.g0.r.s;
/* compiled from: Preference.java */
/* loaded from: classes.dex */
public class d {
    public String a;
    public Long b;

    public d(String str, long j) {
        this.a = str;
        this.b = Long.valueOf(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.a.equals(dVar.a)) {
            return false;
        }
        Long l = this.b;
        Long l2 = dVar.b;
        if (l != null) {
            return l.equals(l2);
        }
        return l2 == null;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        Long l = this.b;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public d(String str, boolean z) {
        long j = z ? 1 : 0;
        this.a = str;
        this.b = Long.valueOf(j);
    }
}
