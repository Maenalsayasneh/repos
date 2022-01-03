package s0.a.d.e;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public class n {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;

    public n(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.c.equals(nVar.c) && this.a.equals(nVar.a) && this.b.equals(nVar.b);
    }

    public int hashCode() {
        return (this.c.hashCode() ^ this.a.hashCode()) ^ this.b.hashCode();
    }
}
