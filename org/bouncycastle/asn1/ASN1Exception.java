package org.bouncycastle.asn1;

import java.io.IOException;
/* loaded from: classes4.dex */
public class ASN1Exception extends IOException {
    public Throwable c;

    public ASN1Exception(String str) {
        super(str);
    }

    public ASN1Exception(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
