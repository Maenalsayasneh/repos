package i0.l.a.j;
/* compiled from: Base64Codec.java */
/* loaded from: classes2.dex */
public final class a {
    public static byte a(int i) {
        int d = d(i, 26);
        int c = c(i, 25) & d(i, 52);
        int c2 = c(i, 51) & d(i, 62);
        int b = b(i, 62);
        int b2 = b(i, 63);
        return (byte) (e(c2, (i - 52) + 48, 0) | e(d, i + 0 + 65, 0) | e(c, (i - 26) + 97, 0) | e(b, 45, 0) | e(b2, 95, 0));
    }

    public static int b(int i, int i2) {
        int i3 = i ^ i2;
        return ((~i3) & (i3 - 1)) >>> 63;
    }

    public static int c(int i, int i2) {
        return (int) ((((long) i2) - ((long) i)) >>> 63);
    }

    public static int d(int i, int i2) {
        return (int) ((((long) i) - ((long) i2)) >>> 63);
    }

    public static int e(int i, int i2, int i3) {
        return ((i - 1) & (i3 ^ i2)) ^ i2;
    }
}
