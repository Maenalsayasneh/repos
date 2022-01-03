package com.stripe.android.paymentsheet.ui;

import com.stripe.android.R;
import kotlin.Metadata;
/* compiled from: AnimationConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/AnimationConstants;", "", "", "FADE_OUT", "I", "getFADE_OUT", "()I", "FADE_IN", "getFADE_IN", "<init>", "()V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class AnimationConstants {
    public static final AnimationConstants INSTANCE = new AnimationConstants();
    private static final int FADE_IN = R.anim.stripe_paymentsheet_transition_fade_in;
    private static final int FADE_OUT = R.anim.stripe_paymentsheet_transition_fade_out;

    private AnimationConstants() {
    }

    public final int getFADE_IN() {
        return FADE_IN;
    }

    public final int getFADE_OUT() {
        return FADE_OUT;
    }
}
