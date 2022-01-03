package s0.a.f.b.a;

import java.io.ByteArrayOutputStream;
import s0.a.g.d;
/* loaded from: classes4.dex */
public class a {
    public final ByteArrayOutputStream a = new ByteArrayOutputStream();

    public byte[] a() {
        return this.a.toByteArray();
    }

    public a b(d dVar) {
        try {
            this.a.write(dVar.getEncoded());
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public a c(byte[] bArr) {
        try {
            this.a.write(bArr);
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public a d(int i) {
        this.a.write((byte) (i >>> 24));
        this.a.write((byte) (i >>> 16));
        this.a.write((byte) (i >>> 8));
        this.a.write((byte) i);
        return this;
    }
}
