package h0.b.f;

import android.widget.PopupWindow;
import java.util.Objects;
/* compiled from: PopupMenu.java */
/* loaded from: classes.dex */
public class l0 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ m0 c;

    public l0(m0 m0Var) {
        this.c = m0Var;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Objects.requireNonNull(this.c);
    }
}
