package com.sinch.verification.core.verification.interceptor;

import com.sinch.verification.core.internal.error.CodeInterceptionException;
import kotlin.Metadata;
/* compiled from: CodeInterceptionTimeoutException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sinch/verification/core/verification/interceptor/CodeInterceptionTimeoutException;", "Lcom/sinch/verification/core/internal/error/CodeInterceptionException;", "<init>", "()V", "verification-core_productionRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CodeInterceptionTimeoutException extends CodeInterceptionException {
    public CodeInterceptionTimeoutException() {
        super("Interception timed out");
    }
}
