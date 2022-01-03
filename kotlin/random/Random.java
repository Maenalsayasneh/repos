package kotlin.random;

import java.io.Serializable;
import m0.m.b;
import m0.n.b.i;
/* compiled from: Random.kt */
/* loaded from: classes4.dex */
public abstract class Random {
    public static final Default d = new Default();
    public static final Random c = b.a.b();

    /* compiled from: Random.kt */
    /* loaded from: classes4.dex */
    public static final class Default extends Random implements Serializable {
        @Override // kotlin.random.Random
        public int a(int i) {
            return Random.c.a(i);
        }

        @Override // kotlin.random.Random
        public int b() {
            return Random.c.b();
        }

        @Override // kotlin.random.Random
        public long c() {
            return Random.c.c();
        }

        @Override // kotlin.random.Random
        public long d(long j, long j2) {
            return Random.c.d(j, j2);
        }
    }

    public abstract int a(int i);

    public abstract int b();

    public abstract long c();

    public long d(long j, long j2) {
        long j3;
        long c2;
        long j4;
        int i;
        if (j2 > j) {
            long j5 = j2 - j;
            if (j5 > 0) {
                if (((-j5) & j5) == j5) {
                    int i2 = (int) j5;
                    int i3 = (int) (j5 >>> 32);
                    if (i2 != 0) {
                        i = a(31 - Integer.numberOfLeadingZeros(i2));
                    } else if (i3 == 1) {
                        i = b();
                    } else {
                        j3 = (((long) a(31 - Integer.numberOfLeadingZeros(i3))) << 32) + ((long) b());
                    }
                    j3 = ((long) i) & 4294967295L;
                } else {
                    do {
                        c2 = c() >>> 1;
                        j4 = c2 % j5;
                    } while ((j5 - 1) + (c2 - j4) < 0);
                    j3 = j4;
                }
                return j + j3;
            }
            while (true) {
                long c3 = c();
                if (j <= c3 && j2 > c3) {
                    return c3;
                }
            }
        } else {
            Long valueOf = Long.valueOf(j);
            Long valueOf2 = Long.valueOf(j2);
            i.e(valueOf, "from");
            i.e(valueOf2, "until");
            throw new IllegalArgumentException(("Random range is empty: [" + valueOf + ", " + valueOf2 + ").").toString());
        }
    }
}
