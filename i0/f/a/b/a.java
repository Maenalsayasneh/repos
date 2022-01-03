package i0.f.a.b;

import com.fasterxml.jackson.core.Base64Variant;
/* compiled from: Base64Variants.java */
/* loaded from: classes2.dex */
public final class a {
    public static final Base64Variant a;
    public static final Base64Variant b;

    static {
        Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        a = base64Variant;
        b = new Base64Variant(base64Variant, "MIME-NO-LINEFEEDS", true, '=', Integer.MAX_VALUE);
        byte[] bArr = base64Variant.q;
        System.arraycopy(bArr, 0, new byte[64], 0, bArr.length);
        char[] cArr = base64Variant.d;
        System.arraycopy(cArr, 0, new char[64], 0, cArr.length);
        int[] iArr = base64Variant.c;
        System.arraycopy(iArr, 0, new int[128], 0, iArr.length);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf("+"), '-');
        sb.setCharAt(sb.indexOf("/"), '_');
        new Base64Variant("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }
}
