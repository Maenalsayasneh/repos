package s0.a.b;

import org.bouncycastle.crypto.DataLengthException;
/* loaded from: classes4.dex */
public interface s {
    int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException;

    String getAlgorithmName();

    int getMacSize();

    void init(i iVar) throws IllegalArgumentException;

    void reset();

    void update(byte b) throws IllegalStateException;

    void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException;
}
