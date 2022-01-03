package com.fasterxml.jackson.databind.introspect;

import i0.f.a.c.n.k;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SimpleMixInResolver implements k.a, Serializable {
    public final k.a c = null;

    public SimpleMixInResolver(k.a aVar) {
    }

    @Override // i0.f.a.c.n.k.a
    public Class<?> a(Class<?> cls) {
        k.a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.a(cls);
    }

    public boolean b() {
        k.a aVar = this.c;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof SimpleMixInResolver) {
            return ((SimpleMixInResolver) aVar).b();
        }
        return true;
    }
}
