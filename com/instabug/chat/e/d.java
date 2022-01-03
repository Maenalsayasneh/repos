package com.instabug.chat.e;

import android.annotation.SuppressLint;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: Message.java */
/* loaded from: classes2.dex */
public class d implements Cacheable, Serializable {
    public long Y1;
    public boolean Z1;
    public long a2;
    public ArrayList<a> b2;
    public String c;
    public ArrayList<e> c2;
    public String d;
    public b d2;
    public c e2;
    public String f2;
    public String g2;
    public String h2;
    public String q;
    public String x;
    public String y;

    /* compiled from: Message.java */
    /* loaded from: classes2.dex */
    public enum b {
        INBOUND("inbound"),
        OUTBOUND("outbound"),
        NOT_AVAILABLE("not-available");
        
        private final String direction;

        b(String str) {
            this.direction = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.direction;
        }
    }

    /* compiled from: Message.java */
    /* loaded from: classes2.dex */
    public enum c {
        STAY_OFFLINE,
        READY_TO_BE_SENT,
        SENT,
        READY_TO_BE_SYNCED,
        SYNCED,
        NOT_AVAILABLE
    }

    public d(String str, String str2, String str3) {
        this(String.valueOf(System.currentTimeMillis()), str, str2, str3);
    }

    public d a(b bVar) {
        this.d2 = bVar;
        if (bVar == b.INBOUND) {
            this.Z1 = true;
        }
        return this;
    }

    public d b(long j) {
        this.a2 = j;
        if (j != 0) {
            this.Z1 = true;
        }
        return this;
    }

    public boolean c() {
        b bVar = this.d2;
        return bVar != null && bVar == b.INBOUND;
    }

    @Override // java.lang.Object
    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        ArrayList<a> arrayList;
        ArrayList<e> arrayList2;
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (String.valueOf(dVar.c).equals(String.valueOf(this.c)) && String.valueOf(dVar.d).equals(String.valueOf(this.d)) && String.valueOf(dVar.x).equals(String.valueOf(this.x)) && String.valueOf(dVar.y).equals(String.valueOf(this.y)) && String.valueOf(dVar.q).equals(String.valueOf(this.q)) && dVar.Y1 == this.Y1 && dVar.e2 == this.e2 && dVar.d2 == this.d2 && dVar.c() == c() && dVar.Z1 == this.Z1 && dVar.a2 == this.a2 && (arrayList = dVar.b2) != null && arrayList.size() == this.b2.size() && (arrayList2 = dVar.c2) != null && arrayList2.size() == this.c2.size()) {
                for (int i = 0; i < dVar.b2.size(); i++) {
                    if (!dVar.b2.get(i).equals(this.b2.get(i))) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < dVar.c2.size(); i2++) {
                    if (!dVar.c2.get(i2).equals(this.c2.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.instabug.library.internal.storage.cache.Cacheable
    public void fromJson(String str) throws JSONException {
        b bVar;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            this.c = jSONObject.getString("id");
        }
        if (jSONObject.has("chat_id")) {
            this.d = jSONObject.getString("chat_id");
        }
        if (jSONObject.has("body")) {
            this.q = jSONObject.getString("body");
        }
        if (jSONObject.has("sender_name")) {
            this.x = jSONObject.getString("sender_name");
        }
        if (jSONObject.has("sender_avatar_url")) {
            this.y = jSONObject.getString("sender_avatar_url");
        }
        if (jSONObject.has("messaged_at")) {
            this.Y1 = jSONObject.getLong("messaged_at");
        }
        if (jSONObject.has("read")) {
            this.Z1 = jSONObject.getBoolean("read");
        }
        if (jSONObject.has("read_at")) {
            b(jSONObject.getLong("read_at"));
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.TABLE_NAME)) {
            JSONArray jSONArray = jSONObject.getJSONArray(InstabugDbContract.AttachmentEntry.TABLE_NAME);
            ArrayList<a> arrayList = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                a aVar = new a();
                aVar.fromJson(jSONArray.getJSONObject(i).toString());
                arrayList.add(aVar);
            }
            this.b2 = arrayList;
        }
        if (jSONObject.has("actions")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("actions");
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                e eVar = new e();
                eVar.fromJson(jSONArray2.getString(i2));
                arrayList2.add(eVar);
            }
            this.c2 = arrayList2;
        }
        if (jSONObject.has("direction")) {
            String string = jSONObject.getString("direction");
            string.hashCode();
            if (string.equals("inbound")) {
                bVar = b.INBOUND;
            } else if (!string.equals("outbound")) {
                bVar = b.NOT_AVAILABLE;
            } else {
                bVar = b.OUTBOUND;
            }
            a(bVar);
        }
        if (jSONObject.has("messages_state")) {
            this.e2 = c.valueOf(jSONObject.getString("messages_state"));
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.c;
        if (str != null) {
            return str.hashCode();
        }
        return -1;
    }

    @Override // com.instabug.library.internal.storage.cache.Cacheable
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject put = jSONObject.put("id", this.c).put("chat_id", this.d).put("body", this.q).put("sender_name", this.x).put("sender_avatar_url", this.y).put("messaged_at", this.Y1).put("read", this.Z1).put("read_at", this.a2).put("messages_state", this.e2.toString()).put("direction", this.d2.toString());
        ArrayList<a> arrayList = this.b2;
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(new JSONObject(arrayList.get(i).toJson()));
        }
        JSONObject put2 = put.put(InstabugDbContract.AttachmentEntry.TABLE_NAME, jSONArray);
        ArrayList<e> arrayList2 = this.c2;
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            jSONArray2.put(arrayList2.get(i2).toJson());
        }
        put2.put("actions", jSONArray2);
        return jSONObject.toString();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder P0 = i0.d.a.a.a.P0("Message:[");
        P0.append(this.c);
        P0.append(", ");
        P0.append(this.d);
        P0.append(", ");
        P0.append(this.q);
        P0.append(", ");
        P0.append(this.Y1);
        P0.append(", ");
        P0.append(this.a2);
        P0.append(", ");
        P0.append(this.x);
        P0.append(", ");
        P0.append(this.y);
        P0.append(", ");
        P0.append(this.e2);
        P0.append(", ");
        P0.append(this.d2);
        P0.append(", ");
        P0.append(this.Z1);
        P0.append(", ");
        P0.append(this.b2);
        P0.append("]");
        return P0.toString();
    }

    /* compiled from: Message.java */
    /* loaded from: classes2.dex */
    public static class a implements Comparator<d>, Serializable {
        public int c;

        public a() {
            this.c = 2;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            String str;
            d dVar3 = dVar;
            d dVar4 = dVar2;
            int i = this.c;
            if (i == 1) {
                String str2 = dVar3.d;
                if (!(str2 == null || (str = dVar4.d) == null)) {
                    return str2.compareTo(str);
                }
            } else if (i != 2) {
                throw new IllegalStateException("Message comparator wasn't provided comparison messageIssueType");
            }
            return new Date(dVar3.Y1).compareTo(new Date(dVar4.Y1));
        }

        public a(int i) {
            this.c = 2;
            this.c = i;
        }
    }

    public d(String str, String str2, String str3, String str4) {
        this.c = str;
        this.b2 = new ArrayList<>();
        this.c2 = new ArrayList<>();
        this.d2 = b.NOT_AVAILABLE;
        this.e2 = c.NOT_AVAILABLE;
        this.f2 = str2;
        this.g2 = str3;
        this.h2 = str4;
    }
}
