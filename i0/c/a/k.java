package i0.c.a;

import android.util.Log;
/* compiled from: AmplitudeLog.java */
/* loaded from: classes.dex */
public class k {
    public static k a = new k();
    public volatile boolean b = true;
    public volatile int c = 4;

    public int a(String str, String str2) {
        if (!this.b || this.c > 6) {
            return 0;
        }
        return Log.e(str, str2);
    }

    public int b(String str, String str2, Throwable th) {
        if (!this.b || this.c > 6) {
            return 0;
        }
        return Log.e(str, str2, th);
    }

    public int c(String str, String str2) {
        if (!this.b || this.c > 5) {
            return 0;
        }
        return Log.w(str, str2);
    }
}
