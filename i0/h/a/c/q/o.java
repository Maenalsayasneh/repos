package i0.h.a.c.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* compiled from: VisibilityAwareImageButton.java */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class o extends ImageButton {
    public int c = getVisibility();

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.c = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.c;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.c = i;
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
