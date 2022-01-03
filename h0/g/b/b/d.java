package h0.g.b.b;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import h0.g.b.a.c;
import java.util.HashMap;
import java.util.HashSet;
/* compiled from: Key.java */
/* loaded from: classes.dex */
public abstract class d {
    public int a = -1;
    public int b = -1;
    public String c = null;
    public int d;
    public HashMap<String, ConstraintAttribute> e;

    public abstract void a(HashMap<String, c> hashMap);

    /* renamed from: b */
    public abstract d clone();

    public d c(d dVar) {
        this.a = dVar.a;
        this.b = dVar.b;
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = dVar.e;
        return this;
    }

    public abstract void d(HashSet<String> hashSet);

    public abstract void e(Context context, AttributeSet attributeSet);

    public void f(HashMap<String, Integer> hashMap) {
    }
}
