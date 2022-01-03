package s0.a.a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes4.dex */
public class t1 {
    public static Long a = 0L;
    public static final Map b = new HashMap();
    public static Locale c;

    static {
        Locale locale;
        if (!"en".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            Locale[] availableLocales = Locale.getAvailableLocales();
            for (int i = 0; i != availableLocales.length; i++) {
                if ("en".equalsIgnoreCase(availableLocales[i].getLanguage())) {
                    locale = availableLocales[i];
                    break;
                }
            }
        }
        locale = Locale.getDefault();
        c = locale;
    }

    public static Date a(Date date) throws ParseException {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return date;
        }
        Map map = b;
        synchronized (map) {
            Long l = (Long) map.get(locale);
            if (l == null) {
                long time = new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime();
                l = time == 0 ? a : Long.valueOf(time);
                map.put(locale, l);
            }
            if (l == a) {
                return date;
            }
            return new Date(date.getTime() - l.longValue());
        }
    }
}
