package i0.h.a.b.c.m;

import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class d {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
