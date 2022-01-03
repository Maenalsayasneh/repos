package i0.h.a.b.g.h;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public class n1<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int c = 0;
    public volatile s1 Y1;
    public final int d;
    public boolean y;
    public List<q1> q = Collections.emptyList();
    public Map<K, V> x = Collections.emptyMap();
    public Map<K, V> Z1 = Collections.emptyMap();

    public n1(int i, m1 m1Var) {
        this.d = i;
    }

    public final int a(K k) {
        int size = this.q.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.q.get(size).c);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.q.get(i2).c);
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: b */
    public final V put(K k, V v) {
        i();
        int a = a(k);
        if (a >= 0) {
            q1 q1Var = this.q.get(a);
            q1Var.q.i();
            V v2 = q1Var.d;
            q1Var.d = v;
            return v2;
        }
        i();
        if (this.q.isEmpty() && !(this.q instanceof ArrayList)) {
            this.q = new ArrayList(this.d);
        }
        int i = -(a + 1);
        if (i >= this.d) {
            return j().put(k, v);
        }
        int size = this.q.size();
        int i2 = this.d;
        if (size == i2) {
            q1 remove = this.q.remove(i2 - 1);
            j().put((K) remove.c, remove.d);
        }
        this.q.add(i, new q1(this, k, v));
        return null;
    }

    public void c() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.y) {
            if (this.x.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.x);
            }
            this.x = map;
            if (this.Z1.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.Z1);
            }
            this.Z1 = map2;
            this.y = true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        i();
        if (!this.q.isEmpty()) {
            this.q.clear();
        }
        if (!this.x.isEmpty()) {
            this.x.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.x.containsKey(comparable);
    }

    public final Map.Entry<K, V> d(int i) {
        return this.q.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.Y1 == null) {
            this.Y1 = new s1(this, null);
        }
        return this.Y1;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return super.equals(obj);
        }
        n1 n1Var = (n1) obj;
        int size = size();
        if (size != n1Var.size()) {
            return false;
        }
        int f = f();
        if (f != n1Var.f()) {
            return ((AbstractSet) entrySet()).equals(n1Var.entrySet());
        }
        for (int i = 0; i < f; i++) {
            if (!d(i).equals(n1Var.d(i))) {
                return false;
            }
        }
        if (f != size) {
            return this.x.equals(n1Var.x);
        }
        return true;
    }

    public final int f() {
        return this.q.size();
    }

    public final V g(int i) {
        i();
        V v = this.q.remove(i).d;
        if (!this.x.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = j().entrySet().iterator();
            this.q.add(new q1(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        if (a >= 0) {
            return this.q.get(a).d;
        }
        return this.x.get(comparable);
    }

    public final Iterable<Map.Entry<K, V>> h() {
        if (this.x.isEmpty()) {
            return (Iterable<Map.Entry<K, V>>) p1.b;
        }
        return this.x.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public int hashCode() {
        int f = f();
        int i = 0;
        for (int i2 = 0; i2 < f; i2++) {
            i += this.q.get(i2).hashCode();
        }
        return this.x.size() > 0 ? i + this.x.hashCode() : i;
    }

    public final void i() {
        if (this.y) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> j() {
        i();
        if (this.x.isEmpty() && !(this.x instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.x = treeMap;
            this.Z1 = treeMap.descendingMap();
        }
        return (SortedMap) this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        i();
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        if (a >= 0) {
            return (V) g(a);
        }
        if (this.x.isEmpty()) {
            return null;
        }
        return this.x.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.x.size() + this.q.size();
    }
}
