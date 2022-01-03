package h0.j.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class c extends a {
    public int b2;
    public int c2;
    public LayoutInflater d2;

    @Deprecated
    public c(Context context, int i, Cursor cursor, boolean z) {
        super(context, null, z);
        this.c2 = i;
        this.b2 = i;
        this.d2 = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // h0.j.a.a
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.d2.inflate(this.b2, viewGroup, false);
    }
}
