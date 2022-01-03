package m0.r.t.a.r.e.b;

import androidx.core.app.FrameMetricsAggregator;
/* compiled from: TypeMappingMode.kt */
/* loaded from: classes4.dex */
public final class s {
    public static final s a;
    public static final s b = new s(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION);
    public static final s c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final s i;
    public final boolean j;
    public final s k;
    public final s l;
    public final boolean m;

    static {
        s sVar = new s(false, false, false, false, false, null, false, null, null, false, 1023);
        a = sVar;
        c = new s(false, false, false, false, false, sVar, false, null, null, false, 988);
    }

    public s(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, s sVar, boolean z6, s sVar2, s sVar3, boolean z7, int i) {
        z = (i & 1) != 0 ? true : z;
        z2 = (i & 2) != 0 ? true : z2;
        z3 = (i & 4) != 0 ? false : z3;
        z4 = (i & 8) != 0 ? false : z4;
        z5 = (i & 16) != 0 ? false : z5;
        sVar = (i & 32) != 0 ? null : sVar;
        z6 = (i & 64) != 0 ? true : z6;
        sVar2 = (i & 128) != 0 ? sVar : sVar2;
        sVar3 = (i & 256) != 0 ? sVar : sVar3;
        z7 = (i & 512) != 0 ? false : z7;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = sVar;
        this.j = z6;
        this.k = sVar2;
        this.l = sVar3;
        this.m = z7;
    }
}
