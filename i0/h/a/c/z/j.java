package i0.h.a.c.z;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes2.dex */
public class j implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView c;
    public final /* synthetic */ h d;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.d = hVar;
        this.c = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.d.i()) {
                this.d.i = false;
            }
            h.g(this.d, this.c);
        }
        return false;
    }
}
