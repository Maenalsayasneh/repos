package h0.b.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
public class q {
    public static q a;
    public final Context b;
    public final LocationManager c;
    public final a d = new a();

    /* compiled from: TwilightManager.java */
    /* loaded from: classes.dex */
    public static class a {
        public boolean a;
        public long b;
    }

    public q(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    public final Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }
}
