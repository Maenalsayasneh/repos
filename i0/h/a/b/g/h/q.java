package i0.h.a.b.g.h;

import com.google.android.gms.internal.recaptcha.zzct;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public final class q implements Iterator {
    public int c = 0;
    public final int d;
    public final /* synthetic */ zzct q;

    public q(zzct zzct) {
        this.q = zzct;
        this.d = zzct.c();
    }

    public final byte a() {
        int i = this.c;
        if (i < this.d) {
            this.c = i + 1;
            return this.q.w(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c < this.d;
    }

    @Override // java.util.Iterator
    public /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
