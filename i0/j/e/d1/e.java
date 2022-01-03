package i0.j.e.d1;

import android.content.Context;
import i0.d.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* compiled from: SdkLocaleRegistry.java */
/* loaded from: classes2.dex */
public final class e {
    public static final Map<String, List<String>> a;
    public static final Set<String> b;
    public final Context c;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("en", d("en"));
        hashMap.put("ar", d("ar"));
        hashMap.put("cs", d("cs"));
        hashMap.put("da", d("da"));
        hashMap.put("de", d("de"));
        hashMap.put("es", d("es"));
        hashMap.put("fr", d("fr"));
        hashMap.put("it", d("it"));
        hashMap.put("ja", d("ja"));
        hashMap.put("ko", d("ko"));
        hashMap.put("nl", d("nl"));
        hashMap.put("no", d("no"));
        hashMap.put("pl", d("pl"));
        hashMap.put("pt", d("pt"));
        hashMap.put("ru", d("ru"));
        hashMap.put("sk", d("sk"));
        hashMap.put("sv", d("sv"));
        hashMap.put("tr", d("tr"));
        hashMap.put("zh", d("zh"));
        hashMap.put("fi", d("fi"));
        hashMap.put("az", d("az"));
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("no");
        hashSet.add("nb");
    }

    public e(Context context) {
        this.c = context;
    }

    public static List<String> d(String str) {
        str.hashCode();
        if (str.equals("zh")) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("CN");
            arrayList.add("TW");
            return arrayList;
        } else if (!str.equals("pt")) {
            return Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("PT");
            arrayList2.add("BR");
            return arrayList2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        if ((c(r0) && ((r1 = i0.j.e.d1.e.a.get(r0)) == null || r1.isEmpty())) != false) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (!c(language)) {
            return "default";
        }
        if (!c(language) || !b.contains(language)) {
            if (c(language)) {
            }
            if (!c(language) || !b(language, country)) {
                if (c(language) && !b(language, country)) {
                    StringBuilder S0 = a.S0(language, "-");
                    List<String> d = d(language);
                    S0.append(d.size() > 0 ? d.get(0) : "");
                    language = S0.toString();
                }
                language = "default";
            } else {
                language = a.o0(language, "-", country);
            }
            return language;
        }
        if (language.equals("no") || language.equals("nb")) {
            language = "nb-NO";
            return language;
        }
        language = "default";
        return language;
    }

    public boolean b(String str, String str2) {
        List<String> list;
        if (c(str) && (list = a.get(str)) != null && list.contains(str2)) {
            return true;
        }
        return false;
    }

    public boolean c(String str) {
        return a.containsKey(str) || b.contains(str);
    }
}
