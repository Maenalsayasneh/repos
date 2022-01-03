package kotlin.reflect.full;

import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: exceptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/full/IllegalPropertyDelegateAccessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ljava/lang/IllegalAccessException;", "cause", "<init>", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final class IllegalPropertyDelegateAccessException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalPropertyDelegateAccessException(IllegalAccessException illegalAccessException) {
        super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", illegalAccessException);
        i.e(illegalAccessException, "cause");
    }
}
