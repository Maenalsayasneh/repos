package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface JsonSetter {

    /* loaded from: classes2.dex */
    public static class Value implements Serializable {
        public static final Value c;
        public final Nulls d;
        public final Nulls q;

        static {
            Nulls nulls = Nulls.DEFAULT;
            c = new Value(nulls, nulls);
        }

        public Value(Nulls nulls, Nulls nulls2) {
            this.d = nulls;
            this.q = nulls2;
        }

        public static Value a(Nulls nulls, Nulls nulls2) {
            if (nulls == null) {
                nulls = Nulls.DEFAULT;
            }
            if (nulls2 == null) {
                nulls2 = Nulls.DEFAULT;
            }
            Nulls nulls3 = Nulls.DEFAULT;
            if (nulls == nulls3 && nulls2 == nulls3) {
                return c;
            }
            return new Value(nulls, nulls2);
        }

        public Nulls b() {
            Nulls nulls = this.q;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
        }

        public Nulls c() {
            Nulls nulls = this.d;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != Value.class) {
                return false;
            }
            Value value = (Value) obj;
            return value.d == this.d && value.q == this.q;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.d.ordinal() + (this.q.ordinal() << 2);
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", this.d, this.q);
        }
    }

    Nulls contentNulls() default Nulls.DEFAULT;

    Nulls nulls() default Nulls.DEFAULT;

    String value() default "";
}
