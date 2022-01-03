package s0.a.b.k0;

import java.math.BigInteger;
import s0.a.b.i;
/* loaded from: classes4.dex */
public class l0 implements i {
    public BigInteger c;
    public BigInteger d;
    public int q;

    public l0(BigInteger bigInteger, BigInteger bigInteger2) {
        this.c = bigInteger2;
        this.d = bigInteger;
        this.q = 0;
    }

    public l0(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.c = bigInteger2;
        this.d = bigInteger;
        this.q = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        if (!l0Var.d.equals(this.d) || !l0Var.c.equals(this.c) || l0Var.q != this.q) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.d.hashCode() ^ this.c.hashCode()) + this.q;
    }
}
