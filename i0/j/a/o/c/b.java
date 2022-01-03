package i0.j.a.o.c;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: APMCountableOutputStream.java */
/* loaded from: classes2.dex */
public class b extends OutputStream {
    public Long c = 0L;
    public OutputStream d;

    public b(OutputStream outputStream) {
        this.d = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.d.write(i);
        this.c = Long.valueOf(this.c.longValue() + 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.d.write(bArr, i, i2);
        this.c = Long.valueOf(this.c.longValue() + ((long) i2));
    }
}
