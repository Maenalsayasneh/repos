package h0.b0;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
/* compiled from: ViewUtilsBase.java */
/* loaded from: classes.dex */
public class c0 {
    public static Field a;
    public static boolean b;

    public void a(View view) {
        throw null;
    }

    public float b(View view) {
        throw null;
    }

    public void c(View view) {
        throw null;
    }

    public void d(View view, int i, int i2, int i3, int i4) {
        throw null;
    }

    public void e(View view, float f) {
        throw null;
    }

    public void f(View view, int i) {
        if (!b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            b = true;
        }
        Field field = a;
        if (field != null) {
            try {
                a.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void g(View view, Matrix matrix) {
        throw null;
    }

    public void h(View view, Matrix matrix) {
        throw null;
    }
}
