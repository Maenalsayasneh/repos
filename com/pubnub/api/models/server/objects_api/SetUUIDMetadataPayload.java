package com.pubnub.api.models.server.objects_api;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class SetUUIDMetadataPayload {
    private final Object custom;
    private final String email;
    private final String externalId;
    private final String name;
    private final String profileUrl;

    public SetUUIDMetadataPayload(String str, String str2, String str3, String str4, Object obj) {
        this.name = str;
        this.email = str2;
        this.externalId = str3;
        this.profileUrl = str4;
        this.custom = obj;
    }

    public Object getCustom() {
        return this.custom;
    }

    public String getEmail() {
        return this.email;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getName() {
        return this.name;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public String toString() {
        StringBuilder P0 = a.P0("SetUUIDMetadataPayload(name=");
        P0.append(getName());
        P0.append(", email=");
        P0.append(getEmail());
        P0.append(", externalId=");
        P0.append(getExternalId());
        P0.append(", profileUrl=");
        P0.append(getProfileUrl());
        P0.append(", custom=");
        P0.append(getCustom());
        P0.append(")");
        return P0.toString();
    }
}
