package i0.f.a.d.a;
/* compiled from: CBORConstants.java */
/* loaded from: classes2.dex */
public final class a {
    public static final int[] a;

    static {
        int[] iArr = new int[256];
        for (int i = 128; i < 256; i++) {
            iArr[i] = (i & 224) == 192 ? 1 : (i & 240) == 224 ? 2 : (i & 248) == 240 ? 3 : -1;
        }
        a = iArr;
    }
}
