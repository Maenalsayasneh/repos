package s0.a.e.b.b0.c;
/* loaded from: classes4.dex */
public class z {
    public static final int[] a = {-1, -1, -2, -1, -1, -1};
    public static final int[] b = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
    public static final int[] c = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.e(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && h3.i1(iArr3, a))) {
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
            j2 = j3 >> 32;
        }
        long j4 = (4294967295L & ((long) iArr[2])) + 1 + j2;
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            h3.z1(6, iArr, 3);
        }
    }

    public static int c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i |= iArr[i2];
        }
        return (((i >>> 1) | (i & 1)) - 1) >> 31;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        h3.v2(iArr, iArr2, iArr4);
        e(iArr4, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[6]) & 4294967295L;
        long j2 = ((long) iArr[7]) & 4294967295L;
        long j3 = (((long) iArr[10]) & 4294967295L) + j;
        long j4 = (((long) iArr[11]) & 4294967295L) + j2;
        long j5 = (((long) iArr[0]) & 4294967295L) + j3 + 0;
        int i = (int) j5;
        long j6 = (((long) iArr[1]) & 4294967295L) + j4 + (j5 >> 32);
        iArr2[1] = (int) j6;
        long j7 = j3 + (((long) iArr[8]) & 4294967295L);
        long j8 = j4 + (((long) iArr[9]) & 4294967295L);
        long j9 = (((long) iArr[2]) & 4294967295L) + j7 + (j6 >> 32);
        long j10 = j9 & 4294967295L;
        long j11 = (((long) iArr[3]) & 4294967295L) + j8 + (j9 >> 32);
        iArr2[3] = (int) j11;
        long j12 = j8 - j2;
        long j13 = (((long) iArr[4]) & 4294967295L) + (j7 - j) + (j11 >> 32);
        iArr2[4] = (int) j13;
        long j14 = (((long) iArr[5]) & 4294967295L) + j12 + (j13 >> 32);
        iArr2[5] = (int) j14;
        long j15 = j14 >> 32;
        long j16 = j10 + j15;
        long j17 = j15 + (((long) i) & 4294967295L);
        iArr2[0] = (int) j17;
        long j18 = j17 >> 32;
        if (j18 != 0) {
            long j19 = j18 + (4294967295L & ((long) iArr2[1]));
            iArr2[1] = (int) j19;
            j16 += j19 >> 32;
        }
        iArr2[2] = (int) j16;
        if (((j16 >> 32) != 0 && h3.z1(6, iArr2, 3) != 0) || (iArr2[5] == -1 && h3.i1(iArr2, a))) {
            b(iArr2);
        }
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
                j4 = j5 >> 32;
            }
            long j6 = (4294967295L & ((long) iArr[2])) + j2 + j4;
            iArr[2] = (int) j6;
            j = j6 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && h3.z1(6, iArr, 3) != 0) || (iArr[5] == -1 && h3.i1(iArr, a))) {
            b(iArr);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        h3.S2(iArr, iArr3);
        e(iArr3, iArr2);
    }

    public static void h(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[12];
        h3.S2(iArr, iArr3);
        while (true) {
            e(iArr3, iArr2);
            i--;
            if (i > 0) {
                h3.S2(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.b3(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & 4294967295L);
                iArr3[1] = (int) j3;
                j2 = j3 >> 32;
            }
            long j4 = ((4294967295L & ((long) iArr3[2])) - 1) + j2;
            iArr3[2] = (int) j4;
            if ((j4 >> 32) != 0) {
                h3.v0(6, iArr3, 3);
            }
        }
    }
}
