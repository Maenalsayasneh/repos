package i0.h.c.o;

import java.util.concurrent.ThreadFactory;
/* compiled from: DefaultHeartBeatInfo.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements ThreadFactory {
    public static final c c = new c();

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int i = d.a;
        return new Thread(runnable, "heartbeat-information-executor");
    }
}
