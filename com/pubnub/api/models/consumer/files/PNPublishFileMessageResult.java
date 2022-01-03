package com.pubnub.api.models.consumer.files;

import i0.d.a.a.a;
import lombok.NonNull;
/* loaded from: classes2.dex */
public class PNPublishFileMessageResult {
    @NonNull
    private final long timetoken;

    public PNPublishFileMessageResult(@NonNull long j) {
        this.timetoken = j;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PNPublishFileMessageResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PNPublishFileMessageResult)) {
            return false;
        }
        PNPublishFileMessageResult pNPublishFileMessageResult = (PNPublishFileMessageResult) obj;
        return pNPublishFileMessageResult.canEqual(this) && getTimetoken() == pNPublishFileMessageResult.getTimetoken();
    }

    @NonNull
    public long getTimetoken() {
        return this.timetoken;
    }

    public int hashCode() {
        long timetoken = getTimetoken();
        return 59 + ((int) (timetoken ^ (timetoken >>> 32)));
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNPublishFileMessageResult(timetoken=");
        P0.append(getTimetoken());
        P0.append(")");
        return P0.toString();
    }
}
