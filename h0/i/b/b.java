package h0.i.b;

import android.content.LocusId;
import android.os.Build;
import android.text.TextUtils;
import i0.d.a.a.a;
/* compiled from: LocusIdCompat.java */
/* loaded from: classes.dex */
public final class b {
    public final String a;
    public final LocusId b;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
            if (Build.VERSION.SDK_INT >= 29) {
                this.b = new LocusId(str);
            } else {
                this.b = null;
            }
        } else {
            throw new IllegalArgumentException("id cannot be empty");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.a;
        if (str == null) {
            return bVar.a == null;
        }
        return str.equals(bVar.a);
    }

    public int hashCode() {
        String str = this.a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder P0 = a.P0("LocusIdCompat[");
        int length = this.a.length();
        P0.append(length + "_chars");
        P0.append("]");
        return P0.toString();
    }
}
