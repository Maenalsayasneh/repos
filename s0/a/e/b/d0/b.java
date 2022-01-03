package s0.a.e.b.d0;

import s0.a.e.b.b0.c.h3;
/* loaded from: classes4.dex */
public abstract class b {
    public static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < 16; i++) {
            iArr3[i] = iArr[i] + iArr2[i];
        }
    }

    public static void b(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = iArr[10];
        int i12 = iArr[11];
        int i13 = iArr[12];
        int i14 = iArr[13];
        int i15 = i2 + (i >>> 28);
        int i16 = i6 + (i5 >>> 28);
        int i17 = i10 + (i9 >>> 28);
        int i18 = i14 + (i13 >>> 28);
        int i19 = i3 + (i15 >>> 28);
        int i20 = i7 + (i16 >>> 28);
        int i21 = i11 + (i17 >>> 28);
        int i22 = iArr[14] + (i18 >>> 28);
        int i23 = i4 + (i19 >>> 28);
        int i24 = i8 + (i20 >>> 28);
        int i25 = i12 + (i21 >>> 28);
        int i26 = iArr[15] + (i22 >>> 28);
        int i27 = i26 >>> 28;
        int i28 = (i & 268435455) + i27;
        int i29 = (i5 & 268435455) + (i23 >>> 28);
        int i30 = (i9 & 268435455) + i27 + (i24 >>> 28);
        int i31 = (i13 & 268435455) + (i25 >>> 28);
        iArr[0] = i28 & 268435455;
        iArr[1] = (i15 & 268435455) + (i28 >>> 28);
        iArr[2] = i19 & 268435455;
        iArr[3] = i23 & 268435455;
        iArr[4] = i29 & 268435455;
        iArr[5] = (i16 & 268435455) + (i29 >>> 28);
        iArr[6] = i20 & 268435455;
        iArr[7] = i24 & 268435455;
        iArr[8] = i30 & 268435455;
        iArr[9] = (i17 & 268435455) + (i30 >>> 28);
        iArr[10] = i21 & 268435455;
        iArr[11] = i25 & 268435455;
        iArr[12] = i31 & 268435455;
        iArr[13] = (i18 & 268435455) + (i31 >>> 28);
        iArr[14] = i22 & 268435455;
        iArr[15] = i26 & 268435455;
    }

    public static void c(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = i3 + i4;
            int i6 = iArr2[i5];
            iArr2[i5] = i6 ^ ((iArr[i2 + i4] ^ i6) & i);
        }
    }

    public static void d(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 0; i3 < 16; i3++) {
            iArr2[i2 + i3] = iArr[i + i3];
        }
    }

    public static void e(int i, int[] iArr, int[] iArr2) {
        int i2 = 0 - i;
        for (int i3 = 0; i3 < 16; i3++) {
            int i4 = iArr[i3];
            int i5 = iArr2[i3];
            int i6 = (i4 ^ i5) & i2;
            iArr[i3] = i4 ^ i6;
            iArr2[i3] = i5 ^ i6;
        }
    }

    public static void f(byte[] bArr, int i, int[] iArr) {
        h(bArr, i, iArr, 0);
        h(bArr, i + 7, iArr, 2);
        h(bArr, i + 14, iArr, 4);
        h(bArr, i + 21, iArr, 6);
        h(bArr, i + 28, iArr, 8);
        h(bArr, i + 35, iArr, 10);
        h(bArr, i + 42, iArr, 12);
        h(bArr, i + 49, iArr, 14);
    }

    public static void g(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i + 0];
        int i4 = iArr[i + 1];
        int i5 = iArr[i + 2];
        int i6 = iArr[i + 3];
        int i7 = iArr[i + 4];
        int i8 = iArr[i + 5];
        int i9 = iArr[i + 6];
        iArr2[i2 + 0] = i3 & 268435455;
        iArr2[i2 + 1] = ((i3 >>> 28) | (i4 << 4)) & 268435455;
        iArr2[i2 + 2] = ((i4 >>> 24) | (i5 << 8)) & 268435455;
        iArr2[i2 + 3] = ((i5 >>> 20) | (i6 << 12)) & 268435455;
        iArr2[i2 + 4] = ((i6 >>> 16) | (i7 << 16)) & 268435455;
        iArr2[i2 + 5] = ((i7 >>> 12) | (i8 << 20)) & 268435455;
        iArr2[i2 + 6] = ((i8 >>> 8) | (i9 << 24)) & 268435455;
        iArr2[i2 + 7] = i9 >>> 4;
    }

    public static void h(byte[] bArr, int i, int[] iArr, int i2) {
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | (bArr[i4 + 1] << 24);
        int i6 = i + 4;
        int i7 = i6 + 1;
        int i8 = (bArr[i7 + 1] & 255) << 16;
        iArr[i2] = 268435455 & i5;
        iArr[i2 + 1] = ((i8 | ((bArr[i6] & 255) | ((bArr[i7] & 255) << 8))) << 4) | (i5 >>> 28);
    }

    public static void i(int[] iArr, byte[] bArr, int i) {
        k(iArr, 0, bArr, i);
        k(iArr, 2, bArr, i + 7);
        k(iArr, 4, bArr, i + 14);
        k(iArr, 6, bArr, i + 21);
        k(iArr, 8, bArr, i + 28);
        k(iArr, 10, bArr, i + 35);
        k(iArr, 12, bArr, i + 42);
        k(iArr, 14, bArr, i + 49);
    }

    public static void j(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i + 0];
        int i4 = iArr[i + 1];
        int i5 = iArr[i + 2];
        int i6 = iArr[i + 3];
        int i7 = iArr[i + 4];
        int i8 = iArr[i + 5];
        int i9 = iArr[i + 6];
        int i10 = iArr[i + 7];
        iArr2[i2 + 0] = i3 | (i4 << 28);
        iArr2[i2 + 1] = (i4 >>> 4) | (i5 << 24);
        iArr2[i2 + 2] = (i5 >>> 8) | (i6 << 20);
        iArr2[i2 + 3] = (i6 >>> 12) | (i7 << 16);
        iArr2[i2 + 4] = (i7 >>> 16) | (i8 << 12);
        iArr2[i2 + 5] = (i8 >>> 20) | (i9 << 8);
        iArr2[i2 + 6] = (i10 << 4) | (i9 >>> 24);
    }

    public static void k(int[] iArr, int i, byte[] bArr, int i2) {
        int i3 = iArr[i];
        int i4 = iArr[i + 1];
        int i5 = (i4 << 28) | i3;
        bArr[i2] = (byte) i5;
        int i6 = i2 + 1;
        bArr[i6] = (byte) (i5 >>> 8);
        int i7 = i6 + 1;
        bArr[i7] = (byte) (i5 >>> 16);
        bArr[i7 + 1] = (byte) (i5 >>> 24);
        int i8 = i4 >>> 4;
        int i9 = i2 + 4;
        bArr[i9] = (byte) i8;
        int i10 = i9 + 1;
        bArr[i10] = (byte) (i8 >>> 8);
        bArr[i10 + 1] = (byte) (i8 >>> 16);
    }

    public static void l(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[14];
        d(iArr, 0, iArr3, 0);
        r(iArr3, 1);
        r(iArr3, -1);
        j(iArr3, 0, iArr4, 0);
        j(iArr3, 8, iArr4, 7);
        h3.r2(a, iArr4, iArr4);
        g(iArr4, 0, iArr2, 0);
        g(iArr4, 7, iArr2, 8);
    }

    public static int m(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            i |= iArr[i2];
        }
        return (((i >>> 1) | (i & 1)) - 1) >> 31;
    }

    public static void n(int[] iArr, int i, int[] iArr2) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = iArr[8];
        int i11 = iArr[9];
        int i12 = iArr[10];
        int i13 = iArr[11];
        int i14 = iArr[12];
        int i15 = iArr[13];
        int i16 = iArr[14];
        int i17 = iArr[15];
        long j = (long) i3;
        long j2 = (long) i;
        long j3 = j * j2;
        int i18 = ((int) j3) & 268435455;
        long j4 = ((long) i7) * j2;
        int i19 = ((int) j4) & 268435455;
        long j5 = ((long) i11) * j2;
        long j6 = ((long) i15) * j2;
        long j7 = (((long) i4) * j2) + (j3 >>> 28);
        iArr2[2] = ((int) j7) & 268435455;
        long j8 = (((long) i8) * j2) + (j4 >>> 28);
        iArr2[6] = ((int) j8) & 268435455;
        long j9 = (((long) i12) * j2) + (j5 >>> 28);
        iArr2[10] = ((int) j9) & 268435455;
        long j10 = (((long) i16) * j2) + (j6 >>> 28);
        iArr2[14] = ((int) j10) & 268435455;
        long j11 = (((long) i5) * j2) + (j7 >>> 28);
        iArr2[3] = ((int) j11) & 268435455;
        long j12 = j11 >>> 28;
        long j13 = (((long) i9) * j2) + (j8 >>> 28);
        iArr2[7] = ((int) j13) & 268435455;
        long j14 = (((long) i13) * j2) + (j9 >>> 28);
        iArr2[11] = ((int) j14) & 268435455;
        long j15 = j14 >>> 28;
        long j16 = (((long) i17) * j2) + (j10 >>> 28);
        iArr2[15] = ((int) j16) & 268435455;
        long j17 = j16 >>> 28;
        long j18 = (((long) i6) * j2) + j12;
        iArr2[4] = ((int) j18) & 268435455;
        long j19 = j18 >>> 28;
        long j20 = (((long) i10) * j2) + (j13 >>> 28) + j17;
        iArr2[8] = ((int) j20) & 268435455;
        long j21 = j20 >>> 28;
        long j22 = (((long) i14) * j2) + j15;
        iArr2[12] = ((int) j22) & 268435455;
        long j23 = j22 >>> 28;
        long j24 = (((long) i2) * j2) + j17;
        iArr2[0] = ((int) j24) & 268435455;
        iArr2[1] = i18 + ((int) (j24 >>> 28));
        iArr2[5] = i19 + ((int) j19);
        iArr2[9] = (((int) j5) & 268435455) + ((int) j21);
        iArr2[13] = (((int) j6) & 268435455) + ((int) j23);
    }

    public static void o(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = iArr[10];
        int i12 = iArr[11];
        int i13 = iArr[12];
        int i14 = iArr[13];
        int i15 = iArr[14];
        int i16 = iArr[15];
        int i17 = iArr2[0];
        int i18 = iArr2[1];
        int i19 = iArr2[2];
        int i20 = iArr2[3];
        int i21 = iArr2[4];
        int i22 = iArr2[5];
        int i23 = iArr2[6];
        int i24 = iArr2[7];
        int i25 = iArr2[8];
        int i26 = iArr2[9];
        int i27 = iArr2[10];
        int i28 = iArr2[11];
        int i29 = iArr2[12];
        int i30 = iArr2[13];
        int i31 = iArr2[14];
        int i32 = iArr2[15];
        int i33 = i + i9;
        int i34 = i3 + i11;
        int i35 = i4 + i12;
        int i36 = i5 + i13;
        int i37 = i6 + i14;
        int i38 = i7 + i15;
        int i39 = i17 + i25;
        int i40 = i18 + i26;
        int i41 = i19 + i27;
        int i42 = i20 + i28;
        int i43 = i21 + i29;
        int i44 = i22 + i30;
        int i45 = i23 + i31;
        int i46 = i24 + i32;
        long j = (long) i;
        long j2 = (long) i17;
        long j3 = j * j2;
        long j4 = (long) i8;
        long j5 = (long) i18;
        long j6 = j4 * j5;
        long j7 = (long) i7;
        long j8 = (long) i19;
        long j9 = (long) i6;
        long j10 = (long) i20;
        long j11 = j9 * j10;
        long j12 = (long) i5;
        long j13 = (long) i21;
        long j14 = j12 * j13;
        long j15 = (long) i4;
        long j16 = (long) i22;
        long j17 = j15 * j16;
        long j18 = (long) i3;
        long j19 = (long) i23;
        long j20 = j18 * j19;
        long j21 = (long) i2;
        long j22 = (long) i24;
        long j23 = j21 * j22;
        long j24 = (long) i9;
        long j25 = (long) i25;
        long j26 = j24 * j25;
        long j27 = (long) i16;
        long j28 = (long) i26;
        long j29 = j27 * j28;
        long j30 = (long) i15;
        long j31 = (long) i27;
        long j32 = (long) i14;
        long j33 = (long) i28;
        long j34 = (long) i13;
        long j35 = (long) i29;
        long j36 = (long) i12;
        long j37 = (long) i30;
        long j38 = j36 * j37;
        long j39 = j38 + (j34 * j35) + (j32 * j33) + (j30 * j31) + j29;
        long j40 = (long) i11;
        long j41 = (long) i31;
        long j42 = (long) i10;
        long j43 = (long) i32;
        long j44 = j42 * j43;
        long j45 = (long) i33;
        long j46 = (long) i39;
        long j47 = j45 * j46;
        long j48 = (long) (i8 + i16);
        long j49 = (long) i40;
        long j50 = j48 * j49;
        long j51 = (long) i38;
        long j52 = (long) i41;
        long j53 = (long) i37;
        long j54 = (long) i42;
        long j55 = j53 * j54;
        long j56 = (long) i36;
        long j57 = (long) i43;
        long j58 = j56 * j57;
        long j59 = (long) i35;
        long j60 = (long) i44;
        long j61 = j59 * j60;
        long j62 = (long) i34;
        long j63 = (long) i45;
        long j64 = (j62 * j63) + j61 + j58 + j55 + (j51 * j52) + j50;
        long j65 = (long) (i2 + i10);
        long j66 = (long) i46;
        long j67 = (j65 * j66) + j64;
        long j68 = ((j3 + j26) + j67) - (j23 + (j20 + (j17 + (j14 + (j11 + ((j7 * j8) + j6))))));
        int i47 = ((int) j68) & 268435455;
        long j69 = j68 >>> 28;
        long j70 = (((j44 + ((j40 * j41) + j39)) + j47) - j3) + j67;
        int i48 = ((int) j70) & 268435455;
        long j71 = (j * j5) + (j21 * j2);
        long j72 = j36 * j41;
        long j73 = (j40 * j43) + j72 + (j34 * j37) + (j32 * j35) + (j30 * j33) + (j27 * j31);
        long j74 = (j45 * j49) + (j65 * j46);
        long j75 = (j62 * j66) + (j59 * j63) + (j56 * j60) + (j53 * j57) + (j51 * j54) + (j48 * j52);
        long j76 = (((j71 + ((j24 * j28) + (j42 * j25))) + j75) - ((j18 * j22) + ((j15 * j19) + ((j12 * j16) + ((j9 * j13) + ((j7 * j10) + (j4 * j8))))))) + j69;
        int i49 = ((int) j76) & 268435455;
        long j77 = ((j73 + j74) - j71) + j75 + (j70 >>> 28);
        int i50 = ((int) j77) & 268435455;
        long j78 = (j * j8) + (j21 * j5) + (j18 * j2);
        long j79 = (j15 * j22) + (j12 * j19) + (j9 * j16) + (j7 * j13) + (j4 * j10);
        long j80 = (j24 * j31) + (j42 * j28) + (j40 * j25);
        long j81 = (j36 * j43) + (j34 * j41) + (j32 * j37) + (j30 * j35) + (j27 * j33);
        long j82 = (j45 * j52) + (j65 * j49) + (j62 * j46);
        long j83 = (j59 * j66) + (j56 * j63) + (j53 * j60) + (j51 * j57) + (j48 * j54);
        long j84 = (((j78 + j80) + j83) - j79) + (j76 >>> 28);
        int i51 = ((int) j84) & 268435455;
        long j85 = ((j81 + j82) - j78) + j83 + (j77 >>> 28);
        int i52 = ((int) j85) & 268435455;
        long j86 = (j * j10) + (j21 * j8) + (j18 * j5) + (j15 * j2);
        long j87 = (j12 * j22) + (j9 * j19) + (j7 * j16) + (j4 * j13);
        long j88 = (j24 * j33) + (j42 * j31) + (j40 * j28) + (j36 * j25);
        long j89 = (j34 * j43) + (j32 * j41) + (j30 * j37) + (j27 * j35);
        long j90 = (j45 * j54) + (j65 * j52) + (j62 * j49) + (j59 * j46);
        long j91 = (j56 * j66) + (j53 * j63) + (j51 * j60) + (j48 * j57);
        long j92 = (((j86 + j88) + j91) - j87) + (j84 >>> 28);
        int i53 = ((int) j92) & 268435455;
        long j93 = ((j89 + j90) - j86) + j91 + (j85 >>> 28);
        int i54 = ((int) j93) & 268435455;
        long j94 = (j * j13) + (j21 * j10) + (j18 * j8) + (j15 * j5) + (j12 * j2);
        long j95 = (j9 * j22) + (j7 * j19) + (j4 * j16);
        long j96 = (j24 * j35) + (j42 * j33) + (j40 * j31) + (j36 * j28) + (j34 * j25);
        long j97 = (j32 * j43) + (j30 * j41) + (j27 * j37);
        long j98 = (j45 * j57) + (j65 * j54) + (j62 * j52) + (j59 * j49) + (j56 * j46);
        long j99 = (j53 * j66) + (j51 * j63) + (j48 * j60);
        long j100 = (((j94 + j96) + j99) - j95) + (j92 >>> 28);
        int i55 = ((int) j100) & 268435455;
        long j101 = ((j97 + j98) - j94) + j99 + (j93 >>> 28);
        int i56 = ((int) j101) & 268435455;
        long j102 = (j * j16) + (j21 * j13) + (j18 * j10) + (j15 * j8) + (j12 * j5) + (j9 * j2);
        long j103 = (j24 * j37) + (j42 * j35) + (j40 * j33) + (j36 * j31) + (j34 * j28) + (j32 * j25);
        long j104 = (j30 * j43) + (j27 * j41);
        long j105 = (j45 * j60) + (j65 * j57) + (j62 * j54) + (j59 * j52) + (j56 * j49) + (j53 * j46);
        long j106 = (j51 * j66) + (j48 * j63);
        long j107 = (((j102 + j103) + j106) - ((j7 * j22) + (j4 * j19))) + (j100 >>> 28);
        int i57 = ((int) j107) & 268435455;
        long j108 = ((j104 + j105) - j102) + j106 + (j101 >>> 28);
        int i58 = ((int) j108) & 268435455;
        long j109 = (j * j19) + (j21 * j16) + (j18 * j13) + (j15 * j10) + (j12 * j8) + (j9 * j5) + (j7 * j2);
        long j110 = (j24 * j41) + (j42 * j37) + (j40 * j35) + (j36 * j33) + (j34 * j31) + (j32 * j28) + (j30 * j25);
        long j111 = j27 * j43;
        long j112 = (j45 * j63) + (j65 * j60) + (j62 * j57) + (j59 * j54) + (j56 * j52) + (j53 * j49) + (j51 * j46);
        long j113 = j48 * j66;
        long j114 = (((j109 + j110) + j113) - (j4 * j22)) + (j107 >>> 28);
        long j115 = ((j111 + j112) - j109) + j113 + (j108 >>> 28);
        long j116 = j15 * j13;
        long j117 = (j * j22) + (j21 * j19) + (j18 * j16) + j116 + (j12 * j10) + (j9 * j8) + (j5 * j7) + (j2 * j4);
        long j118 = j27 * j25;
        long j119 = (j31 * j32) + (j28 * j30) + j118;
        long j120 = (j36 * j35) + (j34 * j33) + j119;
        long j121 = j24 * j43;
        long j122 = j117 + j121 + (j42 * j41) + (j40 * j37) + j120 + (j114 >>> 28);
        long j123 = (((j45 * j66) + ((j65 * j63) + ((j62 * j60) + ((j59 * j57) + ((j56 * j54) + ((j53 * j52) + ((j51 * j49) + (j48 * j46)))))))) - j117) + (j115 >>> 28);
        long j124 = j123 >>> 28;
        long j125 = (j122 >>> 28) + j124 + ((long) i48);
        long j126 = j124 + ((long) i47);
        iArr3[0] = ((int) j126) & 268435455;
        iArr3[1] = i49 + ((int) (j126 >>> 28));
        iArr3[2] = i51;
        iArr3[3] = i53;
        iArr3[4] = i55;
        iArr3[5] = i57;
        iArr3[6] = ((int) j114) & 268435455;
        iArr3[7] = ((int) j122) & 268435455;
        iArr3[8] = ((int) j125) & 268435455;
        iArr3[9] = i50 + ((int) (j125 >>> 28));
        iArr3[10] = i52;
        iArr3[11] = i54;
        iArr3[12] = i56;
        iArr3[13] = i58;
        iArr3[14] = ((int) j115) & 268435455;
        iArr3[15] = ((int) j123) & 268435455;
    }

    public static void p(int[] iArr) {
        r(iArr, 1);
        r(iArr, -1);
    }

    public static void q(int[] iArr) {
        iArr[0] = 1;
        for (int i = 1; i < 16; i++) {
            iArr[i] = 0;
        }
    }

    public static void r(int[] iArr, int i) {
        int i2;
        int i3 = iArr[15];
        int i4 = i3 & 268435455;
        long j = (long) ((i3 >>> 28) + i);
        int i5 = 0;
        long j2 = j;
        while (true) {
            if (i5 >= 8) {
                break;
            }
            long j3 = j2 + (4294967295L & ((long) iArr[i5]));
            iArr[i5] = ((int) j3) & 268435455;
            j2 = j3 >> 28;
            i5++;
        }
        long j4 = j2 + j;
        for (i2 = 8; i2 < 15; i2++) {
            long j5 = j4 + (((long) iArr[i2]) & 4294967295L);
            iArr[i2] = ((int) j5) & 268435455;
            j4 = j5 >> 28;
        }
        iArr[15] = i4 + ((int) j4);
    }

    public static void s(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = iArr[10];
        int i12 = iArr[11];
        int i13 = iArr[12];
        int i14 = iArr[13];
        int i15 = iArr[14];
        int i16 = iArr[15];
        int i17 = i * 2;
        int i18 = i2 * 2;
        int i19 = i3 * 2;
        int i20 = i4 * 2;
        int i21 = i5 * 2;
        int i22 = i6 * 2;
        int i23 = i7 * 2;
        int i24 = i9 * 2;
        int i25 = i10 * 2;
        int i26 = i11 * 2;
        int i27 = i12 * 2;
        int i28 = i13 * 2;
        int i29 = i14 * 2;
        int i30 = i15 * 2;
        int i31 = i + i9;
        int i32 = i2 + i10;
        int i33 = i3 + i11;
        int i34 = i4 + i12;
        int i35 = i5 + i13;
        int i36 = i6 + i14;
        int i37 = i7 + i15;
        int i38 = i8 + i16;
        int i39 = i31 * 2;
        int i40 = i32 * 2;
        int i41 = i33 * 2;
        int i42 = i34 * 2;
        int i43 = i36 * 2;
        long j = (long) i;
        long j2 = j * j;
        long j3 = (long) i8;
        long j4 = (long) i18;
        long j5 = j3 * j4;
        long j6 = (long) i7;
        long j7 = (long) i19;
        long j8 = (j6 * j7) + j5;
        long j9 = (long) i6;
        long j10 = (long) i20;
        long j11 = (long) i5;
        long j12 = j11 * j11;
        long j13 = (long) i9;
        long j14 = (long) i16;
        long j15 = (long) i25;
        long j16 = j14 * j15;
        long j17 = (long) i15;
        long j18 = (long) i26;
        long j19 = (long) i14;
        long j20 = (long) i27;
        long j21 = j19 * j20;
        long j22 = (long) i13;
        long j23 = (long) i31;
        long j24 = (long) i38;
        long j25 = ((long) i40) & 4294967295L;
        long j26 = j24 * j25;
        long j27 = (long) i37;
        long j28 = ((long) i41) & 4294967295L;
        long j29 = (long) i36;
        long j30 = ((long) i42) & 4294967295L;
        long j31 = (j29 * j30) + (j27 * j28) + j26;
        long j32 = (long) i35;
        long j33 = (j32 * j32) + j31;
        long j34 = ((j2 + (j13 * j13)) + j33) - (j12 + ((j9 * j10) + j8));
        int i44 = ((int) j34) & 268435455;
        long j35 = ((((j22 * j22) + (j21 + ((j17 * j18) + j16))) + (j23 * j23)) - j2) + j33;
        int i45 = ((int) j35) & 268435455;
        long j36 = j35 >>> 28;
        long j37 = (long) i2;
        long j38 = (long) i17;
        long j39 = j37 * j38;
        long j40 = j6 * j10;
        long j41 = (long) i21;
        long j42 = j9 * j41;
        long j43 = (long) i10;
        long j44 = (long) i24;
        long j45 = j43 * j44;
        long j46 = (long) i28;
        long j47 = j19 * j46;
        long j48 = (long) i32;
        long j49 = ((long) i39) & 4294967295L;
        long j50 = ((long) (i35 * 2)) & 4294967295L;
        long j51 = j29 * j50;
        long j52 = j51 + (j27 * j30) + (j24 * j28);
        long j53 = (((j39 + j45) + j52) - (j42 + (j40 + (j3 * j7)))) + (j34 >>> 28);
        long j54 = (((j47 + ((j17 * j20) + (j14 * j18))) + (j48 * j49)) - j39) + j52 + j36;
        int i46 = ((int) j54) & 268435455;
        long j55 = j54 >>> 28;
        long j56 = (long) i3;
        long j57 = (j37 * j37) + (j56 * j38);
        long j58 = (long) i11;
        long j59 = (j43 * j43) + (j58 * j44);
        long j60 = (j17 * j46) + (j14 * j20);
        long j61 = (long) i33;
        long j62 = (j29 * j29) + (j27 * j50) + (j24 * j30);
        long j63 = (((j57 + j59) + j62) - ((j9 * j9) + ((j6 * j41) + (j3 * j10)))) + (j53 >>> 28);
        int i47 = ((int) j63) & 268435455;
        long j64 = ((((j19 * j19) + j60) + ((j48 * j48) + (j61 * j49))) - j57) + j62 + j55;
        int i48 = ((int) j64) & 268435455;
        long j65 = (long) i4;
        long j66 = (j56 * j4) + (j65 * j38);
        long j67 = (long) i22;
        long j68 = (long) i12;
        long j69 = (j58 * j15) + (j68 * j44);
        long j70 = (long) i29;
        long j71 = j17 * j70;
        long j72 = (long) i34;
        long j73 = j61 * j25;
        long j74 = j50 * j24;
        long j75 = ((long) i43) & 4294967295L;
        long j76 = (j27 * j75) + j74;
        long j77 = (((j66 + j69) + j76) - ((j6 * j67) + (j3 * j41))) + (j63 >>> 28);
        int i49 = ((int) j77) & 268435455;
        long j78 = j77 >>> 28;
        long j79 = (((j71 + (j14 * j46)) + (j73 + (j72 * j49))) - j66) + j76 + (j64 >>> 28);
        int i50 = ((int) j79) & 268435455;
        long j80 = j56 * j56;
        long j81 = j80 + (j65 * j4) + (j11 * j38);
        long j82 = (j6 * j6) + (j67 * j3);
        long j83 = (j58 * j58) + (j68 * j15) + (j22 * j44);
        long j84 = j61 * j61;
        long j85 = (j27 * j27) + (j75 * j24);
        long j86 = (((j81 + j83) + j85) - j82) + j78;
        long j87 = j86 >>> 28;
        long j88 = ((((j17 * j17) + (j14 * j70)) + (j84 + ((j72 * j25) + (j32 * j49)))) - j81) + j85 + (j79 >>> 28);
        long j89 = j65 * j7;
        long j90 = j89 + (j11 * j4) + (j9 * j38);
        long j91 = (j68 * j18) + (j22 * j15) + (j19 * j44);
        long j92 = (((long) (i37 * 2)) & 4294967295L) * j24;
        long j93 = (((j90 + j91) + j92) - (((long) i23) * j3)) + j87;
        long j94 = (((((long) i30) * j14) + ((j72 * j28) + ((j32 * j25) + (j29 * j49)))) - j90) + j92 + (j88 >>> 28);
        long j95 = (j65 * j65) + (j11 * j7) + (j9 * j4) + (j6 * j38);
        long j96 = j72 * j72;
        long j97 = j24 * j24;
        long j98 = (((j95 + ((j68 * j68) + ((j22 * j18) + ((j19 * j15) + (j17 * j44))))) + j97) - (j3 * j3)) + (j93 >>> 28);
        long j99 = (((j14 * j14) + (j96 + ((j32 * j28) + ((j29 * j25) + (j27 * j49))))) - j95) + j97 + (j94 >>> 28);
        long j100 = (j11 * j10) + (j9 * j7) + (j6 * j4) + (j3 * j38);
        long j101 = (j22 * j20) + (j19 * j18) + (j17 * j15) + (j44 * j14);
        long j102 = j101 + j100 + (j98 >>> 28);
        long j103 = (((j32 * j30) + ((j29 * j28) + ((j27 * j25) + (j24 * j49)))) - j100) + (j99 >>> 28);
        long j104 = j103 >>> 28;
        long j105 = (j102 >>> 28) + j104 + ((long) i45);
        long j106 = j104 + ((long) i44);
        iArr2[0] = ((int) j106) & 268435455;
        iArr2[1] = (((int) j53) & 268435455) + ((int) (j106 >>> 28));
        iArr2[2] = i47;
        iArr2[3] = i49;
        iArr2[4] = ((int) j86) & 268435455;
        iArr2[5] = ((int) j93) & 268435455;
        iArr2[6] = ((int) j98) & 268435455;
        iArr2[7] = ((int) j102) & 268435455;
        iArr2[8] = ((int) j105) & 268435455;
        iArr2[9] = i46 + ((int) (j105 >>> 28));
        iArr2[10] = i48;
        iArr2[11] = i50;
        iArr2[12] = ((int) j88) & 268435455;
        iArr2[13] = ((int) j94) & 268435455;
        iArr2[14] = ((int) j99) & 268435455;
        iArr2[15] = ((int) j103) & 268435455;
    }

    public static void t(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = iArr[10];
        int i12 = iArr[11];
        int i13 = iArr[12];
        int i14 = iArr[13];
        int i15 = iArr[14];
        int i16 = iArr[15];
        int i17 = iArr2[0];
        int i18 = iArr2[1];
        int i19 = iArr2[2];
        int i20 = iArr2[3];
        int i21 = iArr2[4];
        int i22 = iArr2[5];
        int i23 = iArr2[6];
        int i24 = iArr2[7];
        int i25 = iArr2[8];
        int i26 = iArr2[9];
        int i27 = iArr2[10];
        int i28 = iArr2[11];
        int i29 = iArr2[12];
        int i30 = iArr2[13];
        int i31 = (i2 + 536870910) - i18;
        int i32 = (i6 + 536870910) - i22;
        int i33 = (i10 + 536870910) - i26;
        int i34 = (i14 + 536870910) - i30;
        int i35 = ((i3 + 536870910) - i19) + (i31 >>> 28);
        int i36 = ((i7 + 536870910) - i23) + (i32 >>> 28);
        int i37 = ((i11 + 536870910) - i27) + (i33 >>> 28);
        int i38 = ((i15 + 536870910) - iArr2[14]) + (i34 >>> 28);
        int i39 = ((i4 + 536870910) - i20) + (i35 >>> 28);
        int i40 = ((i8 + 536870910) - i24) + (i36 >>> 28);
        int i41 = ((i12 + 536870910) - i28) + (i37 >>> 28);
        int i42 = ((i16 + 536870910) - iArr2[15]) + (i38 >>> 28);
        int i43 = i42 >>> 28;
        int i44 = ((i + 536870910) - i17) + i43;
        int i45 = ((i5 + 536870910) - i21) + (i39 >>> 28);
        int i46 = ((i9 + 536870908) - i25) + i43 + (i40 >>> 28);
        int i47 = ((i13 + 536870910) - i29) + (i41 >>> 28);
        iArr3[0] = i44 & 268435455;
        iArr3[1] = (i31 & 268435455) + (i44 >>> 28);
        iArr3[2] = i35 & 268435455;
        iArr3[3] = i39 & 268435455;
        iArr3[4] = i45 & 268435455;
        iArr3[5] = (i32 & 268435455) + (i45 >>> 28);
        iArr3[6] = i36 & 268435455;
        iArr3[7] = i40 & 268435455;
        iArr3[8] = i46 & 268435455;
        iArr3[9] = (i33 & 268435455) + (i46 >>> 28);
        iArr3[10] = i37 & 268435455;
        iArr3[11] = i41 & 268435455;
        iArr3[12] = i47 & 268435455;
        iArr3[13] = (i34 & 268435455) + (i47 >>> 28);
        iArr3[14] = i38 & 268435455;
        iArr3[15] = i42 & 268435455;
    }
}
