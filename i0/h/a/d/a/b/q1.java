package i0.h.a.d.a.b;

import android.support.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class q1 extends InputStream {
    public final Enumeration<File> c;
    @Nullable
    public InputStream d;

    public q1(Enumeration<File> enumeration) throws IOException {
        this.c = enumeration;
        a();
    }

    public final void a() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            inputStream.close();
        }
        this.d = this.c.hasMoreElements() ? new FileInputStream(this.c.nextElement()) : null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.d;
        if (inputStream != null) {
            inputStream.close();
            this.d = null;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.d;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.d == null) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.d.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                a();
            } while (this.d != null);
            return -1;
        }
    }
}
