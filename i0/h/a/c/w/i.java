package i0.h.a.c.w;

import android.graphics.RectF;
import java.util.Arrays;
/* compiled from: RelativeCornerSize.java */
/* loaded from: classes2.dex */
public final class i implements c {
    public final float a;

    public i(float f) {
        this.a = f;
    }

    @Override // i0.h.a.c.w.c
    public float a(RectF rectF) {
        return rectF.height() * this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.a == ((i) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
