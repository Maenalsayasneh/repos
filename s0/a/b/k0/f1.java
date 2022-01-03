package s0.a.b.k0;

import s0.a.b.i;
/* loaded from: classes4.dex */
public class f1 implements i {
    public byte[] c;
    public i d;

    public f1(i iVar, byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.c = bArr2;
        this.d = iVar;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }
}
