package v0.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Timber.java */
/* loaded from: classes4.dex */
public final class a {
    public static final b[] a;
    public static volatile b[] c;
    public static final List<b> b = new ArrayList();
    public static final b d = new C0311a();

    /* compiled from: Timber.java */
    /* loaded from: classes4.dex */
    public static abstract class b {
        public final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        StringBuilder S0 = i0.d.a.a.a.S0(str, "\n");
                        S0.append(getStackTraceString(th));
                        str = S0.toString();
                    }
                } else if (th != null) {
                    str = getStackTraceString(th);
                } else {
                    return;
                }
                log(i, tag, str, th);
            }
        }

        public void d(String str, Object... objArr) {
            prepareLog(3, null, str, objArr);
        }

        public void e(String str, Object... objArr) {
            prepareLog(6, null, str, objArr);
        }

        public String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        public void i(String str, Object... objArr) {
            prepareLog(4, null, str, objArr);
        }

        @Deprecated
        public boolean isLoggable(int i) {
            return true;
        }

        public boolean isLoggable(String str, int i) {
            return isLoggable(i);
        }

        public abstract void log(int i, String str, String str2, Throwable th);

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, null, str, objArr);
        }

        public void v(String str, Object... objArr) {
            prepareLog(2, null, str, objArr);
        }

        public void w(String str, Object... objArr) {
            prepareLog(5, null, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, null, str, objArr);
        }

        public void d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        public void i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        public void v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        public void w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        public void d(Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        public void e(Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void i(Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, null, new Object[0]);
        }

        public void v(Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        public void w(Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }
    }

    static {
        b[] bVarArr = new b[0];
        a = bVarArr;
        c = bVarArr;
    }

    /* compiled from: Timber.java */
    /* renamed from: v0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0311a extends b {
        @Override // v0.a.a.b
        public void d(String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.d(str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void e(String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.e(str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void i(String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.i(str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void log(int i, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.log(i, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void v(String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.v(str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void w(String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.w(str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void wtf(String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.wtf(str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void d(Throwable th, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.d(th, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void e(Throwable th, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.e(th, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void i(Throwable th, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.i(th, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void log(int i, Throwable th, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.log(i, th, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void v(Throwable th, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.v(th, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void w(Throwable th, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.w(th, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void wtf(Throwable th, String str, Object... objArr) {
            for (b bVar : a.c) {
                bVar.wtf(th, str, objArr);
            }
        }

        @Override // v0.a.a.b
        public void d(Throwable th) {
            for (b bVar : a.c) {
                bVar.d(th);
            }
        }

        @Override // v0.a.a.b
        public void e(Throwable th) {
            for (b bVar : a.c) {
                bVar.e(th);
            }
        }

        @Override // v0.a.a.b
        public void i(Throwable th) {
            for (b bVar : a.c) {
                bVar.i(th);
            }
        }

        @Override // v0.a.a.b
        public void log(int i, Throwable th) {
            for (b bVar : a.c) {
                bVar.log(i, th);
            }
        }

        @Override // v0.a.a.b
        public void v(Throwable th) {
            for (b bVar : a.c) {
                bVar.v(th);
            }
        }

        @Override // v0.a.a.b
        public void w(Throwable th) {
            for (b bVar : a.c) {
                bVar.w(th);
            }
        }

        @Override // v0.a.a.b
        public void wtf(Throwable th) {
            for (b bVar : a.c) {
                bVar.wtf(th);
            }
        }

        @Override // v0.a.a.b
        public void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    }
}
