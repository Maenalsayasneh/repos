package i0.h.d.a.a.a;

import androidx.recyclerview.widget.RecyclerView;
/* compiled from: UnicodeEscaper.java */
/* loaded from: classes2.dex */
public abstract class b {
    public static final ThreadLocal<char[]> a = new a();

    /* compiled from: UnicodeEscaper.java */
    /* loaded from: classes2.dex */
    public class a extends ThreadLocal<char[]> {
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE];
        }
    }
}
