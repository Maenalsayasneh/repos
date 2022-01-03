package h0.i.i;

import i0.d.a.a.a;
import java.util.Objects;
/* compiled from: DisplayCutoutCompat.java */
/* loaded from: classes.dex */
public final class d {
    public final Object a;

    public d(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.a, ((d) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder P0 = a.P0("DisplayCutoutCompat{");
        P0.append(this.a);
        P0.append("}");
        return P0.toString();
    }
}
