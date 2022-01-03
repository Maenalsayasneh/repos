package org.bouncycastle.crypto.io;

import java.io.IOException;
/* loaded from: classes4.dex */
public class CipherIOException extends IOException {
    public final Throwable c;

    public CipherIOException(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
