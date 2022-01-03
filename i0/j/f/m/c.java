package i0.j.f.m;
/* compiled from: AutoShowingManager.java */
/* loaded from: classes2.dex */
public class c {
    public static c a;
    public Runnable b;
    public Runnable c;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }
}
