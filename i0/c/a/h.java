package i0.c.a;
/* compiled from: AmplitudeClient.java */
/* loaded from: classes.dex */
public class h implements Runnable {
    public final /* synthetic */ f c;

    public h(f fVar) {
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.H.set(false);
        this.c.t(true);
    }
}
