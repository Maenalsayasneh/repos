package h0.i.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import h0.i.b.d.d;
import h0.i.b.d.e;
import h0.i.f.l;
import i0.d.a.a.a;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class h extends f {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public h() {
        Method method;
        Method method2;
        Method method3;
        Constructor<?> constructor;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            method3 = n(cls2);
            method2 = o(cls2);
            method = cls2.getMethod("freeze", new Class[0]);
            method4 = cls2.getMethod("abortCreation", new Class[0]);
            method5 = p(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder P0 = a.P0("Unable to collect necessary methods for class ");
            P0.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", P0.toString(), e);
            method5 = null;
            method4 = null;
            constructor = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.g = cls;
        this.h = constructor;
        this.i = method3;
        this.j = method2;
        this.k = method;
        this.l = method4;
        this.m = method5;
    }

    private Object m() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // h0.i.c.f, h0.i.c.l
    public Typeface a(Context context, d dVar, Resources resources, int i) {
        if (!l()) {
            return super.a(context, dVar, resources, i);
        }
        Object m = m();
        if (m == null) {
            return null;
        }
        e[] eVarArr = dVar.a;
        for (e eVar : eVarArr) {
            if (!i(context, m, eVar.a, eVar.e, eVar.b, eVar.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(eVar.d))) {
                h(m);
                return null;
            }
        }
        if (!k(m)) {
            return null;
        }
        return j(m);
    }

    @Override // h0.i.c.f, h0.i.c.l
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i) {
        Typeface j;
        boolean z;
        if (lVarArr.length < 1) {
            return null;
        }
        if (!l()) {
            l lVar = (l) l.e(lVarArr, i, new k(this));
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(lVar.a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(lVar.c).setItalic(lVar.d).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        } else {
            HashMap hashMap = new HashMap();
            for (l lVar2 : lVarArr) {
                if (lVar2.e == 0) {
                    Uri uri = lVar2.a;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, g0.a.b.b.a.g0(context, cancellationSignal, uri));
                    }
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            Object m = m();
            if (m == null) {
                return null;
            }
            int length = lVarArr.length;
            int i2 = 0;
            boolean z2 = false;
            while (i2 < length) {
                l lVar3 = lVarArr[i2];
                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(lVar3.a);
                if (byteBuffer != null) {
                    try {
                        z = ((Boolean) this.j.invoke(m, byteBuffer, Integer.valueOf(lVar3.b), null, Integer.valueOf(lVar3.c), Integer.valueOf(lVar3.d ? 1 : 0))).booleanValue();
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                        z = false;
                    }
                    if (!z) {
                        h(m);
                        return null;
                    }
                    z2 = true;
                }
                i2++;
                z2 = z2;
            }
            if (!z2) {
                h(m);
                return null;
            } else if (k(m) && (j = j(m)) != null) {
                return Typeface.create(j, i);
            } else {
                return null;
            }
        }
    }

    @Override // h0.i.c.l
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        if (!l()) {
            return super.d(context, resources, i, str, i2);
        }
        Object m = m();
        if (m == null) {
            return null;
        }
        if (!i(context, m, str, 0, -1, -1, null)) {
            h(m);
            return null;
        } else if (!k(m)) {
            return null;
        } else {
            return j(m);
        }
    }

    public final void h(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean i(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean k(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean l() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    public Method n(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method o(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method p(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
