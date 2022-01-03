package i0.j.d.h.d;

import android.view.MotionEvent;
import android.view.View;
/* compiled from: InstaToast.java */
/* loaded from: classes2.dex */
public class e implements View.OnTouchListener {
    public final /* synthetic */ d c;

    public e(d dVar) {
        this.c = dVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.c.b(3);
        return false;
    }
}
