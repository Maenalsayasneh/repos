package h0.v.a;
/* compiled from: BatchingListUpdateCallback.java */
/* loaded from: classes.dex */
public class d implements r {
    public final r a;
    public int b = 0;
    public int c = -1;
    public int d = -1;
    public Object e = null;

    public d(r rVar) {
        this.a = rVar;
    }

    @Override // h0.v.a.r
    public void a(int i, int i2) {
        int i3;
        if (this.b == 1 && i >= (i3 = this.c)) {
            int i4 = this.d;
            if (i <= i3 + i4) {
                this.d = i4 + i2;
                this.c = Math.min(i, i3);
                return;
            }
        }
        e();
        this.c = i;
        this.d = i2;
        this.b = 1;
    }

    @Override // h0.v.a.r
    public void b(int i, int i2) {
        int i3;
        if (this.b != 2 || (i3 = this.c) < i || i3 > i + i2) {
            e();
            this.c = i;
            this.d = i2;
            this.b = 2;
            return;
        }
        this.d += i2;
        this.c = i;
    }

    @Override // h0.v.a.r
    public void c(int i, int i2) {
        e();
        this.a.c(i, i2);
    }

    @Override // h0.v.a.r
    public void d(int i, int i2, Object obj) {
        int i3;
        if (this.b == 3) {
            int i4 = this.c;
            int i5 = this.d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.e == obj) {
                this.c = Math.min(i, i4);
                this.d = Math.max(i5 + i4, i3) - this.c;
                return;
            }
        }
        e();
        this.c = i;
        this.d = i2;
        this.e = obj;
        this.b = 3;
    }

    public void e() {
        int i = this.b;
        if (i != 0) {
            if (i == 1) {
                this.a.a(this.c, this.d);
            } else if (i == 2) {
                this.a.b(this.c, this.d);
            } else if (i == 3) {
                this.a.d(this.c, this.d, this.e);
            }
            this.e = null;
            this.b = 0;
        }
    }
}
