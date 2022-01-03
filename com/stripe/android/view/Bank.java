package com.stripe.android.view;

import com.stripe.android.model.PaymentMethodOptionsParams;
import kotlin.Metadata;
/* compiled from: Bank.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b`\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/Bank;", "", "", "getBrandIconResId", "()Ljava/lang/Integer;", "brandIconResId", "", "getDisplayName", "()Ljava/lang/String;", "displayName", "getCode", PaymentMethodOptionsParams.Blik.PARAM_CODE, "getId", "id", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface Bank {
    Integer getBrandIconResId();

    String getCode();

    String getDisplayName();

    String getId();
}
