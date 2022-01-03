package com.fasterxml.jackson.databind.annotation;

import i0.f.a.c.g;
import i0.f.a.c.t.g;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface JsonSerialize {

    @Deprecated
    /* loaded from: classes2.dex */
    public enum Inclusion {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY,
        DEFAULT_INCLUSION
    }

    /* loaded from: classes2.dex */
    public enum Typing {
        DYNAMIC,
        STATIC,
        DEFAULT_TYPING
    }

    Class<?> as() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends g> contentConverter() default g.a.class;

    Class<? extends i0.f.a.c.g> contentUsing() default g.a.class;

    Class<? extends i0.f.a.c.t.g> converter() default g.a.class;

    @Deprecated
    Inclusion include() default Inclusion.DEFAULT_INCLUSION;

    Class<?> keyAs() default Void.class;

    Class<? extends i0.f.a.c.g> keyUsing() default g.a.class;

    Class<? extends i0.f.a.c.g> nullsUsing() default g.a.class;

    Typing typing() default Typing.DEFAULT_TYPING;

    Class<? extends i0.f.a.c.g> using() default g.a.class;
}
