package i0.h.a.c.x;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: SnackbarManager.java */
/* loaded from: classes2.dex */
public class o {
    public static o a;
    public final Object b = new Object();
    public final Handler c = new Handler(Looper.getMainLooper(), new a());
    public c d;
    public c e;

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            o oVar = o.this;
            c cVar = (c) message.obj;
            synchronized (oVar.b) {
                if (oVar.d == cVar || oVar.e == cVar) {
                    oVar.a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b(int i);
    }

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public static class c {
        public final WeakReference<b> a;
        public int b;
        public boolean c;

        public c(int i, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.b = i;
        }
    }

    public static o b() {
        if (a == null) {
            a = new o();
        }
        return a;
    }

    public final boolean a(c cVar, int i) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(cVar);
        bVar.b(i);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.d;
        if (cVar != null) {
            if (bVar != null && cVar.a.get() == bVar) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.e;
        if (cVar != null) {
            if (bVar != null && cVar.a.get() == bVar) {
                return true;
            }
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.b) {
            if (c(bVar)) {
                c cVar = this.d;
                if (!cVar.c) {
                    cVar.c = true;
                    this.c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.b) {
            if (c(bVar)) {
                c cVar = this.d;
                if (cVar.c) {
                    cVar.c = false;
                    g(cVar);
                }
            }
        }
    }

    public final void g(c cVar) {
        int i = cVar.b;
        if (i != -2) {
            i = 2750;
            if (i <= 0 && i == -1) {
                i = 1500;
            }
            this.c.removeCallbacksAndMessages(cVar);
            Handler handler = this.c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i);
        }
    }

    public final void h() {
        c cVar = this.e;
        if (cVar != null) {
            this.d = cVar;
            this.e = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.d = null;
            }
        }
    }
}
