package com.stripe.android.view;

import com.stripe.android.R;
import kotlin.Metadata;
/* compiled from: PaymentFlowPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/view/PaymentFlowPage;", "", "", "titleResId", "I", "getTitleResId", "()I", "<init>", "(Ljava/lang/String;II)V", "ShippingInfo", "ShippingMethod", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public enum PaymentFlowPage {
    ShippingInfo(R.string.title_add_an_address),
    ShippingMethod(R.string.title_select_shipping_method);
    
    private final int titleResId;

    PaymentFlowPage(int i) {
        this.titleResId = i;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }
}
