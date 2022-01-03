package i0.e.b.f3;
/* compiled from: CountFormatter.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final String a(int i) {
        if (i <= 1000) {
            return String.valueOf(i);
        }
        int i2 = i / 1000000;
        int i3 = (i / 100000) % 10;
        int i4 = i / 1000;
        int i5 = (i / 100) % 10;
        if (i2 > 0) {
            if (i3 > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append('.');
                sb.append(i3);
                sb.append('M');
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            sb2.append('M');
            return sb2.toString();
        } else if (i3 > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i4);
            sb3.append('k');
            return sb3.toString();
        } else if (i5 > 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i4);
            sb4.append('.');
            sb4.append(i5);
            sb4.append('k');
            return sb4.toString();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i4);
            sb5.append('k');
            return sb5.toString();
        }
    }
}
