package s0.a.e.b;

import java.math.BigInteger;
import java.util.Hashtable;
import s0.a.b.j;
import s0.a.e.b.e;
import s0.a.e.b.g;
/* loaded from: classes4.dex */
public abstract class h {
    public static final g[] a = new g[0];
    public e b;
    public g c;
    public g d;
    public g[] e;
    public Hashtable f;

    /* loaded from: classes4.dex */
    public class a implements n {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        public a(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // s0.a.e.b.n
        public o a(o oVar) {
            s sVar = oVar instanceof s ? (s) oVar : null;
            if (sVar == null) {
                sVar = new s();
            }
            if (sVar.a) {
                return sVar;
            }
            if (!sVar.b) {
                if (this.a || h.this.s()) {
                    sVar.b = true;
                } else {
                    sVar.a = true;
                    return sVar;
                }
            }
            if (this.b && !sVar.c) {
                if (!h.this.t()) {
                    sVar.a = true;
                    return sVar;
                }
                sVar.c = true;
            }
            return sVar;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b extends h {
        public b(e eVar, g gVar, g gVar2) {
            super(eVar, gVar, gVar2);
        }

        public b(e eVar, g gVar, g gVar2, g[] gVarArr) {
            super(eVar, gVar, gVar2, gVarArr);
        }

        public b B(int i) {
            h f;
            if (m()) {
                return this;
            }
            e eVar = this.b;
            int i2 = eVar.f;
            g gVar = this.c;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 5) {
                        if (i2 != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                f = eVar.g(gVar.q(i), this.d.q(i), new g[]{this.e[0].q(i)});
                return (b) f;
            }
            f = eVar.f(gVar.q(i), this.d.q(i));
            return (b) f;
        }

        @Override // s0.a.e.b.h
        public boolean s() {
            g gVar;
            g gVar2;
            e eVar = this.b;
            g gVar3 = this.c;
            g gVar4 = eVar.b;
            g gVar5 = eVar.c;
            int i = eVar.f;
            if (i == 6) {
                g gVar6 = this.e[0];
                boolean h = gVar6.h();
                if (gVar3.i()) {
                    g o = this.d.o();
                    if (!h) {
                        gVar5 = gVar5.j(gVar6.o());
                    }
                    return o.equals(gVar5);
                }
                g gVar7 = this.d;
                g o2 = gVar3.o();
                if (h) {
                    gVar2 = i0.d.a.a.a.s1(gVar7, gVar7, gVar4);
                    gVar = o2.o().a(gVar5);
                } else {
                    g o3 = gVar6.o();
                    g o4 = o3.o();
                    gVar2 = gVar7.a(gVar6).l(gVar7, gVar4, o3);
                    gVar = o2.p(gVar5, o4);
                }
                return gVar2.j(o2).equals(gVar);
            }
            g gVar8 = this.d;
            g j = gVar8.a(gVar3).j(gVar8);
            if (i != 0) {
                if (i == 1) {
                    g gVar9 = this.e[0];
                    if (!gVar9.h()) {
                        g j2 = gVar9.j(gVar9.o());
                        j = j.j(gVar9);
                        gVar4 = gVar4.j(gVar9);
                        gVar5 = gVar5.j(j2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return j.equals(gVar3.a(gVar4).j(gVar3.o()).a(gVar5));
        }

        @Override // s0.a.e.b.h
        public boolean t() {
            BigInteger bigInteger = this.b.e;
            if (c.c.equals(bigInteger)) {
                return ((g.a) q().d()).w() != 0;
            }
            if (!c.e.equals(bigInteger)) {
                return h.super.t();
            }
            h q = q();
            g d = q.d();
            e eVar = this.b;
            g w = ((e.a) eVar).w(d.a(eVar.b));
            if (w == null) {
                return false;
            }
            return ((g.a) d.j(w).a(q.e())).w() == 0;
        }

        @Override // s0.a.e.b.h
        public h u(g gVar) {
            if (m()) {
                return this;
            }
            int g = g();
            if (g == 5) {
                g gVar2 = this.c;
                return this.b.g(gVar2, this.d.a(gVar2).d(gVar).a(gVar2.j(gVar)), this.e);
            } else if (g != 6) {
                return h.super.u(gVar);
            } else {
                g gVar3 = this.c;
                g gVar4 = this.d;
                g gVar5 = this.e[0];
                g j = gVar3.j(gVar.o());
                return this.b.g(j, gVar4.a(gVar3).a(j), new g[]{gVar5.j(gVar)});
            }
        }

        @Override // s0.a.e.b.h
        public h v(g gVar) {
            if (m()) {
                return this;
            }
            int g = g();
            if (g != 5 && g != 6) {
                return h.super.v(gVar);
            }
            g gVar2 = this.c;
            return this.b.g(gVar2, this.d.a(gVar2).j(gVar).a(gVar2), this.e);
        }

        @Override // s0.a.e.b.h
        public h w(h hVar) {
            return hVar.m() ? this : a(hVar.p());
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class c extends h {
        public c(e eVar, g gVar, g gVar2) {
            super(eVar, gVar, gVar2);
        }

        public c(e eVar, g gVar, g gVar2, g[] gVarArr) {
            super(eVar, gVar, gVar2, gVarArr);
        }

        @Override // s0.a.e.b.h
        public boolean f() {
            return e().s();
        }

        @Override // s0.a.e.b.h
        public boolean s() {
            g gVar = this.c;
            g gVar2 = this.d;
            e eVar = this.b;
            g gVar3 = eVar.b;
            g gVar4 = eVar.c;
            g o = gVar2.o();
            int g = g();
            if (g != 0) {
                if (g == 1) {
                    g gVar5 = this.e[0];
                    if (!gVar5.h()) {
                        g o2 = gVar5.o();
                        g j = gVar5.j(o2);
                        o = o.j(gVar5);
                        gVar3 = gVar3.j(o2);
                        gVar4 = gVar4.j(j);
                    }
                } else if (g == 2 || g == 3 || g == 4) {
                    g gVar6 = this.e[0];
                    if (!gVar6.h()) {
                        g o3 = gVar6.o();
                        g o4 = o3.o();
                        g j2 = o3.j(o4);
                        gVar3 = gVar3.j(o4);
                        gVar4 = gVar4.j(j2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return o.equals(gVar.o().a(gVar3).j(gVar).a(gVar4));
        }

        @Override // s0.a.e.b.h
        public h w(h hVar) {
            return hVar.m() ? this : a(hVar.p());
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends b {
        public d(e eVar, g gVar, g gVar2) {
            super(eVar, gVar, gVar2);
        }

        public d(e eVar, g gVar, g gVar2, g[] gVarArr) {
            super(eVar, gVar, gVar2, gVarArr);
        }

        @Override // s0.a.e.b.h
        public h A(h hVar) {
            if (m()) {
                return hVar;
            }
            if (hVar.m()) {
                return z();
            }
            e eVar = this.b;
            g gVar = this.c;
            if (gVar.i()) {
                return hVar;
            }
            if (eVar.f != 6) {
                return z().a(hVar);
            }
            g gVar2 = hVar.c;
            g gVar3 = hVar.e[0];
            if (gVar2.i() || !gVar3.h()) {
                return z().a(hVar);
            }
            g gVar4 = this.d;
            g gVar5 = this.e[0];
            g gVar6 = hVar.d;
            g o = gVar.o();
            g o2 = gVar4.o();
            g o3 = gVar5.o();
            g a = eVar.b.j(o3).a(o2).a(gVar4.j(gVar5));
            g b = gVar6.b();
            g l = eVar.b.a(b).j(o3).a(o2).l(a, o, o3);
            g j = gVar2.j(o3);
            g o4 = j.a(a).o();
            if (o4.i()) {
                return l.i() ? hVar.z() : eVar.m();
            }
            if (l.i()) {
                return new d(eVar, l, eVar.c.n());
            }
            g j2 = l.o().j(j);
            g j3 = l.j(o4).j(o3);
            return new d(eVar, j2, l.a(o4).o().l(a, b, j3), new g[]{j3});
        }

        @Override // s0.a.e.b.h
        public h a(h hVar) {
            g gVar;
            g gVar2;
            g gVar3;
            g gVar4;
            g gVar5;
            g gVar6;
            if (m()) {
                return hVar;
            }
            if (hVar.m()) {
                return this;
            }
            e eVar = this.b;
            int i = eVar.f;
            g gVar7 = this.c;
            g gVar8 = hVar.c;
            if (i == 0) {
                g gVar9 = this.d;
                g gVar10 = hVar.d;
                g a = gVar7.a(gVar8);
                g a2 = gVar9.a(gVar10);
                if (a.i()) {
                    return a2.i() ? z() : eVar.m();
                }
                g d = a2.d(a);
                g a3 = i0.d.a.a.a.s1(d, d, a).a(eVar.b);
                return new d(eVar, a3, d.j(gVar7.a(a3)).a(a3).a(gVar9));
            } else if (i == 1) {
                g gVar11 = this.d;
                g gVar12 = this.e[0];
                g gVar13 = hVar.d;
                g gVar14 = hVar.e[0];
                boolean h = gVar14.h();
                g a4 = gVar12.j(gVar13).a(h ? gVar11 : gVar11.j(gVar14));
                g a5 = gVar12.j(gVar8).a(h ? gVar7 : gVar7.j(gVar14));
                if (a5.i()) {
                    return a4.i() ? z() : eVar.m();
                }
                g o = a5.o();
                g j = o.j(a5);
                if (!h) {
                    gVar12 = gVar12.j(gVar14);
                }
                g a6 = a4.a(a5);
                g a7 = a6.l(a4, o, eVar.b).j(gVar12).a(j);
                g j2 = a5.j(a7);
                if (!h) {
                    o = o.j(gVar14);
                }
                return new d(eVar, j2, a4.l(gVar7, a5, gVar11).l(o, a6, a7), new g[]{j.j(gVar12)});
            } else if (i != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (gVar7.i()) {
                return gVar8.i() ? eVar.m() : hVar.a(this);
            } else {
                g gVar15 = this.d;
                g gVar16 = this.e[0];
                g gVar17 = hVar.d;
                g gVar18 = hVar.e[0];
                boolean h2 = gVar16.h();
                if (!h2) {
                    gVar2 = gVar8.j(gVar16);
                    gVar = gVar17.j(gVar16);
                } else {
                    gVar2 = gVar8;
                    gVar = gVar17;
                }
                boolean h3 = gVar18.h();
                if (!h3) {
                    gVar7 = gVar7.j(gVar18);
                    gVar3 = gVar15.j(gVar18);
                } else {
                    gVar3 = gVar15;
                }
                g a8 = gVar3.a(gVar);
                g a9 = gVar7.a(gVar2);
                if (a9.i()) {
                    return a8.i() ? z() : eVar.m();
                }
                if (gVar8.i()) {
                    h q = q();
                    g gVar19 = q.c;
                    g j3 = q.j();
                    g d2 = j3.a(gVar17).d(gVar19);
                    gVar5 = i0.d.a.a.a.s1(d2, d2, gVar19).a(eVar.b);
                    if (gVar5.i()) {
                        return new d(eVar, gVar5, eVar.c.n());
                    }
                    gVar4 = d2.j(gVar19.a(gVar5)).a(gVar5).a(j3).d(gVar5).a(gVar5);
                    gVar6 = eVar.k(c.b);
                } else {
                    g o2 = a9.o();
                    g j4 = a8.j(gVar7);
                    g j5 = a8.j(gVar2);
                    g j6 = j4.j(j5);
                    if (j6.i()) {
                        return new d(eVar, j6, eVar.c.n());
                    }
                    g j7 = a8.j(o2);
                    if (!h3) {
                        j7 = j7.j(gVar18);
                    }
                    gVar4 = j5.a(o2).p(j7, gVar15.a(gVar16));
                    gVar6 = !h2 ? j7.j(gVar16) : j7;
                    gVar5 = j6;
                }
                return new d(eVar, gVar5, gVar4, new g[]{gVar6});
            }
        }

        @Override // s0.a.e.b.h
        public h b() {
            return new d(null, d(), e());
        }

        @Override // s0.a.e.b.h
        public boolean f() {
            g gVar = this.c;
            if (gVar.i()) {
                return false;
            }
            g gVar2 = this.d;
            int g = g();
            if (g != 5 && g != 6) {
                return gVar2.d(gVar).s();
            }
            if (gVar2.s() != gVar.s()) {
                return true;
            }
            return false;
        }

        @Override // s0.a.e.b.h
        public g j() {
            int g = g();
            if (g != 5 && g != 6) {
                return this.d;
            }
            g gVar = this.c;
            g gVar2 = this.d;
            if (m() || gVar.i()) {
                return gVar2;
            }
            g j = gVar2.a(gVar).j(gVar);
            if (6 != g) {
                return j;
            }
            g gVar3 = this.e[0];
            return !gVar3.h() ? j.d(gVar3) : j;
        }

        @Override // s0.a.e.b.h
        public h p() {
            if (m()) {
                return this;
            }
            g gVar = this.c;
            if (gVar.i()) {
                return this;
            }
            int g = g();
            if (g == 0) {
                return new d(this.b, gVar, this.d.a(gVar));
            }
            if (g == 1) {
                return new d(this.b, gVar, this.d.a(gVar), new g[]{this.e[0]});
            } else if (g == 5) {
                return new d(this.b, gVar, this.d.b());
            } else {
                if (g == 6) {
                    g gVar2 = this.d;
                    g gVar3 = this.e[0];
                    return new d(this.b, gVar, gVar2.a(gVar3), new g[]{gVar3});
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        @Override // s0.a.e.b.h
        public h z() {
            g gVar;
            g gVar2;
            if (m()) {
                return this;
            }
            e eVar = this.b;
            g gVar3 = this.c;
            if (gVar3.i()) {
                return eVar.m();
            }
            int i = eVar.f;
            if (i == 0) {
                g a = this.d.d(gVar3).a(gVar3);
                g a2 = a.o().a(a).a(eVar.b);
                return new d(eVar, a2, gVar3.p(a2, a.b()));
            } else if (i == 1) {
                g gVar4 = this.d;
                g gVar5 = this.e[0];
                boolean h = gVar5.h();
                g j = h ? gVar3 : gVar3.j(gVar5);
                if (!h) {
                    gVar4 = gVar4.j(gVar5);
                }
                g o = gVar3.o();
                g a3 = o.a(gVar4);
                g o2 = j.o();
                g a4 = a3.a(j);
                g l = a4.l(a3, o2, eVar.b);
                return new d(eVar, j.j(l), o.o().l(j, l, a4), new g[]{j.j(o2)});
            } else if (i == 6) {
                g gVar6 = this.d;
                g gVar7 = this.e[0];
                boolean h2 = gVar7.h();
                g j2 = h2 ? gVar6 : gVar6.j(gVar7);
                g o3 = h2 ? gVar7 : gVar7.o();
                g gVar8 = eVar.b;
                if (h2) {
                    gVar = gVar8;
                } else {
                    gVar = gVar8.j(o3);
                }
                g s1 = i0.d.a.a.a.s1(gVar6, j2, gVar);
                if (s1.i()) {
                    return new d(eVar, s1, eVar.c.n());
                }
                g o4 = s1.o();
                g j3 = h2 ? s1 : s1.j(o3);
                g gVar9 = eVar.c;
                if (gVar9.c() < (eVar.l() >> 1)) {
                    g o5 = gVar6.a(gVar3).o();
                    gVar2 = o5.a(s1).a(o3).j(o5).a(gVar9.h() ? gVar.a(o3).o() : gVar.p(gVar9, o3.o())).a(o4);
                    if (!gVar8.i()) {
                        if (!gVar8.h()) {
                            gVar2 = gVar2.a(gVar8.b().j(j3));
                        }
                        return new d(eVar, o4, gVar2, new g[]{j3});
                    }
                } else {
                    if (!h2) {
                        gVar3 = gVar3.j(gVar7);
                    }
                    gVar2 = gVar3.p(s1, j2).a(o4);
                }
                gVar2 = gVar2.a(j3);
                return new d(eVar, o4, gVar2, new g[]{j3});
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends c {
        public e(e eVar, g gVar, g gVar2) {
            super(eVar, gVar, gVar2);
        }

        public e(e eVar, g gVar, g gVar2, g[] gVarArr) {
            super(eVar, gVar, gVar2, gVarArr);
        }

        @Override // s0.a.e.b.h
        public h A(h hVar) {
            if (this == hVar) {
                return x();
            }
            if (m()) {
                return hVar;
            }
            if (hVar.m()) {
                return z();
            }
            g gVar = this.d;
            if (gVar.i()) {
                return hVar;
            }
            e eVar = this.b;
            int i = eVar.f;
            if (i != 0) {
                return i != 4 ? z().a(hVar) : F(false).a(hVar);
            }
            g gVar2 = this.c;
            g gVar3 = hVar.c;
            g gVar4 = hVar.d;
            g r = gVar3.r(gVar2);
            g r2 = gVar4.r(gVar);
            if (r.i()) {
                return r2.i() ? x() : this;
            }
            g o = r.o();
            g r3 = o.j(gVar2.a(gVar2).a(gVar3)).r(r2.o());
            if (r3.i()) {
                return eVar.m();
            }
            g g = r3.j(r).g();
            g j = r3.j(g).j(r2);
            g r4 = gVar.a(gVar).j(o).j(r).j(g).r(j);
            g a = r4.r(j).j(j.a(r4)).a(gVar3);
            return new e(eVar, a, gVar2.r(a).j(r4).r(gVar));
        }

        public g B(g gVar, g gVar2) {
            g gVar3 = this.b.b;
            if (gVar3.i() || gVar.h()) {
                return gVar3;
            }
            if (gVar2 == null) {
                gVar2 = gVar.o();
            }
            g o = gVar2.o();
            g m = gVar3.m();
            return m.c() < gVar3.c() ? o.j(m).m() : o.j(gVar3);
        }

        public g C(g gVar) {
            g a = gVar.a(gVar);
            return a.a(a);
        }

        public g D() {
            g[] gVarArr = this.e;
            g gVar = gVarArr[1];
            if (gVar != null) {
                return gVar;
            }
            g B = B(gVarArr[0], null);
            gVarArr[1] = B;
            return B;
        }

        public g E(g gVar) {
            return gVar.a(gVar).a(gVar);
        }

        public e F(boolean z) {
            g gVar;
            g gVar2 = this.c;
            g gVar3 = this.d;
            g gVar4 = this.e[0];
            g D = D();
            g a = E(gVar2.o()).a(D);
            g a2 = gVar3.a(gVar3);
            g j = a2.j(gVar3);
            g j2 = gVar2.j(j);
            g a3 = j2.a(j2);
            g r = a.o().r(a3.a(a3));
            g o = j.o();
            g a4 = o.a(o);
            g r2 = a.j(a3.r(r)).r(a4);
            if (z) {
                g j3 = a4.j(D);
                gVar = j3.a(j3);
            } else {
                gVar = null;
            }
            if (!gVar4.h()) {
                a2 = a2.j(gVar4);
            }
            return new e(this.b, r, r2, new g[]{a2, gVar});
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
        @Override // s0.a.e.b.h
        /* Code decompiled incorrectly, please refer to instructions dump */
        public h a(h hVar) {
            g gVar;
            g gVar2;
            g gVar3;
            g gVar4;
            if (m()) {
                return hVar;
            }
            if (hVar.m()) {
                return this;
            }
            if (this == hVar) {
                return z();
            }
            e eVar = this.b;
            int i = eVar.f;
            g gVar5 = this.c;
            g gVar6 = this.d;
            g gVar7 = hVar.c;
            g gVar8 = hVar.d;
            if (i == 0) {
                g r = gVar7.r(gVar5);
                g r2 = gVar8.r(gVar6);
                if (r.i()) {
                    return r2.i() ? z() : eVar.m();
                }
                g d = r2.d(r);
                g r3 = d.o().r(gVar5).r(gVar7);
                return new e(eVar, r3, d.j(gVar5.r(r3)).r(gVar6));
            } else if (i == 1) {
                g gVar9 = this.e[0];
                g gVar10 = hVar.e[0];
                boolean h = gVar9.h();
                boolean h2 = gVar10.h();
                if (!h) {
                    gVar8 = gVar8.j(gVar9);
                }
                if (!h2) {
                    gVar6 = gVar6.j(gVar10);
                }
                g r4 = gVar8.r(gVar6);
                if (!h) {
                    gVar7 = gVar7.j(gVar9);
                }
                if (!h2) {
                    gVar5 = gVar5.j(gVar10);
                }
                g r5 = gVar7.r(gVar5);
                if (r5.i()) {
                    return r4.i() ? z() : eVar.m();
                }
                if (h) {
                    gVar9 = gVar10;
                } else if (!h2) {
                    gVar9 = gVar9.j(gVar10);
                }
                g o = r5.o();
                g j = o.j(r5);
                g j2 = o.j(gVar5);
                g r6 = r4.o().j(gVar9).r(j).r(j2.a(j2));
                return new e(eVar, r5.j(r6), j2.r(r6).k(r4, gVar6, j), new g[]{j.j(gVar9)});
            } else if (i == 2 || i == 4) {
                g gVar11 = this.e[0];
                g gVar12 = hVar.e[0];
                boolean h3 = gVar11.h();
                if (h3 || !gVar11.equals(gVar12)) {
                    if (!h3) {
                        g o2 = gVar11.o();
                        gVar7 = o2.j(gVar7);
                        gVar8 = o2.j(gVar11).j(gVar8);
                    }
                    boolean h4 = gVar12.h();
                    if (!h4) {
                        g o3 = gVar12.o();
                        gVar5 = o3.j(gVar5);
                        gVar6 = o3.j(gVar12).j(gVar6);
                    }
                    g r7 = gVar5.r(gVar7);
                    g r8 = gVar6.r(gVar8);
                    if (r7.i()) {
                        return r8.i() ? z() : eVar.m();
                    }
                    gVar = r7.o();
                    g j3 = gVar.j(r7);
                    g j4 = gVar.j(gVar5);
                    g r9 = r8.o().a(j3).r(j4.a(j4));
                    gVar3 = j4.r(r9).k(r8, j3, gVar6);
                    g j5 = !h3 ? r7.j(gVar11) : r7;
                    gVar4 = !h4 ? j5.j(gVar12) : j5;
                    if (gVar4 == r7) {
                        gVar2 = r9;
                        return new e(eVar, gVar2, gVar3, i != 4 ? new g[]{gVar4, B(gVar4, gVar)} : new g[]{gVar4});
                    }
                    gVar2 = r9;
                } else {
                    g r10 = gVar5.r(gVar7);
                    g r11 = gVar6.r(gVar8);
                    if (r10.i()) {
                        return r11.i() ? z() : eVar.m();
                    }
                    g o4 = r10.o();
                    g j6 = gVar5.j(o4);
                    g j7 = gVar7.j(o4);
                    g j8 = j6.r(j7).j(gVar6);
                    gVar2 = r11.o().r(j6).r(j7);
                    gVar3 = j6.r(gVar2).j(r11).r(j8);
                    gVar4 = r10.j(gVar11);
                }
                gVar = null;
                return new e(eVar, gVar2, gVar3, i != 4 ? new g[]{gVar4, B(gVar4, gVar)} : new g[]{gVar4});
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        @Override // s0.a.e.b.h
        public h b() {
            return new e(null, d(), e());
        }

        @Override // s0.a.e.b.h
        public g k(int i) {
            return (i == 1 && 4 == g()) ? D() : h.super.k(i);
        }

        @Override // s0.a.e.b.h
        public h p() {
            if (m()) {
                return this;
            }
            e eVar = this.b;
            return eVar.f != 0 ? new e(eVar, this.c, this.d.m(), this.e) : new e(eVar, this.c, this.d.m());
        }

        @Override // s0.a.e.b.h
        public h x() {
            if (m()) {
                return this;
            }
            g gVar = this.d;
            if (gVar.i()) {
                return this;
            }
            e eVar = this.b;
            int i = eVar.f;
            if (i != 0) {
                return i != 4 ? z().a(this) : F(false).a(this);
            }
            g gVar2 = this.c;
            g a = gVar.a(gVar);
            g o = a.o();
            g a2 = E(gVar2.o()).a(this.b.b);
            g r = E(gVar2).j(o).r(a2.o());
            if (r.i()) {
                return this.b.m();
            }
            g g = r.j(a).g();
            g j = r.j(g).j(a2);
            g r2 = o.o().j(g).r(j);
            g a3 = r2.r(j).j(j.a(r2)).a(gVar2);
            return new e(eVar, a3, gVar2.r(a3).j(r2).r(gVar));
        }

        @Override // s0.a.e.b.h
        public h y(int i) {
            g gVar;
            if (i < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            } else if (i == 0 || m()) {
                return this;
            } else {
                if (i == 1) {
                    return z();
                }
                e eVar = this.b;
                g gVar2 = this.d;
                if (gVar2.i()) {
                    return eVar.m();
                }
                int i2 = eVar.f;
                g gVar3 = eVar.b;
                g gVar4 = this.c;
                g[] gVarArr = this.e;
                g k = gVarArr.length < 1 ? eVar.k(c.b) : gVarArr[0];
                if (!k.h() && i2 != 0) {
                    if (i2 == 1) {
                        gVar = k.o();
                        gVar4 = gVar4.j(k);
                        gVar2 = gVar2.j(gVar);
                    } else if (i2 == 2) {
                        gVar = null;
                    } else if (i2 == 4) {
                        gVar3 = D();
                    } else {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    gVar3 = B(k, gVar);
                }
                int i3 = 0;
                while (i3 < i) {
                    if (gVar2.i()) {
                        return eVar.m();
                    }
                    g E = E(gVar4.o());
                    g a = gVar2.a(gVar2);
                    g j = a.j(gVar2);
                    g j2 = gVar4.j(j);
                    g a2 = j2.a(j2);
                    g o = j.o();
                    g a3 = o.a(o);
                    if (!gVar3.i()) {
                        E = E.a(gVar3);
                        g j3 = a3.j(gVar3);
                        gVar3 = j3.a(j3);
                    }
                    g r = E.o().r(a2.a(a2));
                    gVar2 = E.j(a2.r(r)).r(a3);
                    k = k.h() ? a : a.j(k);
                    i3++;
                    gVar4 = r;
                }
                if (i2 == 0) {
                    g g = k.g();
                    g o2 = g.o();
                    return new e(eVar, gVar4.j(o2), gVar2.j(o2.j(g)));
                } else if (i2 == 1) {
                    return new e(eVar, gVar4.j(k), gVar2, new g[]{k.j(k.o())});
                } else {
                    if (i2 == 2) {
                        return new e(eVar, gVar4, gVar2, new g[]{k});
                    }
                    if (i2 == 4) {
                        return new e(eVar, gVar4, gVar2, new g[]{k, gVar3});
                    }
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
        }

        @Override // s0.a.e.b.h
        public h z() {
            g gVar;
            g gVar2;
            g gVar3;
            if (m()) {
                return this;
            }
            e eVar = this.b;
            g gVar4 = this.d;
            if (gVar4.i()) {
                return eVar.m();
            }
            int i = eVar.f;
            g gVar5 = this.c;
            if (i == 0) {
                g d = E(gVar5.o()).a(this.b.b).d(gVar4.a(gVar4));
                g r = d.o().r(gVar5.a(gVar5));
                return new e(eVar, r, d.j(gVar5.r(r)).r(gVar4));
            } else if (i == 1) {
                g gVar6 = this.e[0];
                boolean h = gVar6.h();
                g gVar7 = eVar.b;
                if (!gVar7.i() && !h) {
                    gVar7 = gVar7.j(gVar6.o());
                }
                g a = gVar7.a(E(gVar5.o()));
                g j = h ? gVar4 : gVar4.j(gVar6);
                g o = h ? gVar4.o() : j.j(gVar4);
                g C = C(gVar5.j(o));
                g r2 = a.o().r(C.a(C));
                g a2 = j.a(j);
                g j2 = r2.j(a2);
                g a3 = o.a(o);
                g j3 = C.r(r2).j(a);
                g o2 = a3.o();
                g r3 = j3.r(o2.a(o2));
                if (h) {
                    gVar = a3.a(a3);
                } else {
                    gVar = a2.o();
                }
                return new e(eVar, j2, r3, new g[]{gVar.a(gVar).j(j)});
            } else if (i == 2) {
                g gVar8 = this.e[0];
                boolean h2 = gVar8.h();
                g o3 = gVar4.o();
                g o4 = o3.o();
                g gVar9 = eVar.b;
                g m = gVar9.m();
                if (m.t().equals(BigInteger.valueOf(3))) {
                    g o5 = h2 ? gVar8 : gVar8.o();
                    gVar2 = E(gVar5.a(o5).j(gVar5.r(o5)));
                    gVar3 = o3.j(gVar5);
                } else {
                    g E = E(gVar5.o());
                    if (!h2) {
                        if (!gVar9.i()) {
                            g o6 = gVar8.o().o();
                            if (m.c() < gVar9.c()) {
                                gVar2 = E.r(o6.j(m));
                            } else {
                                gVar9 = o6.j(gVar9);
                            }
                        } else {
                            gVar2 = E;
                        }
                        gVar3 = gVar5.j(o3);
                    }
                    gVar2 = E.a(gVar9);
                    gVar3 = gVar5.j(o3);
                }
                g C2 = C(gVar3);
                g r4 = gVar2.o().r(C2.a(C2));
                g r5 = C2.r(r4).j(gVar2).r(C(o4.a(o4)));
                g a4 = gVar4.a(gVar4);
                if (!h2) {
                    a4 = a4.j(gVar8);
                }
                return new e(eVar, r4, r5, new g[]{a4});
            } else if (i == 4) {
                return F(true);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public h(e eVar, g gVar, g gVar2) {
        this(eVar, gVar, gVar2, r1);
        g[] gVarArr;
        int i = eVar == null ? 0 : eVar.f;
        if (i == 0 || i == 5) {
            gVarArr = a;
        } else {
            g k = eVar.k(c.b);
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    gVarArr = new g[]{k, k, k};
                } else if (i == 4) {
                    gVarArr = new g[]{k, eVar.b};
                } else if (i != 6) {
                    throw new IllegalArgumentException("unknown coordinate system");
                }
            }
            gVarArr = new g[]{k};
        }
    }

    public h(e eVar, g gVar, g gVar2, g[] gVarArr) {
        this.f = null;
        this.b = eVar;
        this.c = gVar;
        this.d = gVar2;
        this.e = gVarArr;
    }

    public h A(h hVar) {
        return z().a(hVar);
    }

    public abstract h a(h hVar);

    public abstract h b();

    public boolean c(h hVar) {
        h hVar2;
        if (hVar == null) {
            return false;
        }
        e eVar = this.b;
        e eVar2 = hVar.b;
        boolean z = eVar == null;
        boolean z2 = eVar2 == null;
        boolean m = m();
        boolean m2 = hVar.m();
        if (!m && !m2) {
            if (!z || !z2) {
                if (z) {
                    hVar = hVar.q();
                } else {
                    if (z2) {
                        hVar2 = q();
                    } else if (!eVar.j(eVar2)) {
                        return false;
                    } else {
                        h[] hVarArr = {this, eVar.n(hVar)};
                        eVar.p(hVarArr);
                        hVar2 = hVarArr[0];
                        hVar = hVarArr[1];
                    }
                    return hVar2.c.equals(hVar.c) && hVar2.j().equals(hVar.j());
                }
            }
            hVar2 = this;
            if (hVar2.c.equals(hVar.c)) {
                return false;
            }
        } else if (!m || !m2) {
            return false;
        } else {
            return z || z2 || eVar.j(eVar2);
        }
    }

    public g d() {
        if (n()) {
            return this.c;
        }
        throw new IllegalStateException("point not in normal form");
    }

    public g e() {
        if (n()) {
            return j();
        }
        throw new IllegalStateException("point not in normal form");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return c((h) obj);
    }

    public abstract boolean f();

    public int g() {
        e eVar = this.b;
        if (eVar == null) {
            return 0;
        }
        return eVar.f;
    }

    public final h h() {
        return q().b();
    }

    public int hashCode() {
        int i;
        e eVar = this.b;
        if (eVar == null) {
            i = 0;
        } else {
            i = ~eVar.hashCode();
        }
        if (m()) {
            return i;
        }
        h q = q();
        return (i ^ (q.c.hashCode() * 17)) ^ (q.j().hashCode() * 257);
    }

    public byte[] i(boolean z) {
        if (m()) {
            return new byte[1];
        }
        h q = q();
        byte[] e2 = q.c.e();
        if (z) {
            byte[] bArr = new byte[e2.length + 1];
            bArr[0] = (byte) (q.f() ? 3 : 2);
            System.arraycopy(e2, 0, bArr, 1, e2.length);
            return bArr;
        }
        byte[] e3 = q.j().e();
        byte[] bArr2 = new byte[e2.length + e3.length + 1];
        bArr2[0] = 4;
        System.arraycopy(e2, 0, bArr2, 1, e2.length);
        System.arraycopy(e3, 0, bArr2, e2.length + 1, e3.length);
        return bArr2;
    }

    public g j() {
        return this.d;
    }

    public g k(int i) {
        if (i >= 0) {
            g[] gVarArr = this.e;
            if (i < gVarArr.length) {
                return gVarArr[i];
            }
        }
        return null;
    }

    public boolean l(boolean z, boolean z2) {
        if (m()) {
            return true;
        }
        return !((s) this.b.r(this, "bc_validity", new a(z, z2))).a;
    }

    public boolean m() {
        if (!(this.c == null || this.d == null)) {
            g[] gVarArr = this.e;
            if (gVarArr.length <= 0 || !gVarArr[0].i()) {
                return false;
            }
        }
        return true;
    }

    public boolean n() {
        int g = g();
        return g == 0 || g == 5 || m() || this.e[0].h();
    }

    public h o(BigInteger bigInteger) {
        e eVar = this.b;
        if (eVar.h == null) {
            eVar.h = eVar.d();
        }
        return eVar.h.a(this, bigInteger);
    }

    public abstract h p();

    public h q() {
        int g;
        if (m() || (g = g()) == 0 || g == 5) {
            return this;
        }
        g k = k(0);
        if (k.h()) {
            return this;
        }
        if (this.b != null) {
            g s = this.b.s(j.a());
            return r(k.j(s).g().j(s));
        }
        throw new IllegalStateException("Detached points must be in affine coordinates");
    }

    public h r(g gVar) {
        int g = g();
        if (g != 1) {
            if (g == 2 || g == 3 || g == 4) {
                g o = gVar.o();
                return this.b.f(this.c.j(o), this.d.j(o.j(gVar)));
            } else if (g != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return this.b.f(this.c.j(gVar), this.d.j(gVar));
    }

    public abstract boolean s();

    public boolean t() {
        BigInteger bigInteger;
        if (!c.b.equals(this.b.e) && (bigInteger = this.b.d) != null && !m0.r.t.a.r.m.a1.a.f3(this, bigInteger).m()) {
            return false;
        }
        return true;
    }

    public String toString() {
        if (m()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(this.c);
        stringBuffer.append(',');
        stringBuffer.append(this.d);
        for (int i = 0; i < this.e.length; i++) {
            stringBuffer.append(',');
            stringBuffer.append(this.e[i]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public h u(g gVar) {
        if (m()) {
            return this;
        }
        return this.b.g(this.c.j(gVar), this.d, this.e);
    }

    public h v(g gVar) {
        if (m()) {
            return this;
        }
        return this.b.g(this.c, this.d.j(gVar), this.e);
    }

    public abstract h w(h hVar);

    public h x() {
        return A(this);
    }

    public h y(int i) {
        if (i >= 0) {
            h hVar = this;
            while (true) {
                i--;
                if (i < 0) {
                    return hVar;
                }
                hVar = hVar.z();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    public abstract h z();
}
