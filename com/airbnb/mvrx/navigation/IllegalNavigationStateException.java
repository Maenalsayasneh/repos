package com.airbnb.mvrx.navigation;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: navigationLifecycleAwareLazy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/airbnb/mvrx/navigation/IllegalNavigationStateException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", InstabugDbContract.BugEntry.COLUMN_MESSAGE, "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "mvrx-navigation_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class IllegalNavigationStateException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalNavigationStateException(String str, Throwable th) {
        super(str, th);
        i.e(str, InstabugDbContract.BugEntry.COLUMN_MESSAGE);
        i.e(th, "cause");
    }
}
