package k0.c.x;

import io.sentry.cache.CacheStrategy;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Comparator {
    public static final /* synthetic */ a c = new a();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Charset charset = CacheStrategy.UTF_8;
        return Long.compare(((File) obj).lastModified(), ((File) obj2).lastModified());
    }
}
