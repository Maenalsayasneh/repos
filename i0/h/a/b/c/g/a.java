package i0.h.a.b.c.g;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import h0.b0.v;
import i0.h.a.b.c.g.a.d;
import i0.h.a.b.c.g.c;
import i0.h.a.b.c.g.j.k;
import i0.h.a.b.c.i.b;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes2.dex */
public final class a<O extends d> {
    public final AbstractC0143a<?, O> a;
    public final g<?> b;
    public final String c;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    /* renamed from: i0.h.a.b.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0143a<T extends f, O> extends e<T, O> {
        @RecentlyNonNull
        @Deprecated
        public T a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull i0.h.a.b.c.i.c cVar, @RecentlyNonNull O o, @RecentlyNonNull c.a aVar, @RecentlyNonNull c.b bVar) {
            return b(context, looper, cVar, o, aVar, bVar);
        }

        @RecentlyNonNull
        public T b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull i0.h.a.b.c.i.c cVar, @RecentlyNonNull O o, @RecentlyNonNull i0.h.a.b.c.g.j.e eVar, @RecentlyNonNull k kVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    /* loaded from: classes2.dex */
    public interface b {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    /* loaded from: classes2.dex */
    public static class c<C extends b> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    /* loaded from: classes2.dex */
    public interface d {
        @RecentlyNonNull
        public static final c g = new c(null);

        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        /* renamed from: i0.h.a.b.c.g.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface AbstractC0144a extends d {
            @RecentlyNonNull
            Account J();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        /* loaded from: classes2.dex */
        public interface b extends d {
            @RecentlyNullable
            GoogleSignInAccount k();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        /* loaded from: classes2.dex */
        public static final class c implements d {
            public c() {
            }

            public c(k kVar) {
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    /* loaded from: classes2.dex */
    public static abstract class e<T extends b, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    /* loaded from: classes2.dex */
    public interface f extends b {
        Set<Scope> a();

        void b(i0.h.a.b.c.i.g gVar, Set<Scope> set);

        void c(@RecentlyNonNull String str);

        boolean d();

        @RecentlyNonNull
        String e();

        void f(@RecentlyNonNull b.c cVar);

        void g();

        void h(@RecentlyNonNull b.e eVar);

        boolean i();

        boolean isConnected();

        int j();

        @RecentlyNonNull
        Feature[] k();

        @RecentlyNullable
        String l();

        boolean n();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    /* loaded from: classes2.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(@RecentlyNonNull String str, @RecentlyNonNull AbstractC0143a<C, O> aVar, @RecentlyNonNull g<C> gVar) {
        v.A(aVar, "Cannot construct an Api with a null ClientBuilder");
        v.A(gVar, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.a = aVar;
        this.b = gVar;
    }
}
