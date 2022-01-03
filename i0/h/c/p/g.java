package i0.h.c.p;

import java.util.concurrent.Executor;
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Executor {
    public static final Executor c = new g();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
