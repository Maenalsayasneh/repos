package h0.u;
/* compiled from: PagingConfig.kt */
/* loaded from: classes.dex */
public final class v {
    public final int a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;

    public v(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        i2 = (i6 & 2) != 0 ? i : i2;
        boolean z2 = true;
        z = (i6 & 4) != 0 ? true : z;
        i3 = (i6 & 8) != 0 ? i * 3 : i3;
        i4 = (i6 & 16) != 0 ? Integer.MAX_VALUE : i4;
        i5 = (i6 & 32) != 0 ? Integer.MIN_VALUE : i5;
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        if (!z && i2 == 0) {
            throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
        } else if (i4 == Integer.MAX_VALUE || i4 >= (i2 * 2) + i) {
            if (i5 != Integer.MIN_VALUE && i5 <= 0) {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.".toString());
            }
        } else {
            throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + i + ", prefetchDist=" + i2 + ", maxSize=" + i4);
        }
    }
}
