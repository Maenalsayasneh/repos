package s0.a.b.g0;

import java.io.IOException;
import java.io.OutputStream;
import s0.a.b.s;
/* loaded from: classes4.dex */
public class d extends OutputStream {
    public s c;

    public d(s sVar) {
        this.c = sVar;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.c.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.c.update(bArr, i, i2);
    }
}
