package org.bouncycastle.asn1;
/* loaded from: classes4.dex */
public class ASN1ParsingException extends IllegalStateException {
    public Throwable c;

    public ASN1ParsingException(String str) {
        super(str);
    }

    public ASN1ParsingException(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
