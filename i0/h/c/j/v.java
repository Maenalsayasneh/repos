package i0.h.c.j;

import i0.h.c.q.b;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: LazySet.java */
/* loaded from: classes2.dex */
public class v<T> implements b<Set<T>> {
    public volatile Set<T> b = null;
    public volatile Set<b<T>> a = Collections.newSetFromMap(new ConcurrentHashMap());

    public v(Collection<b<T>> collection) {
        this.a.addAll(collection);
    }

    @Override // i0.h.c.q.b
    public Object get() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = Collections.newSetFromMap(new ConcurrentHashMap());
                    synchronized (this) {
                        for (b<T> bVar : this.a) {
                            this.b.add(bVar.get());
                        }
                        this.a = null;
                    }
                }
            }
        }
        return Collections.unmodifiableSet(this.b);
    }
}
