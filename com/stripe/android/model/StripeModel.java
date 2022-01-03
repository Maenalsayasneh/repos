package com.stripe.android.model;

import android.os.Parcelable;
import com.google.android.gms.recaptcha.RecaptchaActionType;
import kotlin.Metadata;
/* compiled from: StripeModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H¦\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/StripeModel;", "Landroid/os/Parcelable;", "", "hashCode", "()I", "", RecaptchaActionType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface StripeModel extends Parcelable {
    @Override // java.lang.Object
    boolean equals(Object obj);

    @Override // java.lang.Object
    int hashCode();
}
