package i0.l.a.g;

import java.security.Provider;
import java.security.SecureRandom;
/* compiled from: JCAContext.java */
/* loaded from: classes2.dex */
public class a {
    public Provider a;
    public SecureRandom b;

    public a() {
        this.a = null;
        this.b = null;
    }

    public SecureRandom a() {
        SecureRandom secureRandom = this.b;
        return secureRandom != null ? secureRandom : new SecureRandom();
    }

    public a(Provider provider, SecureRandom secureRandom) {
        this.a = provider;
        this.b = secureRandom;
    }
}
