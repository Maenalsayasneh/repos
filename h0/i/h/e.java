package h0.i.h;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class e<T> extends d<T> {
    public final Object c = new Object();

    public e(int i) {
        super(i);
    }

    @Override // h0.i.h.d
    public T a() {
        T t;
        synchronized (this.c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // h0.i.h.d
    public boolean b(T t) {
        boolean b;
        synchronized (this.c) {
            b = super.b(t);
        }
        return b;
    }
}
