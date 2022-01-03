package io.sentry.exception;

import i0.d.a.a.a;
/* loaded from: classes4.dex */
public final class InvalidSentryTraceHeaderException extends Exception {
    private static final long serialVersionUID = 1;
    private final String sentryTraceHeader;

    public InvalidSentryTraceHeaderException(String str) {
        super(a.n0("sentry-trace header does not conform to expected format: ", str));
        this.sentryTraceHeader = str;
    }

    public String getSentryTraceHeader() {
        return this.sentryTraceHeader;
    }
}
