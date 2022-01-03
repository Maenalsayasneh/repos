package i0.h.a.b.g.c;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes2.dex */
public class b implements IInterface {
    public final IBinder a;
    public final String b;

    public b(IBinder iBinder, String str) {
        this.a = iBinder;
        this.b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
