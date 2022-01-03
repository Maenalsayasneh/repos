package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import s0.a.e.b.b0.c.h3;
/* loaded from: classes4.dex */
public final class XMSSNode implements Serializable {
    public final int c;
    public final byte[] d;

    public XMSSNode(int i, byte[] bArr) {
        this.c = i;
        this.d = bArr;
    }

    public byte[] a() {
        return h3.P(this.d);
    }
}
