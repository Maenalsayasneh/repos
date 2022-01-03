package i0.h.c.r;

import android.text.TextUtils;
import i0.h.c.r.p.c;
import i0.h.c.r.r.a;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public final class n {
    public static final long a = TimeUnit.HOURS.toSeconds(1);
    public static final Pattern b = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static n c;
    public final a d;

    public n(a aVar) {
        this.d = aVar;
    }

    public static n c() {
        if (a.a == null) {
            a.a = new a();
        }
        a aVar = a.a;
        if (c == null) {
            c = new n(aVar);
        }
        return c;
    }

    public long a() {
        Objects.requireNonNull(this.d);
        return System.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public boolean d(c cVar) {
        if (TextUtils.isEmpty(cVar.a())) {
            return true;
        }
        if (cVar.b() + cVar.g() < b() + a) {
            return true;
        }
        return false;
    }
}
