package org.bouncycastle.jcajce;

import javax.crypto.SecretKey;
import s0.a.b.g;
/* loaded from: classes4.dex */
public class PBKDF1Key implements SecretKey {
    public final char[] c;
    public final g d;

    public PBKDF1Key(char[] cArr, g gVar) {
        char[] cArr2 = new char[cArr.length];
        this.c = cArr2;
        this.d = gVar;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF1";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.d.convert(this.c);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.d.getType();
    }

    public char[] getPassword() {
        return this.c;
    }
}
