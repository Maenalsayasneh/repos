package com.google.android.datatransport.runtime;

import com.google.auto.value.AutoValue;
import i0.h.a.a.i.a;
import i0.h.a.a.i.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@AutoValue
/* loaded from: classes2.dex */
public abstract class EventInternal {

    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public final a a(String str, String str2) {
            c().put(str, str2);
            return this;
        }

        public abstract EventInternal b();

        public abstract Map<String, String> c();

        public abstract a d(e eVar);

        public abstract a e(long j);

        public abstract a f(String str);

        public abstract a g(long j);
    }

    public static a builder() {
        a.b bVar = new a.b();
        bVar.f = new HashMap();
        return bVar;
    }

    public final String get(String str) {
        String str2 = getAutoMetadata().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map<String, String> getAutoMetadata();

    public abstract Integer getCode();

    public abstract e getEncodedPayload();

    public abstract long getEventMillis();

    public final int getInteger(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long getLong(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(getAutoMetadata());
    }

    public final String getOrDefault(String str, String str2) {
        String str3 = getAutoMetadata().get(str);
        return str3 == null ? str2 : str3;
    }

    @Deprecated
    public byte[] getPayload() {
        return getEncodedPayload().b;
    }

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public a toBuilder() {
        a.b bVar = new a.b();
        bVar.f(getTransportName());
        bVar.b = getCode();
        bVar.d(getEncodedPayload());
        bVar.e(getEventMillis());
        bVar.g(getUptimeMillis());
        bVar.f = new HashMap(getAutoMetadata());
        return bVar;
    }
}
