package h0.o.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
public class p extends AnimationSet implements Runnable {
    public final ViewGroup c;
    public final View d;
    public boolean q;
    public boolean x;
    public boolean y = true;

    public p(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.c = viewGroup;
        this.d = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        this.y = true;
        if (this.q) {
            return !this.x;
        }
        if (!super.getTransformation(j, transformation)) {
            this.q = true;
            h0.i.i.p.a(this.c, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.q || !this.y) {
            this.c.endViewTransition(this.d);
            this.x = true;
            return;
        }
        this.y = false;
        this.c.post(this);
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation, float f) {
        this.y = true;
        if (this.q) {
            return !this.x;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.q = true;
            h0.i.i.p.a(this.c, this);
        }
        return true;
    }
}
