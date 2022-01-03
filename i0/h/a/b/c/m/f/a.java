package i0.h.a.b.c.m.f;

import androidx.annotation.RecentlyNonNull;
import h0.b0.v;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class a implements ThreadFactory {
    public final String c;
    public final ThreadFactory d = Executors.defaultThreadFactory();

    public a(@RecentlyNonNull String str) {
        v.A(str, "Name must not be null");
        this.c = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @RecentlyNonNull
    public Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread newThread = this.d.newThread(new b(runnable));
        newThread.setName(this.c);
        return newThread;
    }
}
