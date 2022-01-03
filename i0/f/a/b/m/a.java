package i0.f.a.b.m;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: BufferRecycler.java */
/* loaded from: classes2.dex */
public class a {
    public static final int[] a = {8000, 8000, RecyclerView.MAX_SCROLL_DURATION, RecyclerView.MAX_SCROLL_DURATION};
    public static final int[] b = {4000, 4000, 200, 200};
    public final AtomicReferenceArray<byte[]> c = new AtomicReferenceArray<>(4);
    public final AtomicReferenceArray<char[]> d = new AtomicReferenceArray<>(4);

    public final byte[] a(int i) {
        int i2 = a[i];
        if (i2 <= 0) {
            i2 = 0;
        }
        byte[] andSet = this.c.getAndSet(i, null);
        return (andSet == null || andSet.length < i2) ? new byte[i2] : andSet;
    }

    public char[] b(int i, int i2) {
        int i3 = b[i];
        if (i2 < i3) {
            i2 = i3;
        }
        char[] andSet = this.d.getAndSet(i, null);
        return (andSet == null || andSet.length < i2) ? new char[i2] : andSet;
    }
}
