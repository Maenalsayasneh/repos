package i0.j.e.p0;

import android.app.Activity;
import java.lang.ref.WeakReference;
/* compiled from: ActivityReferenceManager.java */
/* loaded from: classes2.dex */
public final class a {
    public WeakReference<Activity> a;

    public Activity a() {
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        Activity activity = weakReference.get();
        boolean z = false;
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            z = true;
        }
        if (!z) {
            return null;
        }
        return activity;
    }
}
