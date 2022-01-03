package i0.f.a.c.t;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferBackedOutputStream.java */
/* loaded from: classes2.dex */
public class e extends OutputStream {
    public final ByteBuffer c;

    public e(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.c.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.c.put(bArr, i, i2);
    }
}
