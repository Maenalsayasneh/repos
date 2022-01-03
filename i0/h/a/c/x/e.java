package i0.h.a.c.x;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes2.dex */
public class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public e(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.f.setScaleX(floatValue);
        this.a.f.setScaleY(floatValue);
    }
}
