package s0.a.b.m0.f;

import java.util.Hashtable;
import s0.a.b.n;
/* loaded from: classes4.dex */
public class d {
    public static final Hashtable a;

    static {
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        hashtable.put("SHA-1", 128);
        hashtable.put("SHA-224", 192);
        hashtable.put("SHA-256", 256);
        hashtable.put("SHA-384", 256);
        hashtable.put("SHA-512", 256);
        hashtable.put("SHA-512/224", 192);
        hashtable.put("SHA-512/256", 256);
    }

    public static byte[] a(n nVar, byte[] bArr, int i) {
        int i2 = (i + 7) / 8;
        byte[] bArr2 = new byte[i2];
        int digestSize = i2 / nVar.getDigestSize();
        int digestSize2 = nVar.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        int i3 = 1;
        int i4 = 0;
        for (int i5 = 0; i5 <= digestSize; i5++) {
            nVar.update((byte) i3);
            nVar.update((byte) (i >> 24));
            nVar.update((byte) (i >> 16));
            nVar.update((byte) (i >> 8));
            nVar.update((byte) i);
            nVar.update(bArr, 0, bArr.length);
            nVar.doFinal(bArr3, 0);
            int i6 = i5 * digestSize2;
            int i7 = i2 - i6;
            if (i7 > digestSize2) {
                i7 = digestSize2;
            }
            System.arraycopy(bArr3, 0, bArr2, i6, i7);
            i3++;
        }
        int i8 = i % 8;
        if (i8 != 0) {
            int i9 = 8 - i8;
            int i10 = 0;
            while (i4 != i2) {
                int i11 = bArr2[i4] & 255;
                bArr2[i4] = (byte) ((i10 << (8 - i9)) | (i11 >>> i9));
                i4++;
                i10 = i11;
            }
        }
        return bArr2;
    }
}
