package n0.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import m0.j.g;
import n0.a.h2.a;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public abstract class s0 extends d0 {
    public static final /* synthetic */ int d = 0;
    public long q;
    public boolean x;
    public a<l0<?>> y;

    public final void T(boolean z) {
        long U = this.q - U(z);
        this.q = U;
        if (U <= 0 && this.x) {
            shutdown();
        }
    }

    public final long U(boolean z) {
        return z ? 4294967296L : 1;
    }

    public final void Y(l0<?> l0Var) {
        a<l0<?>> aVar = this.y;
        if (aVar == null) {
            aVar = new a<>();
            this.y = aVar;
        }
        Object[] objArr = aVar.a;
        int i = aVar.c;
        objArr[i] = l0Var;
        int length = (objArr.length - 1) & (i + 1);
        aVar.c = length;
        int i2 = aVar.b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            g.j(objArr, objArr2, 0, i2, 0, 10);
            Object[] objArr3 = aVar.a;
            int length3 = objArr3.length;
            int i3 = aVar.b;
            g.j(objArr3, objArr2, length3 - i3, 0, i3, 4);
            aVar.a = objArr2;
            aVar.b = 0;
            aVar.c = length2;
        }
    }

    public final void Z(boolean z) {
        this.q = U(z) + this.q;
        if (!z) {
            this.x = true;
        }
    }

    public final boolean b0() {
        return this.q >= U(true);
    }

    public long c0() {
        if (!d0()) {
            return RecyclerView.FOREVER_NS;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean d0() {
        a<l0<?>> aVar = this.y;
        if (aVar == null) {
            return false;
        }
        int i = aVar.b;
        l0 l0Var = null;
        if (i != aVar.c) {
            ?? r3 = aVar.a;
            ?? r6 = r3[i];
            r3[i] = 0;
            aVar.b = (i + 1) & (r3.length - 1);
            Objects.requireNonNull(r6, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
            l0Var = r6;
        }
        l0 l0Var2 = l0Var;
        if (l0Var2 == null) {
            return false;
        }
        l0Var2.run();
        return true;
    }

    public void shutdown() {
    }
}
