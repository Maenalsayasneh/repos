package okhttp3.internal.http2;

import m0.n.b.f;
/* compiled from: ErrorCode.kt */
/* loaded from: classes4.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    
    public static final a Companion = new a(null);
    private final int httpCode;

    /* compiled from: ErrorCode.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a(f fVar) {
        }

        public final ErrorCode a(int i) {
            ErrorCode[] values = ErrorCode.values();
            for (int i2 = 0; i2 < 14; i2++) {
                ErrorCode errorCode = values[i2];
                if (errorCode.getHttpCode() == i) {
                    return errorCode;
                }
            }
            return null;
        }
    }

    ErrorCode(int i) {
        this.httpCode = i;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
