package t0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* compiled from: Platform.java */
/* loaded from: classes4.dex */
public class s {
    public static final s a;
    public final boolean b;
    public final Constructor<MethodHandles.Lookup> c;

    /* compiled from: Platform.java */
    /* loaded from: classes4.dex */
    public static final class a extends s {

        /* compiled from: Platform.java */
        /* renamed from: t0.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class ExecutorC0310a implements Executor {
            public final Handler c = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.c.post(runnable);
            }
        }

        public a() {
            super(true);
        }

        @Override // t0.s
        public Executor a() {
            return new ExecutorC0310a();
        }

        @Override // t0.s
        public Object b(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return s.super.b(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    static {
        s sVar;
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            sVar = new a();
        } else {
            sVar = new s(true);
        }
        a = sVar;
    }

    public s(boolean z) {
        this.b = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.c = constructor;
    }

    public Executor a() {
        return null;
    }

    @IgnoreJRERequirement
    public Object b(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        MethodHandles.Lookup lookup;
        Constructor<MethodHandles.Lookup> constructor = this.c;
        if (constructor != null) {
            lookup = constructor.newInstance(cls, -1);
        } else {
            lookup = MethodHandles.lookup();
        }
        return lookup.unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
