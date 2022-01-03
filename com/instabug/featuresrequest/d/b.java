package com.instabug.featuresrequest.d;

import android.annotation.SuppressLint;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FeatureRequest.java */
/* loaded from: classes2.dex */
public class b implements Cacheable, Serializable {
    public String Y1;
    public long Z1;
    public int a2;
    public int b2;
    public boolean c2;
    public String d;
    public String d2;
    public String e2;
    public String f2;
    public String q;
    public String y;
    public EnumC0021b g2 = EnumC0021b.NOTHING;
    public a x = a.Open;
    public long c = System.currentTimeMillis() / 1000;

    /* compiled from: FeatureRequest.java */
    /* loaded from: classes2.dex */
    public enum a {
        Open(0),
        Planned(1),
        InProgress(2),
        Completed(3),
        MaybeLater(4);
        
        private int status;

        a(int i) {
            this.status = i;
        }

        public int a() {
            return this.status;
        }
    }

    /* compiled from: FeatureRequest.java */
    /* renamed from: com.instabug.featuresrequest.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0021b {
        NOTHING(0),
        UPLOADED(1),
        USER_VOTED_UP(2),
        USER_UN_VOTED(3);
        
        private int status;

        EnumC0021b(int i) {
            this.status = i;
        }

        public int a() {
            return this.status;
        }
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
    public b(String str, String str2, String str3) {
        this.d2 = str;
        this.e2 = str2;
        this.f2 = str3;
    }

    @Override // com.instabug.library.internal.storage.cache.Cacheable
    public void fromJson(String str) throws JSONException {
        InstabugSDKLogger.addVerboseLog("FeatureRequest", str);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            this.c = jSONObject.getLong("id");
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE)) {
            this.d = jSONObject.getString(InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE);
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_DESCRIPTION)) {
            this.q = jSONObject.getString(InstabugDbContract.FeatureRequestEntry.COLUMN_DESCRIPTION);
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_CREATOR_NAME)) {
            this.Y1 = jSONObject.getString(InstabugDbContract.FeatureRequestEntry.COLUMN_CREATOR_NAME);
        }
        if (jSONObject.has("status")) {
            int i = jSONObject.getInt("status");
            if (i == 0) {
                this.x = a.Open;
            } else if (i == 1) {
                this.x = a.Planned;
            } else if (i == 2) {
                this.x = a.InProgress;
            } else if (i == 3) {
                this.x = a.Completed;
            } else if (i == 4) {
                this.x = a.MaybeLater;
            }
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_COLOR_CODE)) {
            this.y = jSONObject.getString(InstabugDbContract.FeatureRequestEntry.COLUMN_COLOR_CODE);
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_LIKES_COUNT)) {
            this.a2 = jSONObject.getInt(InstabugDbContract.FeatureRequestEntry.COLUMN_LIKES_COUNT);
        }
        if (jSONObject.has("date")) {
            this.Z1 = jSONObject.getLong("date");
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_COMMENTS_COUNT)) {
            this.b2 = jSONObject.getInt(InstabugDbContract.FeatureRequestEntry.COLUMN_COMMENTS_COUNT);
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_IS_LIKED)) {
            this.c2 = jSONObject.getBoolean(InstabugDbContract.FeatureRequestEntry.COLUMN_IS_LIKED);
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_VOTE_UPDATED)) {
            int i2 = jSONObject.getInt(InstabugDbContract.FeatureRequestEntry.COLUMN_VOTE_UPDATED);
            if (i2 == 0) {
                this.g2 = EnumC0021b.NOTHING;
            } else if (i2 == 1) {
                this.g2 = EnumC0021b.UPLOADED;
            } else if (i2 == 2) {
                this.g2 = EnumC0021b.USER_VOTED_UP;
            } else if (i2 != 3) {
                this.g2 = EnumC0021b.NOTHING;
            } else {
                this.g2 = EnumC0021b.USER_UN_VOTED;
            }
        }
    }

    @Override // com.instabug.library.internal.storage.cache.Cacheable
    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.c).put(InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE, this.d).put(InstabugDbContract.FeatureRequestEntry.COLUMN_DESCRIPTION, this.q).put("status", this.x.a()).put("date", this.Z1).put(InstabugDbContract.FeatureRequestEntry.COLUMN_LIKES_COUNT, this.a2).put(InstabugDbContract.FeatureRequestEntry.COLUMN_COMMENTS_COUNT, this.b2).put(InstabugDbContract.FeatureRequestEntry.COLUMN_IS_LIKED, this.c2).put(InstabugDbContract.FeatureRequestEntry.COLUMN_VOTE_UPDATED, this.g2.a()).put(InstabugDbContract.FeatureRequestEntry.COLUMN_COLOR_CODE, this.y).put(InstabugDbContract.FeatureRequestEntry.COLUMN_CREATOR_NAME, this.Y1);
        return jSONObject.toString();
    }
}
