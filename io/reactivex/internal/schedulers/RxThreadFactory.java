package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import k0.b.z.g.f;
/* loaded from: classes4.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public final String c;
    public final int d;
    public final boolean q;

    /* loaded from: classes4.dex */
    public static final class a extends Thread implements f {
        public a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this.c = str;
        this.d = 5;
        this.q = false;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.c + '-' + incrementAndGet();
        Thread aVar = this.q ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.d);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong, java.lang.Object
    public String toString() {
        return i0.d.a.a.a.y0(i0.d.a.a.a.P0("RxThreadFactory["), this.c, "]");
    }

    public RxThreadFactory(String str, int i) {
        this.c = str;
        this.d = i;
        this.q = false;
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.c = str;
        this.d = i;
        this.q = z;
    }
}
