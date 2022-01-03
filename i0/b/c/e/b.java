package i0.b.c.e;

import java.util.Objects;
/* compiled from: DpValue.kt */
/* loaded from: classes.dex */
public final class b {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        Objects.requireNonNull((b) obj);
        return true;
    }

    public int hashCode() {
        return Integer.hashCode(0);
    }

    public String toString() {
        return "DpValue(dpValue=0)";
    }
}
