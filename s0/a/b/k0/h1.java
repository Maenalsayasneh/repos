package s0.a.b.k0;

import s0.a.b.i;
/* loaded from: classes4.dex */
public class h1 implements i {
    public byte[] c;
    public int d;

    public h1(byte[] bArr, int i) {
        if (bArr.length <= 255) {
            byte[] bArr2 = new byte[bArr.length];
            this.c = bArr2;
            this.d = i;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return;
        }
        throw new IllegalArgumentException("RC5 key length can be no greater than 255");
    }
}
