package com.pubnub.api.enums;
/* loaded from: classes2.dex */
public enum PNPushType {
    APNS("apns"),
    MPNS("mpns"),
    GCM("gcm"),
    FCM("gcm"),
    APNS2("apns2");
    
    private final String value;

    PNPushType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.value;
    }
}
