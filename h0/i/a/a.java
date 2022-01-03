package h0.i.a;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
public final class a {
    public static final Class<?> a;
    public static final Field b;
    public static final Field c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Handler g = new Handler(Looper.getMainLooper());

    /* compiled from: ActivityRecreator.java */
    /* renamed from: h0.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0068a implements Runnable {
        public final /* synthetic */ c c;
        public final /* synthetic */ Object d;

        public RunnableC0068a(c cVar, Object obj) {
            this.c = cVar;
            this.d = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.c = this.d;
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Application c;
        public final /* synthetic */ c d;

        public b(Application application, c cVar) {
            this.c = application;
            this.d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.unregisterActivityLifecycleCallbacks(this.d);
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public Object c;
        public Activity d;
        public final int q;
        public boolean x = false;
        public boolean y = false;
        public boolean Y1 = false;

        public c(Activity activity) {
            this.d = activity;
            this.q = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.d == activity) {
                this.d = null;
                this.y = true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
            r5.Y1 = true;
            r5.c = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
            return;
         */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void onActivityPaused(Activity activity) {
            if (this.y && !this.Y1 && !this.x) {
                Object obj = this.c;
                int i = this.q;
                boolean z = false;
                try {
                    Object obj2 = a.c.get(activity);
                    if (obj2 == obj && activity.hashCode() == i) {
                        a.g.postAtFrontOfQueue(new b(a.b.get(activity), obj2));
                        z = true;
                    }
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while fetching field values", th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.d == activity) {
                this.x = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Class<?> cls;
        Field field;
        Field field2;
        Method declaredMethod;
        Class<?> cls2;
        Method declaredMethod2;
        Class<?> cls3;
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
        } catch (Throwable unused2) {
            field = null;
        }
        b = field;
        try {
            field2 = Activity.class.getDeclaredField("mToken");
            field2.setAccessible(true);
        } catch (Throwable unused3) {
            field2 = null;
        }
        c = field2;
        Class<?> cls4 = a;
        if (cls4 != null) {
            try {
                declaredMethod = cls4.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
            }
            d = declaredMethod;
            cls2 = a;
            if (cls2 != null) {
                try {
                    declaredMethod2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                    declaredMethod2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                e = declaredMethod2;
                cls3 = a;
                if (a() && cls3 != null) {
                    try {
                        Class<?> cls5 = Boolean.TYPE;
                        Method declaredMethod3 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
                        declaredMethod3.setAccessible(true);
                        method = declaredMethod3;
                    } catch (Throwable unused6) {
                    }
                }
                f = method;
            }
            declaredMethod2 = null;
            e = declaredMethod2;
            cls3 = a;
            if (a()) {
                Class<?> cls52 = Boolean.TYPE;
                Method declaredMethod32 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls52, Configuration.class, Configuration.class, cls52, cls52);
                declaredMethod32.setAccessible(true);
                method = declaredMethod32;
            }
            f = method;
        }
        declaredMethod = null;
        d = declaredMethod;
        cls2 = a;
        if (cls2 != null) {
        }
        declaredMethod2 = null;
        e = declaredMethod2;
        cls3 = a;
        if (a()) {
        }
        f = method;
    }

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static boolean b(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f == null) {
            return false;
        } else {
            if (e == null && d == null) {
                return false;
            }
            try {
                Object obj2 = c.get(activity);
                if (obj2 == null || (obj = b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                c cVar = new c(activity);
                application.registerActivityLifecycleCallbacks(cVar);
                Handler handler = g;
                handler.post(new RunnableC0068a(cVar, obj2));
                if (a()) {
                    Method method = f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, cVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
