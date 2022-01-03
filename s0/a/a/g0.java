package s0.a.a;

import java.io.IOException;
/* loaded from: classes4.dex */
public class g0 extends s {
    public g0() {
    }

    public g0(e eVar) {
        super(eVar);
    }

    public g0(f fVar) {
        super(fVar);
    }

    public g0(e[] eVarArr) {
        super(eVarArr);
    }

    @Override // s0.a.a.r
    public void t(q qVar, boolean z) throws IOException {
        qVar.h(z, 48, this.c);
    }

    @Override // s0.a.a.r
    public int u() throws IOException {
        int length = this.c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += this.c[i2].c().u();
        }
        return i + 2 + 2;
    }
}
