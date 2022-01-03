package com.clubhouse.pubsub.user.backchannel.models.remote;

import i0.e.d.b.a.a.b.a;
import n0.c.e;
/* compiled from: ChatMessage.kt */
@e(with = a.class)
/* loaded from: classes2.dex */
public enum BackchannelMessageType {
    CHAT("chat"),
    MEMBER_ADDED("member_added"),
    MEMBER_REMOVED("member_removed"),
    UNAVAILABLE("unavailable");
    
    private final String value;

    BackchannelMessageType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
