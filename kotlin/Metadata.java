package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: Metadata.kt */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0013\u0010\t\u001a\u00020\u00038\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0016\u0010\u0013\u001a\u00020\u00108\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u00020\u00108\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0017\u001a\u00020\n8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00038\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lkotlin/Metadata;", "", "", "", "d1", "()[Ljava/lang/String;", "data1", "xs", "()Ljava/lang/String;", "extraString", "", "bv", "()[I", "bytecodeVersion", "d2", "data2", "", "xi", "()I", "extraInt", "k", "kind", "mv", "metadataVersion", "pn", "packageName", "<init>", "(I[I[ILkotlin/Array;Lkotlin/Array;Ljava/lang/String;Ljava/lang/String;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public @interface Metadata {
    int[] bv() default {1, 0, 3};

    String[] d1() default {};

    String[] d2() default {};

    int k() default 1;

    int[] mv() default {};

    String pn() default "";

    int xi() default 0;

    String xs() default "";
}
