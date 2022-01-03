package com.clubhouse.android.shared;
/* compiled from: FeatureFlags.kt */
/* loaded from: classes3.dex */
public enum Flag {
    DisableAmplitude("DISABLE_AMPLITUDE"),
    DisableRCForFollow("DISABLE_RC_FOR_FOLLOW"),
    DisableInAppReview("DISABLE_REVIEWS"),
    AgoraLogging("ENABLE_AGORA_SDK_LOGGING"),
    DebugView("ENABLE_DEBUG_VIEW"),
    Instabug("ENABLE_INSTABUG"),
    EnableDirectPaymentsRegistration("ENABLE_DIRECT_PAYMENTS_REGISTRATION"),
    AlwaysUseTestStripeKey("ALWAYS_USE_TEST_STRIPE_KEY"),
    EnableMultiStepIncidentReport("ENABLE_MULTI_STEP_INCIDENT_REPORT_V2"),
    EnableReportRoomHallway("ENABLE_REPORT_ROOM_HALLWAY"),
    EnableWaves("ENABLE_WAVES"),
    DisableReportRecentSpeakers("DISABLE_REPORT_RECENT_SPEAKERS"),
    EnableAudioSpatialization("ENABLE_AUDIO_SPATIALIZATION");
    
    private final String key;

    Flag(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }
}
