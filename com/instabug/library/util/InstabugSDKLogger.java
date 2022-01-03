package com.instabug.library.util;

import android.content.Context;
import android.util.Log;
import com.instabug.library.settings.SettingsManager;
import i0.j.e.q0.d;
import i0.j.e.t0.c;
/* loaded from: classes2.dex */
public final class InstabugSDKLogger {
    private static final String LOG_TAG = "IB-";
    private static d instabugSDKDiskLogger;

    /* loaded from: classes2.dex */
    public static class a implements k0.b.y.d<Throwable> {
        public final /* synthetic */ String c;

        public a(String str) {
            this.c = str;
        }

        @Override // k0.b.y.d
        public void b(Throwable th) throws Exception {
            Throwable th2 = th;
            InstabugSDKLogger.e(InstabugSDKLogger.logTag(this.c), th2.getClass().getSimpleName(), th2);
        }
    }

    private InstabugSDKLogger() {
    }

    public static synchronized void addVerboseLog(Object obj, String str) {
        String str2;
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                    if (SettingsManager.getInstance().isDebugEnabled()) {
                        String logTag = logTag(obj);
                        if (str.length() > 4000) {
                            int length = str.length() / 4000;
                            StringBuilder sb = new StringBuilder();
                            sb.append("logMessage length = ");
                            sb.append(str.length());
                            sb.append(" divided to ");
                            int i = length + 1;
                            sb.append(i);
                            sb.append(" chunks");
                            Log.v(logTag, sb.toString());
                            int i2 = 0;
                            while (i2 <= length) {
                                int i3 = i2 + 1;
                                int i4 = i3 * 4000;
                                if (i4 >= str.length()) {
                                    str2 = str.substring(i2 * 4000);
                                } else {
                                    str2 = str.substring(i2 * 4000, i4);
                                }
                                Log.v(logTag, "chunk " + i3 + " of " + i + ":\n" + str2);
                                i2 = i3;
                            }
                        } else {
                            Log.v(logTag, str);
                        }
                    }
                    d dVar = instabugSDKDiskLogger;
                    if (dVar != null) {
                        dVar.a(logTag(obj), str, Thread.currentThread().getName(), System.currentTimeMillis());
                    }
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
            }
        }
    }

    public static synchronized void d(Object obj, String str) {
        String str2;
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
                if (SettingsManager.getInstance().isDebugEnabled()) {
                    String logTag = logTag(obj);
                    if (str.length() > 4000) {
                        int length = str.length() / 4000;
                        StringBuilder sb = new StringBuilder();
                        sb.append("logMessage length = ");
                        sb.append(str.length());
                        sb.append(" divided to ");
                        int i = length + 1;
                        sb.append(i);
                        sb.append(" chunks");
                        Log.d(logTag, sb.toString());
                        int i2 = 0;
                        while (i2 <= length) {
                            int i3 = i2 + 1;
                            int i4 = i3 * 4000;
                            if (i4 >= str.length()) {
                                str2 = str.substring(i2 * 4000);
                            } else {
                                str2 = str.substring(i2 * 4000, i4);
                            }
                            Log.d(logTag, "chunk " + i3 + " of " + i + ":\n" + str2);
                            i2 = i3;
                        }
                    } else {
                        Log.d(logTag, str);
                    }
                    p(obj, str);
                }
            }
        }
    }

    public static synchronized void e(Object obj, String str) {
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
                if (SettingsManager.getInstance().isDebugEnabled()) {
                    Log.e(logTag(obj), str);
                    p(obj, str);
                }
            }
        }
    }

    public static k0.b.y.d<Throwable> errorConsumer(String str) {
        return new a(str);
    }

    public static synchronized void i(Object obj, String str) {
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                    if (SettingsManager.getInstance().isDebugEnabled()) {
                        Log.i(logTag(obj), str);
                    }
                    p(obj, str);
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
            }
        }
    }

    public static synchronized void initLogger(Context context) {
        synchronized (InstabugSDKLogger.class) {
            if (instabugSDKDiskLogger == null) {
                instabugSDKDiskLogger = new d(context);
            }
        }
    }

    public static void logEndSession(long j) {
    }

    public static void logSessionDetails(c cVar) {
    }

    public static String logTag(Object obj) {
        String str;
        if (obj instanceof String) {
            return LOG_TAG + obj;
        }
        if (obj instanceof Class) {
            str = ((Class) obj).getSimpleName();
        } else {
            str = obj.getClass().getSimpleName();
        }
        return i0.d.a.a.a.n0(LOG_TAG, str);
    }

    public static void p(Object obj, String str) {
    }

    public static synchronized void v(Object obj, String str) {
        String str2;
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                    if (SettingsManager.getInstance().isDebugEnabled()) {
                        String logTag = logTag(obj);
                        if (str.length() > 4000) {
                            int length = str.length() / 4000;
                            StringBuilder sb = new StringBuilder();
                            sb.append("logMessage length = ");
                            sb.append(str.length());
                            sb.append(" divided to ");
                            int i = length + 1;
                            sb.append(i);
                            sb.append(" chunks");
                            Log.v(logTag, sb.toString());
                            int i2 = 0;
                            while (i2 <= length) {
                                int i3 = i2 + 1;
                                int i4 = i3 * 4000;
                                if (i4 >= str.length()) {
                                    str2 = str.substring(i2 * 4000);
                                } else {
                                    str2 = str.substring(i2 * 4000, i4);
                                }
                                Log.v(logTag, "chunk " + i3 + " of " + i + ":\n" + str2);
                                i2 = i3;
                            }
                        } else {
                            Log.v(logTag, str);
                        }
                    }
                    p(obj, str);
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
            }
        }
    }

    public static synchronized void w(Object obj, String str) {
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
                if (SettingsManager.getInstance().isDebugEnabled()) {
                    Log.w(logTag(obj), str);
                    p(obj, str);
                }
            }
        }
    }

    public static synchronized void wtf(Object obj, String str) {
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
                if (SettingsManager.getInstance().isDebugEnabled()) {
                    Log.wtf(logTag(obj), str);
                    p(obj, str);
                }
            }
        }
    }

    public static synchronized void e(Object obj, String str, Throwable th) {
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                    if (SettingsManager.getInstance().isDebugEnabled()) {
                        Log.e(logTag(obj), str, th);
                    }
                    p(obj, str);
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
            }
        }
    }

    public static synchronized void wtf(Object obj, String str, Throwable th) {
        synchronized (InstabugSDKLogger.class) {
            if (str != null) {
                try {
                } catch (Exception e) {
                    Log.e("IB-InstabugSDKLogger", e.getMessage(), e);
                }
                if (SettingsManager.getInstance().isDebugEnabled()) {
                    Log.wtf(logTag(obj), str, th);
                    p(obj, str);
                }
            }
        }
    }
}
