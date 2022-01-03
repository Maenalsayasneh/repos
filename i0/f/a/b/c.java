package i0.f.a.b;

import i0.f.a.b.i.a;
/* compiled from: JsonStreamContext.java */
/* loaded from: classes2.dex */
public abstract class c {
    public int a;
    public int b;

    public c() {
    }

    public abstract String a();

    public abstract Object b();

    public abstract c c();

    public final boolean d() {
        return this.a == 1;
    }

    public final boolean e() {
        return this.a == 2;
    }

    public final boolean f() {
        return this.a == 0;
    }

    public abstract void g(Object obj);

    public String h() {
        int i = this.a;
        if (i == 0) {
            return "root";
        }
        if (i != 1) {
            return i != 2 ? "?" : "Object";
        }
        return "Array";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this.a;
        if (i == 0) {
            sb.append("/");
        } else if (i != 1) {
            sb.append('{');
            String a = a();
            if (a != null) {
                sb.append('\"');
                a.a(sb, a);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else {
            sb.append('[');
            int i2 = this.b;
            if (i2 < 0) {
                i2 = 0;
            }
            sb.append(i2);
            sb.append(']');
        }
        return sb.toString();
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
    }

    public c(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
