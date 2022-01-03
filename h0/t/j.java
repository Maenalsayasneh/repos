package h0.t;

import android.net.Uri;
import i0.d.a.a.a;
/* compiled from: NavDeepLinkRequest.java */
/* loaded from: classes.dex */
public class j {
    public final Uri a;
    public final String b;
    public final String c;

    public j(Uri uri, String str, String str2) {
        this.a = uri;
        this.b = str;
        this.c = str2;
    }

    public String toString() {
        StringBuilder S0 = a.S0("NavDeepLinkRequest", "{");
        if (this.a != null) {
            S0.append(" uri=");
            S0.append(this.a.toString());
        }
        if (this.b != null) {
            S0.append(" action=");
            S0.append(this.b);
        }
        if (this.c != null) {
            S0.append(" mimetype=");
            S0.append(this.c);
        }
        S0.append(" }");
        return S0.toString();
    }
}
