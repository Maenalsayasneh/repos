package s0.a.f.d.a;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public final class c {
    static {
        BigInteger.valueOf(0);
        BigInteger.valueOf(1);
        BigInteger.valueOf(2);
        BigInteger.valueOf(4);
    }

    public static int a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            i = -i;
        }
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 8;
        }
        return i2;
    }
}
