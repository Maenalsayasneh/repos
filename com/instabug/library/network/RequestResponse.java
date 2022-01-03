package com.instabug.library.network;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import i0.d.a.a.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class RequestResponse {
    private Map<String, String> headers;
    private Object responseBody;
    private int responseCode;

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface HttpStatusCode {

        @Keep
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface _2xx {
            public static final int OK = 200;
        }

        @Keep
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface _3xx {
            public static final int NOT_MODIFIED = 304;
        }

        @Keep
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface _4xx {
            public static final int BAD_REQUEST = 400;
            public static final int RATE_LIMIT_REACHED = 429;
        }
    }

    public Map<String, String> getHeaders() {
        Map<String, String> map = this.headers;
        return map == null ? Collections.emptyMap() : map;
    }

    public Object getResponseBody() {
        return this.responseBody;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public RequestResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public void setResponseBody(Object obj) {
        this.responseBody = obj;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toString() {
        StringBuilder P0 = a.P0("Response code: ");
        P0.append(this.responseCode);
        P0.append(", Response body: ");
        P0.append(this.responseBody);
        return P0.toString();
    }
}
