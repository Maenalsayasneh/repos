package h0.z.a;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
public class f extends Animation {
    public final /* synthetic */ SwipeRefreshLayout c;

    public f(SwipeRefreshLayout swipeRefreshLayout) {
        this.c = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.c;
        float f2 = swipeRefreshLayout.s2;
        swipeRefreshLayout.setAnimationProgress(((-f2) * f) + f2);
        this.c.g(f);
    }
}
