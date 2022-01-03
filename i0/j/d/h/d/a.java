package i0.j.d.h.d;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.instabug.featuresrequest.ui.custom.IbFrRippleView;
/* compiled from: IbFrRippleView.java */
/* loaded from: classes2.dex */
public class a extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ IbFrRippleView a;

    public a(IbFrRippleView ibFrRippleView) {
        this.a = ibFrRippleView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        super.onLongPress(motionEvent);
        this.a.a(motionEvent);
        this.a.b(Boolean.TRUE);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
