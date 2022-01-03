package i0.f.a.c.j;

import i0.f.a.c.d;
import i0.f.a.c.h;
import i0.f.a.c.t.g;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: JsonDeserialize.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface c {
    Class<?> as() default Void.class;

    Class<?> builder() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends g> contentConverter() default g.a.class;

    Class<? extends d> contentUsing() default d.a.class;

    Class<? extends g> converter() default g.a.class;

    Class<?> keyAs() default Void.class;

    Class<? extends h> keyUsing() default h.a.class;

    Class<? extends d> using() default d.a.class;
}
