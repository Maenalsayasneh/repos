package i0.c.a;

import com.stripe.android.model.parsers.AccountRangeJsonParser;
import java.util.HashSet;
import java.util.Set;
/* compiled from: TrackingOptions.java */
/* loaded from: classes.dex */
public class q {
    public static final String a = "i0.c.a.q";
    public static String[] b = {"city", AccountRangeJsonParser.FIELD_COUNTRY, "dma", "ip_address", "lat_lng", "region"};
    public Set<String> c = new HashSet();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q.class == obj.getClass()) {
            return ((q) obj).c.equals(this.c);
        }
        return false;
    }
}
