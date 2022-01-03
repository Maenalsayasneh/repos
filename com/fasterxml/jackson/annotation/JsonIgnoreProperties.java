package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Set;
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface JsonIgnoreProperties {

    /* loaded from: classes2.dex */
    public static class Value implements Serializable {
        public static final Value c = new Value(Collections.emptySet(), false, false, false, true);
        public final boolean Y1;
        public final Set<String> d;
        public final boolean q;
        public final boolean x;
        public final boolean y;

        public Value(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            if (set == null) {
                this.d = Collections.emptySet();
            } else {
                this.d = set;
            }
            this.q = z;
            this.x = z2;
            this.y = z3;
            this.Y1 = z4;
        }

        public static boolean a(Value value, Value value2) {
            return value.q == value2.q && value.Y1 == value2.Y1 && value.x == value2.x && value.y == value2.y && value.d.equals(value2.d);
        }

        public static Value b(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            Value value = c;
            boolean z5 = false;
            if (z == value.q && z2 == value.x && z3 == value.y && z4 == value.Y1 && (set == null || set.size() == 0)) {
                z5 = true;
            }
            if (z5) {
                return value;
            }
            return new Value(set, z, z2, z3, z4);
        }

        public Set<String> c() {
            if (this.y) {
                return Collections.emptySet();
            }
            return this.d;
        }

        public Set<String> d() {
            if (this.x) {
                return Collections.emptySet();
            }
            return this.d;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            return obj.getClass() == Value.class && a(this, (Value) obj);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.d.size() + (this.q ? 1 : -3) + (this.x ? 3 : -7) + (this.y ? 7 : -11) + (this.Y1 ? 11 : -13);
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this.d, Boolean.valueOf(this.q), Boolean.valueOf(this.x), Boolean.valueOf(this.y), Boolean.valueOf(this.Y1));
        }
    }

    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};
}
