package s0.a.e.b.b0.c;
/* loaded from: classes4.dex */
public class t0 {
    public static final int[] a = {-1, -1, -1, 0, 0, 0, 1, -1};
    public static final int[] b = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.i(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && h3.k1(iArr3, a))) {
            b(iArr3);
        }
    }

    public static void b(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = ((((long) iArr[3]) & 4294967295L) - 1) + j2;
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = ((((long) iArr[6]) & 4294967295L) - 1) + j6;
        iArr[6] = (int) j9;
        iArr[7] = (int) ((4294967295L & ((long) iArr[7])) + 1 + (j9 >> 32));
    }

    public static int c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            i |= iArr[i2];
        }
        return (((i >>> 1) | (i & 1)) - 1) >> 31;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        h3.x2(iArr, iArr2, iArr4);
        e(iArr4, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[9]) & 4294967295L;
        long j2 = ((long) iArr[10]) & 4294967295L;
        long j3 = ((long) iArr[11]) & 4294967295L;
        long j4 = ((long) iArr[12]) & 4294967295L;
        long j5 = ((long) iArr[13]) & 4294967295L;
        long j6 = ((long) iArr[14]) & 4294967295L;
        long j7 = ((long) iArr[15]) & 4294967295L;
        long j8 = (((long) iArr[8]) & 4294967295L) - 6;
        long j9 = j8 + j;
        long j10 = j + j2;
        long j11 = (j2 + j3) - j7;
        long j12 = j3 + j4;
        long j13 = j4 + j5;
        long j14 = j5 + j6;
        long j15 = j6 + j7;
        long j16 = j14 - j9;
        long j17 = (((((long) iArr[0]) & 4294967295L) - j12) - j16) + 0;
        iArr2[0] = (int) j17;
        long j18 = ((((((long) iArr[1]) & 4294967295L) + j10) - j13) - j15) + (j17 >> 32);
        iArr2[1] = (int) j18;
        long j19 = (((((long) iArr[2]) & 4294967295L) + j11) - j14) + (j18 >> 32);
        iArr2[2] = (int) j19;
        long j20 = ((((((long) iArr[3]) & 4294967295L) + (j12 << 1)) + j16) - j15) + (j19 >> 32);
        iArr2[3] = (int) j20;
        long j21 = ((((((long) iArr[4]) & 4294967295L) + (j13 << 1)) + j6) - j10) + (j20 >> 32);
        iArr2[4] = (int) j21;
        long j22 = (((((long) iArr[5]) & 4294967295L) + (j14 << 1)) - j11) + (j21 >> 32);
        iArr2[5] = (int) j22;
        long j23 = (((long) iArr[6]) & 4294967295L) + (j15 << 1) + j16 + (j22 >> 32);
        iArr2[6] = (int) j23;
        long j24 = (((((((long) iArr[7]) & 4294967295L) + (j7 << 1)) + j8) - j11) - j13) + (j23 >> 32);
        iArr2[7] = (int) j24;
        f((int) ((j24 >> 32) + 6), iArr2);
    }

    public static void f(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & 4294967295L;
            long j3 = (((long) iArr[0]) & 4294967295L) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = ((((long) iArr[3]) & 4294967295L) - j2) + j4;
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (((long) iArr[4]) & 4294967295L);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (((long) iArr[5]) & 4294967295L);
                iArr[5] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = ((((long) iArr[6]) & 4294967295L) - j2) + j8;
            iArr[6] = (int) j11;
            long j12 = (4294967295L & ((long) iArr[7])) + j2 + (j11 >> 32);
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || (iArr[7] == -1 && h3.k1(iArr, a))) {
            b(iArr);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        h3.U2(iArr, iArr3);
        e(iArr3, iArr2);
    }

    public static void h(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[16];
        h3.U2(iArr, iArr3);
        while (true) {
            e(iArr3, iArr2);
            i--;
            if (i > 0) {
                h3.U2(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.e3(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & 4294967295L);
                iArr3[1] = (int) j3;
                long j4 = (j3 >> 32) + (((long) iArr3[2]) & 4294967295L);
                iArr3[2] = (int) j4;
                j2 = j4 >> 32;
            }
            long j5 = (((long) iArr3[3]) & 4294967295L) + 1 + j2;
            iArr3[3] = (int) j5;
            long j6 = j5 >> 32;
            if (j6 != 0) {
                long j7 = j6 + (((long) iArr3[4]) & 4294967295L);
                iArr3[4] = (int) j7;
                long j8 = (j7 >> 32) + (((long) iArr3[5]) & 4294967295L);
                iArr3[5] = (int) j8;
                j6 = j8 >> 32;
            }
            long j9 = (((long) iArr3[6]) & 4294967295L) + 1 + j6;
            iArr3[6] = (int) j9;
            iArr3[7] = (int) (((4294967295L & ((long) iArr3[7])) - 1) + (j9 >> 32));
        }
    }
}
