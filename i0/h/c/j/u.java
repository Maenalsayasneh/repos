package i0.h.c.j;

import i0.h.c.q.b;
/* compiled from: Lazy.java */
/* loaded from: classes2.dex */
public class u<T> implements b<T> {
    public static final Object a = new Object();
    public volatile Object b = a;
    public volatile b<T> c;

    public u(b<T> bVar) {
        this.c = bVar;
    }

    @Override // i0.h.c.q.b
    public T get() {
        T t = (T) this.b;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = this.b;
                if (t == obj) {
                    t = this.c.get();
                    this.b = t;
                    this.c = null;
                }
            }
        }
        return t;
    }
}
