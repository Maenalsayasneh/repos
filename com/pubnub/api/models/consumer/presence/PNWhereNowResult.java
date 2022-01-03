package com.pubnub.api.models.consumer.presence;

import i0.d.a.a.a;
import java.util.List;
/* loaded from: classes2.dex */
public class PNWhereNowResult {
    private List<String> channels;

    /* loaded from: classes2.dex */
    public static class PNWhereNowResultBuilder {
        private List<String> channels;

        public PNWhereNowResult build() {
            return new PNWhereNowResult(this.channels);
        }

        public PNWhereNowResultBuilder channels(List<String> list) {
            this.channels = list;
            return this;
        }

        public String toString() {
            StringBuilder P0 = a.P0("PNWhereNowResult.PNWhereNowResultBuilder(channels=");
            P0.append(this.channels);
            P0.append(")");
            return P0.toString();
        }
    }

    public PNWhereNowResult(List<String> list) {
        this.channels = list;
    }

    public static PNWhereNowResultBuilder builder() {
        return new PNWhereNowResultBuilder();
    }

    public List<String> getChannels() {
        return this.channels;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNWhereNowResult(channels=");
        P0.append(getChannels());
        P0.append(")");
        return P0.toString();
    }
}
