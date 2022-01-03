package i0.h.a.b.i;

import com.google.android.gms.common.Feature;
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public final class b {
    public static final Feature a;
    public static final Feature b;
    public static final Feature c;
    public static final Feature d;
    public static final Feature[] e;

    static {
        Feature feature = new Feature("verify_with_recaptcha_v2_internal", 1);
        a = feature;
        Feature feature2 = new Feature("init", 2);
        b = feature2;
        Feature feature3 = new Feature("execute", 4);
        c = feature3;
        Feature feature4 = new Feature("close", 2);
        d = feature4;
        e = new Feature[]{feature, feature2, feature3, feature4};
    }
}
