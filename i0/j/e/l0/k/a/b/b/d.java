package i0.j.e.l0.k.a.b.b;

import android.database.sqlite.SQLiteDatabase;
/* compiled from: Migration_14_15.java */
/* loaded from: classes2.dex */
public class d implements b {
    @Override // i0.j.e.l0.k.a.b.b.b
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE user_attributes_table ADD COLUMN type INTEGER DEFAULT 0");
    }
}
