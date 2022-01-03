package s0.a.b.k0;

import s0.a.b.i;
/* loaded from: classes4.dex */
public class c1 implements i {
    public byte[] c;
    public i d;

    public c1(i iVar, byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.c = bArr2;
        this.d = iVar;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }

    public c1(i iVar, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.c = bArr2;
        this.d = iVar;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
