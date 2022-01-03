package i0.c.c;
/* compiled from: DoubleCheck.java */
/* loaded from: classes.dex */
public class a<T> implements b<T> {
    public static final Object a = new Object();
    public volatile b<T> b;
    public volatile Object c = a;

    public a(b<T> bVar) {
        this.b = bVar;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // i0.c.c.b
    public T get() {
        T t = (T) this.c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = this.c;
                if (t == obj) {
                    t = this.b.get();
                    a(this.c, t);
                    this.c = t;
                    this.b = null;
                }
            }
        }
        return t;
    }
}
