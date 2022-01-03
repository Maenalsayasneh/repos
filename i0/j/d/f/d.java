package i0.j.d.f;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
/* compiled from: TextViewUtils.java */
/* loaded from: classes2.dex */
public class d extends ClickableSpan {
    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
