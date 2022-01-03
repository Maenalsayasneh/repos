package com.instabug.library.n.b.a;

import android.annotation.SuppressLint;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: TimelinePoint.java */
/* loaded from: classes2.dex */
public abstract class f implements Serializable {
    public double c;

    public abstract JSONObject a() throws JSONException;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public JSONObject b(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", this.c);
        jSONObject.put("v", obj);
        return jSONObject;
    }
}
