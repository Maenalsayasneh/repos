package i0.h.c.t;

import java.util.concurrent.Executor;
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class m implements Executor {
    public static final Executor c = new m();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
