package s0.a.c;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s0.a.a.c3.w;
/* loaded from: classes4.dex */
public class k implements CertPathParameters {
    public final Map<w, h> Y1;
    public final List<d> Z1;
    public final Map<w, d> a2;
    public final boolean b2;
    public final PKIXParameters c;
    public final boolean c2;
    public final i d;
    public final int d2;
    public final Set<TrustAnchor> e2;
    public final Date q;
    public final Date x;
    public final List<h> y;

    public k(b bVar, a aVar) {
        this.c = bVar.a;
        this.q = bVar.b;
        this.x = bVar.c;
        this.y = Collections.unmodifiableList(bVar.e);
        this.Y1 = Collections.unmodifiableMap(new HashMap(bVar.f));
        this.Z1 = Collections.unmodifiableList(bVar.g);
        this.a2 = Collections.unmodifiableMap(new HashMap(bVar.h));
        this.d = bVar.d;
        this.b2 = bVar.i;
        this.c2 = bVar.k;
        this.d2 = bVar.j;
        this.e2 = Collections.unmodifiableSet(bVar.l);
    }

    public List<CertStore> b() {
        return this.c.getCertStores();
    }

    public String c() {
        return this.c.getSigProvider();
    }

    @Override // java.security.cert.CertPathParameters, java.lang.Object
    public Object clone() {
        return this;
    }

    public boolean d() {
        return this.c.isExplicitPolicyRequired();
    }

    /* loaded from: classes4.dex */
    public static class b {
        public final PKIXParameters a;
        public final Date b;
        public final Date c;
        public i d;
        public List<h> e;
        public Map<w, h> f;
        public List<d> g;
        public Map<w, d> h;
        public boolean i;
        public int j;
        public boolean k;
        public Set<TrustAnchor> l;

        public b(PKIXParameters pKIXParameters) {
            this.e = new ArrayList();
            this.f = new HashMap();
            this.g = new ArrayList();
            this.h = new HashMap();
            this.j = 0;
            this.k = false;
            this.a = (PKIXParameters) pKIXParameters.clone();
            CertSelector targetCertConstraints = pKIXParameters.getTargetCertConstraints();
            if (targetCertConstraints != null) {
                this.d = new i((CertSelector) targetCertConstraints.clone(), null);
            }
            Date date = pKIXParameters.getDate();
            this.b = date;
            this.c = date == null ? new Date() : date;
            this.i = pKIXParameters.isRevocationEnabled();
            this.l = pKIXParameters.getTrustAnchors();
        }

        public k a() {
            return new k(this, null);
        }

        public b(k kVar) {
            this.e = new ArrayList();
            this.f = new HashMap();
            this.g = new ArrayList();
            this.h = new HashMap();
            this.j = 0;
            this.k = false;
            this.a = kVar.c;
            this.b = kVar.q;
            this.c = kVar.x;
            this.d = kVar.d;
            this.e = new ArrayList(kVar.y);
            this.f = new HashMap(kVar.Y1);
            this.g = new ArrayList(kVar.Z1);
            this.h = new HashMap(kVar.a2);
            this.k = kVar.c2;
            this.j = kVar.d2;
            this.i = kVar.b2;
            this.l = kVar.e2;
        }
    }
}
