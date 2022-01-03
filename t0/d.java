package t0;

import java.io.IOException;
import q0.b0;
/* compiled from: Call.java */
/* loaded from: classes4.dex */
public interface d<T> extends Cloneable {
    void J(f<T> fVar);

    void cancel();

    @Override // java.lang.Object
    /* renamed from: clone */
    d<T> mo59clone();

    v<T> execute() throws IOException;

    boolean isCanceled();

    b0 request();
}
