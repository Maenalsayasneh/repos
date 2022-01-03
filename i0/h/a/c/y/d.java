package i0.h.a.c.y;

import android.view.View;
import com.google.android.material.tabs.TabLayout;
/* compiled from: TabLayout.java */
/* loaded from: classes2.dex */
public class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ View c;
    public final /* synthetic */ TabLayout.i d;

    public d(TabLayout.i iVar, View view) {
        this.d = iVar;
        this.c = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.c.getVisibility() == 0) {
            this.d.g(this.c);
        }
    }
}
