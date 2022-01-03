package i0.h.a.b.m;

import h0.b0.v;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: classes2.dex */
public class h<TResult> {
    public final b0<TResult> a = new b0<>();

    public boolean a(Exception exc) {
        b0<TResult> b0Var = this.a;
        Objects.requireNonNull(b0Var);
        v.A(exc, "Exception must not be null");
        synchronized (b0Var.a) {
            if (b0Var.c) {
                return false;
            }
            b0Var.c = true;
            b0Var.f = exc;
            b0Var.b.a(b0Var);
            return true;
        }
    }

    public boolean b(TResult tresult) {
        b0<TResult> b0Var = this.a;
        synchronized (b0Var.a) {
            if (b0Var.c) {
                return false;
            }
            b0Var.c = true;
            b0Var.e = tresult;
            b0Var.b.a(b0Var);
            return true;
        }
    }
}
