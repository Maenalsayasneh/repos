package i0.h.a.a.i.s.i;

import android.database.Cursor;
import i0.h.a.a.i.s.i.t;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class q implements t.b {
    public static final q a = new q();

    @Override // i0.h.a.a.i.s.i.t.b
    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
