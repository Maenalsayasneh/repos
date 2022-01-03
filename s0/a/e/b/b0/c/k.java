package s0.a.e.b.b0.c;
/* loaded from: classes4.dex */
public class k {
    public static final int[] a = {Integer.MAX_VALUE, -1, -1, -1, -1};
    public static final int[] b = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};
    public static final int[] c = {-1, -1073741826, -1, -1, -1, 1, 1};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.d(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && h3.h1(iArr3, a))) {
            h3.w(5, -2147483647, iArr3);
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
        d(iArr4, iArr3);
    }

    public static void d(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[5]) & 4294967295L;
        long j2 = ((long) iArr[6]) & 4294967295L;
        long j3 = ((long) iArr[7]) & 4294967295L;
        long j4 = ((long) iArr[8]) & 4294967295L;
        long j5 = ((long) iArr[9]) & 4294967295L;
        long j6 = (((long) iArr[0]) & 4294967295L) + j + (j << 31) + 0;
        iArr2[0] = (int) j6;
        long j7 = (((long) iArr[1]) & 4294967295L) + j2 + (j2 << 31) + (j6 >>> 32);
        iArr2[1] = (int) j7;
        long j8 = (((long) iArr[2]) & 4294967295L) + j3 + (j3 << 31) + (j7 >>> 32);
        iArr2[2] = (int) j8;
        long j9 = (((long) iArr[3]) & 4294967295L) + j4 + (j4 << 31) + (j8 >>> 32);
        iArr2[3] = (int) j9;
        long j10 = (4294967295L & ((long) iArr[4])) + j5 + (j5 << 31) + (j9 >>> 32);
        iArr2[4] = (int) j10;
        e((int) (j10 >>> 32), iArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
        if (r12 == 0) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void e(int i, int[] iArr) {
        if (i != 0) {
            long j = ((long) i) & 4294967295L;
            int i2 = 0;
            long j2 = (j * (((long) -2147483647) & 4294967295L)) + (((long) iArr[0]) & 4294967295L) + 0;
            iArr[0] = (int) j2;
            long j3 = (j2 >>> 32) + (4294967295L & ((long) iArr[1]));
            iArr[1] = (int) j3;
            if ((j3 >>> 32) != 0) {
                i2 = h3.A1(5, iArr, 0, 2);
            }
        }
        if (iArr[4] != -1 || !h3.h1(iArr, a)) {
            return;
        }
        h3.w(5, -2147483647, iArr);
    }

    public static void f(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        h3.R2(iArr, iArr3);
        d(iArr3, iArr2);
    }

    public static void g(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[10];
        h3.R2(iArr, iArr3);
        while (true) {
            d(iArr3, iArr2);
            i--;
            if (i > 0) {
                h3.R2(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void h(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h3.a3(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) - (4294967295L & ((long) -2147483647));
            iArr3[0] = (int) j;
            if ((j >> 32) != 0) {
                h3.v0(5, iArr3, 1);
            }
        }
    }
}
