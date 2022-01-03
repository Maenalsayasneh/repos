package i0.h.a.b.c.n;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.RecentlyNonNull;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class a {
    public final Context a;

    public a(@RecentlyNonNull Context context) {
        this.a = context;
    }

    @RecentlyNonNull
    public ApplicationInfo a(@RecentlyNonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    @RecentlyNonNull
    public PackageInfo b(@RecentlyNonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }
}
