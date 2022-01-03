package com.pubnub.api.models;
/* loaded from: classes2.dex */
public class SubscriptionItem {
    private String name;
    private Object state;

    public boolean canEqual(Object obj) {
        return obj instanceof SubscriptionItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionItem)) {
            return false;
        }
        SubscriptionItem subscriptionItem = (SubscriptionItem) obj;
        if (!subscriptionItem.canEqual(this)) {
            return false;
        }
        String name = getName();
        String name2 = subscriptionItem.getName();
        if (name != null ? !name.equals(name2) : name2 != null) {
            return false;
        }
        Object state = getState();
        Object state2 = subscriptionItem.getState();
        return state != null ? state.equals(state2) : state2 == null;
    }

    public String getName() {
        return this.name;
    }

    public Object getState() {
        return this.state;
    }

    public int hashCode() {
        String name = getName();
        int i = 43;
        int hashCode = name == null ? 43 : name.hashCode();
        Object state = getState();
        int i2 = (hashCode + 59) * 59;
        if (state != null) {
            i = state.hashCode();
        }
        return i2 + i;
    }

    public SubscriptionItem setName(String str) {
        this.name = str;
        return this;
    }

    public SubscriptionItem setState(Object obj) {
        this.state = obj;
        return this;
    }
}
