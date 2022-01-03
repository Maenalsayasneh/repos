package h0.g0.r.t;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* compiled from: SerialExecutor.java */
/* loaded from: classes.dex */
public class i implements Executor {
    public final Executor d;
    public volatile Runnable x;
    public final ArrayDeque<a> c = new ArrayDeque<>();
    public final Object q = new Object();

    /* compiled from: SerialExecutor.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final i c;
        public final Runnable d;

        public a(i iVar, Runnable runnable) {
            this.c = iVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.d.run();
            } finally {
                this.c.a();
            }
        }
    }

    public i(Executor executor) {
        this.d = executor;
    }

    public void a() {
        synchronized (this.q) {
            a poll = this.c.poll();
            this.x = poll;
            if (poll != null) {
                this.d.execute(this.x);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.q) {
            this.c.add(new a(this, runnable));
            if (this.x == null) {
                a();
            }
        }
    }
}
