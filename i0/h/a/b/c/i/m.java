package i0.h.a.b.c.i;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class m {
    public static m a;
    public static final RootTelemetryConfiguration b = new RootTelemetryConfiguration(0, false, false, 0, 0);
    public RootTelemetryConfiguration c;

    @RecentlyNonNull
    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m();
            }
            mVar = a;
        }
        return mVar;
    }
}
