package h0.i.f;

import android.util.Base64;
import i0.d.a.a.a;
import java.util.List;
import java.util.Objects;
/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final List<List<byte[]>> d;
    public final int e;
    public final String f;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        Objects.requireNonNull(list);
        this.d = list;
        this.e = 0;
        this.f = str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder P0 = a.P0("FontRequest {mProviderAuthority: ");
        P0.append(this.a);
        P0.append(", mProviderPackage: ");
        P0.append(this.b);
        P0.append(", mQuery: ");
        P0.append(this.c);
        P0.append(", mCertificates:");
        sb.append(P0.toString());
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }

    public e(String str, String str2, String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = null;
        if (i != 0) {
            this.e = i;
            this.f = str + "-" + str2 + "-" + str3;
            return;
        }
        throw new IllegalArgumentException();
    }
}
