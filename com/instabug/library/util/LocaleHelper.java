package com.instabug.library.util;

import android.content.Context;
import java.util.Locale;
/* loaded from: classes2.dex */
public class LocaleHelper {
    public static boolean isRTL(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().getLayoutDirection() == 1;
        }
        return isRTL(Locale.getDefault());
    }

    public static boolean isRTL(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == 1 || directionality == 2;
    }
}
