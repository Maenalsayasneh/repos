package n0.a;

import androidx.recyclerview.widget.RecyclerView;
import n0.a.h2.t;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public final class v0 {
    public static final t a = new t("REMOVED_TASK");
    public static final t b = new t("CLOSED_EMPTY");

    public static final long a(long j) {
        if (j <= 0) {
            return 0;
        }
        return j >= 9223372036854L ? RecyclerView.FOREVER_NS : 1000000 * j;
    }
}
