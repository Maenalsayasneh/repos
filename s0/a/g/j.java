package s0.a.g;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Vector;
/* loaded from: classes4.dex */
public final class j {
    public static String a;

    /* loaded from: classes4.dex */
    public static class a implements PrivilegedAction<String> {
        @Override // java.security.PrivilegedAction
        public String run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        try {
            try {
                a = (String) AccessController.doPrivileged(new a());
            } catch (Exception unused) {
                a = String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
            a = "\n";
        }
    }

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    public static String[] b(String str, char c) {
        int i;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int indexOf = str.indexOf(c);
            if (indexOf > 0) {
                vector.addElement(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    public static byte[] c(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String d(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) ((c - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static void e(char[] cArr, OutputStream outputStream) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        while (i5 < cArr.length) {
            char c = cArr[i5];
            if (c >= 128) {
                if (c < 2048) {
                    i = (c >> 6) | 192;
                    i2 = c;
                } else {
                    if (c < 55296 || c > 57343) {
                        i3 = (c >> 12) | 224;
                        i4 = c;
                    } else {
                        i5++;
                        if (i5 < cArr.length) {
                            char c2 = cArr[i5];
                            if (c <= 56319) {
                                int i6 = (((c & 1023) << 10) | (c2 & 1023)) + 65536;
                                outputStream.write((i6 >> 18) | 240);
                                i3 = ((i6 >> 12) & 63) | 128;
                                i4 = i6;
                            } else {
                                throw new IllegalStateException("invalid UTF-16 codepoint");
                            }
                        } else {
                            throw new IllegalStateException("invalid UTF-16 codepoint");
                        }
                    }
                    outputStream.write(i3);
                    i = ((i4 >> 6) & 63) | 128;
                    i2 = i4;
                }
                outputStream.write(i);
                c = ((i2 == 1 ? 1 : 0) & 63) | 128;
            }
            outputStream.write(c == true ? 1 : 0);
            i5++;
        }
    }

    public static byte[] f(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e(cArr, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public static String g(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) ((c - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}
