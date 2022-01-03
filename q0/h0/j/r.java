package q0.h0.j;

import com.google.android.gms.recaptcha.RecaptchaActionType;
import m0.n.b.i;
/* compiled from: Settings.kt */
/* loaded from: classes4.dex */
public final class r {
    public int a;
    public final int[] b = new int[10];

    public final int a() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public final void b(r rVar) {
        i.e(rVar, RecaptchaActionType.OTHER);
        for (int i = 0; i < 10; i++) {
            boolean z = true;
            if (((1 << i) & rVar.a) == 0) {
                z = false;
            }
            if (z) {
                c(i, rVar.b[i]);
            }
        }
    }

    public final r c(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.a = (1 << i) | this.a;
                iArr[i] = i2;
            }
        }
        return this;
    }
}
