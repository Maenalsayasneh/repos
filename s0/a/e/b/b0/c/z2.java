package s0.a.e.b.b0.c;

import s0.a.e.d.a;
/* loaded from: classes4.dex */
public class z2 {
    public static final long[] a = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    public static void b(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        jArr2[0] = j & 144115188075855871L;
        jArr2[1] = ((j >>> 57) ^ (j2 << 7)) & 144115188075855871L;
        jArr2[2] = ((j2 >>> 50) ^ (j3 << 14)) & 144115188075855871L;
        jArr2[3] = ((j3 >>> 43) ^ (j4 << 21)) & 144115188075855871L;
        jArr2[4] = (j4 >>> 36) ^ (j5 << 28);
    }

    public static void c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        b(jArr, jArr4);
        b(jArr2, jArr5);
        long[] jArr6 = new long[26];
        d(jArr3, jArr4[0], jArr5[0], jArr6, 0);
        d(jArr3, jArr4[1], jArr5[1], jArr6, 2);
        d(jArr3, jArr4[2], jArr5[2], jArr6, 4);
        d(jArr3, jArr4[3], jArr5[3], jArr6, 6);
        d(jArr3, jArr4[4], jArr5[4], jArr6, 8);
        long j = jArr4[0] ^ jArr4[1];
        long j2 = jArr5[0] ^ jArr5[1];
        long j3 = jArr4[0] ^ jArr4[2];
        long j4 = jArr5[0] ^ jArr5[2];
        long j5 = jArr4[2] ^ jArr4[4];
        long j6 = jArr5[2] ^ jArr5[4];
        long j7 = jArr4[3] ^ jArr4[4];
        long j8 = jArr5[3] ^ jArr5[4];
        d(jArr3, j3 ^ jArr4[3], j4 ^ jArr5[3], jArr6, 18);
        d(jArr3, j5 ^ jArr4[1], j6 ^ jArr5[1], jArr6, 20);
        long j9 = j ^ j7;
        long j10 = j2 ^ j8;
        d(jArr3, j9, j10, jArr6, 22);
        d(jArr3, j9 ^ jArr4[2], j10 ^ jArr5[2], jArr6, 24);
        d(jArr3, j, j2, jArr6, 10);
        d(jArr3, j3, j4, jArr6, 12);
        d(jArr3, j5, j6, jArr6, 14);
        d(jArr3, j7, j8, jArr6, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        long j11 = jArr6[0] ^ jArr6[1];
        long j12 = jArr6[2] ^ j11;
        long j13 = jArr6[10] ^ j12;
        jArr3[1] = j13;
        long j14 = jArr6[3] ^ jArr6[4];
        long j15 = j12 ^ (j14 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j15;
        long j16 = j11 ^ j14;
        long j17 = jArr6[5] ^ jArr6[6];
        long j18 = (j16 ^ j17) ^ jArr6[8];
        long j19 = jArr6[13] ^ jArr6[14];
        jArr3[3] = (j18 ^ j19) ^ ((jArr6[18] ^ jArr6[22]) ^ jArr6[24]);
        long j20 = (jArr6[7] ^ jArr6[8]) ^ jArr6[9];
        long j21 = j20 ^ jArr6[17];
        jArr3[8] = j21;
        long j22 = (j20 ^ j17) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j22;
        long j23 = j13 ^ j22;
        long j24 = (jArr6[19] ^ jArr6[20]) ^ (jArr6[25] ^ jArr6[24]);
        jArr3[4] = (j24 ^ (jArr6[18] ^ jArr6[23])) ^ j23;
        jArr3[5] = ((j15 ^ j21) ^ j24) ^ (jArr6[21] ^ jArr6[22]);
        jArr3[6] = (((((j18 ^ jArr6[0]) ^ jArr6[9]) ^ j19) ^ jArr6[21]) ^ jArr6[23]) ^ jArr6[25];
        long j25 = jArr3[0];
        long j26 = jArr3[1];
        long j27 = jArr3[2];
        long j28 = jArr3[3];
        long j29 = jArr3[4];
        long j30 = jArr3[5];
        long j31 = jArr3[6];
        long j32 = jArr3[7];
        long j33 = jArr3[8];
        long j34 = jArr3[9];
        jArr3[0] = j25 ^ (j26 << 57);
        jArr3[1] = (j26 >>> 7) ^ (j27 << 50);
        jArr3[2] = (j27 >>> 14) ^ (j28 << 43);
        jArr3[3] = (j28 >>> 21) ^ (j29 << 36);
        jArr3[4] = (j29 >>> 28) ^ (j30 << 29);
        jArr3[5] = (j30 >>> 35) ^ (j31 << 22);
        jArr3[6] = (j31 >>> 42) ^ (j32 << 15);
        jArr3[7] = (j32 >>> 49) ^ (j33 << 8);
        jArr3[8] = (j33 >>> 56) ^ (j34 << 1);
        jArr3[9] = j34 >>> 63;
    }

    public static void d(long[] jArr, long j, long j2, long[] jArr2, int i) {
        jArr[1] = j2;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j2;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j2;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j2;
        long j3 = jArr[((int) j) & 7];
        long j4 = 0;
        int i2 = 48;
        do {
            int i3 = (int) (j >>> i2);
            long j5 = (jArr[i3 & 7] ^ (jArr[(i3 >>> 3) & 7] << 3)) ^ (jArr[(i3 >>> 6) & 7] << 6);
            j3 ^= j5 << i2;
            j4 ^= j5 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr2[i] = 144115188075855871L & j3;
        jArr2[i + 1] = (((((j & 72198606942111744L) & ((j2 << 7) >> 63)) >>> 8) ^ j4) << 7) ^ (j3 >>> 57);
    }

    public static void e(long[] jArr, long[] jArr2) {
        a.b(jArr, 0, 4, jArr2, 0);
        jArr2[8] = a.a((int) jArr[4]);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[10];
        c(jArr, jArr2, jArr4);
        h(jArr4, jArr3);
    }

    public static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[10];
        c(jArr, jArr2, jArr4);
        a(jArr3, jArr4, jArr3);
    }

    public static void h(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = j5 ^ ((((j9 >>> 27) ^ (j9 >>> 22)) ^ (j9 >>> 20)) ^ (j9 >>> 15));
        long j11 = j ^ ((((j6 << 37) ^ (j6 << 42)) ^ (j6 << 44)) ^ (j6 << 49));
        long j12 = (j2 ^ ((((j7 << 37) ^ (j7 << 42)) ^ (j7 << 44)) ^ (j7 << 49))) ^ ((((j6 >>> 27) ^ (j6 >>> 22)) ^ (j6 >>> 20)) ^ (j6 >>> 15));
        long j13 = j10 >>> 27;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 5)) ^ (j13 << 7)) ^ (j13 << 12);
        jArr2[1] = j12;
        jArr2[2] = (j3 ^ ((((j8 << 37) ^ (j8 << 42)) ^ (j8 << 44)) ^ (j8 << 49))) ^ ((((j7 >>> 27) ^ (j7 >>> 22)) ^ (j7 >>> 20)) ^ (j7 >>> 15));
        jArr2[3] = (j4 ^ ((((j9 << 37) ^ (j9 << 42)) ^ (j9 << 44)) ^ (j9 << 49))) ^ ((((j8 >>> 27) ^ (j8 >>> 22)) ^ (j8 >>> 20)) ^ (j8 >>> 15));
        jArr2[4] = 134217727 & j10;
    }

    public static void i(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[9];
        e(jArr, jArr3);
        h(jArr3, jArr2);
    }

    public static void j(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[9];
        e(jArr, jArr3);
        while (true) {
            h(jArr3, jArr2);
            i--;
            if (i > 0) {
                e(jArr2, jArr3);
            } else {
                return;
            }
        }
    }
}
