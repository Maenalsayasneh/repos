package i0.j.b.t;

import android.graphics.drawable.AnimationDrawable;
/* compiled from: AttachmentsAdapter.java */
/* loaded from: classes2.dex */
public class a implements Runnable {
    public final /* synthetic */ AnimationDrawable c;

    public a(AnimationDrawable animationDrawable) {
        this.c = animationDrawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.start();
    }
}
