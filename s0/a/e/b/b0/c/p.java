package s0.a.e.b.b0.c;

import java.security.SecureRandom;
/* loaded from: classes4.dex */
public class p {
    public static final int[] a = {-21389, -2, -1, -1, -1};
    public static final int[] b = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};
    public static final int[] c = {-457489321, -42779, -2, -1, -1, 42777, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.d(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && h3.h1(iArr3, a))) {
            h3.h(5, 21389, iArr3);
        }
    }

    public static int b(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            i |= iArr[i2];
        }
        return (((i >>> 1) | (i & 1)) - 1) >> 31;
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        h3.u2(iArr, iArr2, iArr4);
        g(iArr4, iArr3);
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.y2(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && h3.f1(10, iArr3, b))) {
            int[] iArr4 = c;
            if (h3.q(iArr4.length, iArr4, iArr3) != 0) {
                h3.z1(10, iArr3, iArr4.length);
            }
        }
    }

    public static void e(int[] iArr, int[] iArr2) {
        if (b(iArr) != 0) {
            int[] iArr3 = a;
            h3.a3(iArr3, iArr3, iArr2);
            return;
        }
        h3.a3(a, iArr, iArr2);
    }

    public static void f(SecureRandom secureRandom, int[] iArr) {
        do {
            byte[] bArr = new byte[20];
            do {
                secureRandom.nextBytes(bArr);
                h3.h2(bArr, 0, iArr, 0, 5);
            } while (h3.f2(5, iArr, a) == 0);
        } while (b(iArr) != 0);
    }

    public static void g(int[] iArr, int[] iArr2) {
        long j = ((long) 21389) & 4294967295L;
        long j2 = ((long) iArr[5]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j3;
        long j4 = ((long) iArr[6]) & 4294967295L;
        long j5 = (j * j4) + j2 + (((long) iArr[1]) & 4294967295L) + (j3 >>> 32);
        iArr2[1] = (int) j5;
        long j6 = ((long) iArr[7]) & 4294967295L;
        long j7 = (j * j6) + j4 + (((long) iArr[2]) & 4294967295L) + (j5 >>> 32);
        iArr2[2] = (int) j7;
        long j8 = ((long) iArr[8]) & 4294967295L;
        long j9 = (j * j8) + j6 + (((long) iArr[3]) & 4294967295L) + (j7 >>> 32);
        iArr2[3] = (int) j9;
        long j10 = ((long) iArr[9]) & 4294967295L;
        long j11 = (j * j10) + j8 + (((long) iArr[4]) & 4294967295L) + (j9 >>> 32);
        iArr2[4] = (int) j11;
        long j12 = (j11 >>> 32) + j10;
        long j13 = j12 & 4294967295L;
        long j14 = (j * j13) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j14;
        long j15 = j12 >>> 32;
        long j16 = (j * j15) + j13 + (((long) iArr2[1]) & 4294967295L) + (j14 >>> 32);
        iArr2[1] = (int) j16;
        long j17 = j15 + (((long) iArr2[2]) & 4294967295L) + (j16 >>> 32);
        iArr2[2] = (int) j17;
        long j18 = (j17 >>> 32) + (4294967295L & ((long) iArr2[3]));
        iArr2[3] = (int) j18;
        if (((j18 >>> 32) == 0 ? 0 : h3.A1(5, iArr2, 0, 4)) != 0 || (iArr2[4] == -1 && h3.h1(iArr2, a))) {
            h3.h(5, 21389, iArr2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
        if (r14 == 0) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void h(int i, int[] iArr) {
        if (i != 0) {
            long j = ((long) i) & 4294967295L;
            int i2 = 0;
            long j2 = ((((long) 21389) & 4294967295L) * j) + (((long) iArr[0]) & 4294967295L) + 0;
            iArr[0] = (int) j2;
            long j3 = j + (((long) iArr[1]) & 4294967295L) + (j2 >>> 32);
            iArr[1] = (int) j3;
            long j4 = (j3 >>> 32) + (4294967295L & ((long) iArr[2]));
            iArr[2] = (int) j4;
            if ((j4 >>> 32) != 0) {
                i2 = h3.A1(5, iArr, 0, 3);
            }
        }
        if (iArr[4] != -1 || !h3.h1(iArr, a)) {
            return;
        }
        h3.h(5, 21389, iArr);
    }

    public static void i(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        h3.R2(iArr, iArr3);
        g(iArr3, iArr2);
    }

    public static void j(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[10];
        h3.R2(iArr, iArr3);
        while (true) {
            g(iArr3, iArr2);
            i--;
            if (i > 0) {
                h3.R2(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.a3(iArr, iArr2, iArr3) != 0) {
            h3.d3(5, 21389, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (h3.M2(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && h3.h1(iArr2, a))) {
            h3.h(5, 21389, iArr2);
        }
    }
}
