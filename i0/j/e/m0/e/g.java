package i0.j.e.m0.e;

import android.view.animation.Animation;
import android.widget.ListView;
/* compiled from: InstabugDialogFragment.java */
/* loaded from: classes2.dex */
public class g implements Animation.AnimationListener {
    public final /* synthetic */ ListView c;

    public g(ListView listView) {
        this.c = listView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.c.setVerticalScrollBarEnabled(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.c.setVerticalScrollBarEnabled(false);
    }
}
