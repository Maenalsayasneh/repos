package i0.f.a.b.i;
/* compiled from: NumberOutput.java */
/* loaded from: classes2.dex */
public final class f {
    public static final String a = String.valueOf(Integer.MIN_VALUE);
    public static final String b = String.valueOf(Long.MIN_VALUE);
    public static final int[] c = new int[1000];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                for (int i4 = 0; i4 < 10; i4++) {
                    i++;
                    c[i] = ((i2 + 48) << 16) | ((i3 + 48) << 8) | (i4 + 48);
                }
            }
        }
    }

    public static int a(int i, char[] cArr, int i2) {
        int i3 = c[i];
        int i4 = i2 + 1;
        cArr[i2] = (char) (i3 >> 16);
        int i5 = i4 + 1;
        cArr[i4] = (char) ((i3 >> 8) & 127);
        int i6 = i5 + 1;
        cArr[i5] = (char) (i3 & 127);
        return i6;
    }

    public static int b(int i, char[] cArr, int i2) {
        int i3 = c[i];
        if (i > 9) {
            if (i > 99) {
                cArr[i2] = (char) (i3 >> 16);
                i2++;
            }
            cArr[i2] = (char) ((i3 >> 8) & 127);
            i2++;
        }
        int i4 = i2 + 1;
        cArr[i2] = (char) (i3 & 127);
        return i4;
    }

    public static int c(int i, char[] cArr, int i2) {
        int i3 = i / 1000;
        int i4 = i - (i3 * 1000);
        int i5 = i3 / 1000;
        int[] iArr = c;
        int i6 = iArr[i5];
        int i7 = i2 + 1;
        cArr[i2] = (char) (i6 >> 16);
        int i8 = i7 + 1;
        cArr[i7] = (char) ((i6 >> 8) & 127);
        int i9 = i8 + 1;
        cArr[i8] = (char) (i6 & 127);
        int i10 = iArr[i3 - (i5 * 1000)];
        int i11 = i9 + 1;
        cArr[i9] = (char) (i10 >> 16);
        int i12 = i11 + 1;
        cArr[i11] = (char) ((i10 >> 8) & 127);
        int i13 = i12 + 1;
        cArr[i12] = (char) (i10 & 127);
        int i14 = iArr[i4];
        int i15 = i13 + 1;
        cArr[i13] = (char) (i14 >> 16);
        int i16 = i15 + 1;
        cArr[i15] = (char) ((i14 >> 8) & 127);
        int i17 = i16 + 1;
        cArr[i16] = (char) (i14 & 127);
        return i17;
    }

    public static int d(int i, char[] cArr, int i2) {
        int i3;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                String str = a;
                int length = str.length();
                str.getChars(0, length, cArr, i2);
                return length + i2;
            }
            cArr[i2] = '-';
            i = -i;
            i2++;
        }
        if (i < 1000000) {
            if (i >= 1000) {
                int i4 = i / 1000;
                return a(i - (i4 * 1000), cArr, b(i4, cArr, i2));
            } else if (i >= 10) {
                return b(i, cArr, i2);
            } else {
                cArr[i2] = (char) (i + 48);
                return i2 + 1;
            }
        } else if (i >= 1000000000) {
            int i5 = i - 1000000000;
            if (i5 >= 1000000000) {
                i5 -= 1000000000;
                i3 = i2 + 1;
                cArr[i2] = '2';
            } else {
                i3 = i2 + 1;
                cArr[i2] = '1';
            }
            return c(i5, cArr, i3);
        } else {
            int i6 = i / 1000;
            int i7 = i6 / 1000;
            return a(i - (i6 * 1000), cArr, a(i6 - (i7 * 1000), cArr, b(i7, cArr, i2)));
        }
    }

    public static int e(long j, char[] cArr, int i) {
        int i2;
        int i3;
        if (j < 0) {
            if (j > -2147483648L) {
                return d((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                String str = b;
                int length = str.length();
                str.getChars(0, length, cArr, i);
                return length + i;
            }
            cArr[i] = '-';
            j = -j;
            i++;
        } else if (j <= 2147483647L) {
            return d((int) j, cArr, i);
        }
        long j2 = j / 1000000000;
        long j3 = j - (j2 * 1000000000);
        if (j2 < 1000000000) {
            int i4 = (int) j2;
            if (i4 >= 1000000) {
                int i5 = i4 / 1000;
                int i6 = i4 - (i5 * 1000);
                int i7 = i5 / 1000;
                int b2 = b(i7, cArr, i);
                int[] iArr = c;
                int i8 = iArr[i5 - (i7 * 1000)];
                int i9 = b2 + 1;
                cArr[b2] = (char) (i8 >> 16);
                int i10 = i9 + 1;
                cArr[i9] = (char) ((i8 >> 8) & 127);
                int i11 = i10 + 1;
                cArr[i10] = (char) (i8 & 127);
                int i12 = iArr[i6];
                int i13 = i11 + 1;
                cArr[i11] = (char) (i12 >> 16);
                int i14 = i13 + 1;
                cArr[i13] = (char) ((i12 >> 8) & 127);
                i3 = i14 + 1;
                cArr[i14] = (char) (i12 & 127);
            } else if (i4 < 1000) {
                i2 = b(i4, cArr, i);
            } else {
                int i15 = i4 / 1000;
                int i16 = i4 - (i15 * 1000);
                int[] iArr2 = c;
                int i17 = iArr2[i15];
                if (i15 > 9) {
                    if (i15 > 99) {
                        cArr[i] = (char) (i17 >> 16);
                        i++;
                    }
                    cArr[i] = (char) ((i17 >> 8) & 127);
                    i++;
                }
                int i18 = i + 1;
                cArr[i] = (char) (i17 & 127);
                int i19 = iArr2[i16];
                int i20 = i18 + 1;
                cArr[i18] = (char) (i19 >> 16);
                int i21 = i20 + 1;
                cArr[i20] = (char) ((i19 >> 8) & 127);
                i3 = i21 + 1;
                cArr[i21] = (char) (i19 & 127);
            }
            i2 = i3;
        } else {
            long j4 = j2 / 1000000000;
            int b3 = b((int) j4, cArr, i);
            i2 = c((int) (j2 - (1000000000 * j4)), cArr, b3);
        }
        return c((int) j3, cArr, i2);
    }
}
