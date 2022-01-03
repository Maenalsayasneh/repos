package com.fasterxml.jackson.core;

import i0.d.a.a.a;
import i0.f.a.b.m.c;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class Base64Variant implements Serializable {
    public final int Y1;
    public final boolean Z1;
    public final PaddingReadBehaviour a2;
    public final transient int[] c;
    public final transient char[] d;
    public final transient byte[] q;
    public final String x;
    public final char y;

    /* loaded from: classes2.dex */
    public enum PaddingReadBehaviour {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        int[] iArr = new int[128];
        this.c = iArr;
        char[] cArr = new char[64];
        this.d = cArr;
        this.q = new byte[64];
        this.x = str;
        this.Z1 = z;
        this.y = c;
        this.Y1 = i;
        int length = str2.length();
        if (length == 64) {
            str2.getChars(0, length, cArr, 0);
            Arrays.fill(iArr, -1);
            for (int i2 = 0; i2 < length; i2++) {
                char c2 = this.d[i2];
                this.q[i2] = (byte) c2;
                this.c[c2] = i2;
            }
            if (z) {
                this.c[c] = -2;
            }
            this.a2 = z ? PaddingReadBehaviour.PADDING_REQUIRED : PaddingReadBehaviour.PADDING_FORBIDDEN;
            return;
        }
        throw new IllegalArgumentException(a.g0("Base64Alphabet length must be exactly 64 (was ", length, ")"));
    }

    public void a() throws IllegalArgumentException {
        throw new IllegalArgumentException(k());
    }

    public void b() throws IllegalArgumentException {
        throw new IllegalArgumentException(String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", this.x));
    }

    public void c(char c, int i, String str) throws IllegalArgumentException {
        String str2;
        if (c <= ' ') {
            StringBuilder P0 = a.P0("Illegal white space character (code 0x");
            P0.append(Integer.toHexString(c));
            P0.append(") as character #");
            P0.append(i + 1);
            P0.append(" of 4-char base64 unit: can only used between units");
            str2 = P0.toString();
        } else {
            if (c == this.y) {
                StringBuilder P02 = a.P0("Unexpected padding character ('");
                P02.append(this.y);
                P02.append("') as character #");
                P02.append(i + 1);
                P02.append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
                str2 = P02.toString();
            } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
                StringBuilder P03 = a.P0("Illegal character (code 0x");
                P03.append(Integer.toHexString(c));
                P03.append(") in base64 content");
                str2 = P03.toString();
            } else {
                str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
            }
        }
        if (str != null) {
            str2 = a.o0(str2, ": ", str);
        }
        throw new IllegalArgumentException(str2);
    }

    public void d(String str, c cVar) throws IllegalArgumentException {
        int length = str.length();
        boolean z = false;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt > ' ') {
                int e = e(charAt);
                if (e < 0) {
                    c(charAt, 0, null);
                    throw null;
                } else if (i2 < length) {
                    int i3 = i2 + 1;
                    char charAt2 = str.charAt(i2);
                    int e2 = e(charAt2);
                    boolean z2 = true;
                    if (e2 >= 0) {
                        int i4 = (e << 6) | e2;
                        if (i3 >= length) {
                            if (this.a2 == PaddingReadBehaviour.PADDING_REQUIRED) {
                                z = true;
                            }
                            if (!z) {
                                cVar.b(i4 >> 4);
                                return;
                            } else {
                                a();
                                throw null;
                            }
                        } else {
                            int i5 = i3 + 1;
                            char charAt3 = str.charAt(i3);
                            int e3 = e(charAt3);
                            if (e3 >= 0) {
                                int i6 = (i4 << 6) | e3;
                                if (i5 >= length) {
                                    if (this.a2 == PaddingReadBehaviour.PADDING_REQUIRED) {
                                        z = true;
                                    }
                                    if (!z) {
                                        cVar.f(i6 >> 2);
                                        return;
                                    } else {
                                        a();
                                        throw null;
                                    }
                                } else {
                                    i2 = i5 + 1;
                                    char charAt4 = str.charAt(i5);
                                    int e4 = e(charAt4);
                                    if (e4 >= 0) {
                                        cVar.e((i6 << 6) | e4);
                                    } else if (e4 == -2) {
                                        if (this.a2 == PaddingReadBehaviour.PADDING_FORBIDDEN) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            cVar.f(i6 >> 2);
                                        } else {
                                            b();
                                            throw null;
                                        }
                                    } else {
                                        c(charAt4, 3, null);
                                        throw null;
                                    }
                                }
                            } else if (e3 == -2) {
                                if (this.a2 == PaddingReadBehaviour.PADDING_FORBIDDEN) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    b();
                                    throw null;
                                } else if (i5 < length) {
                                    i = i5 + 1;
                                    char charAt5 = str.charAt(i5);
                                    if (l(charAt5)) {
                                        cVar.b(i4 >> 4);
                                    } else {
                                        StringBuilder P0 = a.P0("expected padding character '");
                                        P0.append(this.y);
                                        P0.append("'");
                                        c(charAt5, 3, P0.toString());
                                        throw null;
                                    }
                                } else {
                                    a();
                                    throw null;
                                }
                            } else {
                                c(charAt3, 2, null);
                                throw null;
                            }
                        }
                    } else {
                        c(charAt2, 1, null);
                        throw null;
                    }
                } else {
                    a();
                    throw null;
                }
            }
            i = i2;
        }
    }

    public int e(char c) {
        if (c <= 127) {
            return this.c[c];
        }
        return -1;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Base64Variant.class) {
            return false;
        }
        Base64Variant base64Variant = (Base64Variant) obj;
        return base64Variant.y == this.y && base64Variant.Y1 == this.Y1 && base64Variant.Z1 == this.Z1 && base64Variant.a2 == this.a2 && this.x.equals(base64Variant.x);
    }

    public int f(int i) {
        if (i <= 127) {
            return this.c[i];
        }
        return -1;
    }

    public String g(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int i = this.Y1 >> 2;
        int i2 = 0;
        int i3 = length - 3;
        while (i2 <= i3) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = (((bArr[i2] << 8) | (bArr[i4] & 255)) << 8) | (bArr[i5] & 255);
            sb.append(this.d[(i7 >> 18) & 63]);
            sb.append(this.d[(i7 >> 12) & 63]);
            sb.append(this.d[(i7 >> 6) & 63]);
            sb.append(this.d[i7 & 63]);
            i--;
            if (i <= 0) {
                sb.append('\\');
                sb.append('n');
                i = this.Y1 >> 2;
            }
            i2 = i6;
        }
        int i8 = length - i2;
        if (i8 > 0) {
            int i9 = i2 + 1;
            int i10 = bArr[i2] << 16;
            if (i8 == 2) {
                i10 |= (bArr[i9] & 255) << 8;
            }
            sb.append(this.d[(i10 >> 18) & 63]);
            sb.append(this.d[(i10 >> 12) & 63]);
            if (this.Z1) {
                sb.append(i8 == 2 ? this.d[(i10 >> 6) & 63] : this.y);
                sb.append(this.y);
            } else if (i8 == 2) {
                sb.append(this.d[(i10 >> 6) & 63]);
            }
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public int h(int i, char[] cArr, int i2) {
        int i3 = i2 + 1;
        char[] cArr2 = this.d;
        cArr[i2] = cArr2[(i >> 18) & 63];
        int i4 = i3 + 1;
        cArr[i3] = cArr2[(i >> 12) & 63];
        int i5 = i4 + 1;
        cArr[i4] = cArr2[(i >> 6) & 63];
        int i6 = i5 + 1;
        cArr[i5] = cArr2[i & 63];
        return i6;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.x.hashCode();
    }

    public int i(int i, int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        char[] cArr2 = this.d;
        cArr[i3] = cArr2[(i >> 18) & 63];
        int i5 = i4 + 1;
        cArr[i4] = cArr2[(i >> 12) & 63];
        if (this.Z1) {
            int i6 = i5 + 1;
            cArr[i5] = i2 == 2 ? cArr2[(i >> 6) & 63] : this.y;
            int i7 = i6 + 1;
            cArr[i6] = this.y;
            return i7;
        } else if (i2 != 2) {
            return i5;
        } else {
            int i8 = i5 + 1;
            cArr[i5] = cArr2[(i >> 6) & 63];
            return i8;
        }
    }

    public String k() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", this.x, Character.valueOf(this.y));
    }

    public boolean l(char c) {
        return c == this.y;
    }

    public boolean m(int i) {
        return i == this.y;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.x;
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        PaddingReadBehaviour paddingReadBehaviour = base64Variant.a2;
        int[] iArr = new int[128];
        this.c = iArr;
        char[] cArr = new char[64];
        this.d = cArr;
        byte[] bArr = new byte[64];
        this.q = bArr;
        this.x = str;
        byte[] bArr2 = base64Variant.q;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant.d;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant.c;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.Z1 = z;
        this.y = c;
        this.Y1 = i;
        this.a2 = paddingReadBehaviour;
    }
}
