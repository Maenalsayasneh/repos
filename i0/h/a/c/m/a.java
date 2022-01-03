package i0.h.a.c.m;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* compiled from: InsetDialogOnTouchListener.java */
/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {
    public final Dialog c;
    public final int d;
    public final int q;
    public final int x;

    public a(Dialog dialog, Rect rect) {
        this.c = dialog;
        this.d = rect.left;
        this.q = rect.top;
        this.x = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.d;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.q;
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.x;
            obtain.setLocation((float) ((-i) - 1), (float) ((-i) - 1));
        }
        view.performClick();
        return this.c.onTouchEvent(obtain);
    }
}
