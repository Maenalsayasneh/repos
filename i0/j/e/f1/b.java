package i0.j.e.f1;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/* compiled from: LabelFrame.java */
@SuppressFBWarnings({"CO_COMPARETO_INCORRECT_FLOATING", "EQ_COMPARETO_USE_OBJECT_EQUALS"})
/* loaded from: classes2.dex */
public class b implements Comparable<b> {
    public String c;
    public float d;
    public float q;

    public b(String str, float f, float f2) {
        this.c = str;
        this.d = f2;
        this.q = f;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        if (b() > bVar.b()) {
            return 1;
        }
        int i = (b() > bVar.b() ? 1 : (b() == bVar.b() ? 0 : -1));
        return -1;
    }

    public final float b() {
        float f = this.q;
        float f2 = this.d;
        return (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
    }
}
