package com.instabug.library.internal.storage.cache;

import org.json.JSONException;
/* loaded from: classes2.dex */
public interface Cacheable {
    void fromJson(String str) throws JSONException;

    String toJson() throws JSONException;
}
