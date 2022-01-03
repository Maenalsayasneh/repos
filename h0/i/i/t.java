package h0.i.i;

import android.text.TextUtils;
import android.view.View;
import h0.i.i.q;
/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class t extends q.b<CharSequence> {
    public t(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    @Override // h0.i.i.q.b
    public CharSequence b(View view) {
        return view.getStateDescription();
    }

    @Override // h0.i.i.q.b
    public void c(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }

    @Override // h0.i.i.q.b
    public boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
