package com.clubhouse.android.data.models.local.user;

import com.clubhouse.android.data.R;
import com.google.android.gms.recaptcha.RecaptchaActionType;
/* compiled from: ReportReason.kt */
/* loaded from: classes3.dex */
public enum ReportReason {
    BLANK("", R.string.report_blank),
    ABUSE("abuse__bullying__or_harassment", R.string.report_abuse),
    DISCRIMINATION("discrimination_or_hateful_conduct", R.string.report_discrimination),
    INAPPROPRIATE("inappropriate_or_harmful_content", R.string.report_offensive_content),
    TROLLING("trolling", R.string.report_trolling),
    FALSE_INFORMATION("false_information", R.string.report_false_info),
    PLATFORM_MANIPULATION("platform_manipulation", R.string.report_spam),
    ENCOURAGING_USERS_TO_VIOLATE_RULES("encouraging_users_to_violate_rules", R.string.report_rules_violation),
    REAL_NAME("real_name_and_identity", R.string.report_identity),
    AGE_REQUIREMENT("age_requirement", R.string.report_age),
    ILLEGAL_ACTIVITIES("illegal_activities", R.string.report_illegal),
    VIOLENCE("violence_or_harm", R.string.report_violence),
    SHARING_OTHERS_PRIVATE_INFORMATION("sharing_of_others__private_information", R.string.report_private_information),
    FAKE_BADGES("fake_badges", R.string.report_fake_badges),
    INTELLECTUAL_PROPERTY("intellectual_property__copyright__or_trademark", R.string.report_ip_misuse),
    RECORDING("recording__transcribing__or_reproducing_content", R.string.report_recording),
    SYNTHETIC_OR_MANIPULATED_MEDIA("synthetic_or_manipulated_media", R.string.report_manipulated_media),
    SELF_HARM("self-harm_or_suicide", R.string.report_self_harm),
    OTHER(RecaptchaActionType.OTHER, R.string.report_other);
    
    private final int displayName;
    private final String reason;

    ReportReason(String str, int i) {
        this.reason = str;
        this.displayName = i;
    }

    public final int getDisplayName() {
        return this.displayName;
    }

    public final String getReason() {
        return this.reason;
    }
}
