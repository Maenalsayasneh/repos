package i0.h.a.b.g.h;

import java.util.Map;
/* JADX WARN: Incorrect field signature: TK; */
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public final class q1 implements Comparable<q1>, Map.Entry<K, V> {
    public final Comparable c;
    public V d;
    public final /* synthetic */ n1 q;

    /* JADX WARN: Type inference failed for: r3v1, types: [V, java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public q1(n1 n1Var, Map.Entry<K, V> entry) {
        ?? value = entry.getValue();
        this.q = n1Var;
        this.c = (Comparable) entry.getKey();
        this.d = value;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(q1 q1Var) {
        return this.c.compareTo(q1Var.c);
    }

    @Override // java.lang.Object, java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Comparable comparable = this.c;
        Object key = entry.getKey();
        if (comparable == null) {
            z = key == null;
        } else {
            z = comparable.equals(key);
        }
        if (z) {
            V v = this.d;
            Object value = entry.getValue();
            if (v == 0) {
                z2 = value == null;
            } else {
                z2 = v.equals(value);
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.c;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.d;
    }

    @Override // java.lang.Object, java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.c;
        int i = 0;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.d;
        if (v != 0) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        n1 n1Var = this.q;
        int i = n1.c;
        n1Var.i();
        V v2 = this.d;
        this.d = v;
        return v2;
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.c);
        String valueOf2 = String.valueOf(this.d);
        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 1);
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q1(n1 n1Var, K k, V v) {
        this.q = n1Var;
        this.c = k;
        this.d = v;
    }
}
