package i0.c.a;

import android.os.Handler;
import android.os.HandlerThread;
/* compiled from: WorkerThread.java */
/* loaded from: classes.dex */
public class s extends HandlerThread {
    public Handler c;

    public s(String str) {
        super(str, 10);
    }

    public void a(Runnable runnable) {
        b();
        this.c.post(runnable);
    }

    public final synchronized void b() {
        if (this.c == null) {
            this.c = new Handler(getLooper());
        }
    }
}
