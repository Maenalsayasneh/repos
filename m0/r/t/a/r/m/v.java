package m0.r.t.a.r.m;

import i0.j.f.p.h;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import m0.n.b.i;
import m0.r.t.a.r.c.r0.a;
import m0.r.t.a.r.m.x0.e;
import m0.r.t.a.r.m.x0.k;
import m0.r.t.a.r.m.z0.f;
/* compiled from: KotlinType.kt */
/* loaded from: classes4.dex */
public abstract class v implements a, f {
    public int c;

    public v() {
    }

    public abstract List<m0> H0();

    public abstract j0 I0();

    public abstract boolean J0();

    public abstract v K0(e eVar);

    public abstract v0 L0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (J0() == vVar.J0()) {
            v0 L0 = L0();
            v0 L02 = vVar.L0();
            i.e(L0, "a");
            i.e(L02, "b");
            k kVar = k.a;
            i.e(kVar, "context");
            i.e(L0, "a");
            i.e(L02, "b");
            if (d.b(kVar, L0, L02)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = this.c;
        if (i2 != 0) {
            return i2;
        }
        if (h.h2(this)) {
            i = super.hashCode();
        } else {
            int hashCode = H0().hashCode();
            i = (J0() ? 1 : 0) + ((hashCode + (I0().hashCode() * 31)) * 31);
        }
        this.c = i;
        return i;
    }

    public abstract MemberScope o();

    public v(m0.n.b.f fVar) {
    }
}
