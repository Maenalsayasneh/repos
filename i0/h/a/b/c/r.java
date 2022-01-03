package i0.h.a.b.c;

import android.os.RemoteException;
import android.util.Log;
import h0.b0.v;
import i0.h.a.b.c.i.n0;
import i0.h.a.b.c.i.o0;
import i0.h.a.b.d.b;
import i0.h.a.b.d.d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public abstract class r extends o0 {
    public int a;

    public r(byte[] bArr) {
        v.t(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    public static byte[] j0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // i0.h.a.b.c.i.n0
    public final b d() {
        return new d(d0());
    }

    public abstract byte[] d0();

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        b d;
        if (obj != null && (obj instanceof n0)) {
            try {
                n0 n0Var = (n0) obj;
                if (n0Var.h() == this.a && (d = n0Var.d()) != null) {
                    return Arrays.equals(d0(), (byte[]) d.j0(d));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    @Override // i0.h.a.b.c.i.n0
    public final int h() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a;
    }
}
