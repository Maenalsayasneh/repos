package com.stripe.android;

import kotlin.Metadata;
/* compiled from: EphemeralKeyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/EphemeralKeyProvider;", "", "", "apiVersion", "Lcom/stripe/android/EphemeralKeyUpdateListener;", "keyUpdateListener", "Lm0/i;", "createEphemeralKey", "(Ljava/lang/String;Lcom/stripe/android/EphemeralKeyUpdateListener;)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface EphemeralKeyProvider {
    void createEphemeralKey(String str, EphemeralKeyUpdateListener ephemeralKeyUpdateListener);
}
