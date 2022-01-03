package com.pubnub.api.models.consumer;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class PNPublishResult {
    private final Long timetoken;

    /* loaded from: classes2.dex */
    public static class PNPublishResultBuilder {
        private Long timetoken;

        public PNPublishResult build() {
            return new PNPublishResult(this.timetoken);
        }

        public PNPublishResultBuilder timetoken(Long l) {
            this.timetoken = l;
            return this;
        }

        public String toString() {
            StringBuilder P0 = a.P0("PNPublishResult.PNPublishResultBuilder(timetoken=");
            P0.append(this.timetoken);
            P0.append(")");
            return P0.toString();
        }
    }

    public PNPublishResult(Long l) {
        this.timetoken = l;
    }

    public static PNPublishResultBuilder builder() {
        return new PNPublishResultBuilder();
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PNPublishResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PNPublishResult)) {
            return false;
        }
        PNPublishResult pNPublishResult = (PNPublishResult) obj;
        if (!pNPublishResult.canEqual(this)) {
            return false;
        }
        Long timetoken = getTimetoken();
        Long timetoken2 = pNPublishResult.getTimetoken();
        return timetoken != null ? timetoken.equals(timetoken2) : timetoken2 == null;
    }

    public Long getTimetoken() {
        return this.timetoken;
    }

    public int hashCode() {
        Long timetoken = getTimetoken();
        return 59 + (timetoken == null ? 43 : timetoken.hashCode());
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNPublishResult(timetoken=");
        P0.append(getTimetoken());
        P0.append(")");
        return P0.toString();
    }
}
