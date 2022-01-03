package s0.a.e.b.b0.c;

import i0.d.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m0.n.b.i;
import n0.a.m0;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.XMSSNode;
import retrofit2.KotlinExtensions$suspendAndThrow$1;
import s0.a.a.c3.b;
import s0.a.a.o;
import s0.a.a.s;
import s0.a.a.v0;
import s0.a.a.w2.p;
import s0.a.a.x0;
import s0.a.b.b0.a0;
import s0.a.b.b0.v;
import s0.a.b.b0.w;
import s0.a.b.b0.x;
import s0.a.b.b0.y;
import s0.a.b.n;
import s0.a.e.b.b0.c.h3;
import s0.a.e.b.c;
import s0.a.f.a.j;
import s0.a.f.b.a.g;
import s0.a.f.b.h.d;
import s0.a.f.b.h.e;
import s0.a.f.b.h.f;
import s0.a.f.b.h.h;
import s0.a.f.b.h.k;
import s0.a.f.b.h.l;
import s0.a.f.b.h.p;
import s0.a.f.b.h.q;
import s0.a.f.b.h.t;
import s0.a.f.b.h.u;
import t0.m;
/* loaded from: classes4.dex */
public class h3 {
    public static int A(int i, int i2, int i3) {
        int i4 = i2 & ((i >>> i3) ^ i);
        return i ^ (i4 ^ (i4 << i3));
    }

    public static boolean A0(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean z;
        int i4 = 7;
        while (true) {
            z = true;
            if (i4 < 0) {
                break;
            }
            int i5 = iArr[i + i4] ^ Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE ^ iArr2[i2 + i4];
            if (i5 < i6) {
                z = false;
                break;
            } else if (i5 > i6) {
                break;
            } else {
                i4--;
            }
        }
        if (z) {
            Z2(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            Z2(iArr2, i2, iArr, i, iArr3, i3);
        }
        return z;
    }

    public static int A1(int i, int[] iArr, int i2, int i3) {
        while (i3 < i) {
            int i4 = i2 + i3;
            int i5 = iArr[i4] + 1;
            iArr[i4] = i5;
            if (i5 != 0) {
                return 0;
            }
            i3++;
        }
        return 1;
    }

    public static int A2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = 0;
        int i = 0;
        while (i < 7) {
            long j9 = ((long) iArr[i]) & 4294967295L;
            int i2 = i + 0;
            long j10 = (j9 * j) + (((long) iArr3[i2]) & 4294967295L) + 0;
            iArr3[i2] = (int) j10;
            int i3 = i + 1;
            long j11 = (j9 * j2) + (((long) iArr3[i3]) & 4294967295L) + (j10 >>> 32);
            iArr3[i3] = (int) j11;
            int i4 = i + 2;
            long j12 = (j9 * j3) + (((long) iArr3[i4]) & 4294967295L) + (j11 >>> 32);
            iArr3[i4] = (int) j12;
            int i5 = i + 3;
            long j13 = (j9 * j4) + (((long) iArr3[i5]) & 4294967295L) + (j12 >>> 32);
            iArr3[i5] = (int) j13;
            int i6 = i + 4;
            long j14 = (j9 * j5) + (((long) iArr3[i6]) & 4294967295L) + (j13 >>> 32);
            iArr3[i6] = (int) j14;
            int i7 = i + 5;
            long j15 = (j9 * j6) + (((long) iArr3[i7]) & 4294967295L) + (j14 >>> 32);
            iArr3[i7] = (int) j15;
            int i8 = i + 6;
            long j16 = (j9 * j7) + (((long) iArr3[i8]) & 4294967295L) + (j15 >>> 32);
            iArr3[i8] = (int) j16;
            int i9 = i + 7;
            long j17 = (j16 >>> 32) + (((long) iArr3[i9]) & 4294967295L) + j8;
            iArr3[i9] = (int) j17;
            j8 = j17 >>> 32;
            i = i3;
            j7 = j7;
            j6 = j6;
            j3 = j3;
            j2 = j2;
        }
        return (int) j8;
    }

    public static long B(long j, long j2, int i) {
        long j3 = j2 & ((j >>> i) ^ j);
        return j ^ (j3 ^ (j3 << i));
    }

