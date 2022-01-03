package i0.h.a.a.i.s.i;

import android.database.sqlite.SQLiteDatabase;
import i0.h.a.a.i.s.i.z;
import java.util.List;
/* compiled from: SchemaManager.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class y implements z.a {
    public static final y a = new y();

    @Override // i0.h.a.a.i.s.i.z.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        List<z.a> list = z.c;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }
}
