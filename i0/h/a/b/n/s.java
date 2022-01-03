package i0.h.a.b.n;

import com.google.android.gms.common.Feature;
/* compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* loaded from: classes2.dex */
public final class s {
    public static final Feature a;
    public static final Feature b;
    public static final Feature c;
    public static final Feature d;
    public static final Feature e;
    public static final Feature f;
    public static final Feature[] g;

    static {
        Feature feature = new Feature("wallet", 1);
        a = feature;
        Feature feature2 = new Feature("wallet_biometric_auth_keys", 1);
        b = feature2;
        Feature feature3 = new Feature("wallet_payment_dynamic_update", 2);
        c = feature3;
        Feature feature4 = new Feature("wallet_1p_initialize_buyflow", 1);
        d = feature4;
        Feature feature5 = new Feature("wallet_warm_up_ui_process", 1);
        e = feature5;
        Feature feature6 = new Feature("wallet_get_setup_wizard_intent", 2);
        f = feature6;
        g = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6};
    }
}
