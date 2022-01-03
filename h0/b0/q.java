package h0.b0;

import android.os.Build;
/* compiled from: TransitionUtils.java */
/* loaded from: classes.dex */
public class q {
    public static final boolean a = true;
    public static final boolean b = true;
    public static final boolean c;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 28) {
            z = false;
        }
        c = z;
    }
}
