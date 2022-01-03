package org.bouncycastle.util.encoders;
/* loaded from: classes4.dex */
public class DecoderException extends IllegalStateException {
    public Throwable c;

    public DecoderException(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
