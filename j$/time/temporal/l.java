package j$.time.temporal;

import j$.time.c;
import java.util.Objects;
/* loaded from: classes5.dex */
public interface l {
    default Object d(r rVar) {
        int i = q.a;
        if (rVar == f.a || rVar == d.a || rVar == g.a) {
            return null;
        }
        return rVar.a(this);
    }

    boolean f(p pVar);

    long g(p pVar);

    default u i(p pVar) {
        if (!(pVar instanceof j)) {
            Objects.requireNonNull(pVar, "field");
            return pVar.I(this);
        } else if (f(pVar)) {
            return pVar.B();
        } else {
            throw new t("Unsupported field: " + pVar);
        }
    }

    default int j(p pVar) {
        u i = i(pVar);
        if (i.g()) {
            long g = g(pVar);
            if (i.h(g)) {
                return (int) g;
            }
            throw new c("Invalid value for " + pVar + " (valid values " + i + "): " + g);
        }
        throw new t("Invalid field " + pVar + " for get() method, use getLong() instead");
    }
}
