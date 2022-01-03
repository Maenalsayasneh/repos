package s0.a.a;

import java.util.Objects;
/* loaded from: classes4.dex */
public class f {
    public static final e[] a = new e[0];
    public e[] b;
    public int c;
    public boolean d;

    public f(int i) {
        if (i >= 0) {
            this.b = i == 0 ? a : new e[i];
            this.c = 0;
            this.d = false;
            return;
        }
        throw new IllegalArgumentException("'initialCapacity' must not be negative");
    }

    public static e[] b(e[] eVarArr) {
        return eVarArr.length < 1 ? a : (e[]) eVarArr.clone();
    }

    public void a(e eVar) {
        Objects.requireNonNull(eVar, "'element' cannot be null");
        e[] eVarArr = this.b;
        int length = eVarArr.length;
        boolean z = true;
        int i = this.c + 1;
        if (i <= length) {
            z = false;
        }
        if (this.d || z) {
            e[] eVarArr2 = new e[Math.max(eVarArr.length, (i >> 1) + i)];
            System.arraycopy(this.b, 0, eVarArr2, 0, this.c);
            this.b = eVarArr2;
            this.d = false;
        }
        this.b[this.c] = eVar;
        this.c = i;
    }

    public e c(int i) {
        if (i < this.c) {
            return this.b[i];
        }
        throw new ArrayIndexOutOfBoundsException(i + " >= " + this.c);
    }

    public e[] d() {
        int i = this.c;
        if (i == 0) {
            return a;
        }
        e[] eVarArr = this.b;
        if (eVarArr.length == i) {
            this.d = true;
            return eVarArr;
        }
        e[] eVarArr2 = new e[i];
        System.arraycopy(eVarArr, 0, eVarArr2, 0, i);
        return eVarArr2;
    }
}
