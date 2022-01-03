package m0.r.t.a.r.m;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import m0.n.b.i;
import m0.r.t.a.r.c.r0.c;
import m0.r.t.a.r.c.r0.f;
import m0.r.t.a.r.m.z0.g;
import m0.r.t.a.r.m.z0.h;
/* compiled from: KotlinType.kt */
/* loaded from: classes4.dex */
public abstract class a0 extends v0 implements g, h {
    public a0() {
        super(null);
    }

    /* renamed from: P0 */
    public abstract a0 M0(boolean z);

    public abstract a0 Q0(f fVar);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            String[] strArr = {"[", DescriptorRenderer.s(DescriptorRenderer.b, it.next(), null, 2, null), "] "};
            i.e(sb, "$this$append");
            i.e(strArr, InstabugDbContract.UserAttributesEntry.COLUMN_VALUE);
            for (int i = 0; i < 3; i++) {
                sb.append(strArr[i]);
            }
        }
        sb.append(I0());
        if (!H0().isEmpty()) {
            m0.j.g.C(H0(), sb, ", ", "<", ">", 0, null, null, 112);
        }
        if (J0()) {
            sb.append("?");
        }
        String sb2 = sb.toString();
        i.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
