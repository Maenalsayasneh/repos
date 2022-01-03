package com.instabug.library.networkv2.request;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RequestParameter<V> implements Serializable {
    private String key;
    private V value;

    public RequestParameter(String str, V v) {
        this.key = str;
        this.value = v;
    }

    public String getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
