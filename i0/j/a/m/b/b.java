package i0.j.a.m.b;

import android.app.Activity;
import android.content.Context;
import android.os.PowerManager;
import android.view.Display;
import android.view.WindowManager;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/* compiled from: APMDeviceStateProviderImpl.java */
/* loaded from: classes2.dex */
public class b implements a {
    public String a(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
    }

    public int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return (int) defaultDisplay.getRefreshRate();
        }
        return 60;
    }

    @SuppressFBWarnings({"NP_BOOLEAN_RETURN_NULL"})
    public Boolean c(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return Boolean.valueOf(powerManager != null && powerManager.isPowerSaveMode());
    }
}
