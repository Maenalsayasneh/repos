package i0.g.a.d;
/* compiled from: DefaultBubbleBehavior.java */
/* loaded from: classes2.dex */
public class a {
    public final d a;

    public a(d dVar) {
        this.a = dVar;
    }

    public void a() {
        d dVar = this.a;
        dVar.b.cancel();
        if (dVar.a.getVisibility() == 4) {
            dVar.a.setVisibility(0);
            dVar.a();
            dVar.c.start();
        }
    }
}
