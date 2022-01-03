package i0.h.a.b.g.h;
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public final class p {
    public static final Class<?> a;
    public static final boolean b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        b = cls2 != null;
    }

    public static boolean a() {
        return a != null && !b;
    }
}
