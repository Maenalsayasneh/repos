package i0.l.a.i.a;

import i0.l.a.i.a.g;
import java.io.IOException;
/* compiled from: JSONStyle.java */
/* loaded from: classes2.dex */
public class e {
    public static final e a = new e(0);
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public g.AbstractC0208g f;
    public g.AbstractC0208g g;
    public g.h h;

    public e(int i) {
        g.AbstractC0208g gVar;
        boolean z = false;
        boolean z2 = (i & 1) == 0;
        this.b = z2;
        boolean z3 = (i & 4) == 0;
        this.d = z3;
        boolean z4 = (i & 2) == 0;
        this.c = z4;
        this.e = (i & 16) > 0 ? true : z;
        if ((i & 8) > 0) {
            gVar = g.c;
        } else {
            gVar = g.a;
        }
        if (z3) {
            this.g = g.b;
        } else {
            this.g = gVar;
        }
        if (z2) {
            this.f = g.b;
        } else {
            this.f = gVar;
        }
        if (z4) {
            this.h = g.e;
        } else {
            this.h = g.d;
        }
    }

    public void a(Appendable appendable, String str) throws IOException {
        if (!this.g.a(str)) {
            appendable.append(str);
            return;
        }
        appendable.append('\"');
        f.a(str, appendable, this);
        appendable.append('\"');
    }
}
