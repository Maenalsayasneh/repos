package com.clubhouse.android.data.models.local.notification;

import com.clubhouse.android.data.R;
import i0.e.b.b3.a.b.c.d;
import n0.c.e;
/* compiled from: FollowNotificationType.kt */
@e(with = d.class)
/* loaded from: classes3.dex */
public enum FollowNotificationType {
    ALWAYS(1, R.string.follow_notification_always),
    SOMETIMES(2, R.string.follow_notification_sometimes),
    NEVER(3, R.string.follow_notification_never);
    
    private final int code;
    private final int label;

    FollowNotificationType(int i, int i2) {
        this.code = i;
        this.label = i2;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getLabel() {
        return this.label;
    }
}
