package i0.h.a.b.g.b;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes2.dex */
public final class c implements b, IInterface {
    public final IBinder a;

    public c(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
