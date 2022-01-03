package i0.j.b.s;

import java.util.HashMap;
import java.util.Map;
/* compiled from: ReportTypesManager.java */
/* loaded from: classes2.dex */
public class d {
    public static d a;
    public Map<String, Boolean> b;

    public d() {
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        Boolean bool = Boolean.TRUE;
        hashMap.put("feedback", bool);
        this.b.put("bug", bool);
        this.b.put("ask a question", bool);
    }
}
