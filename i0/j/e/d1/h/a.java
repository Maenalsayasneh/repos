package i0.j.e.d1.h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* compiled from: MainThreadExecutor.java */
/* loaded from: classes2.dex */
public class a implements Executor {
    public final Handler c = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.c.post(runnable);
    }
}
