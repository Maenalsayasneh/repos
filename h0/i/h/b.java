package h0.i.h;

import i0.d.a.a.a;
import java.util.Objects;
/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class b<F, S> {
    public final F a;
    public final S b;

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(bVar.a, this.a) || !Objects.equals(bVar.b, this.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f = this.a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder P0 = a.P0("Pair{");
        P0.append(this.a);
        P0.append(" ");
        P0.append(this.b);
        P0.append("}");
        return P0.toString();
    }
}
