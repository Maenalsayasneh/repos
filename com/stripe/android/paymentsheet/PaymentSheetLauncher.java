package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.PaymentSheet;
import kotlin.Metadata;
/* compiled from: PaymentSheetLauncher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;", "", "", "paymentIntentClientSecret", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "configuration", "Lm0/i;", "presentWithPaymentIntent", "(Ljava/lang/String;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;)V", "setupIntentClientSecret", "presentWithSetupIntent", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface PaymentSheetLauncher {

    /* compiled from: PaymentSheetLauncher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void presentWithPaymentIntent$default(PaymentSheetLauncher paymentSheetLauncher, String str, PaymentSheet.Configuration configuration, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                paymentSheetLauncher.presentWithPaymentIntent(str, configuration);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: presentWithPaymentIntent");
        }

        public static /* synthetic */ void presentWithSetupIntent$default(PaymentSheetLauncher paymentSheetLauncher, String str, PaymentSheet.Configuration configuration, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                paymentSheetLauncher.presentWithSetupIntent(str, configuration);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: presentWithSetupIntent");
        }
    }

    void presentWithPaymentIntent(String str, PaymentSheet.Configuration configuration);

    void presentWithSetupIntent(String str, PaymentSheet.Configuration configuration);
}
