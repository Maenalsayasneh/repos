package org.bouncycastle.jcajce;

import java.security.cert.X509Certificate;
import s0.a.c.b;
/* loaded from: classes4.dex */
public class BCFKSLoadStoreParameter extends b {

    /* loaded from: classes4.dex */
    public enum EncryptionAlgorithm {
        AES256_CCM,
        AES256_KWP
    }

    /* loaded from: classes4.dex */
    public enum MacAlgorithm {
        HmacSHA512,
        HmacSHA3_512
    }

    /* loaded from: classes4.dex */
    public enum SignatureAlgorithm {
        SHA512withDSA,
        SHA3_512withDSA,
        SHA512withECDSA,
        SHA3_512withECDSA,
        SHA512withRSA,
        SHA3_512withRSA
    }

    /* loaded from: classes4.dex */
    public interface a {
        boolean a(X509Certificate[] x509CertificateArr);
    }
}
