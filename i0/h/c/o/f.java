package i0.h.c.o;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: HeartBeatInfoStorage.java */
/* loaded from: classes2.dex */
public class f {
    public static f a;
    public static final SimpleDateFormat b = new SimpleDateFormat("dd/MM/yyyy z");
    public final SharedPreferences c;

    public f(Context context) {
        this.c = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
        context.getSharedPreferences("FirebaseAppHeartBeatStorage", 0);
    }

    public synchronized boolean a(String str, long j) {
        if (this.c.contains(str)) {
            Date date = new Date(this.c.getLong(str, -1));
            Date date2 = new Date(j);
            SimpleDateFormat simpleDateFormat = b;
            if (!(!simpleDateFormat.format(date).equals(simpleDateFormat.format(date2)))) {
                return false;
            }
            this.c.edit().putLong(str, j).apply();
            return true;
        }
        this.c.edit().putLong(str, j).apply();
        return true;
    }
}
