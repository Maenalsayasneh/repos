package m0.r.t.a.r.f.c;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
/* compiled from: Flags.java */
/* loaded from: classes4.dex */
public class b {
    public static final C0267b A;
    public static final C0267b B;
    public static final C0267b C;
    public static final C0267b D;
    public static final C0267b E;
    public static final C0267b F;
    public static final C0267b G;
    public static final C0267b H;
    public static final C0267b I;
    public static final C0267b J;
    public static final C0267b K;
    public static final C0267b L;
    public static final C0267b b;
    public static final d<ProtoBuf$Visibility> c;
    public static final d<ProtoBuf$Modality> d;
    public static final d<ProtoBuf$Class.Kind> e;
    public static final C0267b f;
    public static final C0267b g;
    public static final C0267b h;
    public static final C0267b i;
    public static final C0267b j;
    public static final C0267b k;
    public static final C0267b l;
    public static final C0267b m;
    public static final d<ProtoBuf$MemberKind> n;
    public static final C0267b o;
    public static final C0267b p;
    public static final C0267b q;
    public static final C0267b r;
    public static final C0267b s;
    public static final C0267b t;
    public static final C0267b u;
    public static final C0267b v;
    public static final C0267b w;
    public static final C0267b x;
    public static final C0267b y;
    public static final C0267b z;
    public static final C0267b a = d.c();
    public static final C0267b M = d.c();

    /* compiled from: Flags.java */
    /* renamed from: m0.r.t.a.r.f.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0267b extends d<Boolean> {
        public C0267b(int i) {
            super(i, 1, null);
        }

        /* renamed from: f */
        public Boolean d(int i) {
            Boolean valueOf = Boolean.valueOf((i & (1 << this.a)) != 0);
            if (valueOf != null) {
                return valueOf;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        /* renamed from: g */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* compiled from: Flags.java */
    /* loaded from: classes4.dex */
    public static class c<E extends Internal.a> extends d<E> {
        public final E[] c;

        /* JADX WARN: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public c(int i, E[] eArr) {
            super(i, r0, null);
            int i2 = 1;
            if (eArr != null) {
                int length = eArr.length - 1;
                if (length != 0) {
                    for (int i3 = 31; i3 >= 0; i3--) {
                        if (((1 << i3) & length) != 0) {
                            i2 = 1 + i3;
                        }
                    }
                    StringBuilder P0 = i0.d.a.a.a.P0("Empty enum: ");
                    P0.append(eArr.getClass());
                    throw new IllegalStateException(P0.toString());
                }
                this.c = eArr;
                return;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        @Override // m0.r.t.a.r.f.c.b.d
        public Object d(int i) {
            int i2 = this.a;
            int i3 = (i & (((1 << this.b) - 1) << i2)) >> i2;
            E[] eArr = this.c;
            for (E e : eArr) {
                if (e.getNumber() == i3) {
                    return e;
                }
            }
            return null;
        }

        @Override // m0.r.t.a.r.f.c.b.d
        public int e(Object obj) {
            return ((Internal.a) obj).getNumber() << this.a;
        }
    }

    /* compiled from: Flags.java */
    /* loaded from: classes4.dex */
    public static abstract class d<E> {
        public final int a;
        public final int b;

        public d(int i, int i2, a aVar) {
            this.a = i;
            this.b = i2;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$a;>(Lm0/r/t/a/r/f/c/b$d<*>;[TE;)Lm0/r/t/a/r/f/c/b$d<TE;>; */
        public static d a(d dVar, Internal.a[] aVarArr) {
            return new c(dVar.a + dVar.b, aVarArr);
        }

        public static C0267b b(d<?> dVar) {
            return new C0267b(dVar.a + dVar.b);
        }

        public static C0267b c() {
            return new C0267b(0);
        }

        public abstract E d(int i);

        public abstract int e(E e);
    }

    static {
        C0267b c2 = d.c();
        b = c2;
        d<ProtoBuf$Visibility> a2 = d.a(c2, ProtoBuf$Visibility.values());
        c = a2;
        d<ProtoBuf$Modality> a3 = d.a(a2, ProtoBuf$Modality.values());
        d = a3;
        d<ProtoBuf$Class.Kind> a4 = d.a(a3, ProtoBuf$Class.Kind.values());
        e = a4;
        C0267b b2 = d.b(a4);
        f = b2;
        C0267b b3 = d.b(b2);
        g = b3;
        C0267b b4 = d.b(b3);
        h = b4;
        C0267b b5 = d.b(b4);
        i = b5;
        C0267b b6 = d.b(b5);
        j = b6;
        k = d.b(b6);
        C0267b b7 = d.b(a2);
        l = b7;
        m = d.b(b7);
        d<ProtoBuf$MemberKind> a5 = d.a(a3, ProtoBuf$MemberKind.values());
        n = a5;
        C0267b b8 = d.b(a5);
        o = b8;
        C0267b b9 = d.b(b8);
        p = b9;
        C0267b b10 = d.b(b9);
        q = b10;
        C0267b b11 = d.b(b10);
        r = b11;
        C0267b b12 = d.b(b11);
        s = b12;
        C0267b b13 = d.b(b12);
        t = b13;
        C0267b b14 = d.b(b13);
        u = b14;
        v = d.b(b14);
        C0267b b15 = d.b(a5);
        w = b15;
        C0267b b16 = d.b(b15);
        x = b16;
        C0267b b17 = d.b(b16);
        y = b17;
        C0267b b18 = d.b(b17);
        z = b18;
        C0267b b19 = d.b(b18);
        A = b19;
        C0267b b20 = d.b(b19);
        B = b20;
        C0267b b21 = d.b(b20);
        C = b21;
        C0267b b22 = d.b(b21);
        D = b22;
        E = d.b(b22);
        C0267b b23 = d.b(c2);
        F = b23;
        C0267b b24 = d.b(b23);
        G = b24;
        H = d.b(b24);
        C0267b b25 = d.b(a3);
        I = b25;
        C0267b b26 = d.b(b25);
        J = b26;
        K = d.b(b26);
        C0267b c3 = d.c();
        L = c3;
        d.b(c3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 1) {
            if (i2 == 2) {
                objArr[0] = "kind";
            } else if (i2 != 5) {
                if (i2 != 6) {
                    if (i2 != 8) {
                        if (i2 != 9) {
                            if (i2 != 11) {
                                objArr[0] = "visibility";
                            }
                        }
                    }
                }
                objArr[0] = "memberKind";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
            switch (i2) {
                case 3:
                    objArr[2] = "getConstructorFlags";
                    break;
                case 4:
                case 5:
                case 6:
                    objArr[2] = "getFunctionFlags";
                    break;
                case 7:
                case 8:
                case 9:
                    objArr[2] = "getPropertyFlags";
                    break;
                case 10:
                case 11:
                    objArr[2] = "getAccessorFlags";
                    break;
                default:
                    objArr[2] = "getClassFlags";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        objArr[0] = "modality";
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i2) {
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }
}
