package s0.a.f.b.h;

import s0.a.e.b.b0.c.h3;
/* loaded from: classes4.dex */
public abstract class l {
    public final int a;
    public final long b;
    public final int c;
    public final int d;

    /* loaded from: classes4.dex */
    public static abstract class a<T extends a> {
        public final int a;
        public int b = 0;
        public long c = 0;
        public int d = 0;

        public a(int i) {
            this.a = i;
        }

        public abstract T a();

        public T b(int i) {
            this.d = i;
            return a();
        }

        public T c(int i) {
            this.b = i;
            return a();
        }

        public T d(long j) {
            this.c = j;
            return a();
        }
    }

    public l(a aVar) {
        this.a = aVar.b;
        this.b = aVar.c;
        this.c = aVar.a;
        this.d = aVar.d;
    }

    public byte[] a() {
        byte[] bArr = new byte[32];
        h3.B1(this.a, bArr, 0);
        h3.l2(this.b, bArr, 4);
        h3.B1(this.c, bArr, 12);
        h3.B1(this.d, bArr, 28);
        return bArr;
    }
}
