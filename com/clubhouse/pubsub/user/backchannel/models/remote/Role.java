package com.clubhouse.pubsub.user.backchannel.models.remote;

import n0.c.e;
/* compiled from: ChatMember.kt */
@e(with = i0.e.d.b.a.a.b.e.class)
/* loaded from: classes2.dex */
public enum Role {
    MEMBER("member"),
    ADMIN("admin");
    
    private final String value;

    Role(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
