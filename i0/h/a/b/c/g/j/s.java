package i0.h.a.b.c.g.j;

import i0.h.a.b.c.g.j.f;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes2.dex */
public final class s implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ f.a d;

    public s(f.a aVar, int i) {
        this.d = aVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.c(this.c);
    }
}
