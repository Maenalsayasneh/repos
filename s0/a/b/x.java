package s0.a.b;

import org.bouncycastle.crypto.DataLengthException;
/* loaded from: classes4.dex */
public interface x {
    String getAlgorithmName();

    void init(boolean z, i iVar) throws IllegalArgumentException;

    int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

    void reset();
}
