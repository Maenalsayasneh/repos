package i0.h.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import i0.h.c.u.g;
/* compiled from: FirebaseCommonRegistrar.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements g {
    public static final e a = new e();

    @Override // i0.h.c.u.g
    public String a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.minSdkVersion) : "";
    }
}
