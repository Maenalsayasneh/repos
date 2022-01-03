package i0.e.b.f3;

import com.clubhouse.android.shared.preferences.Key;
import com.clubhouse.experimentation.ExperimentBehavior;
import i0.e.a.b.a;
import i0.e.b.f3.k.b;
import java.util.Map;
import java.util.Objects;
import kotlin.text.StringsKt__IndentKt;
import m0.j.g;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.p;
import n0.a.g2.a0;
import n0.a.g2.q;
import n0.a.g2.z;
/* compiled from: Experimentation.kt */
/* loaded from: classes3.dex */
public final class f {
    public final b a;
    public final a b;
    public z<? extends Map<String, ExperimentBehavior>> c;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #0 {Exception -> 0x0065, blocks: (B:3:0x0021, B:5:0x002a, B:12:0x0037), top: B:20:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public f(b bVar, a aVar) {
        String c;
        boolean z;
        i.e(bVar, "userPreferences");
        i.e(aVar, "experimentExposer");
        this.a = bVar;
        this.b = aVar;
        q a = a0.a(g.o());
        this.c = a;
        q qVar = a;
        Objects.requireNonNull(bVar);
        Map map = null;
        try {
            c = i0.e.b.f3.k.a.c(bVar, Key.EXPERIMENTS, null, 2, null);
        } catch (Exception e) {
            v0.a.a.d.e(e);
        }
        if (c != null && !StringsKt__IndentKt.o(c)) {
            z = false;
            if (z) {
                n0.c.l.a aVar2 = bVar.c;
                n0.c.m.b a2 = aVar2.a();
                p.a aVar3 = p.b;
                map = (Map) aVar2.b(m0.r.t.a.r.m.a1.a.u3(a2, m.f(Map.class, aVar3.a(m.e(String.class)), aVar3.a(m.e(ExperimentBehavior.class)))), c);
            }
            qVar.setValue(map == null ? g.o() : map);
        }
        z = true;
        if (z) {
        }
        qVar.setValue(map == null ? g.o() : map);
    }
}
