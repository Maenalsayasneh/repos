package i0.g.a.d;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
/* compiled from: VisibilityAnimationManager.java */
/* loaded from: classes2.dex */
public class d {
    public final View a;
    public AnimatorSet b;
    public AnimatorSet c;
    public float d;
    public float e;

    /* compiled from: VisibilityAnimationManager.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ View b;

        public a(d dVar, View view) {
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.a) {
                this.b.setVisibility(4);
            }
            this.a = false;
        }
    }

    public d(View view, int i, int i2, float f, float f2, int i3) {
        this.a = view;
        this.d = f;
        this.e = f2;
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), i2);
        this.b = animatorSet;
        animatorSet.setStartDelay((long) i3);
        this.b.setTarget(view);
        AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), i);
        this.c = animatorSet2;
        animatorSet2.setTarget(view);
        this.b.addListener(new a(this, view));
        a();
    }

    public void a() {
        View view = this.a;
        view.setPivotX(this.d * ((float) view.getMeasuredWidth()));
        View view2 = this.a;
        view2.setPivotY(this.e * ((float) view2.getMeasuredHeight()));
    }
}
