package h0.q;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class m0 {
    public final b a;
    public final n0 b;

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class a extends d {
        public static a b;
        public Application c;

        public a(Application application) {
            this.c = application;
        }

        @Override // h0.q.m0.d, h0.q.m0.b
        public <T extends k0> T create(Class<T> cls) {
            if (!b.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.c);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public interface b {
        <T extends k0> T create(Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static abstract class c extends e implements b {
        @Override // h0.q.m0.b
        public <T extends k0> T create(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends k0> T create(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class d implements b {
        public static d a;

        @Override // h0.q.m0.b
        public <T extends k0> T create(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class e {
        public void onRequery(k0 k0Var) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public m0(o0 o0Var) {
        this(r0, r3);
        b bVar;
        n0 viewModelStore = o0Var.getViewModelStore();
        if (o0Var instanceof l) {
            bVar = ((l) o0Var).getDefaultViewModelProviderFactory();
        } else {
            if (d.a == null) {
                d.a = new d();
            }
            bVar = d.a;
        }
    }

    public <T extends k0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends k0> T b(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.b.a.get(str);
        if (cls.isInstance(t2)) {
            b bVar = this.a;
            if (bVar instanceof e) {
                ((e) bVar).onRequery(t2);
            }
            return t2;
        }
        b bVar2 = this.a;
        if (bVar2 instanceof c) {
            t = (T) ((c) bVar2).create(str, cls);
        } else {
            t = (T) bVar2.create(cls);
        }
        k0 put = this.b.a.put(str, t);
        if (put != null) {
            put.onCleared();
        }
        return t;
    }

    public m0(n0 n0Var, b bVar) {
        this.a = bVar;
        this.b = n0Var;
    }
}
