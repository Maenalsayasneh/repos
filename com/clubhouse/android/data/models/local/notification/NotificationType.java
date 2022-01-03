package com.clubhouse.android.data.models.local.notification;

import i0.e.b.b3.a.a.e.l;
import n0.c.e;
/* compiled from: NotificationType.kt */
@e(with = l.class)
/* loaded from: classes3.dex */
public enum NotificationType {
    UNKNOWN(-1),
    FOLLOWS_YOU(1),
    ON_CLUBHOUSE(2),
    STARTED_ROOM(3),
    SENT_MESSAGE(4),
    SENT_MESSAGE_WITH_URL(5),
    INVITED_TO_CLUB(6),
    ACCEPTED_CLUB_INVITE(7),
    MADE_CLUB_ADMIN(8),
    INVITE_TO_EXISTING_CHANNEL(9),
    FOLLOWED_CLUB(10),
    WELCOME_ROOM(11),
    APPROVED_TO_JOIN_CLUB(12),
    JOINED_CLUB(13),
    SCHEDULED_EVENT_COHOST(15),
    SCHEDULED_EVENT_GUEST(16),
    NEW_CLUB_CREATED(18),
    REMINDER_HOST_CLUB_EVENT(19),
    FOLLOWS_YOU_STACKED(20),
    FOLLOW_US_ON_TWITTER(21),
    FOLLOWED_CLUB_STACKED(22),
    DIRECT_PAYMENT_RECEIVED(23),
    DIRECT_PAYMENT_ACKNOWLEDGED(24),
    CLUB_INVITES_GIVEN(17),
    INVITES_GIVEN(14);
    
    private final int code;

    NotificationType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
