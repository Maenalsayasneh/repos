package h0.v.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class y extends RecyclerView.k {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    public boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView.b0 b0Var);

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean animateAppearance(RecyclerView.b0 b0Var, RecyclerView.k.c cVar, RecyclerView.k.c cVar2) {
        int i;
        int i2;
        if (cVar == null || ((i = cVar.a) == (i2 = cVar2.a) && cVar.b == cVar2.b)) {
            return animateAdd(b0Var);
        }
        return animateMove(b0Var, i, cVar.b, i2, cVar2.b);
    }

    public abstract boolean animateChange(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean animateChange(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, RecyclerView.k.c cVar, RecyclerView.k.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (b0Var2.shouldIgnore()) {
            int i5 = cVar.a;
            i = cVar.b;
            i2 = i5;
        } else {
            int i6 = cVar2.a;
            i = cVar2.b;
            i2 = i6;
        }
        return animateChange(b0Var, b0Var2, i3, i4, i2, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean animateDisappearance(RecyclerView.b0 b0Var, RecyclerView.k.c cVar, RecyclerView.k.c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = b0Var.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (b0Var.isRemoved() || (i == left && i2 == top)) {
            return animateRemove(b0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return animateMove(b0Var, i, i2, left, top);
    }

    public abstract boolean animateMove(RecyclerView.b0 b0Var, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean animatePersistence(RecyclerView.b0 b0Var, RecyclerView.k.c cVar, RecyclerView.k.c cVar2) {
        int i = cVar.a;
        int i2 = cVar2.a;
        if (i != i2 || cVar.b != cVar2.b) {
            return animateMove(b0Var, i, cVar.b, i2, cVar2.b);
        }
        dispatchMoveFinished(b0Var);
        return false;
    }

    public abstract boolean animateRemove(RecyclerView.b0 b0Var);

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean canReuseUpdatedViewHolder(RecyclerView.b0 b0Var) {
        return !this.mSupportsChangeAnimations || b0Var.isInvalid();
    }

    public final void dispatchAddFinished(RecyclerView.b0 b0Var) {
        onAddFinished(b0Var);
        dispatchAnimationFinished(b0Var);
    }

    public final void dispatchAddStarting(RecyclerView.b0 b0Var) {
        onAddStarting(b0Var);
    }

    public final void dispatchChangeFinished(RecyclerView.b0 b0Var, boolean z) {
        onChangeFinished(b0Var, z);
        dispatchAnimationFinished(b0Var);
    }

    public final void dispatchChangeStarting(RecyclerView.b0 b0Var, boolean z) {
        onChangeStarting(b0Var, z);
    }

    public final void dispatchMoveFinished(RecyclerView.b0 b0Var) {
        onMoveFinished(b0Var);
        dispatchAnimationFinished(b0Var);
    }

    public final void dispatchMoveStarting(RecyclerView.b0 b0Var) {
        onMoveStarting(b0Var);
    }

    public final void dispatchRemoveFinished(RecyclerView.b0 b0Var) {
        onRemoveFinished(b0Var);
        dispatchAnimationFinished(b0Var);
    }

    public final void dispatchRemoveStarting(RecyclerView.b0 b0Var) {
        onRemoveStarting(b0Var);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void onAddFinished(RecyclerView.b0 b0Var) {
    }

    public void onAddStarting(RecyclerView.b0 b0Var) {
    }

    public void onChangeFinished(RecyclerView.b0 b0Var, boolean z) {
    }

    public void onChangeStarting(RecyclerView.b0 b0Var, boolean z) {
    }

    public void onMoveFinished(RecyclerView.b0 b0Var) {
    }

    public void onMoveStarting(RecyclerView.b0 b0Var) {
    }

    public void onRemoveFinished(RecyclerView.b0 b0Var) {
    }

    public void onRemoveStarting(RecyclerView.b0 b0Var) {
    }

    public void setSupportsChangeAnimations(boolean z) {
        this.mSupportsChangeAnimations = z;
    }
}
