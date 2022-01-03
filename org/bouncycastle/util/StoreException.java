package org.bouncycastle.util;
/* loaded from: classes4.dex */
public class StoreException extends RuntimeException {
    public Throwable c;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }
}
