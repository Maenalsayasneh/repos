package h0.v.a;

import android.view.View;
/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
public class b0 {
    public final b a;
    public a b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    public static class a {
        public int a = 0;
        public int b;
        public int c;
        public int d;
        public int e;

        public boolean a() {
            int i = this.a;
            if ((i & 7) != 0 && (i & (b(this.d, this.b) << 0)) == 0) {
                return false;
            }
            int i2 = this.a;
            if ((i2 & 112) != 0 && (i2 & (b(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.a;
            if ((i3 & 1792) != 0 && (i3 & (b(this.e, this.b) << 8)) == 0) {
                return false;
            }
            int i4 = this.a;
            if ((i4 & 28672) == 0 || (i4 & (b(this.e, this.c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        public int b(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    public interface b {
        int a(View view);

        int b();

        int c();

        View d(int i);

        int e(View view);
    }

    public b0(b bVar) {
        this.a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int b2 = this.a.b();
        int c = this.a.c();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View d = this.a.d(i);
            int a2 = this.a.a(d);
            int e = this.a.e(d);
            a aVar = this.b;
            aVar.b = b2;
            aVar.c = c;
            aVar.d = a2;
            aVar.e = e;
            if (i3 != 0) {
                aVar.a = 0;
                aVar.a = i3 | 0;
                if (aVar.a()) {
                    return d;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.b;
                aVar2.a = 0;
                aVar2.a = i4 | 0;
                if (aVar2.a()) {
                    view = d;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        a aVar = this.b;
        int b2 = this.a.b();
        int c = this.a.c();
        int a2 = this.a.a(view);
        int e = this.a.e(view);
        aVar.b = b2;
        aVar.c = c;
        aVar.d = a2;
        aVar.e = e;
        if (i == 0) {
            return false;
        }
        a aVar2 = this.b;
        aVar2.a = 0;
        aVar2.a = 0 | i;
        return aVar2.a();
    }
}
