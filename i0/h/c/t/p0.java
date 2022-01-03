package i0.h.c.t;

import android.util.Log;
import i0.d.a.a.a;
import java.util.Arrays;
import java.util.regex.Pattern;
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final class p0 {
    public static final Pattern a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    public final String b;
    public final String c;
    public final String d;

    public p0(String str, String str2) {
        String str3;
        if (str2 == null || !str2.startsWith("/topics/")) {
            str3 = str2;
        } else {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str));
            str3 = str2.substring(8);
        }
        if (str3 == null || !a.matcher(str3).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str3, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        this.b = str3;
        this.c = str;
        this.d = a.z0(new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()), str, "!", str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        if (!this.b.equals(p0Var.b) || !this.c.equals(p0Var.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.b});
    }
}
