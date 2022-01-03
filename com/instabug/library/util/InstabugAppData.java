package com.instabug.library.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public class InstabugAppData {
    private ApplicationInfo applicationInfo;
    private final Context context;
    private final PackageManager pm;

    public InstabugAppData(Context context) {
        this.context = context;
        PackageManager packageManager = context.getPackageManager();
        this.pm = packageManager;
        try {
            this.applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            InstabugSDKLogger.e("InstabugAppData", e.getMessage(), e);
        }
    }

    public int getAppIcon() {
        ApplicationInfo applicationInfo = this.applicationInfo;
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.icon;
    }

    public String getAppName() {
        ApplicationInfo applicationInfo = this.applicationInfo;
        return (String) (applicationInfo != null ? this.pm.getApplicationLabel(applicationInfo) : "(unknown)");
    }
}
