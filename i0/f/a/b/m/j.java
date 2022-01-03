package i0.f.a.b.m;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: ThreadLocalBufferManager.java */
/* loaded from: classes2.dex */
public class j {
    public final Map<SoftReference<a>, Boolean> a = new ConcurrentHashMap();
    public final ReferenceQueue<a> b = new ReferenceQueue<>();

    /* compiled from: ThreadLocalBufferManager.java */
    /* loaded from: classes2.dex */
    public static final class a {
        public static final j a = new j();
    }
}
