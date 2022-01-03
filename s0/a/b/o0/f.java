package s0.a.b.o0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import s0.a.g.j;
/* loaded from: classes4.dex */
public class f {
    public final ByteArrayOutputStream a = new ByteArrayOutputStream();

    public byte[] a() {
        return this.a.toByteArray();
    }

    public void b(int i) {
        this.a.write((i >>> 24) & 255);
        this.a.write((i >>> 16) & 255);
        this.a.write((i >>> 8) & 255);
        this.a.write(i & 255);
    }

    public void c(BigInteger bigInteger) {
        d(bigInteger.toByteArray());
    }

    public void d(byte[] bArr) {
        b(bArr.length);
        try {
            this.a.write(bArr);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public void e(String str) {
        d(j.c(str));
    }
}
