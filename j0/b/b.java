package j0.b;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: MapBuilder.java */
/* loaded from: classes4.dex */
public final class b<K, V> {
    public final Map<K, V> a;

    public b(int i) {
        this.a = new LinkedHashMap(i < 3 ? i + 1 : i < 1073741824 ? (int) ((((float) i) / 0.75f) + 1.0f) : Integer.MAX_VALUE);
    }

    public Map<K, V> a() {
        if (this.a.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.a);
    }
}
