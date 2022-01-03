package i0.j.b.p;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
/* compiled from: VisitedScreen.java */
/* loaded from: classes2.dex */
public class b {
    public int a;
    public String b;
    public String c;
    public String d;
    public Bitmap e;

    public b(int i, String str, String str2, String str3, Bitmap bitmap) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bitmap;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a != bVar.a || !this.c.equals(bVar.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 88;
    }
}
