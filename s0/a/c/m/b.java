package s0.a.c.m;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;
/* loaded from: classes4.dex */
public class b extends FilterOutputStream {
    public final Cipher c;
    public final byte[] d = new byte[1];

    public b(OutputStream outputStream, Cipher cipher) {
        super(outputStream);
        this.c = cipher;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(4:20|2|(1:4)|5)|18|11|(1:16)(1:17)) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r0 == null) goto L_0x003e;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void close() throws IOException {
        IOException e;
        IOException iOException;
        try {
            byte[] doFinal = this.c.doFinal();
            if (doFinal != null) {
                ((FilterOutputStream) this).out.write(doFinal);
            }
            e = null;
        } catch (GeneralSecurityException e2) {
            iOException = new InvalidCipherTextIOException("Error during cipher finalisation", e2);
            e = iOException;
            ((FilterOutputStream) this).out.flush();
            ((FilterOutputStream) this).out.close();
            if (e != null) {
            }
        } catch (Exception e3) {
            iOException = new IOException("Error closing stream: " + e3);
            e = iOException;
            ((FilterOutputStream) this).out.flush();
            ((FilterOutputStream) this).out.close();
            if (e != null) {
            }
        }
        ((FilterOutputStream) this).out.flush();
        ((FilterOutputStream) this).out.close();
        if (e != null) {
            throw e;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.d;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] update = this.c.update(bArr, i, i2);
        if (update != null) {
            ((FilterOutputStream) this).out.write(update);
        }
    }
}
