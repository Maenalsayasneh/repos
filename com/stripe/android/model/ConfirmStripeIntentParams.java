package com.stripe.android.model;

import kotlin.Metadata;
/* compiled from: ConfirmStripeIntentParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/ConfirmStripeIntentParams;", "Lcom/stripe/android/model/StripeParamsModel;", "", "shouldUseStripeSdk", "()Z", "withShouldUseStripeSdk", "(Z)Lcom/stripe/android/model/ConfirmStripeIntentParams;", "", "getReturnUrl", "()Ljava/lang/String;", "setReturnUrl", "(Ljava/lang/String;)V", "returnUrl", "getClientSecret", "clientSecret", "Companion", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface ConfirmStripeIntentParams extends StripeParamsModel {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String PARAM_CLIENT_SECRET = "client_secret";
    public static final String PARAM_MANDATE_DATA = "mandate_data";
    public static final String PARAM_MANDATE_ID = "mandate";
    public static final String PARAM_PAYMENT_METHOD_DATA = "payment_method_data";
    public static final String PARAM_PAYMENT_METHOD_ID = "payment_method";
    public static final String PARAM_RETURN_URL = "return_url";
    public static final String PARAM_USE_STRIPE_SDK = "use_stripe_sdk";

    /* compiled from: ConfirmStripeIntentParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/stripe/android/model/ConfirmStripeIntentParams$Companion;", "", "", "PARAM_PAYMENT_METHOD_ID", "Ljava/lang/String;", "PARAM_PAYMENT_METHOD_DATA", "PARAM_USE_STRIPE_SDK", "PARAM_RETURN_URL", "PARAM_MANDATE_DATA", "PARAM_MANDATE_ID", "PARAM_CLIENT_SECRET", "<init>", "()V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String PARAM_CLIENT_SECRET = "client_secret";
        public static final String PARAM_MANDATE_DATA = "mandate_data";
        public static final String PARAM_MANDATE_ID = "mandate";
        public static final String PARAM_PAYMENT_METHOD_DATA = "payment_method_data";
        public static final String PARAM_PAYMENT_METHOD_ID = "payment_method";
        public static final String PARAM_RETURN_URL = "return_url";
        public static final String PARAM_USE_STRIPE_SDK = "use_stripe_sdk";

        private Companion() {
        }
    }

    String getClientSecret();

    String getReturnUrl();

    void setReturnUrl(String str);

    boolean shouldUseStripeSdk();

    ConfirmStripeIntentParams withShouldUseStripeSdk(boolean z);
}
