package i0.h.a.b.m;

import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import h0.b0.v;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: classes2.dex */
public final class b0<TResult> extends g<TResult> {
    public final Object a = new Object();
    public final y<TResult> b = new y<>();
    public boolean c;
    public volatile boolean d;
    public TResult e;
    public Exception f;

    @Override // i0.h.a.b.m.g
    public final g<TResult> a(Executor executor, b bVar) {
        y<TResult> yVar = this.b;
        int i = c0.a;
        yVar.b(new p(executor, bVar));
        t();
        return this;
    }

    @Override // i0.h.a.b.m.g
    public final g<TResult> b(c<TResult> cVar) {
        c(i.a, cVar);
        return this;
    }

    @Override // i0.h.a.b.m.g
    public final g<TResult> c(Executor executor, c<TResult> cVar) {
        y<TResult> yVar = this.b;
        int i = c0.a;
        yVar.b(new q(executor, cVar));
        t();
        return this;
    }

    @Override // i0.h.a.b.m.g
    public final g<TResult> d(Executor executor, d dVar) {
        y<TResult> yVar = this.b;
        int i = c0.a;
        yVar.b(new t(executor, dVar));
        t();
        return this;
    }

    @Override // i0.h.a.b.m.g
    public final g<TResult> e(Executor executor, e<? super TResult> eVar) {
        y<TResult> yVar = this.b;
        int i = c0.a;
        yVar.b(new u(executor, eVar));
        t();
        return this;
    }

    @Override // i0.h.a.b.m.g
    public final <TContinuationResult> g<TContinuationResult> f(a<TResult, TContinuationResult> aVar) {
        return g(i.a, aVar);
    }

    @Override // i0.h.a.b.m.g
    public final <TContinuationResult> g<TContinuationResult> g(Executor executor, a<TResult, TContinuationResult> aVar) {
        b0 b0Var = new b0();
        y<TResult> yVar = this.b;
        int i = c0.a;
        yVar.b(new k(executor, aVar, b0Var));
        t();
        return b0Var;
    }

    @Override // i0.h.a.b.m.g
    public final <TContinuationResult> g<TContinuationResult> h(Executor executor, a<TResult, g<TContinuationResult>> aVar) {
        b0 b0Var = new b0();
        y<TResult> yVar = this.b;
        int i = c0.a;
        yVar.b(new l(executor, aVar, b0Var));
        t();
        return b0Var;
    }

    @Override // i0.h.a.b.m.g
    public final Exception i() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // i0.h.a.b.m.g
    public final TResult j() {
        TResult tresult;
        synchronized (this.a) {
            v.C(this.c, "Task is not yet complete");
            if (this.d) {
                throw new CancellationException("Task is already canceled.");
            } else if (this.f == null) {
                tresult = this.e;
            } else {
                throw new RuntimeExecutionException(this.f);
            }
        }
        return tresult;
    }

    @Override // i0.h.a.b.m.g
    public final <X extends Throwable> TResult k(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            v.C(this.c, "Task is not yet complete");
            if (this.d) {
                throw new CancellationException("Task is already canceled.");
            } else if (cls.isInstance(this.f)) {
                throw cls.cast(this.f);
            } else if (this.f == null) {
                tresult = this.e;
            } else {
                throw new RuntimeExecutionException(this.f);
            }
        }
        return tresult;
    }

    @Override // i0.h.a.b.m.g
    public final boolean l() {
        return this.d;
    }

    @Override // i0.h.a.b.m.g
    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // i0.h.a.b.m.g
    public final boolean n() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.d && this.f == null;
        }
        return z;
    }

    @Override // i0.h.a.b.m.g
    public final <TContinuationResult> g<TContinuationResult> o(Executor executor, f<TResult, TContinuationResult> fVar) {
        b0 b0Var = new b0();
        y<TResult> yVar = this.b;
        int i = c0.a;
        yVar.b(new x(executor, fVar, b0Var));
        t();
        return b0Var;
    }

    public final void p(Exception exc) {
        v.A(exc, "Exception must not be null");
        synchronized (this.a) {
            s();
            this.c = true;
            this.f = exc;
        }
        this.b.a(this);
    }

    public final void q(TResult tresult) {
        synchronized (this.a) {
            s();
            this.c = true;
            this.e = tresult;
        }
        this.b.a(this);
    }

    public final boolean r() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = true;
            this.b.a(this);
            return true;
        }
    }

    public final void s() {
        String str;
        if (this.c) {
            int i = DuplicateTaskCompletionException.c;
            if (m()) {
                Exception i2 = i();
                if (i2 != null) {
                    str = "failure";
                } else if (n()) {
                    String valueOf = String.valueOf(j());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 7);
                    sb.append("result ");
                    sb.append(valueOf);
                    str = sb.toString();
                } else {
                    str = l() ? "cancellation" : "unknown issue";
                }
                String valueOf2 = String.valueOf(str);
                throw new DuplicateTaskCompletionException(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), i2);
            }
            throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
    }

    public final void t() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }
}
