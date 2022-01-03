package i0.j.e.l0.k.a.b.b;

import android.database.sqlite.SQLiteDatabase;
/* compiled from: Migration_12_14.java */
/* loaded from: classes2.dex */
public class c implements b {
    @Override // i0.j.e.l0.k.a.b.b.b
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE user ADD COLUMN last_seen INTEGER DEFAULT 0");
    }
}
