package com.pubnub.api.enums;

import com.pubnub.api.endpoints.objects_api.utils.Include;
/* loaded from: classes2.dex */
public enum PNMemberFields {
    CUSTOM(Include.INCLUDE_CUSTOM_PARAM_VALUE),
    USER("user"),
    USER_CUSTOM("user.custom");
    
    private final String value;

    PNMemberFields(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.value;
    }
}
