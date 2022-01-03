package s0.a.e.b;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public class q {
    public final BigInteger a;
    public final int b;

    public q(BigInteger bigInteger, int i) {
        if (i >= 0) {
            this.a = bigInteger;
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public q a(q qVar) {
        if (this.b == qVar.b) {
            return new q(this.a.add(qVar.a), this.b);
        }
        throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
    }

    public int b(BigInteger bigInteger) {
        return this.a.compareTo(bigInteger.shiftLeft(this.b));
    }

    public BigInteger c() {
        BigInteger bigInteger = c.b;
        q qVar = new q(bigInteger, 1);
        int i = this.b;
        if (i >= 0) {
            if (i != 1) {
                qVar = new q(bigInteger.shiftLeft(i - 1), i);
            }
            q a = a(qVar);
            return a.a.shiftRight(a.b);
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public q d(q qVar) {
        BigInteger negate = qVar.a.negate();
        int i = qVar.b;
        if (i < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        } else if (this.b == i) {
            return new q(this.a.add(negate), this.b);
        } else {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a.equals(qVar.a) && this.b == qVar.b;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b;
    }

    public String toString() {
        int i = this.b;
        if (i == 0) {
            return this.a.toString();
        }
        BigInteger shiftRight = this.a.shiftRight(i);
        BigInteger subtract = this.a.subtract(shiftRight.shiftLeft(this.b));
        if (this.a.signum() == -1) {
            subtract = c.b.shiftLeft(this.b).subtract(subtract);
        }
        if (shiftRight.signum() == -1 && !subtract.equals(c.a)) {
            shiftRight = shiftRight.add(c.b);
        }
        String bigInteger = shiftRight.toString();
        char[] cArr = new char[this.b];
        String bigInteger2 = subtract.toString(2);
        int length = bigInteger2.length();
        int i2 = this.b - length;
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = '0';
        }
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i2 + i4] = bigInteger2.charAt(i4);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(bigInteger);
        stringBuffer.append(".");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
