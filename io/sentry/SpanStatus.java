package io.sentry;

import com.instabug.library.network.RequestResponse;
/* loaded from: classes4.dex */
public enum SpanStatus {
    OK(200, 299),
    CANCELLED(499),
    INTERNAL_ERROR(500),
    UNKNOWN(500),
    UNKNOWN_ERROR(500),
    INVALID_ARGUMENT(RequestResponse.HttpStatusCode._4xx.BAD_REQUEST),
    DEADLINE_EXCEEDED(504),
    NOT_FOUND(404),
    ALREADY_EXISTS(409),
    PERMISSION_DENIED(403),
    RESOURCE_EXHAUSTED(429),
    FAILED_PRECONDITION(RequestResponse.HttpStatusCode._4xx.BAD_REQUEST),
    ABORTED(409),
    OUT_OF_RANGE(RequestResponse.HttpStatusCode._4xx.BAD_REQUEST),
    UNIMPLEMENTED(501),
    UNAVAILABLE(503),
    DATA_LOSS(500),
    UNAUTHENTICATED(401);
    
    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;

    SpanStatus(int i) {
        this.minHttpStatusCode = i;
        this.maxHttpStatusCode = i;
    }

    public static SpanStatus fromHttpStatusCode(int i) {
        SpanStatus[] values = values();
        for (int i2 = 0; i2 < 18; i2++) {
            SpanStatus spanStatus = values[i2];
            if (spanStatus.matches(i)) {
                return spanStatus;
            }
        }
        return null;
    }

    private boolean matches(int i) {
        return i >= this.minHttpStatusCode && i <= this.maxHttpStatusCode;
    }

    public static SpanStatus fromHttpStatusCode(int i, SpanStatus spanStatus) {
        SpanStatus fromHttpStatusCode = fromHttpStatusCode(i);
        return fromHttpStatusCode != null ? fromHttpStatusCode : spanStatus;
    }

    SpanStatus(int i, int i2) {
        this.minHttpStatusCode = i;
        this.maxHttpStatusCode = i2;
    }
}
