package i0.h.a.a.i.s.i;

import android.database.sqlite.SQLiteDatabase;
import i0.h.a.a.i.s.i.z;
import java.util.List;
/* compiled from: SchemaManager.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class w implements z.a {
    public static final w a = new w();

    @Override // i0.h.a.a.i.s.i.z.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        List<z.a> list = z.c;
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }
}
