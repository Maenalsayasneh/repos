package h0.z.a;

import android.animation.ValueAnimator;
import h0.z.a.d;
/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ d b;

    public b(d dVar, d.a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.b.d(floatValue, this.a);
        this.b.a(floatValue, this.a, false);
        this.b.invalidateSelf();
    }
}
