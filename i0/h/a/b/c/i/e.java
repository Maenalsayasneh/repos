package i0.h.a.b.c.i;

import android.content.ServiceConnection;
import android.net.Uri;
import h0.b0.v;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public abstract class e {
    public static final Object a = new Object();
    public static e b;

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    /* loaded from: classes2.dex */
    public static final class a {
        public static final Uri a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        public final String b;
        public final String c;
        public final int d;
        public final boolean e;

        public a(String str, String str2, int i, boolean z) {
            v.x(str);
            this.b = str;
            v.x(str2);
            this.c = str2;
            this.d = i;
            this.e = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return v.c0(this.b, aVar.b) && v.c0(this.c, aVar.c) && v.c0(null, null) && this.d == aVar.d && this.e == aVar.e;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.b, this.c, null, Integer.valueOf(this.d), Boolean.valueOf(this.e)});
        }

        public final String toString() {
            String str = this.b;
            if (str != null) {
                return str;
            }
            Objects.requireNonNull((Object) null, "null reference");
            throw null;
        }
    }

    public abstract boolean a(a aVar, ServiceConnection serviceConnection, String str);

    public abstract void b(a aVar, ServiceConnection serviceConnection, String str);
}
