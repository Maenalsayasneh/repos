package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.util.DynamiteApi;
import h0.b0.v;
import i0.h.a.b.e.d;
import i0.h.a.b.e.e;
import i0.h.a.b.e.f;
import i0.h.a.b.e.g;
import i0.h.a.b.e.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class DynamiteModule {
    public static Boolean a = null;
    public static f b = null;
    public static h c = null;
    public static String d = null;
    public static int e = -1;
    public static final ThreadLocal<b> f = new ThreadLocal<>();
    public static final ThreadLocal<Long> g = new i0.h.a.b.e.a();
    public static final a.b h = new i0.h.a.b.e.b();
    @RecentlyNonNull
    public static final a i = new d();
    public final Context j;

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    @DynamiteApi
    /* loaded from: classes2.dex */
    public static class DynamiteLoaderClassLoader {
        @RecentlyNullable
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    /* loaded from: classes2.dex */
    public static class LoadingException extends Exception {
        public LoadingException(String str, i0.h.a.b.e.a aVar) {
            super(str);
        }

        public LoadingException(String str, Throwable th, i0.h.a.b.e.a aVar) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    /* loaded from: classes2.dex */
    public interface a {

        /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0009a {
            public int a = 0;
            public int b = 0;
            public int c = 0;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
        /* loaded from: classes2.dex */
        public interface b {
            int a(Context context, String str, boolean z) throws LoadingException;

            int b(Context context, String str);
        }

        C0009a a(Context context, String str, b bVar) throws LoadingException;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    /* loaded from: classes2.dex */
    public static class b {
        public Cursor a;

        public b() {
        }

        public b(i0.h.a.b.e.a aVar) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    /* loaded from: classes2.dex */
    public static class c implements a.b {
        public final int a;

        public c(int i) {
            this.a = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int a(Context context, String str, boolean z) {
            return 0;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int b(Context context, String str) {
            return this.a;
        }
    }

    public DynamiteModule(Context context) {
        Objects.requireNonNull(context, "null reference");
        this.j = context;
    }

    public static int a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (v.c0(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @RecentlyNonNull
    public static DynamiteModule b(@RecentlyNonNull Context context, @RecentlyNonNull a aVar, @RecentlyNonNull String str) throws LoadingException {
        ThreadLocal<b> threadLocal = f;
        b bVar = threadLocal.get();
        b bVar2 = new b(null);
        threadLocal.set(bVar2);
        ThreadLocal<Long> threadLocal2 = g;
        long longValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            a.C0009a a2 = aVar.a(context, str, h);
            int i2 = a2.a;
            int i3 = a2.b;
            StringBuilder sb = new StringBuilder(str.length() + 68 + str.length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = a2.c;
            if (i4 == 0 || ((i4 == -1 && a2.a == 0) || (i4 == 1 && a2.b == 0))) {
                int i5 = a2.a;
                int i6 = a2.b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), null);
            } else if (i4 == -1) {
                DynamiteModule c2 = c(context, str);
                if (longValue == 0) {
                    threadLocal2.remove();
                } else {
                    threadLocal2.set(Long.valueOf(longValue));
                }
                Cursor cursor = bVar2.a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(bVar);
                return c2;
            } else if (i4 == 1) {
                try {
                    DynamiteModule d2 = d(context, str, a2.b);
                    if (longValue == 0) {
                        threadLocal2.remove();
                    } else {
                        threadLocal2.set(Long.valueOf(longValue));
                    }
                    Cursor cursor2 = bVar2.a;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    threadLocal.set(bVar);
                    return d2;
                } catch (LoadingException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    int i7 = a2.a;
                    if (i7 == 0 || aVar.a(context, str, new c(i7)).c != -1) {
                        throw new LoadingException("Remote load failed. No local fallback found.", e2, null);
                    }
                    DynamiteModule c3 = c(context, str);
                    if (longValue == 0) {
                        g.remove();
                    } else {
                        g.set(Long.valueOf(longValue));
                    }
                    Cursor cursor3 = bVar2.a;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    f.set(bVar);
                    return c3;
                }
            } else {
                int i8 = a2.c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i8);
                throw new LoadingException(sb3.toString(), null);
            }
        } catch (Throwable th) {
            if (longValue == 0) {
                g.remove();
            } else {
                g.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = bVar2.a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f.set(bVar);
            throw th;
        }
    }

    public static DynamiteModule c(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    public static DynamiteModule d(Context context, String str, int i2) throws LoadingException {
        Boolean bool;
        i0.h.a.b.d.b bVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = a;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", null);
            } else if (bool.booleanValue()) {
                return i(context, str, i2);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                f e2 = e(context);
                if (e2 != null) {
                    int d2 = e2.d();
                    if (d2 >= 3) {
                        b bVar2 = f.get();
                        if (bVar2 != null) {
                            bVar = e2.j(new i0.h.a.b.d.d(context), str, i2, new i0.h.a.b.d.d(bVar2.a));
                        } else {
                            throw new LoadingException("No cached result cursor holder", null);
                        }
                    } else if (d2 == 2) {
                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                        bVar = e2.P(new i0.h.a.b.d.d(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        bVar = e2.A(new i0.h.a.b.d.d(context), str, i2);
                    }
                    if (i0.h.a.b.d.d.j0(bVar) != null) {
                        return new DynamiteModule((Context) i0.h.a.b.d.d.j0(bVar));
                    }
                    throw new LoadingException("Failed to load remote module.", null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", null);
            }
        } catch (RemoteException e3) {
            throw new LoadingException("Failed to load remote module.", e3, null);
        } catch (LoadingException e4) {
            throw e4;
        } catch (Throwable th) {
            try {
                Objects.requireNonNull(context, "null reference");
            } catch (Exception e5) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e5);
            }
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    public static f e(Context context) {
        f fVar;
        synchronized (DynamiteModule.class) {
            f fVar2 = b;
            if (fVar2 != null) {
                return fVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    fVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof f) {
                        fVar = (f) queryLocalInterface;
                    } else {
                        fVar = new e(iBinder);
                    }
                }
                if (fVar != null) {
                    b = fVar;
                    return fVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    public static void f(ClassLoader classLoader) throws LoadingException {
        h hVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                hVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof h) {
                    hVar = (h) queryLocalInterface;
                } else {
                    hVar = new g(iBinder);
                }
            }
            c = hVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    public static boolean g(Cursor cursor) {
        b bVar = f.get();
        if (bVar == null || bVar.a != null) {
            return false;
        }
        bVar.a = cursor;
        return true;
    }

    public static int h(Context context, String str, boolean z) {
        Throwable th;
        RemoteException e2;
        f e3 = e(context);
        if (e3 == null) {
            return 0;
        }
        try {
            Cursor cursor = null;
            try {
                int d2 = e3.d();
                try {
                    if (d2 >= 3) {
                        Cursor cursor2 = (Cursor) i0.h.a.b.d.d.j0(e3.X(new i0.h.a.b.d.d(context), str, z, g.get().longValue()));
                        if (cursor2 != null) {
                            try {
                                if (cursor2.moveToFirst()) {
                                    int i2 = cursor2.getInt(0);
                                    if (i2 <= 0 || !g(cursor2)) {
                                        cursor = cursor2;
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return i2;
                                }
                            } catch (RemoteException e4) {
                                e2 = e4;
                                cursor = cursor2;
                                String valueOf = String.valueOf(e2.getMessage());
                                Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return 0;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return 0;
                    } else if (d2 == 2) {
                        Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                        return e3.H(new i0.h.a.b.d.d(context), str, z);
                    } else {
                        Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                        return e3.M(new i0.h.a.b.d.d(context), str, z);
                    }
                } catch (RemoteException e5) {
                    e2 = e5;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (RemoteException e6) {
                e2 = e6;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static DynamiteModule i(Context context, String str, int i2) throws LoadingException, RemoteException {
        h hVar;
        Boolean valueOf;
        i0.h.a.b.d.b bVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            hVar = c;
        }
        if (hVar != null) {
            b bVar2 = f.get();
            if (bVar2 == null || bVar2.a == null) {
                throw new LoadingException("No result cursor", null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = bVar2.a;
            new i0.h.a.b.d.d(null);
            synchronized (DynamiteModule.class) {
                valueOf = Boolean.valueOf(e >= 2);
            }
            if (valueOf.booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                bVar = hVar.p(new i0.h.a.b.d.d(applicationContext), str, i2, new i0.h.a.b.d.d(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                bVar = hVar.j(new i0.h.a.b.d.d(applicationContext), str, i2, new i0.h.a.b.d.d(cursor));
            }
            Context context2 = (Context) i0.h.a.b.d.d.j0(bVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (g(r10) != false) goto L_0x007a;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int j(Context context, String str, boolean z) throws LoadingException {
        Cursor cursor;
        Exception e2;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(z ? "api_force_staging" : "api").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(g.get().longValue())).build(), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i2 = query.getInt(0);
                        if (i2 > 0) {
                            synchronized (DynamiteModule.class) {
                                d = query.getString(2);
                                int columnIndex = query.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    e = query.getInt(columnIndex);
                                }
                            }
                        }
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return i2;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    cursor = query;
                    try {
                        if (e2 instanceof LoadingException) {
                            throw e2;
                        }
                        throw new LoadingException("V2 version check failed", e2, null);
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
        } catch (Exception e4) {
            e2 = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
