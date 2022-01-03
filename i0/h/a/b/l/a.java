package i0.h.a.b.l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import h0.b0.v;
import i0.h.a.b.c.m.d;
import i0.h.a.b.c.m.e;
import i0.h.a.b.c.n.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {
    public static ScheduledExecutorService a;
    public final Object b;
    public final PowerManager.WakeLock c;
    public WorkSource d;
    public final int e;
    public final String f;
    public final Context g;
    public boolean h;
    public final Map<String, Integer[]> i;
    public int j;
    public AtomicInteger k;

    public a(Context context, int i, String str) {
        i0.h.a.b.c.k.a aVar;
        WorkSource workSource = null;
        String packageName = context == null ? null : context.getPackageName();
        this.b = this;
        this.h = true;
        this.i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.k = new AtomicInteger(0);
        v.A(context, "WakeLock: context must not be null");
        v.y(str, "WakeLock: wakeLockName must not be empty");
        this.e = i;
        this.g = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            this.f = str.length() != 0 ? "*gcore*:".concat(str) : new String("*gcore*:");
        } else {
            this.f = str;
        }
        this.c = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (e.a(context)) {
            packageName = d.a(packageName) ? context.getPackageName() : packageName;
            if (!(context.getPackageManager() == null || packageName == null)) {
                try {
                    ApplicationInfo applicationInfo = b.a(context).a.getPackageManager().getApplicationInfo(packageName, 0);
                    if (applicationInfo == null) {
                        Log.e("WorkSourceUtil", packageName.length() != 0 ? "Could not get applicationInfo from package: ".concat(packageName) : new String("Could not get applicationInfo from package: "));
                    } else {
                        int i2 = applicationInfo.uid;
                        workSource = new WorkSource();
                        Method method = e.b;
                        if (method != null) {
                            try {
                                method.invoke(workSource, Integer.valueOf(i2), packageName);
                            } catch (Exception e) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                            }
                        } else {
                            Method method2 = e.a;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i2));
                                } catch (Exception e2) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                                }
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("WorkSourceUtil", packageName.length() != 0 ? "Could not find package: ".concat(packageName) : new String("Could not find package: "));
                }
            }
            this.d = workSource;
            if (workSource != null && e.a(this.g)) {
                WorkSource workSource2 = this.d;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.d = workSource;
                }
                try {
                    this.c.setWorkSource(this.d);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e3) {
                    Log.wtf("WakeLock", e3.toString());
                }
            }
        }
        if (a == null) {
            synchronized (v.class) {
                if (v.a == null) {
                    v.a = new i0.h.a.b.c.k.b();
                }
                aVar = v.a;
            }
            Objects.requireNonNull((i0.h.a.b.c.k.b) aVar);
            a = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r3 == false) goto L_0x0059;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        if (r7.j == 0) goto L_0x0061;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        h0.b0.v.m0(r7.c, null);
        c();
        r7.j++;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void a(long j) {
        this.k.incrementAndGet();
        if (this.h) {
            TextUtils.isEmpty(null);
        }
        synchronized (this.b) {
            boolean z = false;
            if ((!this.i.isEmpty() || this.j > 0) && !this.c.isHeld()) {
                this.i.clear();
                this.j = 0;
            }
            if (this.h) {
                Integer[] numArr = this.i.get(null);
                if (numArr == null) {
                    this.i.put(null, new Integer[]{1});
                    z = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                }
            }
            if (!this.h) {
            }
        }
        this.c.acquire();
        if (j > 0) {
            a.schedule(new b(this), j, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r4 == false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r6.j == 1) goto L_0x005b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        h0.b0.v.m0(r6.c, null);
        c();
        r6.j--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void b() {
        if (this.k.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f).concat(" release without a matched acquire!"));
        }
        if (this.h) {
            TextUtils.isEmpty(null);
        }
        synchronized (this.b) {
            if (this.h) {
                Integer[] numArr = this.i.get(null);
                boolean z = false;
                if (numArr != null) {
                    if (numArr[0].intValue() == 1) {
                        this.i.remove(null);
                        z = true;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    }
                }
            }
            if (!this.h) {
            }
        }
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final List<String> c() {
        int i;
        String str;
        Method method;
        WorkSource workSource = this.d;
        Method method2 = e.a;
        ArrayList arrayList = new ArrayList();
        if (!(workSource == null || (method = e.c) == null)) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Objects.requireNonNull(invoke, "null reference");
                i = ((Integer) invoke).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
            if (i != 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    Method method3 = e.d;
                    if (method3 != null) {
                        try {
                            str = (String) method3.invoke(workSource, Integer.valueOf(i2));
                        } catch (Exception e2) {
                            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                        }
                        if (d.a(str)) {
                            Objects.requireNonNull(str, "null reference");
                            arrayList.add(str);
                        }
                    }
                    str = null;
                    if (d.a(str)) {
                    }
                }
            }
            return arrayList;
        }
        i = 0;
        if (i != 0) {
        }
        return arrayList;
    }

    public final void d() {
        if (this.c.isHeld()) {
            try {
                this.c.release();
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f).concat(" was already released!"), e);
                } else {
                    throw e;
                }
            }
            this.c.isHeld();
        }
    }
}
