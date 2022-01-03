package com.clubhouse.android.notifications;
/* compiled from: NotificationUtil.kt */
/* loaded from: classes3.dex */
public enum ClubhouseDeprecatedNotifications {
    ROOMS("Rooms"),
    WELCOME_ROOMS("WelcomeRooms"),
    EVENTS("Events"),
    INVITES("Invites"),
    CLUBS("Clubs"),
    PEOPLE("People"),
    CLUB_IMPORTANT("Club_Important"),
    CLUB_OTHER("Club_Other"),
    OTHER("Other"),
    ROOM_EVENT_IMPORTANT("Room_Event_Important"),
    ROOM_EVENT_OTHER("Room_Event_Other"),
    CLUBHOUSE("Clubhouse"),
    UPDATES("Updates");
    
    private final String channelId;

    ClubhouseDeprecatedNotifications(String str) {
        this.channelId = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }
}
