package i0.h.a.c.u;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
/* compiled from: RippleUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static final int[] a = {16842919};
    public static final int[] b = {16843623, 16842908};
    public static final int[] c = {16842908};
    public static final int[] d = {16843623};
    public static final int[] e = {16842913, 16842919};
    public static final int[] f = {16842913, 16843623, 16842908};
    public static final int[] g = {16842913, 16842908};
    public static final int[] h = {16842913, 16843623};
    public static final int[] i = {16842913};
    public static final int[] j = {16842910, 16842919};
    public static final String k = a.class.getSimpleName();

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return h0.i.c.a.c(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(j, 0)) != 0) {
            Log.w(k, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean c(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
