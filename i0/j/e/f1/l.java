package i0.j.e.f1;

import java.util.concurrent.Callable;
/* compiled from: VisualUserSteps.java */
/* loaded from: classes2.dex */
public class l implements Callable<Boolean> {
    public final /* synthetic */ String c;
    public final /* synthetic */ m d;

    public l(m mVar, String str) {
        this.d = mVar;
        this.c = str;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        return Boolean.valueOf(m.a(this.d, this.c));
    }
}
