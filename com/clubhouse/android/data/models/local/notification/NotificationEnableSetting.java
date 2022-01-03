package com.clubhouse.android.data.models.local.notification;

import i0.e.b.b3.a.a.e.g;
import n0.c.e;
/* compiled from: NotificationEnableSetting.kt */
@e(with = g.class)
/* loaded from: classes3.dex */
public enum NotificationEnableSetting {
    NULL(-1),
    YES(1),
    NO(2);
    
    private final int code;

    NotificationEnableSetting(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
