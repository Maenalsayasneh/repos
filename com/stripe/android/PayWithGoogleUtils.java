package com.stripe.android;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;
import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: PayWithGoogleUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/PayWithGoogleUtils;", "", "", "price", "Ljava/util/Currency;", "currency", "", "getPriceString", "(ILjava/util/Currency;)Ljava/lang/String;", "<init>", "()V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class PayWithGoogleUtils {
    public static final PayWithGoogleUtils INSTANCE = new PayWithGoogleUtils();

    private PayWithGoogleUtils() {
    }

    public static final String getPriceString(int i, Currency currency) {
        i.e(currency, "currency");
        int defaultFractionDigits = currency.getDefaultFractionDigits();
        int length = String.valueOf(i).length();
        StringBuilder sb = new StringBuilder();
        if (defaultFractionDigits == 0) {
            for (int i2 = 0; i2 < length; i2++) {
                sb.append('#');
            }
            DecimalFormat decimalFormat = new DecimalFormat(sb.toString());
            decimalFormat.setCurrency(currency);
            decimalFormat.setGroupingUsed(false);
            String format = decimalFormat.format(Integer.valueOf(i));
            i.d(format, "noDecimalCurrencyFormat.format(price)");
            return format;
        }
        int i3 = length - defaultFractionDigits;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append('#');
        }
        if (length <= defaultFractionDigits) {
            sb.append('0');
        }
        sb.append('.');
        for (int i5 = 0; i5 < defaultFractionDigits; i5++) {
            sb.append('0');
        }
        double pow = Math.pow(10.0d, (double) defaultFractionDigits);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat2 = new DecimalFormat(sb.toString(), decimalFormatSymbols);
        decimalFormat2.setCurrency(currency);
        decimalFormat2.setGroupingUsed(false);
        String format2 = decimalFormat2.format(((double) i) / pow);
        i.d(format2, "decimalFormat.format(decimalPrice)");
        return format2;
    }
}
