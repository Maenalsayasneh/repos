package s0.a.e.c;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public class f implements a {
    public final BigInteger a;

    public f(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    @Override // s0.a.e.c.a
    public int b() {
        return 1;
    }

    @Override // s0.a.e.c.a
    public BigInteger c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return this.a.equals(((f) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
