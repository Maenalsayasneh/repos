package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import h0.g0.i;
import h0.g0.r.l;
import h0.g0.r.r.c;
import h0.g0.r.t.q.b;
import h0.q.t;
import java.util.Objects;
import java.util.UUID;
/* loaded from: classes.dex */
public class SystemForegroundService extends t implements c.a {
    public static final String d = i.e("SystemFgService");
    public NotificationManager Y1;
    public Handler q;
    public boolean x;
    public c y;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int c;
        public final /* synthetic */ Notification d;
        public final /* synthetic */ int q;

        public a(int i, Notification notification, int i2) {
            this.c = i;
            this.d = notification;
            this.q = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.c, this.d, this.q);
            } else {
                SystemForegroundService.this.startForeground(this.c, this.d);
            }
        }
    }

    public final void a() {
        this.q = new Handler(Looper.getMainLooper());
        this.Y1 = (NotificationManager) getApplicationContext().getSystemService("notification");
        c cVar = new c(getApplicationContext());
        this.y = cVar;
        if (cVar.d2 != null) {
            i.c().b(c.c, "A callback already exists.", new Throwable[0]);
        } else {
            cVar.d2 = this;
        }
    }

    public void b(int i, int i2, Notification notification) {
        this.q.post(new a(i, notification, i2));
    }

    @Override // h0.q.t, android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // h0.q.t, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.y.c();
    }

    @Override // h0.q.t, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.x) {
            i.c().d(d, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.y.c();
            a();
            this.x = false;
        }
        if (intent == null) {
            return 3;
        }
        c cVar = this.y;
        Objects.requireNonNull(cVar);
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i.c().d(c.c, String.format("Started foreground service %s", intent), new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            WorkDatabase workDatabase = cVar.q.g;
            ((b) cVar.x).a.execute(new h0.g0.r.r.b(cVar, workDatabase, stringExtra));
            cVar.a(intent);
            return 3;
        } else if ("ACTION_NOTIFY".equals(action)) {
            cVar.a(intent);
            return 3;
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            i.c().d(c.c, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
            String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
            if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
                return 3;
            }
            l lVar = cVar.q;
            UUID fromString = UUID.fromString(stringExtra2);
            Objects.requireNonNull(lVar);
            ((b) lVar.h).a.execute(new h0.g0.r.t.a(lVar, fromString));
            return 3;
        } else if (!"ACTION_STOP_FOREGROUND".equals(action)) {
            return 3;
        } else {
            i.c().d(c.c, "Stopping foreground service", new Throwable[0]);
            c.a aVar = cVar.d2;
            if (aVar == null) {
                return 3;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) aVar;
            systemForegroundService.x = true;
            i.c().a(d, "All commands completed.", new Throwable[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf();
            return 3;
        }
    }
}
