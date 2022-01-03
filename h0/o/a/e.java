package h0.o.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import h0.o.a.b;
/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ View d;
    public final /* synthetic */ b.C0089b q;

    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.c.endViewTransition(eVar.d);
            e.this.q.a();
        }
    }

    public e(b bVar, ViewGroup viewGroup, View view, b.C0089b bVar2) {
        this.c = viewGroup;
        this.d = view;
        this.q = bVar2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.c.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
