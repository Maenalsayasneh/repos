package com.pubnub.api.models.server;

import com.google.gson.annotations.SerializedName;
import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class SubscribeMetadata {
    @SerializedName("r")
    private final String region;
    @SerializedName("t")
    private final Long timetoken;

    public SubscribeMetadata(Long l, String str) {
        this.timetoken = l;
        this.region = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SubscribeMetadata;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscribeMetadata)) {
            return false;
        }
        SubscribeMetadata subscribeMetadata = (SubscribeMetadata) obj;
        if (!subscribeMetadata.canEqual(this)) {
            return false;
        }
        Long timetoken = getTimetoken();
        Long timetoken2 = subscribeMetadata.getTimetoken();
        if (timetoken != null ? !timetoken.equals(timetoken2) : timetoken2 != null) {
            return false;
        }
        String region = getRegion();
        String region2 = subscribeMetadata.getRegion();
        return region != null ? region.equals(region2) : region2 == null;
    }

    public String getRegion() {
        return this.region;
    }

    public Long getTimetoken() {
        return this.timetoken;
    }

    public int hashCode() {
        Long timetoken = getTimetoken();
        int i = 43;
        int hashCode = timetoken == null ? 43 : timetoken.hashCode();
        String region = getRegion();
        int i2 = (hashCode + 59) * 59;
        if (region != null) {
            i = region.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder P0 = a.P0("SubscribeMetadata(timetoken=");
        P0.append(getTimetoken());
        P0.append(", region=");
        P0.append(getRegion());
        P0.append(")");
        return P0.toString();
    }
}
