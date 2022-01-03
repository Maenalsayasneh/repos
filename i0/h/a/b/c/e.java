package i0.h.a.b.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.google.android.gms.common.R;
import h0.b0.v;
import i0.h.a.b.c.i.p0;
import i0.h.a.b.c.n.b;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class e {
    public static boolean a = false;
    public static boolean b = false;
    public static final AtomicBoolean c = new AtomicBoolean();
    public static final AtomicBoolean d = new AtomicBoolean();

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int a(@RecentlyNonNull Context context, int i) {
        boolean z;
        String packageName;
        PackageInfo packageInfo;
        int i2;
        Bundle bundle;
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !d.get()) {
            synchronized (p0.a) {
                if (!p0.b) {
                    p0.b = true;
                    try {
                        bundle = b.a(context).a(context.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.wtf("MetadataValueReader", "This should never happen.", e);
                    }
                    if (bundle != null) {
                        bundle.getString("com.google.app.id");
                        p0.c = bundle.getInt("com.google.android.gms.version");
                    }
                }
            }
            int i3 = p0.c;
            if (i3 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            } else if (i3 != 12451000) {
                throw new GooglePlayServicesIncorrectManifestValueException(i3);
            }
        }
        try {
            if (!v.N0(context)) {
                if (v.d == null) {
                    v.d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
                }
                if (!v.d.booleanValue()) {
                    z = true;
                    v.t(i < 0);
                    packageName = context.getPackageName();
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo2 = null;
                    if (z) {
                        try {
                            packageInfo2 = packageManager.getPackageInfo("com.android.vending", 8256);
                        } catch (PackageManager.NameNotFoundException unused2) {
                            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                        }
                    }
                    packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    f.a(context);
                    if (f.c(packageInfo, true)) {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                    } else {
                        if (z) {
                            Objects.requireNonNull(packageInfo2, "null reference");
                            if (!f.c(packageInfo2, true) || !packageInfo2.signatures[0].equals(packageInfo.signatures[0])) {
                                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                            }
                        }
                        int i4 = packageInfo.versionCode;
                        int i5 = -1;
                        if (i4 == -1) {
                            i2 = -1;
                        } else {
                            i2 = i4 / 1000;
                        }
                        if (i != -1) {
                            i5 = i / 1000;
                        }
                        if (i2 < i5) {
                            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                            sb.append("Google Play services out of date for ");
                            sb.append(packageName);
                            sb.append(".  Requires ");
                            sb.append(i);
                            sb.append(" but found ");
                            sb.append(i4);
                            Log.w("GooglePlayServicesUtil", sb.toString());
                            return 2;
                        }
                        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                                return 1;
                            }
                        }
                        if (!applicationInfo.enabled) {
                            return 3;
                        }
                        return 0;
                    }
                    return 9;
                }
            }
            packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            f.a(context);
            if (f.c(packageInfo, true)) {
            }
            return 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
        z = false;
        v.t(i < 0);
        packageName = context.getPackageName();
        PackageManager packageManager2 = context.getPackageManager();
        PackageInfo packageInfo22 = null;
        if (z) {
        }
    }
}
