package h0.i.i;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import m0.n.b.s.a;
/* compiled from: ViewGroup.kt */
/* loaded from: classes.dex */
public final class x implements Iterator<View>, a {
    public int c;
    public final /* synthetic */ ViewGroup d;

    public x(ViewGroup viewGroup) {
        this.d = viewGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c < this.d.getChildCount();
    }

    @Override // java.util.Iterator
    public View next() {
        ViewGroup viewGroup = this.d;
        int i = this.c;
        this.c = i + 1;
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        ViewGroup viewGroup = this.d;
        int i = this.c - 1;
        this.c = i;
        viewGroup.removeViewAt(i);
    }
}
