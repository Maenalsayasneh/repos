package i0.h.a.c.z;

import android.widget.AutoCompleteTextView;
/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes2.dex */
public class k implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        h hVar = this.a;
        hVar.i = true;
        hVar.k = System.currentTimeMillis();
        h.f(this.a, false);
    }
}
