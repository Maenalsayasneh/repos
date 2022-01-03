package i0.b.c.e;

import java.util.Objects;
/* compiled from: ColorValue.kt */
/* loaded from: classes.dex */
public final class a {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        Objects.requireNonNull((a) obj);
        return true;
    }

    public int hashCode() {
        return Integer.hashCode(0);
    }

    public String toString() {
        return "ColorValue(colorValue=0)";
    }
}
