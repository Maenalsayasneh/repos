package i0.h.a.c.x;

import android.animation.ValueAnimator;
import android.os.Handler;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes2.dex */
public class i implements ValueAnimator.AnimatorUpdateListener {
    public int a = 0;
    public final /* synthetic */ BaseTransientBottomBar b;

    public i(BaseTransientBottomBar baseTransientBottomBar) {
        this.b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.a;
        this.b.f.setTranslationY((float) intValue);
        this.a = intValue;
    }
}
