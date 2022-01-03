package i0.h.a.d.a.e;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class u extends WeakReference<Throwable> {
    public final int a;

    public u(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == u.class) {
            if (this == obj) {
                return true;
            }
            u uVar = (u) obj;
            if (this.a == uVar.a && get() == uVar.get()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.a;
    }
}
