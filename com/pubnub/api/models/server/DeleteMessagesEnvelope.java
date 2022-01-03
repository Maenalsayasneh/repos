package com.pubnub.api.models.server;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class DeleteMessagesEnvelope {
    private boolean error;
    @SerializedName("error_message")
    private String errorMessage;
    private Integer status;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Integer getStatus() {
        return this.status;
    }

    public boolean isError() {
        return this.error;
    }

    public void setError(boolean z) {
        this.error = z;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }
}
