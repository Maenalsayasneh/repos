package i0.j.f.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
/* compiled from: PersistableSettings.java */
/* loaded from: classes2.dex */
public class b {
    public static b a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;

    @SuppressLint({"CommitPrefEdits"})
    public b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("instabug_survey", 0);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public static b b() {
        Context applicationContext;
        if (a == null && (applicationContext = Instabug.getApplicationContext()) != null) {
            a = new b(applicationContext);
        }
        return a;
    }

    public void a(long j) {
        this.c.putLong("last_survey_time", j);
        this.c.apply();
    }
}
