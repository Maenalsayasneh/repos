package h0.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> c;
    public c<K, V> d;
    public WeakHashMap<f<K, V>, Boolean> q = new WeakHashMap<>();
    public int x = 0;

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // h0.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.x;
        }

        @Override // h0.c.a.b.b.e
        public c<K, V> d(c<K, V> cVar) {
            return cVar.q;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: h0.c.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0055b<K, V> extends e<K, V> {
        public C0055b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // h0.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.q;
        }

        @Override // h0.c.a.b.b.e
        public c<K, V> d(c<K, V> cVar) {
            return cVar.x;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        public final K c;
        public final V d;
        public c<K, V> q;
        public c<K, V> x;

        public c(K k, V v) {
            this.c = k;
            this.d = v;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.c.equals(cVar.c) && this.d.equals(cVar.d);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.d;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.c.hashCode() ^ this.d.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        @Override // java.lang.Object
        public String toString() {
            return this.c + "=" + this.d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> c;
        public boolean d = true;

        public d() {
        }

        @Override // h0.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.c;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.x;
                this.c = cVar3;
                this.d = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.d) {
                return b.this.c != null;
            }
            c<K, V> cVar = this.c;
            return (cVar == null || cVar.q == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.d) {
                this.d = false;
                this.c = b.this.c;
            } else {
                c<K, V> cVar = this.c;
                this.c = cVar != null ? cVar.q : null;
            }
            return this.c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> c;
        public c<K, V> d;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.c = cVar2;
            this.d = cVar;
        }

        @Override // h0.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.c == cVar && cVar == this.d) {
                this.d = null;
                this.c = null;
            }
            c<K, V> cVar3 = this.c;
            if (cVar3 == cVar) {
                this.c = c(cVar3);
            }
            c<K, V> cVar4 = this.d;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.c;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = d(cVar4);
                }
                this.d = cVar2;
            }
        }

        public abstract c<K, V> c(c<K, V> cVar);

        public abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.d;
            c<K, V> cVar2 = this.c;
            this.d = (cVar == cVar2 || cVar2 == null) ? null : d(cVar);
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> b(K k) {
        c<K, V> cVar = this.c;
        while (cVar != null && !cVar.c.equals(k)) {
            cVar = cVar.q;
        }
        return cVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.q.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public c<K, V> e(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.x++;
        c<K, V> cVar2 = this.d;
        if (cVar2 == null) {
            this.c = cVar;
            this.d = cVar;
            return cVar;
        }
        cVar2.q = cVar;
        cVar.x = cVar2;
        this.d = cVar;
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((h0.c.a.b.b.e) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return true;
     */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.x != bVar.x) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                break;
            }
            e eVar2 = (e) it2;
            if (!eVar2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) eVar.next();
            Object next = eVar2.next();
            if ((entry != null || next == null) && (entry == null || entry.equals(next))) {
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i;
            }
            i += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.c, this.d);
        this.q.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V j(K k, V v) {
        c<K, V> b = b(k);
        if (b != null) {
            return b.d;
        }
        e(k, v);
        return null;
    }

    public V k(K k) {
        c<K, V> b = b(k);
        if (b == null) {
            return null;
        }
        this.x--;
        if (!this.q.isEmpty()) {
            for (f<K, V> fVar : this.q.keySet()) {
                fVar.a(b);
            }
        }
        c<K, V> cVar = b.x;
        if (cVar != null) {
            cVar.q = b.q;
        } else {
            this.c = b.q;
        }
        c<K, V> cVar2 = b.q;
        if (cVar2 != null) {
            cVar2.x = cVar;
        } else {
            this.d = cVar;
        }
        b.q = null;
        b.x = null;
        return b.d;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder P0 = i0.d.a.a.a.P0("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                P0.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    P0.append(", ");
                }
            } else {
                P0.append("]");
                return P0.toString();
            }
        }
    }
}
