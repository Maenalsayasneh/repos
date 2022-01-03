package h0.b.f;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import h0.i.i.q;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class c1 {
    public static Method a;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                a.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = a;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static boolean b(View view) {
        AtomicInteger atomicInteger = q.a;
        return view.getLayoutDirection() == 1;
    }
}
