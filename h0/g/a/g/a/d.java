package h0.g.a.g.a;

import java.util.HashMap;
/* compiled from: KeyCache.java */
/* loaded from: classes.dex */
public class d {
    public HashMap<Object, HashMap<String, float[]>> a = new HashMap<>();

    public float a(Object obj, String str, int i) {
        HashMap<String, float[]> hashMap;
        float[] fArr;
        if (this.a.containsKey(obj) && (hashMap = this.a.get(obj)) != null && hashMap.containsKey(str) && (fArr = hashMap.get(str)) != null && fArr.length > i) {
            return fArr[i];
        }
        return Float.NaN;
    }
}
