package h0.g0;

import android.app.Notification;
/* compiled from: ForegroundInfo.java */
/* loaded from: classes.dex */
public final class e {
    public final int a;
    public final int b;
    public final Notification c;

    public e(int i, Notification notification, int i2) {
        this.a = i;
        this.c = notification;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a == eVar.a && this.b == eVar.b) {
            return this.c.equals(eVar.c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode() + (((this.a * 31) + this.b) * 31);
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}
