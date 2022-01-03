package i0.h.a.b.c.g;

import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import i0.h.a.b.c.g.a;
import i0.h.a.b.c.g.j.d;
import i0.h.a.b.c.g.j.e;
import i0.h.a.b.c.g.j.k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
@Deprecated
/* loaded from: classes2.dex */
public abstract class c {
    public static final Set<c> a = Collections.newSetFromMap(new WeakHashMap());

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface a extends e {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface b extends k {
    }

    @RecentlyNonNull
    public <A extends a.b, R extends h, T extends d<R, A>> T a(@RecentlyNonNull T t) {
        throw new UnsupportedOperationException();
    }

    @RecentlyNonNull
    public <A extends a.b, T extends d<? extends h, A>> T b(@RecentlyNonNull T t) {
        throw new UnsupportedOperationException();
    }

    @RecentlyNonNull
    public Looper c() {
        throw new UnsupportedOperationException();
    }
}
