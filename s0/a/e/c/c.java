package s0.a.e.c;

import java.util.Arrays;
import s0.a.e.b.b0.c.h3;
/* loaded from: classes4.dex */
public class c {
    public final int[] a;

    public c(int[] iArr) {
        this.a = h3.O(iArr);
    }

    public int a() {
        int[] iArr = this.a;
        return iArr[iArr.length - 1];
    }

    public int[] b() {
        return h3.O(this.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return Arrays.equals(this.a, ((c) obj).a);
    }

    public int hashCode() {
        return h3.n1(this.a);
    }
}
