package com.stripe.android.paymentsheet.model;

import android.os.Parcelable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import kotlin.Metadata;
import m0.n.b.f;
/* compiled from: ClientSecret.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/ClientSecret;", "Landroid/os/Parcelable;", "", "getValue", "()Ljava/lang/String;", InstabugDbContract.UserAttributesEntry.COLUMN_VALUE, "<init>", "()V", "Lcom/stripe/android/paymentsheet/model/PaymentIntentClientSecret;", "Lcom/stripe/android/paymentsheet/model/SetupIntentClientSecret;", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public abstract class ClientSecret implements Parcelable {
    private ClientSecret() {
    }

    public abstract String getValue();

    public /* synthetic */ ClientSecret(f fVar) {
        this();
    }
}
