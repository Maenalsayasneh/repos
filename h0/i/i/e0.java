package h0.i.i;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import h0.i.i.f0;
/* compiled from: WindowInsetsControllerCompat.java */
/* loaded from: classes.dex */
public class e0 implements Runnable {
    public final /* synthetic */ View c;

    public e0(f0.a aVar, View view) {
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.c.getContext().getSystemService("input_method")).showSoftInput(this.c, 0);
    }
}
