package h0.b0;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class u {
    public static boolean a = true;

    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
