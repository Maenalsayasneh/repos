package s0.a.b.g0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import s0.a.b.n;
/* loaded from: classes4.dex */
public class a extends FilterInputStream {
    public n c;

    public a(InputStream inputStream, n nVar) {
        super(inputStream);
        this.c = nVar;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            this.c.update((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (read > 0) {
            this.c.update(bArr, i, read);
        }
        return read;
    }
}
