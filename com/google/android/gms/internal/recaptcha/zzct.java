package com.google.android.gms.internal.recaptcha;

import i0.h.a.b.c.m.b;
import i0.h.a.b.g.h.b0;
import i0.h.a.b.g.h.p;
import i0.h.a.b.g.h.q;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-recaptcha@@16.0.0 */
/* loaded from: classes2.dex */
public abstract class zzct implements Serializable, Iterable<Byte> {
    public static final zzct c = new zzdd(b0.b);
    public int d = 0;

    static {
        p.a();
    }

    public static int x(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public abstract byte b(int i);

    public abstract int c();

    public abstract int e(int i, int i2, int i3);

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.d;
        if (i == 0) {
            int c2 = c();
            i = e(c2, 0, c2);
            if (i == 0) {
                i = 1;
            }
            this.d = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new q(this);
    }

    public abstract zzct k(int i, int i2);

    @Override // java.lang.Object
    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(c());
        objArr[2] = c() <= 50 ? b.r0(this) : String.valueOf(b.r0(k(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract String v(Charset charset);

    public abstract byte w(int i);

    public abstract boolean y();
}
