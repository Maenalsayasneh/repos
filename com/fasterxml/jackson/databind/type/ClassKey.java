package com.fasterxml.jackson.databind.type;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class ClassKey implements Comparable<ClassKey>, Serializable {
    public String c;
    public Class<?> d;
    public int q;

    public ClassKey() {
        this.d = null;
        this.c = null;
        this.q = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassKey classKey) {
        return this.c.compareTo(classKey.c);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == ClassKey.class && ((ClassKey) obj).d == this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.q;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c;
    }

    public ClassKey(Class<?> cls) {
        this.d = cls;
        String name = cls.getName();
        this.c = name;
        this.q = name.hashCode();
    }
}
