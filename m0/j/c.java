package m0.j;

import java.util.AbstractSet;
import java.util.Set;
import m0.n.b.s.d;
/* compiled from: AbstractMutableSet.kt */
/* loaded from: classes4.dex */
public abstract class c<E> extends AbstractSet<E> implements Set<E>, d {
    public abstract int b();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return b();
    }
}
