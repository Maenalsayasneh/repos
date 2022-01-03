package i0.h.a.b.g.k;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* loaded from: classes2.dex */
public final class k implements IInterface {
    public final IBinder a;
    public final String b = "com.google.android.gms.wallet.internal.IOwService";

    public k(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
