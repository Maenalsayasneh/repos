package i0.h.a.b.c.i;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class k {
    public final List<String> a = new ArrayList();
    public final Object b;

    public k(Object obj, q0 q0Var) {
        Objects.requireNonNull(obj, "null reference");
        this.b = obj;
    }

    @RecentlyNonNull
    public final k a(@RecentlyNonNull String str, Object obj) {
        List<String> list = this.a;
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + str.length() + 1);
        sb.append(str);
        sb.append("=");
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    @RecentlyNonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.b.getClass().getSimpleName());
        sb.append('{');
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
