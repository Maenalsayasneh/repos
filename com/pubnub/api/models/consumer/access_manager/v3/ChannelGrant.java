package com.pubnub.api.models.consumer.access_manager.v3;
/* loaded from: classes2.dex */
public class ChannelGrant extends PNResource<ChannelGrant> {
    private ChannelGrant() {
    }

    public static ChannelGrant name(String str) {
        ChannelGrant channelGrant = new ChannelGrant();
        channelGrant.resourceName = str;
        return channelGrant;
    }

    public static ChannelGrant pattern(String str) {
        ChannelGrant channelGrant = new ChannelGrant();
        channelGrant.resourcePattern = str;
        return channelGrant;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGrant delete() {
        return (ChannelGrant) super.delete();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGrant get() {
        return (ChannelGrant) super.get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGrant join() {
        return (ChannelGrant) super.join();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGrant manage() {
        return (ChannelGrant) super.manage();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGrant read() {
        return (ChannelGrant) super.read();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGrant update() {
        return (ChannelGrant) super.update();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public ChannelGrant write() {
        return (ChannelGrant) super.write();
    }
}
