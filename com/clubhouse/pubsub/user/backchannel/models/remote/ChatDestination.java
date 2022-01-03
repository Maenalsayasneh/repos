package com.clubhouse.pubsub.user.backchannel.models.remote;

import i0.e.d.b.a.a.b.b;
import n0.c.e;
/* compiled from: ChatDestination.kt */
@e(with = b.class)
/* loaded from: classes2.dex */
public enum ChatDestination {
    CHATS("chats", 0),
    REQUESTS("requests", 1);
    
    private final int index;
    private final String value;

    ChatDestination(String str, int i) {
        this.value = str;
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getValue() {
        return this.value;
    }
}
