package com.pubnub.api.models.consumer.files;

import i0.d.a.a.a;
import lombok.NonNull;
/* loaded from: classes2.dex */
public class PNDeleteFileResult {
    @NonNull
    private final int status;

    public PNDeleteFileResult(@NonNull int i) {
        this.status = i;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PNDeleteFileResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PNDeleteFileResult)) {
            return false;
        }
        PNDeleteFileResult pNDeleteFileResult = (PNDeleteFileResult) obj;
        return pNDeleteFileResult.canEqual(this) && getStatus() == pNDeleteFileResult.getStatus();
    }

    @NonNull
    public int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return getStatus() + 59;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNDeleteFileResult(status=");
        P0.append(getStatus());
        P0.append(")");
        return P0.toString();
    }
}
