package com.pubnub.api.enums;

import com.pubnub.api.endpoints.objects_api.utils.Include;
/* loaded from: classes2.dex */
public enum PNSpaceFields {
    CUSTOM(Include.INCLUDE_CUSTOM_PARAM_VALUE);
    
    private final String value;

    PNSpaceFields(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.value;
    }
}
