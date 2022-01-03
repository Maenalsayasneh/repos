package i0.j.e.l0.k.a.b.b;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
/* compiled from: Migration_21_22.java */
/* loaded from: classes2.dex */
public class j implements b {
    @Override // i0.j.e.l0.k.a.b.b.b
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.CREATE_TABLE);
    }
}
