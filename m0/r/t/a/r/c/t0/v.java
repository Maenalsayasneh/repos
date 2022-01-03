package m0.r.t.a.r.c.t0;

import i0.j.f.p.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import m0.c;
import m0.j.g;
import m0.n.a.a;
import m0.n.b.i;
import m0.r.t.a.r.c.k;
import m0.r.t.a.r.c.r0.f;
import m0.r.t.a.r.c.t;
import m0.r.t.a.r.c.t0.v;
import m0.r.t.a.r.c.u;
import m0.r.t.a.r.c.w;
import m0.r.t.a.r.c.y;
import m0.r.t.a.r.g.b;
import m0.r.t.a.r.g.d;
import m0.r.t.a.r.l.f;
import m0.r.t.a.r.l.l;
import m0.r.t.a.r.m.x0.j;
/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: classes4.dex */
public final class v extends k implements u {
    public t Y1;
    public w Z1;
    public boolean a2;
    public final f<b, y> b2;
    public final c c2;
    public final l q;
    public final m0.r.t.a.r.b.f x;
    public final Map<t<?>, Object> y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(d dVar, l lVar, m0.r.t.a.r.b.f fVar, Map map, d dVar2, int i) {
        super(f.a.b, dVar);
        Map o = (i & 16) != 0 ? g.o() : null;
        i.e(dVar, "moduleName");
        i.e(lVar, "storageManager");
        i.e(fVar, "builtIns");
        i.e(o, "capabilities");
        Objects.requireNonNull(m0.r.t.a.r.c.r0.f.i);
        this.q = lVar;
        this.x = fVar;
        if (dVar.d) {
            Map<t<?>, Object> B0 = g.B0(o);
            this.y = B0;
            B0.put(m0.r.t.a.r.m.x0.f.a, new j(null));
            this.a2 = true;
            this.b2 = lVar.g(new m0.n.a.l<b, y>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packages$1
                @Override // m0.n.a.l
                public y invoke(b bVar) {
                    b bVar2 = bVar;
                    i.e(bVar2, "fqName");
                    v vVar = v.this;
                    return new LazyPackageViewDescriptorImpl(vVar, bVar2, vVar.q);
                }
            });
            this.c2 = h.H2(new a<j>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2
                @Override // m0.n.a.a
                public m0.r.t.a.r.c.t0.j invoke() {
                    v vVar = v.this;
                    m0.r.t.a.r.c.t0.t tVar = vVar.Y1;
                    if (tVar != null) {
                        List<v> a = tVar.a();
                        a.contains(v.this);
                        for (v vVar2 : a) {
                            w wVar = vVar2.Z1;
                        }
                        ArrayList arrayList = new ArrayList(h.K(a, 10));
                        for (v vVar3 : a) {
                            w wVar2 = vVar3.Z1;
                            i.c(wVar2);
                            arrayList.add(wVar2);
                        }
                        return new m0.r.t.a.r.c.t0.j(arrayList);
                    }
                    StringBuilder P0 = i0.d.a.a.a.P0("Dependencies of module ");
                    P0.append(vVar.B0());
                    P0.append(" were not set before querying module content");
                    throw new AssertionError(P0.toString());
                }
            });
            return;
        }
        throw new IllegalArgumentException(i.k("Module name must be special: ", dVar));
    }

    public final String B0() {
        String str = getName().c;
        i.d(str, "name.toString()");
        return str;
    }

    @Override // m0.r.t.a.r.c.u
    public <T> T D0(t<T> tVar) {
        i.e(tVar, "capability");
        return (T) this.y.get(tVar);
    }

    public final void H0(v... vVarArr) {
        i.e(vVarArr, "descriptors");
        List l4 = h.l4(vVarArr);
        i.e(l4, "descriptors");
        EmptySet emptySet = EmptySet.c;
        i.e(l4, "descriptors");
        i.e(emptySet, "friends");
        u uVar = new u(l4, emptySet, EmptyList.c, emptySet);
        i.e(uVar, "dependencies");
        this.Y1 = uVar;
    }

    public void I() {
        if (!this.a2) {
            throw new InvalidModuleException(i.k("Accessing invalid module descriptor ", this));
        }
    }

    @Override // m0.r.t.a.r.c.i
    public <R, D> R J(k<R, D> kVar, D d) {
        i.e(this, "this");
        i.e(kVar, "visitor");
        return kVar.j(this, d);
    }

    @Override // m0.r.t.a.r.c.u
    public y M(b bVar) {
        i.e(bVar, "fqName");
        I();
        return (y) ((LockBasedStorageManager.m) this.b2).invoke(bVar);
    }

    @Override // m0.r.t.a.r.c.i
    /* renamed from: b */
    public m0.r.t.a.r.c.i mo53b() {
        i.e(this, "this");
        return null;
    }

    @Override // m0.r.t.a.r.c.u
    public boolean d0(u uVar) {
        i.e(uVar, "targetModule");
        if (i.a(this, uVar)) {
            return true;
        }
        t tVar = this.Y1;
        i.c(tVar);
        if (!g.f(tVar.b(), uVar) && !r0().contains(uVar) && !uVar.r0().contains(this)) {
            return false;
        }
        return true;
    }

    @Override // m0.r.t.a.r.c.u
    public m0.r.t.a.r.b.f m() {
        return this.x;
    }

    @Override // m0.r.t.a.r.c.u
    public Collection<b> n(b bVar, m0.n.a.l<? super d, Boolean> lVar) {
        i.e(bVar, "fqName");
        i.e(lVar, "nameFilter");
        I();
        I();
        return ((j) this.c2.getValue()).n(bVar, lVar);
    }

    @Override // m0.r.t.a.r.c.u
    public List<u> r0() {
        t tVar = this.Y1;
        if (tVar != null) {
            return tVar.c();
        }
        StringBuilder P0 = i0.d.a.a.a.P0("Dependencies of module ");
        P0.append(B0());
        P0.append(" were not set");
        throw new AssertionError(P0.toString());
    }
}
