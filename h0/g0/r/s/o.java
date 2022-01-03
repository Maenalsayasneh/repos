package h0.g0.r.s;

import androidx.work.BackoffPolicy;
import androidx.work.WorkInfo$State;
import h0.g0.b;
import h0.g0.d;
import h0.g0.i;
/* compiled from: WorkSpec.java */
/* loaded from: classes.dex */
public final class o {
    public String a;
    public WorkInfo$State b;
    public String c;
    public String d;
    public d e;
    public d f;
    public long g;
    public long h;
    public long i;
    public b j;
    public int k;
    public BackoffPolicy l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;

    /* compiled from: WorkSpec.java */
    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public WorkInfo$State b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            return this.a.equals(aVar.a);
        }

        public int hashCode() {
            return this.b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    static {
        i.e("WorkSpec");
    }

    public o(String str, String str2) {
        this.b = WorkInfo$State.ENQUEUED;
        d dVar = d.b;
        this.e = dVar;
        this.f = dVar;
        this.j = b.a;
        this.l = BackoffPolicy.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.a = str;
        this.c = str2;
    }

    public long a() {
        long j;
        long j2;
        long j3;
        boolean z = false;
        if (this.b == WorkInfo$State.ENQUEUED && this.k > 0) {
            if (this.l == BackoffPolicy.LINEAR) {
                z = true;
            }
            if (z) {
                j3 = this.m * ((long) this.k);
            } else {
                j3 = (long) Math.scalb((float) this.m, this.k - 1);
            }
            j2 = this.n;
            j = Math.min(18000000L, j3);
        } else {
            long j4 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j5 = this.n;
                int i = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
                if (i == 0) {
                    j5 = this.g + currentTimeMillis;
                }
                long j6 = this.i;
                long j7 = this.h;
                if (j6 != j7) {
                    z = true;
                }
                if (z) {
                    if (i == 0) {
                        j4 = j6 * -1;
                    }
                    return j5 + j7 + j4;
                }
                if (i != 0) {
                    j4 = j7;
                }
                return j5 + j4;
            }
            j = this.n;
            if (j == 0) {
                j = System.currentTimeMillis();
            }
            j2 = this.g;
        }
        return j + j2;
    }

    public boolean b() {
        return !b.a.equals(this.j);
    }

    public boolean c() {
        return this.h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.g != oVar.g || this.h != oVar.h || this.i != oVar.i || this.k != oVar.k || this.m != oVar.m || this.n != oVar.n || this.o != oVar.o || this.p != oVar.p || this.q != oVar.q || !this.a.equals(oVar.a) || this.b != oVar.b || !this.c.equals(oVar.c)) {
            return false;
        }
        String str = this.d;
        if (str == null ? oVar.d == null : str.equals(oVar.d)) {
            return this.e.equals(oVar.e) && this.f.equals(oVar.f) && this.j.equals(oVar.j) && this.l == oVar.l;
        }
        return false;
    }

    public int hashCode() {
        int F = i0.d.a.a.a.F(this.c, (this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31);
        String str = this.d;
        int hashCode = str != null ? str.hashCode() : 0;
        int hashCode2 = this.e.hashCode();
        int hashCode3 = this.f.hashCode();
        long j = this.g;
        long j2 = this.h;
        long j3 = this.i;
        int hashCode4 = this.j.hashCode();
        int hashCode5 = this.l.hashCode();
        long j4 = this.m;
        long j5 = this.n;
        long j6 = this.o;
        long j7 = this.p;
        return ((((((((((hashCode5 + ((((hashCode4 + ((((((((hashCode3 + ((hashCode2 + ((F + hashCode) * 31)) * 31)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.k) * 31)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.q ? 1 : 0);
    }

    public String toString() {
        return i0.d.a.a.a.y0(i0.d.a.a.a.P0("{WorkSpec: "), this.a, "}");
    }

    public o(o oVar) {
        this.b = WorkInfo$State.ENQUEUED;
        d dVar = d.b;
        this.e = dVar;
        this.f = dVar;
        this.j = b.a;
        this.l = BackoffPolicy.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.a = oVar.a;
        this.c = oVar.c;
        this.b = oVar.b;
        this.d = oVar.d;
        this.e = new d(oVar.e);
        this.f = new d(oVar.f);
        this.g = oVar.g;
        this.h = oVar.h;
        this.i = oVar.i;
        this.j = new b(oVar.j);
        this.k = oVar.k;
        this.l = oVar.l;
        this.m = oVar.m;
        this.n = oVar.n;
        this.o = oVar.o;
        this.p = oVar.p;
        this.q = oVar.q;
    }
}
