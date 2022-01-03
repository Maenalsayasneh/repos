package com.clubhouse.android.channels.analytics;
/* compiled from: LeaveReason.kt */
/* loaded from: classes3.dex */
public enum LeaveReason {
    NOTIFICATION("Leave from notification"),
    LEAVE_BUTTON("Leave Quietly button"),
    ACTIVE_PING("Leave from active_ping response"),
    CHANNEL_REFRESH("Leave from get_channel response)"),
    PUBNUB_END("PubNub end message"),
    PUBNUB_LEAVE("PubNub leave message"),
    PUBNUB_REMOVED("PubNub remove message"),
    PUBNUB_ERROR("PubNub error"),
    SCOPE_RELEASE("Leave from scope release"),
    ENDED("Ended by self"),
    SIDE_CHANNEL("Transitioning to side channel"),
    LEAVE_WELCOME_ROOM("Leave Welcome room"),
    TASK_REMOVED("Leave from user swiping away app");
    
    private final String description;

    LeaveReason(String str) {
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }
}
