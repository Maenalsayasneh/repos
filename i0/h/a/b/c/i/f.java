package i0.h.a.b.c.i;

import androidx.annotation.RecentlyNonNull;
import h0.b0.v;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class f {
    public f(@RecentlyNonNull String str) {
        v.A(str, "log tag cannot be null");
        v.v(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
    }
}
