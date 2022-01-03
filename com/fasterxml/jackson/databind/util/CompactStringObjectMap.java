package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class CompactStringObjectMap implements Serializable {
    public static final CompactStringObjectMap c = new CompactStringObjectMap(1, 0, new Object[4]);
    public final int d;
    public final int q;
    public final Object[] x;

    public CompactStringObjectMap(int i, int i2, Object[] objArr) {
        this.d = i;
        this.q = i2;
        this.x = objArr;
    }

    public Object a(String str) {
        int hashCode = str.hashCode() & this.d;
        int i = hashCode << 1;
        Object obj = this.x[i];
        if (obj == str || str.equals(obj)) {
            return this.x[i + 1];
        }
        if (obj == null) {
            return null;
        }
        int i2 = this.d + 1;
        int i3 = ((hashCode >> 1) + i2) << 1;
        Object obj2 = this.x[i3];
        if (str.equals(obj2)) {
            return this.x[i3 + 1];
        }
        if (obj2 == null) {
            return null;
        }
        int i4 = (i2 + (i2 >> 1)) << 1;
        int i5 = this.q + i4;
        while (i4 < i5) {
            Object obj3 = this.x[i4];
            if (obj3 == str || str.equals(obj3)) {
                return this.x[i4 + 1];
            }
            i4 += 2;
        }
        return null;
    }
}
