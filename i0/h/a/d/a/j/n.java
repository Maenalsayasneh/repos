package i0.h.a.d.a.j;

import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class n implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
