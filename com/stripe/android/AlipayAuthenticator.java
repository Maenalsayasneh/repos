package com.stripe.android;

import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.Map;
import kotlin.Metadata;
/* compiled from: AlipayAuthenticator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/AlipayAuthenticator;", "", "", MessageExtension.FIELD_DATA, "", "onAuthenticationRequest", "(Ljava/lang/String;)Ljava/util/Map;", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface AlipayAuthenticator {
    Map<String, String> onAuthenticationRequest(String str);
}
