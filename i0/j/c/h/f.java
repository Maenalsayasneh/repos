package i0.j.c.h;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import i0.j.c.h.a;
/* compiled from: NotificationBarInvoker.java */
/* loaded from: classes2.dex */
public class f implements Runnable {
    public final /* synthetic */ Activity c;
    public final /* synthetic */ FrameLayout.LayoutParams d;
    public final /* synthetic */ a.f q;
    public final /* synthetic */ a x;

    public f(a aVar, Activity activity, FrameLayout.LayoutParams layoutParams, a.f fVar) {
        this.x = aVar;
        this.c = activity;
        this.d = layoutParams;
        this.q = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.x.a.getParent() != null) {
            ((ViewGroup) this.x.a.getParent()).removeView(this.x.a);
        }
        ((ViewGroup) this.c.getWindow().getDecorView()).addView(this.x.a, this.d);
        this.x.a.postDelayed(this.q, 100);
    }
}
