package com.stripe.android.view;

import java.util.Set;
import kotlin.Metadata;
/* compiled from: CardValidCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\nJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/view/CardValidCallback;", "", "", "isValid", "", "Lcom/stripe/android/view/CardValidCallback$Fields;", "invalidFields", "Lm0/i;", "onInputChanged", "(ZLjava/util/Set;)V", "Fields", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface CardValidCallback {

    /* compiled from: CardValidCallback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/CardValidCallback$Fields;", "", "<init>", "(Ljava/lang/String;I)V", "Number", "Expiry", "Cvc", "Postal", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public enum Fields {
        Number,
        Expiry,
        Cvc,
        Postal
    }

    void onInputChanged(boolean z, Set<? extends Fields> set);
}
