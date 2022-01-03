package h0.i.i;

import android.view.View;
import h0.i.i.q;
/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class u extends q.b<Boolean> {
    public u(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // h0.i.i.q.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    @Override // h0.i.i.q.b
    public void c(View view, Boolean bool) {
        view.setAccessibilityHeading(bool.booleanValue());
    }

    @Override // h0.i.i.q.b
    public boolean f(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
