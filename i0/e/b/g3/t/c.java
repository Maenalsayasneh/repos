package i0.e.b.g3.t;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import m0.n.b.i;
/* compiled from: ViewUtil.kt */
/* loaded from: classes3.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View c;
    public final /* synthetic */ View d;
    public final /* synthetic */ View q;

    public c(View view, View view2, View view3) {
        this.c = view;
        this.d = view2;
        this.q = view3;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.c.getMeasuredWidth() > 0 && this.c.getMeasuredHeight() > 0) {
            this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            View view = this.d;
            View view2 = this.q;
            i.e(view2, "<this>");
            int[] iArr = {0, 0};
            view2.getLocationOnScreen(iArr);
            view.setPivotX((((float) view2.getWidth()) / 2.0f) + ((float) iArr[0]));
            View view3 = this.d;
            view3.setPivotY((float) view3.getHeight());
            this.d.animate().setInterpolator(new DecelerateInterpolator()).scaleX(1.0f).scaleY(1.0f).start();
        }
    }
}
