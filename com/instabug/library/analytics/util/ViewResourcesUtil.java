package com.instabug.library.analytics.util;

import android.content.Context;
import android.content.res.Resources;
/* loaded from: classes2.dex */
public class ViewResourcesUtil {
    public static String getViewResourceIdAsString(Context context, int i) {
        if (context != null) {
            try {
                if (!(context.getResources() == null || context.getResources().getResourceEntryName(i) == null)) {
                    return context.getResources().getResourceEntryName(i);
                }
            } catch (Resources.NotFoundException unused) {
                return String.valueOf(i);
            }
        }
        return String.valueOf(i);
    }
}
