package k0.b.z.g;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SchedulerPoolFactory.java */
/* loaded from: classes4.dex */
public final class g {
    public static final boolean a;
    public static final int b;
    public static final AtomicReference<ScheduledExecutorService> c = new AtomicReference<>();
    public static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(g.d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    g.d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039 A[LOOP:0: B:17:0x0039->B:22:0x0064, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        boolean z;
        String property;
        int parseInt;
        String property2;
        try {
            property2 = System.getProperty("rx2.purge-enabled");
        } catch (Throwable unused) {
        }
        if (property2 == null) {
            z = true;
            a = z;
            if (z) {
                try {
                    property = System.getProperty("rx2.purge-period-seconds");
                } catch (Throwable unused2) {
                }
                if (property != null) {
                    parseInt = Integer.parseInt(property);
                    b = parseInt;
                    if (a) {
                        while (true) {
                            AtomicReference<ScheduledExecutorService> atomicReference = c;
                            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                            if (scheduledExecutorService == null) {
                                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                                if (atomicReference.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                                    a aVar = new a();
                                    long j = (long) b;
                                    newScheduledThreadPool.scheduleAtFixedRate(aVar, j, j, TimeUnit.SECONDS);
                                    return;
                                }
                                newScheduledThreadPool.shutdownNow();
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            parseInt = 1;
            b = parseInt;
            if (a) {
            }
        } else {
            z = "true".equals(property2);
            a = z;
            if (z) {
            }
            parseInt = 1;
            b = parseInt;
            if (a) {
            }
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
