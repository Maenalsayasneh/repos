package i0.h.c.r.q;

import i0.h.c.r.n;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/* compiled from: RequestLimiter.java */
/* loaded from: classes2.dex */
public class d {
    public static final long a = TimeUnit.HOURS.toMillis(24);
    public static final long b = TimeUnit.MINUTES.toMillis(30);
    public final n c = n.c();
    public long d;
    public int e;

    public synchronized boolean a() {
        boolean z;
        if (this.e != 0) {
            if (this.c.a() <= this.d) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public synchronized void b(int i) {
        long j;
        boolean z = false;
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            synchronized (this) {
                this.e = 0;
            }
            return;
        }
        this.e++;
        synchronized (this) {
            if (i == 429 || (i >= 500 && i < 600)) {
                z = true;
            }
            if (!z) {
                j = a;
            } else {
                double pow = Math.pow(2.0d, (double) this.e);
                Objects.requireNonNull(this.c);
                j = (long) Math.min(pow + ((double) ((long) (Math.random() * 1000.0d))), (double) b);
            }
            this.d = this.c.a() + j;
        }
    }
}
