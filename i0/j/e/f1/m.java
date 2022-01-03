package i0.j.e.f1;

import android.content.Context;
import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.VisualUserStepsHelper;
import i0.d.a.a.a;
import i0.j.e.f1.c;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.File;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import k0.b.z.e.c.h;
/* compiled from: VisualUserSteps.java */
/* loaded from: classes2.dex */
public class m {
    public Deque<c> a = new LinkedBlockingDeque();
    public int b;

    public static boolean a(m mVar, String str) {
        String str2;
        Objects.requireNonNull(mVar);
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            File visualUserStepsDirectory = VisualUserStepsHelper.getVisualUserStepsDirectory(applicationContext);
            StringBuilder sb = new StringBuilder();
            sb.append(visualUserStepsDirectory);
            File file = new File(a.y0(sb, File.separator, str));
            if (!file.exists()) {
                str2 = "Couldn't execute deleteFile(). File does not exist";
            } else if (file.delete()) {
                InstabugSDKLogger.v("VisualUserSteps", "VisualUserStep screenshot deleted! filename= " + str);
                return true;
            } else {
                str2 = a.o0("Couldn't delete screenshot=", str, ". Something went wrong");
            }
        } else {
            str2 = "Couldn't execute deleteFile(). Context is null";
        }
        InstabugSDKLogger.e("VisualUserSteps", str2);
        return false;
    }

    public c b() {
        return this.a.peekLast();
    }

    public final c c() {
        return this.a.peekFirst();
    }

    public final void d() {
        c peekFirst = this.a.peekFirst();
        if (peekFirst != null) {
            c.a aVar = peekFirst.d;
            if (aVar != null) {
                RxJavaPlugins.onAssembly(new h(new l(this, aVar.a))).v(k0.b.d0.a.b()).t(new k(), k0.b.z.b.a.e, k0.b.z.b.a.c, k0.b.z.b.a.d);
            }
            this.b -= peekFirst.e.size();
            this.a.pollFirst();
        }
    }
}
