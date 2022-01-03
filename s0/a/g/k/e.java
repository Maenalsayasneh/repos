package s0.a.g.k;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
/* loaded from: classes4.dex */
public class e implements c {
    public final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public final byte[] b = new byte[128];

    public e() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i2 < bArr.length) {
                bArr[i2] = -1;
                i2++;
            }
        }
        while (true) {
            byte[] bArr2 = this.a;
            if (i < bArr2.length) {
                this.b[bArr2[i]] = (byte) i;
                i++;
            } else {
                byte[] bArr3 = this.b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }

    public static boolean d(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    @Override // s0.a.g.k.c
    public int a(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        int length = str.length();
        while (length > 0) {
            int i = length - 1;
            if (!d(str.charAt(i))) {
                break;
            }
            length = i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            while (i2 < length && d(str.charAt(i2))) {
                i2++;
            }
            int i5 = i2 + 1;
            byte b = this.b[str.charAt(i2)];
            while (i5 < length && d(str.charAt(i5))) {
                i5++;
            }
            i2 = i5 + 1;
            byte b2 = this.b[str.charAt(i5)];
            if ((b | b2) >= 0) {
                int i6 = i3 + 1;
                bArr[i3] = (byte) ((b << 4) | b2);
                if (i6 == 36) {
                    outputStream.write(bArr);
                    i3 = 0;
                } else {
                    i3 = i6;
                }
                i4++;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        if (i3 > 0) {
            outputStream.write(bArr, 0, i3);
        }
        return i4;
    }

    @Override // s0.a.g.k.c
    public int b(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i2 > 0) {
            int min = Math.min(36, i2);
            int i3 = min + i;
            int i4 = 0;
            while (i < i3) {
                i++;
                int i5 = bArr[i] & 255;
                int i6 = i4 + 1;
                byte[] bArr3 = this.a;
                bArr2[i4] = bArr3[i5 >>> 4];
                i4 = i6 + 1;
                bArr2[i6] = bArr3[i5 & 15];
            }
            outputStream.write(bArr2, 0, i4 + 0);
            i2 -= min;
            i = i3;
        }
        return i2 * 2;
    }

    public byte[] c(String str, int i, int i2) throws IOException {
        Objects.requireNonNull(str, "'str' cannot be null");
        if (i < 0 || i2 < 0 || i > str.length() - i2) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        } else if ((i2 & 1) == 0) {
            int i3 = i2 >>> 1;
            byte[] bArr = new byte[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i + 1;
                byte b = this.b[str.charAt(i)];
                i = i5 + 1;
                int i6 = (b << 4) | this.b[str.charAt(i5)];
                if (i6 >= 0) {
                    bArr[i4] = (byte) i6;
                } else {
                    throw new IOException("invalid characters encountered in Hex string");
                }
            }
            return bArr;
        } else {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
    }
}
