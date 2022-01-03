package kotlin;

import java.io.Serializable;
import m0.c;
/* compiled from: Lazy.kt */
/* loaded from: classes4.dex */
public final class InitializedLazyImpl<T> implements c<T>, Serializable {
    public final T c;

    public InitializedLazyImpl(T t) {
        this.c = t;
    }

    @Override // m0.c
    public T getValue() {
        return this.c;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.valueOf(this.c);
    }
}
