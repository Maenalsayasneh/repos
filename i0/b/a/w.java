package i0.b.a;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.ViewHolderState;
import i0.d.a.a.a;
import java.util.List;
import java.util.Objects;
/* compiled from: EpoxyViewHolder.java */
/* loaded from: classes.dex */
public class w extends RecyclerView.b0 {
    public t a;
    public List<Object> b;
    public r c;
    public ViewHolderState.ViewState d;
    public ViewParent e;

    public w(ViewParent viewParent, View view, boolean z) {
        super(view);
        this.e = viewParent;
        if (z) {
            ViewHolderState.ViewState viewState = new ViewHolderState.ViewState();
            this.d = viewState;
            viewState.d(this.itemView);
        }
    }

    public final void a() {
        if (this.a == null) {
            throw new IllegalStateException("This holder is not currently bound.");
        }
    }

    public void b(t tVar, t<?> tVar2, List<Object> list, int i) {
        this.b = list;
        if (this.c == null && (tVar instanceof u)) {
            r E = ((u) tVar).E(this.e);
            this.c = E;
            E.a(this.itemView);
        }
        this.e = null;
        if (tVar instanceof z) {
            ((z) tVar).g(this, c(), i);
        }
        Objects.requireNonNull(tVar);
        if (tVar2 != null) {
            tVar.l(c(), tVar2);
        } else if (list.isEmpty()) {
            tVar.k(c());
        } else {
            tVar.m(c(), list);
        }
        if (tVar instanceof z) {
            ((z) tVar).c(c(), i);
        }
        this.a = tVar;
    }

    public Object c() {
        r rVar = this.c;
        return rVar != null ? rVar : this.itemView;
    }

    public void d(int i) {
        a();
        this.a.A(i, c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0
    public String toString() {
        StringBuilder P0 = a.P0("EpoxyViewHolder{epoxyModel=");
        P0.append(this.a);
        P0.append(", view=");
        P0.append(this.itemView);
        P0.append(", super=");
        return a.x0(P0, super.toString(), '}');
    }
}
