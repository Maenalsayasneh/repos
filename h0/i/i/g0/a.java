package h0.i.i.g0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {
    public final int c;
    public final b d;
    public final int q;

    public a(int i, b bVar, int i2) {
        this.c = i;
        this.d = bVar;
        this.q = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.c);
        b bVar = this.d;
        bVar.b.performAction(this.q, bundle);
    }
}
