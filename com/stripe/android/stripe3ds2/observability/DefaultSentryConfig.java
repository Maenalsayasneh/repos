package com.stripe.android.stripe3ds2.observability;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import io.sentry.SentryClient;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
/* compiled from: DefaultSentryConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\u0006\u001a\u0004\b\t\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/stripe3ds2/observability/DefaultSentryConfig;", "Lcom/stripe/android/stripe3ds2/observability/SentryConfig;", "", "getTimestamp", "()Ljava/lang/String;", InstabugDbContract.UserAttributesEntry.COLUMN_KEY, "Ljava/lang/String;", "getKey", "secret", "getSecret", "projectId", "getProjectId", "version", "getVersion", "<init>", "()V", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class DefaultSentryConfig implements SentryConfig {
    public static final DefaultSentryConfig INSTANCE = new DefaultSentryConfig();
    private static final String projectId = "426";
    private static final String key = "dcb428fea25c40e7b99f81ae5981ee6a";
    private static final String secret = "deca87e736574c5c83c07314051fd93a";
    private static final String version = SentryClient.SENTRY_PROTOCOL_VERSION;

    private DefaultSentryConfig() {
    }

    @Override // com.stripe.android.stripe3ds2.observability.SentryConfig
    public String getKey() {
        return key;
    }

    @Override // com.stripe.android.stripe3ds2.observability.SentryConfig
    public String getProjectId() {
        return projectId;
    }

    @Override // com.stripe.android.stripe3ds2.observability.SentryConfig
    public String getSecret() {
        return secret;
    }

    @Override // com.stripe.android.stripe3ds2.observability.SentryConfig
    public String getTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis);
        long millis = currentTimeMillis - TimeUnit.SECONDS.toMillis(seconds);
        StringBuilder sb = new StringBuilder();
        sb.append(seconds);
        sb.append('.');
        sb.append(millis);
        return sb.toString();
    }

    @Override // com.stripe.android.stripe3ds2.observability.SentryConfig
    public String getVersion() {
        return version;
    }
}
