package m0.r.t.a.r.f.d.a;

import m0.n.b.i;
/* compiled from: BitEncoding.java */
/* loaded from: classes4.dex */
public class a {
    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        "true".equals(str);
    }

    public static byte[] a(String[] strArr) {
        int i;
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                String[] b = b(strArr);
                i.e(b, "strings");
                int i2 = 0;
                for (String str : b) {
                    i2 += str.length();
                }
                byte[] bArr = new byte[i2];
                int length = b.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    String str2 = b[i3];
                    i3++;
                    int length2 = str2.length() - 1;
                    if (length2 >= 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            i = i4 + 1;
                            bArr[i4] = (byte) str2.charAt(i5);
                            if (i5 == length2) {
                                break;
                            }
                            i5 = i6;
                            i4 = i;
                        }
                        i4 = i;
                    }
                }
                return bArr;
            } else if (charAt == 65535) {
                strArr = b(strArr);
            }
        }
        int i7 = 0;
        for (String str3 : strArr) {
            i7 += str3.length();
        }
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        for (String str4 : strArr) {
            int length3 = str4.length();
            int i9 = 0;
            while (i9 < length3) {
                bArr2[i8] = (byte) str4.charAt(i9);
                i9++;
                i8++;
            }
        }
        for (int i10 = 0; i10 < i7; i10++) {
            bArr2[i10] = (byte) ((bArr2[i10] + Byte.MAX_VALUE) & 127);
        }
        int i11 = (i7 * 7) / 8;
        byte[] bArr3 = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            i12++;
            int i15 = i13 + 1;
            bArr3[i14] = (byte) (((bArr2[i12] & 255) >>> i13) + ((bArr2[i12] & ((1 << i15) - 1)) << (7 - i13)));
            if (i13 == 6) {
                i12++;
                i13 = 0;
            } else {
                i13 = i15;
            }
        }
        return bArr3;
    }

    public static String[] b(String[] strArr) {
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }
}
