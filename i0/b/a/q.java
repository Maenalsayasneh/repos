package i0.b.a;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: EpoxyDiffLogger.java */
/* loaded from: classes.dex */
public class q extends RecyclerView.h {
    public final String a;

    public q(String str) {
        this.a = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void b(int i, int i2) {
        String str = this.a;
        Log.d(str, "Item range changed. Start: " + i + " Count: " + i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void c(int i, int i2, Object obj) {
        if (obj == null) {
            b(i, i2);
            return;
        }
        String str = this.a;
        Log.d(str, "Item range changed with payloads. Start: " + i + " Count: " + i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void d(int i, int i2) {
        String str = this.a;
        Log.d(str, "Item range inserted. Start: " + i + " Count: " + i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void e(int i, int i2, int i3) {
        String str = this.a;
        Log.d(str, "Item moved. From: " + i + " To: " + i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void f(int i, int i2) {
        String str = this.a;
        Log.d(str, "Item range removed. Start: " + i + " Count: " + i2);
    }
}
