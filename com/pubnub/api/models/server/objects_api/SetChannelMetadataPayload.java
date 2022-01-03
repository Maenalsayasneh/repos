package com.pubnub.api.models.server.objects_api;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class SetChannelMetadataPayload {
    private final Object custom;
    private final String description;
    private final String name;

    public SetChannelMetadataPayload(String str, String str2, Object obj) {
        this.name = str;
        this.description = str2;
        this.custom = obj;
    }

    public Object getCustom() {
        return this.custom;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder P0 = a.P0("SetChannelMetadataPayload(name=");
        P0.append(getName());
        P0.append(", description=");
        P0.append(getDescription());
        P0.append(", custom=");
        P0.append(getCustom());
        P0.append(")");
        return P0.toString();
    }
}
