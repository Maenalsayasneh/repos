package i0.h.a.b.g.h;

import com.google.android.gms.internal.recaptcha.zzhk;
import com.google.android.gms.internal.recaptcha.zzhr;
import i0.h.a.b.g.h.z;
import i0.h.a.b.g.h.z.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public abstract class z<MessageType extends z<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends l<MessageType, BuilderType> {
    private static Map<Object, z<?, ?>> zzd = new ConcurrentHashMap();
    public w1 zzb = w1.a;
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
    /* loaded from: classes2.dex */
    public static class a<T extends z<T, ?>> extends o<T> {
        public a(T t) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
    /* loaded from: classes2.dex */
    public static abstract class b<MessageType extends z<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends m<MessageType, BuilderType> {
        public final MessageType c;
        public MessageType d;
        public boolean q = false;

        public b(MessageType messagetype) {
            this.c = messagetype;
            this.d = (MessageType) ((z) messagetype.f(4, null, null));
        }

        @Override // i0.h.a.b.g.h.z0
        public final /* synthetic */ y0 b() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.c.f(5, null, null);
            bVar.f((z) g());
            return bVar;
        }

        public final BuilderType f(MessageType messagetype) {
            if (this.q) {
                MessageType messagetype2 = (MessageType) ((z) this.d.f(4, null, null));
                i1.a.b(messagetype2).e(messagetype2, this.d);
                this.d = messagetype2;
                this.q = false;
            }
            MessageType messagetype3 = this.d;
            i1.a.b(messagetype3).e(messagetype3, messagetype);
            return this;
        }

        public y0 g() {
            if (this.q) {
                return this.d;
            }
            MessageType messagetype = this.d;
            i1.a.b(messagetype).a(messagetype);
            this.q = true;
            return this.d;
        }
    }

    /* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
    /* loaded from: classes2.dex */
    public static final class c implements x<c> {
        @Override // i0.h.a.b.g.h.x
        public final d1 A(d1 d1Var, d1 d1Var2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // i0.h.a.b.g.h.x
        public final zzhk d() {
            throw new NoSuchMethodError();
        }

        @Override // i0.h.a.b.g.h.x
        public final zzhr h() {
            throw new NoSuchMethodError();
        }

        @Override // i0.h.a.b.g.h.x
        public final x0 p(x0 x0Var, y0 y0Var) {
            throw new NoSuchMethodError();
        }

        @Override // i0.h.a.b.g.h.x
        public final boolean x() {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
    /* loaded from: classes2.dex */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends z<MessageType, BuilderType> implements z0 {
        public v<c> zzc = v.a;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
    /* loaded from: classes2.dex */
    public static final class e {
        public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7};
    }

    public static <T extends z<?, ?>> T e(Class<T> cls) {
        z<?, ?> zVar = zzd.get(cls);
        if (zVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zVar = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zVar == null) {
            zVar = (T) ((z) ((z) d2.c(cls)).f(6, null, null));
            if (zVar != null) {
                zzd.put(cls, zVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zVar;
    }

    public static Object g(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <T extends z<?, ?>> void h(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    @Override // i0.h.a.b.g.h.z0
    public final /* synthetic */ y0 b() {
        return (z) f(6, null, null);
    }

    @Override // i0.h.a.b.g.h.y0
    public final /* synthetic */ x0 c() {
        b bVar = (b) f(5, null, null);
        bVar.f(this);
        return bVar;
    }

    @Override // i0.h.a.b.g.h.z0
    public final boolean d() {
        byte byteValue = ((Byte) f(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c2 = i1.a.b(this).c(this);
        f(2, c2 ? this : null, null);
        return c2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return i1.a.b(this).b(this, (z) obj);
        }
        return false;
    }

    public abstract Object f(int i, Object obj, Object obj2);

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int d2 = i1.a.b(this).d(this);
        this.zza = d2;
        return d2;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        i0.h.a.b.c.m.b.s0(this, sb, 0);
        return sb.toString();
    }
}
