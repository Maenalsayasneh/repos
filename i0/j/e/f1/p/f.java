package i0.j.e.f1.p;

import android.view.View;
import java.util.Collection;
import java.util.LinkedHashSet;
import k0.b.y.e;
/* compiled from: Functions.java */
/* loaded from: classes2.dex */
public final class f implements e<Collection<View>, Collection<View>> {
    @Override // k0.b.y.e
    public Collection<View> apply(Collection<View> collection) throws Exception {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (View view : collection) {
            if (!view.getClass().getName().startsWith("com.instabug")) {
                linkedHashSet.add(view);
            }
        }
        return linkedHashSet;
    }
}
