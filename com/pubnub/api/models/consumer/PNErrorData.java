package com.pubnub.api.models.consumer;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class PNErrorData {
    private String information;
    private Exception throwable;

    public PNErrorData(String str, Exception exc) {
        this.information = str;
        this.throwable = exc;
    }

    public String getInformation() {
        return this.information;
    }

    public Exception getThrowable() {
        return this.throwable;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNErrorData(information=");
        P0.append(getInformation());
        P0.append(", throwable=");
        P0.append(getThrowable());
        P0.append(")");
        return P0.toString();
    }
}
