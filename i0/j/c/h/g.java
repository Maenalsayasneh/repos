package i0.j.c.h;

import android.app.Activity;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
/* compiled from: NotificationBarInvoker.java */
/* loaded from: classes2.dex */
public class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ Activity c;
    public final /* synthetic */ a d;

    public g(a aVar, Activity activity) {
        this.d = aVar;
        this.c = activity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.c.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = this.c.getWindow().getDecorView().getRootView().getHeight();
        if (((double) (height - rect.bottom)) > ((double) height) * 0.15d) {
            this.d.c = true;
            return;
        }
        a aVar = this.d;
        aVar.c = false;
        if (aVar.d && !aVar.b) {
            a.b(aVar, this.c);
        }
    }
}
