package com.stripe.android.view;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: PaymentUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/view/PaymentUtils;", "", "", "amount", "Ljava/util/Currency;", "currency", "", "free", "formatPriceStringUsingFree", "(JLjava/util/Currency;Ljava/lang/String;)Ljava/lang/String;", "", "formatPriceString$payments_core_release", "(DLjava/util/Currency;)Ljava/lang/String;", "formatPriceString", "<init>", "()V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class PaymentUtils {
    public static final PaymentUtils INSTANCE = new PaymentUtils();

    private PaymentUtils() {
    }

    public static final String formatPriceStringUsingFree(long j, Currency currency, String str) {
        i.e(currency, "currency");
        i.e(str, "free");
        if (j == 0) {
            return str;
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        Objects.requireNonNull(currencyInstance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        i.d(decimalFormatSymbols, "decimalFormatSymbols");
        decimalFormatSymbols.setCurrencySymbol(currency.getSymbol(Locale.getDefault()));
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return INSTANCE.formatPriceString$payments_core_release((double) j, currency);
    }

    public final /* synthetic */ String formatPriceString$payments_core_release(double d, Currency currency) {
        i.e(currency, "currency");
        double pow = d / Math.pow(10.0d, (double) currency.getDefaultFractionDigits());
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        try {
            if (currencyInstance != null) {
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) currencyInstance).getDecimalFormatSymbols();
                i.d(decimalFormatSymbols, "decimalFormatSymbols");
                decimalFormatSymbols.setCurrencySymbol(currency.getSymbol(Locale.getDefault()));
                ((DecimalFormat) currencyInstance).setDecimalFormatSymbols(decimalFormatSymbols);
                String format = currencyInstance.format(pow);
                i.d(format, "currencyFormat.format(majorUnitAmount)");
                return format;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.text.DecimalFormat");
        } catch (ClassCastException unused) {
            String format2 = currencyInstance.format(pow);
            i.d(format2, "currencyFormat.format(majorUnitAmount)");
            return format2;
        }
    }
}
