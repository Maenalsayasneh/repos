package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.ANRWatchDog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class ANRWatchDog extends Thread {
    private final ANRListener anrListener;
    private final Context context;
    private final ILogger logger;
    private final boolean reportInDebug;
    private final AtomicBoolean reported;
    private final AtomicLong tick;
    private final Runnable ticker;
    private final long timeoutIntervalMillis;
    private final IHandler uiHandler;

    /* loaded from: classes4.dex */
    public interface ANRListener {
        void onAppNotResponding(ApplicationNotResponding applicationNotResponding);
    }

    public ANRWatchDog(long j, boolean z, ANRListener aNRListener, ILogger iLogger, Context context) {
        this(j, z, aNRListener, iLogger, new MainLooperHandler(), context);
    }

    public /* synthetic */ void a() {
        this.tick.set(0);
        this.reported.set(false);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        setName("|ANR-WatchDog|");
        long j = this.timeoutIntervalMillis;
        while (!isInterrupted()) {
            boolean z2 = this.tick.get() == 0;
            this.tick.addAndGet(j);
            if (z2) {
                this.uiHandler.post(this.ticker);
            }
            try {
                Thread.sleep(j);
                if (this.tick.get() != 0 && !this.reported.get()) {
                    if (this.reportInDebug || (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger())) {
                        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
                        if (activityManager != null) {
                            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                            if (processesInErrorState != null) {
                                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().condition == 2) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                }
                            }
                        }
                        this.logger.log(SentryLevel.INFO, "Raising ANR", new Object[0]);
                        this.anrListener.onAppNotResponding(new ApplicationNotResponding("Application Not Responding for at least " + this.timeoutIntervalMillis + " ms.", this.uiHandler.getThread()));
                        j = this.timeoutIntervalMillis;
                        this.reported.set(true);
                    } else {
                        this.logger.log(SentryLevel.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.reported.set(true);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.logger.log(SentryLevel.WARNING, "Interrupted: %s", e.getMessage());
                return;
            }
        }
    }

    public ANRWatchDog(long j, boolean z, ANRListener aNRListener, ILogger iLogger, IHandler iHandler, Context context) {
        this.tick = new AtomicLong(0);
        this.reported = new AtomicBoolean(false);
        this.ticker = new Runnable() { // from class: k0.c.w.a.a
            @Override // java.lang.Runnable
            public final void run() {
                ANRWatchDog.this.a();
            }
        };
        this.reportInDebug = z;
        this.anrListener = aNRListener;
        this.timeoutIntervalMillis = j;
        this.logger = iLogger;
        this.uiHandler = iHandler;
        this.context = context;
    }
}