    public static void B0(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            if (i4 < Math.min(30, i)) {
                i2++;
                j |= (((long) iArr[i2]) & 4294967295L) << i4;
                i4 += 32;
            }
            i3++;
            iArr2[i3] = ((int) j) & 1073741823;
            j >>>= 30;
            i4 -= 30;
            i -= 30;
        }
    }

    public static void B1(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static int B2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = ((long) iArr2[7]) & 4294967295L;
        long j9 = 0;
        int i = 0;
        while (i < 8) {
            long j10 = ((long) iArr[i]) & 4294967295L;
            int i2 = i + 0;
            long j11 = (j10 * j) + (((long) iArr3[i2]) & 4294967295L) + 0;
            iArr3[i2] = (int) j11;
            int i3 = i + 1;
            long j12 = (j10 * j2) + (((long) iArr3[i3]) & 4294967295L) + (j11 >>> 32);
            iArr3[i3] = (int) j12;
            int i4 = i + 2;
            long j13 = (j10 * j3) + (((long) iArr3[i4]) & 4294967295L) + (j12 >>> 32);
            iArr3[i4] = (int) j13;
            int i5 = i + 3;
            long j14 = (j10 * j4) + (((long) iArr3[i5]) & 4294967295L) + (j13 >>> 32);
            iArr3[i5] = (int) j14;
            int i6 = i + 4;
            long j15 = (j10 * j5) + (((long) iArr3[i6]) & 4294967295L) + (j14 >>> 32);
            iArr3[i6] = (int) j15;
            int i7 = i + 5;
            long j16 = (j10 * j6) + (((long) iArr3[i7]) & 4294967295L) + (j15 >>> 32);
            iArr3[i7] = (int) j16;
            int i8 = i + 6;
            long j17 = (j10 * j7) + (((long) iArr3[i8]) & 4294967295L) + (j16 >>> 32);
            iArr3[i8] = (int) j17;
            int i9 = i + 7;
            long j18 = (j10 * j8) + (((long) iArr3[i9]) & 4294967295L) + (j17 >>> 32);
            iArr3[i9] = (int) j18;
            int i10 = i + 8;
            long j19 = (j18 >>> 32) + (((long) iArr3[i10]) & 4294967295L) + j9;
            iArr3[i10] = (int) j19;
            j9 = j19 >>> 32;
            i = i3;
            j8 = j8;
            j6 = j6;
            j3 = j3;
            j2 = j2;
        }
        return (int) j9;
    }

    public static void C(byte[] bArr, n nVar) {
        nVar.update(bArr, 0, bArr.length);
    }

    public static boolean C0(int i, int[] iArr, int[] iArr2) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] C1(int i) {
        byte[] bArr = new byte[4];
        B1(i, bArr, 0);
        return bArr;
    }

    public static int C2(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        long j = ((long) i2) & 4294967295L;
        long j2 = 0;
        int i5 = 0;
        do {
            int i6 = i4 + i5;
            long j3 = ((((long) iArr[i3 + i5]) & 4294967295L) * j) + (((long) iArr2[i6]) & 4294967295L) + j2;
            iArr2[i6] = (int) j3;
            j2 = j3 >>> 32;
            i5++;
        } while (i5 < i);
        return (int) j2;
    }

    public static long D(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "in == null");
        long j = 0;
        for (int i3 = i; i3 < i + i2; i3++) {
            j = (j << 8) | ((long) (bArr[i3] & 255));
        }
        return j;
    }

    public static boolean D0(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void D1(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static void D2(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[14];
        u1(jArr, jArr2, jArr4);
        H2(jArr4, jArr3);
    }

    public static int E(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) (-(i2 & 1))) & 4294967295L;
        long j2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long j3 = (((long) iArr[i3]) & 4294967295L) + (((long) iArr2[i3]) & j) + j2;
            iArr3[i3] = (int) j3;
            j2 = j3 >>> 32;
        }
        return (int) j2;
    }

    public static boolean E0(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void E1(int[] iArr, byte[] bArr, int i) {
        for (int i2 : iArr) {
            D1(i2, bArr, i);
            i += 4;
        }
    }

    public static void E2(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[14];
        u1(jArr, jArr2, jArr4);
        for (int i = 0; i < 13; i++) {
            jArr3[i] = jArr3[i] ^ jArr4[i];
        }
    }

    public static BigInteger F(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        boolean z = bigInteger2.signum() < 0;
        BigInteger multiply = bigInteger.multiply(bigInteger2.abs());
        boolean testBit = multiply.testBit(i - 1);
        BigInteger shiftRight = multiply.shiftRight(i);
        if (testBit) {
            shiftRight = shiftRight.add(c.b);
        }
        return z ? shiftRight.negate() : shiftRight;
    }

    public static boolean F0(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int F1(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = (2 - (i * i2)) * i2;
        int i4 = (2 - (i * i3)) * i3;
        return (2 - (i * i4)) * i4;
    }

    public static int F2(int i, int[] iArr) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 - iArr[i4];
            iArr[i4] = 1073741823 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 - iArr[i2];
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static void G(int[] iArr, int[] iArr2, int[] iArr3) {
        if (r2(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static boolean G0(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean G1(int i, long j) {
        if (j >= 0) {
            return j < (1 << i);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static XMSSNode G2(h hVar, XMSSNode xMSSNode, XMSSNode xMSSNode2, l lVar) {
        Objects.requireNonNull(xMSSNode, "left == null");
        Objects.requireNonNull(xMSSNode2, "right == null");
        if (xMSSNode.c == xMSSNode2.c) {
            byte[] I = I(hVar.d);
            if (lVar instanceof f) {
                f fVar = (f) lVar;
                f.b d = new f.b().c(fVar.a).d(fVar.b);
                d.e = fVar.e;
                d.f = fVar.f;
                d.g = fVar.g;
                lVar = (f) d.b(0).e();
            } else if (lVar instanceof d) {
                d dVar = (d) lVar;
                d.b d2 = new d.b().c(dVar.a).d(dVar.b);
                d2.e = dVar.e;
                d2.f = dVar.f;
                lVar = (d) d2.b(0).e();
            }
            byte[] a = hVar.b.a(I, lVar.a());
            if (lVar instanceof f) {
                f fVar2 = (f) lVar;
                f.b d3 = new f.b().c(fVar2.a).d(fVar2.b);
                d3.e = fVar2.e;
                d3.f = fVar2.f;
                d3.g = fVar2.g;
                lVar = (f) d3.b(1).e();
            } else if (lVar instanceof d) {
                d dVar2 = (d) lVar;
                d.b d4 = new d.b().c(dVar2.a).d(dVar2.b);
                d4.e = dVar2.e;
                d4.f = dVar2.f;
                lVar = (d) d4.b(1).e();
            }
            byte[] a2 = hVar.b.a(I, lVar.a());
            if (lVar instanceof f) {
                f fVar3 = (f) lVar;
                f.b d5 = new f.b().c(fVar3.a).d(fVar3.b);
                d5.e = fVar3.e;
                d5.f = fVar3.f;
                d5.g = fVar3.g;
                lVar = (f) d5.b(2).e();
            } else if (lVar instanceof d) {
                d dVar3 = (d) lVar;
                d.b d6 = new d.b().c(dVar3.a).d(dVar3.b);
                d6.e = dVar3.e;
                d6.f = dVar3.f;
                lVar = (d) d6.b(2).e();
            }
            byte[] a3 = hVar.b.a(I, lVar.a());
            int i = hVar.a.b;
            int i2 = i * 2;
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) (xMSSNode.a()[i3] ^ a2[i3]);
            }
            for (int i4 = 0; i4 < i; i4++) {
                bArr[i4 + i] = (byte) (xMSSNode2.a()[i4] ^ a3[i4]);
            }
            e eVar = hVar.b;
            Objects.requireNonNull(eVar);
            int length = a.length;
            int i5 = eVar.b;
            if (length != i5) {
                throw new IllegalArgumentException("wrong key length");
            } else if (i2 == i5 * 2) {
                return new XMSSNode(xMSSNode.c, eVar.b(1, a, bArr));
            } else {
                throw new IllegalArgumentException("wrong in length");
            }
        } else {
            throw new IllegalStateException("height of both nodes must be equal");
        }
    }

    public static void H(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    public static boolean H0(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean H1(Object[] objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static void H2(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[12];
        long j10 = j7 ^ ((j9 >>> 25) ^ (j9 << 62));
        long j11 = j8 ^ (j9 >>> 2);
        long j12 = jArr[11];
        long j13 = j5 ^ (j12 << 39);
        long j14 = (j6 ^ (j9 << 39)) ^ ((j12 >>> 25) ^ (j12 << 62));
        long j15 = j10 ^ (j12 >>> 2);
        long j16 = jArr[10];
        long j17 = j4 ^ (j16 << 39);
        long j18 = j13 ^ ((j16 >>> 25) ^ (j16 << 62));
        long j19 = j14 ^ (j16 >>> 2);
        long j20 = jArr[9];
        long j21 = j3 ^ (j20 << 39);
        long j22 = j17 ^ ((j20 >>> 25) ^ (j20 << 62));
        long j23 = j18 ^ (j20 >>> 2);
        long j24 = jArr[8];
        long j25 = j ^ (j11 << 39);
        long j26 = (j21 ^ ((j24 >>> 25) ^ (j24 << 62))) ^ (j11 >>> 2);
        long j27 = j15 >>> 25;
        jArr2[0] = j25 ^ j27;
        long j28 = j27 << 23;
        jArr2[1] = j28 ^ ((j2 ^ (j24 << 39)) ^ ((j11 >>> 25) ^ (j11 << 62)));
        jArr2[2] = j26;
        jArr2[3] = j22 ^ (j24 >>> 2);
        jArr2[4] = j23;
        jArr2[5] = j19;
        jArr2[6] = j15 & 33554431;
    }

    public static byte[] I(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static boolean I0(long[] jArr, long[] jArr2) {
        for (int i = 2; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean I1(int i, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int I2(int i, int i2) {
        if (i2 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (x0(i) >= x0(i2)) {
            i ^= i2 << (x0(i) - x0(i2));
        }
        return i;
    }

    public static byte[] J(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        if (bArr2 == null || bArr2.length != bArr.length) {
            return I(bArr);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static boolean J0(long[] jArr, long[] jArr2) {
        for (int i = 3; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean J1(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static byte[] J2(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        while (true) {
            length--;
            if (length < 0) {
                return bArr2;
            }
            i++;
            bArr2[length] = bArr[i];
        }
    }

    public static int[] K(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static boolean K0(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            z &= iArr[length] == iArr2[length];
        }
        return z;
    }

    public static boolean K1(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] K2(int[] iArr) {
        int i = 0;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        while (true) {
            length--;
            if (length < 0) {
                return iArr2;
            }
            i++;
            iArr2[length] = iArr[i];
        }
    }

    public static long[] L(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static boolean L0(short[] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z &= sArr[length] == sArr2[length];
        }
        return z;
    }

    public static boolean L1(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int L2(int i, int[] iArr, int i2) {
        while (true) {
            i--;
            if (i < 0) {
                return i2 << 31;
            }
            int i3 = iArr[i];
            iArr[i] = (i2 << 31) | (i3 >>> 1);
            i2 = i3;
        }
    }

    public static long[] M(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            return null;
        }
        if (jArr2 == null || jArr2.length != jArr.length) {
            return L(jArr);
        }
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        return jArr2;
    }

    public static boolean M0(short[][] sArr, short[][] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z &= L0(sArr[length], sArr2[length]);
        }
        return z;
    }

    public static boolean M1(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int M2(int i, int[] iArr, int i2, int[] iArr2) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            iArr2[i3] = (i2 >>> 31) | (i4 << 1);
            i3++;
            i2 = i4;
        }
        return i2 >>> 31;
    }

    public static short[] N(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static boolean N0(short[][][] sArr, short[][][] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z &= M0(sArr[length], sArr2[length]);
        }
        return z;
    }

    public static boolean N1(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int N2(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = iArr[i4];
            iArr[i4] = (i3 >>> (-i2)) | (i5 << i2);
            i4++;
            i3 = i5;
        }
        return i3 >>> (-i2);
    }

    public static int[] O(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static byte[] O0(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        } else if (i + i2 <= bArr.length) {
            byte[] bArr2 = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[i3] = bArr[i + i3];
            }
            return bArr2;
        } else {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
    }

    public static boolean O1(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int O2(int i, int[] iArr, int i2, int i3, int[] iArr2) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = iArr[i4];
            iArr2[i4] = (i3 >>> (-i2)) | (i5 << i2);
            i4++;
            i3 = i5;
        }
        return i3 >>> (-i2);
    }

    public static byte[] P(byte[] bArr) {
        Objects.requireNonNull(bArr, "in == null");
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int[] P0(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int i2 = (i + 31) >> 5;
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static boolean P1(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static long P2(int i, long[] jArr, int i2, int i3, long j) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = i2 + i4;
            long j2 = jArr[i5];
            jArr[i5] = (j >>> (-i3)) | (j2 << i3);
            i4++;
            j = j2;
        }
        return j >>> (-i3);
    }

    public static byte[][] Q(byte[][] bArr) {
        if (!l1(bArr)) {
            byte[][] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = new byte[bArr[i].length];
                System.arraycopy(bArr[i], 0, bArr2[i], 0, bArr[i].length);
            }
            return bArr2;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static int[] Q0(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[5];
        for (int i = 0; i < 5; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static boolean Q1(String str) {
        int indexOf;
        if (str.length() == 0) {
            return false;
        }
        String n02 = a.n0(str, ".");
        int i = 0;
        int i2 = 0;
        while (i < n02.length() && (indexOf = n02.indexOf(46, i)) > i) {
            if (i2 == 4) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(n02.substring(i, indexOf));
                if (parseInt >= 0 && parseInt <= 255) {
                    i = indexOf + 1;
                    i2++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return i2 == 4;
    }

    public static void Q2(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 8;
        int i2 = 0;
        int i3 = 3;
        while (true) {
            int i4 = i3 - 1;
            long j2 = ((long) iArr[i3]) & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i2 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & 4294967295L) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & 4294967295L;
                long j7 = j5 + (j6 * j);
                int i7 = (int) j7;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j8 = (((long) iArr2[2]) & 4294967295L) + (j7 >>> 32);
                long j9 = ((long) iArr[2]) & 4294967295L;
                long j10 = ((long) iArr2[3]) & 4294967295L;
                long j11 = (j9 * j) + j8;
                int i8 = (int) j11;
                iArr2[2] = (i7 >>> 31) | (i8 << 1);
                long J = a.J(j9, j6, j11 >>> 32, j10);
                long j12 = (((long) iArr2[4]) & 4294967295L) + (J >>> 32);
                long j13 = ((long) iArr[3]) & 4294967295L;
                long j14 = (((long) iArr2[5]) & 4294967295L) + (j12 >>> 32);
                long j15 = j12 & 4294967295L;
                long j16 = (((long) iArr2[6]) & 4294967295L) + (j14 >>> 32);
                long j17 = (j * j13) + (J & 4294967295L);
                int i9 = (int) j17;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                long J2 = a.J(j6, j13, j17 >>> 32, j15);
                long J3 = a.J(j13, j9, J2 >>> 32, j14 & 4294967295L);
                long j18 = j16 + (J3 >>> 32);
                int i10 = (int) J2;
                iArr2[4] = (i9 >>> 31) | (i10 << 1);
                int i11 = i10 >>> 31;
                int i12 = (int) (4294967295L & J3);
                iArr2[5] = i11 | (i12 << 1);
                int i13 = i12 >>> 31;
                int i14 = (int) j18;
                iArr2[6] = i13 | (i14 << 1);
                iArr2[7] = ((iArr2[7] + ((int) (j18 >>> 32))) << 1) | (i14 >>> 31);
                return;
            }
            i3 = i4;
            i2 = i6;
        }
    }

    public static byte[] R(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return I(bArr2);
        }
        if (bArr2 == null) {
            return I(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int[] R0(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[6];
        for (int i = 0; i < 6; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static boolean R1(String str) {
        int indexOf;
        if (str.length() == 0) {
            return false;
        }
        String n02 = a.n0(str, ":");
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < n02.length() && (indexOf = n02.indexOf(58, i)) >= i) {
            if (i2 == 8) {
                return false;
            }
            if (i != indexOf) {
                String substring = n02.substring(i, indexOf);
                if (indexOf != n02.length() - 1 || substring.indexOf(46) <= 0) {
                    try {
                        int parseInt = Integer.parseInt(n02.substring(i, indexOf), 16);
                        if (parseInt >= 0 && parseInt <= 65535) {
                        }
                    } catch (NumberFormatException unused) {
                    }
                    return false;
                } else if (!Q1(substring)) {
                    return false;
                } else {
                    i2++;
                }
            } else if (indexOf != 1 && indexOf != n02.length() - 1 && z) {
                return false;
            } else {
                z = true;
            }
            i = indexOf + 1;
            i2++;
        }
        return i2 == 8 || z;
    }

    public static void R2(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 10;
        int i2 = 0;
        int i3 = 4;
        while (true) {
            int i4 = i3 - 1;
            long j2 = ((long) iArr[i3]) & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i2 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & 4294967295L) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & 4294967295L;
                long j7 = j5 + (j6 * j);
                int i7 = (int) j7;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j8 = (((long) iArr2[2]) & 4294967295L) + (j7 >>> 32);
                long j9 = ((long) iArr[2]) & 4294967295L;
                long j10 = ((long) iArr2[3]) & 4294967295L;
                long j11 = (j9 * j) + j8;
                int i8 = (int) j11;
                iArr2[2] = (i7 >>> 31) | (i8 << 1);
                long J = a.J(j9, j6, j11 >>> 32, j10);
                long j12 = (((long) iArr2[4]) & 4294967295L) + (J >>> 32);
                long j13 = ((long) iArr[3]) & 4294967295L;
                long j14 = (((long) iArr2[5]) & 4294967295L) + (j12 >>> 32);
                long j15 = j12 & 4294967295L;
                long j16 = (((long) iArr2[6]) & 4294967295L) + (j14 >>> 32);
                long j17 = j14 & 4294967295L;
                long j18 = (j13 * j) + (J & 4294967295L);
                int i9 = (int) j18;
                iArr2[3] = (i8 >>> 31) | (i9 << 1);
                long J2 = a.J(j13, j6, j18 >>> 32, j15);
                long J3 = a.J(j13, j9, J2 >>> 32, j17);
                long j19 = j16 + (J3 >>> 32);
                long j20 = J3 & 4294967295L;
                long j21 = ((long) iArr[4]) & 4294967295L;
                long j22 = (((long) iArr2[7]) & 4294967295L) + (j19 >>> 32);
                long j23 = (((long) iArr2[8]) & 4294967295L) + (j22 >>> 32);
                long j24 = (j * j21) + (J2 & 4294967295L);
                int i10 = (int) j24;
                iArr2[4] = (i9 >>> 31) | (i10 << 1);
                long J4 = a.J(j21, j6, j24 >>> 32, j20);
                long J5 = a.J(j21, j9, J4 >>> 32, j19 & 4294967295L);
                long J6 = a.J(j21, j13, J5 >>> 32, j22 & 4294967295L);
                long j25 = j23 + (J6 >>> 32);
                int i11 = (int) J4;
                iArr2[5] = (i11 << 1) | (i10 >>> 31);
                int i12 = (int) J5;
                iArr2[6] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                int i14 = (int) J6;
                iArr2[7] = i13 | (i14 << 1);
                int i15 = i14 >>> 31;
                int i16 = (int) j25;
                iArr2[8] = i15 | (i16 << 1);
                iArr2[9] = (i16 >>> 31) | ((iArr2[9] + ((int) (j25 >>> 32))) << 1);
                return;
            }
            i3 = i4;
            i2 = i6;
        }
    }

    public static byte[] S(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return R(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return R(bArr, bArr3);
        }
        if (bArr3 == null) {
            return R(bArr, bArr2);
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length + 0;
        System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        return bArr4;
    }

    public static int[] S0(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[7];
        for (int i = 0; i < 7; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static boolean S1(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void S2(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 12;
        int i2 = 5;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & 4294967295L) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & 4294967295L;
                long j7 = (j6 * j) + j5;
                int i7 = (int) j7;
                iArr2[1] = (((int) (j4 >>> 32)) & 1) | (i7 << 1);
                long j8 = (((long) iArr2[2]) & 4294967295L) + (j7 >>> 32);
                long j9 = ((long) iArr[2]) & 4294967295L;
                long j10 = ((long) iArr2[3]) & 4294967295L;
                long j11 = ((long) iArr2[4]) & 4294967295L;
                long j12 = (j9 * j) + j8;
                int i8 = (int) j12;
                iArr2[2] = (i7 >>> 31) | (i8 << 1);
                long J = a.J(j9, j6, j12 >>> 32, j10);
                long j13 = j11 + (J >>> 32);
                long j14 = ((long) iArr[3]) & 4294967295L;
                long j15 = (((long) iArr2[5]) & 4294967295L) + (j13 >>> 32);
                long j16 = (((long) iArr2[6]) & 4294967295L) + (j15 >>> 32);
                long j17 = (j14 * j) + (J & 4294967295L);
                int i9 = (int) j17;
                iArr2[3] = (i8 >>> 31) | (i9 << 1);
                int i10 = i9 >>> 31;
                long J2 = a.J(j14, j6, j17 >>> 32, j13 & 4294967295L);
                long J3 = a.J(j14, j9, J2 >>> 32, j15 & 4294967295L);
                long j18 = j16 + (J3 >>> 32);
                long j19 = J3 & 4294967295L;
                long j20 = ((long) iArr[4]) & 4294967295L;
                long j21 = (((long) iArr2[7]) & 4294967295L) + (j18 >>> 32);
                long j22 = j18 & 4294967295L;
                long j23 = (((long) iArr2[8]) & 4294967295L) + (j21 >>> 32);
                long j24 = j21 & 4294967295L;
                long j25 = (j20 * j) + (J2 & 4294967295L);
                int i11 = (int) j25;
                iArr2[4] = (i11 << 1) | i10;
                long J4 = a.J(j20, j6, j25 >>> 32, j19);
                long J5 = a.J(j20, j9, J4 >>> 32, j22);
                long J6 = a.J(j20, j14, J5 >>> 32, j24);
                long j26 = J5 & 4294967295L;
                long j27 = j23 + (J6 >>> 32);
                long j28 = ((long) iArr[5]) & 4294967295L;
                long j29 = (((long) iArr2[9]) & 4294967295L) + (j27 >>> 32);
                long j30 = j27 & 4294967295L;
                long j31 = (((long) iArr2[10]) & 4294967295L) + (j29 >>> 32);
                long j32 = j29 & 4294967295L;
                long j33 = (j * j28) + (J4 & 4294967295L);
                int i12 = (int) j33;
                iArr2[5] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                long J7 = a.J(j6, j28, j33 >>> 32, j26);
                long J8 = a.J(j28, j9, J7 >>> 32, J6 & 4294967295L);
                long J9 = a.J(j28, j14, J8 >>> 32, j30);
                long J10 = a.J(j28, j20, J9 >>> 32, j32);
                long j34 = j31 + (J10 >>> 32);
                int i14 = (int) J7;
                iArr2[6] = i13 | (i14 << 1);
                int i15 = (int) J8;
                iArr2[7] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) J9;
                iArr2[8] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) J10;
                iArr2[9] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j34;
                iArr2[10] = i20 | (i21 << 1);
                iArr2[11] = ((iArr2[11] + ((int) (j34 >>> 32))) << 1) | (i21 >>> 31);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static byte[] T(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr == null) {
            return S(bArr2, bArr3, bArr4);
        }
        if (bArr2 == null) {
            return S(bArr, bArr3, bArr4);
        }
        if (bArr3 == null) {
            return S(bArr, bArr2, bArr4);
        }
        if (bArr4 == null) {
            return S(bArr, bArr2, bArr3);
        }
        byte[] bArr5 = new byte[bArr.length + bArr2.length + bArr3.length + bArr4.length];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        int length = bArr.length + 0;
        System.arraycopy(bArr2, 0, bArr5, length, bArr2.length);
        int length2 = length + bArr2.length;
        System.arraycopy(bArr3, 0, bArr5, length2, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, length2 + bArr3.length, bArr4.length);
        return bArr5;
    }

    public static int[] T0(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static boolean T1(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void T2(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 14;
        int i2 = 6;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & 4294967295L) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & 4294967295L;
                long j7 = (j6 * j) + j5;
                int i7 = (int) j7;
                iArr2[1] = (((int) (j4 >>> 32)) & 1) | (i7 << 1);
                long j8 = (((long) iArr2[2]) & 4294967295L) + (j7 >>> 32);
                long j9 = ((long) iArr[2]) & 4294967295L;
                long j10 = ((long) iArr2[3]) & 4294967295L;
                long j11 = ((long) iArr2[4]) & 4294967295L;
                long j12 = (j9 * j) + j8;
                int i8 = (int) j12;
                iArr2[2] = (i7 >>> 31) | (i8 << 1);
                long J = a.J(j9, j6, j12 >>> 32, j10);
                long j13 = j11 + (J >>> 32);
                long j14 = ((long) iArr[3]) & 4294967295L;
                long j15 = (((long) iArr2[5]) & 4294967295L) + (j13 >>> 32);
                long j16 = (((long) iArr2[6]) & 4294967295L) + (j15 >>> 32);
                long j17 = (j14 * j) + (J & 4294967295L);
                int i9 = (int) j17;
                iArr2[3] = (i8 >>> 31) | (i9 << 1);
                int i10 = i9 >>> 31;
                long J2 = a.J(j14, j6, j17 >>> 32, j13 & 4294967295L);
                long J3 = a.J(j14, j9, J2 >>> 32, j15 & 4294967295L);
                long j18 = j16 + (J3 >>> 32);
                long j19 = J3 & 4294967295L;
                long j20 = ((long) iArr[4]) & 4294967295L;
                long j21 = (((long) iArr2[7]) & 4294967295L) + (j18 >>> 32);
                long j22 = j18 & 4294967295L;
                long j23 = (((long) iArr2[8]) & 4294967295L) + (j21 >>> 32);
                long j24 = j21 & 4294967295L;
                long j25 = (j20 * j) + (J2 & 4294967295L);
                int i11 = (int) j25;
                iArr2[4] = (i11 << 1) | i10;
                long J4 = a.J(j20, j6, j25 >>> 32, j19);
                long J5 = a.J(j20, j9, J4 >>> 32, j22);
                long J6 = a.J(j20, j14, J5 >>> 32, j24);
                long j26 = J5 & 4294967295L;
                long j27 = j23 + (J6 >>> 32);
                long j28 = ((long) iArr[5]) & 4294967295L;
                long j29 = (((long) iArr2[9]) & 4294967295L) + (j27 >>> 32);
                long j30 = j27 & 4294967295L;
                long j31 = (((long) iArr2[10]) & 4294967295L) + (j29 >>> 32);
                long j32 = j29 & 4294967295L;
                long j33 = (j28 * j) + (J4 & 4294967295L);
                int i12 = (int) j33;
                iArr2[5] = (i11 >>> 31) | (i12 << 1);
                long J7 = a.J(j28, j6, j33 >>> 32, j26);
                long J8 = a.J(j28, j9, J7 >>> 32, J6 & 4294967295L);
                long J9 = a.J(j28, j14, J8 >>> 32, j30);
                long j34 = J8 & 4294967295L;
                long J10 = a.J(j28, j20, J9 >>> 32, j32);
                long j35 = j31 + (J10 >>> 32);
                long j36 = J10 & 4294967295L;
                long j37 = ((long) iArr[6]) & 4294967295L;
                long j38 = (((long) iArr2[11]) & 4294967295L) + (j35 >>> 32);
                long j39 = (((long) iArr2[12]) & 4294967295L) + (j38 >>> 32);
                long j40 = j38 & 4294967295L;
                long j41 = (j * j37) + (J7 & 4294967295L);
                int i13 = (int) j41;
                iArr2[6] = (i12 >>> 31) | (i13 << 1);
                int i14 = i13 >>> 31;
                long J11 = a.J(j6, j37, j41 >>> 32, j34);
                long J12 = a.J(j37, j9, J11 >>> 32, J9 & 4294967295L);
                long J13 = a.J(j37, j14, J12 >>> 32, j36);
                long J14 = a.J(j37, j20, J13 >>> 32, j35 & 4294967295L);
                long J15 = a.J(j37, j28, J14 >>> 32, j40);
                long j42 = j39 + (J15 >>> 32);
                int i15 = (int) J11;
                iArr2[7] = i14 | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) J12;
                iArr2[8] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) J13;
                iArr2[9] = i18 | (i19 << 1);
                int i20 = (int) J14;
                iArr2[10] = (i20 << 1) | (i19 >>> 31);
                int i21 = (int) J15;
                iArr2[11] = (i20 >>> 31) | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j42;
                iArr2[12] = i22 | (i23 << 1);
                iArr2[13] = (i23 >>> 31) | ((iArr2[13] + ((int) (j42 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static boolean U(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (bArr == bArr2) {
            return true;
        }
        int length = bArr.length < bArr2.length ? bArr.length : bArr2.length;
        int length2 = bArr.length ^ bArr2.length;
        for (int i = 0; i != length; i++) {
            length2 |= bArr[i] ^ bArr2[i];
        }
        while (length < bArr2.length) {
            length2 |= bArr2[length] ^ (~bArr2[length]);
            length++;
        }
        return length2 == 0;
    }

    public static long[] U0(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int i2 = (i + 63) >> 6;
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArr;
    }

    public static boolean U1(int[] iArr) {
        for (int i = 0; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void U2(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 16;
        int i2 = 7;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & 4294967295L) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & 4294967295L;
                long j7 = (j6 * j) + j5;
                int i7 = (int) j7;
                iArr2[1] = (((int) (j4 >>> 32)) & 1) | (i7 << 1);
                long j8 = (((long) iArr2[2]) & 4294967295L) + (j7 >>> 32);
                long j9 = ((long) iArr[2]) & 4294967295L;
                long j10 = ((long) iArr2[3]) & 4294967295L;
                long j11 = ((long) iArr2[4]) & 4294967295L;
                long j12 = (j9 * j) + j8;
                int i8 = (int) j12;
                iArr2[2] = (i7 >>> 31) | (i8 << 1);
                int i9 = i8 >>> 31;
                long J = a.J(j9, j6, j12 >>> 32, j10);
                long j13 = j11 + (J >>> 32);
                long j14 = ((long) iArr[3]) & 4294967295L;
                long j15 = (((long) iArr2[5]) & 4294967295L) + (j13 >>> 32);
                long j16 = (((long) iArr2[6]) & 4294967295L) + (j15 >>> 32);
                long j17 = (j14 * j) + (J & 4294967295L);
                int i10 = (int) j17;
                iArr2[3] = i9 | (i10 << 1);
                int i11 = i10 >>> 31;
                long J2 = a.J(j14, j6, j17 >>> 32, j13 & 4294967295L);
                long J3 = a.J(j14, j9, J2 >>> 32, j15 & 4294967295L);
                long j18 = j16 + (J3 >>> 32);
                long j19 = J3 & 4294967295L;
                long j20 = ((long) iArr[4]) & 4294967295L;
                long j21 = (((long) iArr2[7]) & 4294967295L) + (j18 >>> 32);
                long j22 = j18 & 4294967295L;
                long j23 = (((long) iArr2[8]) & 4294967295L) + (j21 >>> 32);
                long j24 = j21 & 4294967295L;
                long j25 = (j20 * j) + (J2 & 4294967295L);
                int i12 = (int) j25;
                iArr2[4] = (i12 << 1) | i11;
                long J4 = a.J(j20, j6, j25 >>> 32, j19);
                long J5 = a.J(j20, j9, J4 >>> 32, j22);
                long J6 = a.J(j20, j14, J5 >>> 32, j24);
                long j26 = J5 & 4294967295L;
                long j27 = j23 + (J6 >>> 32);
                long j28 = ((long) iArr[5]) & 4294967295L;
                long j29 = (((long) iArr2[9]) & 4294967295L) + (j27 >>> 32);
                long j30 = j27 & 4294967295L;
                long j31 = (((long) iArr2[10]) & 4294967295L) + (j29 >>> 32);
                long j32 = j29 & 4294967295L;
                long j33 = (j28 * j) + (J4 & 4294967295L);
                int i13 = (int) j33;
                iArr2[5] = (i12 >>> 31) | (i13 << 1);
                long J7 = a.J(j28, j6, j33 >>> 32, j26);
                long J8 = a.J(j28, j9, J7 >>> 32, J6 & 4294967295L);
                long J9 = a.J(j28, j14, J8 >>> 32, j30);
                long j34 = J8 & 4294967295L;
                long J10 = a.J(j28, j20, J9 >>> 32, j32);
                long j35 = j31 + (J10 >>> 32);
                long j36 = J10 & 4294967295L;
                long j37 = ((long) iArr[6]) & 4294967295L;
                long j38 = (((long) iArr2[11]) & 4294967295L) + (j35 >>> 32);
                long j39 = (((long) iArr2[12]) & 4294967295L) + (j38 >>> 32);
                long j40 = j38 & 4294967295L;
                long j41 = (j37 * j) + (J7 & 4294967295L);
                int i14 = (int) j41;
                iArr2[6] = (i13 >>> 31) | (i14 << 1);
                int i15 = i14 >>> 31;
                long J11 = a.J(j37, j6, j41 >>> 32, j34);
                long J12 = a.J(j37, j9, J11 >>> 32, J9 & 4294967295L);
                long J13 = a.J(j37, j14, J12 >>> 32, j36);
                long j42 = J12 & 4294967295L;
                long J14 = a.J(j37, j20, J13 >>> 32, j35 & 4294967295L);
                long J15 = a.J(j37, j28, J14 >>> 32, j40);
                long j43 = J14 & 4294967295L;
                long j44 = j39 + (J15 >>> 32);
                long j45 = J15 & 4294967295L;
                long j46 = ((long) iArr[7]) & 4294967295L;
                long j47 = (((long) iArr2[13]) & 4294967295L) + (j44 >>> 32);
                long j48 = (((long) iArr2[14]) & 4294967295L) + (j47 >>> 32);
                long j49 = j47 & 4294967295L;
                long j50 = (j * j46) + (J11 & 4294967295L);
                int i16 = (int) j50;
                iArr2[7] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                long J16 = a.J(j6, j46, j50 >>> 32, j42);
                long J17 = a.J(j46, j9, J16 >>> 32, J13 & 4294967295L);
                long J18 = a.J(j46, j14, J17 >>> 32, j43);
                long J19 = a.J(j46, j20, J18 >>> 32, j45);
                long J20 = a.J(j46, j28, J19 >>> 32, j44 & 4294967295L);
                long J21 = a.J(j46, j37, J20 >>> 32, j49);
                long j51 = j48 + (J21 >>> 32);
                int i18 = (int) J16;
                iArr2[8] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) J17;
                iArr2[9] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) J18;
                iArr2[10] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) J19;
                iArr2[11] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) J20;
                iArr2[12] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) J21;
                iArr2[13] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = (int) j51;
                iArr2[14] = i29 | (i30 << 1);
                iArr2[15] = (i30 >>> 31) | ((iArr2[15] + ((int) (j51 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static byte[] V(short[] sArr) {
        byte[] bArr = new byte[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            bArr[i] = (byte) sArr[i];
        }
        return bArr;
    }

    public static int V0(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 5) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean V1(int[] iArr) {
        for (int i = 0; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void V2(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[13];
        w1(jArr, jArr3);
        while (true) {
            H2(jArr3, jArr2);
            i--;
            if (i > 0) {
                w1(jArr2, jArr3);
            } else {
                return;
            }
        }
    }

    public static short[] W(byte[] bArr) {
        short[] sArr = new short[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            sArr[i] = (short) (bArr[i] & 255);
        }
        return sArr;
    }

    public static int W0(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 6) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean W1(int[] iArr) {
        for (int i = 0; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int W2(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = ((((long) iArr[i2]) & 4294967295L) - (4294967295L & ((long) iArr2[i2]))) + j;
            iArr3[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static byte[][] X(short[][] sArr) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, sArr.length, sArr[0].length);
        for (int i = 0; i < sArr.length; i++) {
            for (int i2 = 0; i2 < sArr[0].length; i2++) {
                bArr[i][i2] = (byte) sArr[i][i2];
            }
        }
        return bArr;
    }

    public static int X0(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 7) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean X1(int[] iArr) {
        for (int i = 0; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int X2(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & 4294967295L) - (((long) iArr2[i2 + 0]) & 4294967295L)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = ((((long) iArr[i + 1]) & 4294967295L) - (((long) iArr2[i2 + 1]) & 4294967295L)) + (j >> 32);
        iArr3[i3 + 1] = (int) j2;
        long j3 = ((((long) iArr[i + 2]) & 4294967295L) - (((long) iArr2[i2 + 2]) & 4294967295L)) + (j2 >> 32);
        iArr3[i3 + 2] = (int) j3;
        long j4 = ((((long) iArr[i + 3]) & 4294967295L) - (((long) iArr2[i2 + 3]) & 4294967295L)) + (j3 >> 32);
        iArr3[i3 + 3] = (int) j4;
        long j5 = ((((long) iArr[i + 4]) & 4294967295L) - (((long) iArr2[i2 + 4]) & 4294967295L)) + (j4 >> 32);
        iArr3[i3 + 4] = (int) j5;
        long j6 = ((((long) iArr[i + 5]) & 4294967295L) - (((long) iArr2[i2 + 5]) & 4294967295L)) + (j5 >> 32);
        iArr3[i3 + 5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static short[][] Y(byte[][] bArr) {
        short[][] sArr = (short[][]) Array.newInstance(short.class, bArr.length, bArr[0].length);
        for (int i = 0; i < bArr.length; i++) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                sArr[i][i2] = (short) (bArr[i][i2] & 255);
            }
        }
        return sArr;
    }

    public static int Y0(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else if ((i & 255) != i) {
            return 0;
        } else {
            i2 = iArr[i >>> 5] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean Y1(long[] jArr) {
        for (int i = 0; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int Y2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static byte[][][] Z(short[][][] sArr) {
        byte[][][] bArr = (byte[][][]) Array.newInstance(byte.class, sArr.length, sArr[0].length, sArr[0][0].length);
        for (int i = 0; i < sArr.length; i++) {
            for (int i2 = 0; i2 < sArr[0].length; i2++) {
                for (int i3 = 0; i3 < sArr[0][0].length; i3++) {
                    bArr[i][i2][i3] = (byte) sArr[i][i2][i3];
                }
            }
        }
        return bArr;
    }

    public static int Z0(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= iArr.length) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean Z1(long[] jArr) {
        for (int i = 0; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int Z2(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & 4294967295L) - (((long) iArr2[i2 + 0]) & 4294967295L)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = ((((long) iArr[i + 1]) & 4294967295L) - (((long) iArr2[i2 + 1]) & 4294967295L)) + (j >> 32);
        iArr3[i3 + 1] = (int) j2;
        long j3 = ((((long) iArr[i + 2]) & 4294967295L) - (((long) iArr2[i2 + 2]) & 4294967295L)) + (j2 >> 32);
        iArr3[i3 + 2] = (int) j3;
        long j4 = ((((long) iArr[i + 3]) & 4294967295L) - (((long) iArr2[i2 + 3]) & 4294967295L)) + (j3 >> 32);
        iArr3[i3 + 3] = (int) j4;
        long j5 = ((((long) iArr[i + 4]) & 4294967295L) - (((long) iArr2[i2 + 4]) & 4294967295L)) + (j4 >> 32);
        iArr3[i3 + 4] = (int) j5;
        long j6 = ((((long) iArr[i + 5]) & 4294967295L) - (((long) iArr2[i2 + 5]) & 4294967295L)) + (j5 >> 32);
        iArr3[i3 + 5] = (int) j6;
        long j7 = ((((long) iArr[i + 6]) & 4294967295L) - (((long) iArr2[i2 + 6]) & 4294967295L)) + (j6 >> 32);
        iArr3[i3 + 6] = (int) j7;
        long j8 = ((((long) iArr[i + 7]) & 4294967295L) - (((long) iArr2[i2 + 7]) & 4294967295L)) + (j7 >> 32);
        iArr3[i3 + 7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static void a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 8);
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static short[][][] a0(byte[][][] bArr) {
        short[][][] sArr = (short[][][]) Array.newInstance(short.class, bArr.length, bArr[0].length, bArr[0][0].length);
        for (int i = 0; i < bArr.length; i++) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                for (int i3 = 0; i3 < bArr[0][0].length; i3++) {
                    sArr[i][i2][i3] = (short) (bArr[i][i2][i3] & 255);
                }
            }
        }
        return sArr;
    }

    public static b a1(String str) {
        if (str.equals("SHA-1")) {
            return new b(s0.a.a.v2.b.f, v0.c);
        }
        if (str.equals("SHA-224")) {
            return new b(s0.a.a.r2.b.f, v0.c);
        }
        if (str.equals("SHA-256")) {
            return new b(s0.a.a.r2.b.c, v0.c);
        }
        if (str.equals("SHA-384")) {
            return new b(s0.a.a.r2.b.d, v0.c);
        }
        if (str.equals("SHA-512")) {
            return new b(s0.a.a.r2.b.e, v0.c);
        }
        throw new IllegalArgumentException(a.n0("unrecognised digest algorithm: ", str));
    }

    public static boolean a2(long[] jArr) {
        for (int i = 0; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int a3(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int b(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        return ((bArr[i3 + 1] & 255) << 24) | i4 | ((bArr[i3] & 255) << 16);
    }

    public static void b0(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
    }

    public static n b1(b bVar) {
        if (bVar.c.w(s0.a.a.v2.b.f)) {
            return new v();
        }
        if (bVar.c.w(s0.a.a.r2.b.f)) {
            return new w();
        }
        if (bVar.c.w(s0.a.a.r2.b.c)) {
            return new x();
        }
        if (bVar.c.w(s0.a.a.r2.b.d)) {
            return new y();
        }
        if (bVar.c.w(s0.a.a.r2.b.e)) {
            return new a0();
        }
        StringBuilder P0 = a.P0("unrecognised OID in digest algorithm identifier: ");
        P0.append(bVar.c);
        throw new IllegalArgumentException(P0.toString());
    }

    public static boolean b2(long[] jArr) {
        for (int i = 0; i < 5; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int b3(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        long j6 = ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L)) + (j5 >> 32);
        iArr3[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static int c(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = (((long) iArr[i2]) & 4294967295L) + (4294967295L & ((long) iArr2[i2])) + j;
            iArr3[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static void c0(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static s0.a.a.n c1(String str) {
        if (str.equals("SHA-256")) {
            return s0.a.a.r2.b.c;
        }
        if (str.equals("SHA-512")) {
            return s0.a.a.r2.b.e;
        }
        if (str.equals("SHAKE128")) {
            return s0.a.a.r2.b.m;
        }
        if (str.equals("SHAKE256")) {
            return s0.a.a.r2.b.n;
        }
        throw new IllegalArgumentException(a.n0("unrecognized digest: ", str));
    }

    public static boolean c2(long[] jArr) {
        for (int i = 0; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int c3(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        long j6 = ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L)) + (j5 >> 32);
        iArr3[5] = (int) j6;
        long j7 = ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L)) + (j6 >> 32);
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int d(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static void d0(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
    }

    public static int d1(int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0) {
            return i3;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(" > ");
        stringBuffer.append(i2);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static boolean d2(long[] jArr) {
        for (int i = 0; i < 9; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int d3(int i, int i2, int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - (((long) i2) & 4294967295L);
        iArr[0] = (int) j;
        long j2 = ((4294967295L & ((long) iArr[1])) - 1) + (j >> 32);
        iArr[1] = (int) j2;
        if ((j2 >> 32) == 0) {
            return 0;
        }
        return v0(i, iArr, 2);
    }

    public static int e(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static void e0(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
        iArr2[i2 + 5] = iArr[i + 5];
    }

    public static String e1(int i) {
        if (i == 5) {
            return "qTESLA-p-I";
        }
        if (i == 6) {
            return "qTESLA-p-III";
        }
        throw new IllegalArgumentException(a.e0("unknown security category: ", i));
    }

    public static XMSSNode e2(h hVar, k kVar, f fVar) {
        double d;
        int i = hVar.a.d;
        byte[][] Q = Q(kVar.a);
        XMSSNode[] xMSSNodeArr = new XMSSNode[Q.length];
        for (int i2 = 0; i2 < Q.length; i2++) {
            xMSSNodeArr[i2] = new XMSSNode(0, Q[i2]);
        }
        f.b d2 = new f.b().c(fVar.a).d(fVar.b);
        d2.e = fVar.e;
        d2.f = 0;
        d2.g = fVar.g;
        f.b b = d2.b(fVar.d);
        while (true) {
            f fVar2 = (f) b.e();
            if (i <= 1) {
                return xMSSNodeArr[0];
            }
            int i3 = 0;
            while (true) {
                d = (double) (i / 2);
                if (i3 >= ((int) Math.floor(d))) {
                    break;
                }
                f.b d3 = new f.b().c(fVar2.a).d(fVar2.b);
                d3.e = fVar2.e;
                d3.f = fVar2.f;
                d3.g = i3;
                fVar2 = (f) d3.b(fVar2.d).e();
                int i4 = i3 * 2;
                xMSSNodeArr[i3] = G2(hVar, xMSSNodeArr[i4], xMSSNodeArr[i4 + 1], fVar2);
                i3++;
            }
            if (i % 2 == 1) {
                xMSSNodeArr[(int) Math.floor(d)] = xMSSNodeArr[i - 1];
            }
            i = (int) Math.ceil(((double) i) / 2.0d);
            f.b d4 = new f.b().c(fVar2.a).d(fVar2.b);
            d4.e = fVar2.e;
            d4.f = fVar2.f + 1;
            d4.g = fVar2.g;
            b = d4.b(fVar2.d);
        }
    }

    public static int e3(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        long j6 = ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L)) + (j5 >> 32);
        iArr3[5] = (int) j6;
        long j7 = ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L)) + (j6 >> 32);
        iArr3[6] = (int) j7;
        long j8 = ((((long) iArr[7]) & 4294967295L) - (((long) iArr2[7]) & 4294967295L)) + (j7 >> 32);
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int f(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        long j7 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (j6 >>> 32);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static void f0(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
        iArr2[i2 + 5] = iArr[i + 5];
        iArr2[i2 + 6] = iArr[i + 6];
    }

    public static boolean f1(int i, int[] iArr, int[] iArr2) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = iArr[i2] ^ Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE ^ iArr2[i2];
            if (i3 < i4) {
                return false;
            }
            if (i3 > i4) {
                return true;
            }
        }
        return true;
    }

    public static int f2(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (((((long) iArr[i2]) & 4294967295L) - (4294967295L & ((long) iArr2[i2]))) + j) >> 32;
        }
        return (int) j;
    }

    public static int f3(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            long j2 = ((((long) iArr2[i5]) & 4294967295L) - (4294967295L & ((long) iArr[i2 + i4]))) + j;
            iArr2[i5] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int g(int i, int[] iArr, int[] iArr2) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4] + iArr2[i4] + i3;
            iArr[i4] = 1073741823 & i5;
            i3 = i5 >> 30;
        }
        int i6 = iArr[i2] + iArr2[i2] + i3;
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static void g0(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
        iArr2[i2 + 5] = iArr[i + 5];
        iArr2[i2 + 6] = iArr[i + 6];
        iArr2[i2 + 7] = iArr[i + 7];
    }

    public static boolean g1(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static int g2(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << 24) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    public static int g3(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = ((((long) iArr2[i2]) & 4294967295L) - (4294967295L & ((long) iArr[i2]))) + j;
            iArr2[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int h(int i, int i2, int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) i2) & 4294967295L);
        iArr[0] = (int) j;
        long j2 = (4294967295L & ((long) iArr[1])) + 1 + (j >>> 32);
        iArr[1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return z1(i, iArr, 2);
    }

    public static void h0(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
    }

    public static boolean h1(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static void h2(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = g2(bArr, i);
            i += 4;
        }
    }

    public static int h3(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j >> 32);
        iArr2[1] = (int) j2;
        long j3 = ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j2 >> 32);
        iArr2[2] = (int) j3;
        long j4 = ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j3 >> 32);
        iArr2[3] = (int) j4;
        long j5 = ((((long) iArr2[4]) & 4294967295L) - (4294967295L & ((long) iArr[4]))) + (j4 >> 32);
        iArr2[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int i(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        long j7 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (j6 >>> 32);
        iArr3[6] = (int) j7;
        long j8 = (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L) + (j7 >>> 32);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static void i0(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
    }

    public static boolean i1(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static long i2(byte[] bArr, int i) {
        return ((((long) g2(bArr, i + 4)) & 4294967295L) << 32) | (((long) g2(bArr, i)) & 4294967295L);
    }

    public static int i3(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j >> 32);
        iArr2[1] = (int) j2;
        long j3 = ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j2 >> 32);
        iArr2[2] = (int) j3;
        long j4 = ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j3 >> 32);
        iArr2[3] = (int) j4;
        long j5 = ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) + (j4 >> 32);
        iArr2[4] = (int) j5;
        long j6 = ((((long) iArr2[5]) & 4294967295L) - (4294967295L & ((long) iArr[5]))) + (j5 >> 32);
        iArr2[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static int j(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = (((long) iArr[i2]) & 4294967295L) + (((long) iArr2[i2]) & 4294967295L) + (4294967295L & ((long) iArr3[i2])) + j;
            iArr3[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static void j0(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
        jArr2[i2 + 3] = jArr[i + 3];
    }

    public static boolean j1(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static void j2(byte[] bArr, int i, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = i2(bArr, i);
            i += 8;
        }
    }

    public static int j3(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j >> 32);
        iArr2[1] = (int) j2;
        long j3 = ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j2 >> 32);
        iArr2[2] = (int) j3;
        long j4 = ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j3 >> 32);
        iArr2[3] = (int) j4;
        long j5 = ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) + (j4 >> 32);
        iArr2[4] = (int) j5;
        long j6 = ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) + (j5 >> 32);
        iArr2[5] = (int) j6;
        long j7 = ((((long) iArr2[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) + (j6 >> 32);
        iArr2[6] = (int) j7;
        long j8 = ((((long) iArr2[7]) & 4294967295L) - (4294967295L & ((long) iArr[7]))) + (j7 >> 32);
        iArr2[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int k(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static void k0(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static boolean k1(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static int k2(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static final Object k3(Exception exc, m0.l.c<?> cVar) {
        KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        int i;
        if (cVar instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) cVar;
            int i2 = kotlinExtensions$suspendAndThrow$1.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.d = i2 - Integer.MIN_VALUE;
                Object obj = kotlinExtensions$suspendAndThrow$1.c;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                i = kotlinExtensions$suspendAndThrow$1.d;
                if (i != 0) {
                    i0.j.f.p.h.d4(obj);
                    kotlinExtensions$suspendAndThrow$1.q = exc;
                    kotlinExtensions$suspendAndThrow$1.d = 1;
                    m0.a.I(kotlinExtensions$suspendAndThrow$1.getContext(), new m(kotlinExtensions$suspendAndThrow$1, exc));
                    if (coroutineSingletons == coroutineSingletons) {
                        i.e(kotlinExtensions$suspendAndThrow$1, "frame");
                    }
                    if (coroutineSingletons == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else if (i == 1) {
                    Exception exc2 = (Exception) kotlinExtensions$suspendAndThrow$1.q;
                    i0.j.f.p.h.d4(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return m0.i.a;
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new ContinuationImpl(cVar) { // from class: retrofit2.KotlinExtensions$suspendAndThrow$1
            public /* synthetic */ Object c;
            public int d;
            public Object q;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj2) {
                this.c = obj2;
                this.d |= Integer.MIN_VALUE;
                return h3.k3(null, this);
            }
        };
        Object obj2 = kotlinExtensions$suspendAndThrow$1.c;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        i = kotlinExtensions$suspendAndThrow$1.d;
        if (i != 0) {
        }
        return m0.i.a;
    }

    public static int l(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static void l0(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
        jArr2[i2 + 3] = jArr[i + 3];
        jArr2[i2 + 4] = jArr[i + 4];
    }

    public static boolean l1(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static void l2(long j, byte[] bArr, int i) {
        B1((int) (j >>> 32), bArr, i);
        B1((int) (j & 4294967295L), bArr, i + 4);
    }

    public static BigInteger l3(int i, int[] iArr) {
        byte[] bArr = new byte[i << 2];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                B1(i3, bArr, ((i - 1) - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int m(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static void m0(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
        jArr2[i2 + 3] = jArr[i + 3];
        jArr2[i2 + 4] = jArr[i + 4];
        jArr2[i2 + 5] = jArr[i + 5];
        jArr2[i2 + 6] = jArr[i + 6];
    }

    public static int m1(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ bArr[length];
        }
    }

    public static void m2(long j, byte[] bArr, int i) {
        D1((int) (4294967295L & j), bArr, i);
        D1((int) (j >>> 32), bArr, i + 4);
    }

    public static BigInteger m3(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                B1(i2, bArr, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int n(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        long j7 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L) + (j6 >>> 32);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static void n0(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
        jArr2[i2 + 3] = jArr[i + 3];
        jArr2[i2 + 4] = jArr[i + 4];
        jArr2[i2 + 5] = jArr[i + 5];
        jArr2[i2 + 6] = jArr[i + 6];
        jArr2[i2 + 7] = jArr[i + 7];
        jArr2[i2 + 8] = jArr[i + 8];
    }

    public static int n1(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ iArr[length];
        }
    }

    public static void n2(long[] jArr, byte[] bArr, int i) {
        for (long j : jArr) {
            m2(j, bArr, i);
            i += 8;
        }
    }

    public static BigInteger n3(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                B1(i2, bArr, (5 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int o(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        long j7 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L) + (j6 >>> 32);
        iArr3[6] = (int) j7;
        long j8 = (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L) + (((long) iArr3[7]) & 4294967295L) + (j7 >>> 32);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static void o0(byte[] bArr, byte[] bArr2, int i) {
        Objects.requireNonNull(bArr2, "src == null");
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (bArr2.length + i <= bArr.length) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr[i + i2] = bArr2[i2];
            }
        } else {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
    }

    public static int o1(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return 0;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            i3 = (i3 * 257) ^ iArr[i + i2];
        }
    }

    public static byte[] o2(long j) {
        byte[] bArr = new byte[8];
        m2(j, bArr, 0);
        return bArr;
    }

    public static BigInteger o3(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i = 0; i < 7; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                B1(i2, bArr, (6 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int p(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            long j2 = (((long) iArr[i2 + i4]) & 4294967295L) + (4294967295L & ((long) iArr2[i5])) + j;
            iArr2[i5] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static byte[] p0(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
        return bArr2;
    }

    public static int p1(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return 0;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            long j = jArr[i + i2];
            i3 = (((i3 * 257) ^ ((int) j)) * 257) ^ ((int) (j >>> 32));
        }
    }

    public static s0.a.e.b.h p2(s0.a.e.b.c0.c cVar, s0.a.e.b.h hVar) {
        return ((s0.a.e.b.c0.a) hVar.b.r(hVar, "bc_endo", new s0.a.e.b.c0.b(cVar, hVar))).b;
    }

    public static BigInteger p3(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 8; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                B1(i2, bArr, (7 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int q(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = (((long) iArr[i2]) & 4294967295L) + (4294967295L & ((long) iArr2[i2])) + j;
            iArr2[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static byte[] q0(byte[] bArr, int i, int i2) {
        int d1 = d1(i, i2);
        byte[] bArr2 = new byte[d1];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, d1));
        return bArr2;
    }

    public static int q1(short[] sArr) {
        if (sArr == null) {
            return 0;
        }
        int length = sArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ (sArr[length] & 255);
        }
    }

    public static int q2(int i, int i2, int i3) {
        int I2 = I2(i, i3);
        int I22 = I2(i2, i3);
        int i4 = 0;
        if (I22 != 0) {
            int x0 = 1 << x0(i3);
            while (I2 != 0) {
                if (((byte) (I2 & 1)) == 1) {
                    i4 ^= I22;
                }
                I2 >>>= 1;
                I22 <<= 1;
                if (I22 >= x0) {
                    I22 ^= i3;
                }
            }
        }
        return i4;
    }

    public static BigInteger q3(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 3; i++) {
            long j = jArr[i];
            if (j != 0) {
                l2(j, bArr, (2 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int r(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i2 + 0;
        long j = (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L) + (((long) i3) & 4294967295L);
        iArr2[i4] = (int) j;
        int i5 = i2 + 1;
        long j2 = (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i5]) & 4294967295L) + (j >>> 32);
        iArr2[i5] = (int) j2;
        int i6 = i2 + 2;
        long j3 = (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L) + (j2 >>> 32);
        iArr2[i6] = (int) j3;
        int i7 = i2 + 3;
        long j4 = (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L) + (j3 >>> 32);
        iArr2[i7] = (int) j4;
        int i8 = i2 + 4;
        long j5 = (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i8]) & 4294967295L) + (j4 >>> 32);
        iArr2[i8] = (int) j5;
        int i9 = i2 + 5;
        long j6 = (((long) iArr[i + 5]) & 4294967295L) + (4294967295L & ((long) iArr2[i9])) + (j5 >>> 32);
        iArr2[i9] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static s0.a.f.d.a.a r0(s0.a.f.d.a.b bVar, s0.a.f.d.a.e eVar) {
        int i = bVar.a;
        int i2 = 1 << i;
        int e = eVar.e();
        int i3 = 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, e, i2);
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, e, i2);
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr3 = iArr2[0];
            int[] iArr4 = eVar.c;
            int i5 = eVar.b;
            int i6 = iArr4[i5];
            while (true) {
                i5--;
                if (i5 >= 0) {
                    i6 = eVar.a.d(i6, i4) ^ eVar.c[i5];
                }
            }
            iArr3[i4] = bVar.b(i6);
        }
        for (int i7 = 1; i7 < e; i7++) {
            for (int i8 = 0; i8 < i2; i8++) {
                iArr2[i7][i8] = bVar.d(iArr2[i7 - 1][i8], i8);
            }
        }
        int i9 = 0;
        while (i9 < e) {
            int i10 = i3;
            while (i10 < i2) {
                for (int i11 = i3; i11 <= i9; i11++) {
                    iArr[i9][i10] = bVar.d(iArr2[i11][i10], eVar.d((e + i11) - i9)) ^ iArr[i9][i10];
                }
                i10++;
                i3 = 0;
            }
            i9++;
            i3 = 0;
        }
        int[][] iArr5 = (int[][]) Array.newInstance(int.class, e * i, (i2 + 31) >>> 5);
        for (int i12 = 0; i12 < i2; i12++) {
            int i13 = i12 >>> 5;
            int i14 = 1 << (i12 & 31);
            for (int i15 = 0; i15 < e; i15++) {
                int i16 = iArr[i15][i12];
                for (int i17 = 0; i17 < i; i17++) {
                    if (((i16 >>> i17) & 1) != 0) {
                        int[] iArr6 = iArr5[(((i15 + 1) * i) - i17) - 1];
                        iArr6[i13] = iArr6[i13] ^ i14;
                    }
                }
            }
        }
        return new s0.a.f.d.a.a(i2, iArr5);
    }

    public static int r1(short[][] sArr) {
        int i = 0;
        for (int i2 = 0; i2 != sArr.length; i2++) {
            i = (i * 257) + q1(sArr[i2]);
        }
        return i;
    }

    public static int r2(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int numberOfLeadingZeros = (length << 5) - Integer.numberOfLeadingZeros(iArr[length - 1]);
        int i = 30;
        int i2 = (numberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[i2];
        int[] iArr7 = new int[i2];
        int[] iArr8 = new int[i2];
        int[] iArr9 = new int[i2];
        int i3 = 0;
        iArr6[0] = 1;
        B0(numberOfLeadingZeros, iArr2, 0, iArr8, 0);
        B0(numberOfLeadingZeros, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i2);
        int F1 = F1(iArr9[0]);
        int i4 = ((numberOfLeadingZeros * 49) + (numberOfLeadingZeros < 46 ? 80 : 47)) / 17;
        int i5 = -1;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = iArr7[i3];
            int i8 = iArr8[i3];
            int i9 = 1;
            int i10 = 1;
            int i11 = i3;
            int i12 = i11;
            int i13 = i5;
            while (i3 < i) {
                int i14 = i13 >> 31;
                int i15 = -(i8 & 1);
                int i16 = i8 + (((i7 ^ i14) - i14) & i15);
                i12 += ((i9 ^ i14) - i14) & i15;
                i10 += ((i11 ^ i14) - i14) & i15;
                int i17 = i14 & i15;
                i13 = (i13 ^ i17) - (i17 + 1);
                i7 += i16 & i17;
                i8 = i16 >> 1;
                i9 = (i9 + (i12 & i17)) << 1;
                i11 = (i11 + (i17 & i10)) << 1;
                i3++;
                i = 30;
            }
            iArr4[0] = i9;
            iArr4[1] = i11;
            iArr4[2] = i12;
            iArr4[3] = i10;
            u3(i2, iArr5, iArr6, iArr4, F1, iArr9);
            v3(i2, iArr7, iArr8, iArr4);
            i6 += 30;
            i3 = 0;
            i5 = i13;
            i4 = i4;
            i = 30;
        }
        int i18 = i3;
        int i19 = i2 - 1;
        int i20 = iArr7[i19] >> 31;
        int i21 = i18;
        for (int i22 = i21; i22 < i19; i22++) {
            int i23 = ((iArr7[i22] ^ i20) - i20) + i21;
            iArr7[i22] = i23 & 1073741823;
            i21 = i23 >> 30;
        }
        iArr7[i19] = ((iArr7[i19] ^ i20) - i20) + i21;
        int i24 = iArr5[i19] >> 31;
        int i25 = i18;
        for (int i26 = i25; i26 < i19; i26++) {
            int i27 = (((iArr5[i26] + (iArr9[i26] & i24)) ^ i20) - i20) + i25;
            iArr5[i26] = i27 & 1073741823;
            i25 = i27 >> 30;
        }
        iArr5[i19] = (((iArr5[i19] + (i24 & iArr9[i19])) ^ i20) - i20) + i25;
        int i28 = iArr5[i19] >> 31;
        int i29 = i18;
        for (int i30 = i29; i30 < i19; i30++) {
            int i31 = iArr5[i30] + (iArr9[i30] & i28) + i29;
            iArr5[i30] = i31 & 1073741823;
            i29 = i31 >> 30;
        }
        iArr5[i19] = iArr5[i19] + (i28 & iArr9[i19]) + i29;
        w0(numberOfLeadingZeros, iArr5, i18, iArr3, i18);
        int i32 = iArr7[i18] ^ 1;
        for (int i33 = 1; i33 < i2; i33++) {
            i32 |= iArr7[i33];
        }
        int i34 = (((i32 & 1) | (i32 >>> 1)) - 1) >> 31;
        for (int i35 = i18; i35 < i2; i35++) {
            i18 |= iArr8[i35];
        }
        return i34 & ((((i18 >>> 1) | (i18 & 1)) - 1) >> 31);
    }

    public static BigInteger r3(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 4; i++) {
            long j = jArr[i];
            if (j != 0) {
                l2(j, bArr, (3 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int s(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i2 + 0;
        long j = (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L) + (((long) i3) & 4294967295L);
        iArr2[i4] = (int) j;
        int i5 = i2 + 1;
        long j2 = (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i5]) & 4294967295L) + (j >>> 32);
        iArr2[i5] = (int) j2;
        int i6 = i2 + 2;
        long j3 = (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L) + (j2 >>> 32);
        iArr2[i6] = (int) j3;
        int i7 = i2 + 3;
        long j4 = (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L) + (j3 >>> 32);
        iArr2[i7] = (int) j4;
        int i8 = i2 + 4;
        long j5 = (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i8]) & 4294967295L) + (j4 >>> 32);
        iArr2[i8] = (int) j5;
        int i9 = i2 + 5;
        long j6 = (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i9]) & 4294967295L) + (j5 >>> 32);
        iArr2[i9] = (int) j6;
        int i10 = i2 + 6;
        long j7 = (((long) iArr[i + 6]) & 4294967295L) + (((long) iArr2[i10]) & 4294967295L) + (j6 >>> 32);
        iArr2[i10] = (int) j7;
        int i11 = i2 + 7;
        long j8 = (((long) iArr[i + 7]) & 4294967295L) + (4294967295L & ((long) iArr2[i11])) + (j7 >>> 32);
        iArr2[i11] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static s0.a.b.k0.b s0(p pVar) throws IOException {
        s0.a.a.n nVar = pVar.d.c;
        if (nVar.G(s0.a.a.c2.a.J)) {
            return new s0.a.f.b.d.a(((Integer) s0.a.f.b.g.b.i.get(pVar.d.c)).intValue(), o.B(pVar.u()).c);
        } else if (nVar.w(s0.a.a.c2.a.n)) {
            return new s0.a.f.b.f.b(o.B(pVar.u()).c, s0.a.f.b.g.b.d(s0.a.f.a.h.s(pVar.d.d)));
        } else {
            if (nVar.w(s0.a.a.c2.a.N)) {
                byte[] bArr = o.B(pVar.u()).c;
                int length = bArr.length / 2;
                short[] sArr = new short[length];
                for (int i = 0; i != length; i++) {
                    int i2 = i * 2;
                    sArr[i] = (short) (((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255));
                }
                return new s0.a.f.b.c.a(sArr);
            } else if (nVar.w(s0.a.a.w2.n.f66s0)) {
                byte[] bArr2 = o.B(pVar.u()).c;
                s0.a.a.b bVar = pVar.y;
                if (y(bArr2, 0) == 1) {
                    if (bVar == null) {
                        return g.e(q0(bArr2, 4, bArr2.length));
                    }
                    byte[] C = bVar.C();
                    byte[] q02 = q0(bArr2, 4, bArr2.length);
                    byte[] q03 = q0(C, 4, C.length);
                    g e = g.e(q02);
                    e.f2 = s0.a.f.b.a.h.a(q03);
                    return e;
                } else if (bVar == null) {
                    return s0.a.f.b.a.c.a(q0(bArr2, 4, bArr2.length));
                } else {
                    byte[] C2 = bVar.C();
                    s0.a.f.b.a.c a = s0.a.f.b.a.c.a(q0(bArr2, 4, bArr2.length));
                    s0.a.f.b.a.d.a(C2);
                    Objects.requireNonNull(a);
                    return a;
                }
            } else if (nVar.w(s0.a.a.c2.a.r)) {
                s0.a.f.a.i s = s0.a.f.a.i.s(pVar.d.d);
                s0.a.a.n nVar2 = s.q.c;
                s0.a.a.e u = pVar.u();
                s0.a.f.a.m mVar = u instanceof s0.a.f.a.m ? (s0.a.f.a.m) u : u != null ? new s0.a.f.a.m(s.B(u)) : null;
                try {
                    t.b bVar2 = new t.b(new s0.a.f.b.h.s(s.d, s0.a.f.b.h.c.b(s0.a.f.b.g.b.a(nVar2).getAlgorithmName())));
                    bVar2.b = mVar.d;
                    bVar2.d = P(I(mVar.q));
                    bVar2.e = P(I(mVar.x));
                    bVar2.f = P(I(mVar.y));
                    bVar2.g = P(I(mVar.Y1));
                    if (mVar.c != 0) {
                        bVar2.c = mVar.Z1;
                    }
                    if (I(mVar.a2) != null) {
                        BDS bds = (BDS) y0(I(mVar.a2), BDS.class);
                        Objects.requireNonNull(bds);
                        bVar2.h = new BDS(bds, nVar2);
                    }
                    return new t(bVar2, null);
                } catch (ClassNotFoundException e2) {
                    StringBuilder P0 = a.P0("ClassNotFoundException processing BDS state: ");
                    P0.append(e2.getMessage());
                    throw new IOException(P0.toString());
                }
            } else if (nVar.w(s0.a.f.a.e.l)) {
                j s2 = j.s(pVar.d.d);
                s0.a.a.n nVar3 = s2.x.c;
                try {
                    s0.a.a.e u2 = pVar.u();
                    s0.a.f.a.k kVar = u2 instanceof s0.a.f.a.k ? (s0.a.f.a.k) u2 : u2 != null ? new s0.a.f.a.k(s.B(u2)) : null;
                    int i3 = s2.d;
                    p.b bVar3 = new p.b(new s0.a.f.b.h.o(i3, s2.q, s0.a.f.b.h.c.b(s0.a.f.b.g.b.a(nVar3).getAlgorithmName())));
                    bVar3.b = kVar.d;
                    bVar3.d = P(I(kVar.x));
                    bVar3.e = P(I(kVar.y));
                    bVar3.f = P(I(kVar.Y1));
                    bVar3.g = P(I(kVar.Z1));
                    if (kVar.c != 0) {
                        bVar3.c = kVar.q;
                    }
                    if (I(kVar.a2) != null) {
                        BDSStateMap b = ((BDSStateMap) y0(I(kVar.a2), BDSStateMap.class)).b(nVar3);
                        if (b.d == 0) {
                            bVar3.h = new BDSStateMap(b, (1 << i3) - 1);
                        } else {
                            bVar3.h = b;
                        }
                    }
                    return new s0.a.f.b.h.p(bVar3, null);
                } catch (ClassNotFoundException e3) {
                    StringBuilder P02 = a.P0("ClassNotFoundException processing BDS state: ");
                    P02.append(e3.getMessage());
                    throw new IOException(P02.toString());
                }
            } else {
                throw new RuntimeException("algorithm identifier in private key not recognised");
            }
        }
    }

    public static int s1(short[][][] sArr) {
        int i = 0;
        for (int i2 = 0; i2 != sArr.length; i2++) {
            i = (i * 257) + r1(sArr[i2]);
        }
        return i;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static boolean s2(int[] iArr, int[] iArr2, int[] iArr3) {
        int i;
        int i2;
        int i3;
        int length = iArr.length;
        int i4 = 1;
        int numberOfLeadingZeros = (length << 5) - Integer.numberOfLeadingZeros(iArr[length - 1]);
        int i5 = (numberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i5];
        int[] iArr6 = new int[i5];
        int[] iArr7 = new int[i5];
        int[] iArr8 = new int[i5];
        int[] iArr9 = new int[i5];
        ?? r8 = 0;
        iArr6[0] = 1;
        B0(numberOfLeadingZeros, iArr2, 0, iArr8, 0);
        B0(numberOfLeadingZeros, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i5);
        int i6 = i5 - 1;
        int numberOfLeadingZeros2 = -1 - (Integer.numberOfLeadingZeros(iArr8[i6] | 1) - (((i5 * 30) + 2) - numberOfLeadingZeros));
        int F1 = F1(iArr9[0]);
        int i7 = ((numberOfLeadingZeros * 49) + (numberOfLeadingZeros < 46 ? 80 : 47)) / 17;
        int i8 = i5;
        int i9 = 0;
        while (!S1(i8, iArr8)) {
            if (i9 >= i7) {
                return r8;
            }
            int i10 = i9 + 30;
            char c = r8 == true ? 1 : 0;
            char c2 = r8 == true ? 1 : 0;
            char c3 = r8 == true ? 1 : 0;
            int i11 = iArr7[c];
            int i12 = iArr8[r8];
            int i13 = i4;
            int i14 = i13;
            int i15 = r8 == true ? 1 : 0;
            Object[] objArr = r8 == true ? 1 : 0;
            Object[] objArr2 = r8 == true ? 1 : 0;
            int i16 = i15;
            int i17 = i16;
            int i18 = 30;
            while (true) {
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros((-1 << i18) | i12);
                int i19 = i12 >> numberOfTrailingZeros;
                i = i13 << numberOfTrailingZeros;
                i2 = i16 << numberOfTrailingZeros;
                numberOfLeadingZeros2 -= numberOfTrailingZeros;
                int i20 = i18 - numberOfTrailingZeros;
                if (i20 <= 0) {
                    break;
                }
                if (numberOfLeadingZeros2 < 0) {
                    numberOfLeadingZeros2 = -numberOfLeadingZeros2;
                    int i21 = -i11;
                    i17 = -i;
                    i14 = -i2;
                    int i22 = numberOfLeadingZeros2 + 1;
                    if (i22 > i20) {
                        i22 = i20;
                    }
                    i3 = (-1 >>> (32 - i22)) & 63 & (((i19 * i19) - 2) * i19 * i21);
                    i11 = i19;
                    i16 = i14;
                    i19 = i21;
                    i = i17;
                } else {
                    int i23 = numberOfLeadingZeros2 + 1;
                    if (i23 > i20) {
                        i23 = i20;
                    }
                    i3 = ((-((((i11 + 1) & 4) << 1) + i11)) * i19) & (-1 >>> (32 - i23)) & 15;
                    i16 = i2;
                }
                i12 = (i11 * i3) + i19;
                i17 = (i * i3) + i17;
                i14 = (i3 * i16) + i14;
                iArr9 = iArr9;
                iArr8 = iArr8;
                iArr6 = iArr6;
                i7 = i7;
                i13 = i;
                i18 = i20;
                i10 = i10;
            }
            iArr4[0] = i;
            iArr4[1] = i2;
            iArr4[2] = i17;
            iArr4[3] = i14;
            u3(i5, iArr5, iArr6, iArr4, F1, iArr9);
            v3(i8, iArr7, iArr8, iArr4);
            i8--;
            int i24 = iArr7[i8];
            int i25 = iArr8[i8];
            int i26 = i8 - 2;
            if (((i26 >> 31) | ((i24 >> 31) ^ i24) | ((i25 >> 31) ^ i25)) == 0) {
                iArr7[i26] = iArr7[i26] | (i24 << 30);
                iArr8[i26] = iArr8[i26] | (i25 << 30);
            } else {
                i8 = i8;
            }
            i9 = i10;
            iArr9 = iArr9;
            numberOfLeadingZeros2 = numberOfLeadingZeros2;
            r8 = 0;
            iArr8 = iArr8;
            iArr6 = iArr6;
            i7 = i7;
            i4 = 1;
        }
        int i27 = iArr7[i8 - 1] >> 31;
        int i28 = iArr5[i6] >> 31;
        if (i28 < 0) {
            i28 = g(i5, iArr5, iArr9);
        }
        if (i27 < 0) {
            i28 = F2(i5, iArr5);
            F2(i8, iArr7);
        }
        if (!I1(i8, iArr7)) {
            return r8;
        }
        if (i28 < 0) {
            g(i5, iArr5, iArr9);
        }
        int i29 = r8 == true ? 1 : 0;
        int i30 = r8 == true ? 1 : 0;
        int i31 = r8 == true ? 1 : 0;
        w0(numberOfLeadingZeros, iArr5, i29, iArr3, r8);
        return true;
    }

    public static byte[] s3(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) j);
            j >>>= 8;
        }
        return bArr;
    }

    public static int t(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (((long) iArr[i6]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L) + (j >>> 32);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (((long) iArr[i9]) & 4294967295L) + (((long) iArr2[i10]) & 4294967295L) + (j2 >>> 32);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L) + (j3 >>> 32);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (((long) iArr[i15]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L) + (j4 >>> 32);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i + 5;
        int i19 = i2 + 5;
        long j6 = (((long) iArr[i18]) & 4294967295L) + (4294967295L & ((long) iArr2[i19])) + (j5 >>> 32);
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        return (int) (j6 >>> 32);
    }

    public static s0.a.a.w2.p t0(s0.a.b.k0.b bVar, s0.a.a.v vVar) throws IOException {
        s0.a.f.b.a.h f;
        if (bVar instanceof s0.a.f.b.d.a) {
            s0.a.f.b.d.a aVar = (s0.a.f.b.d.a) bVar;
            return new s0.a.a.w2.p(s0.a.f.b.g.b.b(aVar.d), new x0(aVar.a()), vVar, null);
        } else if (bVar instanceof s0.a.f.b.f.b) {
            s0.a.f.b.f.b bVar2 = (s0.a.f.b.f.b) bVar;
            return new s0.a.a.w2.p(new b(s0.a.f.a.e.e, new s0.a.f.a.h(s0.a.f.b.g.b.c(bVar2.d))), new x0(bVar2.a()), null, null);
        } else {
            if (bVar instanceof s0.a.f.b.c.a) {
                b bVar3 = new b(s0.a.f.a.e.f);
                short[] a = ((s0.a.f.b.c.a) bVar).a();
                byte[] bArr = new byte[a.length * 2];
                for (int i = 0; i != a.length; i++) {
                    short s = a[i];
                    int i2 = i * 2;
                    bArr[i2] = (byte) s;
                    bArr[i2 + 1] = (byte) (s >>> 8);
                }
                return new s0.a.a.w2.p(bVar3, new x0(bArr), null, null);
            } else if (bVar instanceof g) {
                g gVar = (g) bVar;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte b = (byte) 0;
                byteArrayOutputStream.write(b);
                byte b2 = (byte) 0;
                byteArrayOutputStream.write(b2);
                byte b3 = (byte) 0;
                byteArrayOutputStream.write(b3);
                byte b4 = (byte) 1;
                byteArrayOutputStream.write(b4);
                try {
                    byteArrayOutputStream.write(gVar.getEncoded());
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    byteArrayOutputStream2.write(b);
                    byteArrayOutputStream2.write(b2);
                    byteArrayOutputStream2.write(b3);
                    byteArrayOutputStream2.write(b4);
                    try {
                        byteArrayOutputStream2.write(gVar.f().getEncoded());
                        return new s0.a.a.w2.p(new b(s0.a.a.w2.n.f66s0), new x0(byteArray), vVar, byteArrayOutputStream2.toByteArray());
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                } catch (Exception e2) {
                    throw new RuntimeException(e2.getMessage(), e2);
                }
            } else if (bVar instanceof s0.a.f.b.a.c) {
                s0.a.f.b.a.c cVar = (s0.a.f.b.a.c) bVar;
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                int i3 = cVar.d;
                byteArrayOutputStream3.write((byte) (i3 >>> 24));
                byteArrayOutputStream3.write((byte) (i3 >>> 16));
                byteArrayOutputStream3.write((byte) (i3 >>> 8));
                byteArrayOutputStream3.write((byte) i3);
                try {
                    byteArrayOutputStream3.write(cVar.getEncoded());
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    int i4 = cVar.d;
                    byteArrayOutputStream4.write((byte) (i4 >>> 24));
                    byteArrayOutputStream4.write((byte) (i4 >>> 16));
                    byteArrayOutputStream4.write((byte) (i4 >>> 8));
                    byteArrayOutputStream4.write((byte) i4);
                    synchronized (cVar) {
                        f = cVar.x.get(0).f();
                    }
                    try {
                        byteArrayOutputStream4.write(f.getEncoded());
                        return new s0.a.a.w2.p(new b(s0.a.a.w2.n.f66s0), new x0(byteArray2), vVar, byteArrayOutputStream4.toByteArray());
                    } catch (Exception e3) {
                        throw new RuntimeException(e3.getMessage(), e3);
                    }
                } catch (Exception e4) {
                    throw new RuntimeException(e4.getMessage(), e4);
                }
            } else if (bVar instanceof t) {
                t tVar = (t) bVar;
                b bVar4 = new b(s0.a.f.a.e.g, new s0.a.f.a.i(tVar.q.c, s0.a.f.b.g.b.e(tVar.d)));
                byte[] encoded = tVar.getEncoded();
                s0.a.f.b.h.s sVar = tVar.q;
                int i5 = sVar.h;
                int i6 = sVar.c;
                int D = (int) D(encoded, 0, 4);
                if (G1(i6, (long) D)) {
                    byte[] O0 = O0(encoded, 4, i5);
                    int i7 = i5 + 4;
                    byte[] O02 = O0(encoded, i7, i5);
                    int i8 = i7 + i5;
                    byte[] O03 = O0(encoded, i8, i5);
                    int i9 = i8 + i5;
                    byte[] O04 = O0(encoded, i9, i5);
                    int i10 = i9 + i5;
                    byte[] O05 = O0(encoded, i10, encoded.length - i10);
                    try {
                        int i11 = ((BDS) y0(O05, BDS.class)).e2;
                        return new s0.a.a.w2.p(bVar4, i11 != (1 << i6) - 1 ? new s0.a.f.a.m(D, O0, O02, O03, O04, O05, i11) : new s0.a.f.a.m(D, O0, O02, O03, O04, O05), vVar, null);
                    } catch (ClassNotFoundException e5) {
                        StringBuilder P0 = a.P0("cannot parse BDS: ");
                        P0.append(e5.getMessage());
                        throw new IOException(P0.toString());
                    }
                } else {
                    throw new IllegalArgumentException("index out of bounds");
                }
            } else if (bVar instanceof s0.a.f.b.h.p) {
                s0.a.f.b.h.p pVar = (s0.a.f.b.h.p) bVar;
                s0.a.a.n nVar = s0.a.f.a.e.l;
                s0.a.f.b.h.o oVar = pVar.q;
                b bVar5 = new b(nVar, new j(oVar.d, oVar.e, s0.a.f.b.g.b.e(pVar.d)));
                byte[] encoded2 = pVar.getEncoded();
                s0.a.f.b.h.o oVar2 = pVar.q;
                int i12 = oVar2.c.h;
                int i13 = oVar2.d;
                int i14 = (i13 + 7) / 8;
                long D2 = (long) ((int) D(encoded2, 0, i14));
                if (G1(i13, D2)) {
                    int i15 = i14 + 0;
                    byte[] O06 = O0(encoded2, i15, i12);
                    int i16 = i15 + i12;
                    byte[] O07 = O0(encoded2, i16, i12);
                    int i17 = i16 + i12;
                    byte[] O08 = O0(encoded2, i17, i12);
                    int i18 = i17 + i12;
                    byte[] O09 = O0(encoded2, i18, i12);
                    int i19 = i18 + i12;
                    byte[] O010 = O0(encoded2, i19, encoded2.length - i19);
                    try {
                        long j = ((BDSStateMap) y0(O010, BDSStateMap.class)).d;
                        return new s0.a.a.w2.p(bVar5, j != (1 << i13) - 1 ? new s0.a.f.a.k(D2, O06, O07, O08, O09, O010, j) : new s0.a.f.a.k(D2, O06, O07, O08, O09, O010), vVar, null);
                    } catch (ClassNotFoundException e6) {
                        StringBuilder P02 = a.P0("cannot parse BDSStateMap: ");
                        P02.append(e6.getMessage());
                        throw new IOException(P02.toString());
                    }
                } else {
                    throw new IllegalArgumentException("index out of bounds");
                }
            } else {
                throw new IOException("key parameters not recognized");
            }
        }
    }

    public static void t1(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = ((j3 >>> 49) ^ (j4 << 15)) & 576460752303423487L;
        jArr2[4] = ((j4 >>> 44) ^ (j5 << 20)) & 576460752303423487L;
        jArr2[5] = ((j5 >>> 39) ^ (j6 << 25)) & 576460752303423487L;
        jArr2[6] = (j6 >>> 34) ^ (j7 << 30);
    }

    public static void t2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        int i = 1;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr[0]) & 4294967295L;
        long j6 = (j5 * j) + 0;
        iArr3[0] = (int) j6;
        char c = ' ';
        long j7 = (j5 * j2) + (j6 >>> 32);
        iArr3[1] = (int) j7;
        long j8 = (j5 * j3) + (j7 >>> 32);
        iArr3[2] = (int) j8;
        long j9 = (j5 * j4) + (j8 >>> 32);
        iArr3[3] = (int) j9;
        iArr3[4] = (int) (j9 >>> 32);
        for (int i2 = 4; i < i2; i2 = 4) {
            long j10 = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j11 = (j10 * j) + (((long) iArr3[i3]) & 4294967295L) + 0;
            iArr3[i3] = (int) j11;
            int i4 = i + 1;
            long j12 = (j10 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j11 >>> c);
            iArr3[i4] = (int) j12;
            int i5 = i + 2;
            long j13 = (j10 * j3) + (((long) iArr3[i5]) & 4294967295L) + (j12 >>> 32);
            iArr3[i5] = (int) j13;
            c = ' ';
            int i6 = i + 3;
            long j14 = (j10 * j4) + (((long) iArr3[i6]) & 4294967295L) + (j13 >>> 32);
            iArr3[i6] = (int) j14;
            iArr3[i + 4] = (int) (j14 >>> 32);
            i = i4;
            j = j;
            j2 = j2;
        }
    }

    public static void t3(int i, n nVar) {
        nVar.update((byte) (i >>> 24));
        nVar.update((byte) (i >>> 16));
        nVar.update((byte) (i >>> 8));
        nVar.update((byte) i);
    }

    public static int u(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (((long) iArr[i6]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L) + (j >>> 32);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (((long) iArr[i9]) & 4294967295L) + (((long) iArr2[i10]) & 4294967295L) + (j2 >>> 32);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L) + (j3 >>> 32);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (((long) iArr[i15]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L) + (j4 >>> 32);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i + 5;
        int i19 = i2 + 5;
        long j6 = (((long) iArr[i18]) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L) + (j5 >>> 32);
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        int i21 = i + 6;
        int i22 = i2 + 6;
        long j7 = (((long) iArr[i21]) & 4294967295L) + (((long) iArr2[i22]) & 4294967295L) + (j6 >>> 32);
        int i23 = (int) j7;
        iArr[i21] = i23;
        iArr2[i22] = i23;
        int i24 = i + 7;
        int i25 = i2 + 7;
        long j8 = (((long) iArr[i24]) & 4294967295L) + (4294967295L & ((long) iArr2[i25])) + (j7 >>> 32);
        int i26 = (int) j8;
        iArr[i24] = i26;
        iArr2[i25] = i26;
        return (int) (j8 >>> 32);
    }

    public static s0.a.a.c3.m0 u0(s0.a.b.k0.b bVar) throws IOException {
        if (bVar instanceof s0.a.f.b.d.b) {
            s0.a.f.b.d.b bVar2 = (s0.a.f.b.d.b) bVar;
            return new s0.a.a.c3.m0(s0.a.f.b.g.b.b(bVar2.d), bVar2.a());
        } else if (bVar instanceof s0.a.f.b.f.c) {
            s0.a.f.b.f.c cVar = (s0.a.f.b.f.c) bVar;
            return new s0.a.a.c3.m0(new b(s0.a.f.a.e.e, new s0.a.f.a.h(s0.a.f.b.g.b.c(cVar.d))), cVar.a());
        } else if (bVar instanceof s0.a.f.b.c.b) {
            return new s0.a.a.c3.m0(new b(s0.a.f.a.e.f), ((s0.a.f.b.c.b) bVar).a());
        } else {
            if (bVar instanceof s0.a.f.b.a.h) {
                s0.a.f.b.a.h hVar = (s0.a.f.b.a.h) bVar;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write((byte) 0);
                byteArrayOutputStream.write((byte) 0);
                byteArrayOutputStream.write((byte) 0);
                byteArrayOutputStream.write((byte) 1);
                try {
                    byteArrayOutputStream.write(hVar.getEncoded());
                    return new s0.a.a.c3.m0(new b(s0.a.a.w2.n.f66s0), new x0(byteArrayOutputStream.toByteArray()));
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            } else if (bVar instanceof s0.a.f.b.a.d) {
                s0.a.f.b.a.d dVar = (s0.a.f.b.a.d) bVar;
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                int i = dVar.d;
                byteArrayOutputStream2.write((byte) (i >>> 24));
                byteArrayOutputStream2.write((byte) (i >>> 16));
                byteArrayOutputStream2.write((byte) (i >>> 8));
                byteArrayOutputStream2.write((byte) i);
                try {
                    byteArrayOutputStream2.write(dVar.q.getEncoded());
                    return new s0.a.a.c3.m0(new b(s0.a.a.w2.n.f66s0), new x0(byteArrayOutputStream2.toByteArray()));
                } catch (Exception e2) {
                    throw new RuntimeException(e2.getMessage(), e2);
                }
            } else if (bVar instanceof u) {
                u uVar = (u) bVar;
                byte[] P = P(uVar.Y1);
                byte[] P2 = P(uVar.y);
                byte[] encoded = uVar.getEncoded();
                if (encoded.length > P.length + P2.length) {
                    return new s0.a.a.c3.m0(new b(s0.a.a.m2.a.a), new x0(encoded));
                }
                return new s0.a.a.c3.m0(new b(s0.a.f.a.e.g, new s0.a.f.a.i(uVar.q.c, s0.a.f.b.g.b.e(uVar.d))), new s0.a.f.a.n(P, P2));
            } else if (bVar instanceof q) {
                q qVar = (q) bVar;
                byte[] P3 = P(qVar.Y1);
                byte[] P4 = P(qVar.y);
                byte[] a = qVar.a();
                if (a.length > P3.length + P4.length) {
                    return new s0.a.a.c3.m0(new b(s0.a.a.m2.a.b), new x0(a));
                }
                s0.a.a.n nVar = s0.a.f.a.e.l;
                s0.a.f.b.h.o oVar = qVar.q;
                return new s0.a.a.c3.m0(new b(nVar, new j(oVar.d, oVar.e, s0.a.f.b.g.b.e(qVar.d))), new s0.a.f.a.l(P(qVar.Y1), P(qVar.y)));
            } else {
                throw new IOException("key parameters not recognized");
            }
        }
    }

    public static void u1(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        t1(jArr, jArr4);
        t1(jArr2, jArr5);
        long[] jArr6 = new long[8];
        for (int i = 0; i < 7; i++) {
            v1(jArr6, jArr4[i], jArr5[i], jArr3, i << 1);
        }
        long j = jArr3[0];
        long j2 = jArr3[1];
        long j3 = j ^ jArr3[2];
        jArr3[1] = j3 ^ j2;
        long j4 = j2 ^ jArr3[3];
        long j5 = j3 ^ jArr3[4];
        jArr3[2] = j5 ^ j4;
        long j6 = j4 ^ jArr3[5];
        long j7 = j5 ^ jArr3[6];
        jArr3[3] = j7 ^ j6;
        long j8 = j6 ^ jArr3[7];
        long j9 = j7 ^ jArr3[8];
        jArr3[4] = j9 ^ j8;
        long j10 = j8 ^ jArr3[9];
        long j11 = j9 ^ jArr3[10];
        jArr3[5] = j11 ^ j10;
        long j12 = j10 ^ jArr3[11];
        long j13 = j11 ^ jArr3[12];
        jArr3[6] = j13 ^ j12;
        long j14 = j13 ^ (j12 ^ jArr3[13]);
        jArr3[7] = jArr3[0] ^ j14;
        jArr3[8] = jArr3[1] ^ j14;
        jArr3[9] = jArr3[2] ^ j14;
        jArr3[10] = jArr3[3] ^ j14;
        jArr3[11] = jArr3[4] ^ j14;
        jArr3[12] = jArr3[5] ^ j14;
        jArr3[13] = j14 ^ jArr3[6];
        v1(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        v1(jArr6, jArr4[0] ^ jArr4[2], jArr5[0] ^ jArr5[2], jArr3, 2);
        v1(jArr6, jArr4[0] ^ jArr4[3], jArr5[0] ^ jArr5[3], jArr3, 3);
        v1(jArr6, jArr4[1] ^ jArr4[2], jArr5[1] ^ jArr5[2], jArr3, 3);
        v1(jArr6, jArr4[0] ^ jArr4[4], jArr5[0] ^ jArr5[4], jArr3, 4);
        v1(jArr6, jArr4[1] ^ jArr4[3], jArr5[1] ^ jArr5[3], jArr3, 4);
        v1(jArr6, jArr4[0] ^ jArr4[5], jArr5[0] ^ jArr5[5], jArr3, 5);
        v1(jArr6, jArr4[1] ^ jArr4[4], jArr5[1] ^ jArr5[4], jArr3, 5);
        v1(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 5);
        v1(jArr6, jArr4[0] ^ jArr4[6], jArr5[0] ^ jArr5[6], jArr3, 6);
        v1(jArr6, jArr4[1] ^ jArr4[5], jArr5[1] ^ jArr5[5], jArr3, 6);
        v1(jArr6, jArr4[2] ^ jArr4[4], jArr5[2] ^ jArr5[4], jArr3, 6);
        v1(jArr6, jArr4[1] ^ jArr4[6], jArr5[1] ^ jArr5[6], jArr3, 7);
        v1(jArr6, jArr4[2] ^ jArr4[5], jArr5[2] ^ jArr5[5], jArr3, 7);
        v1(jArr6, jArr4[3] ^ jArr4[4], jArr5[3] ^ jArr5[4], jArr3, 7);
        v1(jArr6, jArr4[2] ^ jArr4[6], jArr5[2] ^ jArr5[6], jArr3, 8);
        v1(jArr6, jArr4[3] ^ jArr4[5], jArr5[3] ^ jArr5[5], jArr3, 8);
        v1(jArr6, jArr4[3] ^ jArr4[6], jArr5[3] ^ jArr5[6], jArr3, 9);
        v1(jArr6, jArr4[4] ^ jArr4[5], jArr5[4] ^ jArr5[5], jArr3, 9);
        v1(jArr6, jArr4[4] ^ jArr4[6], jArr5[4] ^ jArr5[6], jArr3, 10);
        v1(jArr6, jArr4[5] ^ jArr4[6], jArr5[5] ^ jArr5[6], jArr3, 11);
        long j15 = jArr3[0];
        long j16 = jArr3[1];
        long j17 = jArr3[2];
        long j18 = jArr3[3];
        long j19 = jArr3[4];
        long j20 = jArr3[5];
        long j21 = jArr3[6];
        long j22 = jArr3[7];
        long j23 = jArr3[8];
        long j24 = jArr3[9];
        long j25 = jArr3[10];
        long j26 = jArr3[11];
        long j27 = jArr3[12];
        long j28 = jArr3[13];
        jArr3[0] = j15 ^ (j16 << 59);
        jArr3[1] = (j16 >>> 5) ^ (j17 << 54);
        jArr3[2] = (j17 >>> 10) ^ (j18 << 49);
        jArr3[3] = (j18 >>> 15) ^ (j19 << 44);
        jArr3[4] = (j19 >>> 20) ^ (j20 << 39);
        jArr3[5] = (j20 >>> 25) ^ (j21 << 34);
        jArr3[6] = (j21 >>> 30) ^ (j22 << 29);
        jArr3[7] = (j22 >>> 35) ^ (j23 << 24);
        jArr3[8] = (j23 >>> 40) ^ (j24 << 19);
        jArr3[9] = (j24 >>> 45) ^ (j25 << 14);
        jArr3[10] = (j25 >>> 50) ^ (j26 << 9);
        jArr3[11] = ((j26 >>> 55) ^ (j27 << 4)) ^ (j28 << 63);
        jArr3[12] = j28 >>> 1;
    }

    public static void u2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        int i = 1;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr[0]) & 4294967295L;
        long j7 = (j6 * j) + 0;
        iArr3[0] = (int) j7;
        long j8 = (j6 * j2) + (j7 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (j6 * j3) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (j6 * j4) + (j9 >>> 32);
        iArr3[3] = (int) j10;
        long j11 = (j6 * j5) + (j10 >>> 32);
        iArr3[4] = (int) j11;
        iArr3[5] = (int) (j11 >>> 32);
        for (int i2 = 5; i < i2; i2 = 5) {
            long j12 = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j13 = (j12 * j) + (((long) iArr3[i3]) & 4294967295L) + 0;
            iArr3[i3] = (int) j13;
            int i4 = i + 1;
            long j14 = (j12 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j13 >>> 32);
            iArr3[i4] = (int) j14;
            int i5 = i + 2;
            long j15 = (j12 * j3) + (((long) iArr3[i5]) & 4294967295L) + (j14 >>> 32);
            iArr3[i5] = (int) j15;
            int i6 = i + 3;
            long j16 = (j12 * j4) + (((long) iArr3[i6]) & 4294967295L) + (j15 >>> 32);
            iArr3[i6] = (int) j16;
            long j17 = j16 >>> 32;
            int i7 = i + 4;
            long j18 = (j12 * j5) + (((long) iArr3[i7]) & 4294967295L) + j17;
            iArr3[i7] = (int) j18;
            iArr3[i + 5] = (int) (j18 >>> 32);
            i = i4;
            j = j;
            j2 = j2;
        }
    }

    public static void u3(int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int[] iArr4) {
        int i3 = i;
        int i4 = iArr3[0];
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        int i8 = i3 - 1;
        int i9 = iArr[i8] >> 31;
        int i10 = iArr2[i8] >> 31;
        int i11 = (i4 & i9) + (i5 & i10);
        int i12 = (i9 & i6) + (i10 & i7);
        int i13 = iArr4[0];
        long j = (long) i4;
        long j2 = (long) iArr[0];
        long j3 = (long) i5;
        long j4 = (long) iArr2[0];
        long j5 = (j3 * j4) + (j * j2);
        long j6 = (long) i6;
        long j7 = (long) i7;
        long j8 = (j4 * j7) + (j2 * j6);
        long j9 = (long) i13;
        long j10 = (long) (i11 - (((((int) j5) * i2) + i11) & 1073741823));
        long j11 = (j9 * j10) + j5;
        long j12 = (long) (i12 - (((((int) j8) * i2) + i12) & 1073741823));
        long j13 = (j9 * j12) + j8;
        long j14 = j11 >> 30;
        long j15 = j13 >> 30;
        int i14 = 1;
        while (i14 < i3) {
            int i15 = iArr4[i14];
            long j16 = (long) iArr[i14];
            long j17 = (long) iArr2[i14];
            long j18 = (long) i15;
            long J = a.J(j18, j10, (j3 * j17) + (j * j16), j14);
            long J2 = a.J(j18, j12, (j17 * j7) + (j16 * j6), j15);
            int i16 = i14 - 1;
            iArr[i16] = ((int) J) & 1073741823;
            j14 = J >> 30;
            iArr2[i16] = 1073741823 & ((int) J2);
            j15 = J2 >> 30;
            i14++;
            i3 = i;
            j12 = j12;
        }
        iArr[i8] = (int) j14;
        iArr2[i8] = (int) j15;
    }

    public static int v(int i, int i2, int[] iArr, int i3) {
        long j = (((long) i2) & 4294967295L) + (4294967295L & ((long) iArr[i3]));
        iArr[i3] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return z1(i, iArr, i3 + 1);
    }

    public static int v0(int i, int[] iArr, int i2) {
        while (i2 < i) {
            int i3 = iArr[i2] - 1;
            iArr[i2] = i3;
            if (i3 != -1) {
                return 0;
            }
            i2++;
        }
        return -1;
    }

    public static void v1(long[] jArr, long j, long j2, long[] jArr2, int i) {
        jArr[1] = j2;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j2;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j2;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j2;
        int i2 = (int) j;
        long j3 = (jArr[(i2 >>> 3) & 7] << 3) ^ jArr[i2 & 7];
        long j4 = 0;
        int i3 = 54;
        do {
            int i4 = (int) (j >>> i3);
            long j5 = jArr[i4 & 7] ^ (jArr[(i4 >>> 3) & 7] << 3);
            j3 ^= j5 << i3;
            j4 ^= j5 >>> (-i3);
            i3 -= 6;
        } while (i3 > 0);
        jArr2[i] = jArr2[i] ^ (576460752303423487L & j3);
        int i5 = i + 1;
        jArr2[i5] = jArr2[i5] ^ ((j3 >>> 59) ^ (j4 << 5));
    }

    public static void v2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr[0]) & 4294967295L;
        long j8 = (j7 * j) + 0;
        iArr3[0] = (int) j8;
        long j9 = (j7 * j2) + (j8 >>> 32);
        iArr3[1] = (int) j9;
        long j10 = (j7 * j3) + (j9 >>> 32);
        iArr3[2] = (int) j10;
        long j11 = (j7 * j4) + (j10 >>> 32);
        iArr3[3] = (int) j11;
        long j12 = (j7 * j5) + (j11 >>> 32);
        iArr3[4] = (int) j12;
        long j13 = (j7 * j6) + (j12 >>> 32);
        iArr3[5] = (int) j13;
        iArr3[6] = (int) (j13 >>> 32);
        int i = 1;
        for (int i2 = 6; i < i2; i2 = 6) {
            long j14 = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j15 = (j14 * j) + (((long) iArr3[i3]) & 4294967295L) + 0;
            iArr3[i3] = (int) j15;
            int i4 = i + 1;
            long j16 = (j14 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j15 >>> 32);
            iArr3[i4] = (int) j16;
            int i5 = i + 2;
            long j17 = (j14 * j3) + (((long) iArr3[i5]) & 4294967295L) + (j16 >>> 32);
            iArr3[i5] = (int) j17;
            int i6 = i + 3;
            long j18 = (j14 * j4) + (((long) iArr3[i6]) & 4294967295L) + (j17 >>> 32);
            iArr3[i6] = (int) j18;
            int i7 = i + 4;
            long j19 = (j14 * j5) + (((long) iArr3[i7]) & 4294967295L) + (j18 >>> 32);
            iArr3[i7] = (int) j19;
            long j20 = j19 >>> 32;
            int i8 = i + 5;
            long j21 = (j14 * j6) + (((long) iArr3[i8]) & 4294967295L) + j20;
            iArr3[i8] = (int) j21;
            iArr3[i + 6] = (int) (j21 >>> 32);
            i = i4;
            j = j;
            j2 = j2;
        }
    }

    public static void v3(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = i;
        int i3 = iArr3[0];
        int i4 = 1;
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        long j = (long) i3;
        long j2 = (long) iArr[0];
        long j3 = (long) i5;
        long j4 = (long) iArr2[0];
        long j5 = (long) i6;
        long j6 = (long) i7;
        long j7 = ((j3 * j4) + (j * j2)) >> 30;
        long j8 = ((j4 * j6) + (j2 * j5)) >> 30;
        while (i4 < i2) {
            long j9 = (long) iArr[i4];
            long j10 = j * j9;
            long j11 = (long) iArr2[i4];
            long J = a.J(j3, j11, j10, j7);
            long J2 = a.J(j11, j6, j9 * j5, j8);
            int i8 = i4 - 1;
            iArr[i8] = ((int) J) & 1073741823;
            j7 = J >> 30;
            iArr2[i8] = 1073741823 & ((int) J2);
            j8 = J2 >> 30;
            i4++;
            i2 = i;
            j = j;
        }
        int i9 = i - 1;
        iArr[i9] = (int) j7;
        iArr2[i9] = (int) j8;
    }

    public static int w(int i, int i2, int[] iArr) {
        long j = (((long) i2) & 4294967295L) + (4294967295L & ((long) iArr[0]));
        iArr[0] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return z1(i, iArr, 1);
    }

    public static void w0(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            while (i4 < Math.min(32, i)) {
                i2++;
                j |= ((long) iArr[i2]) << i4;
                i4 += 30;
            }
            i3++;
            iArr2[i3] = (int) j;
            j >>>= 32;
            i4 -= 32;
            i -= 32;
        }
    }

    public static void w1(long[] jArr, long[] jArr2) {
        s0.a.e.d.a.b(jArr, 0, 6, jArr2, 0);
        jArr2[12] = s0.a.e.d.a.a((int) jArr[6]);
    }

    public static void w2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = ((long) iArr[0]) & 4294967295L;
        long j9 = (j8 * j) + 0;
        iArr3[0] = (int) j9;
        long j10 = (j8 * j2) + (j9 >>> 32);
        iArr3[1] = (int) j10;
        long j11 = (j8 * j3) + (j10 >>> 32);
        iArr3[2] = (int) j11;
        long j12 = (j8 * j4) + (j11 >>> 32);
        iArr3[3] = (int) j12;
        long j13 = (j8 * j5) + (j12 >>> 32);
        iArr3[4] = (int) j13;
        long j14 = (j8 * j6) + (j13 >>> 32);
        iArr3[5] = (int) j14;
        long j15 = (j8 * j7) + (j14 >>> 32);
        iArr3[6] = (int) j15;
        iArr3[7] = (int) (j15 >>> 32);
        int i = 1;
        for (int i2 = 7; i < i2; i2 = 7) {
            long j16 = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j17 = (j16 * j) + (((long) iArr3[i3]) & 4294967295L) + 0;
            iArr3[i3] = (int) j17;
            int i4 = i + 1;
            long j18 = (j16 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j17 >>> 32);
            iArr3[i4] = (int) j18;
            int i5 = i + 2;
            long j19 = (j16 * j3) + (((long) iArr3[i5]) & 4294967295L) + (j18 >>> 32);
            iArr3[i5] = (int) j19;
            int i6 = i + 3;
            long j20 = (j16 * j4) + (((long) iArr3[i6]) & 4294967295L) + (j19 >>> 32);
            iArr3[i6] = (int) j20;
            int i7 = i + 4;
            long j21 = (j16 * j5) + (((long) iArr3[i7]) & 4294967295L) + (j20 >>> 32);
            iArr3[i7] = (int) j21;
            int i8 = i + 5;
            long j22 = (j16 * j6) + (((long) iArr3[i8]) & 4294967295L) + (j21 >>> 32);
            iArr3[i8] = (int) j22;
            long j23 = j22 >>> 32;
            int i9 = i + 6;
            long j24 = (j16 * j7) + (((long) iArr3[i9]) & 4294967295L) + j23;
            iArr3[i9] = (int) j24;
            iArr3[i + 7] = (int) (j24 >>> 32);
            i = i4;
            j = j;
            j2 = j2;
        }
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 |= bArr[i + i4];
        }
        return i3 == 0;
    }

    public static int x0(int i) {
        int i2 = -1;
        while (i != 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static int x1(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void x2(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = ((long) iArr2[7]) & 4294967295L;
        long j9 = ((long) iArr[0]) & 4294967295L;
        long j10 = (j9 * j) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j9 * j2) + (j10 >>> 32);
        iArr3[1] = (int) j11;
        long j12 = (j9 * j3) + (j11 >>> 32);
        iArr3[2] = (int) j12;
        long j13 = (j9 * j4) + (j12 >>> 32);
        iArr3[3] = (int) j13;
        long j14 = (j9 * j5) + (j13 >>> 32);
        iArr3[4] = (int) j14;
        long j15 = (j9 * j6) + (j14 >>> 32);
        iArr3[5] = (int) j15;
        long j16 = (j9 * j7) + (j15 >>> 32);
        iArr3[6] = (int) j16;
        long j17 = (j9 * j8) + (j16 >>> 32);
        iArr3[7] = (int) j17;
        iArr3[8] = (int) (j17 >>> 32);
        int i = 1;
        for (int i2 = 8; i < i2; i2 = 8) {
            long j18 = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j19 = (j18 * j) + (((long) iArr3[i3]) & 4294967295L) + 0;
            iArr3[i3] = (int) j19;
            int i4 = i + 1;
            long j20 = (j18 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j19 >>> 32);
            iArr3[i4] = (int) j20;
            int i5 = i + 2;
            long j21 = (j18 * j3) + (((long) iArr3[i5]) & 4294967295L) + (j20 >>> 32);
            iArr3[i5] = (int) j21;
            int i6 = i + 3;
            long j22 = (j18 * j4) + (((long) iArr3[i6]) & 4294967295L) + (j21 >>> 32);
            iArr3[i6] = (int) j22;
            int i7 = i + 4;
            long j23 = (j18 * j5) + (((long) iArr3[i7]) & 4294967295L) + (j22 >>> 32);
            iArr3[i7] = (int) j23;
            int i8 = i + 5;
            long j24 = (j18 * j6) + (((long) iArr3[i8]) & 4294967295L) + (j23 >>> 32);
            iArr3[i8] = (int) j24;
            int i9 = i + 6;
            long j25 = (j18 * j7) + (((long) iArr3[i9]) & 4294967295L) + (j24 >>> 32);
            iArr3[i9] = (int) j25;
            long j26 = j25 >>> 32;
            int i10 = i + 7;
            long j27 = (j18 * j8) + (((long) iArr3[i10]) & 4294967295L) + j26;
            iArr3[i10] = (int) j27;
            iArr3[i + 8] = (int) (j27 >>> 32);
            i = i4;
            j = j;
            j2 = j2;
        }
    }

    public static int y(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] & 255) | (bArr[i] << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
    }

    public static Object y0(byte[] bArr, Class cls) throws IOException, ClassNotFoundException {
        s0.a.f.b.h.v vVar = new s0.a.f.b.h.v(cls, new ByteArrayInputStream(bArr));
        Object readObject = vVar.readObject();
        if (vVar.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        } else if (cls.isInstance(readObject)) {
            return readObject;
        } else {
            throw new IOException("unexpected class found in ObjectInputStream");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r1 >= r4) goto L_0x0017;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r6[r1] = r5[r1];
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int y1(int i, int[] iArr, int[] iArr2) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = iArr[i2] + 1;
            iArr2[i2] = i3;
            i2++;
            if (i3 != 0) {
                break;
            }
        }
        return 1;
    }

    public static int y2(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = 4294967295L;
        long j2 = ((long) iArr2[0]) & 4294967295L;
        long j3 = ((long) iArr2[1]) & 4294967295L;
        long j4 = ((long) iArr2[2]) & 4294967295L;
        long j5 = ((long) iArr2[3]) & 4294967295L;
        long j6 = ((long) iArr2[4]) & 4294967295L;
        long j7 = 0;
        while (i < 5) {
            long j8 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j9 = (j8 * j2) + (((long) iArr3[i2]) & j) + 0;
            iArr3[i2] = (int) j9;
            int i3 = i + 1;
            long j10 = (j8 * j3) + (((long) iArr3[i3]) & 4294967295L) + (j9 >>> 32);
            iArr3[i3] = (int) j10;
            int i4 = i + 2;
            long j11 = (j8 * j4) + (((long) iArr3[i4]) & 4294967295L) + (j10 >>> 32);
            iArr3[i4] = (int) j11;
            int i5 = i + 3;
            long j12 = (j8 * j5) + (((long) iArr3[i5]) & 4294967295L) + (j11 >>> 32);
            iArr3[i5] = (int) j12;
            long j13 = j12 >>> 32;
            int i6 = i + 4;
            long j14 = (j8 * j6) + (((long) iArr3[i6]) & 4294967295L) + j13;
            iArr3[i6] = (int) j14;
            int i7 = i + 5;
            long j15 = (j14 >>> 32) + (((long) iArr3[i7]) & 4294967295L) + j7;
            iArr3[i7] = (int) j15;
            j7 = j15 >>> 32;
            j = 4294967295L;
            j2 = j2;
            i = i3;
            j3 = j3;
            j4 = j4;
        }
        return (int) j7;
    }

    public static long z(byte[] bArr, int i) {
        int y = y(bArr, i);
        return (((long) y(bArr, i + 4)) & 4294967295L) | ((((long) y) & 4294967295L) << 32);
    }

    public static boolean z0(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean z;
        int i4 = 5;
        while (true) {
            z = true;
            if (i4 < 0) {
                break;
            }
            int i5 = iArr[i + i4] ^ Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE ^ iArr2[i2 + i4];
            if (i5 < i6) {
                z = false;
                break;
            } else if (i5 > i6) {
                break;
            } else {
                i4--;
            }
        }
        if (z) {
            X2(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            X2(iArr2, i2, iArr, i, iArr3, i3);
        }
        return z;
    }

    public static int z1(int i, int[] iArr, int i2) {
        while (i2 < i) {
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
            i2++;
        }
        return 1;
    }

    public static int z2(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = 4294967295L;
        long j2 = ((long) iArr2[0]) & 4294967295L;
        long j3 = ((long) iArr2[1]) & 4294967295L;
        long j4 = ((long) iArr2[2]) & 4294967295L;
        long j5 = ((long) iArr2[3]) & 4294967295L;
        long j6 = ((long) iArr2[4]) & 4294967295L;
        long j7 = ((long) iArr2[5]) & 4294967295L;
        long j8 = 0;
        while (i < 6) {
            long j9 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j10 = (j9 * j2) + (((long) iArr3[i2]) & j) + 0;
            iArr3[i2] = (int) j10;
            int i3 = i + 1;
            long j11 = (j9 * j3) + (((long) iArr3[i3]) & 4294967295L) + (j10 >>> 32);
            iArr3[i3] = (int) j11;
            int i4 = i + 2;
            long j12 = (j9 * j4) + (((long) iArr3[i4]) & 4294967295L) + (j11 >>> 32);
            iArr3[i4] = (int) j12;
            int i5 = i + 3;
            long j13 = (j9 * j5) + (((long) iArr3[i5]) & 4294967295L) + (j12 >>> 32);
            iArr3[i5] = (int) j13;
            int i6 = i + 4;
            long j14 = (j9 * j6) + (((long) iArr3[i6]) & 4294967295L) + (j13 >>> 32);
            iArr3[i6] = (int) j14;
            long j15 = j14 >>> 32;
            int i7 = i + 5;
            long j16 = (j9 * j7) + (((long) iArr3[i7]) & 4294967295L) + j15;
            iArr3[i7] = (int) j16;
            int i8 = i + 6;
            long j17 = (j16 >>> 32) + (((long) iArr3[i8]) & 4294967295L) + j8;
            iArr3[i8] = (int) j17;
            j8 = j17 >>> 32;
            i = i3;
            j = 4294967295L;
            j7 = j7;
            j2 = j2;
            j3 = j3;
        }
        return (int) j8;
    }
}
