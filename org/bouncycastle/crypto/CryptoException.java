package org.bouncycastle.crypto;
/* loaded from: classes4.dex */
public class CryptoException extends Exception {
    public Throwable c;

    public CryptoException() {
    }

    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
