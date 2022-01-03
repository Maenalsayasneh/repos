package com.pubnub.api.models.consumer.access_manager.v3;

import i0.d.a.a.a;
import java.util.Objects;
import lombok.NonNull;
/* loaded from: classes2.dex */
public class PNGrantTokenResult {
    @NonNull
    private final String token;

    public PNGrantTokenResult(@NonNull String str) {
        Objects.requireNonNull(str, "token is marked @NonNull but is null");
        this.token = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PNGrantTokenResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PNGrantTokenResult)) {
            return false;
        }
        PNGrantTokenResult pNGrantTokenResult = (PNGrantTokenResult) obj;
        if (!pNGrantTokenResult.canEqual(this)) {
            return false;
        }
        String token = getToken();
        String token2 = pNGrantTokenResult.getToken();
        return token != null ? token.equals(token2) : token2 == null;
    }

    @NonNull
    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        String token = getToken();
        return 59 + (token == null ? 43 : token.hashCode());
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNGrantTokenResult(token=");
        P0.append(getToken());
        P0.append(")");
        return P0.toString();
    }
}
