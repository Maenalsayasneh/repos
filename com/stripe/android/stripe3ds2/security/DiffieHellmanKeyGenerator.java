package com.stripe.android.stripe3ds2.security;

import java.io.Serializable;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import javax.crypto.SecretKey;
import kotlin.Metadata;
/* compiled from: DiffieHellmanKeyGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/DiffieHellmanKeyGenerator;", "Ljava/io/Serializable;", "Ljava/security/interfaces/ECPublicKey;", "acsPublicKey", "Ljava/security/interfaces/ECPrivateKey;", "sdkPrivateKey", "", "agreementInfo", "Ljavax/crypto/SecretKey;", "generate", "(Ljava/security/interfaces/ECPublicKey;Ljava/security/interfaces/ECPrivateKey;Ljava/lang/String;)Ljavax/crypto/SecretKey;", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface DiffieHellmanKeyGenerator extends Serializable {
    SecretKey generate(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey, String str);
}
