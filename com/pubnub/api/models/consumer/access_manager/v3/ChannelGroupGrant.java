package com.pubnub.api.models.consumer.access_manager.v3;
/* loaded from: classes2.dex */
public class ChannelGroupGrant extends PNResource<ChannelGroupGrant> {
    private ChannelGroupGrant() {
    }

    public static ChannelGroupGrant id(String str) {
        ChannelGroupGrant channelGroupGrant = new ChannelGroupGrant();
        channelGroupGrant.resourceName = str;
        return channelGroupGrant;
    }

    public static ChannelGroupGrant pattern(String str) {
        ChannelGroupGrant channelGroupGrant = new ChannelGroupGrant();
        channelGroupGrant.resourcePattern = str;
        return channelGroupGrant;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGroupGrant manage() {
        return (ChannelGroupGrant) super.manage();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGroupGrant read() {
        return (ChannelGroupGrant) super.read();
    }
}
