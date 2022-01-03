package s0.a.g.l;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class b extends OutputStream {
    public OutputStream c;
    public OutputStream d;

    public b(OutputStream outputStream, OutputStream outputStream2) {
        this.c = outputStream;
        this.d = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
        this.d.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.c.flush();
        this.d.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.c.write(i);
        this.d.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.c.write(bArr);
        this.d.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.c.write(bArr, i, i2);
        this.d.write(bArr, i, i2);
    }
}
