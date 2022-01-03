package i0.f.a.c.t;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ArrayIterator.java */
/* loaded from: classes2.dex */
public class c<T> implements Iterator<T>, Iterable<T> {
    public final T[] c;
    public int d = 0;

    public c(T[] tArr) {
        this.c = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.d < this.c.length;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.d;
        T[] tArr = this.c;
        if (i < tArr.length) {
            this.d = i + 1;
            return tArr[i];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
