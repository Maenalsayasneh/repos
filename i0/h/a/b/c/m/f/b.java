package i0.h.a.b.c.m.f;

import android.os.Process;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class b implements Runnable {
    public final Runnable c;

    public b(Runnable runnable) {
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.c.run();
    }
}
