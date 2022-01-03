package m0.r.t.a.r.o;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
/* compiled from: SmartList.java */
/* loaded from: classes4.dex */
public class i<E> extends AbstractList<E> implements RandomAccess {
    public int c;
    public Object d;

    /* compiled from: SmartList.java */
    /* loaded from: classes4.dex */
    public static class b<T> implements Iterator<T> {
        public static final b c = new b();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* compiled from: SmartList.java */
    /* loaded from: classes4.dex */
    public class c extends d<E> {
        public final int d;

        public c() {
            super(null);
            this.d = ((AbstractList) i.this).modCount;
        }

        @Override // m0.r.t.a.r.o.i.d
        public void a() {
            if (((AbstractList) i.this).modCount != this.d) {
                StringBuilder P0 = i0.d.a.a.a.P0("ModCount: ");
                P0.append(((AbstractList) i.this).modCount);
                P0.append("; expected: ");
                P0.append(this.d);
                throw new ConcurrentModificationException(P0.toString());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            i.this.clear();
        }
    }

    /* compiled from: SmartList.java */
    /* loaded from: classes4.dex */
    public static abstract class d<T> implements Iterator<T> {
        public boolean c;

        public d(a aVar) {
        }

        public abstract void a();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.c;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.c) {
                this.c = true;
                a();
                return (T) i.this.d;
            }
            throw new NoSuchElementException();
        }
    }

    public static /* synthetic */ void b(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) {
            throw new IllegalStateException(format);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(E e) {
        int i = this.c;
        if (i == 0) {
            this.d = e;
        } else if (i == 1) {
            this.d = new Object[]{this.d, e};
        } else {
            Object[] objArr = (Object[]) this.d;
            int length = objArr.length;
            if (i >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = i + 1;
                if (i2 < i3) {
                    i2 = i3;
                }
                Object[] objArr2 = new Object[i2];
                this.d = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.c] = e;
        }
        this.c++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        this.d = null;
        this.c = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.c)) {
            StringBuilder Q0 = i0.d.a.a.a.Q0("Index: ", i, ", Size: ");
            Q0.append(this.c);
            throw new IndexOutOfBoundsException(Q0.toString());
        } else if (i2 == 1) {
            return (E) this.d;
        } else {
            return (E) ((Object[]) this.d)[i];
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        int i = this.c;
        if (i == 0) {
            return b.c;
        }
        if (i == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it != null) {
            return it;
        }
        b(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        int i2;
        E e;
        if (i < 0 || i >= (i2 = this.c)) {
            StringBuilder Q0 = i0.d.a.a.a.Q0("Index: ", i, ", Size: ");
            Q0.append(this.c);
            throw new IndexOutOfBoundsException(Q0.toString());
        }
        if (i2 == 1) {
            e = (E) this.d;
            this.d = null;
        } else {
            Object[] objArr = (Object[]) this.d;
            Object obj = objArr[i];
            if (i2 == 2) {
                this.d = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.c - 1] = null;
            }
            e = (E) obj;
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        int i2;
        if (i < 0 || i >= (i2 = this.c)) {
            StringBuilder Q0 = i0.d.a.a.a.Q0("Index: ", i, ", Size: ");
            Q0.append(this.c);
            throw new IndexOutOfBoundsException(Q0.toString());
        } else if (i2 == 1) {
            E e2 = (E) this.d;
            this.d = e;
            return e2;
        } else {
            Object[] objArr = (Object[]) this.d;
            E e3 = (E) objArr[i];
            objArr[i] = e;
            return e3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr != 0) {
            int length = tArr.length;
            int i = this.c;
            if (i == 1) {
                if (length != 0) {
                    tArr[0] = this.d;
                } else {
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                    tArr2[0] = this.d;
                    return tArr2;
                }
            } else if (length < i) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.d, i, tArr.getClass());
                if (tArr3 != null) {
                    return tArr3;
                }
                b(6);
                throw null;
            } else if (i != 0) {
                System.arraycopy(this.d, 0, tArr, 0, i);
            }
            int i2 = this.c;
            if (length > i2) {
                tArr[i2] = 0;
            }
            return tArr;
        }
        b(4);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        int i2;
        if (i < 0 || i > (i2 = this.c)) {
            StringBuilder Q0 = i0.d.a.a.a.Q0("Index: ", i, ", Size: ");
            Q0.append(this.c);
            throw new IndexOutOfBoundsException(Q0.toString());
        }
        if (i2 == 0) {
            this.d = e;
        } else if (i2 == 1 && i == 0) {
            this.d = new Object[]{e, this.d};
        } else {
            Object[] objArr = new Object[i2 + 1];
            if (i2 == 1) {
                objArr[0] = this.d;
            } else {
                Object[] objArr2 = (Object[]) this.d;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.c - i);
            }
            objArr[i] = e;
            this.d = objArr;
        }
        this.c++;
        ((AbstractList) this).modCount++;
    }
}
