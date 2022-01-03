package i0.f.a.c.t;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferBackedInputStream.java */
/* loaded from: classes2.dex */
public class d extends InputStream {
    public final ByteBuffer c;

    public d(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.c.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.c.hasRemaining()) {
            return this.c.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.c.remaining());
        this.c.get(bArr, i, min);
        return min;
    }
}
