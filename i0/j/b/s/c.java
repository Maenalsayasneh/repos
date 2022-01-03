package i0.j.b.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
/* compiled from: PersistableSettings.java */
/* loaded from: classes2.dex */
public class c {
    public static c a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;

    public c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("instabug_bug_reporting", 0);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                Context applicationContext = Instabug.getApplicationContext();
                synchronized (c.class) {
                    a = new c(applicationContext);
                }
            }
            cVar = a;
        }
        return cVar;
    }
}
