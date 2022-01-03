package h0.d.a;

import android.os.Bundle;
/* compiled from: CustomTabColorSchemeParams.java */
/* loaded from: classes.dex */
public final class a {
    public final Integer a;

    public a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.a = num;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        return bundle;
    }
}
