package i0.h.c.t;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import i0.h.a.b.l.a;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final class u0 {
    public static final long a = TimeUnit.MINUTES.toMillis(1);
    public static final Object b = new Object();
    public static a c;

    public static ComponentName a(Context context, Intent intent) {
        synchronized (b) {
            if (c == null) {
                a aVar = new a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                c = aVar;
                aVar.c.setReferenceCounted(true);
                aVar.h = true;
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!booleanExtra) {
                c.a(a);
            }
            return startService;
        }
    }
}
