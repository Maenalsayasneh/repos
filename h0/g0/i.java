package h0.g0;

import android.util.Log;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public abstract class i {
    public static i a;

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public static class a extends i {
        public int b;

        public a(int i) {
            this.b = i;
        }

        @Override // h0.g0.i
        public void a(String str, String str2, Throwable... thArr) {
            if (this.b > 3) {
                return;
            }
            if (thArr.length >= 1) {
                Log.d(str, str2, thArr[0]);
            } else {
                Log.d(str, str2);
            }
        }

        @Override // h0.g0.i
        public void b(String str, String str2, Throwable... thArr) {
            if (this.b > 6) {
                return;
            }
            if (thArr.length >= 1) {
                Log.e(str, str2, thArr[0]);
            } else {
                Log.e(str, str2);
            }
        }

        @Override // h0.g0.i
        public void d(String str, String str2, Throwable... thArr) {
            if (this.b > 4) {
                return;
            }
            if (thArr.length >= 1) {
                Log.i(str, str2, thArr[0]);
            } else {
                Log.i(str, str2);
            }
        }

        @Override // h0.g0.i
        public void f(String str, String str2, Throwable... thArr) {
            if (this.b > 5) {
                return;
            }
            if (thArr.length >= 1) {
                Log.w(str, str2, thArr[0]);
            } else {
                Log.w(str, str2);
            }
        }
    }

    public static synchronized i c() {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new a(3);
            }
            iVar = a;
        }
        return iVar;
    }

    public static String e(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void f(String str, String str2, Throwable... thArr);
}
