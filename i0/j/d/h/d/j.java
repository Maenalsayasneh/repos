package i0.j.d.h.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: InstaToastManager.java */
/* loaded from: classes2.dex */
public class j {
    public static j a;
    public final Object b = new Object();
    public final Handler c = new Handler(Looper.getMainLooper(), new a());
    public c d;
    public c e;

    /* compiled from: InstaToastManager.java */
    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            j jVar = j.this;
            c cVar = (c) message.obj;
            synchronized (jVar.b) {
                if (jVar.d == cVar || jVar.e == cVar) {
                    jVar.c(cVar, 2);
                }
            }
            return true;
        }
    }

    /* compiled from: InstaToastManager.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void e(int i);
    }

    /* compiled from: InstaToastManager.java */
    /* loaded from: classes2.dex */
    public static class c {
        public final WeakReference<b> a;
        public int b;

        public c(int i, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.b = i;
        }
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    public void b(b bVar) {
        synchronized (this.b) {
            if (this.d != null && h(bVar)) {
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    public final boolean c(c cVar, int i) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        bVar.e(i);
        return true;
    }

    public final void d() {
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

    public final void e(c cVar) {
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

    public void f(b bVar) {
        synchronized (this.b) {
            if (this.d != null) {
                if (h(bVar)) {
                    e(this.d);
                }
            }
        }
    }

    public void g(b bVar) {
        synchronized (this.b) {
            if (this.d != null) {
                if (h(bVar)) {
                    e(this.d);
                }
            }
        }
    }

    public final boolean h(b bVar) {
        c cVar = this.d;
        if (cVar != null) {
            if (bVar != null && cVar.a.get() == bVar) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(b bVar) {
        c cVar = this.e;
        if (cVar != null) {
            if (bVar != null && cVar.a.get() == bVar) {
                return true;
            }
        }
        return false;
    }
}
