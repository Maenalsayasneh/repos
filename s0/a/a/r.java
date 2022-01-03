package s0.a.a;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public abstract class r extends m {
    public static r x(byte[] bArr) throws IOException {
        j jVar = new j(bArr);
        try {
            r i = jVar.i();
            if (jVar.available() == 0) {
                return i;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public r A() {
        return this;
    }

    @Override // s0.a.a.m, s0.a.a.e
    public final r c() {
        return this;
    }

    @Override // s0.a.a.m
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && s(((e) obj).c());
    }

    @Override // s0.a.a.m
    public void k(OutputStream outputStream) throws IOException {
        new q(outputStream).k(this);
    }

    @Override // s0.a.a.m
    public void o(OutputStream outputStream, String str) throws IOException {
        q.a(outputStream, str).k(this);
    }

    public abstract boolean s(r rVar);

    public abstract void t(q qVar, boolean z) throws IOException;

    public abstract int u() throws IOException;

    public final boolean v(e eVar) {
        return this == eVar || s(eVar.c());
    }

    public final boolean w(r rVar) {
        return this == rVar || s(rVar);
    }

    public abstract boolean y();

    public r z() {
        return this;
    }
}
