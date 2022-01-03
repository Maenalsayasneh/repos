package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.x = Thread.currentThread();
        try {
            this.q.run();
            return null;
        } finally {
            lazySet(AbstractDirectTask.c);
            this.x = null;
        }
    }
}
