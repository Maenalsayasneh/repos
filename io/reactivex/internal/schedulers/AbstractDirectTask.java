package io.reactivex.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import k0.b.w.a;
/* loaded from: classes4.dex */
public abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements a {
    public static final FutureTask<Void> c;
    public static final FutureTask<Void> d;
    public final Runnable q;
    public Thread x;

    static {
        Runnable runnable = k0.b.z.b.a.b;
        c = new FutureTask<>(runnable, null);
        d = new FutureTask<>(runnable, null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.q = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 != c) {
                if (future2 == d) {
                    future.cancel(this.x != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // k0.b.w.a
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future != c && future != (futureTask = d) && compareAndSet(future, futureTask) && future != null) {
            future.cancel(this.x != Thread.currentThread());
        }
    }

    @Override // k0.b.w.a
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == c || future == d;
    }
}
