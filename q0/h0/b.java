package q0.h0;

import java.util.concurrent.ThreadFactory;
/* compiled from: Util.kt */
/* loaded from: classes4.dex */
public final class b implements ThreadFactory {
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public b(String str, boolean z) {
        this.c = str;
        this.d = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.c);
        thread.setDaemon(this.d);
        return thread;
    }
}
