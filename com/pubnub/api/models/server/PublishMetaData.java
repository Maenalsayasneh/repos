package com.pubnub.api.models.server;

import com.google.gson.annotations.SerializedName;
import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class PublishMetaData {
    @SerializedName("t")
    private Long publishTimetoken;
    @SerializedName("r")
    private Integer region;

    public boolean canEqual(Object obj) {
        return obj instanceof PublishMetaData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PublishMetaData)) {
            return false;
        }
        PublishMetaData publishMetaData = (PublishMetaData) obj;
        if (!publishMetaData.canEqual(this)) {
            return false;
        }
        Long publishTimetoken = getPublishTimetoken();
        Long publishTimetoken2 = publishMetaData.getPublishTimetoken();
        if (publishTimetoken != null ? !publishTimetoken.equals(publishTimetoken2) : publishTimetoken2 != null) {
            return false;
        }
        Integer region = getRegion();
        Integer region2 = publishMetaData.getRegion();
        return region != null ? region.equals(region2) : region2 == null;
    }

    public Long getPublishTimetoken() {
        return this.publishTimetoken;
    }

    public Integer getRegion() {
        return this.region;
    }

    public int hashCode() {
        Long publishTimetoken = getPublishTimetoken();
        int i = 43;
        int hashCode = publishTimetoken == null ? 43 : publishTimetoken.hashCode();
        Integer region = getRegion();
        int i2 = (hashCode + 59) * 59;
        if (region != null) {
            i = region.hashCode();
        }
        return i2 + i;
    }

    public void setPublishTimetoken(Long l) {
        this.publishTimetoken = l;
    }

    public void setRegion(Integer num) {
        this.region = num;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PublishMetaData(publishTimetoken=");
        P0.append(getPublishTimetoken());
        P0.append(", region=");
        P0.append(getRegion());
        P0.append(")");
        return P0.toString();
    }
}
