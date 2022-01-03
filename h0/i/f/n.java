package h0.i.f;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
public class n implements ThreadFactory {
    public String c;
    public int d;

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    public static class a extends Thread {
        public final int c;

        public a(Runnable runnable, String str, int i) {
            super(runnable, str);
            this.c = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(this.c);
            super.run();
        }
    }

    public n(String str, int i) {
        this.c = str;
        this.d = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new a(runnable, this.c, this.d);
    }
}
