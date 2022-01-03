package com.stripe.android.stripe3ds2.security;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import kotlin.Metadata;
/* compiled from: Algorithm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/Algorithm;", "", "", "toString", "()Ljava/lang/String;", InstabugDbContract.UserAttributesEntry.COLUMN_KEY, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "EC", "RSA", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public enum Algorithm {
    EC("EC"),
    RSA("RSA");
    
    private final String key;

    Algorithm(String str) {
        this.key = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.key;
    }
}
