package q0.h0.g;

import java.net.Proxy;
/* loaded from: classes4.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Proxy.Type.values().length];
        a = iArr;
        iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        iArr[Proxy.Type.HTTP.ordinal()] = 2;
    }
}
