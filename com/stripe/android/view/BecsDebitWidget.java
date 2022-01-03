package com.stripe.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.stripe.android.R;
import com.stripe.android.databinding.BecsDebitWidgetBinding;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.BecsDebitBanks;
import i0.j.f.p.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import m0.c;
import m0.j.g;
import m0.n.a.a;
import m0.n.a.l;
import m0.n.b.f;
import m0.n.b.i;
/* compiled from: BecsDebitWidget.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001%B1\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/stripe/android/view/BecsDebitWidget;", "Landroid/widget/FrameLayout;", "Lm0/i;", "verifyCompanyName", "()V", "Landroid/util/AttributeSet;", UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY, "applyAttributes", "(Landroid/util/AttributeSet;)V", "", "isInputValid", "()Z", "Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "validParamsCallback", "Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "getValidParamsCallback", "()Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "setValidParamsCallback", "(Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;)V", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "params", "Lcom/stripe/android/databinding/BecsDebitWidgetBinding;", "viewBinding$delegate", "Lm0/c;", "getViewBinding$payments_core_release", "()Lcom/stripe/android/databinding/BecsDebitWidgetBinding;", "viewBinding", "Landroid/content/Context;", "context", "", "defStyleAttr", "", "companyName", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/lang/String;)V", "ValidParamsCallback", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class BecsDebitWidget extends FrameLayout {
    private ValidParamsCallback validParamsCallback;
    private final c viewBinding$delegate;

    /* compiled from: BecsDebitWidget.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "", "", "isValid", "Lm0/i;", "onInputChanged", "(Z)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public interface ValidParamsCallback {
        void onInputChanged(boolean z);
    }

    public BecsDebitWidget(Context context) {
        this(context, null, 0, null, 14, null);
    }

    public BecsDebitWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
    }

    public BecsDebitWidget(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 8, null);
    }

    public /* synthetic */ BecsDebitWidget(Context context, AttributeSet attributeSet, int i, String str, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str);
    }

    private final void applyAttributes(AttributeSet attributeSet) {
        Context context = getContext();
        i.d(context, "context");
        int[] iArr = R.styleable.BecsDebitWidget;
        i.d(iArr, "R.styleable.BecsDebitWidget");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.BecsDebitWidget_companyName);
        if (string != null) {
            BecsDebitMandateAcceptanceTextView becsDebitMandateAcceptanceTextView = getViewBinding$payments_core_release().mandateAcceptanceTextView;
            i.d(string, "companyName");
            becsDebitMandateAcceptanceTextView.setCompanyName(string);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInputValid() {
        String fieldText$payments_core_release = getViewBinding$payments_core_release().nameEditText.getFieldText$payments_core_release();
        String email = getViewBinding$payments_core_release().emailEditText.getEmail();
        String bsb$payments_core_release = getViewBinding$payments_core_release().bsbEditText.getBsb$payments_core_release();
        String accountNumber = getViewBinding$payments_core_release().accountNumberEditText.getAccountNumber();
        if (!StringsKt__IndentKt.o(fieldText$payments_core_release)) {
            if (!(email == null || StringsKt__IndentKt.o(email))) {
                if (!(bsb$payments_core_release == null || StringsKt__IndentKt.o(bsb$payments_core_release))) {
                    if (!(accountNumber == null || StringsKt__IndentKt.o(accountNumber))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void verifyCompanyName() {
        if (!getViewBinding$payments_core_release().mandateAcceptanceTextView.isValid$payments_core_release()) {
            throw new IllegalArgumentException("A company name is required to render a BecsDebitWidget.".toString());
        }
    }

    public final PaymentMethodCreateParams getParams() {
        String fieldText$payments_core_release = getViewBinding$payments_core_release().nameEditText.getFieldText$payments_core_release();
        String email = getViewBinding$payments_core_release().emailEditText.getEmail();
        String bsb$payments_core_release = getViewBinding$payments_core_release().bsbEditText.getBsb$payments_core_release();
        String accountNumber = getViewBinding$payments_core_release().accountNumberEditText.getAccountNumber();
        getViewBinding$payments_core_release().nameEditText.setShouldShowError(StringsKt__IndentKt.o(fieldText$payments_core_release));
        boolean z = false;
        getViewBinding$payments_core_release().emailEditText.setShouldShowError(email == null || StringsKt__IndentKt.o(email));
        getViewBinding$payments_core_release().bsbEditText.setShouldShowError(bsb$payments_core_release == null || StringsKt__IndentKt.o(bsb$payments_core_release));
        getViewBinding$payments_core_release().accountNumberEditText.setShouldShowError(accountNumber == null || StringsKt__IndentKt.o(accountNumber));
        if (StringsKt__IndentKt.o(fieldText$payments_core_release)) {
            return null;
        }
        if (email == null || StringsKt__IndentKt.o(email)) {
            return null;
        }
        if (bsb$payments_core_release == null || StringsKt__IndentKt.o(bsb$payments_core_release)) {
            return null;
        }
        if (accountNumber == null || StringsKt__IndentKt.o(accountNumber)) {
            z = true;
        }
        if (z) {
            return null;
        }
        return PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.AuBecsDebit(bsb$payments_core_release, accountNumber), new PaymentMethod.BillingDetails(null, email, fieldText$payments_core_release, null, 9, null), (Map) null, 4, (Object) null);
    }

    public final ValidParamsCallback getValidParamsCallback() {
        return this.validParamsCallback;
    }

    public final BecsDebitWidgetBinding getViewBinding$payments_core_release() {
        return (BecsDebitWidgetBinding) this.viewBinding$delegate.getValue();
    }

    public final void setValidParamsCallback(ValidParamsCallback validParamsCallback) {
        i.e(validParamsCallback, "<set-?>");
        this.validParamsCallback = validParamsCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BecsDebitWidget(Context context, AttributeSet attributeSet, int i, String str) {
        super(context, attributeSet, i);
        i.e(context, "context");
        i.e(str, "companyName");
        this.viewBinding$delegate = h.H2(new a<BecsDebitWidgetBinding>(context) { // from class: com.stripe.android.view.BecsDebitWidget$viewBinding$2
            public final /* synthetic */ Context $context;

            {
                this.$context = r2;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // m0.n.a.a
            public final BecsDebitWidgetBinding invoke() {
                BecsDebitWidgetBinding inflate = BecsDebitWidgetBinding.inflate(LayoutInflater.from(this.$context), BecsDebitWidget.this);
                i.d(inflate, "BecsDebitWidgetBinding.i…           this\n        )");
                return inflate;
            }
        });
        this.validParamsCallback = new ValidParamsCallback() { // from class: com.stripe.android.view.BecsDebitWidget$validParamsCallback$1
            @Override // com.stripe.android.view.BecsDebitWidget.ValidParamsCallback
            public void onInputChanged(boolean z) {
            }
        };
        if (Build.VERSION.SDK_INT >= 26) {
            getViewBinding$payments_core_release().nameEditText.setAutofillHints(new String[]{"name"});
            getViewBinding$payments_core_release().emailEditText.setAutofillHints(new String[]{"emailAddress"});
        }
        for (StripeEditText stripeEditText : g.h0(getViewBinding$payments_core_release().nameEditText, getViewBinding$payments_core_release().emailEditText, getViewBinding$payments_core_release().bsbEditText, getViewBinding$payments_core_release().accountNumberEditText)) {
            i.d(stripeEditText, "field");
            stripeEditText.addTextChangedListener(new TextWatcher() { // from class: com.stripe.android.view.BecsDebitWidget$$special$$inlined$forEach$lambda$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    BecsDebitWidget.this.getValidParamsCallback().onInputChanged(BecsDebitWidget.this.isInputValid());
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
        }
        getViewBinding$payments_core_release().bsbEditText.setOnBankChangedCallback(new l<BecsDebitBanks.Bank, m0.i>() { // from class: com.stripe.android.view.BecsDebitWidget.2
            @Override // m0.n.a.l
            public /* bridge */ /* synthetic */ m0.i invoke(BecsDebitBanks.Bank bank) {
                invoke2(bank);
                return m0.i.a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
                if (r0.equals("73") != false) goto L_0x00af;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
                if (r0.equals("08") != false) goto L_0x00c4;
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00ad, code lost:
                if (r0.equals("03") != false) goto L_0x00af;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00af, code lost:
                r5 = 6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00b7, code lost:
                if (r0.equals("01") != false) goto L_0x00c4;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00c0, code lost:
                if (r0.equals("00") != false) goto L_0x00c4;
             */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /* Code decompiled incorrectly, please refer to instructions dump */
            public final void invoke2(BecsDebitBanks.Bank bank) {
                String prefix$payments_core_release;
                String str2 = null;
                if (bank != null) {
                    TextInputLayout textInputLayout = BecsDebitWidget.this.getViewBinding$payments_core_release().bsbTextInputLayout;
                    i.d(textInputLayout, "viewBinding.bsbTextInputLayout");
                    textInputLayout.setHelperText(bank.getName$payments_core_release());
                    TextInputLayout textInputLayout2 = BecsDebitWidget.this.getViewBinding$payments_core_release().bsbTextInputLayout;
                    i.d(textInputLayout2, "viewBinding.bsbTextInputLayout");
                    textInputLayout2.setHelperTextEnabled(true);
                } else {
                    TextInputLayout textInputLayout3 = BecsDebitWidget.this.getViewBinding$payments_core_release().bsbTextInputLayout;
                    i.d(textInputLayout3, "viewBinding.bsbTextInputLayout");
                    textInputLayout3.setHelperText(null);
                    TextInputLayout textInputLayout4 = BecsDebitWidget.this.getViewBinding$payments_core_release().bsbTextInputLayout;
                    i.d(textInputLayout4, "viewBinding.bsbTextInputLayout");
                    textInputLayout4.setHelperTextEnabled(false);
                }
                BecsDebitAccountNumberEditText becsDebitAccountNumberEditText = BecsDebitWidget.this.getViewBinding$payments_core_release().accountNumberEditText;
                if (!(bank == null || (prefix$payments_core_release = bank.getPrefix$payments_core_release()) == null)) {
                    str2 = m0.r.t.a.r.m.a1.a.S3(prefix$payments_core_release, 2);
                }
                int i2 = 9;
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode != 1536) {
                        if (hashCode != 1537) {
                            if (hashCode != 1539) {
                                if (hashCode != 1542) {
                                    if (hashCode != 1544) {
                                        if (hashCode != 1756) {
                                            if (hashCode == 1784 && str2.equals("80")) {
                                                i2 = 4;
                                            }
                                        }
                                    }
                                } else if (str2.equals("06")) {
                                    i2 = 8;
                                }
                            }
                        }
                    }
                    becsDebitAccountNumberEditText.setMinLength(i2);
                }
                i2 = 5;
                becsDebitAccountNumberEditText.setMinLength(i2);
            }
        });
        getViewBinding$payments_core_release().bsbEditText.setOnCompletedCallback(new a<m0.i>() { // from class: com.stripe.android.view.BecsDebitWidget.3
            @Override // m0.n.a.a
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BecsDebitWidget.this.getViewBinding$payments_core_release().accountNumberTextInputLayout.requestFocus();
            }
        });
        EmailEditText emailEditText = getViewBinding$payments_core_release().emailEditText;
        StripeEditText stripeEditText2 = getViewBinding$payments_core_release().nameEditText;
        i.d(stripeEditText2, "viewBinding.nameEditText");
        emailEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(stripeEditText2));
        BecsDebitBsbEditText becsDebitBsbEditText = getViewBinding$payments_core_release().bsbEditText;
        EmailEditText emailEditText2 = getViewBinding$payments_core_release().emailEditText;
        i.d(emailEditText2, "viewBinding.emailEditText");
        becsDebitBsbEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(emailEditText2));
        BecsDebitAccountNumberEditText becsDebitAccountNumberEditText = getViewBinding$payments_core_release().accountNumberEditText;
        BecsDebitBsbEditText becsDebitBsbEditText2 = getViewBinding$payments_core_release().bsbEditText;
        i.d(becsDebitBsbEditText2, "viewBinding.bsbEditText");
        becsDebitAccountNumberEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(becsDebitBsbEditText2));
        getViewBinding$payments_core_release().nameEditText.setErrorMessage$payments_core_release(getResources().getString(R.string.becs_widget_name_required));
        StripeEditText stripeEditText3 = getViewBinding$payments_core_release().nameEditText;
        TextInputLayout textInputLayout = getViewBinding$payments_core_release().nameTextInputLayout;
        i.d(textInputLayout, "viewBinding.nameTextInputLayout");
        stripeEditText3.setErrorMessageListener(new ErrorListener(textInputLayout));
        EmailEditText emailEditText3 = getViewBinding$payments_core_release().emailEditText;
        TextInputLayout textInputLayout2 = getViewBinding$payments_core_release().emailTextInputLayout;
        i.d(textInputLayout2, "viewBinding.emailTextInputLayout");
        emailEditText3.setErrorMessageListener(new ErrorListener(textInputLayout2));
        BecsDebitBsbEditText becsDebitBsbEditText3 = getViewBinding$payments_core_release().bsbEditText;
        TextInputLayout textInputLayout3 = getViewBinding$payments_core_release().bsbTextInputLayout;
        i.d(textInputLayout3, "viewBinding.bsbTextInputLayout");
        becsDebitBsbEditText3.setErrorMessageListener(new ErrorListener(textInputLayout3));
        BecsDebitAccountNumberEditText becsDebitAccountNumberEditText2 = getViewBinding$payments_core_release().accountNumberEditText;
        TextInputLayout textInputLayout4 = getViewBinding$payments_core_release().accountNumberTextInputLayout;
        i.d(textInputLayout4, "viewBinding.accountNumberTextInputLayout");
        becsDebitAccountNumberEditText2.setErrorMessageListener(new ErrorListener(textInputLayout4));
        for (StripeEditText stripeEditText4 : g.h0(getViewBinding$payments_core_release().nameEditText, getViewBinding$payments_core_release().emailEditText)) {
            i.d(stripeEditText4, "field");
            stripeEditText4.addTextChangedListener(new TextWatcher() { // from class: com.stripe.android.view.BecsDebitWidget$$special$$inlined$doAfterTextChanged$2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    StripeEditText.this.setShouldShowError(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
        }
        str = !(StringsKt__IndentKt.o(str) ^ true) ? null : str;
        if (str != null) {
            getViewBinding$payments_core_release().mandateAcceptanceTextView.setCompanyName(str);
        }
        applyAttributes(attributeSet);
        verifyCompanyName();
    }
}
