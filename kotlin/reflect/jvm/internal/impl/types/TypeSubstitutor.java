package kotlin.reflect.jvm.internal.impl.types;

import i0.j.f.p.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1;
import m0.n.b.i;
import m0.r.t.a.r.b.f;
import m0.r.t.a.r.b.g;
import m0.r.t.a.r.m.a0;
import m0.r.t.a.r.m.a1.a;
import m0.r.t.a.r.m.b1.b;
import m0.r.t.a.r.m.d0;
import m0.r.t.a.r.m.j0;
import m0.r.t.a.r.m.l0;
import m0.r.t.a.r.m.m;
import m0.r.t.a.r.m.m0;
import m0.r.t.a.r.m.o0;
import m0.r.t.a.r.m.p;
import m0.r.t.a.r.m.p0;
import m0.r.t.a.r.m.q;
import m0.r.t.a.r.m.q0;
import m0.r.t.a.r.m.s0;
import m0.r.t.a.r.m.t;
import m0.r.t.a.r.m.t0;
import m0.r.t.a.r.m.v;
import m0.r.t.a.r.m.v0;
import m0.r.t.a.r.m.z;
/* loaded from: classes4.dex */
public class TypeSubstitutor {
    public static final TypeSubstitutor a = e(p0.a);
    public final p0 b;

    /* loaded from: classes4.dex */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public TypeSubstitutor(p0 p0Var) {
        if (p0Var != null) {
            this.b = p0Var;
        } else {
            a(6);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    break;
            }
            if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
                switch (i) {
                    default:
                        switch (i) {
                            default:
                                switch (i) {
                                    default:
                                        switch (i) {
                                            case 38:
                                            case 39:
                                            case 40:
                                                break;
                                            default:
                                                i2 = 3;
                                                break;
                                        }
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                        i2 = 2;
                                        break;
                                }
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                                break;
                        }
                    case 10:
                    case 11:
                    case 12:
                        break;
                }
                Object[] objArr = new Object[i2];
                switch (i) {
                    case 1:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 32:
                    case 35:
                    case 38:
                    case 39:
                    case 40:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                        break;
                    case 2:
                        objArr[0] = "first";
                        break;
                    case 3:
                        objArr[0] = "second";
                        break;
                    case 4:
                        objArr[0] = "substitutionContext";
                        break;
                    case 5:
                        objArr[0] = "context";
                        break;
                    case 6:
                    default:
                        objArr[0] = "substitution";
                        break;
                    case 8:
                    case 13:
                        objArr[0] = "type";
                        break;
                    case 9:
                    case 14:
                        objArr[0] = "howThisTypeIsUsed";
                        break;
                    case 15:
                    case 16:
                    case 34:
                        objArr[0] = "typeProjection";
                        break;
                    case 17:
                    case 26:
                        objArr[0] = "originalProjection";
                        break;
                    case 24:
                        objArr[0] = "originalType";
                        break;
                    case 25:
                        objArr[0] = "substituted";
                        break;
                    case 31:
                        objArr[0] = "annotations";
                        break;
                    case 33:
                    case 36:
                        objArr[0] = "typeParameterVariance";
                        break;
                    case 37:
                        objArr[0] = "projectionKind";
                        break;
                }
                if (i != 1) {
                    objArr[1] = "replaceWithNonApproximatingSubstitution";
                } else if (i == 7) {
                    objArr[1] = "getSubstitution";
                } else if (i != 32) {
                    if (i != 35) {
                        switch (i) {
                            case 10:
                            case 11:
                            case 12:
                                objArr[1] = "safeSubstitute";
                                break;
                            default:
                                switch (i) {
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                        objArr[1] = "unsafeSubstitute";
                                        break;
                                    default:
                                        switch (i) {
                                            case 27:
                                            case 28:
                                            case 29:
                                            case 30:
                                                objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                                break;
                                            default:
                                                switch (i) {
                                                    case 38:
                                                    case 39:
                                                    case 40:
                                                        break;
                                                    default:
                                                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                                        break;
                                                }
                                        }
                                }
                        }
                    }
                    objArr[1] = "combine";
                } else {
                    objArr[1] = "filterOutUnsafeVariance";
                }
                switch (i) {
                    case 1:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 32:
                    case 35:
                    case 38:
                    case 39:
                    case 40:
                        break;
                    case 2:
                    case 3:
                        objArr[2] = "createChainedSubstitutor";
                        break;
                    case 4:
                    case 5:
                    default:
                        objArr[2] = "create";
                        break;
                    case 6:
                        objArr[2] = "<init>";
                        break;
                    case 8:
                    case 9:
                        objArr[2] = "safeSubstitute";
                        break;
                    case 13:
                    case 14:
                    case 15:
                        objArr[2] = "substitute";
                        break;
                    case 16:
                        objArr[2] = "substituteWithoutApproximation";
                        break;
                    case 17:
                        objArr[2] = "unsafeSubstitute";
                        break;
                    case 24:
                    case 25:
                    case 26:
                        objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                        break;
                    case 31:
                        objArr[2] = "filterOutUnsafeVariance";
                        break;
                    case 33:
                    case 34:
                    case 36:
                    case 37:
                        objArr[2] = "combine";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
                    switch (i) {
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            switch (i) {
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                    break;
                                default:
                                    switch (i) {
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                            break;
                                        default:
                                            switch (i) {
                                                case 38:
                                                case 39:
                                                case 40:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                    }
                            }
                    }
                }
                throw new IllegalStateException(format);
            }
            i2 = 2;
            Object[] objArr2 = new Object[i2];
            switch (i) {
            }
            if (i != 1) {
            }
            switch (i) {
            }
            String format2 = String.format(str, objArr2);
            if (i == 1) {
                switch (i) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i == 1) {
            switch (i) {
            }
            Object[] objArr22 = new Object[i2];
            switch (i) {
            }
            if (i != 1) {
            }
            switch (i) {
            }
            String format22 = String.format(str, objArr22);
            if (i == 1) {
            }
            throw new IllegalStateException(format22);
        }
        i2 = 2;
        Object[] objArr222 = new Object[i2];
        switch (i) {
        }
        if (i != 1) {
        }
        switch (i) {
        }
        String format222 = String.format(str, objArr222);
        if (i == 1) {
        }
        throw new IllegalStateException(format222);
    }

