package org.bouncycastle.jcajce;

import javax.crypto.SecretKey;
import s0.a.b.g;
/* loaded from: classes4.dex */
public class PBKDF2Key implements SecretKey {
    public final char[] c;
    public final g d;

    public PBKDF2Key(char[] cArr, g gVar) {
        this.c = cArr == null ? null : (char[]) cArr.clone();
        this.d = gVar;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.d.convert(this.c);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.d.getType();
    }
}
