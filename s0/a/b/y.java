package s0.a.b;

import org.bouncycastle.crypto.InvalidCipherTextException;
/* loaded from: classes4.dex */
public interface y {
    byte[] a(byte[] bArr, int i, int i2) throws InvalidCipherTextException;

    byte[] b(byte[] bArr, int i, int i2);

    String getAlgorithmName();

    void init(boolean z, i iVar);
}
