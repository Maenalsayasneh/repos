package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class AccessorNamingStrategy {

    /* loaded from: classes2.dex */
    public static abstract class Provider implements Serializable {
    }

    public abstract String a(AnnotatedMethod annotatedMethod, String str);

    public abstract String b(AnnotatedMethod annotatedMethod, String str);

    public abstract String c(AnnotatedMethod annotatedMethod, String str);
}
