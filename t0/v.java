package t0;

import q0.e0;
import q0.f0;
/* compiled from: Response.java */
/* loaded from: classes4.dex */
public final class v<T> {
    public final e0 a;
    public final T b;
    public final f0 c;

    public v(e0 e0Var, T t, f0 f0Var) {
        this.a = e0Var;
        this.b = t;
        this.c = f0Var;
    }

    public static <T> v<T> b(T t, e0 e0Var) {
        if (e0Var.e()) {
            return new v<>(e0Var, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public boolean a() {
        return this.a.e();
    }

    public String toString() {
        return this.a.toString();
    }
}
