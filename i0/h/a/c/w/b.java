package i0.h.a.c.w;

import android.graphics.RectF;
import java.util.Arrays;
/* compiled from: AdjustedCornerSize.java */
/* loaded from: classes2.dex */
public final class b implements c {
    public final c a;
    public final float b;

    public b(float f, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).a;
            f += ((b) cVar).b;
        }
        this.a = cVar;
        this.b = f;
    }

    @Override // i0.h.a.c.w.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.b == bVar.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
