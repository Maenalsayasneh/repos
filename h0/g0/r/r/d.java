package h0.g0.r.r;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;
/* compiled from: SystemForegroundService.java */
/* loaded from: classes.dex */
public class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Notification d;
    public final /* synthetic */ SystemForegroundService q;

    public d(SystemForegroundService systemForegroundService, int i, Notification notification) {
        this.q = systemForegroundService;
        this.c = i;
        this.d = notification;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.q.Y1.notify(this.c, this.d);
    }
}
