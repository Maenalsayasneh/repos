package h0.t;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
/* compiled from: NavType.java */
/* loaded from: classes.dex */
public abstract class r<T> {
    public static final r<Integer> a = new c(false);
    public static final r<Integer> b = new d(false);
    public static final r<int[]> c = new e(true);
    public static final r<Long> d = new f(false);
    public static final r<long[]> e = new g(true);
    public static final r<Float> f = new h(false);
    public static final r<float[]> g = new i(true);
    public static final r<Boolean> h = new j(false);
    public static final r<boolean[]> i = new k(true);
    public static final r<String> j = new a(true);
    public static final r<String[]> k = new b(true);
    public final boolean l;

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class a extends r<String> {
        public a(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public String a(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "string";
        }

        @Override // h0.t.r
        public String c(String str) {
            return str;
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class b extends r<String[]> {
        public b(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public String[] a(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "string[]";
        }

        @Override // h0.t.r
        public String[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class c extends r<Integer> {
        public c(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "integer";
        }

        @Override // h0.t.r
        public Integer c(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class d extends r<Integer> {
        public d(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "reference";
        }

        @Override // h0.t.r
        public Integer c(String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class e extends r<int[]> {
        public e(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public int[] a(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "integer[]";
        }

        @Override // h0.t.r
        public int[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class f extends r<Long> {
        public f(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public Long a(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "long";
        }

        @Override // h0.t.r
        public Long c(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, Long l) {
            bundle.putLong(str, l.longValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class g extends r<long[]> {
        public g(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public long[] a(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "long[]";
        }

        @Override // h0.t.r
        public long[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class h extends r<Float> {
        public h(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public Float a(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "float";
        }

        @Override // h0.t.r
        public Float c(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, Float f) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class i extends r<float[]> {
        public i(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public float[] a(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "float[]";
        }

        @Override // h0.t.r
        public float[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class j extends r<Boolean> {
        public j(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public Boolean a(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "boolean";
        }

        @Override // h0.t.r
        public Boolean c(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public class k extends r<boolean[]> {
        public k(boolean z) {
            super(z);
        }

        @Override // h0.t.r
        public boolean[] a(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return "boolean[]";
        }

        @Override // h0.t.r
        public boolean[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class l<D extends Enum> extends p<D> {
        public final Class<D> n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // h0.t.r.p, h0.t.r
        public String b() {
            return this.n.getName();
        }

        /* renamed from: f */
        public D e(String str) {
            D[] enumConstants = this.n.getEnumConstants();
            for (D d : enumConstants) {
                if (d.name().equals(str)) {
                    return d;
                }
            }
            throw new IllegalArgumentException(i0.d.a.a.a.Y(this.n, i0.d.a.a.a.T0("Enum value ", str, " not found for type "), "."));
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class m<D extends Parcelable> extends r<D[]> {
        public final Class<D[]> m;

        public m(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        @Override // h0.t.r
        public Object a(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return this.m.getName();
        }

        @Override // h0.t.r
        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            this.m.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((m) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class n<D> extends r<D> {
        public final Class<D> m;

        public n(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        @Override // h0.t.r
        public D a(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return this.m.getName();
        }

        @Override // h0.t.r
        public D c(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, D d) {
            this.m.cast(d);
            if (d == null || (d instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d);
            } else if (d instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((n) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class o<D extends Serializable> extends r<D[]> {
        public final Class<D[]> m;

        public o(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        @Override // h0.t.r
        public Object a(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return this.m.getName();
        }

        @Override // h0.t.r
        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // h0.t.r
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void d(Bundle bundle, String str, Object obj) {
            ?? r4 = (Serializable[]) obj;
            this.m.cast(r4);
            bundle.putSerializable(str, r4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((o) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    public r(boolean z) {
        this.l = z;
    }

    public abstract T a(Bundle bundle, String str);

    public abstract String b();

    public abstract T c(String str);

    public abstract void d(Bundle bundle, String str, T t);

    public String toString() {
        return b();
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static class p<D extends Serializable> extends r<D> {
        public final Class<D> m;

        public p(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        @Override // h0.t.r
        public Object a(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        @Override // h0.t.r
        public String b() {
            return this.m.getName();
        }

        @Override // h0.t.r
        public void d(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            this.m.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        /* renamed from: e */
        public D c(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            return this.m.equals(((p) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        public p(boolean z, Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }
}
