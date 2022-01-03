package com.pubnub.api.models.consumer.message_actions;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class PNMessageAction {
    private Long actionTimetoken;
    private Long messageTimetoken;
    private String type;
    private String uuid;
    private String value;

    public PNMessageAction() {
    }

    public Long getActionTimetoken() {
        return this.actionTimetoken;
    }

    public Long getMessageTimetoken() {
        return this.messageTimetoken;
    }

    public String getType() {
        return this.type;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getValue() {
        return this.value;
    }

    public PNMessageAction setMessageTimetoken(Long l) {
        this.messageTimetoken = l;
        return this;
    }

    public PNMessageAction setType(String str) {
        this.type = str;
        return this;
    }

    public PNMessageAction setValue(String str) {
        this.value = str;
        return this;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNMessageAction(type=");
        P0.append(getType());
        P0.append(", value=");
        P0.append(getValue());
        P0.append(", messageTimetoken=");
        P0.append(getMessageTimetoken());
        P0.append(", uuid=");
        P0.append(getUuid());
        P0.append(", actionTimetoken=");
        P0.append(getActionTimetoken());
        P0.append(")");
        return P0.toString();
    }

    public PNMessageAction(PNMessageAction pNMessageAction) {
        this.type = pNMessageAction.type;
        this.value = pNMessageAction.value;
        this.uuid = pNMessageAction.uuid;
        this.actionTimetoken = pNMessageAction.actionTimetoken;
        this.messageTimetoken = pNMessageAction.messageTimetoken;
    }
}
