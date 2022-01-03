package h0.i.c;

import android.graphics.Insets;
import i0.d.a.a.a;
/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {
    public static final b a = new b(0, 0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public b(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.b, bVar2.b), Math.max(bVar.c, bVar2.c), Math.max(bVar.d, bVar2.d), Math.max(bVar.e, bVar2.e));
    }

    public static b b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return a;
        }
        return new b(i, i2, i3, i4);
    }

    public static b c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets d() {
        return Insets.of(this.b, this.c, this.d, this.e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.e == bVar.e && this.b == bVar.b && this.d == bVar.d && this.c == bVar.c;
    }

    public int hashCode() {
        return (((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        StringBuilder P0 = a.P0("Insets{left=");
        P0.append(this.b);
        P0.append(", top=");
        P0.append(this.c);
        P0.append(", right=");
        P0.append(this.d);
        P0.append(", bottom=");
        return a.s0(P0, this.e, '}');
    }
}
