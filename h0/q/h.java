package h0.q;

import java.util.ArrayDeque;
import java.util.Queue;
/* compiled from: DispatchQueue.kt */
/* loaded from: classes.dex */
public final class h {
    public boolean b;
    public boolean c;
    public boolean a = true;
    public final Queue<Runnable> d = new ArrayDeque();

    public final boolean a() {
        return this.b || !this.a;
    }

    public final void b() {
        if (!this.c) {
            try {
                this.c = true;
                while ((!this.d.isEmpty()) && a()) {
                    Runnable poll = this.d.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            } finally {
                this.c = false;
            }
        }
    }

    public final void c(Runnable runnable) {
        if (this.d.offer(runnable)) {
            b();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }
}
