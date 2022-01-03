package com.fasterxml.jackson.core;

import com.instabug.library.model.StepType;
import com.pubnub.api.vendor.FileEncryptionUtil;
import i0.d.a.a.a;
import java.io.Serializable;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public class JsonLocation implements Serializable {
    public static final JsonLocation c = new JsonLocation(null, -1, -1, -1, -1);
    public final transient Object Y1;
    public final long d;
    public final long q;
    public final int x;
    public final int y;

    public JsonLocation(Object obj, long j, int i, int i2) {
        this.Y1 = obj;
        this.d = -1;
        this.q = j;
        this.x = i;
        this.y = i2;
    }

    public final int a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return str.length();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        Object obj2 = this.Y1;
        if (obj2 == null) {
            if (jsonLocation.Y1 != null) {
                return false;
            }
        } else if (!obj2.equals(jsonLocation.Y1)) {
            return false;
        }
        return this.x == jsonLocation.x && this.y == jsonLocation.y && this.q == jsonLocation.q && this.d == jsonLocation.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Object obj = this.Y1;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this.x) + this.y) ^ ((int) this.q)) + ((int) this.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump */
    public String toString() {
        Class<?> cls;
        int i;
        int i2;
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        Object obj = this.Y1;
        if (obj == null) {
            sb.append(StepType.UNKNOWN);
        } else {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            String name = cls.getName();
            if (name.startsWith("java.")) {
                name = cls.getSimpleName();
            } else if (obj instanceof byte[]) {
                name = "byte[]";
            } else if (obj instanceof char[]) {
                name = "char[]";
            }
            sb.append('(');
            sb.append(name);
            sb.append(')');
            int i3 = 0;
            String str = " chars";
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                i = charSequence.length();
                i2 = a(sb, charSequence.subSequence(0, Math.min(i, 500)).toString());
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                i = cArr.length;
                String str2 = new String(cArr, 0, Math.min(i, 500));
                sb.append('\"');
                sb.append(str2);
                sb.append('\"');
                i2 = str2.length();
            } else {
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    int min = Math.min(bArr.length, 500);
                    String str3 = new String(bArr, 0, min, Charset.forName(FileEncryptionUtil.ENCODING_UTF_8));
                    sb.append('\"');
                    sb.append(str3);
                    sb.append('\"');
                    str3.length();
                    i3 = bArr.length - min;
                    str = " bytes";
                }
                if (i3 > 0) {
                    sb.append("[truncated ");
                    sb.append(i3);
                    sb.append(str);
                    sb.append(']');
                }
            }
            i3 = i - i2;
            if (i3 > 0) {
            }
        }
        sb.append("; line: ");
        sb.append(this.x);
        sb.append(", column: ");
        return a.s0(sb, this.y, ']');
    }

    public JsonLocation(Object obj, long j, long j2, int i, int i2) {
        this.Y1 = obj;
        this.d = j;
        this.q = j2;
        this.x = i;
        this.y = i2;
    }
}
