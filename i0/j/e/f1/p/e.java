package i0.j.e.f1.p;

import android.view.View;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* compiled from: Functions.java */
/* loaded from: classes2.dex */
public final class e implements k0.b.y.e<Collection<View>, Collection<View>> {
    @Override // k0.b.y.e
    public Collection<View> apply(Collection<View> collection) throws Exception {
        boolean z;
        Collection<View> collection2 = collection;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (View view : collection2) {
            Iterator<View> it = collection2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getParent() == view) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                linkedHashSet.add(view);
            }
        }
        return linkedHashSet;
    }
}
