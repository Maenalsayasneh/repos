package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface JsonIncludeProperties {

    /* loaded from: classes2.dex */
    public static class Value implements Serializable {
        public static final Value c = new Value(null);
        public final Set<String> d;

        public Value(Set<String> set) {
            this.d = set;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            boolean z;
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj.getClass() == Value.class) {
                Set<String> set = this.d;
                Set<String> set2 = ((Value) obj).d;
                if (set == null) {
                    z = set2 == null;
                } else {
                    z = set.equals(set2);
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Set<String> set = this.d;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this.d);
        }
    }

    String[] value() default {};
}
