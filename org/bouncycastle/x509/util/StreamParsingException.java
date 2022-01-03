package org.bouncycastle.x509.util;
/* loaded from: classes4.dex */
public class StreamParsingException extends Exception {
    public Throwable c;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
