package okio;

import com.google.android.gms.recaptcha.RecaptchaActionType;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import i0.j.f.p.h;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.text.StringsKt__IndentKt;
import m0.n.b.f;
import m0.n.b.i;
import r0.a0.b;
/* compiled from: ByteString.kt */
/* loaded from: classes4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public transient int q;
    public transient String x;
    public final byte[] y;
    public static final a d = new a(null);
    public static final ByteString c = new ByteString(new byte[0]);

    /* compiled from: ByteString.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a(f fVar) {
        }

        public static ByteString d(a aVar, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            i.e(bArr, "$this$toByteString");
            m0.r.t.a.r.m.a1.a.A0((long) bArr.length, (long) i, (long) i2);
            int i4 = i2 + i;
            i.e(bArr, "$this$copyOfRangeImpl");
            h.X(i4, bArr.length);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i4);
            i.d(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return new ByteString(copyOfRange);
        }

        public final ByteString a(String str) {
            int i;
            int i2;
            i.e(str, "$this$decodeBase64");
            byte[] bArr = r0.a.a;
            i.e(str, "$this$decodeBase64ToArray");
            int length = str.length();
            while (length > 0 && ((r7 = str.charAt(length - 1)) == '=' || r7 == '\n' || r7 == '\r' || r7 == ' ' || r7 == '\t')) {
                length = i2;
            }
            int i3 = (int) ((((long) length) * 6) / 8);
            byte[] bArr2 = new byte[i3];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i4 < length) {
                    char charAt = str.charAt(i4);
                    if ('A' <= charAt && 'Z' >= charAt) {
                        i = charAt - 'A';
                    } else if ('a' <= charAt && 'z' >= charAt) {
                        i = charAt - 'G';
                    } else if ('0' <= charAt && '9' >= charAt) {
                        i = charAt + 4;
                    } else if (charAt == '+' || charAt == '-') {
                        i = 62;
                    } else if (charAt == '/' || charAt == '_') {
                        i = 63;
                    } else {
                        if (!(charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                            break;
                        }
                        i4++;
                    }
                    i6 = (i6 << 6) | i;
                    i5++;
                    if (i5 % 4 == 0) {
                        int i8 = i7 + 1;
                        bArr2[i7] = (byte) (i6 >> 16);
                        int i9 = i8 + 1;
                        bArr2[i8] = (byte) (i6 >> 8);
                        bArr2[i9] = (byte) i6;
                        i7 = i9 + 1;
                    }
                    i4++;
                } else {
                    int i10 = i5 % 4;
                    if (i10 != 1) {
                        if (i10 == 2) {
                            bArr2[i7] = (byte) ((i6 << 12) >> 16);
                            i7++;
                        } else if (i10 == 3) {
                            int i11 = i6 << 6;
                            int i12 = i7 + 1;
                            bArr2[i7] = (byte) (i11 >> 16);
                            i7 = i12 + 1;
                            bArr2[i12] = (byte) (i11 >> 8);
                        }
                        if (i7 != i3) {
                            bArr2 = Arrays.copyOf(bArr2, i7);
                            i.d(bArr2, "java.util.Arrays.copyOf(this, newSize)");
                        }
                    }
                }
            }
            bArr2 = null;
            if (bArr2 != null) {
                return new ByteString(bArr2);
            }
            return null;
        }

        public final ByteString b(String str) {
            i.e(str, "$this$decodeHex");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (b.a(str.charAt(i2 + 1)) + (b.a(str.charAt(i2)) << 4));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(i0.d.a.a.a.n0("Unexpected hex string: ", str).toString());
        }

        public final ByteString c(String str) {
            i.e(str, "$this$encodeUtf8");
            i.e(str, "$this$asUtf8ToByteArray");
            byte[] bytes = str.getBytes(m0.t.a.a);
            i.d(bytes, "(this as java.lang.String).getBytes(charset)");
            ByteString byteString = new ByteString(bytes);
            byteString.x = str;
            return byteString;
        }
    }

    public ByteString(byte[] bArr) {
        i.e(bArr, MessageExtension.FIELD_DATA);
        this.y = bArr;
    }

    public String a() {
        byte[] bArr = this.y;
        byte[] bArr2 = r0.a.a;
        byte[] bArr3 = r0.a.a;
        i.e(bArr, "$this$encodeBase64");
        i.e(bArr3, "map");
        byte[] bArr4 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b = bArr[i];
            int i4 = i3 + 1;
            byte b2 = bArr[i3];
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            int i6 = i2 + 1;
            bArr4[i2] = bArr3[(b & 255) >> 2];
            int i7 = i6 + 1;
            bArr4[i6] = bArr3[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i8 = i7 + 1;
            bArr4[i7] = bArr3[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 = i8 + 1;
            bArr4[i8] = bArr3[b3 & 63];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            int i9 = i2 + 1;
            bArr4[i2] = bArr3[(b4 & 255) >> 2];
            int i10 = i9 + 1;
            bArr4[i9] = bArr3[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr4[i10] = b5;
            bArr4[i10 + 1] = b5;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b6 = bArr[i];
            byte b7 = bArr[i11];
            int i12 = i2 + 1;
            bArr4[i2] = bArr3[(b6 & 255) >> 2];
            int i13 = i12 + 1;
            bArr4[i12] = bArr3[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr4[i13] = bArr3[(b7 & 15) << 2];
            bArr4[i13 + 1] = (byte) 61;
        }
        i.e(bArr4, "$this$toUtf8String");
        return new String(bArr4, m0.t.a.a);
    }

    public ByteString b(String str) {
        i.e(str, "algorithm");
        byte[] digest = MessageDigest.getInstance(str).digest(this.y);
        i.d(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r0 < r1) goto L_0x0031;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
        if (r6 < r7) goto L_0x0031;
     */
    @Override // java.lang.Comparable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public int compareTo(ByteString byteString) {
        ByteString byteString2 = byteString;
        i.e(byteString2, RecaptchaActionType.OTHER);
        int e = e();
        int e2 = byteString2.e();
        int min = Math.min(e, e2);
        for (int i = 0; i < min; i++) {
            int i2 = i(i) & 255;
            int i3 = byteString2.i(i) & 255;
            if (i2 == i3) {
            }
        }
        if (e == e2) {
            return 0;
        }
    }

    public int e() {
        return this.y.length;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int e = byteString.e();
            byte[] bArr = this.y;
            if (e == bArr.length && byteString.n(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        byte[] bArr = this.y;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = b.a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public byte[] g() {
        return this.y;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.q;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.y);
        this.q = hashCode;
        return hashCode;
    }

    public byte i(int i) {
        return this.y[i];
    }

    public boolean l(int i, ByteString byteString, int i2, int i3) {
        i.e(byteString, RecaptchaActionType.OTHER);
        return byteString.n(i2, this.y, i, i3);
    }

    public boolean n(int i, byte[] bArr, int i2, int i3) {
        i.e(bArr, RecaptchaActionType.OTHER);
        if (i >= 0) {
            byte[] bArr2 = this.y;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && m0.r.t.a.r.m.a1.a.T(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public ByteString q() {
        byte b;
        int i = 0;
        while (true) {
            byte[] bArr = this.y;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            byte b3 = (byte) 65;
            if (b2 < b3 || b2 > (b = (byte) 90)) {
                i++;
            } else {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                i.d(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x011c, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0125, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0163, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0176, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0187, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0196, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01ac, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01b4, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x01bb, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x01f0, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x01f3, code lost:
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008a, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009b, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a6, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00e8, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00fb, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x010a, code lost:
        if (r4 == 64) goto L_0x01f4;
     */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump */
    public String toString() {
        ByteString byteString;
        byte[] bArr = this.y;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        loop0: while (true) {
            if (i >= length) {
                break;
            }
            byte b = bArr[i];
            if (b >= 0) {
                int i4 = i2 + 1;
                if (i2 == 64) {
                    break;
                }
                if (!(b == 10 || b == 13)) {
                    if ((b >= 0 && 31 >= b) || (Byte.MAX_VALUE <= b && 159 >= b)) {
                        break;
                    }
                }
                if (b == 65533) {
                    break;
                }
                i3 += b < 65536 ? 1 : 2;
                i++;
                while (true) {
                    i2 = i4;
                    if (i < length && bArr[i] >= 0) {
                        int i5 = i + 1;
                        byte b2 = bArr[i];
                        i4 = i2 + 1;
                        if (i2 == 64) {
                            break loop0;
                        }
                        if (!(b2 == 10 || b2 == 13)) {
                            if ((b2 >= 0 && 31 >= b2) || (Byte.MAX_VALUE <= b2 && 159 >= b2)) {
                                break loop0;
                            }
                        }
                        if (b2 == 65533) {
                            break loop0;
                        }
                        i3 += b2 < 65536 ? 1 : 2;
                        i = i5;
                    }
                }
            } else if ((b >> 5) == -2) {
                int i6 = i + 1;
                if (length > i6) {
                    byte b3 = bArr[i];
                    byte b4 = bArr[i6];
                    if ((b4 & 192) == 128) {
                        int i7 = (b4 ^ 3968) ^ (b3 << 6);
                        if (i7 >= 128) {
                            i2++;
                            if (i2 == 64) {
                                break;
                            }
                            if (!(i7 == 10 || i7 == 13)) {
                                if ((i7 >= 0 && 31 >= i7) || (127 <= i7 && 159 >= i7)) {
                                    break;
                                }
                            }
                            if (i7 == 65533) {
                                break;
                            }
                            i3 += i7 < 65536 ? 1 : 2;
                            i += 2;
                        }
                    }
                }
            } else if ((b >> 4) == -2) {
                int i8 = i + 2;
                if (length > i8) {
                    byte b5 = bArr[i];
                    byte b6 = bArr[i + 1];
                    if ((b6 & 192) == 128) {
                        byte b7 = bArr[i8];
                        if ((b7 & 192) == 128) {
                            int i9 = ((b7 ^ -123008) ^ (b6 << 6)) ^ (b5 << 12);
                            if (i9 >= 2048) {
                                if (55296 > i9 || 57343 < i9) {
                                    i2++;
                                    if (i2 == 64) {
                                        break;
                                    }
                                    if (!(i9 == 10 || i9 == 13)) {
                                        if ((i9 >= 0 && 31 >= i9) || (127 <= i9 && 159 >= i9)) {
                                            break;
                                        }
                                    }
                                    if (i9 == 65533) {
                                        break;
                                    }
                                    i3 += i9 < 65536 ? 1 : 2;
                                    i += 3;
                                }
                            }
                        }
                    }
                }
            } else if ((b >> 3) == -2) {
                int i10 = i + 3;
                if (length > i10) {
                    byte b8 = bArr[i];
                    byte b9 = bArr[i + 1];
                    if ((b9 & 192) == 128) {
                        byte b10 = bArr[i + 2];
                        if ((b10 & 192) == 128) {
                            byte b11 = bArr[i10];
                            if ((b11 & 192) == 128) {
                                int i11 = (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b8 << 18);
                                if (i11 <= 1114111) {
                                    if (55296 > i11 || 57343 < i11) {
                                        if (i11 >= 65536) {
                                            i2++;
                                            if (i2 == 64) {
                                                break;
                                            }
                                            if (!(i11 == 10 || i11 == 13)) {
                                                if ((i11 >= 0 && 31 >= i11) || (127 <= i11 && 159 >= i11)) {
                                                    break;
                                                }
                                            }
                                            if (i11 == 65533) {
                                                break;
                                            }
                                            i3 += i11 < 65536 ? 1 : 2;
                                            i += 4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i3 != -1) {
            String v = v();
            String substring = v.substring(0, i3);
            i.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String B = StringsKt__IndentKt.B(StringsKt__IndentKt.B(StringsKt__IndentKt.B(substring, "\\", "\\\\", false, 4), "\n", "\\n", false, 4), "\r", "\\r", false, 4);
            if (i3 < v.length()) {
                StringBuilder P0 = i0.d.a.a.a.P0("[size=");
                P0.append(this.y.length);
                P0.append(" text=");
                P0.append(B);
                P0.append("…]");
                return P0.toString();
            }
            return "[text=" + B + ']';
        } else if (this.y.length <= 64) {
            StringBuilder P02 = i0.d.a.a.a.P0("[hex=");
            P02.append(f());
            P02.append(']');
            return P02.toString();
        } else {
            StringBuilder P03 = i0.d.a.a.a.P0("[size=");
            P03.append(this.y.length);
            P03.append(" hex=");
            byte[] bArr2 = this.y;
            if (64 <= bArr2.length) {
                if (64 == bArr2.length) {
                    byteString = this;
                } else {
                    i.e(bArr2, "$this$copyOfRangeImpl");
                    h.X(64, bArr2.length);
                    byte[] copyOfRange = Arrays.copyOfRange(bArr2, 0, 64);
                    i.d(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
                    byteString = new ByteString(copyOfRange);
                }
                P03.append(byteString.f());
                P03.append("…]");
                return P03.toString();
            }
            throw new IllegalArgumentException(i0.d.a.a.a.s0(i0.d.a.a.a.P0("endIndex > length("), this.y.length, ')').toString());
        }
    }

    public String v() {
        String str = this.x;
        if (str != null) {
            return str;
        }
        byte[] g = g();
        i.e(g, "$this$toUtf8String");
        String str2 = new String(g, m0.t.a.a);
        this.x = str2;
        return str2;
    }

    public void w(r0.f fVar, int i, int i2) {
        i.e(fVar, "buffer");
        i.e(this, "$this$commonWrite");
        i.e(fVar, "buffer");
        fVar.H(this.y, i, i2);
    }
}
