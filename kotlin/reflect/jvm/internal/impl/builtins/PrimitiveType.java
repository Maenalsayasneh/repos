package kotlin.reflect.jvm.internal.impl.builtins;

import i0.j.f.p.h;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import m0.c;
import m0.j.g;
import m0.n.b.f;
import m0.n.b.i;
import m0.r.t.a.r.g.b;
import m0.r.t.a.r.g.d;
/* compiled from: PrimitiveType.kt */
/* loaded from: classes4.dex */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final a Companion = new a(null);
    private final c arrayTypeFqName$delegate;
    private final d arrayTypeName;
    private final c typeFqName$delegate;
    private final d typeName;
    public static final Set<PrimitiveType> NUMBER_TYPES = g.h0(CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE);

    /* compiled from: PrimitiveType.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a(f fVar) {
        }
    }

    PrimitiveType(String str) {
        d g = d.g(str);
        i.d(g, "identifier(typeName)");
        this.typeName = g;
        d g2 = d.g(i.k(str, "Array"));
        i.d(g2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = g2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = h.G2(lazyThreadSafetyMode, new m0.n.a.a<b>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$typeFqName$2
            @Override // m0.n.a.a
            public b invoke() {
                b c = m0.r.t.a.r.b.g.l.c(PrimitiveType.this.getTypeName());
                i.d(c, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
                return c;
            }
        });
        this.arrayTypeFqName$delegate = h.G2(lazyThreadSafetyMode, new m0.n.a.a<b>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$arrayTypeFqName$2
            @Override // m0.n.a.a
            public b invoke() {
                b c = m0.r.t.a.r.b.g.l.c(PrimitiveType.this.getArrayTypeName());
                i.d(c, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
                return c;
            }
        });
    }

    public final b getArrayTypeFqName() {
        return (b) this.arrayTypeFqName$delegate.getValue();
    }

    public final d getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final b getTypeFqName() {
        return (b) this.typeFqName$delegate.getValue();
    }

    public final d getTypeName() {
        return this.typeName;
    }
}
