package com.clubhouse.android.data.models.local.channel;

import i0.e.b.b3.a.b.c.b;
import n0.c.e;
/* compiled from: ClipsPermission.kt */
@e(with = b.class)
/* loaded from: classes3.dex */
public enum ClipsPermission {
    NOT_ALLOWED(0),
    ALLOWED_FOR_ALL(1);
    
    private final int code;

    ClipsPermission(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
