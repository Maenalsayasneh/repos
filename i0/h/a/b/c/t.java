package i0.h.a.b.c;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class t extends r {
    public final byte[] b;

    public t(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.b = bArr;
    }

    @Override // i0.h.a.b.c.r
    public final byte[] d0() {
        return this.b;
    }
}
