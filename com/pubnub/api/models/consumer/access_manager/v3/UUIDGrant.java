package com.pubnub.api.models.consumer.access_manager.v3;
/* loaded from: classes2.dex */
public class UUIDGrant extends PNResource<UUIDGrant> {
    private UUIDGrant() {
    }

    public static UUIDGrant id(String str) {
        UUIDGrant uUIDGrant = new UUIDGrant();
        uUIDGrant.resourceName = str;
        return uUIDGrant;
    }

    public static UUIDGrant pattern(String str) {
        UUIDGrant uUIDGrant = new UUIDGrant();
        uUIDGrant.resourcePattern = str;
        return uUIDGrant;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public UUIDGrant delete() {
        return (UUIDGrant) super.delete();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public UUIDGrant get() {
        return (UUIDGrant) super.get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pubnub.api.models.consumer.access_manager.v3.PNResource
    public UUIDGrant update() {
        return (UUIDGrant) super.update();
    }
}
