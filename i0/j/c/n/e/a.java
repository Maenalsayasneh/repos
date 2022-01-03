package i0.j.c.n.e;

import android.view.View;
/* compiled from: AttachmentsBottomSheetFragment.java */
/* loaded from: classes2.dex */
public class a implements Runnable {
    public final /* synthetic */ View c;

    public a(View view) {
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int height = this.c.getHeight();
        this.c.setTranslationY((float) height);
        this.c.setAlpha(1.0f);
        this.c.animate().setDuration(100).translationYBy((float) (-height));
    }
}
