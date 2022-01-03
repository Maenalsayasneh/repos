package i0.b.a;

import android.content.Context;
import java.util.Arrays;
/* compiled from: StringAttributeData.java */
/* loaded from: classes.dex */
public class k0 {
    public final boolean a;
    public final CharSequence b;
    public CharSequence c;
    public int d;
    public Object[] e;

    public k0() {
        this.a = false;
        this.b = null;
    }

    public void a(int i, Object[] objArr) {
        if (i != 0) {
            this.d = i;
            this.e = null;
            this.c = null;
        } else if (this.a) {
            b(this.b);
        } else {
            throw new IllegalArgumentException("0 is an invalid value for required strings.");
        }
    }

    public void b(CharSequence charSequence) {
        this.c = charSequence;
        this.d = 0;
    }

    public CharSequence c(Context context) {
        if (this.d == 0) {
            return this.c;
        }
        if (this.e != null) {
            return context.getResources().getString(this.d, this.e);
        }
        return context.getResources().getText(this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        if (this.d != k0Var.d) {
            return false;
        }
        CharSequence charSequence = this.c;
        if (charSequence == null ? k0Var.c == null : charSequence.equals(k0Var.c)) {
            return Arrays.equals(this.e, k0Var.e);
        }
        return false;
    }

    public int hashCode() {
        CharSequence charSequence = this.c;
        return Arrays.hashCode(this.e) + ((((((((charSequence != null ? charSequence.hashCode() : 0) * 31) + this.d) * 31) + 0) * 31) + 0) * 31);
    }

    public k0(CharSequence charSequence) {
        this.a = true;
        this.b = null;
        this.c = null;
    }
}
