package i0.o.a;

import android.util.LruCache;
import i0.o.a.o;
/* compiled from: LruCache.java */
/* loaded from: classes3.dex */
public class n extends LruCache<String, o.a> {
    public n(o oVar, int i) {
        super(i);
    }

    @Override // android.util.LruCache
    public int sizeOf(String str, o.a aVar) {
        return aVar.b;
    }
}
