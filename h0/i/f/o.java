package h0.i.f;

import android.os.Handler;
import java.util.concurrent.Callable;
/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
public class o<T> implements Runnable {
    public Callable<T> c;
    public h0.i.h.a<T> d;
    public Handler q;

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ h0.i.h.a c;
        public final /* synthetic */ Object d;

        public a(o oVar, h0.i.h.a aVar, Object obj) {
            this.c = aVar;
            this.d = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.c.b(this.d);
        }
    }

    public o(Handler handler, Callable<T> callable, h0.i.h.a<T> aVar) {
        this.c = callable;
        this.d = aVar;
        this.q = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        T t;
        try {
            t = this.c.call();
        } catch (Exception unused) {
            t = null;
        }
        this.q.post(new a(this, this.d, t));
    }
}
