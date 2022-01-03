package i0.h.c.m;

import i0.d.a.a.a;
import java.util.Collections;
import java.util.Map;
/* compiled from: FieldDescriptor.java */
/* loaded from: classes2.dex */
public final class c {
    public final String a;
    public final Map<Class<?>, Object> b;

    public c(String str, Map<Class<?>, Object> map) {
        this.a = str;
        this.b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a) && this.b.equals(cVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder P0 = a.P0("FieldDescriptor{name=");
        P0.append(this.a);
        P0.append(", properties=");
        P0.append(this.b.values());
        P0.append("}");
        return P0.toString();
    }
}
