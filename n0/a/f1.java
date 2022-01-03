package n0.a;

import java.util.concurrent.CancellationException;
import m0.i;
import m0.l.c;
import m0.l.e;
import m0.n.a.l;
import m0.s.h;
/* compiled from: Job.kt */
/* loaded from: classes4.dex */
public interface f1 extends e.a {
    public static final /* synthetic */ int k = 0;

    /* compiled from: Job.kt */
    /* loaded from: classes4.dex */
    public static final class a implements e.b<f1> {
        public static final /* synthetic */ a c = new a();
    }

    o0 E(l<? super Throwable, i> lVar);

    r N(t tVar);

    boolean a();

    void b(CancellationException cancellationException);

    h<f1> getChildren();

    boolean isCancelled();

    Object l(c<? super i> cVar);

    o0 q(boolean z, boolean z2, l<? super Throwable, i> lVar);

    boolean start();

    CancellationException v();
}
