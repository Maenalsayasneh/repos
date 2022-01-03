package s0.a.f.b.h;

import com.pubnub.api.builder.PubNubErrorBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class i implements r {
    public static final Map<String, i> a;
    public final int b;
    public final String c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(b("SHA-256", 32, 16, 67), new i(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(b("SHA-512", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS), new i(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(b("SHAKE128", 32, 16, 67), new i(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(b("SHAKE256", 64, 16, PubNubErrorBuilder.PNERR_INVALID_ARGUMENTS), new i(67108868, "WOTSP_SHAKE256_W16"));
        a = Collections.unmodifiableMap(hashMap);
    }

    public i(int i, String str) {
        this.b = i;
        this.c = str;
    }

    public static String b(String str, int i, int i2, int i3) {
        return str + "-" + i + "-" + i2 + "-" + i3;
    }

    @Override // s0.a.f.b.h.r
    public int a() {
        return this.b;
    }

    public String toString() {
        return this.c;
    }
}
