package com.clubhouse.android.notifications;

import com.pubnub.api.endpoints.objects_api.utils.Include;
/* compiled from: NotificationUtil.kt */
/* loaded from: classes3.dex */
public enum NotificationAction {
    ExpireChannel("expire_channel", Include.INCLUDE_CHANNEL_PARAM_VALUE, 3311),
    OpenChannel("open_channel", Include.INCLUDE_CHANNEL_PARAM_VALUE, 3311),
    OpenClub("open_club", "club_id", 3312),
    OpenInvites("open_invites", "num_invites", 3313),
    OpenEvent("open_event", "event_id", 3311),
    OpenProfile("open_profile", "user_id", 3310),
    OpenChat("open_chat", "message_id", 3315),
    OpenUrl("open_url", "url", 3310),
    OpenRecentPayments("acknowledge_payment", "payment", 3314),
    OpenWaveChannel("send_wave", "wave_id", 3316),
    ExpireWaveChannel("expire_wave", "wave_id", 3316);
    
    private final String action;
    private final String dataKey;
    private final int notificationId;

    NotificationAction(String str, String str2, int i) {
        this.action = str;
        this.dataKey = str2;
        this.notificationId = i;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getDataKey() {
        return this.dataKey;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }
}
