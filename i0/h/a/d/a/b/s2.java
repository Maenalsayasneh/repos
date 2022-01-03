package i0.h.a.d.a.b;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes2.dex */
public final /* synthetic */ class s2 implements ThreadFactory {
    public static final ThreadFactory c = new s2();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
