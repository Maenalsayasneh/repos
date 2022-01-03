package i0.j.e.y.a;

import android.content.res.Configuration;
import com.instabug.library.core.eventbus.EventBus;
/* compiled from: CurrentActivityConfigurationChange.java */
/* loaded from: classes2.dex */
public class a extends EventBus<a> {
    public static a a;
    public Configuration b;

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }
}
