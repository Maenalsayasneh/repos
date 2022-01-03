package m0.r.t.a.q;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
/* compiled from: Caller.kt */
/* loaded from: classes4.dex */
public interface c<M extends Member> {
    M a();

    List<Type> b();

    Object call(Object[] objArr);

    Type getReturnType();
}
