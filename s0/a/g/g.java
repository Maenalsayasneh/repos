package s0.a.g;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Map;
/* loaded from: classes4.dex */
public class g {
    public static final ThreadLocal a = new ThreadLocal();

    /* loaded from: classes4.dex */
    public static class a implements PrivilegedAction {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Security.getProperty(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements PrivilegedAction {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(this.a);
        }
    }

    public static String a(String str) {
        String str2;
        String str3 = (String) AccessController.doPrivileged(new a(str));
        if (str3 != null) {
            return str3;
        }
        Map map = (Map) a.get();
        return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new b(str)) : str2;
    }

    public static boolean b(String str) {
        try {
            return d(a(str));
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public static boolean c(String str, boolean z) {
        try {
            String a2 = a(str);
            if (z) {
                return d(a2);
            }
            if (a2 != null && a2.length() == 5) {
                if (a2.charAt(0) != 'f' && a2.charAt(0) != 'F') {
                    return false;
                }
                if (a2.charAt(1) != 'a' && a2.charAt(1) != 'A') {
                    return false;
                }
                if (a2.charAt(2) != 'l' && a2.charAt(2) != 'L') {
                    return false;
                }
                if (a2.charAt(3) == 's' || a2.charAt(3) == 'S') {
                    return a2.charAt(4) == 'e' || a2.charAt(4) == 'E';
                }
                return false;
            }
            return false;
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public static boolean d(String str) {
        if (str == null || str.length() != 4) {
            return false;
        }
        if (str.charAt(0) != 't' && str.charAt(0) != 'T') {
            return false;
        }
        if (str.charAt(1) != 'r' && str.charAt(1) != 'R') {
            return false;
        }
        if (str.charAt(2) == 'u' || str.charAt(2) == 'U') {
            return str.charAt(3) == 'e' || str.charAt(3) == 'E';
        }
        return false;
    }
}
