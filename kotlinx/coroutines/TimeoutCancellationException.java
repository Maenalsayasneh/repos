package kotlinx.coroutines;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import n0.a.f1;
/* compiled from: Timeout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\b\u0000\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "Ln0/a/f1;", "c", "Ln0/a/f1;", "coroutine", "", InstabugDbContract.BugEntry.COLUMN_MESSAGE, "<init>", "(Ljava/lang/String;Ln0/a/f1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class TimeoutCancellationException extends CancellationException {
    public final f1 c;

    public TimeoutCancellationException(String str, f1 f1Var) {
        super(str);
        this.c = f1Var;
    }
}
