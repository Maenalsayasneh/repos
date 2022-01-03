package k0.b.z.b;
/* compiled from: ObjectHelper.java */
/* loaded from: classes4.dex */
public final class b {
    public static int a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
