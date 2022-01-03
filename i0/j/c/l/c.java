package i0.j.c.l;

import android.content.SharedPreferences;
import com.instabug.library.Instabug;
/* compiled from: PersistableSettings.java */
/* loaded from: classes2.dex */
public class c {
    public static c a;
    public SharedPreferences b;

    public c(SharedPreferences sharedPreferences) {
        this.b = sharedPreferences;
    }

    public static c a() {
        if (a == null && Instabug.getApplicationContext() != null) {
            a = new c(Instabug.getApplicationContext().getSharedPreferences("com.instabug.chat", 0));
        }
        return a;
    }
}
