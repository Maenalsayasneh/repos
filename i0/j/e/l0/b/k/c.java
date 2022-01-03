package i0.j.e.l0.b.k;

import java.util.Comparator;
/* compiled from: FileInspector.java */
/* loaded from: classes2.dex */
public class c implements Comparator<f> {
    @Override // java.util.Comparator
    public int compare(f fVar, f fVar2) {
        return Double.compare((double) fVar2.a(), (double) fVar.a());
    }
}
