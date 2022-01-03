package i0.e.b.a3.a;

import kotlin.Result;
import m0.r.t.a.r.m.a1.a;
import n0.a.i0;
import n0.a.v;
/* compiled from: ReleaseCompletable.kt */
/* loaded from: classes3.dex */
public final class b {
    public final i0<Integer> a = a.g(null, 1);

    public static void a(b bVar, Result result, int i) {
        int i2 = i & 1;
        Result result2 = null;
        if (i2 != 0) {
            result2 = new Result(null);
        }
        Object obj = result2.c;
        v vVar = (v) bVar.a;
        Throwable a = Result.a(obj);
        if (a == null) {
            vVar.H(obj);
        } else {
            vVar.G(a);
        }
    }
}
