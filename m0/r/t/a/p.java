package m0.r.t.a;

import java.lang.ref.WeakReference;
import m0.n.b.i;
/* compiled from: moduleByClassLoader.kt */
/* loaded from: classes4.dex */
public final class p {
    public final WeakReference<ClassLoader> a;
    public final int b;

    public p(ClassLoader classLoader) {
        i.e(classLoader, "classLoader");
        this.a = new WeakReference<>(classLoader);
        this.b = System.identityHashCode(classLoader);
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && this.a.get() == ((p) obj).a.get();
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        String classLoader;
        ClassLoader classLoader2 = this.a.get();
        return (classLoader2 == null || (classLoader = classLoader2.toString()) == null) ? "<null>" : classLoader;
    }
}
