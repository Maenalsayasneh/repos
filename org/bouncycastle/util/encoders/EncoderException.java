package org.bouncycastle.util.encoders;
/* loaded from: classes4.dex */
public class EncoderException extends IllegalStateException {
    public Throwable c;

    public EncoderException(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
