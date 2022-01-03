package s0.a.b.n0;

import io.agora.rtc.internal.RtcEngineEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class n {
    public static final Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("RIPEMD128", 13004);
        hashMap.put("RIPEMD160", 12748);
        hashMap.put("SHA-1", 13260);
        hashMap.put("SHA-224", 14540);
        hashMap.put("SHA-256", 13516);
        hashMap.put("SHA-384", Integer.valueOf((int) RtcEngineEvent.EvtType.EVT_CONNECTION_STATE_CHANGED));
        hashMap.put("SHA-512", 13772);
        hashMap.put("SHA-512/224", 14796);
        hashMap.put("SHA-512/256", 15052);
        hashMap.put("Whirlpool", 14284);
        a = Collections.unmodifiableMap(hashMap);
    }

    public static Integer a(s0.a.b.n nVar) {
        return a.get(nVar.getAlgorithmName());
    }
}
