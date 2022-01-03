package s0.a.b.k0;

import java.util.Arrays;
import s0.a.e.b.b0.c.h3;
/* loaded from: classes4.dex */
public class l {
    public byte[] a;
    public int b;

    public l(byte[] bArr, int i) {
        this.a = h3.I(bArr);
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.b != this.b) {
            return false;
        }
        return Arrays.equals(this.a, lVar.a);
    }

    public int hashCode() {
        return this.b ^ h3.m1(this.a);
    }
}
