package com.fasterxml.jackson.annotation;

import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class ObjectIdGenerator<T> implements Serializable {

    /* loaded from: classes2.dex */
    public static final class IdKey implements Serializable {
        public final Class<?> c;
        public final Class<?> d;
        public final Object q;
        public final int x;

        public IdKey(Class<?> cls, Class<?> cls2, Object obj) {
            this.c = cls;
            this.d = cls2;
            this.q = obj;
            int hashCode = cls.getName().hashCode() + obj.hashCode();
            this.x = cls2 != null ? hashCode ^ cls2.getName().hashCode() : hashCode;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != IdKey.class) {
                return false;
            }
            IdKey idKey = (IdKey) obj;
            return idKey.q.equals(this.q) && idKey.c == this.c && idKey.d == this.d;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.x;
        }

        @Override // java.lang.Object
        public String toString() {
            String str;
            Object[] objArr = new Object[3];
            objArr[0] = this.q;
            Class<?> cls = this.c;
            String str2 = "NONE";
            if (cls == null) {
                str = str2;
            } else {
                str = cls.getName();
            }
            objArr[1] = str;
            Class<?> cls2 = this.d;
            if (cls2 != null) {
                str2 = cls2.getName();
            }
            objArr[2] = str2;
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", objArr);
        }
    }

    public abstract boolean a(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> b(Class<?> cls);

    public abstract T c(Object obj);

    public abstract Class<?> d();

    public abstract IdKey e(Object obj);

    public abstract ObjectIdGenerator<T> f(Object obj);
}
