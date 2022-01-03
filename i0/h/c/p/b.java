package i0.h.c.p;

import i0.h.a.b.c.m.f.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes2.dex */
public class b {
    public static final /* synthetic */ int a = 0;

    public static ExecutorService a() {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("firebase-iid-executor"));
    }
}
