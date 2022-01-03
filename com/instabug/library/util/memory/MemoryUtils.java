package com.instabug.library.util.memory;

import android.app.ActivityManager;
import android.content.Context;
import com.instabug.library.util.InstabugSDKLogger;
/* loaded from: classes2.dex */
public class MemoryUtils {
    private static final String TAG = "IB-MemoryUtils";

    public static long getFreeMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return 0;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.availMem * ((long) 70)) / 100;
    }

    public static boolean isLowMemory(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.lowMemory;
            }
        } catch (Exception | OutOfMemoryError e) {
            InstabugSDKLogger.e(TAG, e.getLocalizedMessage() != null ? e.getLocalizedMessage() : "Something went wrong while trying to evaluate isLowMemory", e);
        }
        return true;
    }
}
