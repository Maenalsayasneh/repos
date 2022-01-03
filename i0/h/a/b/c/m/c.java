package i0.h.a.b.c.m;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.RecentlyNullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class c {
    public static String a;
    public static int b;

    @RecentlyNullable
    public static String a() {
        BufferedReader bufferedReader;
        Throwable th;
        if (a == null) {
            if (b == 0) {
                b = Process.myPid();
            }
            int i = b;
            String str = null;
            str = null;
            str = null;
            BufferedReader bufferedReader2 = null;
            str = null;
            if (i > 0) {
                try {
                    try {
                        StringBuilder sb = new StringBuilder(25);
                        sb.append("/proc/");
                        sb.append(i);
                        sb.append("/cmdline");
                        bufferedReader = b(sb.toString());
                        try {
                            String readLine = bufferedReader.readLine();
                            Objects.requireNonNull(readLine, "null reference");
                            str = readLine.trim();
                            bufferedReader.close();
                        } catch (IOException unused) {
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            a = str;
                            return a;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused3) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException unused4) {
                }
            }
            a = str;
        }
        return a;
    }

    public static BufferedReader b(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
