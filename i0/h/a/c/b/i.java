package i0.h.a.c.b;

import android.view.View;
import h0.i.i.q;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes2.dex */
public class i {
    public final View a;
    public int b;
    public int c;
    public int d;
    public int e;

    public i(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        int top = this.d - (view.getTop() - this.b);
        AtomicInteger atomicInteger = q.a;
        view.offsetTopAndBottom(top);
        View view2 = this.a;
        view2.offsetLeftAndRight(this.e - (view2.getLeft() - this.c));
    }
}
