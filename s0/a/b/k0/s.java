package s0.a.b.k0;

import java.util.Arrays;
import s0.a.e.b.b0.c.h3;
/* loaded from: classes4.dex */
public class s {
    public byte[] a;
    public int b;

    public s(byte[] bArr, int i) {
        this.a = h3.I(bArr);
        this.b = i;
    }

    public s(byte[] bArr, int i, int i2) {
        this.a = h3.I(bArr);
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (sVar.b != this.b) {
            return false;
        }
        return Arrays.equals(this.a, sVar.a);
    }

    public int hashCode() {
        return this.b ^ h3.m1(this.a);
    }
}
