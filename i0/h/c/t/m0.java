package i0.h.c.t;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final class m0 {
    public final SharedPreferences a;
    public final Executor e;
    public final ArrayDeque<String> d = new ArrayDeque<>();
    public final String b = "topic_operation_queue";
    public final String c = InstabugDbContract.COMMA_SEP;

    public m0(SharedPreferences sharedPreferences, String str, Executor executor) {
        this.a = sharedPreferences;
        this.e = executor;
    }

    public static m0 a(SharedPreferences sharedPreferences, String str, Executor executor) {
        m0 m0Var = new m0(sharedPreferences, "topic_operation_queue", executor);
        synchronized (m0Var.d) {
            m0Var.d.clear();
            String string = m0Var.a.getString(m0Var.b, "");
            if (!TextUtils.isEmpty(string) && string.contains(m0Var.c)) {
                String[] split = string.split(m0Var.c, -1);
                int length = split.length;
                if (length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        m0Var.d.add(str2);
                    }
                }
            }
        }
        return m0Var;
    }
}
