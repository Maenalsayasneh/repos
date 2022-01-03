package h0.b0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
/* compiled from: ViewUtilsApi23.java */
/* loaded from: classes.dex */
public class a0 extends z {
    public static boolean g = true;

    @Override // h0.b0.c0
    @SuppressLint({"NewApi"})
    public void f(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i);
        } else if (g) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
