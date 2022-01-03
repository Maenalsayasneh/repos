package com.stripe.android.stripe3ds2.observability;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import kotlin.Metadata;
/* compiled from: SentryConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/stripe/android/stripe3ds2/observability/SentryConfig;", "", "", "getTimestamp", "()Ljava/lang/String;", "getKey", InstabugDbContract.UserAttributesEntry.COLUMN_KEY, "getProjectId", "projectId", "getVersion", "version", "getSecret", "secret", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface SentryConfig {
    String getKey();

    String getProjectId();

    String getSecret();

    String getTimestamp();

    String getVersion();
}
