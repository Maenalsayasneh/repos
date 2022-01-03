package m0.r.t.a.r.c;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import m0.r.t.a.r.c.r0.f;
import m0.r.t.a.r.g.d;
import m0.r.t.a.r.m.p0;
import m0.r.t.a.r.m.v;
/* compiled from: FunctionDescriptor.java */
/* loaded from: classes4.dex */
public interface r extends CallableMemberDescriptor {

    /* compiled from: FunctionDescriptor.java */
    /* loaded from: classes4.dex */
    public interface a<D extends r> {
        a<D> a(List<o0> list);

        a<D> b(Modality modality);

        D build();

        a<D> c(f0 f0Var);

        a<D> d();

        a<D> e(v vVar);

        a<D> f(CallableMemberDescriptor callableMemberDescriptor);

        a<D> g();

        a<D> h(boolean z);

        a<D> i(p0 p0Var);

        a<D> j(List<m0> list);

        a<D> k(p pVar);

        a<D> l(i iVar);

        a<D> m();

        a<D> n(CallableMemberDescriptor.Kind kind);

        a<D> o(f fVar);

        a<D> p(d dVar);

        a<D> q();
    }

    boolean O();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, m0.r.t.a.r.c.a, m0.r.t.a.r.c.i
    /* renamed from: a */
    r mo56a();

    @Override // m0.r.t.a.r.c.j, m0.r.t.a.r.c.i
    /* renamed from: b */
    i mo53b();

    @Override // m0.r.t.a.r.c.j0, m0.r.t.a.r.c.h
    r c(TypeSubstitutor typeSubstitutor);

    r c0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, m0.r.t.a.r.c.a
    Collection<? extends r> e();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    a<? extends r> s();

    boolean u0();

    boolean y0();
}
