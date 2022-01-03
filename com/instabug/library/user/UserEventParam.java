package com.instabug.library.user;

import android.annotation.SuppressLint;
/* loaded from: classes2.dex */
public class UserEventParam {
    private String key;
    private String value;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public boolean equals(Object obj) {
        if (!(obj instanceof UserEventParam)) {
            return false;
        }
        UserEventParam userEventParam = (UserEventParam) obj;
        if (!String.valueOf(userEventParam.getKey()).equals(String.valueOf(getKey())) || !String.valueOf(userEventParam.getValue()).equals(String.valueOf(getValue()))) {
            return false;
        }
        return true;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        if (getKey() == null || getValue() == null) {
            return -1;
        }
        return (getKey() + ": " + getValue()).hashCode();
    }

    public UserEventParam setKey(String str) {
        this.key = str;
        return this;
    }

    public UserEventParam setValue(String str) {
        this.value = str;
        return this;
    }
}
