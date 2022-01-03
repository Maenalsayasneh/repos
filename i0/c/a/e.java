package i0.c.a;
/* compiled from: AmplitudeClient.java */
/* loaded from: classes.dex */
public class e implements Runnable {
    public final /* synthetic */ f c;

    public e(f fVar) {
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.G.set(false);
        this.c.t(false);
    }
}
