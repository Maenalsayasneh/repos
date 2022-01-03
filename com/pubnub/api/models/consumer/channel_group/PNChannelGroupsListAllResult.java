package com.pubnub.api.models.consumer.channel_group;

import i0.d.a.a.a;
import java.util.List;
/* loaded from: classes2.dex */
public class PNChannelGroupsListAllResult {
    private List<String> groups;

    /* loaded from: classes2.dex */
    public static class PNChannelGroupsListAllResultBuilder {
        private List<String> groups;

        public PNChannelGroupsListAllResult build() {
            return new PNChannelGroupsListAllResult(this.groups);
        }

        public PNChannelGroupsListAllResultBuilder groups(List<String> list) {
            this.groups = list;
            return this;
        }

        public String toString() {
            StringBuilder P0 = a.P0("PNChannelGroupsListAllResult.PNChannelGroupsListAllResultBuilder(groups=");
            P0.append(this.groups);
            P0.append(")");
            return P0.toString();
        }
    }

    public PNChannelGroupsListAllResult(List<String> list) {
        this.groups = list;
    }

    public static PNChannelGroupsListAllResultBuilder builder() {
        return new PNChannelGroupsListAllResultBuilder();
    }

    public List<String> getGroups() {
        return this.groups;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNChannelGroupsListAllResult(groups=");
        P0.append(getGroups());
        P0.append(")");
        return P0.toString();
    }
}
