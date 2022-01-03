package com.pubnub.api.models.consumer;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class PNTimeResult {
    private Long timetoken;

    /* loaded from: classes2.dex */
    public static class PNTimeResultBuilder {
        private Long timetoken;

        public PNTimeResult build() {
            return new PNTimeResult(this.timetoken);
        }

        public PNTimeResultBuilder timetoken(Long l) {
            this.timetoken = l;
            return this;
        }

        public String toString() {
            StringBuilder P0 = a.P0("PNTimeResult.PNTimeResultBuilder(timetoken=");
            P0.append(this.timetoken);
            P0.append(")");
            return P0.toString();
        }
    }

    public PNTimeResult(Long l) {
        this.timetoken = l;
    }

    public static PNTimeResultBuilder builder() {
        return new PNTimeResultBuilder();
    }

    public Long getTimetoken() {
        return this.timetoken;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNTimeResult(timetoken=");
        P0.append(getTimetoken());
        P0.append(")");
        return P0.toString();
    }
}
