package i0.j.e.z0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.settings.SettingsManager;
/* compiled from: PersistableSettings.java */
/* loaded from: classes2.dex */
public class b {
    public static b a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;

    @SuppressLint({"CommitPrefEdits"})
    public b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
        this.b.edit().remove("ib_app_token").apply();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            Context applicationContext = Instabug.getApplicationContext();
            if (a == null && applicationContext != null) {
                a = new b(applicationContext);
            }
            bVar = a;
        }
        return bVar;
    }
}
