package i0.k.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StrictLineReader.java */
/* loaded from: classes2.dex */
public class b implements Closeable {
    public final InputStream c;
    public final Charset d;
    public byte[] q;
    public int x;
    public int y;

    /* compiled from: StrictLineReader.java */
    /* loaded from: classes2.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream, java.lang.Object
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, b.this.d.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        if (charset == null) {
            throw null;
        } else if (charset.equals(c.a)) {
            this.c = inputStream;
            this.d = charset;
            this.q = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void a() throws IOException {
        InputStream inputStream = this.c;
        byte[] bArr = this.q;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.x = 0;
            this.y = read;
            return;
        }
        throw new EOFException();
    }

    public String b() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.c) {
            if (this.q != null) {
                if (this.x >= this.y) {
                    a();
                }
                for (int i3 = this.x; i3 != this.y; i3++) {
                    byte[] bArr2 = this.q;
                    if (bArr2[i3] == 10) {
                        if (i3 != this.x) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                byte[] bArr3 = this.q;
                                int i4 = this.x;
                                String str = new String(bArr3, i4, i2 - i4, this.d.name());
                                this.x = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        byte[] bArr32 = this.q;
                        int i42 = this.x;
                        String str2 = new String(bArr32, i42, i2 - i42, this.d.name());
                        this.x = i3 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.y - this.x) + 80);
                loop1: while (true) {
                    byte[] bArr4 = this.q;
                    int i5 = this.x;
                    aVar.write(bArr4, i5, this.y - i5);
                    this.y = -1;
                    a();
                    i = this.x;
                    while (i != this.y) {
                        bArr = this.q;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.x;
                if (i != i6) {
                    aVar.write(bArr, i6, i - i6);
                }
                this.x = i + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.c) {
            if (this.q != null) {
                this.q = null;
                this.c.close();
            }
        }
    }
}
