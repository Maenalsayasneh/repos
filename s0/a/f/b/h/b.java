package s0.a.f.b.h;

import com.pubnub.api.builder.PubNubErrorBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class b implements r {
    public static final Map<String, b> a;
    public final int b;
    public final String c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(b("SHA-256", 32, 16, 67, 10), new b(1, "XMSS_SHA2_10_256"));
        hashMap.put(b("SHA-256", 32, 16, 67, 16), new b(2, "XMSS_SHA2_16_256"));
        hashMap.put(b("SHA-256", 32, 16, 67, 20), new b(3, "XMSS_SHA2_20_256"));
        hashMap.put(b("SHA-512", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS, 10), new b(4, "XMSS_SHA2_10_512"));
        hashMap.put(b("SHA-512", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS, 16), new b(5, "XMSS_SHA2_16_512"));
        hashMap.put(b("SHA-512", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS, 20), new b(6, "XMSS_SHA2_20_512"));
        hashMap.put(b("SHAKE128", 32, 16, 67, 10), new b(7, "XMSS_SHAKE_10_256"));
        hashMap.put(b("SHAKE128", 32, 16, 67, 16), new b(8, "XMSS_SHAKE_16_256"));
        hashMap.put(b("SHAKE128", 32, 16, 67, 20), new b(9, "XMSS_SHAKE_20_256"));
        hashMap.put(b("SHAKE256", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS, 10), new b(10, "XMSS_SHAKE_10_512"));
        hashMap.put(b("SHAKE256", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS, 16), new b(11, "XMSS_SHAKE_16_512"));
        hashMap.put(b("SHAKE256", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS, 20), new b(12, "XMSS_SHAKE_20_512"));
        a = Collections.unmodifiableMap(hashMap);
    }

    public b(int i, String str) {
        this.b = i;
        this.c = str;
    }

    public static String b(String str, int i, int i2, int i3, int i4) {
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4;
    }

    @Override // s0.a.f.b.h.r
    public int a() {
        return this.b;
    }

    public String toString() {
        return this.c;
    }
}
