package com.instabug.library.model.session;

import androidx.annotation.Keep;
import com.instabug.library.model.common.Session;
import i0.j.e.l0.a.b;
import i0.j.e.l0.a.c;
@Keep
/* loaded from: classes2.dex */
public class CoreSession implements Session {
    @b
    @c(name = "application_token")
    private final String appToken;
    @b
    @c(name = "app_version")
    private final String appVersion;
    @b
    @c(name = "crash_reporting_enabled")
    private final boolean crashReportingEnabled;
    @b
    @c(alternate = SessionParameter.CUSTOM_ATTRIBUTES_KEYS, name = SessionParameter.CUSTOM_ATTRIBUTES)
    private final String customAttributes;
    @b
    @c(name = "device")
    private final String device;
    @b
    @c(name = "duration")
    private final long duration;
    private final String id;
    @b
    @c(name = "os")
    private final String os;
    @b
    @c(name = "sdk_version")
    private final String sdkVersion;
    private final long startNanoTime;
    @b
    @c(name = "started_at")
    private final long startTimestampMicros;
    private final int syncStatus;
    @b
    @c(name = "email")
    private final String userEmail;
    @b
    @c(alternate = SessionParameter.USER_EVENTS_KEYS, name = "user_events")
    private final String userEvents;
    @b
    @c(name = "name")
    private final String userName;
    private final boolean usersPageEnabled;
    @b
    @c(name = "uuid")
    private final String uuid;

    public CoreSession(String str) {
        this(str, "null", null, 0, 0, 0, null, null, null, "null", null, null, false, 0, "null", null, false);
    }

    public String getAppToken() {
        return this.appToken;
    }

    @Override // com.instabug.library.model.common.Session
    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCustomAttributes() {
        return this.customAttributes;
    }

    public String getDevice() {
        return this.device;
    }

    public long getDuration() {
        return this.duration;
    }

    @Override // com.instabug.library.model.common.Session
    public String getId() {
        return this.id;
    }

    @Override // com.instabug.library.model.common.Session
    public String getOs() {
        return this.os;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.instabug.library.model.common.Session
    public long getStartNanoTime() {
        return this.startNanoTime;
    }

    @Override // com.instabug.library.model.common.Session
    public long getStartTimestampMicros() {
        return this.startTimestampMicros;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserEvents() {
        return this.userEvents;
    }

    public String getUserName() {
        return this.userName;
    }

    @Override // com.instabug.library.model.common.Session
    public String getUuid() {
        return this.uuid;
    }

    public boolean isCrashReportingEnabled() {
        return this.crashReportingEnabled;
    }

    public boolean isUsersPageEnabled() {
        return this.usersPageEnabled;
    }

    public CoreSession(String str, String str2, String str3, String str4, long j, long j2) {
        this(str, str2, null, 0, j, j2, null, null, null, str4, null, null, false, 0, str3, null, false);
    }

    public CoreSession(String str, String str2, String str3, long j, long j2, long j3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, int i, String str10, String str11, boolean z2) {
        this.id = str;
        this.os = str2;
        this.device = str3;
        this.duration = j;
        this.startTimestampMicros = j2;
        this.userName = str4;
        this.userEmail = str5;
        this.sdkVersion = str6;
        this.appVersion = str7;
        this.userEvents = str8;
        this.customAttributes = str9;
        this.crashReportingEnabled = z;
        this.syncStatus = i;
        this.uuid = str10;
        this.appToken = str11;
        this.usersPageEnabled = z2;
        this.startNanoTime = j3;
    }
}
