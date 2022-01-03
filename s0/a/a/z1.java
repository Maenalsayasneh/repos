package s0.a.a;

import java.io.InputStream;
/* loaded from: classes4.dex */
public abstract class z1 extends InputStream {
    public final InputStream c;
    public int d;

    public z1(InputStream inputStream, int i) {
        this.c = inputStream;
        this.d = i;
    }

    public void a(boolean z) {
        InputStream inputStream = this.c;
        if (inputStream instanceof w1) {
            w1 w1Var = (w1) inputStream;
            w1Var.Y1 = z;
            w1Var.b();
        }
    }
}
