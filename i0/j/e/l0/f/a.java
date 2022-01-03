package i0.j.e.l0.f;

import android.os.Build;
import com.instabug.library.util.InstabugSDKLogger;
import com.pubnub.api.vendor.FileEncryptionUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
/* compiled from: InstabugRootChecker.java */
@SuppressFBWarnings({"DMI_HARDCODED_ABSOLUTE_FILENAME"})
/* loaded from: classes2.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.lang.Class<i0.j.e.l0.f.a>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static boolean a() {
        boolean z;
        boolean z2;
        Object obj;
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        try {
            z = new File("/system/app/Superuser.apk").exists();
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            return true;
        }
        ?? r02 = a.class;
        ArrayList arrayList = new ArrayList();
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charset.forName(FileEncryptionUtil.ENCODING_UTF_8)));
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            InstabugSDKLogger.addVerboseLog(r02, "SHELL --> Line received: " + readLine);
                            arrayList.add(readLine);
                        } catch (Throwable th) {
                            exec.destroy();
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        obj = r02;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    exec.destroy();
                    bufferedReader.close();
                    obj = r02;
                }
            }
            exec.destroy();
            bufferedReader.close();
            obj = r02;
            InstabugSDKLogger.addVerboseLog(obj, "SHELL --> Full response was: " + arrayList);
            r02 = arrayList.size();
        } catch (Exception unused2) {
        }
        if (r02 != 0) {
            z2 = true;
            return !z2;
        }
        z2 = false;
        if (!z2) {
        }
    }
}
