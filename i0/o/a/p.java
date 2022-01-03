package i0.o.a;

import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: MarkableInputStream.java */
/* loaded from: classes3.dex */
public final class p extends InputStream {
    public int Z1;
    public final InputStream c;
    public long d;
    public long q;
    public long x;
    public long y = -1;
    public boolean Y1 = true;

    public p(InputStream inputStream) {
        this.Z1 = -1;
        this.c = !inputStream.markSupported() ? new BufferedInputStream(inputStream, 4096) : inputStream;
        this.Z1 = RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE;
    }

    public void a(long j) throws IOException {
        if (this.d > this.x || j < this.q) {
            throw new IOException("Cannot reset");
        }
        this.c.reset();
        e(this.q, j);
        this.d = j;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.c.available();
    }

    public final void b(long j) {
        try {
            long j2 = this.q;
            long j3 = this.d;
            if (j2 >= j3 || j3 > this.x) {
                this.q = j3;
                this.c.mark((int) (j - j3));
            } else {
                this.c.reset();
                this.c.mark((int) (j - this.q));
                e(this.q, this.d);
            }
            this.x = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public final void e(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.c.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        long j = this.d + ((long) i);
        if (this.x < j) {
            b(j);
        }
        this.y = this.d;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.c.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.Y1) {
            long j = this.x;
            if (this.d + 1 > j) {
                b(j + ((long) this.Z1));
            }
        }
        int read = this.c.read();
        if (read != -1) {
            this.d++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        a(this.y);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (!this.Y1) {
            long j2 = this.d;
            if (j2 + j > this.x) {
                b(j2 + j + ((long) this.Z1));
            }
        }
        long skip = this.c.skip(j);
        this.d += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (!this.Y1) {
            long j = this.d;
            if (((long) bArr.length) + j > this.x) {
                b(j + ((long) bArr.length) + ((long) this.Z1));
            }
        }
        int read = this.c.read(bArr);
        if (read != -1) {
            this.d += (long) read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.Y1) {
            long j = this.d;
            long j2 = (long) i2;
            if (j + j2 > this.x) {
                b(j + j2 + ((long) this.Z1));
            }
        }
        int read = this.c.read(bArr, i, i2);
        if (read != -1) {
            this.d += (long) read;
        }
        return read;
    }
}
