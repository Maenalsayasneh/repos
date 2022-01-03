package i0.c.b;

import java.security.DigestException;
import java.security.MessageDigest;
/* compiled from: MD5.java */
/* loaded from: classes.dex */
public final class a extends MessageDigest implements Cloneable {
    public long c;
    public int d;
    public byte[] q = new byte[64];
    public int x = 1732584193;
    public int y = -271733879;
    public int Y1 = -1732584194;
    public int Z1 = 271733878;

    public a() {
        super("MD5");
    }

    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r13v77 ?? I:??[int, boolean])
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:107)
        */
    public final void b(byte[] r28, int r29) {
        /*
        // Method dump skipped, instructions count: 1652
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.c.b.a.b(byte[], int):void");
    }

    @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        a aVar = (a) super.clone();
        aVar.q = (byte[]) this.q.clone();
        return aVar;
    }

    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        try {
            byte[] bArr = new byte[16];
            engineDigest(bArr, 0, 16);
            return bArr;
        } catch (DigestException unused) {
            return null;
        }
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return 16;
    }

    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        this.d = 0;
        this.c = 0;
        byte[] bArr = this.q;
        int i = 60;
        do {
            bArr[i - 4] = 0;
            bArr[i - 3] = 0;
            bArr[i - 2] = 0;
            bArr[i - 1] = 0;
            bArr[i] = 0;
            bArr[i + 1] = 0;
            bArr[i + 2] = 0;
            bArr[i + 3] = 0;
            i -= 8;
        } while (i >= 0);
        this.x = 1732584193;
        this.y = -271733879;
        this.Y1 = -1732584194;
        this.Z1 = 271733878;
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b) {
        this.c++;
        int i = this.d;
        if (i < 63) {
            byte[] bArr = this.q;
            this.d = i + 1;
            bArr[i] = b;
            return;
        }
        byte[] bArr2 = this.q;
        bArr2[63] = b;
        b(bArr2, i);
        this.d = 0;
    }

    @Override // java.security.MessageDigestSpi
    public int engineDigest(byte[] bArr, int i, int i2) throws DigestException {
        if (i2 < 16) {
            throw new DigestException("partial digests not returned");
        } else if (bArr.length - i >= 16) {
            byte[] bArr2 = this.q;
            int i3 = this.d;
            bArr2[i3] = Byte.MIN_VALUE;
            switch (i3) {
                case 56:
                    bArr2[57] = 0;
                case 57:
                    bArr2[58] = 0;
                case 58:
                    bArr2[59] = 0;
                case 59:
                    bArr2[60] = 0;
                case 60:
                    bArr2[61] = 0;
                case 61:
                    bArr2[62] = 0;
                case 62:
                    bArr2[63] = 0;
                case 63:
                    b(bArr2, 0);
                    i3 = -1;
                    break;
            }
            switch (i3 & 7) {
                case 0:
                    i3 += 4;
                    bArr2[i3 - 3] = 0;
                    bArr2[i3 - 2] = 0;
                    bArr2[i3 - 1] = 0;
                    bArr2[i3] = 0;
                    bArr2[i3 + 1] = 0;
                    bArr2[i3 + 2] = 0;
                    bArr2[i3 + 3] = 0;
                    break;
                case 1:
                    i3 += 3;
                    bArr2[i3 - 2] = 0;
                    bArr2[i3 - 1] = 0;
                    bArr2[i3] = 0;
                    bArr2[i3 + 1] = 0;
                    bArr2[i3 + 2] = 0;
                    bArr2[i3 + 3] = 0;
                    break;
                case 2:
                    i3 += 2;
                    bArr2[i3 - 1] = 0;
                    bArr2[i3] = 0;
                    bArr2[i3 + 1] = 0;
                    bArr2[i3 + 2] = 0;
                    bArr2[i3 + 3] = 0;
                    break;
                case 3:
                    i3++;
                    bArr2[i3] = 0;
                    bArr2[i3 + 1] = 0;
                    bArr2[i3 + 2] = 0;
                    bArr2[i3 + 3] = 0;
                    break;
                case 4:
                    bArr2[i3 + 1] = 0;
                    bArr2[i3 + 2] = 0;
                    bArr2[i3 + 3] = 0;
                    break;
                case 5:
                    i3--;
                    bArr2[i3 + 2] = 0;
                    bArr2[i3 + 3] = 0;
                    break;
                case 6:
                    i3 -= 2;
                    bArr2[i3 + 3] = 0;
                    break;
                case 7:
                    i3 -= 3;
                    break;
            }
            while (true) {
                i3 += 8;
                if (i3 <= 52) {
                    bArr2[i3 - 4] = 0;
                    bArr2[i3 - 3] = 0;
                    bArr2[i3 - 2] = 0;
                    bArr2[i3 - 1] = 0;
                    bArr2[i3] = 0;
                    bArr2[i3 + 1] = 0;
                    bArr2[i3 + 2] = 0;
                    bArr2[i3 + 3] = 0;
                } else {
                    long j = this.c;
                    int i4 = ((int) j) << 3;
                    bArr2[56] = (byte) i4;
                    bArr2[57] = (byte) (i4 >>> 8);
                    bArr2[58] = (byte) (i4 >>> 16);
                    bArr2[59] = (byte) (i4 >>> 24);
                    int i5 = (int) (j >>> 29);
                    bArr2[60] = (byte) i5;
                    bArr2[61] = (byte) (i5 >>> 8);
                    bArr2[62] = (byte) (i5 >>> 16);
                    bArr2[63] = (byte) (i5 >>> 24);
                    b(bArr2, 0);
                    int i6 = this.x;
                    bArr[i] = (byte) i6;
                    bArr[i + 1] = (byte) (i6 >>> 8);
                    bArr[i + 2] = (byte) (i6 >>> 16);
                    bArr[i + 3] = (byte) (i6 >>> 24);
                    int i7 = this.y;
                    bArr[i + 4] = (byte) i7;
                    bArr[i + 5] = (byte) (i7 >>> 8);
                    int i8 = i + 10;
                    bArr[i8 - 4] = (byte) (i7 >>> 16);
                    bArr[i8 - 3] = (byte) (i7 >>> 24);
                    int i9 = this.Y1;
                    bArr[i8 - 2] = (byte) i9;
                    bArr[i8 - 1] = (byte) (i9 >>> 8);
                    bArr[i8] = (byte) (i9 >>> 16);
                    bArr[i8 + 1] = (byte) (i9 >>> 24);
                    int i10 = this.Z1;
                    bArr[i8 + 2] = (byte) i10;
                    bArr[i8 + 3] = (byte) (i10 >>> 8);
                    bArr[i8 + 4] = (byte) (i10 >>> 16);
                    bArr[i8 + 5] = (byte) (i10 >>> 24);
                    engineReset();
                    return 16;
                }
            }
        } else {
            throw new DigestException("insufficient space in output buffer to store the digest");
        }
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        this.c += (long) i2;
        int i3 = this.d;
        if (i3 > 0 && i3 + i2 >= 64) {
            int i4 = 64 - i3;
            System.arraycopy(bArr, i, this.q, i3, i4);
            byte[] bArr2 = this.q;
            this.d = 0;
            b(bArr2, 0);
            i += i4;
            i2 -= i4;
        }
        while (i2 >= 512) {
            b(bArr, i);
            b(bArr, i + 64);
            b(bArr, i + 128);
            b(bArr, i + 192);
            b(bArr, i + 256);
            b(bArr, i + 320);
            b(bArr, i + 384);
            b(bArr, i + 448);
            i += 512;
            i2 -= 512;
        }
        while (i2 >= 64) {
            b(bArr, i);
            i += 64;
            i2 -= 64;
        }
        if (i2 > 0) {
            System.arraycopy(bArr, i, this.q, this.d, i2);
            this.d += i2;
        }
    }
}
