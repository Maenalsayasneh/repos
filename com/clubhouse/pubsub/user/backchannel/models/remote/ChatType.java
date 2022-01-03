package com.clubhouse.pubsub.user.backchannel.models.remote;

import i0.e.d.b.a.a.b.c;
import n0.c.e;
/* compiled from: ChatType.kt */
@e(with = c.class)
/* loaded from: classes2.dex */
public enum ChatType {
    ONE_ON_ONE("one_on_one"),
    GROUP("group");
    
    private final String value;

    ChatType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
