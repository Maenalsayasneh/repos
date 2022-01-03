package m0.j;

import java.util.Iterator;
import m0.n.b.s.a;
/* compiled from: Iterators.kt */
/* loaded from: classes4.dex */
public abstract class o implements Iterator<Integer>, a {
    public abstract int a();

    @Override // java.util.Iterator
    public Integer next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
