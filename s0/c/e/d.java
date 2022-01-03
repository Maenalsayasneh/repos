package s0.c.e;

import java.io.PrintStream;
/* compiled from: Util.java */
/* loaded from: classes4.dex */
public final class d {
    public static b a = null;
    public static boolean b = false;

    /* compiled from: Util.java */
    /* loaded from: classes4.dex */
    public static final class b extends SecurityManager {
        public b(a aVar) {
        }

        @Override // java.lang.SecurityManager
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static final void a(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    public static final void b(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }
}
