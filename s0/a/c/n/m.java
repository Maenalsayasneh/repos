package s0.a.c.n;

import i0.d.a.a.a;
import java.security.spec.EncodedKeySpec;
import s0.a.e.b.b0.c.h3;
import s0.a.g.j;
/* loaded from: classes4.dex */
public class m extends EncodedKeySpec {
    public static final String[] c = {"ssh-rsa", "ssh-ed25519", "ssh-dss"};
    public final String d;

    public m(byte[] bArr) {
        super(bArr);
        int i = 0;
        int i2 = (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) + 4;
        if (i2 < bArr.length) {
            String a = j.a(h3.q0(bArr, 4, i2));
            this.d = a;
            if (!a.startsWith("ecdsa")) {
                while (true) {
                    String[] strArr = c;
                    if (i >= strArr.length) {
                        StringBuilder P0 = a.P0("unrecognised public key type ");
                        P0.append(this.d);
                        throw new IllegalArgumentException(P0.toString());
                    } else if (!strArr[i].equals(this.d)) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
        }
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return "OpenSSH";
    }
}
