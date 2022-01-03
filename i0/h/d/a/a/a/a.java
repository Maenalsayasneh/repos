package i0.h.d.a.a.a;
/* compiled from: PercentEscaper.java */
/* loaded from: classes2.dex */
public class a extends b {
    public static final char[] b = {'+'};
    public static final char[] c = "0123456789ABCDEF".toCharArray();
    public final boolean d;
    public final boolean[] e;

    public a(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (z && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        } else if (!str.contains("%")) {
            this.d = z;
            char[] charArray = str.toCharArray();
            int i = 122;
            for (char c2 : charArray) {
                i = Math.max((int) c2, i);
            }
            boolean[] zArr = new boolean[i + 1];
            for (int i2 = 48; i2 <= 57; i2++) {
                zArr[i2] = true;
            }
            for (int i3 = 65; i3 <= 90; i3++) {
                zArr[i3] = true;
            }
            for (int i4 = 97; i4 <= 122; i4++) {
                zArr[i4] = true;
            }
            for (char c3 : charArray) {
                zArr[c3] = true;
            }
            this.e = zArr;
        } else {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
    }
}
