package i0.l.a.f.h;
/* compiled from: AuthenticatedCipherText.java */
/* loaded from: classes2.dex */
public final class b {
    public final byte[] a;
    public final byte[] b;

    public b(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            this.a = bArr;
            if (bArr2 != null) {
                this.b = bArr2;
                return;
            }
            throw new IllegalArgumentException("The authentication tag must not be null");
        }
        throw new IllegalArgumentException("The cipher text must not be null");
    }
}
