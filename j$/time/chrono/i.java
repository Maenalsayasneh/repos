package j$.time.chrono;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.g;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.t;
import j$.time.temporal.u;
/* loaded from: classes5.dex */
public interface i extends l, m {
    @Override // j$.time.temporal.l
    default Object d(r rVar) {
        int i = q.a;
        return rVar == g.a ? ChronoUnit.ERAS : super.d(rVar);
    }

    @Override // j$.time.temporal.m
    default Temporal e(Temporal temporal) {
        return temporal.c(j.ERA, (long) k());
    }

    @Override // j$.time.temporal.l
    default boolean f(p pVar) {
        return pVar instanceof j ? pVar == j.ERA : pVar != null && pVar.V(this);
    }

    @Override // j$.time.temporal.l
    default long g(p pVar) {
        if (pVar == j.ERA) {
            return (long) k();
        }
        if (!(pVar instanceof j)) {
            return pVar.q(this);
        }
        throw new t("Unsupported field: " + pVar);
    }

    @Override // j$.time.temporal.l
    default u i(p pVar) {
        return super.i(pVar);
    }

    @Override // j$.time.temporal.l
    default int j(p pVar) {
        return pVar == j.ERA ? k() : super.j(pVar);
    }

    int k();
}
