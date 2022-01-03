package i0.j.a.o.c;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: APMCountableInputStream.java */
/* loaded from: classes2.dex */
public class a extends InputStream {
    public long c = 0;
    public int d = -1;
    public boolean q = false;
    public InputStream x;
    public AbstractC0169a y;

    /* compiled from: APMCountableInputStream.java */
    /* renamed from: i0.j.a.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0169a {
        void a(long j) throws IOException;
    }

    public a(InputStream inputStream, AbstractC0169a aVar) {
        this.x = inputStream;
        this.y = aVar;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.x.mark(i);
        this.d = (int) this.c;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.x.read();
        if (read != -1) {
            this.c++;
        } else if (!this.q) {
            this.q = true;
            this.y.a(this.c);
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (!this.x.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.d != -1) {
            this.x.reset();
            this.c = (long) this.d;
        } else {
            throw new IOException("Mark not set");
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.x.skip(j);
        this.c += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.x.read(bArr, i, i2);
        if (read != -1) {
            this.c += (long) read;
        } else if (!this.q) {
            this.q = true;
            this.y.a(this.c);
        }
        return read;
    }
}
