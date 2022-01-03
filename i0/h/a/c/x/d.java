package i0.h.a.c.x;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes2.dex */
public class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public d(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
