package i0.j.e.l0.m;

import android.content.Context;
import android.widget.MediaController;
/* compiled from: InstabugMediaController.java */
/* loaded from: classes2.dex */
public class h extends MediaController {
    public final a c;

    /* compiled from: InstabugMediaController.java */
    /* loaded from: classes2.dex */
    public interface a {
        void isVisible(boolean z);
    }

    public h(Context context, a aVar) {
        super(context);
        this.c = aVar;
    }

    @Override // android.widget.MediaController
    public void hide() {
        super.hide();
        a aVar = this.c;
        if (aVar != null) {
            aVar.isVisible(false);
        }
    }

    @Override // android.widget.MediaController
    public void show() {
        super.show();
        a aVar = this.c;
        if (aVar != null) {
            aVar.isVisible(true);
        }
    }
}
