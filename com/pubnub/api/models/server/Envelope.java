package com.pubnub.api.models.server;

import com.google.gson.JsonElement;
/* loaded from: classes2.dex */
public class Envelope<T> {
    private String action;
    private boolean error;
    private String message;
    private int occupancy;
    private T payload;
    private String service;
    private int status;
    private JsonElement uuids;

    public String getAction() {
        return this.action;
    }

    public String getMessage() {
        return this.message;
    }

    public int getOccupancy() {
        return this.occupancy;
    }

    public T getPayload() {
        return this.payload;
    }

    public String getService() {
        return this.service;
    }

    public int getStatus() {
        return this.status;
    }

    public JsonElement getUuids() {
        return this.uuids;
    }

    public boolean isError() {
        return this.error;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setError(boolean z) {
        this.error = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOccupancy(int i) {
        this.occupancy = i;
    }

    public void setPayload(T t) {
        this.payload = t;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUuids(JsonElement jsonElement) {
        this.uuids = jsonElement;
    }
}
