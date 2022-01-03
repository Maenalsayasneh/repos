package com.pubnub.api.models.server.files;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class FormField {
    private final String key;
    private final String value;

    public FormField(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof FormField;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FormField)) {
            return false;
        }
        FormField formField = (FormField) obj;
        if (!formField.canEqual(this)) {
            return false;
        }
        String key = getKey();
        String key2 = formField.getKey();
        if (key != null ? !key.equals(key2) : key2 != null) {
            return false;
        }
        String value = getValue();
        String value2 = formField.getValue();
        return value != null ? value.equals(value2) : value2 == null;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String key = getKey();
        int i = 43;
        int hashCode = key == null ? 43 : key.hashCode();
        String value = getValue();
        int i2 = (hashCode + 59) * 59;
        if (value != null) {
            i = value.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder P0 = a.P0("FormField(key=");
        P0.append(getKey());
        P0.append(", value=");
        P0.append(getValue());
        P0.append(")");
        return P0.toString();
    }
}
