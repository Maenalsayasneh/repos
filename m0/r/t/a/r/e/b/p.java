package m0.r.t.a.r.e.b;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import m0.n.b.i;
/* compiled from: SignatureBuildingComponents.kt */
/* loaded from: classes4.dex */
public final class p {
    public static final p a = new p();

    public final String[] a(String... strArr) {
        i.e(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public final String b(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final Set<String> c(String str, String... strArr) {
        i.e(str, "internalName");
        i.e(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set<String> d(String str, String... strArr) {
        i.e(str, "name");
        i.e(strArr, "signatures");
        String g = g(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return c(g, strArr2);
    }

    public final Set<String> e(String str, String... strArr) {
        i.e(str, "name");
        i.e(strArr, "signatures");
        String h = h(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return c(h, strArr2);
    }

    public final String f(String str) {
        i.e(str, "name");
        return i.k("java/util/function/", str);
    }

    public final String g(String str) {
        i.e(str, "name");
        return i.k("java/lang/", str);
    }

    public final String h(String str) {
        i.e(str, "name");
        return i.k("java/util/", str);
    }

    public final String i(String str, String str2) {
        i.e(str, "internalName");
        i.e(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
