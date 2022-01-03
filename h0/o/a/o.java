package h0.o.a;

import android.animation.Animator;
import android.view.animation.Animation;
/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
public class o {
    public final Animation a;
    public final Animator b;

    public o(Animation animation) {
        this.a = animation;
        this.b = null;
    }

    public o(Animator animator) {
        this.a = null;
        this.b = animator;
    }
}
