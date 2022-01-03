package h0.b.f;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.R;
import h0.b.e.f;
import h0.b.e.i.g;
import h0.b.e.i.l;
/* compiled from: PopupMenu.java */
/* loaded from: classes.dex */
public class m0 {
    public final Context a;
    public final g b;
    public final View c;
    public final l d;
    public a e;

    /* compiled from: PopupMenu.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public m0(Context context, View view) {
        int i = R.attr.popupMenuStyle;
        this.a = context;
        this.c = view;
        g gVar = new g(context);
        this.b = gVar;
        gVar.f = new k0(this);
        l lVar = new l(context, gVar, view, false, i, 0);
        this.d = lVar;
        lVar.g = 0;
        lVar.k = new l0(this);
    }

    public void a(int i) {
        new f(this.a).inflate(i, this.b);
    }
}
