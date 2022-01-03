package i0.b.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* compiled from: HandlerExecutor.java */
/* loaded from: classes.dex */
public class a0 implements Executor {
    public final Handler c;

    public a0(Handler handler) {
        this.c = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Looper.myLooper() == this.c.getLooper()) {
            runnable.run();
        } else {
            this.c.post(runnable);
        }
    }
}
