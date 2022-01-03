package org.bouncycastle.jce.exception;

import java.security.cert.CertPathBuilderException;
/* loaded from: classes4.dex */
public class ExtCertPathBuilderException extends CertPathBuilderException {
    public Throwable c;

    public ExtCertPathBuilderException(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
