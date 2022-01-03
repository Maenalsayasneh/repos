package s0.a.d.e;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import s0.a.e.b.h;
/* loaded from: classes4.dex */
public class e implements AlgorithmParameterSpec {
    public s0.a.e.b.e a;
    public byte[] b;
    public h c;
    public BigInteger d;
    public BigInteger e;

    public e(s0.a.e.b.e eVar, h hVar, BigInteger bigInteger) {
        this.a = eVar;
        this.c = hVar.q();
        this.d = bigInteger;
        this.e = BigInteger.valueOf(1);
        this.b = null;
    }

    public e(s0.a.e.b.e eVar, h hVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.a = eVar;
        this.c = hVar.q();
        this.d = bigInteger;
        this.e = bigInteger2;
        this.b = bArr;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.a.j(eVar.a) || !this.c.c(eVar.c)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode() ^ this.c.hashCode();
    }
}
