package n0.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* compiled from: CompletionState.kt */
/* loaded from: classes4.dex */
public class z {
    public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(z.class, "_handled");
    private volatile /* synthetic */ int _handled;
    public final Throwable b;

    public z(Throwable th, boolean z) {
        this.b = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + this.b + ']';
    }

    public z(Throwable th, boolean z, int i) {
        z = (i & 2) != 0 ? false : z;
        this.b = th;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        this._handled = i2;
    }
}
