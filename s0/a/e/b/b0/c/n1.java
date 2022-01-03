package s0.a.e.b.b0.c;

import s0.a.e.d.a;
/* loaded from: classes4.dex */
public class n1 {
    public static final long[] a = {2791191049453778211L, 2791191049453778402L, 6};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = ((jArr[2] << 40) ^ (j2 >>> 24)) & 17592186044415L;
        long j4 = ((j2 << 20) ^ (j >>> 44)) & 17592186044415L;
        long j5 = j & 17592186044415L;
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = ((j7 >>> 24) ^ (jArr2[2] << 40)) & 17592186044415L;
        long j9 = ((j7 << 20) ^ (j6 >>> 44)) & 17592186044415L;
        long j10 = j6 & 17592186044415L;
        long[] jArr4 = new long[10];
        c(jArr3, j5, j10, jArr4, 0);
        c(jArr3, j3, j8, jArr4, 2);
        long j11 = (j5 ^ j4) ^ j3;
        long j12 = (j10 ^ j9) ^ j8;
        c(jArr3, j11, j12, jArr4, 4);
        long j13 = (j4 << 1) ^ (j3 << 2);
        long j14 = (j9 << 1) ^ (j8 << 2);
        c(jArr3, j5 ^ j13, j10 ^ j14, jArr4, 6);
        c(jArr3, j11 ^ j13, j12 ^ j14, jArr4, 8);
        long j15 = jArr4[6] ^ jArr4[8];
        long j16 = jArr4[7] ^ jArr4[9];
        long j17 = (j15 << 1) ^ jArr4[6];
        long j18 = (j15 ^ (j16 << 1)) ^ jArr4[7];
        long j19 = jArr4[0];
        long j20 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j21 = jArr4[1] ^ jArr4[5];
        long j22 = ((j19 ^ j17) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j23 = (((j20 ^ j18) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j22 >>> 44);
        long j24 = (j21 ^ j16) ^ (j23 >>> 44);
        long j25 = j23 & 17592186044415L;
        long j26 = ((j22 & 17592186044415L) >>> 1) ^ ((j25 & 1) << 43);
        long j27 = j26 ^ (j26 << 1);
        long j28 = j27 ^ (j27 << 2);
        long j29 = j28 ^ (j28 << 4);
        long j30 = j29 ^ (j29 << 8);
        long j31 = j30 ^ (j30 << 16);
        long j32 = (j31 ^ (j31 << 32)) & 17592186044415L;
        long j33 = ((j25 >>> 1) ^ ((j24 & 1) << 43)) ^ (j32 >>> 43);
        long j34 = j33 ^ (j33 << 1);
        long j35 = j34 ^ (j34 << 2);
        long j36 = j35 ^ (j35 << 4);
        long j37 = j36 ^ (j36 << 8);
        long j38 = j37 ^ (j37 << 16);
        long j39 = (j38 ^ (j38 << 32)) & 17592186044415L;
        long j40 = (j24 >>> 1) ^ (j39 >>> 43);
        long j41 = j40 ^ (j40 << 1);
        long j42 = j41 ^ (j41 << 2);
        long j43 = j42 ^ (j42 << 4);
        long j44 = j43 ^ (j43 << 8);
        long j45 = j44 ^ (j44 << 16);
        long j46 = j45 ^ (j45 << 32);
        jArr3[0] = j19;
        jArr3[1] = (j20 ^ j32) ^ jArr4[2];
        jArr3[2] = ((j21 ^ j39) ^ j32) ^ jArr4[3];
        jArr3[3] = j39 ^ j46;
        jArr3[4] = jArr4[2] ^ j46;
        jArr3[5] = jArr4[3];
        long j47 = jArr3[0];
        long j48 = jArr3[1];
        long j49 = jArr3[2];
        long j50 = jArr3[3];
        long j51 = jArr3[4];
        long j52 = jArr3[5];
        jArr3[0] = j47 ^ (j48 << 44);
        jArr3[1] = (j48 >>> 20) ^ (j49 << 24);
        jArr3[2] = ((j49 >>> 40) ^ (j50 << 4)) ^ (j51 << 48);
        jArr3[3] = ((j50 >>> 60) ^ (j52 << 28)) ^ (j51 >>> 16);
        jArr3[4] = j52 >>> 36;
        jArr3[5] = 0;
    }

    public static void c(long[] jArr, long j, long j2, long[] jArr2, int i) {
        jArr[1] = j2;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j2;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j2;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j2;
        int i2 = (int) j;
        long j3 = (((jArr[i2 & 7] ^ (jArr[(i2 >>> 3) & 7] << 3)) ^ (jArr[(i2 >>> 6) & 7] << 6)) ^ (jArr[(i2 >>> 9) & 7] << 9)) ^ (jArr[(i2 >>> 12) & 7] << 12);
        long j4 = 0;
        int i3 = 30;
        do {
            int i4 = (int) (j >>> i3);
            long j5 = (((jArr[i4 & 7] ^ (jArr[(i4 >>> 3) & 7] << 3)) ^ (jArr[(i4 >>> 6) & 7] << 6)) ^ (jArr[(i4 >>> 9) & 7] << 9)) ^ (jArr[(i4 >>> 12) & 7] << 12);
            j3 ^= j5 << i3;
            j4 ^= j5 >>> (-i3);
            i3 -= 15;
        } while (i3 > 0);
        jArr2[i] = 17592186044415L & j3;
        jArr2[i + 1] = (j3 >>> 44) ^ (j4 << 20);
    }

    public static void d(long[] jArr, long[] jArr2) {
        a.b(jArr, 0, 2, jArr2, 0);
        int i = ((int) jArr[2]) & 255;
        int i2 = (i | (i << 4)) & 3855;
        int i3 = (i2 | (i2 << 2)) & 13107;
        jArr2[4] = ((long) ((i3 | (i3 << 1)) & 21845)) & 4294967295L;
    }

    public static void e(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        b(jArr, jArr2, jArr4);
        g(jArr4, jArr3);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        b(jArr, jArr2, jArr4);
        a(jArr3, jArr4, jArr3);
    }

    public static void g(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = j4 ^ (j5 >>> 59);
        long j7 = j ^ ((j6 << 61) ^ (j6 << 63));
        long j8 = (j2 ^ ((j5 << 61) ^ (j5 << 63))) ^ ((((j6 >>> 3) ^ (j6 >>> 1)) ^ j6) ^ (j6 << 5));
        long j9 = (j3 ^ ((((j5 >>> 3) ^ (j5 >>> 1)) ^ j5) ^ (j5 << 5))) ^ (j6 >>> 59);
        long j10 = j9 >>> 3;
        jArr2[0] = (((j7 ^ j10) ^ (j10 << 2)) ^ (j10 << 3)) ^ (j10 << 8);
        jArr2[1] = (j10 >>> 56) ^ j8;
        jArr2[2] = 7 & j9;
    }

    public static void h(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[5];
        d(jArr, jArr3);
        g(jArr3, jArr2);
    }

    public static void i(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[5];
        d(jArr, jArr3);
        while (true) {
            g(jArr3, jArr2);
            i--;
            if (i > 0) {
                d(jArr2, jArr3);
            } else {
                return;
            }
        }
    }
}
