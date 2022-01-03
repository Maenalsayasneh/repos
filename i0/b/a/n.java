package i0.b.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* compiled from: EpoxyAsyncUtil.java */
/* loaded from: classes.dex */
public final class n {
    public static final Handler a = a(Looper.getMainLooper(), false);
    public static final Handler b = a(Looper.getMainLooper(), true);
    public static Handler c;

    public static Handler a(Looper looper, boolean z) {
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (Throwable unused) {
            return new Handler(looper);
        }
    }

    public static Handler b() {
        if (c == null) {
            HandlerThread handlerThread = new HandlerThread("epoxy");
            handlerThread.start();
            c = a(handlerThread.getLooper(), true);
        }
        return c;
    }
}
