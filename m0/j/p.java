package m0.j;

import java.util.Iterator;
import m0.n.b.s.a;
/* compiled from: Iterators.kt */
/* loaded from: classes4.dex */
public abstract class p implements Iterator<Long>, a {
    public abstract long a();

    @Override // java.util.Iterator
    public Long next() {
        return Long.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
