package s0.a.c;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import s0.a.c.k;
/* loaded from: classes4.dex */
public class j implements CertPathParameters {
    public final k c;
    public final Set<X509Certificate> d;
    public final int q;

    /* loaded from: classes4.dex */
    public static class b {
        public final k a;
        public int b;
        public Set<X509Certificate> c;

        public b(PKIXBuilderParameters pKIXBuilderParameters) {
            this.b = 5;
            this.c = new HashSet();
            this.a = new k.b(pKIXBuilderParameters).a();
            this.b = pKIXBuilderParameters.getMaxPathLength();
        }

        public b(k kVar) {
            this.b = 5;
            this.c = new HashSet();
            this.a = kVar;
        }

        public j a() {
            return new j(this, null);
        }

        public b b(int i) {
            if (i >= -1) {
                this.b = i;
                return this;
            }
            throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
        }
    }

    public j(b bVar, a aVar) {
        this.c = bVar.a;
        this.d = Collections.unmodifiableSet(bVar.c);
        this.q = bVar.b;
    }

    @Override // java.security.cert.CertPathParameters, java.lang.Object
    public Object clone() {
        return this;
    }
}
