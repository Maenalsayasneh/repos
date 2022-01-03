package i0.g.a.d;

import android.content.Context;
import com.futuremind.recyclerviewfastscroll.FastScroller;
import com.hbb20.R;
/* compiled from: ScrollerViewProvider.java */
/* loaded from: classes2.dex */
public abstract class c {
    public FastScroller a;
    public a b;

    public a a() {
        if (this.b == null) {
            this.b = new a(new d(((b) this).c, R.animator.fastscroll__default_show, R.animator.fastscroll__default_hide, 1.0f, 1.0f, 1000));
        }
        return this.b;
    }

    public Context b() {
        return this.a.getContext();
    }

    public a c() {
        return null;
    }
}
