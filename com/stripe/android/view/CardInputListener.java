package com.stripe.android.view;

import kotlin.Metadata;
/* compiled from: CardInputListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/stripe/android/view/CardInputListener;", "", "Lcom/stripe/android/view/CardInputListener$FocusField;", "focusField", "Lm0/i;", "onFocusChange", "(Lcom/stripe/android/view/CardInputListener$FocusField;)V", "onCardComplete", "()V", "onExpirationComplete", "onCvcComplete", "FocusField", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface CardInputListener {

    /* compiled from: CardInputListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/CardInputListener$FocusField;", "", "<init>", "(Ljava/lang/String;I)V", "CardNumber", "ExpiryDate", "Cvc", "PostalCode", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public enum FocusField {
        CardNumber,
        ExpiryDate,
        Cvc,
        PostalCode
    }

    void onCardComplete();

    void onCvcComplete();

    void onExpirationComplete();

    void onFocusChange(FocusField focusField);
}
