package com.instabug.crash.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
/* compiled from: PersistableSettings.java */
/* loaded from: classes2.dex */
public class c {
    public static c a;
    public SharedPreferences b;

    public c(Context context) {
        this.b = context.getSharedPreferences("instabug_crash", 0);
    }

    public static c a() {
        if (a == null && Instabug.getApplicationContext() != null) {
            a = new c(Instabug.getApplicationContext());
        }
        return a;
    }
}
