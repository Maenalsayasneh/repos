package com.instabug.library.model.session.config;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class SessionsConfig {
    private final int maxSessionsPerRequest;
    private final int syncIntervalsInMinutes;
    private final int syncMode;

    public SessionsConfig(int i, int i2, int i3) {
        this.syncIntervalsInMinutes = i;
        this.maxSessionsPerRequest = i2;
        this.syncMode = i3;
    }

    public static SessionsConfig createDefault() {
        return new SessionsConfig(720, 10, 2);
    }

    public int getMaxSessionsPerRequest() {
        return this.maxSessionsPerRequest;
    }

    public int getSyncIntervalsInMinutes() {
        return this.syncIntervalsInMinutes;
    }

    public int getSyncMode() {
        return this.syncMode;
    }

    public String toString() {
        StringBuilder P0 = a.P0("{syncIntervalsInMinutes = ");
        P0.append(this.syncIntervalsInMinutes);
        P0.append(", maxSessionsPerRequest = ");
        P0.append(this.maxSessionsPerRequest);
        P0.append(", syncMode = ");
        return a.u0(P0, this.syncMode, "}");
    }
}
