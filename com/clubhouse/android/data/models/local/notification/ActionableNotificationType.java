package com.clubhouse.android.data.models.local.notification;

import i0.e.b.b3.a.a.e.a;
import n0.c.e;
/* compiled from: ActionableNotificationType.kt */
@e(with = a.class)
/* loaded from: classes3.dex */
public enum ActionableNotificationType {
    UNKNOWN(-1),
    INVITED_TO_CLUB(1),
    PENDING_NOMINATIONS_TO_CLUB(2),
    ON_CLUBHOUSE(3),
    FOLLOWED_YOU(4),
    CLUB_ADD_TOPICS(6),
    USER_ADD_TOPICS(7),
    CLUB_REVIEW_CHANGES(8),
    FRIEND_ON_WAITLIST(5);
    
    private final int code;

    ActionableNotificationType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
