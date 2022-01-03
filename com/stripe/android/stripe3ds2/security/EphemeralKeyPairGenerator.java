package com.stripe.android.stripe3ds2.security;

import java.security.KeyPair;
import kotlin.Metadata;
/* compiled from: EphemeralKeyPairGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "", "Ljava/security/KeyPair;", "generate", "()Ljava/security/KeyPair;", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface EphemeralKeyPairGenerator {
    KeyPair generate();
}
