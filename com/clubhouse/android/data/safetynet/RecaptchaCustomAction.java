package com.clubhouse.android.data.safetynet;

import com.pubnub.api.PubNubUtil;
/* compiled from: SafetyNetClient.kt */
/* loaded from: classes3.dex */
public enum RecaptchaCustomAction {
    Auth(PubNubUtil.AUTH_QUERY_PARAM_NAME),
    Follow("followAuth");
    
    private final String action;

    RecaptchaCustomAction(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}
