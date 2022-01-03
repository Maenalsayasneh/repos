package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;
/* loaded from: classes4.dex */
public final class MapEntry<K, V> implements Serializable {
    public final K c;
    public final V d;

    public MapEntry(K k, V v) {
        this.c = k;
        this.d = v;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof MapEntry)) {
            return false;
        }
        MapEntry mapEntry = (MapEntry) obj;
        K k = this.c;
        if (k == null) {
            if (mapEntry.c != null) {
                return false;
            }
        } else if (!k.equals(mapEntry.c)) {
            return false;
        }
        V v = this.d;
        V v2 = mapEntry.d;
        if (v == null) {
            if (v2 != null) {
                return false;
            }
        } else if (!v.equals(v2)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        K k = this.c;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.d;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c + "=" + this.d;
    }
}
