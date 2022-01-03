package com.airbnb.mvrx;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: MavericksFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/airbnb/mvrx/ViewModelDoesNotExistException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", InstabugDbContract.BugEntry.COLUMN_MESSAGE, "<init>", "(Ljava/lang/String;)V", "mvrx_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class ViewModelDoesNotExistException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewModelDoesNotExistException(String str) {
        super(str);
        i.e(str, InstabugDbContract.BugEntry.COLUMN_MESSAGE);
    }
}
