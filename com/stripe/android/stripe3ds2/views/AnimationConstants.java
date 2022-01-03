package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.R;
import kotlin.Metadata;
/* compiled from: AnimationConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/AnimationConstants;", "", "", "SLIDE_OUT", "I", "getSLIDE_OUT", "()I", "SLIDE_IN", "getSLIDE_IN", "<init>", "()V", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class AnimationConstants {
    public static final AnimationConstants INSTANCE = new AnimationConstants();
    private static final int SLIDE_IN = R.anim.stripe_3ds2_challenge_transition_slide_in;
    private static final int SLIDE_OUT = R.anim.stripe_3ds2_challenge_transition_slide_out;

    private AnimationConstants() {
    }

    public final int getSLIDE_IN() {
        return SLIDE_IN;
    }

    public final int getSLIDE_OUT() {
        return SLIDE_OUT;
    }
}
