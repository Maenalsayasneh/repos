package com.clubhouse.android.data.models.remote.request;

import i0.e.b.b3.a.b.c.g;
import n0.c.e;
/* compiled from: SearchRequest.kt */
@e(with = g.class)
/* loaded from: classes3.dex */
public enum SearchItemType {
    USERS("UserProfile"),
    CLUBS("Club"),
    CHANNELS("LiveChannel"),
    EVENTS("Event");
    
    private final String value;

    SearchItemType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
