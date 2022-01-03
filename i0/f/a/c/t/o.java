package i0.f.a.c.t;
/* compiled from: PrimitiveArrayBuilder.java */
/* loaded from: classes2.dex */
public abstract class o<T> {
    public T a;
    public a<T> b;
    public a<T> c;
    public int d;

    /* compiled from: PrimitiveArrayBuilder.java */
    /* loaded from: classes2.dex */
    public static final class a<T> {
        public final T a;
        public final int b;
        public a<T> c;

        public a(T t, int i) {
            this.a = t;
            this.b = i;
        }
    }

    public abstract T a(int i);

    public final T b(T t, int i) {
        a<T> aVar = new a<>(t, i);
        if (this.b == null) {
            this.c = aVar;
            this.b = aVar;
        } else {
            a<T> aVar2 = this.c;
            if (aVar2.c == null) {
                aVar2.c = aVar;
                this.c = aVar;
            } else {
                throw new IllegalStateException();
            }
        }
        this.d += i;
        return a(i < 16384 ? i + i : i + (i >> 2));
    }

    public T c(T t, int i) {
        int i2 = this.d + i;
        T a2 = a(i2);
        int i3 = 0;
        for (a<T> aVar = this.b; aVar != null; aVar = aVar.c) {
            System.arraycopy(aVar.a, 0, a2, i3, aVar.b);
            i3 += aVar.b;
        }
        System.arraycopy(t, 0, a2, i3, i);
        int i4 = i3 + i;
        if (i4 == i2) {
            return a2;
        }
        throw new IllegalStateException(i0.d.a.a.a.h0("Should have gotten ", i2, " entries, got ", i4));
    }

    public T d() {
        a<T> aVar = this.c;
        if (aVar != null) {
            this.a = aVar.a;
        }
        this.c = null;
        this.b = null;
        this.d = 0;
        T t = this.a;
        return t == null ? a(12) : t;
    }
}