    public static Variance b(Variance variance, Variance variance2) {
        if (variance == null) {
            a(36);
            throw null;
        } else if (variance2 != null) {
            Variance variance3 = Variance.INVARIANT;
            if (variance == variance3) {
                if (variance2 != null) {
                    return variance2;
                }
                a(38);
                throw null;
            } else if (variance2 == variance3) {
                if (variance != null) {
                    return variance;
                }
                a(39);
                throw null;
            } else if (variance != variance2) {
                throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
            } else if (variance2 != null) {
                return variance2;
            } else {
                a(40);
                throw null;
            }
        } else {
            a(37);
            throw null;
        }
    }

    public static VarianceConflictType c(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor d(v vVar) {
        if (vVar != null) {
            return e(l0.b.b(vVar.I0(), vVar.H0()));
        }
        a(5);
        throw null;
    }

    public static TypeSubstitutor e(p0 p0Var) {
        return new TypeSubstitutor(p0Var);
    }

    public static TypeSubstitutor f(p0 p0Var, p0 p0Var2) {
        if (p0Var == null) {
            a(2);
            throw null;
        } else if (p0Var2 != null) {
            i.e(p0Var, "first");
            i.e(p0Var2, "second");
            if (p0Var.f()) {
                p0Var = p0Var2;
            } else if (!p0Var2.f()) {
                p0Var = new m(p0Var, p0Var2, null);
            }
            return e(p0Var);
        } else {
            a(3);
            throw null;
        }
    }

    public static String j(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!a.y2(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    public p0 g() {
        p0 p0Var = this.b;
        if (p0Var != null) {
            return p0Var;
        }
        a(7);
        throw null;
    }

    public boolean h() {
        return this.b.f();
    }

    public v i(v vVar, Variance variance) {
        if (vVar == null) {
            a(8);
            throw null;
        } else if (variance == null) {
            a(9);
            throw null;
        } else if (!h()) {
            try {
                v type = m(new o0(variance, vVar), null, 0).getType();
                if (type != null) {
                    return type;
                }
                a(11);
                throw null;
            } catch (SubstitutionException e) {
                return p.d(e.getMessage());
            }
        } else if (vVar != null) {
            return vVar;
        } else {
            a(10);
            throw null;
        }
    }

    public v k(v vVar, Variance variance) {
        o0 o0Var;
        if (vVar == null) {
            a(13);
            throw null;
        } else if (variance != null) {
            m0 l = l(new o0(variance, g().g(vVar, variance)));
            if (this.b.a() || this.b.b()) {
                boolean b = this.b.b();
                if (l == null) {
                    l = null;
                } else if (!l.c()) {
                    v type = l.getType();
                    i.d(type, "typeProjection.type");
                    if (s0.c(type, CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1.c)) {
                        Variance b2 = l.b();
                        i.d(b2, "typeProjection.projectionKind");
                        if (b2 == Variance.OUT_VARIANCE) {
                            o0Var = new o0(b2, a.S(type).b);
                        } else if (b) {
                            o0Var = new o0(b2, a.S(type).a);
                        } else {
                            TypeSubstitutor e = e(new b());
                            i.d(e, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
                            l = e.l(l);
                        }
                        l = o0Var;
                    }
                }
            }
            if (l == null) {
                return null;
            }
            return l.getType();
        } else {
            a(14);
            throw null;
        }
    }

    public m0 l(m0 m0Var) {
        if (m0Var == null) {
            a(16);
            throw null;
        } else if (h()) {
            return m0Var;
        } else {
            try {
                return m(m0Var, null, 0);
            } catch (SubstitutionException unused) {
                return null;
            }
        }
    }

    public final m0 m(m0 m0Var, m0.r.t.a.r.c.m0 m0Var2, int i) throws SubstitutionException {
        a0 a0Var;
        TypeSubstitutor typeSubstitutor;
        v vVar;
        v vVar2 = null;
        if (m0Var != null) {
            p0 p0Var = this.b;
            if (i > 100) {
                StringBuilder P0 = i0.d.a.a.a.P0("Recursion too deep. Most likely infinite loop while substituting ");
                P0.append(j(m0Var));
                P0.append("; substitution: ");
                P0.append(j(p0Var));
                throw new IllegalStateException(P0.toString());
            } else if (m0Var.c()) {
                return m0Var;
            } else {
                v type = m0Var.getType();
                if (type instanceof t0) {
                    t0 t0Var = (t0) type;
                    v0 B0 = t0Var.B0();
                    v E = t0Var.E();
                    m0 m = m(new o0(m0Var.b(), B0), m0Var2, i + 1);
                    return new o0(m.b(), h.G4(m.getType().L0(), k(E, m0Var.b())));
                } else if (h.f2(type) || (type.L0() instanceof z)) {
                    return m0Var;
                } else {
                    m0 e = this.b.e(type);
                    if (e == null) {
                        e = null;
                    } else if (type.getAnnotations().n(g.a.G)) {
                        j0 I0 = e.getType().I0();
                        if (I0 instanceof NewCapturedTypeConstructor) {
                            m0 m0Var3 = ((NewCapturedTypeConstructor) I0).a;
                            Variance b = m0Var3.b();
                            VarianceConflictType c = c(m0Var.b(), b);
                            VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
                            if (c == varianceConflictType) {
                                e = new o0(m0Var3.getType());
                            } else if (m0Var2 != null && c(m0Var2.l(), b) == varianceConflictType) {
                                e = new o0(m0Var3.getType());
                            }
                        }
                    }
                    Variance b2 = m0Var.b();
                    if (e == null && h.k2(type)) {
                        i.e(type, "<this>");
                        v0 L0 = type.L0();
                        m0.r.t.a.r.m.h hVar = L0 instanceof m0.r.t.a.r.m.h ? (m0.r.t.a.r.m.h) L0 : null;
                        if (!(hVar == null ? false : hVar.D())) {
                            q t = h.t(type);
                            int i2 = i + 1;
                            m0 m2 = m(new o0(b2, t.d), m0Var2, i2);
                            m0 m3 = m(new o0(b2, t.q), m0Var2, i2);
                            Variance b3 = m2.b();
                            if (m2.getType() == t.d && m3.getType() == t.q) {
                                return m0Var;
                            }
                            return new o0(b3, KotlinTypeFactory.c(h.x(m2.getType()), h.x(m3.getType())));
                        }
                    }
                    if (f.F(type) || h.h2(type)) {
                        return m0Var;
                    }
                    if (e != null) {
                        VarianceConflictType c2 = c(b2, e.b());
                        if (!h.c2(type)) {
                            int ordinal = c2.ordinal();
                            if (ordinal == 1) {
                                return new o0(Variance.OUT_VARIANCE, type.I0().m().p());
                            }
                            if (ordinal == 2) {
                                throw new SubstitutionException("Out-projection in in-position");
                            }
                        }
                        i.e(type, "<this>");
                        v0 L02 = type.L0();
                        m0.r.t.a.r.m.h hVar2 = L02 instanceof m0.r.t.a.r.m.h ? (m0.r.t.a.r.m.h) L02 : null;
                        if (hVar2 == null || !hVar2.D()) {
                            hVar2 = null;
                        }
                        if (e.c()) {
                            return e;
                        }
                        if (hVar2 != null) {
                            vVar = hVar2.I(e.getType());
                        } else {
                            vVar = s0.k(e.getType(), type.J0());
                        }
                        if (!type.getAnnotations().isEmpty()) {
                            m0.r.t.a.r.c.r0.f d = this.b.d(type.getAnnotations());
                            if (d != null) {
                                if (d.n(g.a.G)) {
                                    d = new m0.r.t.a.r.c.r0.h(d, new q0());
                                }
                                vVar = a.g3(vVar, new CompositeAnnotations(vVar.getAnnotations(), d));
                            } else {
                                a(31);
                                throw null;
                            }
                        }
                        if (c2 == VarianceConflictType.NO_CONFLICT) {
                            b2 = b(b2, e.b());
                        }
                        return new o0(b2, vVar);
                    }
                    v type2 = m0Var.getType();
                    Variance b4 = m0Var.b();
                    if (type2.I0().c() instanceof m0.r.t.a.r.c.m0) {
                        return m0Var;
                    }
                    i.e(type2, "<this>");
                    i.e(type2, "<this>");
                    v0 L03 = type2.L0();
                    m0.r.t.a.r.m.a aVar = L03 instanceof m0.r.t.a.r.m.a ? (m0.r.t.a.r.m.a) L03 : null;
                    if (aVar == null) {
                        a0Var = null;
                    } else {
                        a0Var = aVar.q;
                    }
                    if (a0Var != null) {
                        p0 p0Var2 = this.b;
                        if (!(p0Var2 instanceof t) || !p0Var2.b()) {
                            typeSubstitutor = this;
                        } else {
                            t tVar = (t) this.b;
                            typeSubstitutor = new TypeSubstitutor(new t(tVar.b, tVar.c, false));
                        }
                        vVar2 = typeSubstitutor.k(a0Var, Variance.INVARIANT);
                    }
                    List<m0.r.t.a.r.c.m0> parameters = type2.I0().getParameters();
                    List<m0> H0 = type2.H0();
                    ArrayList arrayList = new ArrayList(parameters.size());
                    boolean z = false;
                    for (int i3 = 0; i3 < parameters.size(); i3++) {
                        m0.r.t.a.r.c.m0 m0Var4 = parameters.get(i3);
                        m0 m0Var5 = H0.get(i3);
                        m0 m4 = m(m0Var5, m0Var4, i + 1);
                        int ordinal2 = c(m0Var4.l(), m4.b()).ordinal();
                        if (ordinal2 == 0) {
                            Variance l = m0Var4.l();
                            Variance variance = Variance.INVARIANT;
                            if (l != variance && !m4.c()) {
                                m4 = new o0(variance, m4.getType());
                            }
                        } else if (ordinal2 == 1 || ordinal2 == 2) {
                            m4 = s0.m(m0Var4);
                        }
                        if (m4 != m0Var5) {
                            z = true;
                        }
                        arrayList.add(m4);
                    }
                    if (z) {
                        H0 = arrayList;
                    }
                    m0.r.t.a.r.c.r0.f d2 = this.b.d(type2.getAnnotations());
                    i.e(type2, "<this>");
                    i.e(H0, "newArguments");
                    i.e(d2, "newAnnotations");
                    v u3 = h.u3(type2, H0, d2, null, 4);
                    if ((u3 instanceof a0) && (vVar2 instanceof a0)) {
                        u3 = d0.e((a0) u3, (a0) vVar2);
                    }
                    return new o0(b4, u3);
                }
            }
        } else {
            a(17);
            throw null;
        }
    }
}
