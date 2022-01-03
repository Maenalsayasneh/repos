package i0.h.a.c.x;

import android.animation.ValueAnimator;
import android.os.Handler;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes2.dex */
public class g implements ValueAnimator.AnimatorUpdateListener {
    public int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BaseTransientBottomBar c;

    public g(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.c = baseTransientBottomBar;
        this.b = i;
        this.a = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.a;
        this.c.f.setTranslationY((float) intValue);
        this.a = intValue;
    }
}
