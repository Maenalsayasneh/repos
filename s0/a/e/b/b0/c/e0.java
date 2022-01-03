package s0.a.e.b.b0.c;
/* loaded from: classes4.dex */
public class e0 {
    public static final int[] a = {-6803, -2, -1, -1, -1, -1, -1};
    public static final int[] b = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};
    public static final int[] c = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    public static int a(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 7; i2++) {
            i |= iArr[i2];
        }
        return (((i >>> 1) | (i & 1)) - 1) >> 31;
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[14];
        h3.w2(iArr, iArr2, iArr4);
        c(iArr4, iArr3);
    }

    public static void c(int[] iArr, int[] iArr2) {
        long j = ((long) 6803) & 4294967295L;
        long j2 = ((long) iArr[7]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j3;
        long j4 = ((long) iArr[8]) & 4294967295L;
        long j5 = (j * j4) + j2 + (((long) iArr[1]) & 4294967295L) + (j3 >>> 32);
        iArr2[1] = (int) j5;
        long j6 = ((long) iArr[9]) & 4294967295L;
        long j7 = (j * j6) + j4 + (((long) iArr[2]) & 4294967295L) + (j5 >>> 32);
        iArr2[2] = (int) j7;
        long j8 = ((long) iArr[10]) & 4294967295L;
        long j9 = (j * j8) + j6 + (((long) iArr[3]) & 4294967295L) + (j7 >>> 32);
        iArr2[3] = (int) j9;
        long j10 = ((long) iArr[11]) & 4294967295L;
        long j11 = (j * j10) + j8 + (((long) iArr[4]) & 4294967295L) + (j9 >>> 32);
        iArr2[4] = (int) j11;
        long j12 = ((long) iArr[12]) & 4294967295L;
        long j13 = (j * j12) + j10 + (((long) iArr[5]) & 4294967295L) + (j11 >>> 32);
        iArr2[5] = (int) j13;
        long j14 = ((long) iArr[13]) & 4294967295L;
        long j15 = (j * j14) + j12 + (((long) iArr[6]) & 4294967295L) + (j13 >>> 32);
        iArr2[6] = (int) j15;
        long j16 = (j15 >>> 32) + j14;
        long j17 = j16 & 4294967295L;
        long j18 = (j * j17) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j18;
        long j19 = j16 >>> 32;
        long j20 = (j * j19) + j17 + (((long) iArr2[1]) & 4294967295L) + (j18 >>> 32);
        iArr2[1] = (int) j20;
        long j21 = j19 + (((long) iArr2[2]) & 4294967295L) + (j20 >>> 32);
        iArr2[2] = (int) j21;
        long j22 = (j21 >>> 32) + (4294967295L & ((long) iArr2[3]));
        iArr2[3] = (int) j22;
        if (((j22 >>> 32) == 0 ? 0 : h3.A1(7, iArr2, 0, 4)) != 0 || (iArr2[6] == -1 && h3.j1(iArr2, a))) {
            h3.h(7, 6803, iArr2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
        if (r14 == 0) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void d(int i, int[] iArr) {
        if (i != 0) {
            long j = ((long) i) & 4294967295L;
            int i2 = 0;
            long j2 = ((((long) 6803) & 4294967295L) * j) + (((long) iArr[0]) & 4294967295L) + 0;
            iArr[0] = (int) j2;
            long j3 = j + (((long) iArr[1]) & 4294967295L) + (j2 >>> 32);
            iArr[1] = (int) j3;
            long j4 = (j3 >>> 32) + (4294967295L & ((long) iArr[2]));
            iArr[2] = (int) j4;
            if ((j4 >>> 32) != 0) {
                i2 = h3.A1(7, iArr, 0, 3);
            }
        }
        if (iArr[6] != -1 || !h3.j1(iArr, a)) {
            return;
        }
        h3.h(7, 6803, iArr);
    }

    public static void e(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[14];
        h3.T2(iArr, iArr3);
        c(iArr3, iArr2);
    }

    public static void f(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[14];
        h3.T2(iArr, iArr3);
        while (true) {
            c(iArr3, iArr2);
            i--;
            if (i > 0) {
                h3.T2(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.c3(iArr, iArr2, iArr3) != 0) {
            h3.d3(7, 6803, iArr3);
        }
    }
}
