package m0.r.t.a.r.k.b.v;

import java.io.InputStream;
import m0.n.b.i;
/* compiled from: BuiltInsResourceLoader.kt */
/* loaded from: classes4.dex */
public final class c {
    public final InputStream a(String str) {
        i.e(str, "path");
        ClassLoader classLoader = c.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
