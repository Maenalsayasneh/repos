package m0;

import com.google.android.gms.recaptcha.RecaptchaActionType;
import m0.n.b.i;
/* compiled from: KotlinVersion.kt */
/* loaded from: classes4.dex */
public final class b implements Comparable<b> {
    public static final b c = new b(1, 5, 21);
    public final int d;
    public final int q;
    public final int x;
    public final int y;

    public b(int i, int i2, int i3) {
        this.q = i;
        this.x = i2;
        this.y = i3;
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            this.d = (i << 16) + (i2 << 8) + i3;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    @Override // java.lang.Comparable
    public int compareTo(b bVar) {
        b bVar2 = bVar;
        i.e(bVar2, RecaptchaActionType.OTHER);
        return this.d - bVar2.d;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            obj = null;
        }
        b bVar = (b) obj;
        return bVar != null && this.d == bVar.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.d;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.q);
        sb.append('.');
        sb.append(this.x);
        sb.append('.');
        sb.append(this.y);
        return sb.toString();
    }
}
