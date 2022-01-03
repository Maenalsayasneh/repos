package h0.i.e;
/* compiled from: CancellationSignal.java */
/* loaded from: classes.dex */
public final class a {
    public boolean a;
    public AbstractC0071a b;
    public boolean c;

    /* compiled from: CancellationSignal.java */
    /* renamed from: h0.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0071a {
        void a();
    }

    public void a() {
        synchronized (this) {
            try {
                if (!this.a) {
                    this.a = true;
                    this.c = true;
                    AbstractC0071a aVar = this.b;
                    if (aVar != null) {
                        try {
                            aVar.a();
                        } catch (Throwable th) {
                            synchronized (this) {
                                try {
                                    this.c = false;
                                    notifyAll();
                                    throw th;
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        try {
                            this.c = false;
                            notifyAll();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public void b(AbstractC0071a aVar) {
        synchronized (this) {
            while (this.c) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.b != aVar) {
                this.b = aVar;
                if (this.a) {
                    aVar.a();
                }
            }
        }
    }
}
