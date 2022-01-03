package o0.a.a;

import java.util.regex.Pattern;
import m0.r.t.a.r.m.a1.a;
/* compiled from: CodeVerifierUtil.java */
/* loaded from: classes4.dex */
public final class h {
    public static final Pattern a = Pattern.compile("^[0-9a-zA-Z\\-\\.\\_\\~]{43,128}$");

    public static void a(String str) {
        boolean z = true;
        a.x0(43 <= str.length(), "codeVerifier length is shorter than allowed by the PKCE specification");
        if (str.length() > 128) {
            z = false;
        }
        a.x0(z, "codeVerifier length is longer than allowed by the PKCE specification");
        a.x0(a.matcher(str).matches(), "codeVerifier string contains illegal characters");
    }
}
