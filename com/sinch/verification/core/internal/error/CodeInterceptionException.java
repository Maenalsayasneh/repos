package com.sinch.verification.core.internal.error;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import kotlin.Metadata;
/* compiled from: CodeInterceptionException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sinch/verification/core/internal/error/CodeInterceptionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", InstabugDbContract.BugEntry.COLUMN_MESSAGE, "<init>", "(Ljava/lang/String;)V", "verification-core_productionRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class CodeInterceptionException extends Exception {
    public CodeInterceptionException(String str) {
        super(str);
    }
}
