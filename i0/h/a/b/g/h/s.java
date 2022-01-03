package i0.h.a.b.g.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public class s {
    public static volatile s a;
    public static final s b = new s(true);
    public final Map<?, ?> c;

    public s() {
        new HashMap();
    }

    public static s a() {
        s sVar = a;
        if (sVar == null) {
            synchronized (s.class) {
                sVar = a;
                if (sVar == null) {
                    sVar = b;
                    a = sVar;
                }
            }
        }
        return sVar;
    }

    public s(boolean z) {
        this.c = Collections.emptyMap();
    }
}
