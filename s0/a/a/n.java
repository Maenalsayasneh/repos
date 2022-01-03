package s0.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import s0.a.e.b.b0.c.h3;
/* loaded from: classes4.dex */
public class n extends r {
    public static final ConcurrentMap<a, n> c = new ConcurrentHashMap();
    public final String d;
    public byte[] q;

    /* loaded from: classes4.dex */
    public static class a {
        public final int a;
        public final byte[] b;

        public a(byte[] bArr) {
            this.a = h3.m1(bArr);
            this.b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(this.b, ((a) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return this.a;
        }
    }

    public n(String str) {
        char charAt;
        Objects.requireNonNull(str, "'identifier' cannot be null");
        boolean z = false;
        if (str.length() >= 3 && str.charAt(1) == '.' && (charAt = str.charAt(0)) >= '0' && charAt <= '2') {
            z = F(str, 2);
        }
        if (z) {
            this.d = str;
            return;
        }
        throw new IllegalArgumentException(i0.d.a.a.a.o0("string ", str, " not an OID"));
    }

    public n(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigInteger = null;
        for (int i = 0; i != bArr.length; i++) {
            int i2 = bArr[i] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (i2 & 127));
                if ((i2 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf((long) (i2 & 127)));
                if ((i2 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.d = stringBuffer.toString();
        this.q = h3.I(bArr);
    }

    public static n D(Object obj) {
        if (obj == null || (obj instanceof n)) {
            return (n) obj;
        }
        if (obj instanceof e) {
            r c2 = ((e) obj).c();
            if (c2 instanceof n) {
                return (n) c2;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (n) r.x((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException(i0.d.a.a.a.V(e, i0.d.a.a.a.P0("failed to construct object identifier from byte[]: ")));
            }
        } else {
            throw new IllegalArgumentException(i0.d.a.a.a.c0(obj, i0.d.a.a.a.P0("illegal object in getInstance: ")));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r7.charAt(r0 + 1) != '0') goto L_0x0005;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r2 == 0) goto L_0x0021;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r2 <= 1) goto L_0x0005;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static boolean F(String str, int i) {
        int length = str.length();
        loop0: while (true) {
            int i2 = 0;
            while (true) {
                length--;
                if (length < i) {
                    return i2 != 0 && (i2 <= 1 || str.charAt(length + 1) != '0');
                }
                char charAt = str.charAt(length);
                if (charAt == '.') {
                    break;
                } else if ('0' > charAt || charAt > '9') {
                    break loop0;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void B(java.io.ByteArrayOutputStream r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.String r1 = r0.d
            r2 = 46
            r3 = 0
            int r4 = r1.indexOf(r2, r3)
            r5 = -1
            r6 = 1
            if (r4 != r5) goto L_0x0015
            java.lang.String r4 = r1.substring(r3)
            r7 = r5
            goto L_0x001f
        L_0x0015:
            java.lang.String r7 = r1.substring(r3, r4)
            int r4 = r4 + r6
            r16 = r7
            r7 = r4
            r4 = r16
        L_0x001f:
            int r4 = java.lang.Integer.parseInt(r4)
            int r4 = r4 * 40
            r8 = 0
            if (r7 != r5) goto L_0x002b
            r9 = r7
            r7 = r8
            goto L_0x003c
        L_0x002b:
            int r9 = r1.indexOf(r2, r7)
            if (r9 != r5) goto L_0x0037
            java.lang.String r7 = r1.substring(r7)
            r9 = r5
            goto L_0x003c
        L_0x0037:
            java.lang.String r7 = r1.substring(r7, r9)
            int r9 = r9 + r6
        L_0x003c:
            int r10 = r7.length()
            r11 = 18
            if (r10 > r11) goto L_0x004e
            long r12 = (long) r4
            long r14 = java.lang.Long.parseLong(r7)
            long r12 = r12 + r14
            r7 = r18
            r4 = r0
            goto L_0x008b
        L_0x004e:
            java.math.BigInteger r10 = new java.math.BigInteger
            r10.<init>(r7)
            long r12 = (long) r4
            java.math.BigInteger r4 = java.math.BigInteger.valueOf(r12)
            java.math.BigInteger r4 = r10.add(r4)
            r7 = r18
            r0.I(r7, r4)
            r4 = r0
        L_0x0062:
            if (r9 == r5) goto L_0x0066
            r10 = r6
            goto L_0x0067
        L_0x0066:
            r10 = r3
        L_0x0067:
            if (r10 == 0) goto L_0x0099
            if (r9 != r5) goto L_0x006e
            r10 = r9
            r9 = r8
            goto L_0x0080
        L_0x006e:
            int r10 = r1.indexOf(r2, r9)
            if (r10 != r5) goto L_0x007a
            java.lang.String r9 = r1.substring(r9)
            r10 = r5
            goto L_0x0080
        L_0x007a:
            java.lang.String r9 = r1.substring(r9, r10)
            int r10 = r10 + 1
        L_0x0080:
            int r12 = r9.length()
            if (r12 > r11) goto L_0x008f
            long r12 = java.lang.Long.parseLong(r9)
            r9 = r10
        L_0x008b:
            r4.H(r7, r12)
            goto L_0x0062
        L_0x008f:
            java.math.BigInteger r12 = new java.math.BigInteger
            r12.<init>(r9)
            r4.I(r7, r12)
            r9 = r10
            goto L_0x0062
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.a.a.n.B(java.io.ByteArrayOutputStream):void");
    }

    public final synchronized byte[] C() {
        if (this.q == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            B(byteArrayOutputStream);
            this.q = byteArrayOutputStream.toByteArray();
        }
        return this.q;
    }

    public n E() {
        a aVar = new a(C());
        ConcurrentMap<a, n> concurrentMap = c;
        n nVar = concurrentMap.get(aVar);
        if (nVar != null) {
            return nVar;
        }
        n putIfAbsent = concurrentMap.putIfAbsent(aVar, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    public boolean G(n nVar) {
        String str = this.d;
        String str2 = nVar.d;
        return str.length() > str2.length() && str.charAt(str2.length()) == '.' && str.startsWith(str2);
    }

    public final void H(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    public final void I(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    @Override // s0.a.a.m
    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // s0.a.a.r
    public boolean s(r rVar) {
        if (rVar == this) {
            return true;
        }
        if (!(rVar instanceof n)) {
            return false;
        }
        return this.d.equals(((n) rVar).d);
    }

    @Override // s0.a.a.r
    public void t(q qVar, boolean z) throws IOException {
        qVar.g(z, 6, C());
    }

    public String toString() {
        return this.d;
    }

    @Override // s0.a.a.r
    public int u() throws IOException {
        int length = C().length;
        return a2.a(length) + 1 + length;
    }

    @Override // s0.a.a.r
    public boolean y() {
        return false;
    }

    public n(n nVar, String str) {
        if (F(str, 0)) {
            this.d = i0.d.a.a.a.z0(new StringBuilder(), nVar.d, ".", str);
            return;
        }
        throw new IllegalArgumentException(i0.d.a.a.a.o0("string ", str, " not a valid OID branch"));
    }
}
