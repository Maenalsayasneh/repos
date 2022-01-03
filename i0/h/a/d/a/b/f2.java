package i0.h.a.d.a.b;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public final class f2 {
    public final int a;
    public final String b;
    public final long c;
    public final long d;
    public final int e;

    public f2() {
    }

    public f2(int i, @Nullable String str, long j, long j2, int i2) {
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f2) {
            f2 f2Var = (f2) obj;
            if (this.a == f2Var.a && ((str = this.b) != null ? str.equals(f2Var.b) : f2Var.b == null) && this.c == f2Var.c && this.d == f2Var.d && this.e == f2Var.e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.c;
        long j2 = this.d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.e;
    }

    public String toString() {
        int i = this.a;
        String str = this.b;
        long j = this.c;
        long j2 = this.d;
        int i2 = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
