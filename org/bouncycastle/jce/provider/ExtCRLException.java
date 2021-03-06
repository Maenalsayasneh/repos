package org.bouncycastle.jce.provider;

import java.security.cert.CRLException;
/* loaded from: classes4.dex */
public class ExtCRLException extends CRLException {
    public Throwable cause;

    public ExtCRLException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
