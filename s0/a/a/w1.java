package s0.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class w1 extends z1 {
    public int q;
    public int x;
    public boolean y = false;
    public boolean Y1 = true;

    public w1(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        this.q = inputStream.read();
        int read = inputStream.read();
        this.x = read;
        if (read >= 0) {
            b();
            return;
        }
        throw new EOFException();
    }

    public final boolean b() {
        if (!this.y && this.Y1 && this.q == 0 && this.x == 0) {
            this.y = true;
            a(true);
        }
        return this.y;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (b()) {
            return -1;
        }
        int read = this.c.read();
        if (read >= 0) {
            int i = this.q;
            this.q = this.x;
            this.x = read;
            return i;
        }
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.Y1 || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this.y) {
            return -1;
        }
        int read = this.c.read(bArr, i + 2, i2 - 2);
        if (read >= 0) {
            bArr[i] = (byte) this.q;
            bArr[i + 1] = (byte) this.x;
            this.q = this.c.read();
            int read2 = this.c.read();
            this.x = read2;
            if (read2 >= 0) {
                return read + 2;
            }
            throw new EOFException();
        }
        throw new EOFException();
    }
}
