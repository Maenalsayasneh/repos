package s0.a.c;

import java.io.OutputStream;
import java.security.KeyStore;
/* loaded from: classes4.dex */
public class b implements KeyStore.LoadStoreParameter {
    public OutputStream a() {
        throw new UnsupportedOperationException("parameter not configured for storage - no OutputStream");
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return null;
    }
}
