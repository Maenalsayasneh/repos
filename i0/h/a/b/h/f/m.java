package i0.h.a.b.h.f;

import android.os.Bundle;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class m {
    public static <T extends Parcelable> T a(Bundle bundle, String str) {
        bundle.setClassLoader(m.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(m.class.getClassLoader());
        return (T) bundle2.getParcelable(str);
    }

    public static void b(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            Parcelable a = a(bundle, "MapOptions");
            if (a != null) {
                c(bundle2, "MapOptions", a);
            }
            Parcelable a2 = a(bundle, "StreetViewPanoramaOptions");
            if (a2 != null) {
                c(bundle2, "StreetViewPanoramaOptions", a2);
            }
            Parcelable a3 = a(bundle, "camera");
            if (a3 != null) {
                c(bundle2, "camera", a3);
            }
            if (bundle.containsKey("position")) {
                bundle2.putString("position", bundle.getString("position"));
            }
            if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
                bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
            }
        }
    }

    public static void c(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(m.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(m.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
