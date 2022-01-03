package m0.p;

import kotlin.random.Random;
/* compiled from: PlatformRandom.kt */
/* loaded from: classes4.dex */
public abstract class a extends Random {
    @Override // kotlin.random.Random
    public int a(int i) {
        return ((-i) >> 31) & (e().nextInt() >>> (32 - i));
    }

    @Override // kotlin.random.Random
    public int b() {
        return e().nextInt();
    }

    @Override // kotlin.random.Random
    public long c() {
        return e().nextLong();
    }

    public abstract java.util.Random e();
}
