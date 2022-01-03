package s0.a.b;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
/* loaded from: classes4.dex */
public interface v {
    boolean a(byte[] bArr);

    byte[] b() throws CryptoException, DataLengthException;

    void init(boolean z, i iVar);

    void update(byte b);

    void update(byte[] bArr, int i, int i2);
}
