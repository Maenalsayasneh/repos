package com.nimbusds.jose.jwk;

import i0.l.a.h.a;
import java.io.Serializable;
import java.security.spec.ECParameterSpec;
/* loaded from: classes2.dex */
public final class Curve implements Serializable {
    public final String c2;
    public final String d2;
    public static final Curve c = new Curve("P-256", "secp256r1", "1.2.840.10045.3.1.7");
    public static final Curve d = new Curve("secp256k1", "secp256k1", "1.3.132.0.10");
    @Deprecated
    public static final Curve q = new Curve("P-256K", "secp256k1", "1.3.132.0.10");
    public static final Curve x = new Curve("P-384", "secp384r1", "1.3.132.0.34");
    public static final Curve y = new Curve("P-521", "secp521r1", "1.3.132.0.35");
    public static final Curve Y1 = new Curve("Ed25519", "Ed25519", null);
    public static final Curve Z1 = new Curve("Ed448", "Ed448", null);
    public static final Curve a2 = new Curve("X25519", "X25519", null);
    public static final Curve b2 = new Curve("X448", "X448", null);

    public Curve(String str, String str2, String str3) {
        if (str != null) {
            this.c2 = str;
            this.d2 = str2;
            return;
        }
        throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
    }

    public static Curve a(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
        }
        Curve curve = c;
        if (str.equals(curve.c2)) {
            return curve;
        }
        Curve curve2 = q;
        if (str.equals(curve2.c2)) {
            return curve2;
        }
        Curve curve3 = d;
        if (str.equals(curve3.c2)) {
            return curve3;
        }
        Curve curve4 = x;
        if (str.equals(curve4.c2)) {
            return curve4;
        }
        Curve curve5 = y;
        if (str.equals(curve5.c2)) {
            return curve5;
        }
        Curve curve6 = Y1;
        if (str.equals(curve6.c2)) {
            return curve6;
        }
        Curve curve7 = Z1;
        if (str.equals(curve7.c2)) {
            return curve7;
        }
        Curve curve8 = a2;
        if (str.equals(curve8.c2)) {
            return curve8;
        }
        Curve curve9 = b2;
        if (str.equals(curve9.c2)) {
            return curve9;
        }
        return new Curve(str, null, null);
    }

    public ECParameterSpec b() {
        ECParameterSpec eCParameterSpec = a.a;
        if (c.equals(this)) {
            return a.a;
        }
        if (d.equals(this)) {
            return a.b;
        }
        if (x.equals(this)) {
            return a.c;
        }
        if (y.equals(this)) {
            return a.d;
        }
        return null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof Curve) && this.c2.equals(obj.toString());
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c2;
    }
}
