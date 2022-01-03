package com.nimbusds.jose;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import i0.j.f.p.h;
import i0.l.a.j.c;
import java.io.Serializable;
import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class CommonSEHeader implements Serializable {
    public static final Map<String, Object> c = Collections.unmodifiableMap(new HashMap());
    public final Map<String, Object> Y1;
    public final Base64URL Z1;
    public final URI a2;
    public final JWK b2;
    public final URI c2;
    public final Algorithm d;
    public final Base64URL d2;
    public final Base64URL e2;
    public final List<Base64> f2;
    public final String g2;
    public final JOSEObjectType q;
    public final String x;
    public final Set<String> y;

    public CommonSEHeader(Algorithm algorithm, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, Map<String, Object> map, Base64URL base64URL3) {
        if (algorithm != null) {
            this.d = algorithm;
            this.q = jOSEObjectType;
            this.x = str;
            if (set != null) {
                this.y = Collections.unmodifiableSet(new HashSet(set));
            } else {
                this.y = null;
            }
            if (map != null) {
                this.Y1 = Collections.unmodifiableMap(new HashMap(map));
            } else {
                this.Y1 = c;
            }
            this.Z1 = base64URL3;
            this.a2 = uri;
            this.b2 = jwk;
            this.c2 = uri2;
            this.d2 = base64URL;
            this.e2 = base64URL2;
            if (list != null) {
                this.f2 = Collections.unmodifiableList(new ArrayList(list));
            } else {
                this.f2 = null;
            }
            this.g2 = str2;
            return;
        }
        throw new IllegalArgumentException("The algorithm \"alg\" header parameter must not be null");
    }

    public static Algorithm a(Map<String, Object> map) throws ParseException {
        String str = (String) h.h1(map, "alg", String.class);
        if (str != null) {
            Algorithm algorithm = Algorithm.c;
            if (str.equals(algorithm.d)) {
                return algorithm;
            }
            if (map.containsKey("enc")) {
                JWEAlgorithm jWEAlgorithm = JWEAlgorithm.q;
                if (str.equals(jWEAlgorithm.d)) {
                    return jWEAlgorithm;
                }
                JWEAlgorithm jWEAlgorithm2 = JWEAlgorithm.x;
                if (str.equals(jWEAlgorithm2.d)) {
                    return jWEAlgorithm2;
                }
                JWEAlgorithm jWEAlgorithm3 = JWEAlgorithm.y;
                if (str.equals(jWEAlgorithm3.d)) {
                    return jWEAlgorithm3;
                }
                JWEAlgorithm jWEAlgorithm4 = JWEAlgorithm.Y1;
                if (str.equals(jWEAlgorithm4.d)) {
                    return jWEAlgorithm4;
                }
                JWEAlgorithm jWEAlgorithm5 = JWEAlgorithm.Z1;
                if (str.equals(jWEAlgorithm5.d)) {
                    return jWEAlgorithm5;
                }
                JWEAlgorithm jWEAlgorithm6 = JWEAlgorithm.a2;
                if (str.equals(jWEAlgorithm6.d)) {
                    return jWEAlgorithm6;
                }
                JWEAlgorithm jWEAlgorithm7 = JWEAlgorithm.b2;
                if (str.equals(jWEAlgorithm7.d)) {
                    return jWEAlgorithm7;
                }
                JWEAlgorithm jWEAlgorithm8 = JWEAlgorithm.c2;
                if (str.equals(jWEAlgorithm8.d)) {
                    return jWEAlgorithm8;
                }
                JWEAlgorithm jWEAlgorithm9 = JWEAlgorithm.d2;
                if (str.equals(jWEAlgorithm9.d)) {
                    return jWEAlgorithm9;
                }
                JWEAlgorithm jWEAlgorithm10 = JWEAlgorithm.e2;
                if (str.equals(jWEAlgorithm10.d)) {
                    return jWEAlgorithm10;
                }
                JWEAlgorithm jWEAlgorithm11 = JWEAlgorithm.f2;
                if (str.equals(jWEAlgorithm11.d)) {
                    return jWEAlgorithm11;
                }
                JWEAlgorithm jWEAlgorithm12 = JWEAlgorithm.g2;
                if (str.equals(jWEAlgorithm12.d)) {
                    return jWEAlgorithm12;
                }
                JWEAlgorithm jWEAlgorithm13 = JWEAlgorithm.h2;
                if (str.equals(jWEAlgorithm13.d)) {
                    return jWEAlgorithm13;
                }
                JWEAlgorithm jWEAlgorithm14 = JWEAlgorithm.i2;
                if (str.equals(jWEAlgorithm14.d)) {
                    return jWEAlgorithm14;
                }
                JWEAlgorithm jWEAlgorithm15 = JWEAlgorithm.j2;
                if (str.equals(jWEAlgorithm15.d)) {
                    return jWEAlgorithm15;
                }
                JWEAlgorithm jWEAlgorithm16 = JWEAlgorithm.k2;
                if (str.equals(jWEAlgorithm16.d)) {
                    return jWEAlgorithm16;
                }
                JWEAlgorithm jWEAlgorithm17 = JWEAlgorithm.l2;
                return str.equals(jWEAlgorithm17.d) ? jWEAlgorithm17 : new JWEAlgorithm(str);
            }
            JWSAlgorithm jWSAlgorithm = JWSAlgorithm.q;
            if (str.equals(jWSAlgorithm.d)) {
                return jWSAlgorithm;
            }
            JWSAlgorithm jWSAlgorithm2 = JWSAlgorithm.x;
            if (str.equals(jWSAlgorithm2.d)) {
                return jWSAlgorithm2;
            }
            JWSAlgorithm jWSAlgorithm3 = JWSAlgorithm.y;
            if (str.equals(jWSAlgorithm3.d)) {
                return jWSAlgorithm3;
            }
            JWSAlgorithm jWSAlgorithm4 = JWSAlgorithm.Y1;
            if (str.equals(jWSAlgorithm4.d)) {
                return jWSAlgorithm4;
            }
            JWSAlgorithm jWSAlgorithm5 = JWSAlgorithm.Z1;
            if (str.equals(jWSAlgorithm5.d)) {
                return jWSAlgorithm5;
            }
            JWSAlgorithm jWSAlgorithm6 = JWSAlgorithm.a2;
            if (str.equals(jWSAlgorithm6.d)) {
                return jWSAlgorithm6;
            }
            JWSAlgorithm jWSAlgorithm7 = JWSAlgorithm.b2;
            if (str.equals(jWSAlgorithm7.d)) {
                return jWSAlgorithm7;
            }
            JWSAlgorithm jWSAlgorithm8 = JWSAlgorithm.c2;
            if (str.equals(jWSAlgorithm8.d)) {
                return jWSAlgorithm8;
            }
            JWSAlgorithm jWSAlgorithm9 = JWSAlgorithm.d2;
            if (str.equals(jWSAlgorithm9.d)) {
                return jWSAlgorithm9;
            }
            JWSAlgorithm jWSAlgorithm10 = JWSAlgorithm.e2;
            if (str.equals(jWSAlgorithm10.d)) {
                return jWSAlgorithm10;
            }
            JWSAlgorithm jWSAlgorithm11 = JWSAlgorithm.f2;
            if (str.equals(jWSAlgorithm11.d)) {
                return jWSAlgorithm11;
            }
            JWSAlgorithm jWSAlgorithm12 = JWSAlgorithm.g2;
            if (str.equals(jWSAlgorithm12.d)) {
                return jWSAlgorithm12;
            }
            JWSAlgorithm jWSAlgorithm13 = JWSAlgorithm.h2;
            if (str.equals(jWSAlgorithm13.d)) {
                return jWSAlgorithm13;
            }
            JWSAlgorithm jWSAlgorithm14 = JWSAlgorithm.i2;
            return str.equals(jWSAlgorithm14.d) ? jWSAlgorithm14 : new JWSAlgorithm(str);
        }
        throw new ParseException("Missing \"alg\" in header JSON object", 0);
    }

    public Base64URL b() {
        Base64URL base64URL = this.Z1;
        return base64URL == null ? Base64URL.d(toString().getBytes(c.a)) : base64URL;
    }

    public Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.Y1);
        hashMap.put("alg", this.d.d);
        JOSEObjectType jOSEObjectType = this.q;
        if (jOSEObjectType != null) {
            hashMap.put("typ", jOSEObjectType.c);
        }
        String str = this.x;
        if (str != null) {
            hashMap.put("cty", str);
        }
        Set<String> set = this.y;
        if (set != null && !set.isEmpty()) {
            hashMap.put("crit", new ArrayList(this.y));
        }
        URI uri = this.a2;
        if (uri != null) {
            hashMap.put("jku", uri.toString());
        }
        JWK jwk = this.b2;
        if (jwk != null) {
            hashMap.put("jwk", jwk.d());
        }
        URI uri2 = this.c2;
        if (uri2 != null) {
            hashMap.put("x5u", uri2.toString());
        }
        Base64URL base64URL = this.d2;
        if (base64URL != null) {
            hashMap.put("x5t", base64URL.c);
        }
        Base64URL base64URL2 = this.e2;
        if (base64URL2 != null) {
            hashMap.put("x5t#S256", base64URL2.c);
        }
        List<Base64> list = this.f2;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f2.size());
            for (Base64 base64 : this.f2) {
                arrayList.add(base64.c);
            }
            hashMap.put("x5c", arrayList);
        }
        String str2 = this.g2;
        if (str2 != null) {
            hashMap.put("kid", str2);
        }
        return hashMap;
    }

    @Override // java.lang.Object
    public String toString() {
        return h.k4(c());
    }
}
